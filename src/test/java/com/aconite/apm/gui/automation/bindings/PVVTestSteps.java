package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.records.PVVDataRecord;
import com.aconite.apm.gui.automation.records.TokenApplicationProfileDataRecord;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import com.aconite.apm.gui.automation.webpages.PVVPage;
import com.aconite.apm.gui.automation.webpages.TokenApplicationProfilePage;
import com.aconite.apm.gui.automation.webpages.TokenProductsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import java.util.*;

public class PVVTestSteps {

    public WebDriver webDriver;
    public SoftAssert softAssert = new SoftAssert();

    TokenProductsPage tokenProductsPage;
    TokenApplicationProfilePage tokenApplicationProfilePage;
    AdminCommon adminCommon;
    PVVPage pvvPage;

    public TokenProductDataRecord recordNewTokenProduct = new TokenProductDataRecord();
    public TokenApplicationProfileDataRecord recordNewTokenApplicationProfile = new TokenApplicationProfileDataRecord();
    public PVVDataRecord recordNewPVV = new PVVDataRecord();
    public PVVDataRecord recordEditPVV = new PVVDataRecord();
    public PVVDataRecord recordDbPVV = new PVVDataRecord();
    public PVVDataRecord recordTablePVV = new PVVDataRecord();

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public PVVTestSteps(AbsractSteps absractSteps) {
        try {
            webDriver = absractSteps.getDriver();
            tokenProductsPage = new TokenProductsPage(webDriver);
            tokenApplicationProfilePage = new TokenApplicationProfilePage(webDriver);
            adminCommon = new AdminCommon(webDriver);
            pvvPage = new PVVPage(webDriver);

            reqFields.put("TokenProduct","Please Specify Name");
            reqFields.put("AppSequenceNumber","Please Specify App Seq Num");
            reqFields.put("PVKIdentifier","Please provide PVK Identifier");
            reqFields.put("PinVerificationMethod","Please specify a PIN verification method");
            reqFields.put("PinVerificationKey","Please specify a PIN verification key");

            editFields.add("PVKIdentifier");
            editFields.add("PinVerificationMethod");
            editFields.add("PinVerificationKey");


        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("I check the pvv required fields")
    public void checkRequiredFields(){

        // STARTING POINT: On Token Products Page - no other windows open
        // Create new token product
        recordNewTokenProduct.setParentInstitution("TestBank");
        recordNewTokenProduct.setParentIssuer("TestBank");
        adminCommon.searchInstitutionAndIssuer(recordNewTokenProduct.getParentInstitution(), recordNewTokenProduct.getParentIssuer());

        // Create a dummy data as data class
        recordNewTokenProduct.setName("TestBank_" + AdminCommon.getDateTime());
        recordNewTokenProduct.setIssuerTokenProductCode("TestBank_" + AdminCommon.getDateTime());
        recordNewTokenProduct.setIssuer("TestBank HK");
        recordNewTokenProduct.setTokenProductGroup("TestBank Diamond");
        recordNewTokenProduct.setRetentionDays("100");
        recordNewTokenProduct.setCountry("Guatemala");
        recordNewTokenProduct.setLanguage("SPA");
        recordNewTokenProduct.setPersoBureau("LastBank Setec");
        recordNewTokenProduct.setFeedbackRequired("true");
        recordNewTokenProduct.setActive("true");
        recordNewTokenProduct.setServiceCode("455");


        TokenProductDataRecord temp = tokenProductsPage.enterTokenProductCodeData(recordNewTokenProduct); // Pass record obj across
        recordNewTokenProduct.setId(temp.getId());

        //Search for the newly created token product
        adminCommon.searchInstitutionAndIssuer(recordNewTokenProduct.getParentInstitution(), recordNewTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordNewTokenProduct.getId());

        // Create the data for the parent token application profile
        //Enough data to get to check all the required fields
        // TODO: Think about where this data can be better placed
        recordNewTokenApplicationProfile.setParentInstitution("TestBank");
        recordNewTokenApplicationProfile.setParentIssuer("TestBank HK");
        recordNewTokenApplicationProfile.setName("TAP_" + AdminCommon.getDateTime());
        recordNewTokenApplicationProfile.setParentTokenProduct(recordNewTokenProduct.getName());
        recordNewTokenApplicationProfile.setParentTokenProductId(recordNewTokenProduct.getId());
        recordNewTokenApplicationProfile.setAppSequenceNumber("1");
        recordNewTokenApplicationProfile.setPinLength("4");
        recordNewTokenApplicationProfile.setValidityInDays("3");
        recordNewTokenApplicationProfile.setImportEncryptionZone("ABCBank Import");
        recordNewTokenApplicationProfile.setSmsEncryptionZone("ABCBank Export");
        recordNewTokenApplicationProfile.setPinMailerDelayHours("3");
       //recordNewTokenApplicationProfile.setImportGeneratePuk("Generate");
        recordNewTokenApplicationProfile.setPinVerificationKey("ABCBank PVK 1");
        recordNewTokenApplicationProfile.setPinTemplate("TestBank PIN template");
        recordNewTokenApplicationProfile.setPukTemplate("TestBank PUK template");
        recordNewTokenApplicationProfile.setPasswordTemplate("TestBank Password template");
        recordNewTokenApplicationProfile.setPinOverSMSDelayHours("2");
        recordNewTokenApplicationProfile.setSmsPasswordDelayHours("2");
        recordNewTokenApplicationProfile.setSmsSender("D");
        recordNewTokenApplicationProfile.setSmsValidityHours("2");
        recordNewTokenApplicationProfile.setSmsPasswordHours("2");
        recordNewTokenApplicationProfile.setSmsClass("Class 1 (normal)");

        tokenApplicationProfilePage.enterTokenApplicationProfileData(recordNewTokenApplicationProfile);

        //dbl click on the new token application profile
        tokenApplicationProfilePage.dblClickTokenApplicationProfileByName(recordNewTokenApplicationProfile.getName());

        //click the add pvv button
        pvvPage.clickAddPVV();

       // Click Create
        pvvPage.clickCreatePVV();

        //Check that all required fields have the correct error message
        for (String field : reqFields.keySet()){
            boolean rc = pvvPage.checkRequiredFieldMessages(field, reqFields.get(field));
            if(rc){
                Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
            } else {
                Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
            }
        }

        //Click cancel
        pvvPage.clickCancelPVV();

    }

    @Then ("I add a new pvv")
    public void addPvv()  {

        // Create the data for the new pvv
        recordNewPVV.setParentInstitution(recordNewTokenApplicationProfile.getParentInstitution());
        recordNewPVV.setParentIssuer(recordNewTokenApplicationProfile.getParentIssuer());
        recordNewPVV.setParentTokenProduct(recordNewTokenProduct.getName());
        recordNewPVV.setParentTokenProductId(recordNewTokenProduct.getId());
        recordNewPVV.setParentTokenApplicationProfileName(recordNewTokenApplicationProfile.getName());
        recordNewPVV.setParentTokenApplicationProfileAppSeqNum(recordNewTokenApplicationProfile.getAppSequenceNumber());
        recordNewPVV.setPvkIdentifier("PVV_" + AdminCommon.getDateTime());
        recordNewPVV.setPinVerificationMethod("CVV");
        recordNewPVV.setPinVerificationKey("LastBank PVK 1");

        recordNewPVV = pvvPage.enterPVVData(recordNewPVV);

        if(recordNewPVV != null){
            Logging.passMessage("PVV " + recordNewPVV.getPvkIdentifier() + " created successfully.");
        } else {
            Logging.failMessage("PVV creation failed.");
            softAssert.fail("PVV creation failed.");
        }

        recordEditPVV = pvvPage.getPVVRecordByPVKIdentifier(recordNewPVV);
        recordNewPVV.setId(recordEditPVV.getId());

    }

    @Then ("I edit an existing pvv")
    public void editPvv(){

        try{

            recordEditPVV = recordNewPVV;

            boolean editSuccess;

            for(String field :  editFields) {

                switch (field) {

                    case ("PVKIdentifier"):
                        recordEditPVV.setPvkIdentifier("PVV2_" + AdminCommon.getDateTime());
                        break;

                    case ("PinVerificationMethod"):
                        recordEditPVV.setPinVerificationMethod("Password comparison");
                        break;

                    case ("PinVerificationKey"):
                        recordEditPVV.setPinVerificationKey("ClearBank PVK 1");
                        break;

                }

                Logging.stepName("Edit PVV: " + field);
                editSuccess = pvvPage.editPVVData(recordEditPVV, field);
                if(!editSuccess){
                    softAssert.fail("Edit PVV: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit PVV: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditPVV);

                }
                else {

                    Logging.stepName("Edit PVV: Table Data Check: " + field);
                    recordTablePVV = pvvPage.getPVVRecordByPVKIdentifier(recordEditPVV);
                    checkTableRecords(recordEditPVV, recordTablePVV);

                    Logging.stepName("Edit PVV: Database Data Check: " + field);
                    recordDbPVV = pvvPage.getDBDataById(recordEditPVV.getId());
                    System.out.println("recordEditPVV = " + recordEditPVV);
                    System.out.println("recordDbPVV = " + recordDbPVV);
                    checkDBRecords(recordEditPVV, recordDbPVV);
                }

            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("I delete a pvv")
    public void deletePvv(){

        try{
            Logging.stepName("Delete PVV");

            if(pvvPage.deletePVV(recordEditPVV)){

                Logging.stepName("Delete PVV: Table Deletion Check");
                recordTablePVV = pvvPage.getPVVRecordByPVKIdentifier(recordEditPVV);
                if (recordTablePVV.getId()!=null){
                    Logging.failMessage("PVV Name " + recordEditPVV.getId() + " still exists in the table.");
                    softAssert.fail("PVV Name " + recordEditPVV.getId() + " still exists in the table.");
                }
                else{
                    Logging.passMessage("PVV Name " + recordEditPVV.getId() + " deleted from table");
                }

                Logging.stepName("Delete PVV: Database Deletion Check");
                recordDbPVV = pvvPage.getDBDataById(recordEditPVV.getId());
                if (recordDbPVV.getId()!=null){
                    Logging.failMessage("PVV ID " + recordEditPVV.getId() + " still exists in the database.");
                    softAssert.fail("PVV ID " + recordEditPVV.getId() + " still exists in the database.");
                }
                else{
                    Logging.passMessage("PVV ID " + recordEditPVV.getId() + " deleted from database");
                }


            }
            else{
                Logging.failMessage("Deletion of PVV ID " + recordEditPVV.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of PVV ID " + recordEditPVV.getId() + " failed in the GUI.");
            }


        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I delete the pvv parent application profile")
    public void deleteParentTokenApplicationProfile(){

        TokenApplicationProfileDataRecord recordDelTokenApplicationProfile = new TokenApplicationProfileDataRecord();
        recordDelTokenApplicationProfile.setParentInstitution(recordEditPVV.getParentInstitution());
        recordDelTokenApplicationProfile.setParentIssuer(recordEditPVV.getParentIssuer());
        recordDelTokenApplicationProfile.setName(recordEditPVV.getParentTokenApplicationProfileName());
        recordDelTokenApplicationProfile.setParentTokenProductId(recordEditPVV.getParentTokenProductId());
        recordDelTokenApplicationProfile.setName(recordEditPVV.getParentTokenApplicationProfileName());

        TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
        recordSearchTokenProduct.setParentInstitution(recordEditPVV.getParentInstitution());
        recordSearchTokenProduct.setParentIssuer(recordEditPVV.getParentIssuer());


        try{

            adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
            tokenProductsPage.dblClickTokenProductById(recordDelTokenApplicationProfile.getParentTokenProductId());
            tokenApplicationProfilePage.deleteTokenApplicationProfileByName(recordDelTokenApplicationProfile);

        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("I delete the pvv parent token product")
    public void deleteParentTokenProduct(){

        TokenProductDataRecord recordDelTokenProduct = new TokenProductDataRecord();
        recordDelTokenProduct.setParentInstitution(recordEditPVV.getParentInstitution());
        recordDelTokenProduct.setParentIssuer(recordEditPVV.getParentIssuer());
        recordDelTokenProduct.setId(recordEditPVV.getParentTokenProductId());

        try{

            adminCommon.searchInstitutionAndIssuer(recordDelTokenProduct.getParentInstitution(), recordDelTokenProduct.getParentIssuer());
            tokenProductsPage.clickDeleteTokenProductById(recordDelTokenProduct);

        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("Check pvv scenario")
    public void checkPvvScenario() {
        softAssert.assertAll();
    }

    public void checkTableRecords(PVVDataRecord record1, PVVDataRecord record2) {

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
        if (record1.toString().equals(record2.toString())) {
            Logging.passMessage("Record data matches:" +
                    "\nRecord 1 Data = " + record1 +
                    "\nRecord 2 Data = " + record2);
        }
        else{

            String[] rec1 = record1.toString().split(", ");
            String[] rec2 = record2.toString().split(", ");

            for(int i=0;i<rec1.length;i++){

                if(!rec1[i].equals(rec2[i])){
                    Logging.failMessage("Record field does not match:" +
                            "\nRecord 1 Data = " + rec1[i] +
                            "\nRecord 2 Data = " + rec2[i]);
                    softAssert.fail("Record data does not match:" +
                            "\nRecord 1 Data = " + rec1[i] +
                            "\nRecord 2 Data = " + rec2[i]);
                }

            }

        }
    }

    public void checkDBRecords(PVVDataRecord record1, PVVDataRecord record2) {

        System.out.println("IN CHECK DB RECORDS");
        System.out.println("record1 = " + record1);
        System.out.println("record2 = " + record2);
        System.out.println("== = " + (record1==record2));
        System.out.println("record2 = " + record1.equals(record2));


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
            System.out.println("IN DB RECORDS ARE EQUAL");
            Logging.passMessage("Record data matches:" +
                    "\nRecord 1 Data = " + record1 +
                    "\nRecord 2 Data = " + record2);
        }
        else{
            System.out.println("IN DB RECORDS ARE NOT EQUAL");
            String[] rec1 = record1.toString().split(", ");
            String[] rec2 = record2.toString().split(", ");

            for(int i=0;i<rec1.length;i++){

                if(!rec1[i].equals(rec2[i])){
                    Logging.failMessage("Record field does not match:" +
                            "\nRecord 1 Data = " + rec1[i] +
                            "\nRecord 2 Data = " + rec2[i]);
                    softAssert.fail("Record data does not match:" +
                            "\nRecord 1 Data = " + rec1[i] +
                            "\nRecord 2 Data = " + rec2[i]);
                }

            }

        }
    }


}
