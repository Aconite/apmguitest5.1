package com.aconite.apm.gui.automation.records;

public class TokenProductAddEditDataRecord
{
    private String id;
    private String name;
    private String issuerTokenProductCode;
    private String issuer;
    private String tokenProductGroup;
    private String retentionDays;
    private String country;
    private String language;
    private String persoBureau;
    private String pinOverSmsDelayHours;
    private String pinMailerDelayHours;
    private String smsPasswordDelayHours;
    private String feedbackRequired;
    private String active;
    private String pinTemplate;
    private String secondaryPinTemplate;
    private String pukTemplate;
    private String passwordTemplate;
    private String smsSender;
    private String smsValidityHours;
    private String smsPasswordHours;
    private String smsClassDB;
    private String smsClassGUI;
    private String tiPinDeliveryMethodDB;
    private String tiPinDeliveryMethodGUI;
    private String towpdPinDeliveryMethodDB;
    private String towpdPinDeliveryMethodGUI;
    private String forcePinDelivery;
    private String paPinDeliveryMethodDB;
    private String paPinDeliveryMethodGUI;
    private String forcePinAdvice;


    private String nullEmptyFix(String param){
        if (param==null || param.equals("") || param.equals("\u00A0") || param.equals("null")){
            param = " ";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if (param.equals("Y") || param.equals("A")){
            param = "true";
        }
        if (param.equals("I") || param.equals("N")){
            param = "false";
        }
        return param;
    }

    public String getId() { return id; }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getIssuerTokenProductCode()
    {
        return issuerTokenProductCode;
    }

    public void setIssuerTokenProductCode(String issuerTokenProductCode) { this.issuerTokenProductCode = issuerTokenProductCode; }

    public String getIssuer()
    {
        return issuer;
    }

    public void setIssuer(String issuer) { this.issuer = issuer; }

    public String getTokenProductGroup()
    {
        return tokenProductGroup;
    }

    public void setTokenProductGroup(String tokenProductGroup) { this.tokenProductGroup = tokenProductGroup; }

    public String getRetentionDays()
    {
        return retentionDays;
    }

    public void setRetentionDays(String retentionDays) { this.retentionDays = retentionDays; }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country) { this.country = country; }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language) { this.language = language; }

    public String getPersoBureau()
    {
        return persoBureau;
    }

    public void setPersoBureau(String persoBureau) { this.persoBureau = persoBureau; }

    public String getPinOverSmsDelayHours() { return pinOverSmsDelayHours; }

    public void setPinOverSmsDelayHours(String pinOverSmsDelayHours) { this.pinOverSmsDelayHours = pinOverSmsDelayHours; }

    public String getPinMailerDelayHours() { return pinMailerDelayHours; }

    public void setPinMailerDelayHours(String pinMailerDelayHours) { this.pinMailerDelayHours = pinMailerDelayHours; }

    public String getSmsPasswordDelayHours() { return smsPasswordDelayHours; }

    public void setSmsPasswordDelayHours(String smsPasswordDelayHours) { this.smsPasswordDelayHours = smsPasswordDelayHours; }

    public String getFeedbackRequired()
    {
        return feedbackRequired;
    }

    public void setFeedbackRequired(String feedbackRequired) { this.feedbackRequired = setToTrueFalse(feedbackRequired); }

    public String getActive()
        {
            return active;
        }

    public void setActive(String active) { this.active = setToTrueFalse(active); }

    public String getPinTemplate()
        {
            return pinTemplate;
        }

    public void setPinTemplate(String pinTemplate) { this.pinTemplate = pinTemplate; }

    public String getSecondaryPinTemplate()
        {
            return secondaryPinTemplate;
        }

    public void setSecondaryPinTemplate(String secondaryPinTemplate) { this.secondaryPinTemplate = nullEmptyFix(secondaryPinTemplate); }

    public String getPukTemplate()
        {
            return pukTemplate;
        }

    public void setPukTemplate(String pukTemplate) { this.pukTemplate = pukTemplate; }

    public String getPasswordTemplate()
        {
            return passwordTemplate;
        }

    public void setPasswordTemplate(String passwordTemplate) { this.passwordTemplate = passwordTemplate; }

    public String getSmsSender()
    {
        return smsSender;
    }

    public void setSmsSender(String smsSender) { this.smsSender = smsSender; }


    public String getSmsValidityHours()
    {
        return smsValidityHours;
    }

    public void setSmsValidityHours(String smsValidityHours) { this.smsValidityHours = smsValidityHours; }

    public String getSmsPasswordHours()
        {
            return smsPasswordHours;
        }

    public void setSmsPasswordHours(String smsPasswordHours) { this.smsPasswordHours = smsPasswordHours; }

    public String getSmsClassDB() { return smsClassDB; }

    public void setSmsClassDB(String smsClass) {
        this.smsClassDB = smsClass;
        if(this.smsClassDB.equals("1")){
            this.smsClassGUI = "Class 1 (normal)";
        }
        if(this.smsClassDB.equals("0")){
            this.smsClassGUI = "Class 0 (flash)";
        }
    }

    public String getSmsClassGUI(){ return smsClassGUI; }

    public void setSmsClassGUI(String smsClass) {
        this.smsClassGUI = smsClass;
        if(this.smsClassGUI.equals("Class 1 (normal)")){
            this.smsClassDB = "1";
        }
        if(this.smsClassGUI.equals("Class 0 (flash)")){
            this.smsClassDB = "0";
        }

    }

    public String getTiPinDeliveryMethodDB() { return tiPinDeliveryMethodDB; }

    public void setTiPinDeliveryMethodDB(String tiPinDeliveryMethod) {

        this.tiPinDeliveryMethodDB = tiPinDeliveryMethod;
        if(this.tiPinDeliveryMethodDB.equals("1")){
            this.tiPinDeliveryMethodGUI = "No PIN-delivery required";
        }
        if(this.tiPinDeliveryMethodDB.equals("6")){
            this.tiPinDeliveryMethodGUI = "Message";
        }
    }

    public String getTiPinDeliveryMethodGUI() { return tiPinDeliveryMethodGUI; }

    public void setTiPinDeliveryMethodGUI(String tiPinDeliveryMethod) {
        this.tiPinDeliveryMethodGUI = tiPinDeliveryMethod;
        if(this.tiPinDeliveryMethodGUI.equals("No PIN-delivery required")){
            this.tiPinDeliveryMethodDB = "1";
        }
        if(this.tiPinDeliveryMethodGUI.equals("Message")){
            this.tiPinDeliveryMethodDB = "6";
        }
    }

    public String getTowpdPinDeliveryMethodDB() { return towpdPinDeliveryMethodDB; }

    public void setTowpdPinDeliveryMethodDB(String towpdPinDeliveryMethod) {
        this.towpdPinDeliveryMethodDB = towpdPinDeliveryMethod;
        if(this.towpdPinDeliveryMethodDB.equals("1")){
            this.towpdPinDeliveryMethodGUI = "No PIN-delivery required";
        }
        if(this.towpdPinDeliveryMethodDB.equals("6")){
            this.towpdPinDeliveryMethodGUI = "Message";
        }
    }

    public String getTowpdPinDeliveryMethodGUI() { return towpdPinDeliveryMethodGUI; }

    public void setTowpdPinDeliveryMethodGUI(String towpdPinDeliveryMethod) {
        this.towpdPinDeliveryMethodGUI = towpdPinDeliveryMethod;
        if(this.towpdPinDeliveryMethodGUI.equals("No PIN-delivery required")){
            this.towpdPinDeliveryMethodDB = "1";
        }
        if(this.towpdPinDeliveryMethodGUI.equals("Message")){
            this.towpdPinDeliveryMethodDB = "6";
        }

    }

    public String getForcePinDelivery() { return forcePinDelivery; }

    public void setForcePinDelivery(String forcePinDelivery) { this.forcePinDelivery = setToTrueFalse(forcePinDelivery); }

    public String getPaPinDeliveryMethodDB() { return paPinDeliveryMethodDB; }

    public void setPaPinDeliveryMethodDB(String paPinDeliveryMethod) {
        this.paPinDeliveryMethodDB = paPinDeliveryMethod;
        if(this.paPinDeliveryMethodDB.equals("1")){
            this.paPinDeliveryMethodGUI = "No PIN-delivery required";
        }
        if(this.paPinDeliveryMethodDB.equals("6")){
            this.paPinDeliveryMethodGUI = "Message";
        }
    }


    public String getPaPinDeliveryMethodGUI() { return paPinDeliveryMethodGUI; }

    public void setPaPinDeliveryMethodGUI(String paPinDeliveryMethod) {
        this.paPinDeliveryMethodGUI = paPinDeliveryMethod;
        if(this.paPinDeliveryMethodGUI.equals("No PIN-delivery required")){
            this.paPinDeliveryMethodDB = "1";
        }
        if(this.paPinDeliveryMethodGUI.equals("Message")){
            this.paPinDeliveryMethodDB = "6";
        }
    }

    public String getForcePinAdvice() { return forcePinAdvice; }

    public void setForcePinAdvice(String forcePinAdvice) { this.forcePinAdvice = setToTrueFalse(forcePinAdvice); }


    @Override
    public String toString()
    {
        return  "Record: [ID=" + getId() +
                ", NAME=" + getName() +
                ", ISSUERTOKENPRODUCTCODE=" + getIssuerTokenProductCode() +
                ", ISSUER=" + getIssuer() +
                ", TOKENPRODUCTGROUP=" + getTokenProductGroup() +
                ", RETENTIONDAYS=" + getRetentionDays() +
                ", COUNTRY=" + getCountry() +
                ", LANGUAGE=" + getLanguage() +
                ", PERSOBUREAU=" + getPersoBureau() +
                ", PINOVERSMSDELAYHOURS=" + getPinOverSmsDelayHours() +
                ", PINMAILERDELAYHOURS=" + getPinMailerDelayHours() +
                ", SMSPASSWORDDELAYHOURS = " + getSmsPasswordDelayHours() +
                ", FEEDBACKREQUIRED=" + getFeedbackRequired() +
                ", ACTIVE=" + getActive() +
                ", PINTEMPLATE=" + getPinTemplate() +
                ", SECONDARYPINTEMPLATE=" + getSecondaryPinTemplate() +
                ", PUKTEMPLATE=" + getPukTemplate() +
                ", PASSWORDTEMPLATE=" + getPasswordTemplate() +
                ", SMSSENDER=" + getSmsSender() +
                ", SMSVALIDITYHOURS=" + getSmsValidityHours() +
                ", SMSPASSWORDHOURS=" + getSmsPasswordHours() +
                ", SMSCLASSDB=" + getSmsClassDB() +
                ", SMSCLASSGUI=" + getSmsClassGUI() +
                ", TIPINDELIVERYMETHODDB=" + getTiPinDeliveryMethodDB() +
                ", TIPINDELIVERYMETHODGUI=" + getTiPinDeliveryMethodGUI() +
                ", TOWPDDELIVERYMETHODDB=" + getTowpdPinDeliveryMethodDB() +
                ", TOWPDDELIVERYMETHODGUI=" + getTowpdPinDeliveryMethodGUI() +
                ", FORCEPINDELIVERY=" + getForcePinDelivery() +
                ", PAPINDELIVERYMETHODDB=" + getPaPinDeliveryMethodDB() +
                ", PAPINDELIVERYMETHODGUI=" + getPaPinDeliveryMethodGUI() +
                ", FORCEPINADVICE=" + getForcePinAdvice() +
                "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        if (obj.getClass() != this.getClass())
        {
            return false;
        }

        final TokenProductAddEditDataRecord other = (TokenProductAddEditDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getIssuerTokenProductCode().equals(other.getIssuerTokenProductCode()))
        {
            return false;
        }

        if (!this.getIssuer().equals(other.getIssuer()))
        {
            return false;
        }

        if (!this.getTokenProductGroup().equals(other.getTokenProductGroup()))
        {
            return false;
        }

        if (!this.getRetentionDays().equals(other.getRetentionDays()))
        {
            return false;
        }

        if (!this.getCountry().equals(other.getCountry()))
        {
            return false;
        }

        if (!this.getLanguage().equals(other.getLanguage()))
        {
            return false;
        }

        if (!this.getPersoBureau().equals(other.getPersoBureau()))
        {
            return false;
        }

        if (!this.getPinOverSmsDelayHours().equals(other.getPinOverSmsDelayHours()))
        {
            return false;
        }

        if (!this.getPinMailerDelayHours().equals(other.getPinMailerDelayHours()))
        {
            return false;
        }

        if (!this.getSmsPasswordDelayHours().equals(other.getSmsPasswordDelayHours()))
        {
            return false;
        }

        if (!this.getFeedbackRequired().equals(other.getFeedbackRequired()))
        {
            return false;
        }

        if (!this.getActive().equals(other.getActive()))
        {
            return false;
        }

        if (!this.getPinTemplate().equals(other.getPinTemplate()))
        {
            return false;
        }

        if (!this.getSecondaryPinTemplate().equals(other.getSecondaryPinTemplate()))
        {
            return false;
        }

        if (!this.getPukTemplate().equals(other.getPukTemplate()))
        {
            return false;
        }

        if (!this.getPasswordTemplate().equals(other.getPasswordTemplate()))
        {
            return false;
        }

        if (!this.getSmsSender().equals(other.getSmsSender()))
        {
            return false;
        }

        if (!this.getSmsValidityHours().equals(other.getSmsValidityHours()))
        {
            return false;
        }

        if (!this.getSmsPasswordHours().equals(other.getSmsPasswordHours()))
        {
            return false;
        }

        if (!this.getSmsClassDB().equals(other.getSmsClassDB()))
        {
            return false;
        }

        if (!this.getSmsClassGUI().equals(other.getSmsClassGUI()))
        {
            return false;
        }

        if (!this.getTiPinDeliveryMethodDB().equals(other.getTiPinDeliveryMethodDB()))
        {
            return false;
        }

        if (!this.getTiPinDeliveryMethodGUI().equals(other.getTiPinDeliveryMethodGUI()))
        {
            return false;
        }

        if (!this.getTowpdPinDeliveryMethodDB().equals(other.getTowpdPinDeliveryMethodDB()))
        {
            return false;
        }

        if (!this.getTowpdPinDeliveryMethodGUI().equals(other.getTowpdPinDeliveryMethodGUI()))
        {
            return false;
        }

        if (!this.getForcePinDelivery().equals(other.getForcePinDelivery()))
        {
            return false;
        }

        if (!this.getPaPinDeliveryMethodDB().equals(other.getPaPinDeliveryMethodDB()))
        {
            return false;
        }

        if (!this.getPaPinDeliveryMethodGUI().equals(other.getPaPinDeliveryMethodGUI()))
        {
            return false;
        }

        if (!this.getForcePinAdvice().equals(other.getForcePinAdvice()))
        {
            return false;
        }

        return true;
    }
}