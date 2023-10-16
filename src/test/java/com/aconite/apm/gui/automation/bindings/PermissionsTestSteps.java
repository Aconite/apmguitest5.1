package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.AdminCommon;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.TokenProductGroupsPage;
import com.aconite.apm.gui.automation.webpages.TokenProductsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PermissionsTestSteps {

    public WebDriver webDriver = null;
    public SoftAssert softAssert = new SoftAssert();

    AbsractSteps absractSteps;
    AdminCommon adminCommon;

    TokenProductsPage tokenProductsPage;
    TokenProductGroupsPage tokenProductGroupsPage;
    HomePage homePage;

    public PermissionsTestSteps(AbsractSteps absractSteps) {
        try {
            this.absractSteps = absractSteps;
            webDriver = absractSteps.getDriver();
            adminCommon = new AdminCommon(webDriver);

            tokenProductsPage = new TokenProductsPage(webDriver);
            tokenProductGroupsPage = new TokenProductGroupsPage(webDriver);
            homePage = new HomePage(webDriver);

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    @Then("I check the menu for \"([^\"]*)\"$")
    public void checkMenuForGetUser(String userId){

        List<String> opts = homePage.getMenuOptions();
        System.out.println("Options: " + opts);
        String menuText = "";
        int menuOpt=0;

        switch(userId){

            case "admin_tpg_g":
            case "admin_tpg_s":
                menuText = "Token Product Groups";
                menuOpt=1;
                break;

            case "admin_ins_g":
            case "admin_ins_s":
                menuText = "Institutions";
                menuOpt=1;
                break;

            case "admin_iss_g":
            case "admin_iss_s":
                menuText = "Issuers";
                menuOpt=1;
                break;

            case "admin_sch_g":
            case "admin_sch_s":
                menuText = "Task Scheduler";
                menuOpt=1;
                break;

            case "admin_int_g":
            case "admin_int_s":
                menuText = "Interfaces";
                menuOpt=2;
                break;

            case "admin_pbu_g":
            case "admin_pbu_s":
                menuText = "Personalisation Bureaus";
                menuOpt=2;
                break;
        }

        if(opts.get(menuOpt).equals(menuText)){
            Logging.passMessage("Correct Menu Options: " + opts);
        }
        else{
            Logging.failMessage("INCORRECT Menu Options " + opts + "\nOption should include " + menuText);
            softAssert.fail("INCORRECT Menu Options " + opts + "\nOption should include " + menuText);
        }

    }


    @Then("I check the user cannot make changes to \"([^\"]*)\"$")
    public void checkTableForGetUser(String testItem){

        boolean rc = false;

        System.out.println(testItem);

        switch(testItem){

            case "Token Product Groups":
                System.out.println("Search Inst & Issuer");
                adminCommon.searchInstitutionAndIssuer("TestBank","TestBank HK");
                rc = adminCommon.checkReadOnly(testItem);
                break;

            case "Interfaces":
            case "Institutions":
            case "Perso Bureau":
            case "Task Scheduler":
                rc = adminCommon.checkReadOnly(testItem);
                break;

            case "Issuers":
                adminCommon.searchInstitution("TestBank");
                rc = adminCommon.checkReadOnly(testItem);
                break;

        }

       //        Check the data table has all edit or delete buttons with the class "x-item-disabled"
        if(rc){
            Logging.passMessage(testItem + " table does not contain edit or delete buttons");
        } else {
            Logging.failMessage(testItem + " table contains edit or delete buttons");
            softAssert.fail(testItem + " table contains edit or delete buttons");
        }



    }

    @Then("I check the user can make changes to \"([^\"]*)\"$")
    public void checkTableForSetUser(String testItem){

        boolean rc = false;

        System.out.println(testItem);

        switch(testItem){

            case "Token Product Groups":
                System.out.println("Search Inst & Issuer");
                adminCommon.searchInstitutionAndIssuer("TestBank","TestBank HK");
                rc = adminCommon.checkReadOnly(testItem);
                break;

            case "Interfaces":
            case "Institutions":
            case "Perso Bureau":
            case "Task Scheduler":
                rc = adminCommon.checkReadOnly(testItem);
                break;

            case "Issuers":
                adminCommon.searchInstitution("TestBank");
                rc = adminCommon.checkReadOnly(testItem);
                break;

        }

        //        Check the data table has all edit or delete buttons with the class "x-item-disabled"
        if(!rc){
            Logging.failMessage(testItem + " table does not contain edit or delete buttons");
            softAssert.fail(testItem + " table contains edit or delete buttons");
        } else {
            Logging.passMessage(testItem + " table contains edit or delete buttons");

        }
    }

    @Then("Check Permissions scenario")
    public void check_permissions_scenario() {
        softAssert.assertAll();
    }

    @Then("I click on the Admin Menu Task Scheduler")
    public void clickTaskScheduler(){
        homePage.clickOnTaskSchedulerMenuItem();
    }


}
