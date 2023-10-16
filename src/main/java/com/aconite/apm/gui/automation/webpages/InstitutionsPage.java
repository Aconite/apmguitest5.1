package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.InstitutionDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstitutionsPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;


    public InstitutionsPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }


    /********************************
     * Main Page Functions
     ********************************/

    public boolean isPageOpened() {
        return orAdmin.spanInstitutionsTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInstitutionDetailCreate()));

        orAdmin.btnInstitutionDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInstitutionDetailCancel()));

        orAdmin.btnInstitutionDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On Institution Page - Institution Detail window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtInstitutionDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("LocalZone"):
                if (!orAdmin.selInstitutionDetailLocalZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("InstitutionZone"):
                if (!orAdmin.selInstitutionDetailInstitutionZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("InterfaceZone"):
                if (!orAdmin.selInstitutionDetailInterfaceZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("MaxVppPinIdSeconds"):
                if (!orAdmin.txtInstitutionDetailMaxVppPinIdSeconds().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }



        return rc;

    }

    public InstitutionDataRecord enterInstitutionData(InstitutionDataRecord newInst){

        InstitutionDataRecord newRecord;

        // Click Add button
        orAdmin.btnAdd().click();
        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInstitutionDetailCancel()));

        orAdmin.txtInstitutionDetailName().sendKeys(newInst.getInstitutionName());
        adminCommon.setListValue(orAdmin.selInstitutionDetailLocalZone(), newInst.getLocalZone());
        adminCommon.setListValue(orAdmin.selInstitutionDetailInstitutionZone(), newInst.getInstitutionZone());
        adminCommon.setListValue(orAdmin.selInstitutionDetailInterfaceZone(), newInst.getInterfaceZone());
        orAdmin.txtInstitutionDetailMaxVppPinIdSeconds().sendKeys(newInst.getMaxVppPinIdSeconds());

        orAdmin.btnInstitutionDetailCreate().click();

        // Deal with the confirmation pop up
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("successfully added")){
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblInstitutionList()));

            // get the row data by institution name and get the id to return
            newRecord = getInstitutionListRecordByName(newInst);
        }
        else{
            newRecord=null;
        }

        return(newRecord);

    }

    public boolean editInstitutionData(InstitutionDataRecord recordEditInst, String instField){

        adminCommon.sleep(500);
        adminCommon.clickEditById(orAdmin.tblInstitutionList(),recordEditInst.getId());

        // Edit the field required
        switch(instField){

            case("Name"):
                orAdmin.txtInstitutionDetailName().clear();
                orAdmin.txtInstitutionDetailName().sendKeys(recordEditInst.getInstitutionName());
                break;

            case("LocalZone"):
                adminCommon.setListValue(orAdmin.selInstitutionDetailLocalZone(), recordEditInst.getLocalZone());
                break;

            case("InstitutionZone"):
                adminCommon.setListValue(orAdmin.selInstitutionDetailInstitutionZone(), recordEditInst.getInstitutionZone());
                break;

            case("InterfaceZone"):
                adminCommon.setListValue(orAdmin.selInstitutionDetailInterfaceZone(), recordEditInst.getInterfaceZone());
                break;

            case("MaxVppPinIdSeconds"):
                orAdmin.txtInstitutionDetailMaxVppPinIdSeconds().clear();
                orAdmin.txtInstitutionDetailMaxVppPinIdSeconds().sendKeys(recordEditInst.getMaxVppPinIdSeconds());
                break;

        }

        
        // Click the Save button
        orAdmin.btnInstitutionDetailSave().click();

        return(adminCommon.clickBtnOk());

    }

    public void clickEditInstitutionById(String id){

        int rowCount = adminCommon.getDataRowCount();

        for(int i = 1; i <= rowCount; i++){
            WebElement cell = orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]"));
            if(cell.getAttribute("textContent").equals(id)){
                // press the id key
                int j = i+1;
                WebElement btnEdit =  orAdmin.tblInstitutionList().findElement(By.xpath("//tr[" + j + "]//img[contains(@src, \"edit.png\")]"));
                btnEdit.click();
            }
        }


    }

    public boolean clickDeleteInstitutionById(InstitutionDataRecord delInstitution){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);

        // Click delete
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblInstitutionList()));
        adminCommon.sleep(500);
        adminCommon.clickDeleteById(orAdmin.tblInstitutionList(), delInstitution.getId());

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

    public InstitutionDataRecord getInstitutionListRecordByName(InstitutionDataRecord instName){

        List<WebElement> rows = orAdmin.tblInstitutionList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            instName.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (instName.getInstitutionName().equals(cellName.getText())) {
                    instName.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                instName.setId(null);
            }
        }

        return(instName);

//        InstitutionDataRecord record = new InstitutionDataRecord();
//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            String thisName = orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"Name\")])[" + i + "]")).getAttribute("textContent");
//            if (thisName.equals(instName)){
//                    record.setId(orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]")).getAttribute("textContent"));
//                    record.setInstitutionName(thisName);
//                    record.setLocalZone(orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGLocalZone\")])[" + i + "]")).getAttribute("textContent"));
//                    record.setInstitutionZone(orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGInstZone\")])[" + i + "]")).getAttribute("textContent"));
//                    record.setInterfaceZone(orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGInterfaceZone\")])[" + i + "]")).getAttribute("textContent"));
//                    record.setMaxVppPinIdSeconds(orAdmin.tblInstitutionList().findElement(By.xpath("(//td[contains(@class, \"idGMaxVPPPinId\")])[" + i + "]")).getAttribute("textContent"));
//                    break;
//                }
//        }
//
//        return(record);

    }

    public InstitutionDataRecord getTableDataById(InstitutionDataRecord institution){

        InstitutionDataRecord record = new InstitutionDataRecord();

        List<WebElement> rows = orAdmin.tblInstitutionList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
                if (institution.getId().equals(cellId.getText())) {
                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    record.setInstitutionName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getText());
                    record.setLocalZone(row.findElement(By.xpath(".//td[contains(@class, 'idGLocalZone')]")).getText());
                    record.setInstitutionZone(row.findElement(By.xpath(".//td[contains(@class, 'idGInstZone')]")).getText());
                    record.setInterfaceZone(row.findElement(By.xpath(".//td[contains(@class, 'idGInterfaceZone')]")).getText());
                    record.setMaxVppPinIdSeconds(row.findElement(By.xpath(".//td[contains(@class, 'idGMaxVPPPinId')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                record.setId(null);
            }
        }

        return(record);
    }

    public InstitutionDataRecord getDBDataById(String instId) throws Exception{

        InstitutionDataRecord record = new InstitutionDataRecord();

        try {

            String getInstByIdSQL = "SELECT CDI.ID, CDI.NAME, EDEZ1.NAME, " +
                    "EDEZ2.NAME, EDEZ3.NAME, CDI.MAX_VPPPINID_LIFETIME " +
                    "FROM C_D_INSTITUTION CDI " +
                    "LEFT JOIN  ENC_D_ENCRYPTION_ZONE EDEZ1 ON CDI.APM_LOCAL_ENC_ZONE_ID = EDEZ1.ID " +
                    "LEFT JOIN  ENC_D_ENCRYPTION_ZONE EDEZ2 ON CDI.APM_INSTITUTION_ENC_ZONE_ID = EDEZ2.ID " +
                    "LEFT JOIN  ENC_D_ENCRYPTION_ZONE EDEZ3 ON CDI.APM_IF_ENC_ZONE_ID = EDEZ3.ID " +
                    "WHERE CDI.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getInstByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setInstitutionName(null);
                record.setLocalZone(null);
                record.setInstitutionZone(null);
                record.setInterfaceZone(null);
                record.setMaxVppPinIdSeconds(null);
            }
            else{

            rs.next();

            record.setId(rs.getString(1));
            record.setInstitutionName(rs.getString(2));
            record.setLocalZone(rs.getString(3));
            record.setInstitutionZone(rs.getString(4));
            record.setInterfaceZone(rs.getString(5));
            record.setMaxVppPinIdSeconds(rs.getString(6));

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

}
