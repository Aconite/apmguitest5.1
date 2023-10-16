package com.aconite.apm.gui.automation.bindings;


import com.aconite.apm.gui.automation.records.PersoBureauDataRecord;
import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.PersoBureauPage;
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


public class PersoBureauTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    // Code for getting data from json
    String testDataPath = "";

    public PersoBureauDataRecord recordNewPersoBureau = new PersoBureauDataRecord();
    public PersoBureauDataRecord recordEditPersoBureau = new PersoBureauDataRecord();
    public PersoBureauDataRecord recordTablePersoBureau = new PersoBureauDataRecord();
    public PersoBureauDataRecord recordDBPersoBureau = new PersoBureauDataRecord();

    PersoBureauPage persoBureauPage;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public PersoBureauTestSteps(AbsractSteps absractSteps) {

        try

        {
            webDriver = absractSteps.getDriver();
            persoBureauPage = new PersoBureauPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            testDataPath = absractSteps.getDataPath();
            recordNewPersoBureau = getJSONData();

            reqFields.put("name","Perso Bureau Name is required");
            reqFields.put("code","Perso Bureau Code is required");
            reqFields.put("destinationDirectory","Please use valid path characters only</li><li>Destination Directory is required");
            reqFields.put("encryptionZone","Encryption Zone is required");


            editFields.add("extractPAN");
            editFields.add("extractPANDisplay");

        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }

    }

    private PersoBureauDataRecord getJSONData(){

        PersoBureauDataRecord outRecord = new PersoBureauDataRecord();
        String path = testDataPath + "/newPersoBureau.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONObject inst = new JSONObject(contents);
            outRecord.setName((String) inst.get("name"));
            outRecord.setCode((String) inst.get("code"));
            outRecord.setDestinationDirectory((String) inst.get("destinationDirectory"));
            outRecord.setEncryptionZone((String) inst.get("encryptionZone"));
            outRecord.setExtractPan((String) inst.get("extractPAN"));
            outRecord.setExtractPanDisplay((String) inst.get("extractPANDisplay"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return outRecord;

    }

    @Then("I click on the Admin Menu Interfaces Perso Bureau")
    public void clickAdminPersonalisationBureaus() {

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnInterfacesPersoBureauMenuItem();

            Logging.stepName("Click On Admin > Interfaces > Personalisation Bureaus Menu Item");

            if(persoBureauPage.isPageOpened()){
                Logging.passMessage("Logged in and on Personalisation Bureaus Page");
            }
            else{
                Logging.failMessage("Not logged in and on Personalisation Bureaus Page");
                softAssert.fail("Not logged in and on Personalisation Bureaus Page");
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I check the perso bureau required fields")
    public void checkRequiredFields(){

        try{

            adminCommon.clickAddButton();
            persoBureauPage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = persoBureauPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            persoBureauPage.clickDetailCancelButton();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new perso bureau")
    public void addPersoBureau(){

        recordNewPersoBureau = persoBureauPage.enterPersoBureauData(recordNewPersoBureau);

        if(recordNewPersoBureau!=null) {

            Logging.stepName("Add Personalisation Bureau: Table Data Check");
            recordTablePersoBureau = persoBureauPage.getTableDataById(recordNewPersoBureau);
            System.out.println(recordTablePersoBureau);
            System.out.println(recordNewPersoBureau);
            checkRecords(recordNewPersoBureau, recordTablePersoBureau);

            Logging.stepName("Add Personalisation Bureau: Database Data Check");
            recordDBPersoBureau = persoBureauPage.getDBDataById(recordNewPersoBureau.getId());
            checkRecords(recordNewPersoBureau, recordDBPersoBureau);

        }
        else{
            Logging.stepName("Add Personalisation Bureau");
            softAssert.fail("Personalisation Bureau not added correctly.");
            Logging.failMessage("Personalisation Bureau not added correctly.");
        }


    }

    @Then("I edit a perso bureau")
    public void editPersoBureau(){

        try {

            boolean editSuccess;

            // Create the newly created data as data class
            recordEditPersoBureau = recordNewPersoBureau;
            System.out.println("NEW: " + recordNewPersoBureau);
            System.out.println("EDIT: " + recordEditPersoBureau);

            for(String field :  editFields) {

                switch (field) {

                    /* Change the fields */
                    case ("extractPAN"):
                        recordEditPersoBureau.setExtractPan("true");
                        break;

                    case ("extractPANDisplay"):
                        recordEditPersoBureau.setExtractPanDisplay("true");
                        break;

                }

                editSuccess = persoBureauPage.editPersoBureauData(recordEditPersoBureau,field);

                if(!editSuccess){
                    softAssert.fail("Edit Personalisation Bureau: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Personalisation Bureau: Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditPersoBureau);
                }
                else {
                    Logging.stepName("Edit Personalisation Bureau: Table Data Check: " + field);
                    recordTablePersoBureau = persoBureauPage.getTableDataById(recordEditPersoBureau);
                    checkRecords(recordEditPersoBureau, recordTablePersoBureau);

                    Logging.stepName("Edit Personalisation Bureau: Database Data Check");
                    recordDBPersoBureau = persoBureauPage.getDBDataById(recordEditPersoBureau.getId());
                    checkRecords(recordEditPersoBureau, recordDBPersoBureau);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void checkRecords(PersoBureauDataRecord record1, PersoBureauDataRecord record2) {

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

    @Then("I delete a perso bureau")
    public void deletePersonalisationBureau(){
        try {

            Logging.stepName("Delete Personalisation Bureau");

            // Delete the newly created issuer
            if(persoBureauPage.clickDeletePersoBureauById(recordNewPersoBureau)) {

                Logging.stepName("Delete Personalisation Bureau: Table Deletion Check");
                recordTablePersoBureau = persoBureauPage.getTableDataById(recordNewPersoBureau);
                if (recordTablePersoBureau.getId() != null) {
                    Logging.failMessage("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " still exists in the table.");
                    softAssert.fail("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " deleted from table");
                }

                Logging.stepName("Delete Personalisation Bureau: Database Deletion Check");
                recordDBPersoBureau = persoBureauPage.getDBDataById(recordNewPersoBureau.getId());
                if (recordDBPersoBureau.getId() != null) {
                    Logging.failMessage("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " still exists in the database.");
                    softAssert.fail("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("Personalisation Bureau ID " + recordNewPersoBureau.getId() + " deleted from database");
                }
            }
            else{
                Logging.failMessage("Deletion of Personalisation Bureau ID " + recordNewPersoBureau.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Personalisation Bureau ID " + recordNewPersoBureau.getId() + " failed in the GUI.");
            }


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }


    }

    @Then("Check Perso Bureau scenario")
    public void checkPersoBureauScenario()  {
        softAssert.assertAll();
    }

}
