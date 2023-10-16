package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.records.CountryDataRecord;
import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.CountryPage;
import com.aconite.apm.gui.automation.webpages.HomePage;
import io.cucumber.java.en.Then;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CountryTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    // Code for getting data from json
    String testDataPath = "";

    public CountryDataRecord recordNewCountry = new CountryDataRecord();
    public CountryDataRecord recordEditCountry = new CountryDataRecord();
    public CountryDataRecord recordTableCountry = new CountryDataRecord();
    public CountryDataRecord recordDbCountry = new CountryDataRecord();

    CountryPage countryPage;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public CountryTestSteps(AbsractSteps absractSteps) {

        try{
            webDriver = absractSteps.getDriver();
            countryPage = new CountryPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            testDataPath = absractSteps.getDataPath();
            recordNewCountry = getJSONData();

            reqFields.put("CountryCode","This field is required");
            reqFields.put("CountryName","This field is required");

            editFields.add("CountryName");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

    }

    private CountryDataRecord getJSONData(){

        CountryDataRecord outRecord = new CountryDataRecord();
        String path = testDataPath + "/newCountry.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONObject inst = new JSONObject(contents);
            outRecord.setCountryName((String) inst.get("countryName"));
            outRecord.setCountryCode((String) inst.get("countryCode"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return outRecord;

    }

    @Then("I click on the Admin Menu Data Dictionary Countries")
    public void clickAdminCountries() {

        try{

            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminCountriesMenuItem();

            Logging.stepName("Click On Admin > Data Dictionary > Countries Menu Item");

            if(countryPage.isPageOpened()){
                Logging.passMessage("Logged in and on Countries Page");
            }
            else{
                Logging.failMessage("Not logged in and on Countries Page");
                softAssert.fail("Not logged in and on Countries Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I check the country required fields")
    public void checkRequiredFields(){

        try{

            adminCommon.clickAddButton();
            countryPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = countryPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            countryPage.clickDetailCancelButton();


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new country")
    public void addCountry(){
        try{

            recordNewCountry = countryPage.enterCountryData(recordNewCountry);

            if(recordNewCountry!=null) {

                Logging.stepName("Add Country: Table Data Check");
                recordTableCountry = countryPage.getTableDataById(recordNewCountry);
                checkRecords(recordNewCountry, recordTableCountry);

                Logging.stepName("Add Country: Database Data Check");
                recordDbCountry = countryPage.getDBDataById(recordNewCountry.getCountryCode());
                checkRecords(recordNewCountry, recordDbCountry);

            }
            else{
                Logging.stepName("Add Country");
                softAssert.fail("Country not added correctly.");
                Logging.failMessage("Country not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I edit a country")
    public void editCountry(){

        try {

            boolean editSuccess;

            // Create the newly created data as data class
            recordEditCountry = recordNewCountry;

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("CountryName"):
                        recordEditCountry.setCountryName("North Burpistan");
                        break;

                    /* Change the code */
                    case ("CountryCode"):
                        recordEditCountry.setCountryCode("950");
                        break;

                }
                System.out.println(recordEditCountry);
                editSuccess = countryPage.editCountryData(recordEditCountry,field);

                if(!editSuccess){
                    softAssert.fail("Edit Country: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Country: Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditCountry);
                }
                else {
                    Logging.stepName("Edit Country: Table Data Check: " + field);
                    recordTableCountry = countryPage.getTableDataById(recordEditCountry);
                    checkRecords(recordEditCountry, recordTableCountry);

                    Logging.stepName("Edit Country: Database Data Check");
                    recordDbCountry = countryPage.getDBDataById(recordNewCountry.getCountryCode());
                    checkRecords(recordEditCountry, recordDbCountry);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I delete a country")
    public void deleteCountry() {
        try {

            Logging.stepName("Delete Country");

            // Delete the newly created issuer
            if(countryPage.clickDeleteCountryByCountryCode(recordNewCountry)) {

                Logging.stepName("Delete Country: Table Deletion Check");
                recordTableCountry = countryPage.getTableDataById(recordNewCountry);
                if (recordTableCountry.getCountryCode() != null) {
                    Logging.failMessage("Country ID " + recordNewCountry.getCountryCode() + " still exists in the table.");
                    softAssert.fail("Country ID " + recordNewCountry.getCountryCode() + " still exists in the table.");
                } else {
                    Logging.passMessage("Country ID " + recordNewCountry.getCountryCode() + " deleted from table");
                }

                Logging.stepName("Delete Country: Database Deletion Check");
                recordDbCountry = countryPage.getDBDataById(recordNewCountry.getCountryCode());
                if (recordDbCountry.getCountryCode() != null) {
                    Logging.failMessage("Country ID " + recordNewCountry.getCountryCode() + " still exists in the database.");
                    softAssert.fail("Country ID " + recordNewCountry.getCountryCode() + " still exists in the database.");
                } else {
                    Logging.passMessage("Country ID " + recordNewCountry.getCountryCode() + " deleted from database");
                }
            }
            else{
                Logging.failMessage("Deletion of Country ID " + recordNewCountry.getCountryCode() + " failed in the GUI.");
                softAssert.fail("Deletion of Country ID " + recordNewCountry.getCountryCode() + " failed in the GUI.");
            }


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkRecords(CountryDataRecord record1, CountryDataRecord record2) {

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

    @Then("Check Country scenario")
    public void checkCountryScenario()  {
        softAssert.assertAll();
    }
}
