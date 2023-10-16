package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.SMSTemplatesPage;
import com.aconite.apm.gui.automation.records.SMSTemplateDataRecord;
import io.cucumber.java.en.Then;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SMSTemplatesTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    public SMSTemplateDataRecord recordNewSMSTemplate = new SMSTemplateDataRecord();
    public SMSTemplateDataRecord recordEditSMSTemplate = new SMSTemplateDataRecord();
    public SMSTemplateDataRecord recordTableSMSTemplate = new SMSTemplateDataRecord();
    public SMSTemplateDataRecord recordDbSMSTemplate = new SMSTemplateDataRecord();

    SMSTemplatesPage smsTemplatesPage = null;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public SMSTemplatesTestSteps(AbsractSteps absractSteps) {

        try {

            webDriver = absractSteps.getDriver();
            smsTemplatesPage = new SMSTemplatesPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Name is required");
            reqFields.put("InstitutionName","Institution is required");
            reqFields.put("TemplateType","Template type is required");

            editFields.add("Name");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    @Then("I click on the Admin Menu SMS Templates")
    public void clickAdminSmsTemplates() {

        try{

            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminSMSTemplatesMenuItem();

            Logging.stepName("Click On Admin SMS Templates Menu Item");

            if(smsTemplatesPage.isPageOpened()){
                Logging.passMessage("Logged in and on SMS Templates Page");
            }
            else{
                Logging.failMessage("Not logged in and on SMS Templates Page");
                softAssert.fail("Not logged in and on SMS Templates Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I check the SMS Template required fields")
    public void checkRequiredFields(){

        try{

            boolean rc;

            // STARTING POINT: On Message Template Page - no other windows open
            recordNewSMSTemplate.setParentInstitution("ClearBank");
            adminCommon.searchInstitution(recordNewSMSTemplate.getParentInstitution());

            adminCommon.clickAddButton();
            smsTemplatesPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                rc = smsTemplatesPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            smsTemplatesPage.clickDetailCancelButton();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I add a new SMS Template")
    public void addSmsTemplate() {

        try {

            // Create dummy data as data class
            recordNewSMSTemplate.setParentInstitution("TestBank");
            recordNewSMSTemplate.setName("TestBank PIN " + AdminCommon.getDateTime());
            recordNewSMSTemplate.setInstitutionName("TestBank");
            recordNewSMSTemplate.setTemplateType("PIN");

            //Enter Details and create
            recordNewSMSTemplate = smsTemplatesPage.enterSMSTemplateData(recordNewSMSTemplate);

            if(recordNewSMSTemplate!=null) {

                Logging.stepName("Add SMS Template: Table Data Check");
                recordTableSMSTemplate = smsTemplatesPage.getTableDataById(recordNewSMSTemplate);
                checkRecords(recordNewSMSTemplate, recordTableSMSTemplate);

                Logging.stepName("Add SMS Template: Database Data Check");
                recordDbSMSTemplate = smsTemplatesPage.getDBDataById(recordNewSMSTemplate.getId());
                checkRecords(recordNewSMSTemplate, recordDbSMSTemplate);

            }
            else{
                Logging.stepName("Add SMS Template");
                softAssert.fail("SMS Template not added correctly.");
                Logging.failMessage("SMS Template not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit an SMS Template")
    public void editSmsTemplate() {

        try {

            boolean editSuccess;
            // Use the new for edit
            recordEditSMSTemplate = recordNewSMSTemplate;
            recordEditSMSTemplate.setParentInstitution("TestBank");

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("Name"):
                        recordEditSMSTemplate.setName("TestBank PIN " + AdminCommon.getDateTime());
                        break;
                  }

                editSuccess = smsTemplatesPage.editSMSTemplateData(recordEditSMSTemplate,field);

                if(!editSuccess){
                    softAssert.fail("Edit SMS Template: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Edit SMS Template: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditSMSTemplate);
                }
                else {

                    Logging.stepName("Edit SMS Template: Table Data Check: " + field);
                    recordTableSMSTemplate = smsTemplatesPage.getTableDataById(recordEditSMSTemplate);
                    checkRecords(recordEditSMSTemplate, recordTableSMSTemplate);

                    Logging.stepName("Edit SMS Template: Database Data Check: " + field);
                    recordDbSMSTemplate = smsTemplatesPage.getDBDataById(recordEditSMSTemplate.getId());
                    checkRecords(recordEditSMSTemplate, recordDbSMSTemplate);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I delete an SMS Template")
    public void deleteSmsTemplate() {
        try {
            Logging.stepName("Delete SMS Template");

            // Delete the newly created institution
            if(smsTemplatesPage.clickDeleteSMSTemplateById(recordEditSMSTemplate)) {

                Logging.stepName("Delete SMS Template: : Table Deletion Check");
                recordTableSMSTemplate = smsTemplatesPage.getTableDataById(recordEditSMSTemplate);
                if (recordTableSMSTemplate.getId() != null) {
                    Logging.failMessage("SMS Template ID " + recordEditSMSTemplate.getId() + " still exists in the table.");
                    softAssert.fail("SMS Template ID " + recordEditSMSTemplate.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("SMS Template ID " + recordEditSMSTemplate.getId() + " deleted from table");
                }

                Logging.stepName("Delete SMS Template: Database Deletion Check");
                recordDbSMSTemplate = smsTemplatesPage.getDBDataById(recordEditSMSTemplate.getId());
                if (recordDbSMSTemplate.getId() != null) {
                    Logging.failMessage("SMS Template ID " + recordEditSMSTemplate.getId() + " still exists in the database.");
                    softAssert.fail("SMS Template ID " + recordEditSMSTemplate.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("SMS Template ID " + recordEditSMSTemplate.getId() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of SMS Template ID " + recordNewSMSTemplate.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of SMS Template ID " + recordNewSMSTemplate.getId() + " failed in the GUI.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkRecords(SMSTemplateDataRecord record1, SMSTemplateDataRecord record2) {

        if (record1 == null) {
            softAssert.fail("Record 1 data is NULL");
            Logging.failMessage("Record 1 data is NULL");
            return;
        }

        if (record2 == null) {
            softAssert.fail("Record 2 data is NULL");
            Logging.failMessage("Record 2 data is NULL");
            return;
        }

        // Check the records match
        if (record1.equals(record2)) {
            Logging.passMessage("Record data matches:" +
                    "\nRecord 1 Data = " + record1 +
                    "\nRecord 2 Data = " + record2);
        }
        else{
            softAssert.fail("Record data does not match:");
            Logging.failMessage("Record data does not match:" +
                    "\nRecord 1 Data = " + record1 +
                    "\nRecord 2 Data = " + record2);
        }
    }

    @Then("Check SMS Template scenario")
    public void checkSmsTemplateScenario(){
        softAssert.assertAll();
    }


}
