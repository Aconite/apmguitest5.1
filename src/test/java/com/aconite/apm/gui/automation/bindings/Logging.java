package com.aconite.apm.gui.automation.bindings;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class Logging {

    public WebDriver webDriver;
    public SoftAssert softAssert = new SoftAssert();

    public Logging(AbsractSteps absractSteps)
    {
        webDriver = absractSteps.getDriver();
    }

    public static void passMessage(String msg){

        AbsractSteps.myScenario.log("<font color=\"green\"><b>" + msg + "</b></font>");

    }

    public static void failMessage(String msg){

        AbsractSteps.myScenario.log("<font color=\"red\"><b>" + msg + "</b></font>");


    }

    public static void warnMessage(String msg){

        AbsractSteps.myScenario.log("<font color=\"chocolate\"><b>" + msg + "</b></font>");

    }

    public static void stepName(String msg){

        AbsractSteps.myScenario.log("===================================================================================================<p>   " +
                msg +
                "<p>   ===================================================================================================");

    }

    public static void dataMsg(String msg){

        AbsractSteps.myScenario.log( msg );

    }




}
