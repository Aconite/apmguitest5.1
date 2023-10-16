package com.aconite.apm.gui.automation.records;



public class TokenApplicationProfileDataRecord {

    private String parentInstitution;
    private String parentIssuer;
    private String parentTokenProduct;
    private String parentTokenProductId;
    private String name;
    private String appSequenceNumber;
    private String status;
    private String dbStatus;
    private String defaultApp;
    private String pinRequired;
    private String pinLength;
    private String validityInDays;
    private String importEncryptionZone;
    private String smsInterface;
    private String smsEncryptionZone;
    private String returnInterface;
    private String pinDeliveryMethod;
    private String pinMailerDelayHours;
    private String pinHeldBySeqNum;
    private String allowPinChange;
    private String allowOnlinePinChange;
    private String allowOnlinePinView;
    private String pukRequired;
    private String pukLength;
    private String allowPukChange;
    private String pukHeldBySeqNum;
    private String importGeneratePuk;
    private String pinVerificationMethod;
    private String pinVerificationKey;
    private String pinTries;
    private String verificationBackoff;
    private String backoffMultiplier;
    private String tokenImportPinDeliveryMethod;
    private String tokenImportOutputInterface;
    private String tokenOrderPinDeliveryMethod;
    private String forceTokenOrderPinDelivery;
    private String tokenOutputInterface;
    private String pinAdvicePinDeliveryMethod;
    private String forcePinAdvicePinDelivery;
    private String pinAdviceOutputInterface;
    private String updatePinDeliveryMethod;
    private String updateInterface;
    private String vppPinDeliveryMethod;
    private String vppInterface;
    private String pinTemplate;
    private String secondaryPinTemplate;
    private String pukTemplate;
    private String passwordTemplate;
    private String messageTemplate;
    private String pinOverSMSDelayHours;
    private String smsPasswordDelayHours;
    private String smsSender;
    private String smsValidityHours;
    private String smsPasswordHours;
    private String smsClass;

    public TokenApplicationProfileDataRecord(){
        parentInstitution=" ";
        parentIssuer=" ";
        parentTokenProduct=" ";
        parentTokenProductId=" ";
        name=" ";
        appSequenceNumber=" ";
        status="I";
        defaultApp="false";
        pinRequired="false";
        pinLength=" ";
        validityInDays=" ";
        importEncryptionZone=" ";
        smsInterface=" ";
        smsEncryptionZone=" ";
        returnInterface=" ";
        pinDeliveryMethod=" ";
        pinMailerDelayHours=" ";
        pinHeldBySeqNum=" ";
        allowPinChange="false";
        allowOnlinePinChange="false";
        allowOnlinePinView="false";
        pukRequired="false";
        pukLength=" ";
        allowPukChange="false";
        pukHeldBySeqNum=" ";
        importGeneratePuk=" ";
        pinVerificationMethod=" ";
        pinVerificationKey=" ";
        pinTries=" ";
        verificationBackoff=" ";
        backoffMultiplier=" ";
        tokenImportPinDeliveryMethod="No PIN-delivery required";
        tokenImportOutputInterface=" ";
        tokenOrderPinDeliveryMethod="No PIN-delivery required";
        forceTokenOrderPinDelivery="false";
        tokenOutputInterface=" ";
        pinAdvicePinDeliveryMethod="No PIN-delivery required";
        forcePinAdvicePinDelivery="false";
        pinAdviceOutputInterface=" ";
        updatePinDeliveryMethod=" ";
        updateInterface=" ";
        vppPinDeliveryMethod=" ";
        vppInterface=" ";
        pinTemplate=" ";
        secondaryPinTemplate=" ";
        pukTemplate=" ";
        passwordTemplate=" ";
        messageTemplate=" ";
        pinOverSMSDelayHours=" ";
        smsPasswordDelayHours=" ";
        smsSender=" ";
        smsValidityHours=" ";
        smsPasswordHours=" ";
        smsClass=" ";
    }

    private String nullEmptyFix(String param){
        if (param==null || param.equals("") || param.equals("\u00A0")){
            param = " ";
        }
        return param;
    }

    private String statusFix(String param){
        if (param==null || param.equals("") || param.equals("\u00A0") || param.equals(" ")){
            param = "I";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if (param.equals("Y") || param.equals("A")){
            param = "true";
        }
        if (param.equals("I")|| param.equals("N")){
            param = "false";
        }
        return param;
    }

    public String getParentInstitution()
    {
        return parentInstitution;
    }

    public void setParentInstitution(String parentInstitution)
    {
        this.parentInstitution = parentInstitution;
    }

    public String getParentIssuer()
    {
        return parentIssuer;
    }

    public void setParentIssuer(String parentIssuer)
    {
        this.parentIssuer = parentIssuer;
    }

    public String getParentTokenProduct(){ return parentTokenProduct; }

    public void setParentTokenProduct(String parentTokenProduct) { this.parentTokenProduct = parentTokenProduct; }

    public String getParentTokenProductId() { return parentTokenProductId; }

    public void setParentTokenProductId(String parentTokenProductId) { this.parentTokenProductId = parentTokenProductId; }

    public String getName()
    {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getAppSequenceNumber() { return appSequenceNumber; }

    public void setAppSequenceNumber(String appSequenceNumber) { this.appSequenceNumber = appSequenceNumber; }

    public String getStatus() { return status; }

    public String getDBStatus(){ return dbStatus; }

    public void setStatus(String status){
        this.status = statusFix(status);
        setDBStatus(status);
    }

    public void setDBStatus(String status){

        if(status.equals("Active") || status.equals("A")){
            this.dbStatus="A";
        }
        if(status.equals("Inactive") || status.equals("I")){
            this.dbStatus="I";
        }
    }

    public String getDefaultApp() {  return defaultApp; }

    public void setDefaultApp(String defaultApp) {
        this.defaultApp = setToTrueFalse(defaultApp);
    }

    public String getPinRequired() {
        return pinRequired;
    }

    public void setPinRequired(String pinRequired) {
        this.pinRequired = setToTrueFalse(pinRequired);
    }

    public String getPinLength() { return pinLength; }

    public void setPinLength(String pinLength) {
        this.pinLength = pinLength;
    }

    public String getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(String validityInDays) {
        this.validityInDays = nullEmptyFix(validityInDays);
    }

    public String getImportEncryptionZone() {
        return importEncryptionZone;
    }

    public void setImportEncryptionZone(String importEncryptionZone) {
        this.importEncryptionZone = nullEmptyFix(importEncryptionZone);
    }

    public String getSmsInterface() {
        return smsInterface;
    }

    public void setSmsInterface(String smsInterface) {
        this.smsInterface = nullEmptyFix(smsInterface);
    }

    public String getSmsEncryptionZone() {
        return smsEncryptionZone;
    }

    public void setSmsEncryptionZone(String smsEncryptionZone) {
        this.smsEncryptionZone = nullEmptyFix(smsEncryptionZone);
    }

    public String getReturnInterface() {
        return returnInterface;
    }

    public void setReturnInterface(String returnInterface) {
        this.returnInterface = nullEmptyFix(returnInterface);
    }

    public String getPinDeliveryMethod() {
        return pinDeliveryMethod;
    }

    public void setPinDeliveryMethod(String pinDeliveryMethod) {
        this.pinDeliveryMethod = nullEmptyFix(pinDeliveryMethod);
    }

    public String getPinMailerDelayHours() {
        return pinMailerDelayHours;
    }

    public void setPinMailerDelayHours(String pinMailerDelayHours) {
        this.pinMailerDelayHours = nullEmptyFix(pinMailerDelayHours);
    }

    public String getPinHeldBySeqNum() {
        return pinHeldBySeqNum;
    }

    public void setPinHeldBySeqNum(String pinHeldBySeqNum) {
        this.pinHeldBySeqNum = nullEmptyFix(pinHeldBySeqNum);
    }

    public String getAllowPinChange() {
        return allowPinChange;
    }

    public void setAllowPinChange(String allowPinChange) {
        this.allowPinChange = setToTrueFalse(allowPinChange);
    }

    public String getAllowOnlinePinChange() {
        return allowOnlinePinChange;
    }

    public void setAllowOnlinePinChange(String allowOnlinePinChange) {
        this.allowOnlinePinChange = setToTrueFalse(allowOnlinePinChange);
    }

    public String getAllowOnlinePinView() {
        return allowOnlinePinView;
    }

    public void setAllowOnlinePinView(String allowOnlinePinView) {
        this.allowOnlinePinView = setToTrueFalse(allowOnlinePinView);
    }

    public String getPukRequired() {
        return pukRequired;
    }

    public void setPukRequired(String pukRequired) {
        this.pukRequired = setToTrueFalse(pukRequired);
    }

    public String getPukLength() {
        return pukLength;
    }

    public void setPukLength(String pukLength) {
        this.pukLength = nullEmptyFix(pukLength);
    }

    public String getAllowPukChange() {
        return allowPukChange;
    }

    public void setAllowPukChange(String allowPukChange) {
        this.allowPukChange = setToTrueFalse(allowPukChange);
    }

    public String getPukHeldBySeqNum() {
        return pukHeldBySeqNum;
    }

    public void setPukHeldBySeqNum(String pukHeldBySeqNum) {
        this.pukHeldBySeqNum = nullEmptyFix(pukHeldBySeqNum);
    }

    public String getImportGeneratePuk() {
        return importGeneratePuk;
    }

    public String getDBImportGeneratePuk() {
        String dbImportGeneratePuk="";
        if(importGeneratePuk.equals("Import") || importGeneratePuk.equals("I")){
            dbImportGeneratePuk="I";
        }
        if(importGeneratePuk.equals("Generate") || importGeneratePuk.equals("G")){
            dbImportGeneratePuk="G";
        }
        return dbImportGeneratePuk;
    }

    public void setImportGeneratePuk(String importGeneratePuk) {
        this.importGeneratePuk = nullEmptyFix(importGeneratePuk);
    }

    public String getPinVerificationMethod() {
        return pinVerificationMethod;
    }

    public void setPinVerificationMethod(String pinVerificationMethod) {
        this.pinVerificationMethod = nullEmptyFix(pinVerificationMethod);
    }

    public String getPinVerificationKey() {
        return pinVerificationKey;
    }

    public void setPinVerificationKey(String pinVerificationKey) {
        this.pinVerificationKey = nullEmptyFix(pinVerificationKey);
    }

    public String getPinTries() {
        return pinTries;
    }

    public void setPinTries(String pinTries) {
        this.pinTries = nullEmptyFix(pinTries);
    }

    public String getVerificationBackoff() {
        return verificationBackoff;
    }

    public void setVerificationBackoff(String verificationBackoff) {
        this.verificationBackoff = nullEmptyFix(verificationBackoff);
    }

    public String getBackoffMultiplier() {
        return backoffMultiplier;
    }

    public void setBackoffMultiplier(String backoffMultiplier) {
        this.backoffMultiplier = nullEmptyFix(backoffMultiplier);
    }

    public String getTokenImportPinDeliveryMethod() {
        return tokenImportPinDeliveryMethod;
    }

    public void setTokenImportPinDeliveryMethod(String tokenImportPinDeliveryMethod) {
        this.tokenImportPinDeliveryMethod = nullEmptyFix(tokenImportPinDeliveryMethod);
    }

    public String getTokenImportOutputInterface() {
        return tokenImportOutputInterface;
    }

    public void setTokenImportOutputInterface(String tokenImportOutputInterface) {
        this.tokenImportOutputInterface = nullEmptyFix(tokenImportOutputInterface);
    }

    public String getTokenOrderPinDeliveryMethod() {
        return tokenOrderPinDeliveryMethod;
    }

    public void setTokenOrderPinDeliveryMethod(String tokenOrderPinDeliveryMethod) {
        this.tokenOrderPinDeliveryMethod = nullEmptyFix(tokenOrderPinDeliveryMethod);
    }

    public String getForceTokenOrderPinDelivery() {
        return forceTokenOrderPinDelivery;
    }

    public void setForceTokenOrderPinDelivery(String forceTokenOrderPinDelivery) {
        this.forceTokenOrderPinDelivery = setToTrueFalse(forceTokenOrderPinDelivery);
    }

    public String getTokenOutputInterface() {
        return tokenOutputInterface;
    }

    public void setTokenOutputInterface(String tokenOutputInterface) {
        this.tokenOutputInterface = nullEmptyFix(tokenOutputInterface);
    }

    public String getPinAdvicePinDeliveryMethod() {
        return pinAdvicePinDeliveryMethod;
    }

    public void setPinAdvicePinDeliveryMethod(String pinAdvicePinDeliveryMethod) {
        this.pinAdvicePinDeliveryMethod = nullEmptyFix(pinAdvicePinDeliveryMethod);
    }

    public String getForcePinAdvicePinDelivery() {
        return forcePinAdvicePinDelivery;
    }

    public void setForcePinAdvicePinDelivery(String forcePinAdvicePinDelivery) {
        this.forcePinAdvicePinDelivery = setToTrueFalse(forcePinAdvicePinDelivery);
    }

    public String getPinAdviceOutputInterface() {
        return pinAdviceOutputInterface;
    }

    public void setPinAdviceOutputInterface(String pinAdviceOutputInterface) {
        this.pinAdviceOutputInterface = nullEmptyFix(pinAdviceOutputInterface);
    }

    public String getUpdatePinDeliveryMethod() {
        return updatePinDeliveryMethod;
    }

    public void setUpdatePinDeliveryMethod(String updatePinDeliveryMethod) {
        this.updatePinDeliveryMethod = nullEmptyFix(updatePinDeliveryMethod);
    }

    public String getUpdateInterface() {
        return updateInterface;
    }

    public void setUpdateInterface(String updateInterface) {
        this.updateInterface = nullEmptyFix(updateInterface);
    }

    public String getVppPinDeliveryMethod() {
        return vppPinDeliveryMethod;
    }

    public void setVppPinDeliveryMethod(String vppPinDeliveryMethod) {
        this.vppPinDeliveryMethod = nullEmptyFix(vppPinDeliveryMethod);
    }

    public String getVppInterface() {
        return vppInterface;
    }

    public void setVppInterface(String vppInterface) {
        this.vppInterface = nullEmptyFix(vppInterface);
    }

    public String getPinTemplate() {
        return pinTemplate;
    }

    public void setPinTemplate(String pinTemplate) {
        this.pinTemplate = nullEmptyFix(pinTemplate);
    }

    public String getSecondaryPinTemplate() {
        return secondaryPinTemplate;
    }

    public void setSecondaryPinTemplate(String secondaryPinTemplate) {
        this.secondaryPinTemplate = nullEmptyFix(secondaryPinTemplate);
    }

    public String getPukTemplate() {
        return pukTemplate;
    }

    public void setPukTemplate(String pukTemplate) {
        this.pukTemplate = nullEmptyFix(pukTemplate);
    }

    public String getPasswordTemplate() {
        return passwordTemplate;
    }

    public void setPasswordTemplate(String passwordTemplate) {
        this.passwordTemplate = nullEmptyFix(passwordTemplate);
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = nullEmptyFix(messageTemplate);
    }

    public String getPinOverSMSDelayHours() {
        return pinOverSMSDelayHours;
    }

    public void setPinOverSMSDelayHours(String pinOverSMSDelayHours) {
        this.pinOverSMSDelayHours = nullEmptyFix(pinOverSMSDelayHours);
    }

    public String getSmsPasswordDelayHours() {
        return smsPasswordDelayHours;
    }

    public void setSmsPasswordDelayHours(String smsPasswordDelayHours) {
        this.smsPasswordDelayHours = nullEmptyFix(smsPasswordDelayHours);
    }

    public String getSmsSender() {
        return smsSender;
    }

    public void setSmsSender(String smsSender) {
        this.smsSender = nullEmptyFix(smsSender);
    }

    public String getSmsValidityHours() {
        return smsValidityHours;
    }

    public void setSmsValidityHours(String smsValidityHours) {
        this.smsValidityHours = nullEmptyFix(smsValidityHours);
    }

    public String getSmsPasswordHours() {
        return smsPasswordHours;
    }

    public void setSmsPasswordHours(String smsPasswordHours) {
        this.smsPasswordHours = nullEmptyFix(smsPasswordHours);
    }

    public String getSmsClass() {
        return smsClass;
    }

    public String getDbSmsClass() {
        String dbSmsClass = "";
        if(this.smsClass.equals("Class 1 (normal)") || this.smsClass.equals("1")){
            dbSmsClass = "1";
        }
        if(this.smsClass.equals("Class 0 (flash)") || this.smsClass.equals("0")){
            dbSmsClass = "0";
        }
        return dbSmsClass;
    }

    public void setSmsClass(String smsClass) {
        this.smsClass = smsClass;
    }

    @Override
    public String toString()
    {
        return "Record: [NAME=" + getName() + ", TOKENPRODUCT=" + getParentTokenProduct() +
                ", APPSEQNUM=" + getAppSequenceNumber() + ", STATUS=" + getDBStatus() +
                ", DEFAULTAPP=" + getDefaultApp() + ", PINREQUIRED=" + getPinRequired() +
                ", PINLENGTH=" + getPinLength() + ", PINVERIFICATIONMETHOD=" + getPinVerificationMethod() +
                ", PINVERIFICATIONKEY=" + getPinVerificationKey() + ", PINTRIES=" + getPinTries() +
                ", PUKREQUIRED=" + getPukRequired() + ", VALIDITYINDAYS=" + getValidityInDays() +
                ", IMPORTENCRYPTIONZONE=" + getImportEncryptionZone() +
                ", EXPORTENCRYPTIONZONE=" + getSmsEncryptionZone() + ", IMPORTGENERATEPUK=" + getImportGeneratePuk() +
                ", EXPORTINTERFACE=" + getSmsInterface() + ", RETURNINTERFACE=" + getReturnInterface() + "]";

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final TokenApplicationProfileDataRecord other = (TokenApplicationProfileDataRecord) obj;

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getParentTokenProduct().equals(other.getParentTokenProduct()))
        {
            return false;
        }

        if (!this.getAppSequenceNumber().equals(other.getAppSequenceNumber()))
        {
            return false;
        }

        if (!this.getDBStatus().equals(other.getDBStatus()))
        {
            return false;
        }

        if (!this.getDefaultApp().equals(other.getDefaultApp()))
        {
            return false;
        }

        if (!this.getPinRequired().equals(other.getPinRequired()))
        {
            return false;
        }

        if (!this.getPinLength().equals(other.getPinLength()))
        {
            return false;
        }

        if (!this.getPinVerificationMethod().equals(other.getPinVerificationMethod()))
        {
            return false;
        }

        if (!this.getPinVerificationKey().equals(other.getPinVerificationKey()))
        {
            return false;
        }

        if (!this.getPinTries().equals(other.getPinTries()))
        {
            return false;
        }

        if (!this.getPukRequired().equals(other.getPukRequired()))
        {
            return false;
        }

        if (!this.getPukLength().equals(other.getPukLength()))
        {
            return false;
        }

        if (!this.getValidityInDays().equals(other.getValidityInDays()))
        {
            return false;
        }

        if (!this.getImportEncryptionZone().equals(other.getImportEncryptionZone()))
        {
            return false;
        }

        if (!this.getSmsEncryptionZone().equals(other.getSmsEncryptionZone()))
        {
            return false;
        }

        if (!this.getDBImportGeneratePuk().equals(other.getImportGeneratePuk()))
        {
            return false;
        }

        if (!this.getSmsInterface().equals(other.getSmsInterface()))
        {
            return false;
        }

        if (!this.getReturnInterface().equals(other.getReturnInterface()))
        {
            return false;
        }

        return true;

    }

    public boolean equalsAllFields(Object obj) {

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final TokenApplicationProfileDataRecord other = (TokenApplicationProfileDataRecord) obj;

        if (!this.getAppSequenceNumber().equals(other.getAppSequenceNumber()))
        {
            System.out.println("Equal all fields getAppSequenceNumber: " + this.getAppSequenceNumber() + "<>" + other.getAppSequenceNumber());
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            System.out.println("Equal all fields getName: " + this.getName() + "<>" + other.getName());
            return false;
        }

        if (!this.getParentTokenProduct().equals(other.getParentTokenProduct()))
        {
            System.out.println("Equal all fields getParentTokenProduct: " + this.getParentTokenProduct() + "<>" + other.getParentTokenProduct());
            return false;
        }

        if (!this.getDBStatus().equals(other.getDBStatus()))
        {
            System.out.println("Equal all fields getDBStatus: " + this.getDBStatus() + "<>" + other.getDBStatus());
            return false;
        }

        if (!this.getDefaultApp().equals(other.getDefaultApp()))
        {
            System.out.println("Equal all fields getDefaultApp: " + this.getDefaultApp() + "<>" + other.getDefaultApp());
            return false;
        }

        if (!this.getPinRequired().equals(other.getPinRequired()))
        {
            System.out.println("Equal all fields getPinRequired: " + this.getPinRequired() + "<>" + other.getPinRequired());
            return false;
        }

        if (!this.getPinLength().equals(other.getPinLength()))
        {
            System.out.println("Equal all fields getPinLength: " + this.getPinLength() + "<>" + other.getPinLength());
            return false;
        }

        if (!this.getPinVerificationMethod().equals(other.getPinVerificationMethod()))
        {
            System.out.println("Equal all fields getPinVerificationMethod: " + this.getPinVerificationMethod() + "<>" + other.getPinVerificationMethod());
            return false;
        }

        if (!this.getPinVerificationKey().equals(other.getPinVerificationKey()))
        {
            System.out.println("Equal all fields getPinVerificationKey: " + this.getPinVerificationKey() + "<>" + other.getPinVerificationKey());
            return false;
        }

        if (!this.getPinTries().equals(other.getPinTries()))
        {
            System.out.println("Equal all fields getPinTries: " + this.getPinTries() + "<>" + other.getPinTries());
            return false;
        }

        if (!this.getPukRequired().equals(other.getPukRequired()))
        {
            System.out.println("Equal all fields getPukRequired: " + this.getPukRequired() + "<>" + other.getPukRequired());
            return false;
        }

        if (!this.getValidityInDays().equals(other.getValidityInDays()))
        {
            System.out.println("Equal all fields getValidityInDays: " + this.getValidityInDays() + "<>" + other.getValidityInDays());
            return false;
        }

        if (!this.getImportEncryptionZone().equals(other.getImportEncryptionZone()))
        {
            System.out.println("Equal all fields getImportEncryptionZone: " + this.getImportEncryptionZone() + "<>" + other.getImportEncryptionZone());
            return false;
        }

        if (!this.getSmsEncryptionZone().equals(other.getSmsEncryptionZone()))
        {
            System.out.println("Equal all fields getSmsEncryptionZone: " + this.getSmsEncryptionZone() + "<>" + other.getSmsEncryptionZone());
            return false;
        }

        if (!this.getDBImportGeneratePuk().equals(other.getDBImportGeneratePuk()))
        {
            System.out.println("Equal all fields getDBImportGeneratePuk: " + this.getDBImportGeneratePuk() + "<>" + other.getDBImportGeneratePuk());
            return false;
        }

        if (!this.getSmsInterface().equals(other.getSmsInterface()))
        {
            System.out.println("Equal all fields getSmsInterface: " + this.getSmsInterface() + "<>" + other.getSmsInterface());
            return false;
        }

        if (!this.getReturnInterface().equals(other.getReturnInterface()))
        {
            System.out.println("Equal all fields getReturnInterface: >" + this.getReturnInterface() + "< <> >" + other.getReturnInterface() + "<");
            return false;
        }

        if (!this.getPinDeliveryMethod().equals(other.getPinDeliveryMethod()))
        {
            System.out.println("Equal all fields getPinDeliveryMethod: " + this.getPinDeliveryMethod() + "<>" + other.getPinDeliveryMethod());
            return false;
        }

        if (!this.getPinMailerDelayHours().equals(other.getPinMailerDelayHours()))
        {
            System.out.println("Equal all fields getPinMailerDelayHours: " + this.getPinMailerDelayHours() + "<>" + other.getPinMailerDelayHours());
            return false;
        }

        if (!this.getPinHeldBySeqNum().equals(other.getPinHeldBySeqNum()))
        {
            System.out.println("Equal all fields getPinHeldBySeqNum: " + this.getPinHeldBySeqNum() + "<>" + other.getPinHeldBySeqNum());
            return false;
        }

        if (!this.getAllowPinChange().equals(other.getAllowPinChange()))
        {
            System.out.println("Equal all fields getAllowPinChange: " + this.getAllowPinChange() + "<>" + other.getAllowPinChange());
            return false;
        }

        if (!this.getAllowOnlinePinChange().equals(other.getAllowOnlinePinChange()))
        {
            System.out.println("Equal all fields getAllowOnlinePinChange: " + this.getAllowOnlinePinChange() + "<>" + other.getAllowOnlinePinChange());
            return false;
        }

        if (!this.getAllowOnlinePinView().equals(other.getAllowOnlinePinView()))
        {
            System.out.println("Equal all fields getAllowOnlinePinView: " + this.getAllowOnlinePinView() + "<>" + other.getAllowOnlinePinView());
            return false;
        }

        if (!this.getPukLength().equals(other.getPukLength()))
        {
            System.out.println("Equal all fields getPukLength: " + this.getPukLength() + "<>" + other.getPukLength());
            return false;
        }

        if (!this.getAllowPukChange().equals(other.getAllowPukChange()))
        {
            System.out.println("Equal all fields getAllowPukChange: " + this.getAllowPukChange() + "<>" + other.getAllowPukChange());
            return false;
        }

        if (!this.getPukHeldBySeqNum().equals(other.getPukHeldBySeqNum()))
        {
            System.out.println("Equal all fields getPukHeldBySeqNum: " + this.getPukHeldBySeqNum() + "<>" + other.getPukHeldBySeqNum());
            return false;
        }

        if (!this.getVerificationBackoff().equals(other.getVerificationBackoff()))
        {
            System.out.println("Equal all fields getVerificationBackoff: " + this.getVerificationBackoff() + "<>" + other.getVerificationBackoff());
            return false;
        }

        if (!this.getBackoffMultiplier().equals(other.getBackoffMultiplier()))
        {
            System.out.println("Equal all fields getBackoffMultiplier: " + this.getBackoffMultiplier() + "<>" + other.getBackoffMultiplier());
            return false;
        }

        if (!this.getTokenImportPinDeliveryMethod().equals(other.getTokenImportPinDeliveryMethod()))
        {
            System.out.println("Equal all fields getTokenImportPinDeliveryMethod: " + this.getTokenImportPinDeliveryMethod() + "<>" + other.getTokenImportPinDeliveryMethod());
            return false;
        }

        if (!this.getTokenImportOutputInterface().equals(other.getTokenImportOutputInterface()))
        {
            System.out.println("Equal all fields getTokenImportOutputInterface: " + this.getTokenImportOutputInterface() + "<>" + other.getTokenImportOutputInterface());
            return false;
        }

        if (!this.getTokenOrderPinDeliveryMethod().equals(other.getTokenOrderPinDeliveryMethod()))
        {
            System.out.println("Equal all fields getTokenOrderPinDeliveryMethod: " + this.getTokenOrderPinDeliveryMethod() + "<>" + other.getTokenOrderPinDeliveryMethod());
            return false;
        }

        if (!this.getForceTokenOrderPinDelivery().equals(other.getForceTokenOrderPinDelivery()))
        {
            System.out.println("Equal all fields getForceTokenOrderPinDelivery: " + this.getForceTokenOrderPinDelivery() + "<>" + other.getForceTokenOrderPinDelivery());
            return false;
        }

        if (!this.getTokenOutputInterface().equals(other.getTokenOutputInterface()))
        {
            System.out.println("Equal all fields getTokenOutputInterface: " + this.getTokenOutputInterface() + "<>" + other.getTokenOutputInterface());
            return false;
        }

        if (!this.getPinAdvicePinDeliveryMethod().equals(other.getPinAdvicePinDeliveryMethod()))
        {
            System.out.println("Equal all fields getPinAdvicePinDeliveryMethod: " + this.getPinAdvicePinDeliveryMethod() + "<>" + other.getPinAdvicePinDeliveryMethod());
            return false;
        }

        if (!this.getForcePinAdvicePinDelivery().equals(other.getForcePinAdvicePinDelivery()))
        {
            System.out.println("Equal all fields getForcePinAdvicePinDelivery: " + this.getForcePinAdvicePinDelivery() + "<>" + other.getForcePinAdvicePinDelivery());
            return false;
        }

        if (!this.getPinAdviceOutputInterface().equals(other.getPinAdviceOutputInterface()))
        {
            System.out.println("Equal all fields getPinAdviceOutputInterface: " + this.getPinAdviceOutputInterface() + "<>" + other.getPinAdviceOutputInterface());
            return false;
        }

        if (!this.getUpdatePinDeliveryMethod().equals(other.getUpdatePinDeliveryMethod()))
        {
            System.out.println("Equal all fields getUpdatePinDeliveryMethod: " + this.getUpdatePinDeliveryMethod() + "<>" + other.getUpdatePinDeliveryMethod());
            return false;
        }

        if (!this.getUpdateInterface().equals(other.getUpdateInterface()))
        {
            System.out.println("Equal all fields getUpdateInterface: " + this.getUpdateInterface() + "<>" + other.getUpdateInterface());
            return false;
        }

        if (!this.getVppPinDeliveryMethod().equals(other.getVppPinDeliveryMethod()))
        {
            System.out.println("Equal all fields getVppPinDeliveryMethod: " + this.getVppPinDeliveryMethod() + "<>" + other.getVppPinDeliveryMethod());
            return false;
        }

        if (!this.getVppInterface().equals(other.getVppInterface()))
        {
            System.out.println("Equal all fields getVppInterface: " + this.getVppInterface() + "<>" + other.getVppInterface());
            return false;
        }

        if (!this.getPinTemplate().equals(other.getPinTemplate()))
        {
            System.out.println("Equal all fields getPinTemplate: " + this.getPinTemplate() + "<>" + other.getPinTemplate());
            return false;
        }

        if (!this.getSecondaryPinTemplate().equals(other.getSecondaryPinTemplate()))
        {
            System.out.println("Equal all fields getSecondaryPinTemplate: " + this.getSecondaryPinTemplate() + "<>" + other.getSecondaryPinTemplate());
            return false;
        }

        if (!this.getPukTemplate().equals(other.getPukTemplate()))
        {
            System.out.println("Equal all fields getPukTemplate: " + this.getPukTemplate() + "<>" + other.getPukTemplate());
            return false;
        }

        if (!this.getPasswordTemplate().equals(other.getPasswordTemplate()))
        {
            System.out.println("Equal all fields getPasswordTemplate: " + this.getPasswordTemplate() + "<>" + other.getPasswordTemplate());
            return false;
        }

        if (!this.getMessageTemplate().equals(other.getMessageTemplate()))
        {
            System.out.println("Equal all fields getMessageTemplate: " + this.getMessageTemplate() + "<>" + other.getMessageTemplate());
            return false;
        }

        if (!this.getPinOverSMSDelayHours().equals(other.getPinOverSMSDelayHours()))
        {
            System.out.println("Equal all fields getPinOverSMSDelayHours: " + this.getPinOverSMSDelayHours() + "<>" + other.getPinOverSMSDelayHours());
            return false;
        }

        if (!this.getSmsPasswordDelayHours().equals(other.getSmsPasswordDelayHours()))
        {
            System.out.println("Equal all fields getSmsPasswordDelayHours: " + this.getSmsPasswordDelayHours() + "<>" + other.getSmsPasswordDelayHours());
            return false;
        }

        if (!this.getSmsSender().equals(other.getSmsSender()))
        {
            System.out.println("Equal all fields getSmsSender: " + this.getSmsSender() + "<>" + other.getSmsSender());
            return false;
        }

        if (!this.getSmsValidityHours().equals(other.getSmsValidityHours()))
        {
            System.out.println("Equal all fields getSmsValidityHours: " + this.getSmsValidityHours() + "<>" + other.getSmsValidityHours());
            return false;
        }

        if (!this.getSmsPasswordHours().equals(other.getSmsPasswordHours()))
        {
            System.out.println("Equal all fields getSmsPasswordHours: " + this.getSmsPasswordHours() + "<>" + other.getSmsPasswordHours());
            return false;
        }

        if (!this.getDbSmsClass().equals(other.getDbSmsClass()))
        {
            System.out.println("Equal all fields getDbSmsClass: " + this.getDbSmsClass() + "<>" + other.getDbSmsClass());
            return false;
        }

        return true;

    }

    public String toStringAllFields()
    {
        return "Record: [NAME=" + getName() + ", TOKENPRODUCT=" + getParentTokenProduct() +
                ", APPSEQNUM=" + getAppSequenceNumber() + ", STATUS=" + getDBStatus() +
                ", DEFAULTAPP=" + getDefaultApp() + ", PINREQUIRED=" + getPinRequired() +
                ", PINLENGTH=" + getPinLength() + ", VALIDITYINDAYS=" + getValidityInDays() +
                ", IMPORTENCRYPTIONZONE=" + getImportEncryptionZone() + ", SMSINTERFACE = " + getSmsInterface() +
                ", SMSENCRYPTIONZONE=" + getSmsEncryptionZone() + ", RETURNINTERFACE=" + getReturnInterface() +
                ", PINDELIVERYMETHOD=" + getPinDeliveryMethod() + ", PINMAILERDELAYHOURS=" + getPinMailerDelayHours() +
                ", PINHELDBYSEQNUMBER=" + getPinHeldBySeqNum() + ", ALLOWPINCHANGE=" + getAllowPinChange() +
                ", ALLOWONLINEPINCHANGE=" + getAllowOnlinePinChange() +
                ", ALLOWONLINEPINVIEW=" + getAllowOnlinePinView() +
                ", PUKREQUIRED=" + getPukRequired() + ", PUKLENGTH=" + getPukLength() +
                ", ALLOWPUKCHANGE=" + getAllowPukChange() + ", PUKHELDBYSEQNUM=" + getPukHeldBySeqNum() +
                ", IMPORTGENERATEPUK=" + getDBImportGeneratePuk() +
                ", PINVERIFICATIONMETHOD=" + getPinVerificationMethod() +
                ", PINVERIFICATIONKEY=" + getPinVerificationKey() + ", PINTRIES=" + getPinTries() +
                ", VERIFICATIONBACKOFF=" + getVerificationBackoff() + ", BACKOFFMULTIPLIER=" + getBackoffMultiplier() +
                ", TOKENIMPORTPINDELIVERYMETHOD=" + getTokenImportPinDeliveryMethod() +
                ", TOKENIMPORTOUTPUTINTERFACE=" + getTokenImportOutputInterface() +
                ", TOKENORDERPINDELIVERYMETHOD=" + getTokenOrderPinDeliveryMethod() +
                ", FORCETOKENORDERPINDELIVERY=" + getForceTokenOrderPinDelivery() +
                ", TOKENOUTPUTINTERFACE=" + getTokenOutputInterface() +
                ", PINADVICEPINDELIVERYMETHOD=" + getPinAdvicePinDeliveryMethod() +
                ", FORCEPINADVICEPINDELIVERY=" + getForcePinAdvicePinDelivery() +
                ", PINADVICEOUTPUTINTERFACE=" + getPinAdviceOutputInterface() +
                ", UPDATEPINDELIVERYMETHOD=" + getUpdatePinDeliveryMethod() +
                ", UPDATEINTERFACE=" + getUpdateInterface() +
                ", VPPPINDELIVERYMETHOD=" + getVppPinDeliveryMethod() + ", VPPINTERFACE=" + getVppInterface() +
                ", PINTEMPLATE=" + getPinTemplate() + ", SECONDARYPINTEMPLATE=" + getSecondaryPinTemplate() +
                ", PUKTEMPLATE=" + getPukTemplate() + ", PASSWORDTEMPLATE=" + getPasswordTemplate() +
                ", MESSAGETEMPLATE=" + getMessageTemplate() + ", PINOVERSMSDELAYHOURS=" + getPinOverSMSDelayHours() +
                ", SMSPASSWORDDELAYHOURS=" + getSmsPasswordDelayHours() + ", SMSSENDER=" + getSmsSender() +
                ", SMSVALIDITYHOURS=" + getSmsValidityHours() + ", SMSPASSWORDHOURS=" + getSmsPasswordHours() +
                ", SMSCLASS=" + getDbSmsClass() + "]";

    }

}
