package com.aconite.apm.gui.automation.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OR_Admin {

    public static WebDriver webDriver;

    public OR_Admin(WebDriver webDriver){
        this.webDriver = webDriver;
//        System.out.println("OR Page Creation: " + this.webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /****************************************************************************************
     * Search Field Objects
     ****************************************************************************************/

    /* Headers */

    public WebElement spanIssuerSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idIssuerSearch_header_hd-textEl\"]"));
    }

    public static WebElement spanTokenProductsSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenProductsSearch_header_hd-textEl\"]"));
    }

    public static WebElement spanTokenProductGroupsSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenProductGroupsSearch_header_hd-textEl\"]"));
    }

    public WebElement spanSmsTemplateSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTemplateSearch_header_hd-textEl\"]"));
    }

    public WebElement spanMessageTemplateSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idMessageSearch_header_hd-textEl\"]"));
    }

    /* Search Fields */

    public WebElement selSearchInstitution(){
        return webDriver.findElement(By.xpath("//input[@id=\"idSInstitution-inputEl\"]"));
    }

    public WebElement selSearchIssuer(){
        return webDriver.findElement(By.xpath("//input[@id=\"idSIssuer-inputEl\"]"));
    }

    public WebElement selSearchTokenProductGroups(){
        return webDriver.findElement(By.xpath("//input[@id=\"idSTokenProductGroups-inputEl\"]"));
    }

    public WebElement selSearchTemplateType(){
        return webDriver.findElement(By.xpath("//input[@id=\"idSTemplateType-inputEl\"]"));
    }

    public WebElement txtSearchName(){
        return webDriver.findElement(By.xpath("//input[@id=\"idSName-inputEl\"]"));
    }

    public WebElement btnSearch(){
        return webDriver.findElement(By.xpath("//span[text()=\"Search\"]"));
    }

    public WebElement btnReset(){
        return webDriver.findElement(By.xpath("//span[text()=\"Reset\"]"));
    }

    /* Common Items */
    public List<WebElement> dropDownItems(){
        return webDriver.findElements(By.xpath("//div[contains(@id,\"boundlist\") and not (contains(@style,\"display: none\")) and not (contains(@id,\"-listEl\"))]//li[contains(@class,\"x-boundlist-item\")]"));
    }

    public WebElement btnAdd(){
        return webDriver.findElement(By.xpath("//span[contains(@class,'icon-add')][1]"));
    }

    public List<WebElement> tblRows(){
        return webDriver.findElements(By.xpath("//tr[contains(@class, \"x-grid-row\")]"));
    }

    public WebElement txtMsg(){
        return webDriver.findElement(By.xpath("//div[@id=\"messagebox-1001-displayfield-inputEl\"]"));
    }

    public WebElement btnOK(){
        return webDriver.findElement(By.xpath("//button[@id=\"button-1005-btnEl\"]"));
    }

    public WebElement btnYes(){
        return webDriver.findElement(By.xpath("//*[@id=\"button-1006-btnEl\"]"));
    }

    /****************************************************************************************
     * Message Template Objects
     ****************************************************************************************/

    public WebElement spanMessageTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idMessageList_header_hd-textEl\"]"));
    }

    public WebElement tblMessageTemplateList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idMessageList-body\"]"));
    }

    public WebElement btnMessageTemplateRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idMessageBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtMessageDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1058-inputEl\"]"));
    }

    public WebElement txtMessageDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idName-inputEl\"]"));
    }

    public WebElement selMessageDetailInstitution(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idInstitution-inputEl\"]"));
    }

    public WebElement cbxMessageDetailPan(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPAN-inputEl\"]"));
    }

    public WebElement cbxMessageDetailPanAlias(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPANAlias-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPinPukFlag(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPinPukFlag-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPinBlock(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPINB-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPinVerificationValue(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPINPVV-inputEl\"]"));

    }

    public WebElement cbxMessageDetailCustomerCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idCustomerCode-inputEl\"]"));

    }

    public WebElement cbxMessageDetailTokenProductName(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idETPN-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPanSequence(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPANSEQ-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPanId(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPANId-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPukBlock(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPUKB-inputEl\"]"));

    }

    public WebElement cbxMessageDetailPukVerificationValue(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPUKPVV-inputEl\"]"));

    }

    public WebElement cbxMessageDetailOperation(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idOperation-inputEl\"]"));

    }

    public WebElement cbxMessageDetailAppSequenceNumber(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEAppSEQ-inputEl\"]"));

    }

    public WebElement cbxMessageDetailExpiryDate(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//input[@id=\"idEPANED-inputEl\"]"));

    }

    public WebElement txtMessageDetailFixedData(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//textarea[@id=\"idFixedData-inputEl\"]"));
    }

    public WebElement btnMessageDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//span[text()=\"Create\"]"));

    }

    public WebElement btnMessageDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"divMessageEdit\"]//span[text()=\"Cancel\"]"));

    }

    public WebElement btnMessageDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idMessageEdit\"]//div[@id=\"idMessageEditFooter-innerCt\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * SMS Template Objects
     ****************************************************************************************/

    public WebElement spanTemplateTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTemplateList_header_hd-textEl\"]"));
    }

    public WebElement tblTemplateList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateList-body\"]"));
    }

    public WebElement btnTemplateRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtTemplateDetailId() {
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1061-inputEl\"]"));
    }

    public WebElement txtTemplateDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//input[@id=\"idName-inputEl\"]"));
    }

    public WebElement selTemplateDetailInstitution(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//input[@id=\"idInstitution-inputEl\"]"));
    }

    public WebElement selTemplateDetailTemplateType() {
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//input[@id=\"idTemplateType-inputEl\"]"));
    }

    public WebElement btnTemplateDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnTemplateDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnTemplateDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTemplateEdit\"]//div[@id=\"idTemplateEditFooter-innerCt\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * Institutions Page Objects
     ****************************************************************************************/

    public WebElement spanInstitutionsTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idInstitutionList_header_hd-textEl\"]"));
    }

    public WebElement tblInstitutionList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionList-body\"]"));
    }

    public WebElement btnInstitutionsRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtInstitutionDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1051-inputEl\"]"));
    }

    public WebElement txtInstitutionDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//input[@id=\"idName-inputEl\"]"));
    }

    public WebElement selInstitutionDetailLocalZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//input[@id=\"idLocalzone-inputEl\"]"));
    }

    public WebElement selInstitutionDetailInstitutionZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//input[@id=\"idInstzone-inputEl\"]"));
    }

    public WebElement selInstitutionDetailInterfaceZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//input[@id=\"idInterfacezone-inputEl\"]"));
    }

    public WebElement txtInstitutionDetailMaxVppPinIdSeconds(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//input[@id=\"idMaxVPPPinId-inputEl\"]"));
    }

    public WebElement btnInstitutionDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnInstitutionDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnInstitutionDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInstitutionEdit\"]//div[@id=\"idInstitutionEditFooter-innerCt\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * Issuers Page Objects
     ****************************************************************************************/

    public WebElement spanIssuersTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idIssuerSearch_header_hd-textEl\"]"));
    }

    public WebElement tblIssuerList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerList-body\"]"));
    }

    public WebElement btnIssuerRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtIssuerDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1059-inputEl\"]"));
    }

    public WebElement txtIssuerDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//input[@id=\"idEName-inputEl\"]"));
    }

    public WebElement txtIssuerDetailInstitutionName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//input[@id=\"idEInstitution-inputEl\"]"));
    }

    public WebElement selIssuerDetailCountry(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//input[@id=\"idECountry-inputEl\"]"));
    }

    public WebElement btnIssuerDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnIssuerDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnIssuerDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idIssuerEdit\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * Token Product Groups Page Objects
     ****************************************************************************************/
    public WebElement spanTokenProductGroupsTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenProductGroupsSearch_header_hd-textEl\"]"));
    }

    public WebElement tblTokenProductGroupsList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductGroupsList-body\"]"));
    }

    public WebElement btnTokenProductGroupsRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductGroupsBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtTokenProductGroupsDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1059-inputEl\"]"));
    }

    public WebElement txtTokenProductGroupsDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//input[@id=\"idEName-inputEl\"]"));
    }

    public WebElement selTokenProductGroupsDetailIssuer(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//input[@id=\"idEIssuer-inputEl\"]"));
    }

    public WebElement txtTokenProductGroupsDetailGroupCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//input[@id=\"idEGroupCode-inputEl\"]"));
    }

    public WebElement btnTokenProductGroupsDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnTokenProductGroupsDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnTokenProductGroupsDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"divTokenProductGroupsEdit\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * Token Product Page Objects
     ****************************************************************************************/

    public WebElement spanTokenProductTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenProductsList_header_hd-textEl\"]"));
    }

    public WebElement spanTokenProductSearchHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenProductsSearch_header_hd-textEl\"]"));
    }

    public WebElement tblTokenProductList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsList-body\"]"));
    }

    public WebElement btnTokenProductRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtTokenProductDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"idID-inputEl\"]"));
    }

    public WebElement txtTokenProductDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idName-inputEl\"]"));
    }

    public WebElement txtTokenProductDetailIssuerTokenProductCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idIssuerTokenProductCode-inputEl\"]"));
    }

    public WebElement selTokenProductDetailIssuer(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idIssuerid-inputEl\"]"));
    }

    public WebElement selTokenProductDetailTokenProductGroup(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idTokenProductGroupID-inputEl\"]"));
    }

    public WebElement txtTokenProductDetailRetentionDays(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idRetentionDays-inputEl\"]"));
    }

    public WebElement selTokenProductDetailCountry(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idCountryCode-inputEl\"]"));
    }

    public WebElement selTokenProductDetailLanguage(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idLanguangeCode-inputEl\"]"));
    }

    public WebElement selTokenProductDetailPersoBureau(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idPersoBureauID-inputEl\"]"));
    }

    public WebElement cbxTokenProductDetailFeedbackRequired(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idFeedbackRequired-inputEl\"]"));
    }

    public WebElement cbxTokenProductDetailActive(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idStatus-inputEl\"]"));
    }

    public WebElement txtTokenProductDetailServiceCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//input[@id=\"idServiceCode-inputEl\"]"));
    }

    public WebElement btnTokenProductDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnTokenProductDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnTokenProductDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenProductsEdit\"]//span[text()=\"Save\"]"));
    }

    /****************************************************************************************
     * Token Application Profile Page Objects
     ****************************************************************************************/

    public WebElement spanTokenApplicationProfileTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idTokenAppProfilesList_header_hd-textEl\"]"));
    }

    public WebElement tblTokenApplicationProfileList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesList-body\"]"));
    }

    public WebElement btnTokenApplicationProfileAdd(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesTBar\"]//span[contains(@id,\"button\") and contains(text(),\"Add\")]"));
    }

    public WebElement btnTokenApplicationProfileRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1140-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idNameTAP-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailTokenProduct(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idTokenProductId-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailAppSeqNumber(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idAppSeqNumberTAP-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailStatus(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idStatusTAP-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailDefaultApp(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idDefaultAppFlagTAP-inputEl\"]"));
    }

    public WebElement tabTokenApplicationProfileDetailPINDetails(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"PIN Details\")]"));
    }

    public WebElement tabTokenApplicationProfileDetailPUKDetails(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"PUK Details\")]"));
    }

    public WebElement tabTokenApplicationProfileDetailVerification(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"Verification\")]"));
    }

    public WebElement tabTokenApplicationProfileDetailDelivery(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"Delivery\")]"));
    }

    public WebElement tabTokenApplicationProfileDetailTemplates(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"Templates\")]"));
    }

    public WebElement tabTokenApplicationProfileDetailSMS(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[contains(@id,\"tab\") and contains(text(),\"SMS\")]"));
    }

    /* PIN Details */

    public WebElement cbxTokenApplicationProfileDetailPINRequired(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPINRequiredFlagTAP-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPINLength(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPINlengthTAP-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailValidityInDays(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idExpiryInDaysTAP-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailImportEncryptionZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEImportEncryptionZone-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailSMSInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEExportInterface-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailSMSEncryptionZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEExportEncryptionZone-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailReturnInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEReturnInterface-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPinDeliveryMethodId-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPINMailerDelayHours(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPinMailerDelay-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPINHeldBySeqNum(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEUsesPinOfTokenAppSeqNum-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailAllowPINChange(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEAllowPinChangeFlag-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailAllowOnlinePINChange(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEAllowOnlinePinChangeFlag-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailAllowOnlinePINView(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEAllowOnlinePinViewFlag-inputEl\"]"));
    }

    /* PUK Details */

    public WebElement cbxTokenApplicationProfileDetailPUKRequired(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPUKrequiredflagTAP-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPUKLength(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPUKlengthTAP-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailAllowPUKChange(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEAllowPukChangeFlag-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPUKHeldBySeqNum(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEUsesPukOfTokenAppSeqNum-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailImportGeneratePUK(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idImportGeneratePukFlag-inputEl\"]"));
    }

    /* Verification */

    public WebElement selTokenApplicationProfileDetailPINVerificationMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPinVerficationMethodId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPINVerificationKey(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPinVerficationKeyId-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailPINTries(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPinTries-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailVerificationBackoff(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEVerificationBackoff-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailBackoffMultiplier(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEBackoffMultiplier-inputEl\"]"));
    }

    /* Delivery */

    public WebElement selTokenApplicationProfileDetailTokenImportPINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idETIPinDeliveryMethodId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailTokenImportOutputInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEImportOutputIntId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailTokenOrderPINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idETOWPDPinDeliveryMethodId-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailForceTOWPDPINDelivery(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEForceTOWPDPinDeliveryMethod-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailTokenOutputInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idTowpdOutputIntId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPINAdvicePINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPAPinDeliveryMethodId-inputEl\"]"));
    }

    public WebElement cbxTokenApplicationProfileDetailForcePINAdvicePINDelivery(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEForcePAPinDeliveryMethod-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPINAdviceOutputInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEPAOutputIntId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailUpdatePINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEUpdatePinDeliveryMethod-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailUpdateInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEOutputInterface-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailVPPPINDeliveryMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEVPPDeliveryMethodId-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailVPPInterface(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idEVPPInterface-inputEl\"]"));
    }

    /* Templates */

    public WebElement selTokenApplicationProfileDetailPINTemplate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPinTemplateid-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailSecondaryPINTemplate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSecondaryPinTemplateid-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPUKTemplate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPukTemplateid-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailPasswordTemplate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPasswordTemplateid-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailMessageTemplate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idMessageTemplateid-inputEl\"]"));
    }

    /* SMS */

    public WebElement txtTokenApplicationProfileDetailPINOverSMSDelayHours(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idPinOverSMSDelay-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailSMSPasswordDelayHours(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSMSPasswordDelay-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailSMSSender(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSmsSender-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailSMSValidityHours(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSmsValidity-inputEl\"]"));
    }

    public WebElement txtTokenApplicationProfileDetailSMSPasswordHours(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSmsPasswordExpiry-inputEl\"]"));
    }

    public WebElement selTokenApplicationProfileDetailSMSClass(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//input[@id=\"idSmsClass-inputEl\"]"));
    }

    public WebElement btnTokenApplicationProfileDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[text()=\"Save\"]"));
    }

    public WebElement btnTokenApplicationProfileDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnTokenApplicationProfileDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idTokenAppProfilesEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement spnPUKLength(){
        return webDriver.findElement(By.xpath("//table[@id=\"idPUKlengthTAP-triggerWrap\"]"));
    }

    public WebElement spnPUKHeldBySeqNum(){
        return webDriver.findElement(By.xpath("//table[@id=\"idEUsesPukOfTokenAppSeqNum-triggerWrap\"]"));
    }

    public WebElement spnPINTries(){
        return webDriver.findElement(By.xpath("//table[@id=\"idEPinTries-triggerWrap\"]"));
    }

    public WebElement spnVerificationBackoff(){
        return webDriver.findElement(By.xpath("//table[@id=\"idEVerificationBackoff-triggerWrap\"]"));
    }

    public WebElement spnBackoffMultipliers(){
        return webDriver.findElement(By.xpath("//table[@id=\"idEBackoffMultiplier-triggerWrap\"]"));
    }

    public WebElement spnSMSPasswordDelayHours(){
        return webDriver.findElement(By.xpath("//table[@id=\"idSMSPasswordDelay-triggerWrap\"]"));
    }

    public WebElement spnSMSValidityHours(){
        return webDriver.findElement(By.xpath("//table[@id=\"idSmsValidity-triggerWrap\"]"));
    }

    public WebElement spnSMSPasswordHours(){
        return webDriver.findElement(By.xpath("//table[@id=\"idSmsPasswordExpiry-triggerWrap\"]"));
    }

    /****************************************************************************************
     * PVV Page Objects
     ****************************************************************************************/

    public WebElement spanPVVTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idPVVList_header_hd-textEl\"]"));
    }

    public WebElement tblPVVList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVList-body\"]"));
    }

    public WebElement btnPVVAdd(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVTBar\"]//span[contains(@id,\"button\") and contains(text(),\"Add\")]"));
    }

    public WebElement btnPVVRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement txtPVVDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1168-inputEl\"]"));
    }

    public WebElement selPVVDetailTokenProduct(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//input[@name=\"tokenProductId\"]"));
    }

    public WebElement txtPVVDetailAppSeqNumber(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//input[@name=\"appSeqNumber\"]"));
    }

    public WebElement txtPVVDetailPvkIdentifier(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//input[@name=\"pvkIdentifier\"]"));
    }

    public WebElement selPVVDetailPinVerificationMethod(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//input[@name=\"pinVerificationMethodId\"]"));
    }

    public WebElement selPVVDetailPinVerificationKey(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//input[@name=\"sciPinVerificationKeyId\"]"));
    }

    public WebElement btnPVVDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//span[text()=\"Save\"]"));
    }

    public WebElement btnPVVDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnPVVDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPVVEdit\"]//span[text()=\"Cancel\"]"));
    }

    /*
     * --------------------------------------------------------------------------
     * Country Page Objects
     * --------------------------------------------------------------------------
     */

    public WebElement countryList(){return webDriver.findElement(By.xpath("//div[@id=\"divCountryList\"]")); }

    public WebElement spanCountryTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idCountryList_header_hd-textEl\"]"));
    }

    public WebElement tblCountryList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryList-body\"]"));
    }

    public WebElement btnCountryAdd(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryTBar\"]//span[contains(@id,\"button\") and contains(text(),\"Add\")]"));
    }

    public WebElement btnCountryRefresh(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryBBar\"]/div/div/div[contains(@id,'button')]/em/button[@data-qtip=\"Refresh\"]"));
    }

    public WebElement btnCountryCodeHeader(){
        return webDriver.findElement(By.xpath("//div[@id=\"idGCode-triggerEl\"]"));
    }

    public WebElement btnCountryCodeSortAscending(){
        return webDriver.findElement(By.xpath("//span[@id=\"menuitem-1056-textEl\"]"));
    }

    public WebElement btnCountryCodeSortDescending(){
        return webDriver.findElement(By.xpath("//span[@id=\"menuitem-1057-textEl\"]"));
    }

    public WebElement btnCountryTableFirst(){
        return webDriver.findElement(By.xpath("//button[@id=\"button-1038-btnEl\"]"));
    }

    public WebElement btnCountryTableLast(){
        return webDriver.findElement(By.xpath("//button[@id=\"button-1046-btnEl\"]"));
    }

    public WebElement btnCountryTablePrevious(){
        return webDriver.findElement(By.xpath("//button[@id=\"button-1039-btnEl\"]"));
    }

    public WebElement btnCountryTableNext(){
        return webDriver.findElement(By.xpath("//button[@id=\"button-1045-btnEl\"]"));
    }

    public WebElement txtCountryTablePage(){
        return webDriver.findElement(By.xpath("//input[@id=\"numberfield-1042-inputEl\"]"));
    }

    public WebElement txtCountryTablePageCount(){
        return webDriver.findElement(By.xpath("//div[@id=\"tbtext-1050\"]"));
    }

    public WebElement txtCountryDetailId(){
        return webDriver.findElement(By.xpath("//div[@id=\"displayfield-1065-inputEl\"]"));
    }

    public WebElement txtCountryDetailCountryCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryEdit\"]//input[@id=\"idCode-inputEl\"]"));
    }

    public WebElement txtCountryDetailCountryName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryEdit\"]//input[@id=\"idName-inputEl\"]"));
    }

    public WebElement btnCountryDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryEdit\"]//span[text()=\"Save\"]"));
    }

    public WebElement btnCountryDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnCountryDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idCountryEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement hdrCountryCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"divCountryList\"]//span[text()=\"Country Code\"]"));
    }

    /****************************************************************************************
     * Encryption > Keys Page Objects
     ****************************************************************************************/

    public WebElement keyList(){return webDriver.findElement(By.xpath("//div[@id=\"divKeyList\"]")); }

    public WebElement spanKeyTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idKeyList_header_hd-textEl\"]"));
    }

    public WebElement tblKeyList(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyList-body\"]"));
    }

    public WebElement selSearchKeyType(){ return webDriver.findElement(By.xpath("//div[@id=\"divKeySearch\"]//input[@name=\"keyTypeListId\"]")); }


    public WebElement btnKeyDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement btnKeyDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//span[text()=\"Save\"]"));
    }

    public WebElement btnKeyDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement selKeyDetailStatus(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"status\"]"));
    }

    public WebElement selKeyDetailKeyType(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"keyTypeId\"]"));
    }

    public WebElement dateKeyDetailExpiryDate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"expiryDate\"]"));
    }

    public WebElement txtKeyDetailIndex(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"index\"]"));
    }

    public WebElement txtKeyDetailDecimalisationTable(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"decimalisationTable\"]"));
    }

    public WebElement cbxKeyDetailDecimalisationTableEncryption(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@id=\"idDecTableEncryptedFlag-inputEl\"]"));
    }

    public WebElement txtKeyDetailValidationPattern(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"validationDataPattern\"]"));
    }

    public WebElement txtKeyDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"name\"]"));
    }

    public WebElement selKeyDetailHsmType(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"hsmType\"]"));
    }

    public WebElement txtKeyDetailMkCheckValue(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"lmkKCV\"]"));
    }

    public WebElement txtKeyDetailSciKeyType(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"sciKeyType\"]"));
    }

    public WebElement selKeyDetailKeyAlgorithm(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"keyAlgorithm\"]"));
    }

    public WebElement txtKeyDetailBlockSize(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"blockSize\"]"));
    }

    public WebElement txtKeyDetailKeyValue(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//textarea[@name=\"keyValue\"]"));
    }

    public WebElement txtKeyDetailCheckValue(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"keyKCV\"]"));
    }

    public WebElement txtKeyDetailExtension(){
        return webDriver.findElement(By.xpath("//div[@id=\"idKeyEdit\"]//input[@name=\"extension\"]"));
    }

    /*
     * --------------------------------------------------------------------------
     * Interfaces > Perso Bureau Page Objects
     * --------------------------------------------------------------------------
     */
    public WebElement tblPersoBureauList(){return webDriver.findElement(By.xpath("//div[@id=\"divPersoBureauList\"]")); }

    public WebElement spanPersoBureauTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idPersoBureauList_header_hd-textEl\"]"));
    }

    public WebElement btnPersoBureauDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnPersoBureauDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement txtPersoBureauDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@name=\"name\"]"));
    }

    public WebElement txtPersoBureauDetailCode(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@name=\"code\"]"));
    }

    public WebElement txtPersoBureauDetailDestinationDirectory(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@name=\"destinationDirectory\"]"));
    }

    public WebElement selPersoBureauDetailPinEncryptionZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@name=\"encryptionZoneId\"]"));
    }

    public WebElement cbxPersoBureauDetailExtractPan(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@id=\"idExtractPan-inputEl\"]"));
    }

    public WebElement cbxPersoBureauDetailExtractPanDisplay(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//input[@id=\"idExtractPanDisplay-inputEl\"]"));
    }

    public WebElement btnPersoBureauDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idPersoBureauEdit\"]//span[text()=\"Save\"]"));
    }

    /*
     * --------------------------------------------------------------------------
     * Interfaces > Interfaces Objects
     * --------------------------------------------------------------------------
     */
    public WebElement tblInterfaceList(){return webDriver.findElement(By.xpath("//div[@id=\"divInterfaceList\"]")); }

    public WebElement spanInterfaceTableHeader(){
        return webDriver.findElement(By.xpath("//span[@id=\"idInterfaceList_header_hd-textEl\"]"));
    }

    public WebElement btnInterfaceDetailCreate(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//span[text()=\"Create\"]"));
    }

    public WebElement btnInterfaceDetailCancel(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//span[text()=\"Cancel\"]"));
    }

    public WebElement txtInterfaceDetailName(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"name\"]"));
    }

    public WebElement selInterfaceDetailType(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"interfaceTypeId\"]"));
    }

    public WebElement selInterfaceDetailInstitution(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"institutionId\"]"));
    }

    public WebElement selInterfaceDetailEncryptionZone(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"encryptionZoneId\"]"));
    }

    public WebElement txtInterfaceDetailHost(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"ipAddress\"]"));
    }

    public WebElement txtInterfaceDetailPort(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"ipPort\"]"));
    }

    public WebElement txtInterfaceDetailTimeout(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"timeout\"]"));
    }

    public WebElement cbxInterfaceDetailSSL(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@id=\"idSSL-inputEl\"]"));
    }

    public WebElement txtInterfaceDetailKeystorePath(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"keystorePath\"]"));
    }

    public WebElement txtInterfaceDetailKeystorePassword(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"keystorePassword\"]"));
    }

    public WebElement txtInterfaceDetailKeystorePasswordConfirmation(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"keystorePasswordConfirmation\"]"));
    }

    public WebElement txtInterfaceDetailCertificateAlias(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"certificateAlias\"]"));
    }

    public WebElement txtInterfaceDetailKeyPassword(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"keyPassword\"]"));
    }

    public WebElement txtInterfaceDetailKeyPasswordConfirmation(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"keyPasswordConfirmation\"]"));
    }

    public WebElement txtInterfaceDetailContext(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"context\"]"));
    }

    public WebElement txtInterfaceDetailUsername(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"username\"]"));
    }

    public WebElement txtInterfaceDetailPassword(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"password\"]"));
    }

    public WebElement txtInterfaceDetailPasswordConfirmation(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//input[@name=\"passwordConfirmation\"]"));
    }

    public WebElement btnInterfaceDetailSave(){
        return webDriver.findElement(By.xpath("//div[@id=\"idInterfaceEdit\"]//span[text()=\"Save\"]"));
    }

    /*
     * --------------------------------------------------------------------------
     * Task Scheduler Objects
     * --------------------------------------------------------------------------
     */

    public WebElement tblTaskSchedulerList(){
        return webDriver.findElement(By.xpath("//div[@id=\"divSchedulerList\"]"));
    }

}
