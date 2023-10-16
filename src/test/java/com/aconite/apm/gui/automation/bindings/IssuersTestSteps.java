package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.IssuersPage;
import com.aconite.apm.gui.automation.records.IssuerDataRecord;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class IssuersTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    public IssuerDataRecord recordNewIss = new IssuerDataRecord();
    public IssuerDataRecord recordEditIss = new IssuerDataRecord();
    public IssuerDataRecord recordTableIss = new IssuerDataRecord();
    public IssuerDataRecord recordDbIss = new IssuerDataRecord();

    IssuersPage issuersPage = null;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public IssuersTestSteps(AbsractSteps absractSteps){
        try {

            webDriver = absractSteps.getDriver();
            issuersPage = new IssuersPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Name is required");
            reqFields.put("Country","Country is required");

            editFields.add("Name");
            editFields.add("Country");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    @Then("I click on the Admin Menu Issuers")
    public void clickAdminIssuers(){

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminIssuersMenuItem();

            Logging.stepName("Click On Admin Issuers Menu Item");

            if(issuersPage.isPageOpened()){
                Logging.passMessage("Logged in and on Issuers Page");
            }
            else{
                Logging.failMessage("Not logged in and on Issuers Page");
                softAssert.fail("Not logged in and on Issuers Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I check the issuer required fields")
    public void checkRequiredFields(){

        try{

            recordNewIss.setParentInstitution("TestBank");
            adminCommon.searchInstitution(recordNewIss.getParentInstitution());

            adminCommon.clickAddButton();
            issuersPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = issuersPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            issuersPage.clickDetailCancelButton();


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new issuer")
    public void addIssuer() {
        try {

            // Create dummy data as data class
            recordNewIss.setParentInstitution("TestBank");
            recordNewIss.setIssuerName("TestIssuer_" + AdminCommon.getDateTime());
            recordNewIss.setInstitutionName("TestBank");
            recordNewIss.setCountry("Madagascar");

            //Enter Details and create
            recordNewIss = issuersPage.enterIssuerData(recordNewIss);

            if(recordNewIss!=null) {
                Logging.stepName("Add Issuer: Table Data Check");
                recordTableIss = issuersPage.getTableDataById(recordNewIss);
                checkRecords(recordNewIss, recordTableIss);

                Logging.stepName("Add Issuer: Database Data Check");
                recordDbIss = issuersPage.getDBDataById(recordNewIss.getId());
                checkRecords(recordNewIss, recordDbIss);
            }
            else{
                Logging.stepName("Add Issuer");
                softAssert.fail("Issuer not added correctly.");
                Logging.failMessage("Issuer not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit an issuer")
    public void editIssuer(){

        try {
            boolean editSuccess;

            // Create the newly created data as data class
            recordEditIss = recordNewIss;
            recordNewIss.setParentInstitution("TestBank");//gets lost when updating TODO: fix so updates do not overwrite
            recordEditIss.setParentInstitution("TestBank");//gets lost when updating

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("Name"):
                        recordEditIss.setIssuerName("TestIssuer_" + AdminCommon.getDateTime());
                        break;

                    /* Change the country */
                    case ("Country"):
                        recordEditIss.setCountry("Malawi");
                        break;

                }

                editSuccess = issuersPage.editIssuerData(recordEditIss, field);

                if(!editSuccess){
                    softAssert.fail("Edit Issuer: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Issuer: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditIss);
                }
                else {

                    Logging.stepName("Edit Issuer: Table Data Check: " + field);
                    recordTableIss = issuersPage.getTableDataById(recordEditIss);
                    checkRecords(recordEditIss, recordTableIss);

                    Logging.stepName("Edit Issuer: Database Data Check: " + field);
                    recordDbIss = issuersPage.getDBDataById(recordEditIss.getId());
                    checkRecords(recordEditIss, recordDbIss);
                }

            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkRecords(IssuerDataRecord record1, IssuerDataRecord record2) {

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

    @Then("I delete an issuer")
    public void deleteIssuer() {
        try {

            Logging.stepName("Delete Issuer");

            // Delete the newly created issuer
            if(issuersPage.clickDeleteIssuerById(recordNewIss)) {

                Logging.stepName("Delete Issuer: Table Deletion Check");
                recordTableIss = issuersPage.getTableDataById(recordNewIss);
                if (recordTableIss.getId() != null) {
                    Logging.failMessage("Issuer ID " + recordNewIss.getId() + " still exists in the table.");
                    softAssert.fail("Issuer ID " + recordNewIss.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("Issuer ID " + recordNewIss.getId() + " deleted from table");
                }

                Logging.stepName("Delete Issuer: Database Deletion Check");
                recordDbIss = issuersPage.getDBDataById(recordNewIss.getId());
                if (recordDbIss.getId() != null) {
                    Logging.failMessage("Issuer ID " + recordNewIss.getId() + " still exists in the database.");
                    softAssert.fail("Issuer ID " + recordNewIss.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("Issuer ID " + recordNewIss.getId() + " deleted from database");
                }
            }
            else{
                Logging.failMessage("Deletion of Issuer ID " + recordNewIss.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Issuer ID " + recordNewIss.getId() + " failed in the GUI.");
            }


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("Check issuer scenario")
    public void checkIssuerScenario(){
        softAssert.assertAll();
    }

}


