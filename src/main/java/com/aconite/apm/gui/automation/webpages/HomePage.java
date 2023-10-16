package com.aconite.apm.gui.automation.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage
{
    private WebDriver webDriver;

    @FindBy (xpath = "//a[normalize-space()='Administration']")
    WebElement eAdministrationMasterMenu;

    @FindBy (xpath = "//a[normalize-space()='Operations']")
    WebElement eOperationsMasterMenu;

    @FindBy (xpath = "//a[normalize-space()='Task Scheduler']")
    WebElement eTaskScheduler;

    @FindBy (xpath = "//a[normalize-space()='Token Products']")
    WebElement eTokenProducts;

    @FindBy (xpath = "//a[normalize-space()='Token Product Groups']")
    WebElement eTokenProductGroups;

    @FindBy (xpath = "//a[normalize-space()='Institutions']")
    WebElement eInstitutions;

    @FindBy (xpath = "//a[normalize-space()='Issuers']")
    WebElement eIssuers;

    @FindBy (xpath = "//a[contains(text(),'Data Dictionary')]")
    WebElement eDataDictionary;

    @FindBy (xpath = "//a[normalize-space()='Countries']")
    WebElement eCountries;

    @FindBy (xpath = "//a[normalize-space()='SMS Templates']")
    WebElement eSMSTemplates;

    @FindBy (xpath = "//a[normalize-space()='Message Templates']")
    WebElement eMessageTemplates;

    @FindBy (xpath = "//a[contains(text(),'Interfaces') and contains(@href,'#')]")
    WebElement eMainInterfaces;

    @FindBy (xpath = "//a[normalize-space()='Interfaces' and contains(@href,'pages')]")
    WebElement eMenuInterfaces;

    @FindBy (xpath = "//a[normalize-space()='Personalisation Bureaus']")
    WebElement ePersonalisationBureaus;

//    @FindBy(how = How.ID, using = "navigation")
////    @FindBy (xpath = "//ul[@id=\"navigation\"]")
//    WebElement eMenu;

    public HomePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageOpened()
    {
        return webDriver.getTitle().equals("APM - Home");
    }

    public void clickOnTaskSchedulerMenuItem()
    {
        isPageOpened();
        eOperationsMasterMenu.click();
        eTaskScheduler.click();
    }

    public void clickOnAdminTokenProductsMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eTokenProducts.click();
    }

    public void clickOnAdminTokenProductGroupsMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eTokenProductGroups.click();

    }

    public void clickOnAdminInstitutionsMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eInstitutions.click();
    }
    public void clickOnAdminCountriesMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eDataDictionary.click();
        eCountries.click();
    }

    public void clickOnAdminIssuersMenuItem() {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eIssuers.click();
    }

    public void clickOnAdminSMSTemplatesMenuItem() {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eSMSTemplates.click();
    }
    public void clickOnAdminMessageTemplatesMenuItem() {
       isPageOpened();
       eAdministrationMasterMenu.click();
       eMessageTemplates.click();
    }

    public void clickOnInterfacesInterfacesMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eMainInterfaces.click();
        eMenuInterfaces.click();
    }

    public void clickOnInterfacesPersoBureauMenuItem()
    {
        isPageOpened();
        eAdministrationMasterMenu.click();
        eMainInterfaces.click();
        ePersonalisationBureaus.click();
    }

    public List<String> getMenuOptions()
    {
        List<WebElement> menuOptions;
        List menuText = new ArrayList();

        isPageOpened();

        WebElement eMenu = webDriver.findElement(By.xpath("//ul[@id=\"navigation\"]"));

        menuOptions = eMenu.findElements(By.xpath(".//a"));
        for(int i = 0; i<menuOptions.size(); i++){
            System.out.println("Menu Options " + i + ": " + menuOptions.get(i).getAttribute("textContent"));
            menuText.add(menuOptions.get(i).getAttribute("textContent"));
            System.out.println("Menu Text: " + menuText);
        }

        return menuText;
    }

}
