package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.InterfaceDataRecord;
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

public class InterfacePage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public InterfacePage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanInterfaceTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInterfaceDetailCreate()));

        orAdmin.btnInterfaceDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInterfaceDetailCancel()));

        orAdmin.btnInterfaceDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        switch (field) {

            case("name"):
                if (!orAdmin.txtInterfaceDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("type"):
                if (!orAdmin.selInterfaceDetailType().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("institution"):
                if (!orAdmin.selInterfaceDetailInstitution().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("encryptionZone"):
                if (!orAdmin.selInterfaceDetailEncryptionZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("host"):
                if (!orAdmin.txtInterfaceDetailHost().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("port"):
                if (!orAdmin.txtInterfaceDetailPort().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("timeout"):
                if (!orAdmin.txtInterfaceDetailTimeout().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;
        }

        return rc;

    }

    public InterfaceDataRecord enterInterfaceData(InterfaceDataRecord newInterface){

        InterfaceDataRecord newRecord;
        newRecord = newInterface;
        WebDriverWait myWait = new WebDriverWait(webDriver, 30);

        orAdmin.btnAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnInterfaceDetailCancel()));

        orAdmin.txtInterfaceDetailName().sendKeys(newInterface.getName());
        adminCommon.setListValue(orAdmin.selInterfaceDetailType(),newInterface.getType());
        adminCommon.setListValue(orAdmin.selInterfaceDetailInstitution(),newInterface.getInstitution());
        adminCommon.setListValue(orAdmin.selInterfaceDetailEncryptionZone(),newInterface.getEncryptionZone());
        orAdmin.txtInterfaceDetailHost().sendKeys(newInterface.getHost());
        orAdmin.txtInterfaceDetailPort().sendKeys(newInterface.getPort());
        orAdmin.txtInterfaceDetailTimeout().sendKeys(newInterface.getTimeout());
        adminCommon.selectCheckbox(orAdmin.cbxInterfaceDetailSSL(),newInterface.getSsl());
        orAdmin.txtInterfaceDetailUsername().sendKeys(newInterface.getUsername());

        orAdmin.btnInterfaceDetailCreate().click();
//        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));
//
//        String output = orAdmin.txtMsg().getText();
//
//        if(output.contains("Successfully added")) {
//            orAdmin.btnOK().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblInterfaceList()));

        adminCommon.findObjectByColumn(orAdmin.tblInterfaceList(),"Name", newInterface.getName());
        newRecord.setId(adminCommon.getIdByColumn(orAdmin.tblInterfaceList(),"Name",newInterface.getName()));
//        }
//        else{
//            newRecord = null;
//        }

        return newRecord;
    }

    public InterfaceDataRecord getTableDataById(InterfaceDataRecord newInterface){

        InterfaceDataRecord record = new InterfaceDataRecord();

        //need to find the object in the table
        adminCommon.findObjectByColumn(orAdmin.tblInterfaceList(), "Name", newInterface.getName());

        List<WebElement> rows = orAdmin.tblInterfaceList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));

        if (rows.size() == 0){
            record.setId(null);
            record.setName(null);
            record.setType(null);
            record.setInstitution(null);
            record.setEncryptionZone(null);
            record.setHost(null);
            record.setPort(null);
            record.setTimeout(null);
            record.setSsl(null);
            record.setKeystorePath(null);
            record.setCertificateAlias(null);
            record.setContext(null);
            record.setUsername(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId')]"));
                if (newInterface.getId().equals(cellId.getText())) {
                    record.setId(cellId.getText());
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGName')]")).getText());
                    record.setType(row.findElement(By.xpath(".//td[contains(@class, 'idGInterfaceType')]")).getText());
                    record.setInstitution(row.findElement(By.xpath(".//td[contains(@class, 'idGInstitution')]")).getText());
                    record.setEncryptionZone(row.findElement(By.xpath(".//td[contains(@class, 'idGEncryptionZone')]")).getText());
                    record.setHost(row.findElement(By.xpath(".//td[contains(@class, 'idGIpAddress')]")).getText());
                    record.setPort(row.findElement(By.xpath(".//td[contains(@class, 'idGPort')]")).getText());
                    record.setTimeout(row.findElement(By.xpath(".//td[contains(@class, 'idGTimeout')]")).getText());
                    record.setSsl(row.findElement(By.xpath(".//td[contains(@class, 'idGSSL')]")).getText());
                    record.setKeystorePath(row.findElement(By.xpath(".//td[contains(@class, 'idGKeystorePath')]")).getText());
                    record.setCertificateAlias(row.findElement(By.xpath(".//td[contains(@class, 'idGCertificateAlias')]")).getText());
                    record.setContext(row.findElement(By.xpath(".//td[contains(@class, 'idGExportContext')]")).getText());
                    record.setUsername(row.findElement(By.xpath(".//td[contains(@class, 'idGReturnInterfaceUser')]")).getText());

                    found = true;
                    break;
                }
            }

            if(!found){
                record.setId(null);
                record.setName(null);
                record.setType(null);
                record.setInstitution(null);
                record.setEncryptionZone(null);
                record.setHost(null);
                record.setPort(null);
                record.setTimeout(null);
                record.setSsl(null);
                record.setKeystorePath(null);
                record.setCertificateAlias(null);
                record.setContext(null);
                record.setUsername(null);
            }
        }

        return(record);

    }

    public InterfaceDataRecord getDBDataById(String instId){

        InterfaceDataRecord record = new InterfaceDataRecord();

        try {
            String getIssByIdSQL = "SELECT CDI.ID, CDI.NAME, ISIT.NAME, CDINST.NAME, EDEZ.NAME, CDI.HOST, CDI.PORT, " +
                    "CDI.TIMEOUT, CDI.SSL_FLAG, CDI.KEYSTORE_PATH, CDI.CERTIFICATE_ALIAS, " +
                    "CDI.CONTEXT, CDI.USERNAME " +
                    "FROM C_D_INTERFACE CDI " +
                    "LEFT JOIN INT_S_INTERFACE_TYPE ISIT ON CDI.TYPE_ID=ISIT.ID " +
                    "LEFT JOIN C_D_INSTITUTION CDINST ON CDI.INSTITUTION_ID=CDINST.ID " +
                    "LEFT JOIN ENC_D_ENCRYPTION_ZONE EDEZ ON CDI.INTERFACE_ENC_ZONE_ID=EDEZ.ID " +
                    "WHERE CDI.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()) {
                record.setId(null);
                record.setName(null);
                record.setType(null);
                record.setInstitution(null);
                record.setEncryptionZone(null);
                record.setHost(null);
                record.setPort(null);
                record.setTimeout(null);
                record.setSsl(null);
                record.setKeystorePath(null);
                record.setCertificateAlias(null);
                record.setContext(null);
                record.setUsername(null);

            }
            else{

                rs.next();
                record.setId(instId);
                record.setName(rs.getString(2));
                record.setType(rs.getString(3));
                record.setInstitution(rs.getString(4));
                record.setEncryptionZone(rs.getString(5));
                record.setHost(rs.getString(6));
                record.setPort(rs.getString(7));
                record.setTimeout(rs.getString(8));
                record.setSsl(rs.getString(9));
                record.setKeystorePath(rs.getString(10));
                record.setCertificateAlias(rs.getString(11));
                record.setContext(rs.getString(12));
                record.setUsername(rs.getString(13));

            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public boolean editInterfaceData(InterfaceDataRecord editInterface, String editField){

        adminCommon.sleep(500);


        if(adminCommon.clickEditByColumn(orAdmin.tblInterfaceList(), "ID", editInterface.getId())) {

            // Edit the field required
            switch (editField) {

                case ("keystorePath"):
                    orAdmin.txtInterfaceDetailKeystorePath().clear();
                    orAdmin.txtInterfaceDetailKeystorePath().sendKeys(editInterface.getKeystorePath());
                    break;

               case ("certificateAlias"):
                    orAdmin.txtInterfaceDetailCertificateAlias().clear();
                    orAdmin.txtInterfaceDetailCertificateAlias().sendKeys(editInterface.getCertificateAlias());
                    break;

               case ("context"):
                    orAdmin.txtInterfaceDetailContext().clear();
                    orAdmin.txtInterfaceDetailContext().sendKeys(editInterface.getContext());
                    break;

            }

            // Click the Save button
            orAdmin.btnInterfaceDetailSave().click();

//            return(adminCommon.clickBtnOk());
            return true;

        }

        return false;

    }

    public boolean clickDeleteInterfaceById(InterfaceDataRecord delInterface){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

        //changed as ID gives "Element not interactable" error
        adminCommon.findObjectByColumn(orAdmin.tblInterfaceList(), "Name", delInterface.getName());

        adminCommon.sleep(500);
        adminCommon.clickDeleteById(orAdmin.tblInterfaceList(), delInterface.getId());

        // Click Yes
//        String out =
        adminCommon.clickBtnYes();
//        if (!out.equals("false")){
//            // Click OK
//            if(!adminCommon.clickBtnOk()){
//                return false;
//            }
//        }

        return true;
    }



}
