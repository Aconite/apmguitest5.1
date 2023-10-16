package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.records.InterfaceDataRecord;
import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.InterfacePage;
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


public class InterfaceTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    // Code for getting data from json
    String testDataPath = "";

    public InterfaceDataRecord recordNewInterface = new InterfaceDataRecord();
    public InterfaceDataRecord recordEditInterface = new InterfaceDataRecord();
    public InterfaceDataRecord recordTableInterface = new InterfaceDataRecord();
    public InterfaceDataRecord recordDBInterface = new InterfaceDataRecord();

    InterfacePage interfacePage;
    AdminCommon adminCommon;

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public InterfaceTestSteps(AbsractSteps absractSteps) {

        try

        {
            webDriver = absractSteps.getDriver();
            interfacePage = new InterfacePage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            testDataPath = absractSteps.getDataPath();
            recordNewInterface = getJSONData();

            reqFields.put("name","Interface Name is required");
            reqFields.put("type","Interface Type is required");
            reqFields.put("institution","Institution is required");
            reqFields.put("encryptionZone","Encryption Zone is required");
            reqFields.put("host","Host Address is required");
            reqFields.put("port","IP Port config is required");
            reqFields.put("timeout","Timeout is required");
            reqFields.put("username","This field is required");

            editFields.add("keystorePath");
            editFields.add("certificateAlias");
            editFields.add("context");

        }
        catch(Exception exc)
        {
            exc.printStackTrace();
        }

    }

    private InterfaceDataRecord getJSONData(){

        InterfaceDataRecord outRecord = new InterfaceDataRecord();
        String path = testDataPath + "/newInterface.json";

        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONObject inst = new JSONObject(contents);
            outRecord.setName((String) inst.get("name"));
            outRecord.setType((String) inst.get("type"));
            outRecord.setInstitution((String) inst.get("institution"));
            outRecord.setEncryptionZone((String) inst.get("encryptionZone"));
            outRecord.setHost((String) inst.get("host"));
            outRecord.setPort((String) inst.get("port"));
            outRecord.setTimeout((String) inst.get("timeout"));
            outRecord.setSsl((String) inst.get("ssl"));
            outRecord.setKeystorePath((String) inst.get("keystorePath"));
            outRecord.setUsername((String) inst.get("username"));
            outRecord.setCertificateAlias((String) inst.get("certificateAlias"));
            outRecord.setContext((String) inst.get("context"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return outRecord;

    }

    @Then("I click on the Admin Menu Interfaces Interfaces")
    public void clickAdminInterfaces() {

        try{
            HomePage homePage = new HomePage(webDriver);
            homePage.clickOnInterfacesInterfacesMenuItem();

            Logging.stepName("Click On Admin > Interfaces > Interfaces Menu Item");

            if(interfacePage.isPageOpened()){
                Logging.passMessage("Logged in and on Interfaces Page");
            }
            else{
                Logging.failMessage("Not logged in and on Interfaces Page");
                softAssert.fail("Not logged in and on Interfaces Page");
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I check the interface required fields")
    public void checkRequiredFields(){

        try{

            adminCommon.clickAddButton();
            interfacePage.clickDetailCreateButton();

            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = interfacePage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

            interfacePage.clickDetailCancelButton();

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new interface")
    public void addInterface(){

        recordNewInterface = interfacePage.enterInterfaceData(recordNewInterface);

        if(recordNewInterface!=null) {

            Logging.stepName("Add Interface: Table Data Check");
            recordTableInterface = interfacePage.getTableDataById(recordNewInterface);
            System.out.println(recordTableInterface);
            System.out.println(recordNewInterface);
            checkRecords(recordNewInterface, recordTableInterface);

            Logging.stepName("Add Interface: Database Data Check");
            recordDBInterface = interfacePage.getDBDataById(recordNewInterface.getId());
            checkRecords(recordNewInterface, recordDBInterface);

        }
        else{
            Logging.stepName("Add Interface");
            softAssert.fail("Interface not added correctly.");
            Logging.failMessage("Interface not added correctly.");
        }


    }

    @Then("I edit an interface")
    public void editInterface(){

        try {

            boolean editSuccess;

            // Create the newly created data as data class
            recordEditInterface = recordNewInterface;

            for(String field :  editFields) {

                switch (field) {

                    /* Change the fields */
                    case ("keystorePath"):
                        recordEditInterface.setKeystorePath("/home/pojo/pinmanager/keys/.keystore");
                        break;

                    case ("certificateAlias"):
                        recordEditInterface.setCertificateAlias("wls");
                        break;

                    case ("context"):
                        recordEditInterface.setContext("PINAdviceConfirmServer/ApmRemoteService");
                        break;

                    case ("username"):
                        recordEditInterface.setUsername("wsuser");
                        break;

                }

                editSuccess = interfacePage.editInterfaceData(recordEditInterface,field);

                if(!editSuccess){
                    softAssert.fail("Edit Interface: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Interfaces: Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditInterface);
                }
                else {
                    Logging.stepName("Edit Interface: Table Data Check: " + field);
                    recordTableInterface = interfacePage.getTableDataById(recordEditInterface);
                    checkRecords(recordEditInterface, recordTableInterface);

                    Logging.stepName("Edit Interface: Database Data Check");
                    recordDBInterface = interfacePage.getDBDataById(recordEditInterface.getId());
                    checkRecords(recordEditInterface, recordDBInterface);
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void checkRecords(InterfaceDataRecord record1, InterfaceDataRecord record2) {

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

    @Then("I delete an interface")
    public void deleteInterface(){
        try {

            Logging.stepName("Delete Interface");

            // Delete the newly created issuer
            if(interfacePage.clickDeleteInterfaceById(recordNewInterface)) {

                Logging.stepName("Delete Interface: Table Deletion Check");
                recordTableInterface = interfacePage.getTableDataById(recordNewInterface);
                if (recordTableInterface.getId() != null) {
                    Logging.failMessage("Interface ID " + recordNewInterface.getId() + " still exists in the table.");
                    softAssert.fail("Interface ID " + recordNewInterface.getId() + " still exists in the table.");
                } else {
                    Logging.passMessage("Interface ID " + recordNewInterface.getId() + " deleted from table");
                }

                Logging.stepName("Delete Interface: Database Deletion Check");
                recordDBInterface = interfacePage.getDBDataById(recordNewInterface.getId());
                if (recordDBInterface.getId() != null) {
                    Logging.failMessage("Interface ID " + recordNewInterface.getId() + " still exists in the database.");
                    softAssert.fail("Interface " + recordNewInterface.getId() + " still exists in the database.");
                } else {
                    Logging.passMessage("Interface ID " + recordNewInterface.getId() + " deleted from database");
                }
            }
            else{
                Logging.failMessage("Deletion of Interface ID " + recordNewInterface.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Interface ID " + recordNewInterface.getId() + " failed in the GUI.");
            }


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }


    }

    @Then("Check Interface scenario")
    public void checkInterfaceScenario()  {
        softAssert.assertAll();
    }

}
