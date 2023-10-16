package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class HousekeeperTransactionHistoryCleanUpRecord
{
    private String id;
    private String trxTypeId;
    private String trxStatus;
    private String systemDateTime;
    private String reqDateTime;
    private String reqOrigId;
    private String reqIssuerPinId;
    private String reqPinExpiryDate;
    private String reqPinId;
    private String reqPanId;
    private String reqIssuerPanAlias;
    private String reqPanSeqNumber;
    private String reqPanExpiryDate;
    private String reqPinDeliveryMethod;
    private String reqMobilePhone;
    private String reqTHTitle;
    private String reqTHFirstName;
    private String reqTHMiddleName;
    private String reqTHLastName;
    private String reqTHAddress1;
    private String reqTHAddress2;
    private String reqTHAddress3;
    private String reqTHAddress4;
    private String reqTHAddress5;
    private String reqTHAddress6;
    private String reqTHTown;
    private String reqTHPostCode;
    private String reqTHCountryCode;
    private String reqCompanyName;
    private String reqCompanyContact;



    private String nullEmptyFix(String param){
        if (param==null || param==""){
            param = " ";
        }
        return param;
    }

    private String millisecondsToOneDP(String param){
        if (param.substring(param.length()-3).equals(":00")){
            param = param + ".0";

        }
        return param;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTrxTypeId() { return trxTypeId; }

    public void setTrxTypeId(String trxTypeId) { this.trxTypeId = nullEmptyFix(trxTypeId); }

    public String getTrxStatus() { return trxStatus; }

    public void setTrxStatus(String trxStatus) { this.trxStatus = nullEmptyFix(trxStatus); }

    public String getSystemDateTime() { return systemDateTime; }

    public void setSystemDateTime(String systemDateTime) { this.systemDateTime = millisecondsToOneDP(nullEmptyFix(systemDateTime)); }

    public String getReqDateTime() { return reqDateTime; }

    public void setReqDateTime(String reqDateTime){ this.reqDateTime = millisecondsToOneDP(nullEmptyFix(reqDateTime)); }

    public String getReqOrigId()
    {
        return reqOrigId;
    }

    public void setReqOrigId(String reqOrigId)
    {
        this.reqOrigId = nullEmptyFix(reqOrigId);
    }

    public String getReqIssuerPinId()
    {
        return reqIssuerPinId;
    }

    public void setReqIssuerPinId(String reqIssuerPinId)
    {
        this.reqIssuerPinId = nullEmptyFix(reqIssuerPinId);
    }

     public String getReqPinExpiryDate()
    {
        return reqPinExpiryDate;
    }

    public void setReqPinExpiryDate(String reqPinExpiryDate)
    {
        this.reqPinExpiryDate = nullEmptyFix(reqPinExpiryDate);
    }

    public String getReqPinId()
    {
        return reqPinId;
    }

    public void setReqPinId(String reqPinId)
    {
        this.reqPinId = nullEmptyFix(reqPinId);
    }

    public String getReqPanId() { return reqPanId; }

    public void setReqPanId(String reqPanId){ this.reqPanId = nullEmptyFix(reqPanId); }

    public String getReqIssuerPanAlias() { return reqIssuerPanAlias; }

    public void setReqIssuerPanAlias(String reqIssuerPanAlias){ this.reqIssuerPanAlias = nullEmptyFix(reqIssuerPanAlias); }

    public String getReqPanSeqNumber() { return reqPanSeqNumber; }

    public void setReqPanSeqNumber(String reqPanSeqNumber){ this.reqPanSeqNumber = nullEmptyFix(reqPanSeqNumber); }

    public String getReqPanExpiryDate() { return reqPanExpiryDate; }

    public void setReqPanExpiryDate(String reqPanExpiryDate){ this.reqPanExpiryDate = nullEmptyFix(reqPanExpiryDate); }

    public String getReqPinDeliveryMethod() { return reqPinDeliveryMethod; }

    public void setReqPinDeliveryMethod(String reqPinDeliveryMethod){ this.reqPinDeliveryMethod = nullEmptyFix(reqPinDeliveryMethod); }

    public String getReqMobilePhone() { return reqMobilePhone; }

    public void setReqMobilePhone(String reqMobilePhone){ this.reqMobilePhone = nullEmptyFix(reqMobilePhone); }

    public String getReqTHTitle() { return reqTHTitle; }

    public void setReqTHTitle(String reqTHTitle){ this.reqTHTitle = nullEmptyFix(reqTHTitle); }

    public String getReqTHFirstName() { return reqTHFirstName; }

    public void setReqTHFirstName(String reqTHFirstName){ this.reqTHFirstName = nullEmptyFix(reqTHFirstName); }

    public String getReqTHMiddleName() { return reqTHMiddleName; }

    public void setReqTHMiddleName(String reqTHMiddleName){ this.reqTHMiddleName = nullEmptyFix(reqTHMiddleName); }

    public String getReqTHLastName() { return reqTHLastName; }

    public void setReqTHLastName(String reqTHLastName){ this.reqTHLastName = nullEmptyFix(reqTHLastName); }

    public String getReqTHAddress1() { return reqTHAddress1; }

    public void setReqTHAddress1(String reqTHAddress1){ this.reqTHAddress1 = nullEmptyFix(reqTHAddress1); }

    public String getReqTHAddress2() { return reqTHAddress2; }

    public void setReqTHAddress2(String reqTHAddress2){ this.reqTHAddress2 = nullEmptyFix(reqTHAddress2); }

    public String getReqTHAddress3() { return reqTHAddress3; }

    public void setReqTHAddress3(String reqTHAddress3){ this.reqTHAddress3 = nullEmptyFix(reqTHAddress3); }

    public String getReqTHAddress4() { return reqTHAddress4; }

    public void setReqTHAddress4(String reqTHAddress4){ this.reqTHAddress4 = nullEmptyFix(reqTHAddress4); }

    public String getReqTHAddress5() { return reqTHAddress5; }

    public void setReqTHAddress5(String reqTHAddress5){ this.reqTHAddress5 = nullEmptyFix(reqTHAddress5); }

    public String getReqTHAddress6() { return reqTHAddress6; }

    public void setReqTHAddress6(String reqTHAddress6){ this.reqTHAddress6 = nullEmptyFix(reqTHAddress6); }

    public String getReqTHTown() { return reqTHTown; }

    public void setReqTHTown(String reqTHTown){ this.reqTHTown = nullEmptyFix(reqTHTown); }

    public String getReqTHPostCode() { return reqTHPostCode; }

    public void setReqTHPostCode(String reqTHPostCode){ this.reqTHPostCode = nullEmptyFix(reqTHPostCode); }

    public String getReqTHCountryCode() { return reqTHCountryCode; }

    public void setReqTHCountryCode(String reqTHCountryCode){ this.reqTHCountryCode = nullEmptyFix(reqTHCountryCode); }

    public String getReqCompanyName() { return reqCompanyName; }

    public void setReqCompanyName(String reqCompanyName){ this.reqCompanyName = nullEmptyFix(reqCompanyName); }

    public String getReqCompanyContact() { return reqCompanyContact; }

    public void setReqCompanyContact(String reqCompanyContact){ this.reqCompanyContact = nullEmptyFix(reqCompanyContact); }





    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TRXTYPEID=" + getTrxTypeId() + ", TRXSTATUS=" + getTrxStatus() +
                        ", SYSTEMDATETIME=" + getSystemDateTime() + ", REQDATETIME=" + getReqDateTime() +
                        ", REQORIGID=" + getReqOrigId() + ", REQISSUERPINID=" + getReqIssuerPinId() +
                        ", REQPINEXPIRYDATE=" + getReqPinExpiryDate() + ", REQPINID=" + getReqPinId() +
                        ", REQPANID=" + getReqPanId() + ", REQISSUERPANALIAS=" + getReqIssuerPanAlias() +
                        ", REQPANSEQNUMBER=" + getReqPanSeqNumber() + ", REQPANEXPIRYDATE=" + getReqPanExpiryDate() +
                        ", REQPINDELIVERYMETHOD=" + getReqPinDeliveryMethod() + ", REQMOBILEPHONE=" + getReqMobilePhone() +
                        ", REQTHTITLE=" + getReqTHTitle() + ", REQTHFIRSTNAME=" + getReqTHFirstName() +
                        ", REQTHMIDDLENAME=" + getReqTHMiddleName() + ", REQTHLASTNAME=" + getReqTHLastName() +
                        ", REQTHADDRESS1=" + getReqTHAddress1() + ", REQTHADDRESS2=" + getReqTHAddress2() +
                        ", REQTHADDRESS3=" + getReqTHAddress3() + ", REQTHADDRESS4=" + getReqTHAddress4() +
                        ", REQTHADDRESS5=" + getReqTHAddress5() + ", REQTHADDRESS6=" + getReqTHAddress6() +
                        ", REQTHTOWN=" + getReqTHTown() + ", REQTHPOSTCODE=" + getReqTHPostCode() +
                        ", REQTHCOUNTRYCODE=" + getReqTHCountryCode() + ", REQCOMPANYNAME=" + getReqCompanyName() +
                        ", REQCOMPANYCONTACT=" + getReqCompanyContact() + "]";
    }

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

        final HousekeeperTransactionHistoryCleanUpRecord other = (HousekeeperTransactionHistoryCleanUpRecord) obj;

        if (!this.getId().equals(other.getId())) { return false; }

        if (!this.getTrxTypeId().equals(other.getTrxTypeId())) { return false; }

        if (!this.getTrxStatus().equals(other.getTrxStatus())) { return false; }

        if (!this.getSystemDateTime().equals(other.getSystemDateTime())) { return false; }

        if (!this.getReqDateTime().equals(other.getReqDateTime())) { return false; }

        if (!this.getReqOrigId().equals(other.getReqOrigId())) { return false; }

        if (!this.getReqIssuerPinId().equals(other.getReqIssuerPinId()))
        {
            return false;
        }

        if (!this.getReqPinExpiryDate().equals(other.getReqPinExpiryDate()))
        {
            return false;
        }

        if (!this.getReqPinId().equals(other.getReqPinId()))
        {
            return false;
        }

        if (!this.getReqPanId().equals(other.getReqPanId()))
        {
            return false;
        }

        if (!this.getReqIssuerPanAlias().equals(other.getReqIssuerPanAlias()))
        {
            return false;
        }

        if (!this.getReqPanSeqNumber().equals(other.getReqPanSeqNumber()))
        {
            return false;
        }

        if (!this.getReqPanExpiryDate().equals(other.getReqPanExpiryDate()))
        {
            return false;
        }

        if (!this.getReqPinDeliveryMethod().equals(other.getReqPinDeliveryMethod()))
        {
            return false;
        }

        if (!this.getReqMobilePhone().equals(other.getReqMobilePhone()))
        {
            return false;
        }

        if (!this.getReqTHTitle().equals(other.getReqTHTitle()))
        {
            return false;
        }

        if (!this.getReqTHFirstName().equals(other.getReqTHFirstName()))
        {
            return false;
        }

        if (!this.getReqTHMiddleName().equals(other.getReqTHMiddleName()))
        {
            return false;
        }

        if (!this.getReqTHLastName().equals(other.getReqTHLastName()))
        {
            return false;
        }

        if (!this.getReqTHAddress1().equals(other.getReqTHAddress1()))
        {
            return false;
        }

        if (!this.getReqTHAddress2().equals(other.getReqTHAddress2()))
        {
            return false;
        }

        if (!this.getReqTHAddress3().equals(other.getReqTHAddress3()))
        {
            return false;
        }

        if (!this.getReqTHAddress4().equals(other.getReqTHAddress4()))
        {
            return false;
        }

        if (!this.getReqTHAddress5().equals(other.getReqTHAddress5()))
        {
            return false;
        }

        if (!this.getReqTHAddress6().equals(other.getReqTHAddress6()))
        {
            return false;
        }

        if (!this.getReqTHTown().equals(other.getReqTHTown()))
        {
            return false;
        }

        if (!this.getReqTHPostCode().equals(other.getReqTHPostCode()))
        {
            return false;
        }

        if (!this.getReqTHCountryCode().equals(other.getReqTHCountryCode()))
        {
            return false;
        }

        if (!this.getReqCompanyName().equals(other.getReqCompanyName()))
        {
            return false;
        }

        if (!this.getReqCompanyContact().equals(other.getReqCompanyContact()))
        {
            return false;
        }

        return true;
    }














    }

