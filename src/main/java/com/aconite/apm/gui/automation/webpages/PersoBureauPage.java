package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.PersoBureauDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PersoBureauPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public PersoBureauPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanPersoBureauTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPersoBureauDetailCreate()));

        orAdmin.btnPersoBureauDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPersoBureauDetailCancel()));

        orAdmin.btnPersoBureauDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        switch (field) {

            case("name"):
                if (!orAdmin.txtPersoBureauDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("code"):
                if (!orAdmin.txtPersoBureauDetailCode().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("destinationDirectory"):
                if (!orAdmin.txtPersoBureauDetailDestinationDirectory().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("encryptionZone"):
                if (!orAdmin.selPersoBureauDetailPinEncryptionZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }

    public PersoBureauDataRecord enterPersoBureauData(PersoBureauDataRecord newPersoBureau){

        PersoBureauDataRecord newRecord;
        newRecord = newPersoBureau;
        WebDriverWait myWait = new WebDriverWait(webDriver, 30);

        orAdmin.btnAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPersoBureauDetailCancel()));

        orAdmin.txtPersoBureauDetailName().sendKeys(newPersoBureau.getName());
        orAdmin.txtPersoBureauDetailCode().sendKeys(newPersoBureau.getCode());
        orAdmin.txtPersoBureauDetailDestinationDirectory().sendKeys(newPersoBureau.getDestinationDirectory());
        adminCommon.setListValue(orAdmin.selPersoBureauDetailPinEncryptionZone(),newPersoBureau.getEncryptionZone());

        orAdmin.btnPersoBureauDetailCreate().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("Successfully added")) {
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblPersoBureauList()));

            adminCommon.findObjectByColumn(orAdmin.tblPersoBureauList(),"Name", newPersoBureau.getName());
            newRecord.setId(adminCommon.getIdByColumn(orAdmin.tblPersoBureauList(),"Name",newPersoBureau.getName()));
        }
        else{
            newRecord = null;
        }

        return newRecord;
    }

    public PersoBureauDataRecord getTableDataById(PersoBureauDataRecord newPersoBureau){

        PersoBureauDataRecord record = new PersoBureauDataRecord();

        //need to find the object in the table
        adminCommon.findObjectByColumn(orAdmin.tblPersoBureauList(), "Name", newPersoBureau.getName());

        List<WebElement> rows = orAdmin.tblPersoBureauList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));

        if (rows.size() == 0){
            record.setId(null);
            record.setName(null);
            record.setCode(null);
            record.setDestinationDirectory(null);
            record.setEncryptionZone(null);
            record.setExtractPan(null);
            record.setExtractPanDisplay(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId')]"));
                if (newPersoBureau.getId().equals(cellId.getText())) {
                    record.setId(cellId.getText());
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGName')]")).getText());
                    record.setCode(row.findElement(By.xpath(".//td[contains(@class, 'idGCode')]")).getText());
                    record.setDestinationDirectory(row.findElement(By.xpath(".//td[contains(@class, 'idGDestinationDirectory')]")).getText());
                    record.setEncryptionZone(row.findElement(By.xpath(".//td[contains(@class, 'idGEncryptionZone')]")).getText());
                    record.setExtractPan(row.findElement(By.xpath(".//td[contains(@class, 'idGExtractPan   ')]")).getText());
                    record.setExtractPanDisplay(row.findElement(By.xpath(".//td[contains(@class, 'idGExtractPanDisplay')]")).getText());

                    found = true;
                    break;
                }
            }

            if(!found){
                record.setId(null);
                record.setName(null);
                record.setCode(null);
                record.setDestinationDirectory(null);
                record.setEncryptionZone(null);
                record.setExtractPan(null);
                record.setExtractPanDisplay(null);
            }
        }

        return(record);

    }

    public PersoBureauDataRecord getDBDataById(String instId){

        PersoBureauDataRecord record = new PersoBureauDataRecord();

        try {
            String getIssByIdSQL = "SELECT IDPB.ID, IDPB.NAME, IDPB.BUREAU_CODE, IDPB.DESTINATION_DIRECTORY, " +
                    "EDEZ.NAME, IDPB.EXTRACT_PAN_FLAG, IDPB.EXTRACT_PAN_DISPLAY_FLAG " +
                    "FROM INT_D_PERSO_BUREAU IDPB " +
                    "LEFT JOIN ENC_D_ENCRYPTION_ZONE EDEZ ON IDPB.APM_BUREAU_ENC_ZONE_ID=EDEZ.ID " +
                    "WHERE IDPB.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()) {
                record.setId(null);
                record.setName(null);
                record.setCode(null);
                record.setDestinationDirectory(null);
                record.setEncryptionZone(null);
                record.setExtractPan(null);
                record.setExtractPanDisplay(null);

            }
            else{
                rs.next();
                record.setId(instId);
                record.setName(rs.getString(2));
                record.setCode(rs.getString(3));
                record.setDestinationDirectory(rs.getString(4));
                record.setEncryptionZone(rs.getString(5));
                record.setExtractPan(rs.getString(6));
                record.setExtractPanDisplay(rs.getString(7));

            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public boolean editPersoBureauData(PersoBureauDataRecord editPersoBureau, String editField){

        adminCommon.sleep(500);


        if(adminCommon.clickEditByColumn(orAdmin.tblPersoBureauList(), "ID", editPersoBureau.getId())) {

            // Edit the field required
            switch (editField) {

                case ("extractPAN"):
                    adminCommon.selectCheckbox(orAdmin.cbxPersoBureauDetailExtractPan(), editPersoBureau.getExtractPan());
                    break;

                case ("extractPANDisplay"):
                    adminCommon.selectCheckbox(orAdmin.cbxPersoBureauDetailExtractPanDisplay(), editPersoBureau.getExtractPanDisplay());
                    break;

            }

            // Click the Save button
            orAdmin.btnPersoBureauDetailSave().click();

            return(adminCommon.clickBtnOk());

        }

        return false;

    }

    public boolean clickDeletePersoBureauById(PersoBureauDataRecord delPersoBureau){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

        adminCommon.findObjectByColumn(orAdmin.tblPersoBureauList(), "Name", delPersoBureau.getName());

        adminCommon.sleep(500);
        adminCommon.clickDeleteById(orAdmin.tblPersoBureauList(), delPersoBureau.getId());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }

        return true;
    }



}
