package com.aconite.apm.gui.automation.bindings;


import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinVerify;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.utilities.WebRequests;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinImport;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class DataloadTestSteps {

    public WebDriver webDriver = null;

    public DataloadTestSteps(AbsractSteps absractSteps){
        try {
            webDriver = absractSteps.getDriver();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }

    @Given("Pin Import Single")
    public void runPinImportSingle(){
        WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
    }

    @Given("Pin Verify By PAN ID")
    public void runPinVerifyByPanId(){
        try {
            String xmlrsp = WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanId());
            System.out.println("Response Output: \n-------------------------------------------" + xmlrsp +
                    "\n-------------------------------------------");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Given("Pin Import Multiple")
    public void runPinImportMultiple(){
        WebRequests.dataload(DataLoadPinImport.dataloadPinImportMultiple());
    }

    @Given("Token Import OrderType 1 SMS")
    public void runTOWPD_OT1_SMS(){
        WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS());
    }

}


