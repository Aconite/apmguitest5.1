package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.EncryptionKeyDataRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EncryptionKeyPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public EncryptionKeyPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanKeyTableHeader().isDisplayed();
    }

    public void selectAllKeyTypesAndSearch(){

        adminCommon.setListValue(orAdmin.selSearchKeyType(),"Zone PIN Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"PIN Verification Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"PAN Encryption Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"PIN Encryption Key (software encryption)");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"Key Export Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"PIN Generation Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"Asymmetric Import Key");
        orAdmin.selSearchKeyType().click();
        adminCommon.setListValue(orAdmin.selSearchKeyType(),"Asymmetric Export Key");
        orAdmin.selSearchKeyType().click();

        orAdmin.btnSearch().click();
    }

    public EncryptionKeyDataRecord enterKeyData(EncryptionKeyDataRecord newKey){

        EncryptionKeyDataRecord newRecord;
        newRecord = newKey;
        WebDriverWait myWait = new WebDriverWait(webDriver, 30);

        selectAllKeyTypesAndSearch();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

        orAdmin.btnAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnKeyDetailCancel()));

        adminCommon.setListValue(orAdmin.selKeyDetailStatus(),newKey.getStatus());
        adminCommon.setListValue(orAdmin.selKeyDetailKeyType(),newKey.getKeyType());
        orAdmin.txtKeyDetailName().sendKeys(newKey.getName());
        adminCommon.setListValue(orAdmin.selKeyDetailHsmType(),newKey.getHsmType());
        orAdmin.txtKeyDetailMkCheckValue().sendKeys(newKey.getMkCheckValue());
        adminCommon.setListValue(orAdmin.selKeyDetailKeyAlgorithm(),newKey.getKeyAlgorithm());
        orAdmin.txtKeyDetailBlockSize().sendKeys(newKey.getBlockSize());
        orAdmin.txtKeyDetailKeyValue().sendKeys(newKey.getKeyValue());

        orAdmin.btnKeyDetailCreate().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("successfully added")) {
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblKeyList()));

            adminCommon.findObjectByColumn(orAdmin.keyList(),"Name", newKey.getName());
            newRecord.setId(adminCommon.getIdByColumn(orAdmin.keyList(),"Name",newKey.getName()));
        }
        else{
            newRecord = null;
        }

        return newRecord;
    }

}
