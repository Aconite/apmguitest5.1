package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class TokenProductTableDataRecord
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
    private String feedbackRequired;
    private String active;
    private String pinTemplate;
    private String secondaryPinTemplate;
    private String pukTemplate;
    private String passwordTemplate;
    private String smsPasswordHours;
    private String smsSender;
    private String smsValidityHours;
    private String smsClassDB;
    private String smsClassGUI;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("") || param.equals("\u00A0")){
            param = " ";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if (param.equals("Y") || param.equals("A")){
            param = "true";
        }
        if (param.equals("N")){ // TODO: Check value from database for an inactive token product
            param = "true";
        }
        return param;
    }

    public String getId()
    {
        return id;
    }

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

    public String getSmsPasswordHours()
        {
            return smsPasswordHours;
        }

    public void setSmsPasswordHours(String smsPasswordHours) { this.smsPasswordHours = smsPasswordHours; }

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

    public String getSmsClassDB()
    {
        return smsClassDB;
    }

    public void setSmsClassDB(String smsClass) {
        this.smsClassDB = smsClass;
        if(this.smsClassGUI==null && this.smsClassDB.equals("1")){
            this.smsClassGUI = "Class 1 (normal)";
        }
        if(this.smsClassGUI==null && this.smsClassDB.equals("0")){
            this.smsClassGUI = "Class 0 (flash)";
        }
    }

    public String getSmsClassGUI(){ return smsClassGUI; }

    public void setSmsClassGUI(String smsClass) {
        this.smsClassGUI = smsClass;
        if(this.smsClassDB==null && this.smsClassGUI.equals("Class 1 (normal)")){
            this.smsClassDB = "1";
        }
        if(this.smsClassDB==null && this.smsClassGUI.equals("Class 0 (flash)")){
            this.smsClassDB = "0";
        }

    }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", NAME=" + getName() + ", ISSUERTOKENPRODUCTCODE=" + getIssuerTokenProductCode() +
                ", ISSUER=" + getIssuer() + ", TOKENPRODUCTGROUP=" + getTokenProductGroup() + ", RETENTIONDAYS=" +
                getRetentionDays() + ", COUNTRY=" + getCountry() + ", LANGUAGE=" + getLanguage() + ", PERSOBUREAU=" +
                getPersoBureau() + ", FEEDBACKREQUIRED=" + getFeedbackRequired() + ", ACTIVE=" + getActive() +
                ", PINTEMPLATE=" + getPinTemplate() + ", SECONDARYPINTEMPLATE=" + getSecondaryPinTemplate() +
                ", PUKTEMPLATE=" + getPukTemplate() + ", PASSWORDTEMPLATE=" + getPasswordTemplate() +
                ", SMSPASSWORDHOURS=" + getSmsPasswordHours() + ", SMSSENDER=" + getSmsSender() +
                ", SMSVALIDITYHOURS=" + getSmsValidityHours() + ", SMSCLASSDB=" + getSmsClassDB() +
                ", SMSCLASSGUI=" + getSmsClassGUI() + "]";
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

        final TokenProductTableDataRecord other = (TokenProductTableDataRecord) obj;

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

        if (!this.getSmsPasswordHours().equals(other.getSmsPasswordHours()))
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

        if (!this.getSmsClassDB().equals(other.getSmsClassDB()))
        {
            return false;
        }

        if (!this.getSmsClassGUI().equals(other.getSmsClassGUI()))
        {
            return false;
        }

        return true;
    }
}