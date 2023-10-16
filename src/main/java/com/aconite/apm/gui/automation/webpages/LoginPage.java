package com.aconite.apm.gui.automation.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    private WebDriver webDriver;
    private String url;

    @FindBy(xpath = "//input[@name='username']")
    WebElement eUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement ePassword;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    WebElement eLoginButton;

    public LoginPage(String url, WebDriver webDriver) throws Exception
    {
        try {
            this.webDriver = webDriver;
            PageFactory.initElements(webDriver, this);
            this.url = url;
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    public void goToLoginPage ()
    {
        System.out.println(url);
        webDriver.navigate().to(url);
    }

    public void isLoginPageDisplayed() throws Exception
    {
        if (!webDriver.getTitle().equals("APM - Login"))
        {
            throw new Exception("Login Page not displayed");
        }
    }

    public void enterCredentials (String username, String password)
    {
        eUsername.clear();
        eUsername.sendKeys(username);
        ePassword.clear();
        ePassword.sendKeys(password);
    }

    public void clickLogin ()
    {
        eLoginButton.click();
    }

    public void isLoginSuccessful() throws Exception
    {
        if (!webDriver.getTitle().equals("APM - Home"))
        {
            throw new Exception("Login not successful");
        }
    }

    public void login(String username, String password) throws Exception
    {
        goToLoginPage();
        isLoginPageDisplayed();
        enterCredentials(username, password);
        clickLogin();
        isLoginSuccessful();
    }
}
