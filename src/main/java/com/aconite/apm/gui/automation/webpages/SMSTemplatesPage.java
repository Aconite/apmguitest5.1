package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.records.SMSTemplateDataRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aconite.apm.gui.automation.objectrepository.OR_Admin;


public class SMSTemplatesPage {


    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public SMSTemplatesPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanSmsTemplateSearchHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTemplateDetailCreate()));

        orAdmin.btnTemplateDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTemplateDetailCancel()));

        orAdmin.btnTemplateDetailCancel().click();

    }

//    public void clickEditSMSTemplateById(String id){
//
//        List<WebElement> rows = orAdmin.tblTemplateList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
//        for(WebElement row : rows){
//            List <WebElement> cells = row.findElements(By.xpath(".//td[contains(@class, 'idGId')]"));
//            for(WebElement cell : cells) {
//                if(id.equals(cell.getText())){
//                    WebElement btnEdit = row.findElement(By.xpath(".//img[contains(@src, 'edit.png')]"));
//                    btnEdit.click();
//                    break;
//                }
//            }
//        }
//    }

    public boolean clickDeleteSMSTemplateById(SMSTemplateDataRecord delSMSTemplate){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);

        // Search page
        adminCommon.searchInstitution(delSMSTemplate.getParentInstitution());

        // Click delete
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTemplateList()));
        adminCommon.clickDeleteById(orAdmin.tblTemplateList(), delSMSTemplate.getId());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }

        return true;

//        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
//
//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            WebElement cell = orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]"));
//            if(cell.getAttribute("textContent").equals(id)){
//                String delName = orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGName\")])[" + i + "]")).getAttribute("textContent");
//                int j = i+1;
//                WebElement btnDelete =  orAdmin.tblTemplateList().findElement(By.xpath("//tr[" + j + "]//img[contains(@src, \"delete.gif\")]"));
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

    public SMSTemplateDataRecord getTableDataById(SMSTemplateDataRecord smsTemplate){

        SMSTemplateDataRecord record = new SMSTemplateDataRecord();
//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            String thisId = orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]")).getAttribute("textContent");
//            if (thisId.equals(smsTemplate.getId())){
//                record.setId(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]")).getAttribute("textContent"));
//                record.setName(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGName\")])[" + i + "]")).getAttribute("textContent"));
//                record.setInstitutionName(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGInstitution\")])[" + i + "]")).getAttribute("textContent"));
//                record.setTemplateType(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGTemplateType\")])[" + i + "]")).getAttribute("textContent"));
//                break;
//            }
//        }

        List<WebElement> rows = orAdmin.tblTemplateList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
                if (smsTemplate.getId().equals(cellId.getText())) {
                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getText());
                    record.setInstitutionName(row.findElement(By.xpath(".//td[contains(@class, 'idGInstitution')]")).getText());
                    record.setTemplateType(row.findElement(By.xpath(".//td[contains(@class, 'idGTemplateType')]")).getText());
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

    public SMSTemplateDataRecord getDBDataById(String instId) throws Exception{

        SMSTemplateDataRecord record = new SMSTemplateDataRecord();

        try {

            String getIssByIdSQL = "SELECT PMDT.ID, PMDT.NAME, INST.NAME, PMST.NAME " +
                    "FROM PM_D_TEMPLATE PMDT " +
                    "LEFT JOIN  C_D_INSTITUTION INST ON PMDT.INSTITUTION_ID = INST.ID " +
                    "LEFT JOIN  PM_S_TEMPLATE_TYPE PMST ON PMDT.TYPE_ID = PMST.ID " +
                    "WHERE PMDT.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setName(null);
                record.setInstitutionName(null);
                record.setTemplateType(null);
            }
            else{

                rs.next();

                record.setId(rs.getString(1));
                record.setName(rs.getString(2));
                record.setInstitutionName(rs.getString(3));
                record.setTemplateType(rs.getString(4));


            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public SMSTemplateDataRecord getSMSTemplateListRecordByName(SMSTemplateDataRecord smsTemplateName){

        List<WebElement> rows = orAdmin.tblTemplateList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            smsTemplateName.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (smsTemplateName.getName().equals(cellName.getText())) {
                    smsTemplateName.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                smsTemplateName.setId(null);
            }
        }

        return(smsTemplateName);

//        SMSTemplateDataRecord record = new SMSTemplateDataRecord();
//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            String thisName = orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGName\")])[" + i + "]")).getAttribute("textContent");
//            if (thisName.equals(smsTemplateName)){
//                record.setId(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGId\")])[" + i + "]")).getAttribute("textContent"));
//                record.setName(thisName);
//                record.setInstitutionName(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGInstitution\")])[" + i + "]")).getAttribute("textContent"));
//                record.setTemplateType(orAdmin.tblTemplateList().findElement(By.xpath("(//td[contains(@class, \"idGTemplateType\")])[" + i + "]")).getAttribute("textContent"));
//                break;
//            }
//        }
//
//        return(record);
    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On SMS Template Page - SMS Template Detail window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtTemplateDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("InstitutionName"):
                if (!orAdmin.selTemplateDetailInstitution().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("TemplateType"):
                if (!orAdmin.selTemplateDetailTemplateType().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }
        return rc;

    }

    public SMSTemplateDataRecord enterSMSTemplateData(SMSTemplateDataRecord newSmsTemplate) {

        adminCommon.searchInstitution(newSmsTemplate.getParentInstitution());

        // Click Add button
        orAdmin.btnAdd().click();
        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTemplateDetailCancel()));

        orAdmin.txtTemplateDetailName().sendKeys(newSmsTemplate.getName());
        adminCommon.setListValue(orAdmin.selTemplateDetailInstitution(), newSmsTemplate.getInstitutionName());
        adminCommon.setListValue(orAdmin.selTemplateDetailTemplateType(), newSmsTemplate.getTemplateType());

        orAdmin.btnTemplateDetailCreate().click();

        // Deal with the confirmation pop up
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("Successfully Added")) {

            orAdmin.btnOK().click();
            mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTemplateList()));

            // get the row data by issuer name and get the id to return
            newSmsTemplate = getSMSTemplateListRecordByName(newSmsTemplate);


        }
        else{
            newSmsTemplate=null;
        }

        return(newSmsTemplate);

    }

    public boolean editSMSTemplateData(SMSTemplateDataRecord editSMSTemplate, String instField){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitution(editSMSTemplate.getInstitutionName());
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTemplateList()));

        // Find and click the Edit button by the row's ID
        adminCommon.clickEditById(orAdmin.tblTemplateList(),editSMSTemplate.getId());

        // Edit the field required
        if(instField.equals("Name")){

                orAdmin.txtTemplateDetailName().clear();
                orAdmin.txtTemplateDetailName().sendKeys(editSMSTemplate.getName());

        }

        // Click the Save button
        orAdmin.btnTemplateDetailSave().click();

        return(adminCommon.clickBtnOk());

    }

}





