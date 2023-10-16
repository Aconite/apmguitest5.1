package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.records.MessageTemplateDataRecord;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.MessageTemplatesPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import java.util.*;

public class MessageTemplatesTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    public MessageTemplateDataRecord recordNewMessageTemplate = new MessageTemplateDataRecord();
    public MessageTemplateDataRecord recordEditMessageTemplate = new MessageTemplateDataRecord();
    public MessageTemplateDataRecord recordTableMessageTemplate = new MessageTemplateDataRecord();
    public MessageTemplateDataRecord recordDbMessageTemplate = new MessageTemplateDataRecord();

    MessageTemplatesPage messageTemplatesPage;
    AdminCommon adminCommon;


    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public MessageTemplatesTestSteps(AbsractSteps absractSteps){
        try {

            webDriver = absractSteps.getDriver();
            messageTemplatesPage = new MessageTemplatesPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Name is required");
            reqFields.put("InstitutionName","Institution is required");

            editFields.add("Name");
            editFields.add("InstitutionName");
            editFields.add("Pan");
            editFields.add("PanSequence");
            editFields.add("ExpiryDate");
            editFields.add("PanAlias");
            editFields.add("PanId");
            editFields.add("PinPukFlag");
            editFields.add("PinBlock");
            editFields.add("PukBlock");
            editFields.add("PinVerificationValue");
            editFields.add("PukVerificationValue");
            editFields.add("CustomerCode");
            editFields.add("Operation");
            editFields.add("TokenProductName");
            editFields.add("AppSequenceNumber");
            editFields.add("FixedData");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    @Then("I click on the Admin Menu Message Templates")
    public void clickAdminMessageTemplates() {

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminMessageTemplatesMenuItem();

            Logging.stepName("Click On Admin Message Templates Menu Item");

            if(messageTemplatesPage.isPageOpened()){
                Logging.passMessage("Logged in and on Message Templates Page");
            }
            else{
                Logging.failMessage("Not logged in and on Message Templates Page");
                softAssert.fail("Not logged in and on Message Templates Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then ("I check the Message Template required fields")
    public void checkRequiredFields() {

        try{

            // STARTING POINT: On Message Template Page - no other windows open
            recordNewMessageTemplate.setParentInstitution("ClearBank");
            adminCommon.searchInstitution(recordNewMessageTemplate.getParentInstitution());

            adminCommon.clickAddButton();
            messageTemplatesPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = messageTemplatesPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            messageTemplatesPage.clickDetailCancelButton();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I add a new Message Template")
    public void addMessageTemplate() {

        try {

            // Create dummy data as data class
            recordNewMessageTemplate.setParentInstitution("TestBank");
            recordNewMessageTemplate.setName("TestBank Message Template " + AdminCommon.getDateTime());
            recordNewMessageTemplate.setInstitutionName("TestBank");
            recordNewMessageTemplate.setPan("false");
            recordNewMessageTemplate.setPanSequence("false");
            recordNewMessageTemplate.setExpiryDate("false");
            recordNewMessageTemplate.setPanAlias("false");
            recordNewMessageTemplate.setPanId("false");
            recordNewMessageTemplate.setPinPukFlag("false");
            recordNewMessageTemplate.setPinBlock("false");
            recordNewMessageTemplate.setPukBlock("false");
            recordNewMessageTemplate.setPinVerificationValue("false");
            recordNewMessageTemplate.setPukVerificationValue("false");
            recordNewMessageTemplate.setCustomerCode("false");
            recordNewMessageTemplate.setOperation("false");
            recordNewMessageTemplate.setTokenProductName("false");
            recordNewMessageTemplate.setAppSequenceNumber("false");
            recordNewMessageTemplate.setFixedData("");

            //Enter Details and create
            recordNewMessageTemplate = messageTemplatesPage.enterMessageTemplateData(recordNewMessageTemplate);
            if(recordNewMessageTemplate!=null) {

                Logging.stepName("Add Message Template: Table Data Check");
                recordTableMessageTemplate = messageTemplatesPage.getTableDataById(recordNewMessageTemplate);
                if (recordNewMessageTemplate.getName().equals(recordTableMessageTemplate.getName())) {
                    Logging.passMessage("Record data matches");
                } else {
                    softAssert.fail("Add Message Template: Record data does not match:");
                    Logging.failMessage("Record data does not match:" +
                            "\nRecord 1 Data = " + recordNewMessageTemplate.getName() +
                            "\nRecord 2 Data = " + recordTableMessageTemplate.getName());
                }

                Logging.stepName("Add Message Template: Database Data Check");
                recordDbMessageTemplate = messageTemplatesPage.getDBDataById(recordNewMessageTemplate.getId());
                checkDatabaseRecords(recordNewMessageTemplate, recordDbMessageTemplate);

            }
            else{
                Logging.stepName("Add Message Template");
                softAssert.fail("Message Template not added correctly.");
                Logging.failMessage("Message Template not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit a Message Template")
    public void editMessageTemplate() {

        try {

            boolean editSuccess;

            // Create the newly created data as data class
            recordEditMessageTemplate = recordNewMessageTemplate;

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("Name"):
                        recordEditMessageTemplate.setName("TestBank Message Template " + AdminCommon.getDateTime());
                        break;

                    case("InstitutionName"):
                        recordEditMessageTemplate.setInstitutionName("ABCBank");
                        break;

                    case("Pan"):
                        recordEditMessageTemplate.setPan("true");
                        break;

                    case("PanSequence"):
                        recordEditMessageTemplate.setPanSequence("true");
                        break;


                    case("ExpiryDate"):
                        recordEditMessageTemplate.setExpiryDate("true");
                        break;

                    case("PanAlias"):
                        recordEditMessageTemplate.setPanAlias("true");
                        break;

                    case("PanId"):
                        recordEditMessageTemplate.setPanId("true");
                        break;

                    case("PinPukFlag"):
                        recordEditMessageTemplate.setPinPukFlag("true");
                        break;

                    case("PinBlock"):
                        recordEditMessageTemplate.setPinBlock("true");
                        break;

                    case("PukBlock"):
                        recordEditMessageTemplate.setPukBlock("true");
                        break;

                    case("PinVerificationValue"):
                        recordEditMessageTemplate.setPinVerificationValue("true");
                        break;

                    case("PukVerificationValue"):
                        recordEditMessageTemplate.setPukVerificationValue("true");
                        break;

                    case("CustomerCode"):
                        recordEditMessageTemplate.setCustomerCode("true");
                        break;

                    case("Operation"):
                        recordEditMessageTemplate.setOperation("true");
                        break;

                    case("TokenProductName"):
                        recordEditMessageTemplate.setTokenProductName("true");
                        break;

                    case("AppSequenceNumber"):
                        recordEditMessageTemplate.setAppSequenceNumber("true");
                        break;

                    case("FixedData"):
                        recordEditMessageTemplate.setFixedData("Edited TestBank fixed data " + AdminCommon.getDateTime());
                        break;
                    }

                Logging.stepName("Edit Message Template: " + field);
                editSuccess = messageTemplatesPage.editMessageTemplateData(recordEditMessageTemplate,field);
                if(!editSuccess){
                    softAssert.fail("Edit Message Template: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Message Template: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditMessageTemplate);
                }
                else {
                    if(field.equals("InstitutionName")){
                        recordEditMessageTemplate.setParentInstitution("ABCBank");
                        adminCommon.searchInstitution(recordEditMessageTemplate.getParentInstitution());
                    }

                    Logging.stepName("Edit Message Template: Database Data Check " + field);
                    recordDbMessageTemplate = messageTemplatesPage.getDBDataById(recordEditMessageTemplate.getId());
                    checkDatabaseRecords(recordEditMessageTemplate, recordDbMessageTemplate);

                    Logging.stepName("Edit Message Template: Table Data Check " + field);
                    recordTableMessageTemplate = messageTemplatesPage.getTableDataById(recordEditMessageTemplate);
//                    recordTableMessageTemplate = messageTemplatesPage.getMessageTemplateListRecordByName(recordEditMessageTemplate);
                    checkTableRecords(recordEditMessageTemplate, recordTableMessageTemplate);

                }

            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I delete a Message Template")
    public void deleteMessageTemplate() {

        try {

            Logging.stepName("Delete Message Template");

            // Delete the newly created institution
            if(messageTemplatesPage.clickDeleteMessageTemplateById(recordNewMessageTemplate)){

                Logging.stepName("Delete Message Template: Table Deletion Check");
                recordTableMessageTemplate = messageTemplatesPage.getTableDataById(recordNewMessageTemplate);
                if (recordTableMessageTemplate.getId()!=null){
                    Logging.failMessage("Message Template ID " + recordNewMessageTemplate.getId() + " still exists in the table.");
                    softAssert.fail("Message Template ID " + recordNewMessageTemplate.getId() + " still exists in the table.");
                }
                else{
                    Logging.passMessage("Message Template ID " + recordNewMessageTemplate.getId() + " deleted from table successfully.");
                }

                Logging.stepName("Delete Message Template: Database Deletion Check");
                recordDbMessageTemplate = messageTemplatesPage.getDBDataById(recordNewMessageTemplate.getId());
                if (recordDbMessageTemplate.getId()!=null){
                    Logging.failMessage("Message Template ID " + recordNewMessageTemplate.getId() + " still exists in the database.");
                    softAssert.fail("Message Template ID " + recordNewMessageTemplate.getId() + " still exists in the database.");
                }
                else{
                    Logging.passMessage("Message Template ID " + recordNewMessageTemplate.getId() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of Message Template ID " + recordNewMessageTemplate.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Message Template ID " + recordNewMessageTemplate.getId() + " failed in the GUI.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkDatabaseRecords(MessageTemplateDataRecord record1, MessageTemplateDataRecord record2) {

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

    public void checkTableRecords(MessageTemplateDataRecord record1, MessageTemplateDataRecord record2) {

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
        if (record1.equalsTable(record2)) {
            Logging.passMessage("Record data matches:" +
                    "\nRecord 1 Data = " + record1.toStringTable() +
                    "\nRecord 2 Data = " + record2.toStringTable());
        }
        else{
            softAssert.fail("Record data does not match:");
            Logging.failMessage("Record data does not match:" +
                    "\nRecord 1 Data = " + record1.toStringTable() +
                    "\nRecord 2 Data = " + record2.toStringTable());
        }

    }

    @Then("Check Message Template scenario")
    public void checkMessageTemplatesScenario(){
        softAssert.assertAll();
    }


}
