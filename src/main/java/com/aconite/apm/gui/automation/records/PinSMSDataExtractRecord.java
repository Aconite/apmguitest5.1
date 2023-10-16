package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class PinSMSDataExtractRecord
{
    private String id;
    private String interfaceId;
    private String trxTypeId;
    private String trxStatus;
    private String systemDateTime;
    private String reqDateTime;
    private String reqOrigId;
    private String reqRn;
    private String reqIssuerPinId;
    private String reqIssuerPukId;
    private String reqPukId;
    private String reqPinExpiryDate;
    private String reqPinId;
    private String reqPanId;
    private String reqIssuerPanAlias;
    private String reqPanSeqNumber;
    private String reqPanExpiryDate;
    private String reqTokenAppStatusId;
    private String reqTokenAppSeqNum;
    private String reqIssuerTokenProductCode;
    private String reqPinDeliveryMethod;
    private String reqAdviceAllTokenAppFlag;
    private String reqAdvicePinPukFlag;
    private String reqLanguageCode;
    private String reqMailingCode;
    private String reqPriority;
    private String reqBranchCode;
    private String reqBranchName;
    private String reqNumberofTokens;
    private String reqGeneratePanFlag;
    private String reqGeneratePinFlag;
    private String reqGeneratePukFlag;
    private String reqOrderType;
    private String reqFeedbackRequiredFlag;
    private String reqPreviousPanId;
    private String reqPreviousPanSeqNumber;
    private String reqPreviousPanExpiryDate;
    private String rspResponseCode;
    private String rspErrorDescr;
    private String rspDateTime;
    private String rspPinId;
    private String rspPukId;
    private String rspPanId;
    private String rspPanSeqNumber;
    private String rspPanExpiryDate;
    private String rspIssuerTokenProductCode;
    private String rspTokenAppSeqNum;
    private String rspSmsStatus;
    private String extInstitutionId;
    private String extInstitutionName;
    private String extIssuerId;
    private String extIssuerName;
    private String extTokenProductId;
    private String extIssuerTokenproductCode;
    private String extTokenProductName;
    private String extTokenProductGroupId;
    private String extTokenProductGroupName;
    private String extTokenProductGroupCode;
    private String extPanDisplay;
    private String extIssuerCountryCode;

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

    public String getInterfaceId() { return interfaceId; }

    public void setInterfaceId(String interfaceId) { this.interfaceId = nullEmptyFix(interfaceId); }

    public String getTrxTypeId() { return trxTypeId; }

    public void setTrxTypeId(String trxTypeId) { this.trxTypeId = nullEmptyFix(trxTypeId); }

    public String getTrxStatus() { return trxStatus; }

    public void setTrxStatus(String trxStatus) { this.trxStatus = nullEmptyFix(trxStatus); }

    public String getSystemDateTime() { return systemDateTime; }

    public void setSystemDateTime(String systemDateTime) { this.systemDateTime = millisecondsToOneDP(nullEmptyFix(systemDateTime)); }

    public String getReqDateTime() { return reqDateTime; }

    public void setReqDateTime(String reqDateTime)
    {
        this.reqDateTime = millisecondsToOneDP(nullEmptyFix(reqDateTime));
    }

    public String getReqOrigId()
    {
        return reqOrigId;
    }

    public void setReqOrigId(String reqOrigId)
    {
        this.reqOrigId = nullEmptyFix(reqOrigId);
    }

    public String getReqRn()
    {
        return reqRn;
    }

    public void setReqRn(String reqRn)
    {
        this.reqRn = nullEmptyFix(reqRn);
    }

    public String getReqIssuerPinId()
    {
        return reqIssuerPinId;
    }

    public void setReqIssuerPinId(String reqIssuerPinId)
    {
        this.reqIssuerPinId = nullEmptyFix(reqIssuerPinId);
    }

    public String getReqIssuerPukId()
    {
        return reqIssuerPukId;
    }

    public void setReqIssuerPukId(String reqIssuerPukId)
    {
        this.reqIssuerPukId = nullEmptyFix(reqIssuerPukId);
    }

    public String getReqPukId()
    {
        return reqPukId;
    }

    public void setReqPukId(String reqPukId)
    {
        this.reqPukId = nullEmptyFix(reqPukId);
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

    public String getReqTokenAppStatusId() { return reqTokenAppStatusId; }

    public void setReqTokenAppStatusId(String reqTokenAppStatusId){ this.reqTokenAppStatusId = nullEmptyFix(reqTokenAppStatusId); }

    public String getReqTokenAppSeqNum() { return reqTokenAppSeqNum; }

    public void setReqTokenAppSeqNum(String reqTokenAppSeqNum){ this.reqTokenAppSeqNum = nullEmptyFix(reqTokenAppSeqNum); }

    public String getReqIssuerTokenProductCode() { return reqIssuerTokenProductCode; }

    public void setReqIssuerTokenProductCode(String reqIssuerTokenProductCode){ this.reqIssuerTokenProductCode = nullEmptyFix(reqIssuerTokenProductCode); }

    public String getReqPinDeliveryMethod() { return reqPinDeliveryMethod; }

    public void setReqPinDeliveryMethod(String reqPinDeliveryMethod){ this.reqPinDeliveryMethod = nullEmptyFix(reqPinDeliveryMethod); }

    public String getReqAdviceAllTokenAppFlag() { return reqAdviceAllTokenAppFlag; }

    public void setReqAdviceAllTokenAppFlag(String reqAdviceAllTokenAppFlag){ this.reqAdviceAllTokenAppFlag = nullEmptyFix(reqAdviceAllTokenAppFlag); }

    public String getReqAdvicePinPukFlag() { return reqAdvicePinPukFlag; }

    public void setReqAdvicePinPukFlag(String reqAdvicePinPukFlag){ this.reqAdvicePinPukFlag = nullEmptyFix(reqAdvicePinPukFlag); }

    public String getReqLanguageCode() { return reqLanguageCode; }

    public void setReqLanguageCode(String reqLanguageCode){ this.reqLanguageCode = nullEmptyFix(reqLanguageCode); }

    public String getReqMailingCode() { return reqMailingCode; }

    public void setReqMailingCode(String reqMailingCode){ this.reqMailingCode = nullEmptyFix(reqMailingCode); }

    public String getReqPriority() { return reqPriority; }

    public void setReqPriority(String reqPriority){ this.reqPriority = nullEmptyFix(reqPriority); }

    public String getReqBranchCode() { return reqBranchCode; }

    public void setReqBranchCode(String reqBranchCode){ this.reqBranchCode = nullEmptyFix(reqBranchCode); }

    public String getReqBranchName() { return reqBranchName; }

    public void setReqBranchName(String reqBranchName){ this.reqBranchName = nullEmptyFix(reqBranchName); }

    public String getReqNumberofTokens() { return reqNumberofTokens; }

    public void setReqNumberofTokens(String reqNumberofTokens){ this.reqNumberofTokens = nullEmptyFix(reqNumberofTokens); }

    public String getReqGeneratePanFlag() { return reqGeneratePanFlag; }

    public void setReqGeneratePanFlag(String reqGeneratePanFlag){ this.reqGeneratePanFlag = nullEmptyFix(reqGeneratePanFlag); }

    public String getReqGeneratePinFlag() { return reqGeneratePinFlag; }

    public void setReqGeneratePinFlag(String reqGeneratePinFlag){ this.reqGeneratePinFlag = nullEmptyFix(reqGeneratePinFlag); }

    public String getReqGeneratePukFlag() { return reqGeneratePukFlag; }

    public void setReqGeneratePukFlag(String reqGeneratePukFlag){ this.reqGeneratePukFlag = nullEmptyFix(reqGeneratePukFlag); }

    public String getReqOrderType() { return reqOrderType; }

    public void setReqOrderType(String reqOrderType){ this.reqOrderType = nullEmptyFix(reqOrderType); }

    public String getReqFeedbackRequiredFlag() { return reqFeedbackRequiredFlag; }

    public void setReqFeedbackRequiredFlag(String reqFeedbackRequiredFlag){ this.reqFeedbackRequiredFlag = nullEmptyFix(reqFeedbackRequiredFlag); }

    public String getReqPreviousPanId() { return reqPreviousPanId; }

    public void setReqPreviousPanId(String reqPreviousPanId){ this.reqPreviousPanId = nullEmptyFix(reqPreviousPanId); }

    public String getReqPreviousPanSeqNumber() { return reqPreviousPanSeqNumber; }

    public void setReqPreviousPanSeqNumber(String reqPreviousPanSeqNumber){ this.reqPreviousPanSeqNumber = nullEmptyFix(reqPreviousPanSeqNumber); }

    public String getReqPreviousPanExpiryDate() { return reqPreviousPanExpiryDate; }

    public void setReqPreviousPanExpiryDate(String reqPreviousPanExpiryDate){ this.reqPreviousPanExpiryDate = nullEmptyFix(reqPreviousPanExpiryDate); }

    public String getRspResponseCode() { return rspResponseCode; }

    public void setRspResponseCode(String rspResponseCode){ this.rspResponseCode = nullEmptyFix(rspResponseCode); }

    public String getRspErrorDescr() { return rspErrorDescr; }

    public void setRspErrorDescr(String rspErrorDescr){ this.rspErrorDescr = nullEmptyFix(rspErrorDescr); }

    public String getRspDateTime() { return rspDateTime; }

    public void setRspDateTime(String rspDateTime){ this.rspDateTime = millisecondsToOneDP(nullEmptyFix(rspDateTime)); }

    public String getRspPinId() { return rspPinId; }

    public void setRspPinId(String rspPinId){ this.rspPinId = nullEmptyFix(rspPinId); }

    public String getRspPukId() { return rspPukId; }

    public void setRspPukId(String rspPukId){ this.rspPukId = nullEmptyFix(rspPukId); }

    public String getRspPanId() { return rspPanId; }

    public void setRspPanId(String rspPanId){ this.rspPanId = nullEmptyFix(rspPanId); }

    public String getRspPanSeqNumber() { return rspPanSeqNumber; }

    public void setRspPanSeqNumber(String rspPanSeqNumber){ this.rspPanSeqNumber = nullEmptyFix(rspPanSeqNumber); }

    public String getRspPanExpiryDate() { return rspPanExpiryDate; }

    public void setRspPanExpiryDate(String rspPanExpiryDate){ this.rspPanExpiryDate = nullEmptyFix(rspPanExpiryDate); }

    public String getRspIssuerTokenProductCode() { return rspIssuerTokenProductCode; }

    public void setRspIssuerTokenProductCode(String rspIssuerTokenProductCode){ this.rspIssuerTokenProductCode = nullEmptyFix(rspIssuerTokenProductCode); }

    public String getRspTokenAppSeqNum() { return rspTokenAppSeqNum; }

    public void setRspTokenAppSeqNum(String rspTokenAppSeqNum){ this.rspTokenAppSeqNum = nullEmptyFix(rspTokenAppSeqNum); }

    public String getRspSmsStatus() { return rspSmsStatus; }

    public void setRspSmsStatus(String rspSmsStatus){ this.rspSmsStatus = nullEmptyFix(rspSmsStatus); }

    public String getExtInstitutionId() { return extInstitutionId; }

    public void setExtInstitutionId(String extInstitutionId){ this.extInstitutionId = nullEmptyFix(extInstitutionId); }

    public String getExtInstitutionName() { return extInstitutionName; }

    public void setExtInstitutionName(String extInstitutionName){ this.extInstitutionName = nullEmptyFix(extInstitutionName); }

    public String getExtIssuerId() { return extIssuerId; }

    public void setExtIssuerId(String extIssuerId){ this.extIssuerId = nullEmptyFix(extIssuerId); }

    public String getExtIssuerName() { return extIssuerName; }

    public void setExtIssuerName(String extIssuerName){ this.extIssuerName = nullEmptyFix(extIssuerName); }

    public String getExtTokenProductId() { return extTokenProductId; }

    public void setExtTokenProductId(String extTokenProductId){ this.extTokenProductId = nullEmptyFix(extTokenProductId); }

    public String getExtIssuerTokenproductCode() { return extIssuerTokenproductCode; }

    public void setExtIssuerTokenproductCode(String extIssuerTokenproductCode){ this.extIssuerTokenproductCode = nullEmptyFix(extIssuerTokenproductCode); }

    public String getExtTokenProductName() { return extTokenProductName; }

    public void setExtTokenProductName(String extTokenProductName){ this.extTokenProductName = nullEmptyFix(extTokenProductName); }

    public String getExtTokenProductGroupId() { return extTokenProductGroupId; }

    public void setExtTokenProductGroupId(String extTokenProductGroupId){ this.extTokenProductGroupId = nullEmptyFix(extTokenProductGroupId); }

    public String getExtTokenProductGroupName() { return extTokenProductGroupName; }

    public void setExtTokenProductGroupName(String extTokenProductGroupName){ this.extTokenProductGroupName = nullEmptyFix(extTokenProductGroupName); }

    public String getExtTokenProductGroupCode() { return extTokenProductGroupCode; }

    public void setExtTokenProductGroupCode(String extTokenProductGroupCode){ this.extTokenProductGroupCode = nullEmptyFix(extTokenProductGroupCode); }

    public String getExtPanDisplay() { return extPanDisplay; }

    public void setExtPanDisplay(String extPanDisplay){ this.extPanDisplay = nullEmptyFix(extPanDisplay); }

    public String getExtIssuerCountryCode() { return extIssuerCountryCode; }

    public void setExtIssuerCountryCode(String extIssuerCountryCode){ this.extIssuerCountryCode = nullEmptyFix(extIssuerCountryCode); }

    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", INTERFACEID=" + getInterfaceId() + ", TRXTYPEID=" + getTrxTypeId() +
                        ", TRXSTATUS=" + getTrxStatus() + ", SYSTEMDATETIME=" + getSystemDateTime() +
                        ", REQDATETIME=" + getReqDateTime() + ", REQORIGID=" + getReqOrigId() +
                        ", REQRN=" + getReqRn() + ", REQISSUERPINID=" + getReqIssuerPinId() +
                        ", REQISSUERPUKID=" + getReqIssuerPukId() + ", REQPUKID=" + getReqPukId() +
                        ", REQPINEXPIRYDATE=" + getReqPinExpiryDate() + ", REQPINID=" + getReqPinId() +
                        ", REQPANID=" + getReqPanId() + ", REQISSUERPANALIAS=" + getReqIssuerPanAlias() +
                        ", REQPANSEQNUMBER=" + getReqPanSeqNumber() + ", REQPANEXPIRYDATE=" + getReqPanExpiryDate() +
                        ", REQTOKENAPPSTATUSID=" + getReqTokenAppStatusId() + ", REQTOKENAPPSEQNUM=" + getReqTokenAppSeqNum() +
                        ", REQISSUERTOKENPRODUCTCODE=" + getReqIssuerTokenProductCode() + ", REQPINDELIVERYMETHOD=" + getReqPinDeliveryMethod() +
                        ", REQADVICEALLTOKENAPPFLAG=" + getReqAdviceAllTokenAppFlag() + ", REQADVICEPINPUKFLAG=" + getReqAdvicePinPukFlag() +
                        ", REQLANGUAGECODE=" + getReqLanguageCode() + ", REQMAILINGCODE=" + getReqMailingCode() +
                        ", REQPRIORITY=" + getReqPriority() + ", REQBRANCHCODE=" + getReqBranchCode() +
                        ", REQBRANCHNAME=" + getReqBranchName() + ", REQNUMBEROFTOKENS=" + getReqNumberofTokens() +
                        ", REQGENERATEPANFLAG=" + getReqGeneratePanFlag() + ", REQGENERATEPINFLAG=" + getReqGeneratePinFlag() +
                        ", REQGENERATEPUKFLAG=" + getReqGeneratePukFlag() + ", REQORDERTYPE=" + getReqOrderType() +
                        ", REQFEEDBACKREQUIREDFLAG=" + getReqFeedbackRequiredFlag() + ", REQPREVIOUSPANID=" + getReqPreviousPanId() +
                        ", REQPREVIOUSPANSEQNUMBER=" + getReqPreviousPanSeqNumber() + ", REQPREVIOUSPANEXPIRYDATE=" + getReqPreviousPanExpiryDate() +
                        ", RSPRESPONSECODE=" + getRspResponseCode() + ", RSPERRORDESCR=" + getRspErrorDescr() +
                        ", RSPDATETIME=" + getRspDateTime() + ", RSPPINID=" + getRspPinId() +
                        ", RSPPUKID=" + getRspPukId() + ", RSPPANID=" + getRspPanId() +
                        ", RSPPANSEQNUMBER=" + getRspPanSeqNumber() + ", RSPPANEXPIRYDATE=" + getRspPanExpiryDate() +
                        ", RSPISSUERTOKENPRODUCTCODE=" + getRspIssuerTokenProductCode() + ", RSPTOKENAPPSEQNUM=" + getRspTokenAppSeqNum() +
                        ", RSPSMSSTATUS=" + getRspSmsStatus() + ", EXTINSTITUTIONID=" + getExtInstitutionId() +
                        ", EXTINSTITUTIONNAME=" + getExtInstitutionName() + ", EXTISSUERID=" + getExtIssuerId() +
                        ", EXTISSUERNAME=" + getExtIssuerName() + ", EXTTOKENPRODUCTID=" + getExtTokenProductId() +
                        ", EXTISSUERTOKENPRODUCTCODE=" + getExtIssuerTokenproductCode() + ", EXTTOKENPRODUCTNAME=" + getExtTokenProductName() +
                        ", EXTTOKENPRODUCTGROUPID=" + getExtTokenProductGroupId() + ", EXTTOKENPRODUCTGROUPNAME=" + getExtTokenProductGroupName() +
                        ", EXTTOKENPRODUCTGROUPCODE=" + getExtTokenProductGroupCode() + ", EXTPANDISPLAY=" + getExtPanDisplay() +
                        ", EXTISSUERCOUNTRYCODE=" + getExtIssuerCountryCode() + "]";
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

        final PinSMSDataExtractRecord other = (PinSMSDataExtractRecord) obj;

        if (!this.getId().equals(other.getId())) { return false; }

        if (!this.getInterfaceId().equals(other.getInterfaceId())) { return false; }

        if (!this.getTrxTypeId().equals(other.getTrxTypeId())) { return false; }

        if (!this.getTrxStatus().equals(other.getTrxStatus())) { return false; }

        if (!this.getSystemDateTime().equals(other.getSystemDateTime())) { return false; }

        if (!this.getReqDateTime().equals(other.getReqDateTime())) { return false; }

        if (!this.getReqOrigId().equals(other.getReqOrigId())) { return false; }

        if (!this.getReqRn().equals(other.getReqRn()))
        {
            return false;
        }

        if (!this.getReqIssuerPinId().equals(other.getReqIssuerPinId()))
        {
            return false;
        }

        if (!this.getReqIssuerPukId().equals(other.getReqIssuerPukId()))
        {
            return false;
        }

        if (!this.getReqPukId().equals(other.getReqPukId()))
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

        if (!this.getReqTokenAppStatusId().equals(other.getReqTokenAppStatusId()))
        {
            return false;
        }

        if (!this.getReqTokenAppSeqNum().equals(other.getReqTokenAppSeqNum()))
        {
            return false;
        }

        if (!this.getReqIssuerTokenProductCode().equals(other.getReqIssuerTokenProductCode()))
        {
            return false;
        }

        if (!this.getReqPinDeliveryMethod().equals(other.getReqPinDeliveryMethod()))
        {
            return false;
        }

        if (!this.getReqAdviceAllTokenAppFlag().equals(other.getReqAdviceAllTokenAppFlag()))
        {
            return false;
        }

        if (!this.getReqAdvicePinPukFlag().equals(other.getReqAdvicePinPukFlag()))
        {
            return false;
        }

        if (!this.getReqLanguageCode().equals(other.getReqLanguageCode()))
        {
            return false;
        }

        if (!this.getReqMailingCode().equals(other.getReqMailingCode()))
        {
            return false;
        }

        if (!this.getReqPriority().equals(other.getReqPriority()))
        {
            return false;
        }

        if (!this.getReqBranchCode().equals(other.getReqBranchCode()))
        {
            return false;
        }

        if (!this.getReqBranchName().equals(other.getReqBranchName()))
        {
            return false;
        }

        if (!this.getReqNumberofTokens().equals(other.getReqNumberofTokens()))
        {
            return false;
        }

        if (!this.getReqGeneratePanFlag().equals(other.getReqGeneratePanFlag()))
        {
            return false;
        }

        if (!this.getReqGeneratePinFlag().equals(other.getReqGeneratePinFlag()))
        {
            return false;
        }

        if (!this.getReqGeneratePukFlag().equals(other.getReqGeneratePukFlag()))
        {
            return false;
        }

        if (!this.getReqOrderType().equals(other.getReqOrderType()))
        {
            return false;
        }

        if (!this.getReqFeedbackRequiredFlag().equals(other.getReqFeedbackRequiredFlag()))
        {
            return false;
        }

        if (!this.getReqPreviousPanId().equals(other.getReqPreviousPanId()))
        {
            return false;
        }

        if (!this.getReqPreviousPanSeqNumber().equals(other.getReqPreviousPanSeqNumber()))
        {
            return false;
        }

        if (!this.getReqPreviousPanExpiryDate().equals(other.getReqPreviousPanExpiryDate()))
        {
            return false;
        }

        if (!this.getRspResponseCode().equals(other.getRspResponseCode()))
        {
            return false;
        }

        if (!this.getRspErrorDescr().equals(other.getRspErrorDescr()))
        {
            return false;
        }

        if (!this.getRspDateTime().equals(other.getRspDateTime()))
        {
            return false;
        }

        if (!this.getRspPinId().equals(other.getRspPinId()))
        {
            return false;
        }

        if (!this.getRspPukId().equals(other.getRspPukId()))
        {
            return false;
        }

        if (!this.getRspPanId().equals(other.getRspPanId()))
        {
            return false;
        }

        if (!this.getRspPanSeqNumber().equals(other.getRspPanSeqNumber()))
        {
            return false;
        }

        if (!this.getRspPanExpiryDate().equals(other.getRspPanExpiryDate()))
        {
            return false;
        }

        if (!this.getRspIssuerTokenProductCode().equals(other.getRspIssuerTokenProductCode()))
        {
            return false;
        }

        if (!this.getRspTokenAppSeqNum().equals(other.getRspTokenAppSeqNum()))
        {
            return false;
        }

//        if (!this.getRspSmsStatus().equals(other.getRspSmsStatus()))
//        {
//            return false;
//        }

        if (!this.getExtInstitutionId().equals(other.getExtInstitutionId()))
        {
            return false;
        }

        if (!this.getExtInstitutionName().equals(other.getExtInstitutionName()))
        {
            return false;
        }

        if (!this.getExtIssuerId().equals(other.getExtIssuerId()))
        {
            return false;
        }

        if (!this.getExtIssuerName().equals(other.getExtIssuerName()))
        {
            return false;
        }

        if (!this.getExtTokenProductId().equals(other.getExtTokenProductId()))
        {
            return false;
        }

        if (!this.getExtIssuerTokenproductCode().equals(other.getExtIssuerTokenproductCode()))
        {
            return false;
        }

        if (!this.getExtTokenProductName().equals(other.getExtTokenProductName()))
        {
            return false;
        }

        if (!this.getExtTokenProductGroupId().equals(other.getExtTokenProductGroupId()))
        {
            return false;
        }

        if (!this.getExtTokenProductGroupName().equals(other.getExtTokenProductGroupName()))
        {
            return false;
        }

        if (!this.getExtTokenProductGroupCode().equals(other.getExtTokenProductGroupCode()))
        {
            return false;
        }

        if (!this.getExtPanDisplay().equals(other.getExtPanDisplay()))
        {
            return false;
        }

        if (!this.getExtIssuerCountryCode().equals(other.getExtIssuerCountryCode()))
        {
            return false;
        }
        return true;
    }














    }

