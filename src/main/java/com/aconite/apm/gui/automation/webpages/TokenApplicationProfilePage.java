package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import com.aconite.apm.gui.automation.records.TokenApplicationProfileDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TokenApplicationProfilePage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    private final TokenProductsPage tokenProductsPage;
    public AdminCommon adminCommon;

    public TokenApplicationProfilePage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        tokenProductsPage = new TokenProductsPage(webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public void clickAddTokenApplication(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);

        orAdmin.btnTokenApplicationProfileAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileDetailCreate()));

    }

    public void clickCreateTokenApplication(){

        orAdmin.btnTokenApplicationProfileDetailCreate().click();

    }

    public void clickCancelTokenApplication(){

        orAdmin.btnTokenApplicationProfileDetailCancel().click();

    }

    public boolean deleteTokenApplicationProfileByName(TokenApplicationProfileDataRecord delTokenApplicationProfile){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(delTokenApplicationProfile.getParentInstitution(), delTokenApplicationProfile.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(delTokenApplicationProfile.getParentTokenProductId());
        adminCommon.sleep(500);

        // Click delete
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenApplicationProfileList()));
        adminCommon.clickDeleteByName(orAdmin.tblTokenApplicationProfileList(), delTokenApplicationProfile.getName());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenApplicationProfileList()));
        refreshTokenApplicationProfileTable();
        return true;

    }

    public boolean checkRequiredFieldMessages(String field, String message){

        boolean rc = true;

        switch(field) {

            case("Name"):
                if (!orAdmin.txtTokenApplicationProfileDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("TokenProductCode"):
                if (!orAdmin.selTokenApplicationProfileDetailTokenProduct().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("AppSequenceNumber"):
                if (!orAdmin.txtTokenApplicationProfileDetailAppSeqNumber().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case ("PinLength"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                orAdmin.txtTokenApplicationProfileDetailPINLength().clear();
                orAdmin.txtTokenApplicationProfileDetailName().click();
                if (!orAdmin.txtTokenApplicationProfileDetailPINLength().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("ImportEncryptionZone"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                if (!orAdmin.selTokenApplicationProfileDetailImportEncryptionZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsEncryptionZone"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                if (!orAdmin.selTokenApplicationProfileDetailSMSEncryptionZone().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinMailerDelayHours"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                if (!orAdmin.txtTokenApplicationProfileDetailPINMailerDelayHours().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("ImportGeneratePuk"):
                orAdmin.tabTokenApplicationProfileDetailPUKDetails().click();
                if (!orAdmin.selTokenApplicationProfileDetailImportGeneratePUK().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinVerificationKey"):
                orAdmin.tabTokenApplicationProfileDetailVerification().click();
                if (!orAdmin.selTokenApplicationProfileDetailPINVerificationKey().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                if (!orAdmin.selTokenApplicationProfileDetailPINTemplate().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PukTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                if (!orAdmin.selTokenApplicationProfileDetailPUKTemplate().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PasswordTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                if (!orAdmin.selTokenApplicationProfileDetailPasswordTemplate().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinOverSMSDelayHours"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.txtTokenApplicationProfileDetailPINOverSMSDelayHours().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsPasswordDelayHours"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.txtTokenApplicationProfileDetailSMSPasswordDelayHours().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsSender"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.txtTokenApplicationProfileDetailSMSSender().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsValidityHours"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.txtTokenApplicationProfileDetailSMSValidityHours().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsPasswordHours"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.txtTokenApplicationProfileDetailSMSPasswordHours().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("SmsClass"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                if (!orAdmin.selTokenApplicationProfileDetailSMSClass().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;
    }

    public TokenApplicationProfileDataRecord enterTokenApplicationProfileData(TokenApplicationProfileDataRecord newTokenApplicationProfile){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
        clickAddTokenApplication();

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileDetailCreate()));
        orAdmin.txtTokenApplicationProfileDetailName().sendKeys(newTokenApplicationProfile.getName());
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenProduct(), newTokenApplicationProfile.getParentTokenProduct());
        orAdmin.txtTokenApplicationProfileDetailAppSeqNumber().sendKeys(newTokenApplicationProfile.getAppSequenceNumber());
        orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
        orAdmin.txtTokenApplicationProfileDetailPINLength().clear();
        orAdmin.txtTokenApplicationProfileDetailPINLength().sendKeys(newTokenApplicationProfile.getPinLength());
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailImportEncryptionZone(),newTokenApplicationProfile.getImportEncryptionZone());
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSMSEncryptionZone(),newTokenApplicationProfile.getSmsEncryptionZone());
        orAdmin.txtTokenApplicationProfileDetailPINMailerDelayHours().sendKeys(newTokenApplicationProfile.getPinMailerDelayHours());
        orAdmin.tabTokenApplicationProfileDetailPUKDetails().click();
        orAdmin.tabTokenApplicationProfileDetailVerification().click();
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINVerificationKey(),newTokenApplicationProfile.getPinVerificationKey());
        orAdmin.tabTokenApplicationProfileDetailTemplates().click();
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINTemplate(), newTokenApplicationProfile.getPinTemplate());
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPUKTemplate(), newTokenApplicationProfile.getPukTemplate());
        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPasswordTemplate(), newTokenApplicationProfile.getPasswordTemplate());
        orAdmin.tabTokenApplicationProfileDetailSMS().click();
        orAdmin.txtTokenApplicationProfileDetailPINOverSMSDelayHours().sendKeys(newTokenApplicationProfile.getPinOverSMSDelayHours());

        System.out.println("getSmsPasswordDelayHours: " + newTokenApplicationProfile.getSmsPasswordDelayHours());
        System.out.println("getSmsValidityHours: " + newTokenApplicationProfile.getSmsValidityHours());
        System.out.println("getSmsPasswordHours: " + newTokenApplicationProfile.getSmsPasswordHours());

//        orAdmin.txtTokenApplicationProfileDetailSMSPasswordDelayHours().sendKeys(newTokenApplicationProfile.getSmsPasswordDelayHours());
        adminCommon.setSpinValue(orAdmin.spnSMSPasswordDelayHours(), newTokenApplicationProfile.getSmsPasswordDelayHours());

        orAdmin.txtTokenApplicationProfileDetailSMSSender().sendKeys(newTokenApplicationProfile.getSmsSender());

//        orAdmin.txtTokenApplicationProfileDetailSMSValidityHours().sendKeys(newTokenApplicationProfile.getSmsValidityHours());
        adminCommon.setSpinValue(orAdmin.spnSMSValidityHours(), newTokenApplicationProfile.getSmsValidityHours());

//        orAdmin.txtTokenApplicationProfileDetailSMSPasswordHours().sendKeys(newTokenApplicationProfile.getSmsPasswordHours());
        adminCommon.setSpinValue(orAdmin.spnSMSPasswordHours(), newTokenApplicationProfile.getSmsPasswordHours());

        adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSMSClass(), newTokenApplicationProfile.getSmsClass());

        orAdmin.btnTokenApplicationProfileDetailCreate().click();

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();
        if(!output.contains("successfully added")){
            newTokenApplicationProfile = null;
        }
        else{
            orAdmin.btnOK().click();
            tokenProductsPage.dblClickTokenProductById(newTokenApplicationProfile.getParentTokenProductId());
        }


        return newTokenApplicationProfile;

    }

    public boolean editTokenApplicationProfileData(TokenApplicationProfileDataRecord editTokenApplicationProfile, String field){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);

        TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
        recordSearchTokenProduct.setParentInstitution(editTokenApplicationProfile.getParentInstitution());
        recordSearchTokenProduct.setParentIssuer(editTokenApplicationProfile.getParentIssuer());
        recordSearchTokenProduct.setId(editTokenApplicationProfile.getParentTokenProductId());

        adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordSearchTokenProduct.getId());

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
        adminCommon.sleep(1000);

//        editTokenApplicationProfileByName(editTokenApplicationProfile.getName());
        adminCommon.clickEditByName(orAdmin.tblTokenApplicationProfileList(), editTokenApplicationProfile.getName());
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileDetailSave()));


        switch(field) {



            /* Currently, not done - name and token product code used to id token application profile */
            case ("Name"):
                orAdmin.txtTokenApplicationProfileDetailName().clear();
                orAdmin.txtTokenApplicationProfileDetailName().sendKeys(editTokenApplicationProfile.getName());
                break;

            /* Currently, not done - name and token product code used to id token application profile */
            case("TokenProductCode"):
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenProduct(), editTokenApplicationProfile.getParentTokenProduct());
                break;

            /* Not editable */
            case ("AppSequenceNumber"):
                orAdmin.txtTokenApplicationProfileDetailAppSeqNumber().clear();
                orAdmin.txtTokenApplicationProfileDetailAppSeqNumber().sendKeys(editTokenApplicationProfile.getAppSequenceNumber());
                break;

            case("Status"):
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailStatus(), editTokenApplicationProfile.getStatus());
                break;

            case ("DefaultApp"):
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailDefaultApp(), editTokenApplicationProfile.getDefaultApp());
                break;

            case ("PinRequired"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailPINRequired(), editTokenApplicationProfile.getPinRequired());
                break;

            case ("PinLength"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                orAdmin.txtTokenApplicationProfileDetailPINLength().clear();
                orAdmin.txtTokenApplicationProfileDetailPINLength().sendKeys(editTokenApplicationProfile.getPinLength());
                break;

            case("ImportEncryptionZone"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailImportEncryptionZone(), editTokenApplicationProfile.getImportEncryptionZone());
                break;

            case("SmsInterface"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSMSInterface(), editTokenApplicationProfile.getSmsInterface());
                break;

            case("SmsEncryptionZone"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSMSEncryptionZone(), editTokenApplicationProfile.getSmsEncryptionZone());
                break;

            case("ReturnInterface"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailReturnInterface(), editTokenApplicationProfile.getReturnInterface());
                break;

            case("PINDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINDeliveryMethod(), editTokenApplicationProfile.getPinDeliveryMethod());
                break;

            case ("PinMailerDelayHours"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                orAdmin.txtTokenApplicationProfileDetailPINMailerDelayHours().clear();
                orAdmin.txtTokenApplicationProfileDetailPINMailerDelayHours().sendKeys(editTokenApplicationProfile.getPinMailerDelayHours());
                break;

            case ("PinHeldBySeqNum"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                orAdmin.txtTokenApplicationProfileDetailPINHeldBySeqNum().clear();
                orAdmin.txtTokenApplicationProfileDetailPINHeldBySeqNum().sendKeys(editTokenApplicationProfile.getPinHeldBySeqNum());
                break;

            case ("AllowPinChange"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailAllowPINChange(), editTokenApplicationProfile.getAllowPinChange());
                break;

            case ("AllowOnlinePinChange"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailAllowOnlinePINChange(), editTokenApplicationProfile.getAllowOnlinePinChange());
                break;

            case ("AllowOnlinePinView"):
                orAdmin.tabTokenApplicationProfileDetailPINDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailAllowOnlinePINView(), editTokenApplicationProfile.getAllowOnlinePinView());
                break;

            case ("PukRequired"):
                orAdmin.tabTokenApplicationProfileDetailPUKDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailPUKRequired(), editTokenApplicationProfile.getPukRequired());
                if (editTokenApplicationProfile.getPukRequired().equals("true")) {
                    adminCommon.setSpinValue(orAdmin.spnPUKLength(), editTokenApplicationProfile.getPukLength());
                }
                break;

            case ("PukLength"):
                adminCommon.setSpinValue(orAdmin.spnPUKLength(), editTokenApplicationProfile.getPukLength());
                break;

            case ("AllowPukChange"):
                orAdmin.tabTokenApplicationProfileDetailPUKDetails().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailAllowPUKChange(), editTokenApplicationProfile.getAllowPukChange());
                break;

            case ("PukHeldBySeqNum"):
                adminCommon.setSpinValue(orAdmin.spnPUKHeldBySeqNum(), editTokenApplicationProfile.getPukHeldBySeqNum());
                break;

            case("ImportGeneratePuk"):
                orAdmin.tabTokenApplicationProfileDetailPUKDetails().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailImportGeneratePUK(), editTokenApplicationProfile.getImportGeneratePuk());
                break;

            case("PinVerificationMethod"):
                orAdmin.tabTokenApplicationProfileDetailVerification().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINVerificationMethod(), editTokenApplicationProfile.getPinVerificationMethod());
                break;

           case("PinVerificationKey"):
               orAdmin.tabTokenApplicationProfileDetailVerification().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINVerificationKey(), editTokenApplicationProfile.getPinVerificationKey());
                break;

            case ("PinTries"):
                adminCommon.setSpinValue(orAdmin.spnPINTries(), editTokenApplicationProfile.getPinTries());
                break;

            case ("VerificationBackoff"):
                adminCommon.setSpinValue(orAdmin.spnVerificationBackoff(), editTokenApplicationProfile.getVerificationBackoff());
                break;

            case ("BackoffMultiplier"):
                adminCommon.setSpinValue(orAdmin.spnBackoffMultipliers(), editTokenApplicationProfile.getBackoffMultiplier());
                break;

            case("TokenImportPinDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenImportPINDeliveryMethod(), editTokenApplicationProfile.getTokenImportPinDeliveryMethod());
                break;

            case("TokenImportOutputInterface"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenImportOutputInterface(), editTokenApplicationProfile.getTokenImportOutputInterface());
                break;

            case("TokenOrderPinDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenOrderPINDeliveryMethod(), editTokenApplicationProfile.getTokenOrderPinDeliveryMethod());
                break;

            case ("ForceTokenOrderPinDelivery"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailForceTOWPDPINDelivery(), editTokenApplicationProfile.getForceTokenOrderPinDelivery());
                break;

            case("TokenOutputInterface"):
                 orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailTokenOutputInterface(), editTokenApplicationProfile.getTokenOutputInterface());
                break;

            case("PinAdvicePinDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINAdvicePINDeliveryMethod(), editTokenApplicationProfile.getPinAdvicePinDeliveryMethod());
                break;

            case ("ForcePinAdvicePinDelivery"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.selectCheckbox(orAdmin.cbxTokenApplicationProfileDetailForcePINAdvicePINDelivery(), editTokenApplicationProfile.getForcePinAdvicePinDelivery());
                break;

            case("PinAdviceOutputInterface"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINAdviceOutputInterface(), editTokenApplicationProfile.getPinAdviceOutputInterface());
                break;

            case("UpdatePinDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailUpdatePINDeliveryMethod(), editTokenApplicationProfile.getUpdatePinDeliveryMethod());
                break;

            case("UpdateInterface"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailUpdateInterface(), editTokenApplicationProfile.getUpdateInterface());
                break;

            case("VppPinDeliveryMethod"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailVPPPINDeliveryMethod(), editTokenApplicationProfile.getVppPinDeliveryMethod());
                break;

            case("VppInterface"):
                orAdmin.tabTokenApplicationProfileDetailDelivery().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailVPPInterface(), editTokenApplicationProfile.getVppInterface());
                break;

           case("PinTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPINTemplate(), editTokenApplicationProfile.getPinTemplate());
                break;

           case("SecondaryPinTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSecondaryPINTemplate(), editTokenApplicationProfile.getSecondaryPinTemplate());
                break;

           case("PukTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPUKTemplate(), editTokenApplicationProfile.getPukTemplate());
                break;

           case("PasswordTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailPasswordTemplate(), editTokenApplicationProfile.getPasswordTemplate());
                break;

           case("MessageTemplate"):
                orAdmin.tabTokenApplicationProfileDetailTemplates().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailMessageTemplate(), editTokenApplicationProfile.getMessageTemplate());
                break;

            case ("PinOverSMSDelayHours"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                orAdmin.txtTokenApplicationProfileDetailPINOverSMSDelayHours().clear();
                orAdmin.txtTokenApplicationProfileDetailPINOverSMSDelayHours().sendKeys(editTokenApplicationProfile.getPinOverSMSDelayHours());
                break;

            case ("SmsPasswordDelayHours"):
                adminCommon.setSpinValue(orAdmin.spnSMSPasswordDelayHours(), editTokenApplicationProfile.getSmsPasswordDelayHours());
                break;

            case ("SmsSender"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                orAdmin.txtTokenApplicationProfileDetailSMSSender().clear();
                orAdmin.txtTokenApplicationProfileDetailSMSSender().sendKeys(editTokenApplicationProfile.getSmsSender());
                break;

            case ("SmsValidityHours"):
                adminCommon.setSpinValue(orAdmin.spnSMSValidityHours(), editTokenApplicationProfile.getSmsValidityHours());
                break;

            case ("SmsPasswordHours"):
                adminCommon.setSpinValue(orAdmin.spnSMSPasswordHours(), editTokenApplicationProfile.getSmsPasswordHours());
                break;

            case("SmsClass"):
                orAdmin.tabTokenApplicationProfileDetailSMS().click();
                adminCommon.setListValue(orAdmin.selTokenApplicationProfileDetailSMSClass(), editTokenApplicationProfile.getSmsClass());
                break;

        }

        // Click the Save button
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileDetailSave()));
        orAdmin.btnTokenApplicationProfileDetailSave().click();
        boolean present = false;
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            try{
                webDriver.findElement(By.xpath("//*[@id=\"button-1005-btnEl\"]"));
                String output = orAdmin.txtMsg().getText();
                if (!output.contains("successfully updated")) {
                    return(false);
                }

                orAdmin.btnOK().click();
                myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
                present = true;
                break;

            }catch (NoSuchElementException e) {
                System.out.println("OK Button not found: " + i);
            }
        }

        return(present);

    }

    public TokenApplicationProfileDataRecord getDBDataByName(String name){

        TokenApplicationProfileDataRecord record = new TokenApplicationProfileDataRecord();

        try {

            String SQL = "SELECT TAP.NAME, TP.NAME, TAP.APP_SEQ_NUMBER, TAP.STATUS, TAP.DEFAULT_APP_FLAG, " +
                    "TAP.PIN_REQUIRED_FLAG, TAP.PIN_LENGTH, TAP.EXPIRY_IN_DAYS, EDEZ1.NAME, " +
                    "IDI1.NAME, EDEZ2.NAME, IDI2.NAME, PDM1.NAME, TAP.PIN_MAILER_DELAY, " +
                    "TAP.USES_PIN_OF_TOKEN_APP_SEQ_NUM, TAP.ALLOW_PIN_CHANGE_FLAG, " +
                    "TAP.ALLOW_ONLINE_PIN_CHANGE_FLAG, TAP.ALLOW_ONLINE_PIN_VIEWING_FLAG, " +
                    "TAP.PUK_REQUIRED_FLAG, TAP.PUK_LENGTH, TAP.ALLOW_PUK_CHANGE_FLAG, " +
                    "TAP.USES_PUK_OF_TOKEN_APP_SEQ_NUM, TAP.IMPORT_GENERATE_PUK_FLAG, " +
                    "PVM.NAME, SCI.NAME, TAP.PIN_TRIES_NUMBER, TAP.VERIFICATION_BACKOFF, " +
                    "TAP.BACKOFF_MULTIPLIER, PDM6.NAME, IDI3.NAME, PDM2.NAME, " +
                    "TAP.TOWPD_FORCE_DELIVERY_FLAG, IDI4.NAME, PDM3.NAME, TAP.ADVICE_FORCE_DELIVERY_FLAG, " +
                    "IDI5.NAME, PDM4.NAME, IDI6.NAME, PDM5.NAME, IDI7.NAME, TEM1.NAME, " +
                    "TEM2.NAME, TEM3.NAME, TEM4.NAME, TEM5.NAME, TAP.PIN_OVER_SMS_DELAY, " +
                    "TAP.SMS_PASSWORD_DELAY, TAP.SMS_SENDER, TAP.SMS_VALIDITY, " +
                    "TAP.SMS_PASSWORD_EXPIRATION, TAP.SMS_CLASS " +
                    "FROM C_D_TOKEN_APP_PROFILE TAP " +
                    "LEFT JOIN C_D_TOKEN_PRODUCT TP ON TAP.TOKEN_PRODUCT_ID = TP.ID " +
                    "LEFT JOIN ENC_D_ENCRYPTION_ZONE EDEZ1 ON TAP.IMPORT_ENC_ZONE_ID = EDEZ1.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI1 ON TAP.EXPORT_INTERFACE_ID = IDI1.ID " +
                    "LEFT JOIN ENC_D_ENCRYPTION_ZONE EDEZ2 ON TAP.EXPORT_ENC_ZONE_ID = EDEZ2.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI2 ON TAP.RETURN_INTERFACE_ID = IDI2.ID " +
                    " LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM1 ON TAP.PIN_DELIVERY_METHOD_ID = PDM1.ID " +
                    "LEFT JOIN ENC_S_PIN_VERIFICATION_METHOD PVM ON TAP.PIN_VERIFICATION_METHOD_ID = PVM.ID " +
                    "LEFT JOIN ENC_D_SCI SCI ON TAP.SCI_PIN_VERIFICATION_KEY_ID = SCI.ID " +
                    "LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM6 ON TAP.IMPORT_PIN_DELIVERY_METHOD = PDM6.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI3 ON TAP.IMPORT_OUTPUT_INTERFACE_ID = IDI3.ID " +
                    "LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM2 ON TAP.TOWPD_PIN_DELIVERY_METHOD = PDM2.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI4 ON TAP.TOWPD_OUTPUT_INTERFACE_ID = IDI4.ID " +
                    "LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM3 ON TAP.ADVICE_PIN_DELIVERY_METHOD = PDM3.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI5 ON TAP.ADVICE_OUTPUT_INTERFACE_ID = IDI5.ID " +
                    "LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM4 ON TAP.UPDATE_PIN_DELIVERY_METHOD = PDM4.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI6 ON TAP.UPDATE_OUTPUT_INTERFACE_ID = IDI6.ID " +
                    "LEFT JOIN C_S_PIN_DELIVERY_METHOD PDM5 ON TAP.VPP_PIN_DELIVERY_METHOD = PDM5.ID " +
                    "LEFT JOIN C_D_INTERFACE IDI7 ON TAP.VPP_OUTPUT_INTERFACE_ID = IDI7.ID " +
                    "LEFT JOIN PM_D_TEMPLATE TEM1 ON TAP.PIN_TEMPLATE_ID = TEM1.ID " +
                    "LEFT JOIN PM_D_TEMPLATE TEM2 ON TAP.SECONDARY_PIN_TEMPLATE_ID = TEM2.ID " +
                    "LEFT JOIN PM_D_TEMPLATE TEM3 ON TAP.PUK_TEMPLATE_ID = TEM3.ID " +
                    "LEFT JOIN PM_D_TEMPLATE TEM4 ON TAP.PASSWORD_TEMPLATE_ID = TEM4.ID " +
                    "LEFT JOIN C_D_MESSAGE_TEMPLATE TEM5 ON TAP.MESSAGE_TEMPLATE_ID = TEM5.ID " +
                    "WHERE TAP.NAME = ? ";

            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setString(1, name);

            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setName(null);
            }
            else{
                rs.next();

                record.setName(rs.getString(1));
                record.setParentTokenProduct(rs.getString(2));
                record.setAppSequenceNumber(rs.getString(3));
                record.setStatus(rs.getString(4));
                record.setDefaultApp(rs.getString(5));
                record.setPinRequired(rs.getString(6));
                record.setPinLength(rs.getString(7));
//                record.setValidityInDays(rs.getString(8));
                record.setImportEncryptionZone(rs.getString(9));
                record.setSmsInterface(rs.getString(10));
                record.setSmsEncryptionZone(rs.getString(11));
                record.setReturnInterface(rs.getString(12));
                record.setPinDeliveryMethod(rs.getString(13));
                record.setPinMailerDelayHours(rs.getString(14));
                record.setPinHeldBySeqNum(rs.getString(15));
                record.setAllowPinChange(rs.getString(16));
                record.setAllowOnlinePinChange(rs.getString(17));
                record.setAllowOnlinePinView(rs.getString(18));
                record.setPukRequired(rs.getString(19));
                record.setPukLength(rs.getString(20));
                record.setAllowPukChange(rs.getString(21));
                record.setPukHeldBySeqNum(rs.getString(22));
               // record.setImportGeneratePuk(rs.getString(23));
                record.setPinVerificationMethod(rs.getString(24));
                record.setPinVerificationKey(rs.getString(25));
                record.setPinTries(rs.getString(26));
                record.setVerificationBackoff(rs.getString(27));
                record.setBackoffMultiplier(rs.getString(28));
                record.setTokenImportPinDeliveryMethod(rs.getString(29));
                record.setTokenImportOutputInterface(rs.getString(30));
                record.setTokenOrderPinDeliveryMethod(rs.getString(31));
                record.setForceTokenOrderPinDelivery(rs.getString(32));
                record.setTokenOutputInterface(rs.getString(33));
                record.setPinAdvicePinDeliveryMethod(rs.getString(34));
                record.setForcePinAdvicePinDelivery(rs.getString(35));
                record.setPinAdviceOutputInterface(rs.getString(36));
                record.setUpdatePinDeliveryMethod(rs.getString(37));
                record.setUpdateInterface(rs.getString(38));
                record.setVppPinDeliveryMethod(rs.getString(39));
                record.setVppInterface(rs.getString(40));
                record.setPinTemplate(rs.getString(41));
                record.setSecondaryPinTemplate(rs.getString(42));
                record.setPukTemplate(rs.getString(43));
                record.setPasswordTemplate(rs.getString(44));
                record.setMessageTemplate(rs.getString(45));
                record.setPinOverSMSDelayHours(rs.getString(46));
                record.setSmsPasswordDelayHours(rs.getString(47));
                record.setSmsSender(rs.getString(48));
                record.setSmsValidityHours(rs.getString(49));
                record.setSmsPasswordHours(rs.getString(50));
                record.setSmsClass(rs.getString(51));

            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public TokenApplicationProfileDataRecord getTableDataByName(TokenApplicationProfileDataRecord tokenApplicationProfile){

        TokenApplicationProfileDataRecord record = new TokenApplicationProfileDataRecord();

        adminCommon.sleep(1000);

        List<WebElement> rows = webDriver.findElements(By.xpath("//div[@id=\"idTokenAppProfilesList-body\"]//tr[contains(@class,\"x-grid-row\")]"));

        if (rows.size() == 0){
            record.setName(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (cellName.getAttribute("textContent").equals(tokenApplicationProfile.getName())) {
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getAttribute("textContent"));
                    record.setParentTokenProduct(row.findElement(By.xpath(".//td[contains(@class, 'idGTPId')]")).getAttribute("textContent"));
                    record.setAppSequenceNumber(row.findElement(By.xpath(".//td[contains(@class, 'idGAppSeqNum')]")).getAttribute("textContent"));
                    record.setStatus(row.findElement(By.xpath(".//td[contains(@class, 'idGStatus')]")).getAttribute("textContent"));
                    record.setDefaultApp(row.findElement(By.xpath(".//td[contains(@class, 'idGDefAppFlg')]")).getAttribute("textContent"));
                    record.setPinRequired(row.findElement(By.xpath(".//td[contains(@class, 'idGPinReqFlg')]")).getAttribute("textContent"));
                    record.setPinLength(row.findElement(By.xpath(".//td[contains(@class, 'idGPINLength')]")).getAttribute("textContent"));
                    record.setPinVerificationMethod(row.findElement(By.xpath(".//td[contains(@class, 'idGPINVMID')]")).getAttribute("textContent"));
                    record.setPinVerificationKey(row.findElement(By.xpath(".//td[contains(@class, 'idGPINVKID')]")).getAttribute("textContent"));
                    record.setPinTries(row.findElement(By.xpath(".//td[contains(@class, 'idGPINNoOfTries')]")).getAttribute("textContent"));
                    record.setPukRequired(row.findElement(By.xpath(".//td[contains(@class, 'idGPUKReqFlg')]")).getAttribute("textContent"));
                    record.setPukLength(row.findElement(By.xpath(".//td[contains(@class, 'idGPUKLength')]")).getAttribute("textContent"));
//                    record.setValidityInDays(row.findElement(By.xpath(".//td[contains(@class, 'idGExpiryInDays')]")).getAttribute("textContent"));
                    record.setImportEncryptionZone(row.findElement(By.xpath(".//td[contains(@class, 'idGImportEncZoneID')]")).getAttribute("textContent"));
                    record.setSmsEncryptionZone(row.findElement(By.xpath(".//td[contains(@class, 'idGExportEncZoneID')]")).getAttribute("textContent"));
                    //record.setImportGeneratePuk(row.findElement(By.xpath(".//td[contains(@class, 'idGImportGeneratePukFlag')]")).getAttribute("textContent"));
                    record.setSmsInterface(row.findElement(By.xpath(".//td[contains(@class, 'idGExportInterfaceId')]")).getAttribute("textContent"));
                    record.setReturnInterface(row.findElement(By.xpath(".//td[contains(@class, 'idGReturnInterfaceId')]")).getAttribute("textContent"));
                    found = true;
                    break;
                }
            }
            if(!found){
                record.setName(null);
            }
        }

        return(record);
    }

    public void dblClickTokenApplicationProfileByName(String name){

        Actions action = new Actions(webDriver);

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        int rowCount = adminCommon.getDataRowCount();

        for(int i = 1; i <= rowCount; i++){
            WebElement cell = orAdmin.tblTokenApplicationProfileList().findElement(By.xpath("(//td[contains(@class, \"idGNam\")])[" + i + "]"));
            if(cell.getAttribute("textContent").equals(name)){
                // press the id key
                action.moveToElement(cell).doubleClick().perform();
                myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
                break;
            }
        }

    }

    public void refreshTokenApplicationProfileTable(){

        orAdmin.btnTokenApplicationProfileRefresh().click();

    }


}
