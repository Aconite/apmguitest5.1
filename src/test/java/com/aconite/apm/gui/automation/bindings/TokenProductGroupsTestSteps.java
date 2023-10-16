package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.TokenProductGroupsPage;
import com.aconite.apm.gui.automation.records.TokenProductGroupDataRecord;
import io.cucumber.java.en.Then;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TokenProductGroupsTestSteps {

    TokenProductGroupsPage tokenProductGroupsPage;
    AdminCommon adminCommon;

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    public TokenProductGroupDataRecord recordNewTPG = new TokenProductGroupDataRecord();
    public TokenProductGroupDataRecord recordEditTPG = new TokenProductGroupDataRecord();
    public TokenProductGroupDataRecord recordTableTPG = new TokenProductGroupDataRecord();
    public TokenProductGroupDataRecord recordDbTPG = new TokenProductGroupDataRecord();


    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public TokenProductGroupsTestSteps(AbsractSteps absractSteps){

        try {

            webDriver = absractSteps.getDriver();
            tokenProductGroupsPage = new TokenProductGroupsPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Name is required");
            reqFields.put("Issuer","Issuer is required");

            editFields.add("Name");
            // editFields.add("Issuer");
            editFields.add("GroupCode");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    @Then("I click on the Admin Menu Token Product Groups")
    public void clickAdminTokenProductGroups() {

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminTokenProductGroupsMenuItem();

            Logging.stepName("Click On Admin Token Product Groups Menu Item");

            if(tokenProductGroupsPage.isPageOpened()){
                Logging.passMessage("Logged in and on Token Product Groups Page");
            }
            else{
                Logging.failMessage("Not logged in and on Token Product Groups Page");
                softAssert.fail("Not logged in and on Token Product Groups Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I check the token product group required fields")
    public void checkRequiredFields(){

        try{

            recordNewTPG.setParentInstitution("TestBank");
            recordNewTPG.setParentIssuer("TestBank HK");
            adminCommon.searchInstitutionAndIssuer(recordNewTPG.getParentInstitution(), recordNewTPG.getParentIssuer());

            adminCommon.clickAddButton();
            tokenProductGroupsPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = tokenProductGroupsPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            tokenProductGroupsPage.clickDetailCancelButton();


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new token product group")
    public void addTokenProductGroup() {

        try {

            // Create dummy data as data class
            recordNewTPG.setParentInstitution("TestBank");
            recordNewTPG.setParentIssuer("TestBank HK");
            recordNewTPG.setName("TestBank " + AdminCommon.getDateTime());
            recordNewTPG.setIssuer("TestBank HK");
            recordNewTPG.setGroupCode("TB_" + AdminCommon.getDateTime());

            //Enter Details and create
            recordNewTPG = tokenProductGroupsPage.enterTokenProductGroupData(recordNewTPG);

            if(recordNewTPG!=null) {
                recordNewTPG.setParentInstitution("TestBank");
                recordNewTPG.setParentIssuer("TestBank HK");
                Logging.stepName("Add Token Product Group: Table Data Check");
                recordTableTPG = tokenProductGroupsPage.getTableDataById(recordNewTPG);
                checkRecords(recordNewTPG, recordTableTPG);

                Logging.stepName("Add Token Product Group: Database Data Check");
                recordDbTPG = tokenProductGroupsPage.getDBDataById(recordNewTPG);
                checkRecords(recordNewTPG, recordDbTPG);
            }
            else{
                Logging.stepName("Add Token Product Group");
                softAssert.fail("Token Product Group not added correctly.");
                Logging.failMessage("Token Product Group not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit a token product group")
    public void editTokenProductGroup() {

        try {
            boolean editSuccess;

            // Create the newly created data as data class
            recordEditTPG = recordNewTPG;
            recordEditTPG.setParentInstitution("TestBank");
            recordEditTPG.setParentIssuer("TestBank HK");

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("Name"):
                        recordEditTPG.setName("TestBank Edit " + AdminCommon.getDateTime());
                         break;

                    /* Change the issuer */
                    case ("Issuer"):
                        recordEditTPG.setIssuer("TestBank UK");
                        break;

                    /* Change the Group Code */
                    case ("GroupCode"):
                        recordEditTPG.setGroupCode("TPG GC 495");
                        break;


                }

                editSuccess = tokenProductGroupsPage.editTokenProductGroupData(recordEditTPG, field);

                if(!editSuccess){
                    softAssert.fail("Edit Token Product Group: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Token Product Group: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditTPG);
                }
                else {

                    if(field.equals("Issuer")) {
                        recordEditTPG.setParentIssuer("TestBank UK");
                        adminCommon.searchInstitutionAndIssuer(recordEditTPG.getParentInstitution(), recordEditTPG.getParentIssuer());
                    }

                    Logging.stepName("Edit Token Product Group: Table Data Check: " + field);
                    recordTableTPG = tokenProductGroupsPage.getTableDataById(recordEditTPG);
                    checkRecords(recordEditTPG, recordTableTPG);

                    Logging.stepName("Edit Token Product Group: Database Data Check: " + field);
                    recordDbTPG = tokenProductGroupsPage.getDBDataById(recordEditTPG);
                    checkRecords(recordEditTPG, recordDbTPG);

                }


            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    
    public void checkRecords(TokenProductGroupDataRecord record1, TokenProductGroupDataRecord record2) {

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

    @Then("I delete a token product group")
    public void deleteTokenProductGroup() {

        try {

            Logging.stepName("Delete Token Product Group");

            // Delete the newly created Token Product Group
            if(tokenProductGroupsPage.deleteTokenProductGroupById(recordEditTPG)) {

                Logging.stepName("Delete Token Product Group: Table Deletion Check");
                recordTableTPG = tokenProductGroupsPage.getTableDataById(recordEditTPG);
                if (recordTableTPG.getId() != null) {
                    Logging.failMessage("Token Product Group ID " + recordEditTPG.getId() + " still exists in the table.");
                    softAssert.fail("Token Product Group ID " + recordEditTPG.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("Token Product Group ID " + recordEditTPG.getId() + " deleted from table");
                }

                Logging.stepName("Delete Token Product Group: Database Deletion Check");
                recordDbTPG = tokenProductGroupsPage.getDBDataById(recordEditTPG);
                if (recordDbTPG.getId() != null) {
                    Logging.failMessage("Token Product Group ID " + recordEditTPG.getId() + " still exists in the database.");
                    softAssert.fail("Token Product Group ID " + recordEditTPG.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("Token Product Group ID " + recordEditTPG.getId() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of Token Product Group ID " + recordEditTPG.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Token Product Group ID " + recordEditTPG.getId() + " failed in the GUI.");
            }


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("Check token product group scenario")
    public void checkTokenProductGroupScenario(){
        softAssert.assertAll();
    }


}
