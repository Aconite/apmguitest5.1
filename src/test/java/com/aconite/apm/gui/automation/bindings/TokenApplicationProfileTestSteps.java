package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import com.aconite.apm.gui.automation.records.TokenApplicationProfileDataRecord;
import com.aconite.apm.gui.automation.webpages.TokenProductsPage;
import com.aconite.apm.gui.automation.webpages.TokenApplicationProfilePage;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TokenApplicationProfileTestSteps {

    public WebDriver webDriver;
    public SoftAssert softAssert = new SoftAssert();

    TokenProductsPage tokenProductsPage;
    TokenApplicationProfilePage tokenApplicationProfilePage;
    AdminCommon adminCommon;


    public TokenProductDataRecord recordNewTokenProduct = new TokenProductDataRecord();
    public TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
    public TokenApplicationProfileDataRecord recordNewTokenApplicationProfile = new TokenApplicationProfileDataRecord();
    public TokenApplicationProfileDataRecord recordEditTokenApplicationProfile = new TokenApplicationProfileDataRecord();
    public TokenApplicationProfileDataRecord recordTableTokenApplicationProfile = new TokenApplicationProfileDataRecord();
    public TokenApplicationProfileDataRecord recordDbTokenApplicationProfile = new TokenApplicationProfileDataRecord();

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public TokenApplicationProfileTestSteps(AbsractSteps absractSteps) {
        try {

            webDriver = absractSteps.getDriver();
            tokenProductsPage = new TokenProductsPage(webDriver);
            tokenApplicationProfilePage = new TokenApplicationProfilePage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Please specify a name");
            reqFields.put("TokenProductCode","Please select a token product");
            reqFields.put("AppSequenceNumber","Please specify an application sequence number");
            reqFields.put("PinLength","Please specify a PIN length");
//            reqFields.put("ValidityInDays","Please specify validity in days");
            reqFields.put("ImportEncryptionZone","Please specify an import encryption zone");
            reqFields.put("SmsEncryptionZone","Please specify an SMS encryption zone");
            reqFields.put("PinMailerDelayHours","Please specify the number of hours for which sending PIN mailers is delayed");
            //reqFields.put("ImportGeneratePuk","Please specify an import generate PUK");
            reqFields.put("PinVerificationKey","Please specify a PIN verification key");
            reqFields.put("PinTemplate","Please specify a template");
            reqFields.put("PukTemplate","Please specify a template");
            reqFields.put("PasswordTemplate","Please specify a template");
            reqFields.put("PinOverSMSDelayHours","Please specify the number of hours for which sending SMSs is delayed");
            reqFields.put("SmsPasswordDelayHours","Please specify the number of hours for which sending passwords is delayed");
            reqFields.put("SmsSender","Please specify an SMS sender");
            reqFields.put("SmsValidityHours","Please specify the number of hours for which an SMS is valid");
            reqFields.put("SmsPasswordHours","Please specify the number of hours for which an SMS password is valid");
            reqFields.put("SmsClass","Please specify an SMS class");

            editFields.add("Status");
            editFields.add("DefaultApp");
            editFields.add("PinRequired");
            editFields.add("PinLength");
//            editFields.add("ValidityInDays");
            editFields.add("ImportEncryptionZone");
            editFields.add("SmsInterface");
            editFields.add("SmsEncryptionZone");
            editFields.add("ReturnInterface");
            // editFields.add("PINDeliveryMethod");
            editFields.add("PinMailerDelayHours");
            editFields.add("PinHeldBySeqNum");
            editFields.add("AllowPinChange");
            editFields.add("AllowOnlinePinChange");
            editFields.add("AllowOnlinePinView");
            editFields.add("PukRequired");
            // editFields.add("PukLength");
            editFields.add("AllowPukChange");
            editFields.add("PukHeldBySeqNum");
            //editFields.add("ImportGeneratePuk"); //Unable to change - PMV-2237
            editFields.add("PinVerificationMethod");
            editFields.add("PinVerificationKey");
            editFields.add("PinTries");
            editFields.add("VerificationBackoff");
            editFields.add("BackoffMultiplier");
            editFields.add("TokenImportPinDeliveryMethod");
            editFields.add("TokenImportOutputInterface");
            editFields.add("TokenOrderPinDeliveryMethod");
            editFields.add("ForceTokenOrderPinDelivery");
            editFields.add("TokenOutputInterface");
            editFields.add("PinAdvicePinDeliveryMethod");
            editFields.add("ForcePinAdvicePinDelivery");
            editFields.add("PinAdviceOutputInterface");
            editFields.add("UpdatePinDeliveryMethod");
            editFields.add("UpdateInterface");
            editFields.add("VppPinDeliveryMethod");
            editFields.add("VppInterface");
            editFields.add("PinTemplate");
            editFields.add("SecondaryPinTemplate");
            editFields.add("PukTemplate");
            editFields.add("PasswordTemplate");
            editFields.add("MessageTemplate");
            editFields.add("PinOverSMSDelayHours");
            editFields.add("SmsPasswordDelayHours");
            editFields.add("SmsSender");
            editFields.add("SmsValidityHours");
            editFields.add("SmsPasswordHours");
            editFields.add("SmsClass");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("I check the Token Application Profile required fields")
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
        recordNewTokenProduct.setTokenProductGroup("TestBank Sapphire");
        recordNewTokenProduct.setRetentionDays("90");
        recordNewTokenProduct.setCountry("France");
        recordNewTokenProduct.setLanguage("FRA");
        recordNewTokenProduct.setPersoBureau("Gemalto");
        recordNewTokenProduct.setFeedbackRequired("true");
        recordNewTokenProduct.setActive("true");
        recordNewTokenProduct.setServiceCode("767");

        TokenProductDataRecord temp = tokenProductsPage.enterTokenProductCodeData(recordNewTokenProduct);
        recordNewTokenProduct.setId(temp.getId());

        //Search for the newly created token product
        adminCommon.searchInstitutionAndIssuer(recordNewTokenProduct.getParentInstitution(), recordNewTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordNewTokenProduct.getId());

        // Open Token App Profiles Detail window
        tokenApplicationProfilePage.clickAddTokenApplication();

        // Click create
        tokenApplicationProfilePage.clickCreateTokenApplication();

        //Check that all required fields have the correct error message
        for (String field : reqFields.keySet()){
            boolean rc = tokenApplicationProfilePage.checkRequiredFieldMessages(field, reqFields.get(field));
            if(rc){
                Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
            } else {
                Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
            }
        }

        //Click cancel
        tokenApplicationProfilePage.clickCancelTokenApplication();

    }

    @Then ("I add a new token application profile")
    public void addTokenApplicationProfile(){

        //Enough data to get to check all the required fields
        // TODO: Think about where this data can be better placed
        recordNewTokenApplicationProfile.setParentInstitution("TestBank");
        recordNewTokenApplicationProfile.setParentIssuer("TestBank HK");
        recordNewTokenApplicationProfile.setName("TAP_" + AdminCommon.getDateTime());
        recordNewTokenApplicationProfile.setParentTokenProduct(recordNewTokenProduct.getName());
        recordNewTokenApplicationProfile.setParentTokenProductId(recordNewTokenProduct.getId());
        recordNewTokenApplicationProfile.setAppSequenceNumber("2");
        recordNewTokenApplicationProfile.setStatus("Inactive");
        recordNewTokenApplicationProfile.setPinLength("4");
//        recordNewTokenApplicationProfile.setValidityInDays("3");
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

        // Search for the parent token product
        recordSearchTokenProduct.setParentInstitution(recordNewTokenApplicationProfile.getParentInstitution());
        recordSearchTokenProduct.setParentIssuer(recordNewTokenApplicationProfile.getParentIssuer());
        recordSearchTokenProduct.setId(recordNewTokenApplicationProfile.getParentTokenProductId());
        adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordSearchTokenProduct.getId());

        TokenApplicationProfileDataRecord temp = tokenApplicationProfilePage.enterTokenApplicationProfileData(recordNewTokenApplicationProfile);

        if(temp != null){

            Logging.stepName("Add Token Application Profile: Table Data Check");
            recordTableTokenApplicationProfile = tokenApplicationProfilePage.getTableDataByName(recordNewTokenApplicationProfile);
            checkTableRecords(recordNewTokenApplicationProfile, recordTableTokenApplicationProfile);

            Logging.stepName("Add Token Application Profile: Database Data Check");
            recordDbTokenApplicationProfile = tokenApplicationProfilePage.getDBDataByName(recordNewTokenApplicationProfile.getName());
            checkRecords(recordNewTokenApplicationProfile, recordDbTokenApplicationProfile);


        }
        else{
            Logging.stepName("Add Token Application Profile");
            softAssert.fail("Token Application Profile not added correctly.");
            Logging.failMessage("Token Application Profile not added correctly.");
        }

    }

    @Then ("I edit an existing token application profile")
    public void editTokenApplicationProfile(){

        recordEditTokenApplicationProfile = recordNewTokenApplicationProfile;
        boolean editSuccess;

        try{


            for(String field :  editFields) {

                switch (field) {

                    /* Currently, not done - name and token product code used to id token application profile */
                    case ("Name"):
                        recordEditTokenApplicationProfile.setName("TAP" + AdminCommon.getDateTime());
                        break;

                    /* Currently, not done - name and token product code used to id token application profile */
                    case ("TokenProductCode"):
                        recordEditTokenApplicationProfile.setParentTokenProduct("TestBank Sapphire");
                        recordEditTokenApplicationProfile.setParentTokenProductId("81");
                        break;

                    /* Not editable */
                    case ("AppSequenceNumber"):
                        recordEditTokenApplicationProfile.setAppSequenceNumber("4");
                        break;

                    case ("Status"):
                        recordEditTokenApplicationProfile.setStatus("Active");
                        break;

                    case ("DefaultApp"):
                        recordEditTokenApplicationProfile.setDefaultApp("true");
                        break;

                    case ("PinRequired"):
                        recordEditTokenApplicationProfile.setPinRequired("true");
                        break;

                    case ("PinLength"):
                        recordEditTokenApplicationProfile.setPinLength("6");
                        break;

                    case ("ImportEncryptionZone"):
                        recordEditTokenApplicationProfile.setImportEncryptionZone("LastBank Import");
                        break;

                    case ("SmsInterface"):
                        recordEditTokenApplicationProfile.setSmsInterface("ClearBank PDG");
                        break;

                    case ("SmsEncryptionZone"):
                        recordEditTokenApplicationProfile.setSmsEncryptionZone("LastBank Export");
                        break;

                    case ("ReturnInterface"):
                        recordEditTokenApplicationProfile.setReturnInterface("ClearBank Return interface");
                        break;

                    case ("PINDeliveryMethod"):
                        recordEditTokenApplicationProfile.setPinDeliveryMethod("PIN over SMS");
                        break;

                    case ("PinMailerDelayHours"):
                        recordEditTokenApplicationProfile.setPinMailerDelayHours("12");
                        break;

                    case ("PinHeldBySeqNum"):
                        recordEditTokenApplicationProfile.setPinHeldBySeqNum("1");
                        break;

                    case ("AllowPinChange"):
                        recordEditTokenApplicationProfile.setAllowPinChange("true");
                        break;

                    case ("AllowOnlinePinChange"):
                        recordEditTokenApplicationProfile.setAllowOnlinePinChange("true");
                        break;

                    case ("AllowOnlinePinView"):
                        recordEditTokenApplicationProfile.setAllowOnlinePinView("true");
                        break;

                    case ("PukRequired"):
                        recordEditTokenApplicationProfile.setPukRequired("true");
                        recordEditTokenApplicationProfile.setPukLength("4");
                        break;

                    case ("PukLength"):
                        recordEditTokenApplicationProfile.setPukLength("6");
                        break;


                    case ("AllowPukChange"):
                        recordEditTokenApplicationProfile.setAllowPukChange("true");
                        break;

                    case ("PukHeldBySeqNum"):
                        recordEditTokenApplicationProfile.setPukHeldBySeqNum("6");
                        break;

                    case ("ImportGeneratePuk"):
                        recordEditTokenApplicationProfile.setImportGeneratePuk("Import");
                        break;

                    case ("PinVerificationMethod"):
                        recordEditTokenApplicationProfile.setPinVerificationMethod("CVV");
                        break;

                    case ("PinVerificationKey"):
                        recordEditTokenApplicationProfile.setPinVerificationKey("ClearBank PVK 1");
                        break;

                    case ("PinTries"):
                        recordEditTokenApplicationProfile.setPinTries("3");
                        break;

                    case ("VerificationBackoff"):
                        recordEditTokenApplicationProfile.setVerificationBackoff("3");
                        break;

                    case ("BackoffMultiplier"):
                        recordEditTokenApplicationProfile.setBackoffMultiplier("2");
                        break;

                    case ("TokenImportPinDeliveryMethod"):
                        recordEditTokenApplicationProfile.setTokenImportPinDeliveryMethod("Message");
                        break;

                    case ("TokenImportOutputInterface"):
                        recordEditTokenApplicationProfile.setTokenImportOutputInterface("ClearBank Message interface");
                        break;

                    case ("TokenOrderPinDeliveryMethod"):
                        recordEditTokenApplicationProfile.setTokenOrderPinDeliveryMethod("Message");
                        break;

                    case ("ForceTokenOrderPinDelivery"):
                        recordEditTokenApplicationProfile.setForceTokenOrderPinDelivery("true");
                        break;

                    case ("TokenOutputInterface"):
                        recordEditTokenApplicationProfile.setTokenOutputInterface("ClearBank Message interface");
                        break;

                    case ("PinAdvicePinDeliveryMethod"):
                        recordEditTokenApplicationProfile.setPinAdvicePinDeliveryMethod("Message");
                        break;

                    case ("ForcePinAdvicePinDelivery"):
                        recordEditTokenApplicationProfile.setForcePinAdvicePinDelivery("true");
                        break;

                    case ("PinAdviceOutputInterface"):
                        recordEditTokenApplicationProfile.setPinAdviceOutputInterface("ClearBank Message interface");
                        break;

                    case ("UpdatePinDeliveryMethod"):
                        recordEditTokenApplicationProfile.setUpdatePinDeliveryMethod("Message");
                        break;

                    case ("UpdateInterface"):
                        recordEditTokenApplicationProfile.setUpdateInterface("ClearBank Return interface");
                        break;

                    case ("VppPinDeliveryMethod"):
                        recordEditTokenApplicationProfile.setVppPinDeliveryMethod("Message");
                        break;

                    case ("VppInterface"):
                        recordEditTokenApplicationProfile.setVppInterface("ClearBank Return interface");
                        break;

                    case ("PinTemplate"):
                        recordEditTokenApplicationProfile.setPinTemplate("TestBank PIN template 2");
                        break;

                    case ("SecondaryPinTemplate"):
                        recordEditTokenApplicationProfile.setSecondaryPinTemplate("TestBank PIN template");
                        break;

                    case ("PukTemplate"):
                        recordEditTokenApplicationProfile.setPukTemplate("TestBank PUK template 2");
                        break;

                    case ("PasswordTemplate"):
                        recordEditTokenApplicationProfile.setPasswordTemplate("TestBank Password template 2");
                        break;

                    case ("MessageTemplate"):
                        recordEditTokenApplicationProfile.setMessageTemplate("TestBank Message Template");
                        break;

                    case ("PinOverSMSDelayHours"):
                        recordEditTokenApplicationProfile.setPinOverSMSDelayHours("4");
                        break;

                    case ("SmsPasswordDelayHours"):
                        recordEditTokenApplicationProfile.setSmsPasswordDelayHours("4");
                        break;

                    case ("SmsSender"):
                        recordEditTokenApplicationProfile.setSmsSender("SMS Sender");
                        break;

                    case ("SmsValidityHours"):
                        recordEditTokenApplicationProfile.setSmsValidityHours("6");
                        break;

                    case ("SmsPasswordHours"):
                        recordEditTokenApplicationProfile.setSmsPasswordHours("8");
                        break;

                    case ("SmsClass"):
                        recordEditTokenApplicationProfile.setSmsClass("Class 0 (flash)");
                        break;

                }

                editSuccess = tokenApplicationProfilePage.editTokenApplicationProfileData(recordEditTokenApplicationProfile, field);
                if(!editSuccess){
                    Logging.failMessage("Edit Token Application Profile: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change.");
                }
                else {
                    Logging.stepName("Edit Token Application Profile: Database Data Check: " + field);
                    recordDbTokenApplicationProfile = tokenApplicationProfilePage.getDBDataByName(recordEditTokenApplicationProfile.getName());
                    checkRecords(recordEditTokenApplicationProfile, recordDbTokenApplicationProfile);

                    Logging.stepName("Edit Token Application Profile: Table Data Check: " + field);
                    recordTableTokenApplicationProfile = tokenApplicationProfilePage.getTableDataByName(recordEditTokenApplicationProfile);
                    checkTableRecords(recordEditTokenApplicationProfile, recordTableTokenApplicationProfile);

                }

            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("I delete a token application profile")
    public void deleteTokenApplicationProfile(){

        try{
            Logging.stepName("Delete Token Application Profile");

            if(tokenApplicationProfilePage.deleteTokenApplicationProfileByName(recordEditTokenApplicationProfile)){

                //Seems to need a refresh
                tokenApplicationProfilePage.refreshTokenApplicationProfileTable();
                adminCommon.sleep(1000);

                Logging.stepName("Delete Token Application Profile: Table Deletion Check");
                recordTableTokenApplicationProfile = new TokenApplicationProfileDataRecord();
                recordTableTokenApplicationProfile = tokenApplicationProfilePage.getTableDataByName(recordEditTokenApplicationProfile);
                System.out.println("TAP NAME in table >" + recordTableTokenApplicationProfile.getName() + "<");
                if (recordTableTokenApplicationProfile.getName()!=null){
                    Logging.failMessage("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " still exists in the table.");
                    softAssert.fail("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " still exists in the table.");
                }
                else{
                    Logging.passMessage("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " deleted from table");
                }

                Logging.stepName("Delete Token Application Profile: Database Deletion Check");
                recordDbTokenApplicationProfile = tokenApplicationProfilePage.getDBDataByName(recordEditTokenApplicationProfile.getName());
                if (recordDbTokenApplicationProfile.getName()!=null){
                    Logging.failMessage("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " still exists in the database.");
                    softAssert.fail("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " still exists in the database.");
                }
                else{
                    Logging.passMessage("Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " failed in the GUI.");
                softAssert.fail("Deletion of Token Application Profile Name " + recordEditTokenApplicationProfile.getName() + " failed in the GUI.");
            }


        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then ("I delete the parent token product")
    public void deleteParentTokenProduct(){

        TokenProductDataRecord recordDbTokenProduct;

        try{

            adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
            tokenProductsPage.clickDeleteTokenProductById(recordSearchTokenProduct);


            Logging.stepName("Delete Parent Token Product: Database Deletion Check");
            recordDbTokenProduct = tokenProductsPage.getDBDataById(recordSearchTokenProduct.getId());
            if (recordDbTokenProduct.getId()!=null){
                Logging.failMessage("Parent Token Product ID " + recordSearchTokenProduct.getId() + " still exists in the database.");
                softAssert.fail("Parent Token Product ID " + recordSearchTokenProduct.getId() + " still exists in the database.");
            }
            else{
                Logging.passMessage("Parent Token Product ID " + recordSearchTokenProduct.getId() + " deleted from database");
            }


        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then ("Check token application profile scenario")
    public void checkTokenApplicationProfileScenario() {
        softAssert.assertAll();
    }

    public void checkRecords(TokenApplicationProfileDataRecord record1, TokenApplicationProfileDataRecord record2) {

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
        if (record1.equalsAllFields(record2)) {
            Logging.passMessage("Record data matches:" +
                    "\nRecord 1 Data = " + record1 +
                    "\nRecord 2 Data = " + record2);
        }
        else{

            String[] rec1 = record1.toStringAllFields().split(", ");
            String[] rec2 = record2.toStringAllFields().split(", ");

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

    public void checkTableRecords(TokenApplicationProfileDataRecord record1, TokenApplicationProfileDataRecord record2) {

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

    
}
