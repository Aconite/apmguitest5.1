package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.InstitutionsPage;
import com.aconite.apm.gui.automation.records.InstitutionDataRecord;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class InstitutionsTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    // Code for getting data from json
    String testDataPath = "";

    public InstitutionDataRecord recordNewInst = new InstitutionDataRecord();
    public InstitutionDataRecord recordEditInst = new InstitutionDataRecord();
    public InstitutionDataRecord recordTableInst = new InstitutionDataRecord();
    public InstitutionDataRecord recordDbInst = new InstitutionDataRecord();

    InstitutionsPage institutionsPage;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public InstitutionsTestSteps(AbsractSteps absractSteps) {

        try {

            webDriver = absractSteps.getDriver();
            institutionsPage = new InstitutionsPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            // Code for getting data from json
            testDataPath = absractSteps.getDataPath();
            System.out.println("Creation: " + testDataPath);
            recordNewInst = getJSONData("newInstitution.json");

            reqFields.put("Name","Name is required");                                                                                                                                                                            reqFields.put("LocalZone","Local Zone is required");
            reqFields.put("InstitutionZone","Institution Zone is required");
            reqFields.put("InterfaceZone","Interface Zone is required");
            reqFields.put("MaxVppPinIdSeconds","Max VPP PIN ID seconds is required");

            editFields.add("Name");
            editFields.add("LocalZone");
            editFields.add("InstitutionZone");
            editFields.add("InterfaceZone");
            editFields.add("MaxVppPinIdSeconds");

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    private InstitutionDataRecord getJSONData(String fileName){

        InstitutionDataRecord outRecord = new InstitutionDataRecord();
        String path = testDataPath + "/" + fileName;

        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONObject inst = new JSONObject(contents);
            System.out.println(inst.get("localZone"));
            outRecord.setInstitutionName((String) inst.get("institutionName"));
            outRecord.setLocalZone((String) inst.get("localZone"));
            outRecord.setInstitutionZone((String) inst.get("institutionZone"));
            outRecord.setInterfaceZone((String) inst.get("interfaceZone"));
            outRecord.setMaxVppPinIdSeconds((String) inst.get("maxVppPinIdSeconds"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return outRecord;

    }

    @Then("I click on the Admin Menu Institutions")
    public void clickAdminInstitutions() {

        try{

            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnAdminInstitutionsMenuItem();

            Logging.stepName("Click On Admin Institution Menu Item");

            if(institutionsPage.isPageOpened()){
                Logging.passMessage("Logged in and on Institution Page");
            }
            else{
                Logging.failMessage("Not logged in and on Institution Page");
                softAssert.fail("Not logged in and on Institution Page");

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I check the institution required fields")
    public void checkRequiredFields(){

        try{

            adminCommon.clickAddButton();
            institutionsPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = institutionsPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            institutionsPage.clickDetailCancelButton();


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I add a new institution")
    public void addInstitution() {

        try {

//            if(AbsractSteps.myScenario.getName().contains("Burp")){
//                // Create dummy data as data class
//                recordNewInst.setInstitutionName("BurpBank");
//                recordNewInst.setLocalZone("ABCBank Local");
//                recordNewInst.setInstitutionZone("ABCBank Institution");
//                recordNewInst.setInterfaceZone("ABCBank Interface");
//                recordNewInst.setMaxVppPinIdSeconds("1200");
//            }
//            else {
//
//                // Create dummy data as data class
//                recordNewInst.setInstitutionName("Bank of Dave " + AdminCommon.getDateTime());
//                recordNewInst.setLocalZone("ABCBank Local");
//                recordNewInst.setInstitutionZone("ABCBank Institution");
//                recordNewInst.setInterfaceZone("ABCBank Interface");
//                recordNewInst.setMaxVppPinIdSeconds("1200");
//            }

            //Enter Details and create
            recordNewInst = institutionsPage.enterInstitutionData(recordNewInst);

            if(recordNewInst!=null) {

                Logging.stepName("Add Institution: Table Data Check");
                recordTableInst = institutionsPage.getTableDataById(recordNewInst);
                checkRecords(recordNewInst, recordTableInst);

                Logging.stepName("Add Institution: Database Data Check");

                recordDbInst = institutionsPage.getDBDataById(recordNewInst.getId());
                checkRecords(recordNewInst, recordDbInst);
            }
            else{
                Logging.stepName("Add Institution");
                softAssert.fail("Institution not added correctly.");
                Logging.failMessage("Institution not added correctly.");
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit an institution")
    public void editInstitution() {

        try {

            boolean editSuccess;

            // Create the newly created data as data class
            recordEditInst = recordNewInst;

            for(String field :  editFields) {

                switch (field) {

                    /* Change the name */
                    case ("Name"):
                        recordEditInst.setInstitutionName("Bank of Dave " + AdminCommon.getDateTime());
                        break;

                    /* Change the local zone */
                    case ("LocalZone"):
                        recordEditInst.setLocalZone("ABCBank Export");
                        break;

                    /* Change the institution zone */
                    case ("InstitutionZone"):
                        recordEditInst.setInstitutionZone("ABCBank Import");
                        break;

                    /* Change the interface zone */
                    case ("InterfaceZone"):
                        recordEditInst.setInterfaceZone("ABCBank Message");
                        break;

                    /* Change the MaxVppPinIdSeconds */
                    case ("MaxVppPinIdSeconds"):
                        recordEditInst.setMaxVppPinIdSeconds("1200");
                        break;
                }

                editSuccess = institutionsPage.editInstitutionData(recordEditInst,field);

                if(!editSuccess){
                    softAssert.fail("Edit Institution: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Institution: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditInst);
                }
                else {

                    Logging.stepName("Edit Institution: Table Data Check: " + field);
                    recordTableInst = institutionsPage.getTableDataById(recordEditInst);
                    checkRecords(recordEditInst, recordTableInst);

                    Logging.stepName("Edit Institution: Database Data Check: " + field);
                    recordDbInst = institutionsPage.getDBDataById(recordEditInst.getId());
                    checkRecords(recordEditInst, recordDbInst);

                }

            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I delete an institution")
    public void deleteInstitution() {

        try {
            Logging.stepName("Delete Institution");

            // Delete the newly created institution
            if(institutionsPage.clickDeleteInstitutionById(recordNewInst)) {

                Logging.stepName("Delete Institution: Table Deletion Check");
                recordTableInst = institutionsPage.getTableDataById(recordNewInst);
                if (recordTableInst.getId() != null) {
                    Logging.failMessage("Institution ID " + recordNewInst.getId() + " still exists in the table.");
                    softAssert.fail("Institution ID " + recordNewInst.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("Institution ID " + recordNewInst.getId() + " deleted from table");
                }

                Logging.stepName("Delete Institution: Database Deletion Check");
                recordDbInst = institutionsPage.getDBDataById(recordNewInst.getId());
                if (recordDbInst.getId() != null) {
                    Logging.failMessage("Institution ID " + recordNewInst.getId() + " still exists in the database.");
                    softAssert.fail("Institution ID " + recordNewInst.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("Institution ID " + recordNewInst.getId() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of Institution ID " + recordNewInst.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Institution ID " + recordNewInst.getId() + " failed in the GUI.");
            }



        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkRecords(InstitutionDataRecord record1, InstitutionDataRecord record2) {

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

    @Then("Check institution scenario")
    public void checkInstitutionScenario(){
        softAssert.assertAll();
    }

}