package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.MessageTemplateDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class MessageTemplatesPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public MessageTemplatesPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);

    }

    public boolean isPageOpened() {
        return orAdmin.spanMessageTemplateSearchHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnMessageDetailCreate()));

        orAdmin.btnMessageDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnMessageDetailCancel()));

        orAdmin.btnMessageDetailCancel().click();

    }

    public boolean clickDeleteMessageTemplateById(MessageTemplateDataRecord delMessageTemplate){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);

        // Search page
        adminCommon.searchInstitution(delMessageTemplate.getParentInstitution());

        // Click delete
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblMessageTemplateList()));
        adminCommon.clickDeleteById(orAdmin.tblMessageTemplateList(), delMessageTemplate.getId());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }

        return true;


//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            WebElement cell = orAdmin.tblMessageTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]"));
//            if(cell.getAttribute("textContent").equals(delMessageTemplate.getId())){
//                String delName = orAdmin.tblMessageTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGName\")])[" + i + "]")).getAttribute("textContent");
//                int j = i+1;
//                WebElement btnDelete =  orAdmin.tblMessageTemplateList().findElement(By.xpath("//tr[" + j + "]//img[contains(@src, \"delete.gif\")]"));
//                btnDelete.click();
//
//                mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnYes()));
//                String output = orAdmin.txtMsg().getText();
//
//                if(output.contains(delName)){
//                    orAdmin.btnYes().click();
//                    mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));
//
//                    orAdmin.btnOK().click();
//                    mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
//                    break;
//
//                }
//                else{
//                    System.out.println("THERE'S NO MESSAGE");
//                }
//            }
//        }


    }

    public MessageTemplateDataRecord getTableDataById(MessageTemplateDataRecord messageTemplate){

        MessageTemplateDataRecord record = new MessageTemplateDataRecord();

        List<WebElement> rows = orAdmin.tblMessageTemplateList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
                if (messageTemplate.getId().equals(cellId.getText())) {
                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getText());
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

    public MessageTemplateDataRecord getDBDataById(String instId) throws Exception{

        MessageTemplateDataRecord record = new MessageTemplateDataRecord();

        try {

            String getIssByIdSQL = "SELECT CDMT.ID, CDMT.NAME, INST.NAME, CDMT.HAS_PAN, CDMT.HAS_PSN, CDMT.HAS_EXPIRY, " +
                    "CDMT.HAS_PAN_ALIAS, CDMT.HAS_PAN_ID, CDMT.HAS_PIN_PUK_FLAG, " +
                    "CDMT.HAS_PIN_BLOCK, CDMT.HAS_PUK_BLOCK, CDMT.HAS_PIN_PVV, " +
                    "CDMT.HAS_PUK_PVV, CDMT.HAS_CUSTOMER_CODE, CDMT.HAS_OPERATION, " +
                    "CDMT.HAS_TOKEN_PRODUCT_NAME, CDMT.HAS_APP_SEQ_NUM, CDMT.FIXED_DATA " +
                    "FROM C_D_MESSAGE_TEMPLATE CDMT " +
                    "LEFT JOIN  C_D_INSTITUTION INST ON CDMT.INSTITUTION_ID = INST.ID " +
                    "WHERE CDMT.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setName(null);
                record.setInstitutionName(null);
                record.setPan(null);
                record.setPanSequence(null);
                record.setExpiryDate(null);
                record.setPanAlias(null);
                record.setPanId(null);
                record.setPinPukFlag(null);
                record.setPinBlock(null);
                record.setPukBlock(null);
                record.setPinVerificationValue(null);
                record.setPukVerificationValue(null);
                record.setCustomerCode(null);
                record.setOperation(null);
                record.setTokenProductName(null);
                record.setAppSequenceNumber(null);
                record.setFixedData(null);
            }
            else{

                rs.next();

                record.setId(rs.getString(1));
                record.setName(rs.getString(2));
                record.setInstitutionName(rs.getString(3));
                record.setPan(rs.getString(4));
                record.setPanSequence(rs.getString(5));
                record.setExpiryDate(rs.getString(6));
                record.setPanAlias(rs.getString(7));
                record.setPanId(rs.getString(8));
                record.setPinPukFlag(rs.getString(9));
                record.setPinBlock(rs.getString(10));
                record.setPukBlock(rs.getString(11));
                record.setPinVerificationValue(rs.getString(12));
                record.setPukVerificationValue(rs.getString(13));
                record.setCustomerCode(rs.getString(14));
                record.setOperation(rs.getString(15));
                record.setTokenProductName(rs.getString(16));
                record.setAppSequenceNumber(rs.getString(17));
                record.setFixedData(rs.getString(18));
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public MessageTemplateDataRecord getMessageTemplateListRecordByName(MessageTemplateDataRecord editMessageTemplate){

        List<WebElement> rows = orAdmin.tblMessageTemplateList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            editMessageTemplate.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (editMessageTemplate.getName().equals(cellName.getText())) {
                    editMessageTemplate.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                editMessageTemplate.setId(null);
            }
        }

        return(editMessageTemplate);

//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            String thisName = orAdmin.tblMessageTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGName\")])[" + i + "]")).getAttribute("textContent");
//            if (thisName.equals(editMessageTemplate.getName())){
//                editMessageTemplate.setId(orAdmin.tblMessageTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]")).getAttribute("textContent"));
//                break;
//            }
//        }
//
//        return(editMessageTemplate);
    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On Message Template Page - Message Template Window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtMessageDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("InstitutionName"):
                if (!orAdmin.selMessageDetailInstitution().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }

    public MessageTemplateDataRecord enterMessageTemplateData(MessageTemplateDataRecord newMessageTemplate) {

        // Click Reset button
        orAdmin.btnReset().click();

        adminCommon.searchInstitution(newMessageTemplate.getParentInstitution());

        // Click Add button
        orAdmin.btnAdd().click();
        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnMessageDetailCancel()));

        // Enter required field data
        orAdmin.txtMessageDetailName().sendKeys(newMessageTemplate.getName());
        adminCommon.setListValue(orAdmin.selMessageDetailInstitution(), newMessageTemplate.getInstitutionName());

        orAdmin.btnMessageDetailCreate().click();

        // Deal with the confirmation pop up
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("Successfully Added")) {
            orAdmin.btnOK().click();
            mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblMessageTemplateList()));

            // get the row data by issuer name and get the id to return
            newMessageTemplate = getMessageTemplateListRecordByName(newMessageTemplate);

        }
        else{
            newMessageTemplate = null;
        }

        return(newMessageTemplate);

    }

    public boolean editMessageTemplateData(MessageTemplateDataRecord editMessageTemplate, String instField){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitution(editMessageTemplate.getParentInstitution());
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblMessageTemplateList()));

        // Find and click the Edit button by the row's ID
        //clickEditMessageTemplateById(editMessageTemplate.getId());
        adminCommon.clickEditById(orAdmin.tblMessageTemplateList(), editMessageTemplate.getId());

        // Edit the field required

        switch(instField) {

            case ("Name"):
                orAdmin.txtMessageDetailName().clear();
                orAdmin.txtMessageDetailName().sendKeys(editMessageTemplate.getName());
                break;

            case ("InstitutionName"):
                adminCommon.setListValue(orAdmin.selMessageDetailInstitution(), editMessageTemplate.getInstitutionName());
                break;

            case ("Pan"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPan(),editMessageTemplate.getPan());
                break;

            case ("PanSequence"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPanSequence(),editMessageTemplate.getPanSequence());
                break;

            case ("ExpiryDate"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailExpiryDate(),editMessageTemplate.getExpiryDate());
                break;

            case ("PanAlias"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPanAlias(),editMessageTemplate.getPanAlias());
                break;

            case ("PanId"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPanId(),editMessageTemplate.getPanId());
                break;

            case ("PinPukFlag"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPinPukFlag(),editMessageTemplate.getPinPukFlag());
                break;

            case ("PinBlock"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPinBlock(),editMessageTemplate.getPinBlock());
                break;

            case ("PukBlock"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPukBlock(),editMessageTemplate.getPukBlock());
                break;

            case ("PinVerificationValue"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPinVerificationValue(),editMessageTemplate.getPinVerificationValue());
                break;

            case ("PukVerificationValue"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailPukVerificationValue(),editMessageTemplate.getPukVerificationValue());
                break;

            case ("CustomerCode"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailCustomerCode(),editMessageTemplate.getCustomerCode());
                break;

            case ("Operation"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailOperation(),editMessageTemplate.getOperation());
                break;

            case ("TokenProductName"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailTokenProductName(),editMessageTemplate.getTokenProductName());
                break;

            case ("AppSequenceNumber"):
                adminCommon.selectCheckbox(orAdmin.cbxMessageDetailAppSequenceNumber(),editMessageTemplate.getAppSequenceNumber());
                break;

            case ("FixedData"):
                orAdmin.txtMessageDetailFixedData().clear();
                orAdmin.txtMessageDetailFixedData().sendKeys(editMessageTemplate.getFixedData());
                break;

        }

        // Click the Save button
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnMessageDetailSave()));
        orAdmin.btnMessageDetailSave().click();

        return(adminCommon.clickBtnOk());

    }

}





