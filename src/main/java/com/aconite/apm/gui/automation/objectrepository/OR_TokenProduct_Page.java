package com.aconite.apm.gui.automation.objectrepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;



public class OR_TokenProduct_Page{

    public static WebDriver webDriver;

    public OR_TokenProduct_Page(WebDriver webDriver){
        this.webDriver = webDriver;
        System.out.println("OR Page Creation: " + this.webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /********************************
     * Main Page Objects
     ********************************/

    public static WebElement eSearchHeader(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"idTokenProductsSearch_header-body\"]"));
        return element;
    }

    public static WebElement selectInstitution(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"idSInstitution-inputEl\"]"));
        return element;
    }

    public static WebElement selectIssuer(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"idSIssuer-inputEl\"]"));
        return element;
    }

    public static WebElement selectTPG(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"idSTokenProductGroups-inputEl\"]"));
        return element;
    }

    public static List<WebElement> dropDownItems(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//li"));
        return elements;
    }

    public static List<WebElement> tpgItems(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id=\"boundlist-1162-listEl\"]"));
        return elements;
    }

    public static WebElement btnSearch(){
        WebElement element = webDriver.findElement(By.xpath("//span[text()=\"Search\"]"));
        return element;
    }


    public static WebElement table(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsList-body\"]"));
        return element;
    }

    public static List<WebElement> colHeaders(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@id=\"divTokenProductsList\"]//span[@class=\"x-column-header-text\"]"));
        return elements;
    }

    public static List<WebElement> tblRows(){
        List<WebElement> elements = webDriver.findElements(By.xpath("//tr[contains(@class, \"x-grid-row\")]"));
        return elements;
    }

    public static WebElement btnAdd(){
        WebElement element = webDriver.findElement(By.xpath("//span[contains(@class,'icon-add')]"));
        return element;
    }

    public static WebElement btnRefresh(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
        return element;
    }

    /********************************
     * Edit Page Objects
     ********************************/

    public static WebElement winAddEdit(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]"));
        return element;
    }

    public static WebElement txtId(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"idID-inputEl\"]"));
        return element;
    }

    public static WebElement editName(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idName')]"));
        return element;
    }

    public static WebElement editIssuerTokenProductCode(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idIssuerTokenProductCode')]"));
        return element;
    }

    public static WebElement selEditIssuer(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idIssuerid')]"));
        return element;
    }

    public static WebElement selEditTokenProductGroup(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idTokenProductGroupID')]"));
        return element;
    }

    public static WebElement editRetentionDays(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idRetentionDays')]"));
        return element;
    }

    public static WebElement selEditCountry(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idCountryCode')]"));
        return element;
    }

    public static WebElement selEditLanguage(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idLanguangeCode')]"));
        return element;
    }

    public static WebElement selEditPersonBureau(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPersoBureauID')]"));
        return element;
    }

    public static WebElement editPinOverSMSDelay(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPinOverSMSDelay')]"));
        return element;
    }

    public static WebElement editPinMailerDelay(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPinMailerDelay')]"));
        return element;
    }

    public static WebElement editSMSPasswordDelay(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSMSPasswordDelay')]"));
        return element;
    }

    public static WebElement cbxFeedbackRequired(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idFeedbackRequired')]"));
        return element;
    }

    public static WebElement cbxActive(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idStatus')]"));
        return element;
    }

    public static WebElement selEditPinTemplate(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPinTemplateid')]"));
        return element;
    }

    public static WebElement editSecondaryPinTemplate(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSecondaryPinTemplateid')]"));
        return element;
    }

    public static WebElement selEditPukTemplate(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPukTemplateid')]"));
        return element;
    }

    public static WebElement selEditPasswordTemplate(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idPasswordTemplateid')]"));
        return element;
    }

    public static WebElement editSmsSender(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSmsSender')]"));
        return element;
    }

    public static WebElement editSmsValidity(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSmsValidity')]"));
        return element;
    }

    public static WebElement editSmsPasswordExpiry(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSmsPasswordExpiry')]"));
        return element;
    }

    public static WebElement selEditSmsClass(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idSmsClass')]"));
        return element;
    }

    public static WebElement selEditTIPinDeliveryMethod(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idETIPinDeliveryMethodId')]"));
        return element;
    }

    public static WebElement selEditTOWPDPinDeliveryMethod(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idETOWPDPinDeliveryMethodId')]"));
        return element;
    }

    public static WebElement cbxForceTOWPDPinDeliveryMethod(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idEForceTOWPDPinDeliveryMethod')]"));
        return element;
    }

    public static WebElement selEditPAPinDeliveryMethod(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idEPAPinDeliveryMethodId')]"));
        return element;
    }

    public static WebElement cbxForcePAPinDeliveryMethod(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//input[contains(@id,'idEForcePAPinDeliveryMethod')]"));
        return element;
    }

    public static WebElement btnCreate(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"button-1133\"]"));
        return element;
    }

    public static WebElement btnCancel(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//div[@id=\"idTokenProductsEditFooter-innerCt\"]//span[text()=\"Cancel\"]"));
        return element;
    }

    public static WebElement txtMsg(){
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"messagebox-1001-displayfield-inputEl\"]"));
        return element;
    }

    public static WebElement btnOK(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"button-1005-btnEl\"]"));
        return element;
    }

    public static WebElement btnSave(){
//        WebElement element = webDriver.findElement(By.xpath("//div[@outerText, 'Save']"));
        WebElement element = webDriver.findElement(By.xpath("//div[@id=\"divTokenProductsEdit\"]//div[@id=\"idTokenProductsEditFooter-innerCt\"]//span[text()=\"Save\"]"));
        return element;
    }

    public static WebElement hdrMsg(){
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"messagebox-1001_header_hd-textEl\"]"));
        return element;
    }


}