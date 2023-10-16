package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.LoginPage;
import com.aconite.apm.gui.automation.webpages.TokenProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TokenProductTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    private TokenProductsPage tokenProductsPage;
    private AbsractSteps absractSteps;
    AdminCommon adminCommon;

    public TokenProductDataRecord recordNewTokenProduct = new TokenProductDataRecord();
    public TokenProductDataRecord recordEditTokenProduct = new TokenProductDataRecord();
    public TokenProductDataRecord recordTableTokenProduct = new TokenProductDataRecord();
    public TokenProductDataRecord recordDbTokenProduct = new TokenProductDataRecord();

    List<String> editFields = new ArrayList<>();
    HashMap<String, String> reqFields = new HashMap<>();

    public TokenProductTestSteps(AbsractSteps absractSteps) {
        try {
            this.absractSteps = absractSteps;
            webDriver = absractSteps.getDriver();
            tokenProductsPage = new TokenProductsPage(webDriver);
            adminCommon = new AdminCommon(webDriver);

            reqFields.put("Name","Please specify a name");
            reqFields.put("IssuerTokenProductCode","Please specify an issuer token product code");
            //reqFields.put("Issuer","Please specify an issuer"); // PMV-2423
            reqFields.put("TokenProductGroup","Please specify a token product group");
            reqFields.put("Country","Please specify a country");
            reqFields.put("Language","Please specify a language");
            reqFields.put("PersoBureau","Please specify a perso bureau");

            editFields.add("Name");
            editFields.add("IssuerTokenProductCode");
            //editFields.add("Issuer"); Removed
            editFields.add("TokenProductGroup");
            editFields.add("RetentionDays");
            editFields.add("Country");
            editFields.add("Language");
            editFields.add("PersoBureau");
            editFields.add("FeedbackRequired");
            editFields.add("Active");
            editFields.add("ServiceCode");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Given("I am logged in")
    public void i_am_logged_in() {

        try {

            System.out.println("About to create Login. WebDriver is: " + webDriver);
            LoginPage loginPage = new LoginPage(absractSteps.getBaseUrl(), webDriver);
            System.out.println("About to Login: " + absractSteps.getUsername() + "/" + absractSteps.getPassword());
            loginPage.login(absractSteps.getUsername(), absractSteps.getPassword());

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I click on the Admin Menu Token Products")
    public void clickAdminTokenProducts() {

        try {
            HomePage homePage = new HomePage(absractSteps.getDriver());
            homePage.clickOnAdminTokenProductsMenuItem();

            if (tokenProductsPage.isPageOpened()) {
                Logging.passMessage("Logged in and on Token Products Page");
            } else {
                Logging.failMessage("Not logged in and on Token Products Page");
                softAssert.fail("Not logged in and on Token Products Page");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I check the token product required fields")
    public void checkRequiredFields(){

        try{

            recordNewTokenProduct.setParentInstitution("TestBank");
            recordNewTokenProduct.setParentIssuer("TestBank HK");
            adminCommon.searchInstitutionAndIssuer(recordNewTokenProduct.getParentInstitution(), recordNewTokenProduct.getParentIssuer());

            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            adminCommon.clickAddButton();
            tokenProductsPage.clickDetailCreateButton();


            //Check that all required fields have the correct error message
            for (String field : reqFields.keySet()){
                boolean rc = tokenProductsPage.checkRequiredFieldMessages(field, reqFields.get(field));
                if(rc){
                    Logging.passMessage(field + " object contains correct error message: " + reqFields.get(field));
                } else {
                    Logging.failMessage(field + " object does not contain correct error message: " + reqFields.get(field));
                    softAssert.fail(field + " object does not contain correct error message: " + reqFields.get(field));
                }
            }

//            tokenProductsPage.clickDetailCancelButton();


        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I add a new token product")
    public void addTokenProduct(){

        try {

            recordNewTokenProduct.setParentInstitution("TestBank");
            recordNewTokenProduct.setParentIssuer("TestBank HK");
            adminCommon.searchInstitutionAndIssuer(recordNewTokenProduct.getParentInstitution(), recordNewTokenProduct.getParentIssuer());

            // Create a dummy data as data class
            recordNewTokenProduct.setName("TestBank_" + AdminCommon.getDateTime());
            recordNewTokenProduct.setIssuerTokenProductCode("TestBank_" + AdminCommon.getDateTime());
            recordNewTokenProduct.setIssuer("TestBank HK");
            recordNewTokenProduct.setTokenProductGroup("TestBank Diamond");
            recordNewTokenProduct.setRetentionDays("90");
            recordNewTokenProduct.setCountry("France");
            recordNewTokenProduct.setLanguage("FRA");
            recordNewTokenProduct.setPersoBureau("Gemalto");
            recordNewTokenProduct.setFeedbackRequired("true");
            recordNewTokenProduct.setActive("true");
            recordNewTokenProduct.setServiceCode("");

            // Enter Details and create
            TokenProductDataRecord temp = tokenProductsPage.enterTokenProductCodeData(recordNewTokenProduct);

            if (temp != null) {

                recordNewTokenProduct.setId(temp.getId());
                Logging.stepName("Add Token Product: Table Data Check");
                recordTableTokenProduct = tokenProductsPage.getTableDataById(recordNewTokenProduct);
                checkTableRecords(recordNewTokenProduct, recordTableTokenProduct);

                Logging.stepName("Add Token Product: Database Data Check");
                recordDbTokenProduct = tokenProductsPage.getDBDataById(recordNewTokenProduct.getId());
                checkRecords(recordNewTokenProduct, recordDbTokenProduct);

            }
            else{
                Logging.stepName("Add Token Product");
                softAssert.fail("Token Product not added correctly.");
                Logging.failMessage("Token Product not added correctly.");
            }


        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    @Then("I edit an existing token product")
    public void editTokenProduct(){

        try{
            boolean editSuccess;

            recordEditTokenProduct = recordNewTokenProduct;
            recordEditTokenProduct.setParentInstitution("TestBank");
            recordEditTokenProduct.setParentIssuer("TestBank");
            adminCommon.searchInstitutionAndIssuer(recordEditTokenProduct.getParentInstitution(),recordEditTokenProduct.getParentIssuer());

            System.out.println("Number of edit fields: " + editFields.size());

            for(String field :  editFields) {

                switch (field) {

                    case ("Name"):
                        recordEditTokenProduct.setName("TestBank_" + AdminCommon.getDateTime());
                        break;

                    case("IssuerTokenProductCode"):
                        recordEditTokenProduct.setIssuerTokenProductCode("TestBank_" + AdminCommon.getDateTime());
                        break;

                    case("Issuer"):
                        recordEditTokenProduct.setIssuer("TestBank UK");
                        break;

                    case("TokenProductGroup"):
                        recordEditTokenProduct.setTokenProductGroup("TestBank Sapphire");
                        break;

                    case("RetentionDays"):
                        recordEditTokenProduct.setRetentionDays("300");
                        break;

                    case("Country"):
                        recordEditTokenProduct.setCountry("Antigua and Barbuda");
                        break;

                    case("Language"):
                        recordEditTokenProduct.setLanguage("AYM");
                        break;

                    case("PersoBureau"):
                        recordEditTokenProduct.setPersoBureau("Card USA");
                        break;

                    case("FeedbackRequired"):
                        recordEditTokenProduct.setFeedbackRequired("false");
                        break;

                    case("Active"):
                        recordEditTokenProduct.setActive("false");
                        break;

                    case("ServiceCode"):
                        recordEditTokenProduct.setServiceCode("321");
                        break;

                }

                editSuccess = tokenProductsPage.editTokenProductCodeData(recordEditTokenProduct, field);
                if(!editSuccess){
                    softAssert.fail("Edit Token Product: Data change was unsuccessful - Either data value was not different or object did not trigger a change.");
                    Logging.failMessage("Edit Token Product: Database Data Check: " + field +
                            "\nData change was unsuccessful - Either data value was not different or object did not trigger a change." +
                            "\nExpected values: " + recordEditTokenProduct);
                }
                else {

                    if(field.equals("Issuer")) {
                        recordEditTokenProduct.setParentIssuer("TestBank2");
                        adminCommon.searchInstitutionAndIssuer(recordEditTokenProduct.getParentInstitution(), recordEditTokenProduct.getParentIssuer());
                        tokenProductsPage.clickTokenProductRefresh();
                    }

                    Logging.stepName("Edit Token Product: Table Data Check: " + field);
                    recordTableTokenProduct = tokenProductsPage.getTableDataById(recordEditTokenProduct);
                    checkTableRecords(recordEditTokenProduct, recordTableTokenProduct);

                    Logging.stepName("Edit Token Product: Database Data Check: " + field);
                    recordDbTokenProduct = tokenProductsPage.getDBDataById(recordEditTokenProduct.getId());
                    checkRecords(recordEditTokenProduct, recordDbTokenProduct);

//                    if (field.equals("Issuer")) {
//                        recordEditTokenProduct.setParentIssuer("TestBank2");
//                    }
                }


            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I delete a token product")
    public void deleteTokenProduct(){

        try{

            Logging.stepName("Delete Token Product");

            if(tokenProductsPage.clickDeleteTokenProductById(recordEditTokenProduct)){

                Logging.stepName("Delete Token Product: Table Deletion Check");
                recordTableTokenProduct = tokenProductsPage.getTableDataById(recordEditTokenProduct);
                if (recordTableTokenProduct.getId()!=null){
                    Logging.failMessage("Token Product ID " + recordEditTokenProduct.getId() + " still exists in the table.");
                    softAssert.fail("Token Product ID " + recordEditTokenProduct.getId() + " still exists in the table.");
                }
                else{
                    Logging.passMessage("Token Product ID " + recordEditTokenProduct.getId() + " deleted from table");
                }

                Logging.stepName("Delete Token Product: Database Deletion Check");
                recordDbTokenProduct = tokenProductsPage.getDBDataById(recordEditTokenProduct.getId());
                if (recordDbTokenProduct.getId()!=null){
                    Logging.failMessage("Token Product ID " + recordEditTokenProduct.getId() + " still exists in the database.");
                    softAssert.fail("Token Product ID " + recordEditTokenProduct.getId() + " still exists in the database.");
                }
                else{
                    Logging.passMessage("Token Product ID " + recordEditTokenProduct.getId() + " deleted from database");
                }

            }
            else{
                Logging.failMessage("Deletion of Token Product ID " + recordEditTokenProduct.getId() + " failed in the GUI.");
                softAssert.fail("Deletion of Token Product ID " + recordEditTokenProduct.getId() + " failed in the GUI.");
            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void checkRecords(TokenProductDataRecord record1, TokenProductDataRecord record2) {

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

    public void checkTableRecords(TokenProductDataRecord record1, TokenProductDataRecord record2) {

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

    @Then("Check token product scenario")
    public void checkTokenProductScenario() {
        softAssert.assertAll();
    }


}