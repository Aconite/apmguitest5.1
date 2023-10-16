package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class AbsractSteps
{
    private static boolean initialized = false;
    private static WebDriver driver;
    private String baseUrl;
    private String username;
    private String password;
    private String testType;
    public static Scenario myScenario;


    Properties properties;

    @Before ()
    public void setUp(Scenario myScenario)
    {
        AbsractSteps.myScenario = myScenario;

        if (!initialized)
        {
            System.out.println("In setUp: " + myScenario.getName());

            if(myScenario.getName().contains("Burp")){

                Proxy proxy = new Proxy();
                proxy.setHttpProxy("127.0.0.1:8080");
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--allow-insecure-localhost");
                chromeOptions.setCapability(CapabilityType.PROXY, proxy);
                driver = new ChromeDriver(chromeOptions);

            }
            else {
                // initialize the driver
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--allow-insecure-localhost");
                driver = new ChromeDriver(chromeOptions);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            initialized = true;

        }

        properties = new Properties();

        try
        {
            properties.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties"));
        }
        catch (IOException iox)
        {
            iox.printStackTrace();
        }

        baseUrl = properties.getProperty("apm_url");
        username = properties.getProperty("apm_username");
        password = properties.getProperty("apm_password");

        System.out.println("My Scenario is called *** " + myScenario.getName() + " ***");

    }


    @When("I set test type \"([^\"]*)\"$")
    public void setTestType(String testType){
        this.testType = testType;
    }

    public String getTestType()
    {
        return testType;
    }

    public String getDataPath(){

        String testPath = "";

         if(getTestType().equals("Admin")){
            testPath = "src/test/resources/TestData/Admin";
        }
        if(getTestType().equals("Scheduler")){
            testPath = "src/test/resources/TestData/Admin";
        }

        return testPath;
    }


    public WebDriver getDriver()
    {
         return driver;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    @After()
    public void tearDown()
    {
        driver.quit();
        initialized = false;
    }

}