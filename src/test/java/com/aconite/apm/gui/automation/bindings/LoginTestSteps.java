package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.webpages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class LoginTestSteps
{
    LoginPage loginPage = null;
//    String url = "http://54.77.193.235:7005/pages/login/login.html";
//    String username = "admin";
//    String password = "password";

    private AbsractSteps absractSteps;
    public WebDriver webDriver = null;

    public LoginTestSteps(AbsractSteps absractSteps)
    {
        this.absractSteps = absractSteps;
        webDriver = absractSteps.getDriver();
    }

    @Given("that i am on the APM login page")
    public void that_i_am_on_the_apm_login_page() throws Exception
    {
        loginPage.goToLoginPage();
        loginPage.isLoginPageDisplayed();
    }

//    @When("i enter a valid username and password and click on the login button")
//    public void iEnterAValidUsernameAndPasswordAndClickOnTheLoginButton()  throws Exception
//    {
//        loginPage.login(username, password);
//    }

    @Then("i am successfully logged in")
    public void i_am_successfully_logged_in() throws Exception
    {
        loginPage.isLoginSuccessful();
    }

    @Given("I am logged in as \"([^\"]*)\"$")
    public void i_am_logged_in_as(String login) {

        try {

            String[] arrLogin = login.split("/");
            String userName = arrLogin[0];
            String pwd = arrLogin[1];

            System.out.println("About to create Login. WebDriver is: " + webDriver);
            LoginPage loginPage = new LoginPage(absractSteps.getBaseUrl(), webDriver);
            System.out.println("About to Login: " + userName + "/" + pwd);
            loginPage.login(userName, pwd);

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
