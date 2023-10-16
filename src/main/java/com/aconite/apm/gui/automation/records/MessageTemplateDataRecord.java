package com.aconite.apm.gui.automation.records;

@SuppressWarnings("Annotation")
public class MessageTemplateDataRecord
{
    private String parentInstitution; // for searches on data - not for comparison
    private String id;
    private String name;
    private String institutionName;
    private String Pan;
    private String panSequence;
    private String expiryDate;
    private String panAlias;
    private String panId;
    private String pinPukFlag;
    private String pinBlock;
    private String pukBlock;
    private String pinVerificationValue;
    private String pukVerificationValue;
    private String customerCode;
    private String operation;
    private String tokenProductName;
    private String appSequenceNumber;
    private String fixedData;


    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    private String setToTrueFalse(String param){
        if(param!=null) {
            if (param.equals("Y") || param.equals("A")) {
                param = "true";
            }
            if (param.equals("I") || param.equals("N")) {
                param = "false";
            }
        }
        return param;
    }
    public String getParentInstitution(){ return parentInstitution; }

    public void setParentInstitution(String parentinstitution){ this.parentInstitution = nullEmptyFix(parentinstitution); }

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

    public void setName(String name)
    {
        this.name = nullEmptyFix(name);
    }

    public String getInstitutionName(){ return institutionName; }

    public void setInstitutionName(String institutionName){ this.institutionName = nullEmptyFix(institutionName); }

    public String getPan()
    {
        return Pan;
    }

    public void setPan(String Pan)
    {
        this.Pan = setToTrueFalse(Pan);
    }

    public String getPanSequence() { return panSequence; }

    public void setPanSequence(String panSequence) { this.panSequence = setToTrueFalse(panSequence); }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiryDate) { this.expiryDate = setToTrueFalse(expiryDate); }

    public String getPanAlias() { return panAlias; }

    public void setPanAlias(String panAlias) { this.panAlias = setToTrueFalse(panAlias); }

    public String getPanId() { return panId; }

    public void setPanId(String panId) { this.panId = setToTrueFalse(panId); }

    public String getPinPukFlag() { return pinPukFlag; }

    public void setPinPukFlag(String pinPukFlag) { this.pinPukFlag = setToTrueFalse(pinPukFlag); }

    public String getPinBlock() { return pinBlock; }

    public void setPinBlock(String pinBlock) { this.pinBlock = setToTrueFalse(pinBlock); }

    public String getPukBlock() { return pukBlock; }

    public void setPukBlock(String pukBlock) { this.pukBlock = setToTrueFalse(pukBlock); }

    public String getPinVerificationValue() { return pinVerificationValue; }

    public void setPinVerificationValue(String pinVerificationValue) { this.pinVerificationValue = setToTrueFalse(pinVerificationValue); }

    public String getPukVerificationValue() { return pukVerificationValue; }

    public void setPukVerificationValue(String pukVerificationValue) { this.pukVerificationValue = setToTrueFalse(pukVerificationValue); }

    public String getCustomerCode() { return customerCode; }

    public void setCustomerCode(String customerCode) { this.customerCode = setToTrueFalse(customerCode); }

    public String getOperation() { return operation; }

    public void setOperation(String operation) { this.operation = setToTrueFalse(operation); }

    public String getTokenProductName() { return tokenProductName; }

    public void setTokenProductName(String tokenProductName) { this.tokenProductName = setToTrueFalse(tokenProductName); }

    public String getAppSequenceNumber() { return appSequenceNumber; }

    public void setAppSequenceNumber(String appSequenceNumber) { this.appSequenceNumber = setToTrueFalse(appSequenceNumber); }

    public String getFixedData() { return fixedData; }

    public void setFixedData(String fixedData) { this.fixedData = nullEmptyFix(fixedData); }



    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TEMPLATENAME=" + getName() + ", INSTITUTIONNAME=" + getInstitutionName() +
                ", PAN=" + getPan() + ", PANSEQUENCE=" + getPanSequence() + ", EXPIRYDATE=" + getExpiryDate() +
                ", PANALIAS=" + getPanAlias() + ", PANID=" + getPanId() + ", PINPUKFLAG=" + getPinPukFlag() +
                ", PINBLOCK=" + getPinBlock() + ", PUKBLOCK=" + getPukBlock() +
                ", PINVERIFICATIONVALUE=" + getPinVerificationValue() +
                ", PUKVERIFICATIONVALUE=" + getPukVerificationValue() +
                ", CUSTOMERCODE=" + getCustomerCode() + ", OPERATION=" + getOperation() +
                ", TOKENPRODUCTNAME=" + getTokenProductName() + ", APPSEQNUMBER=" + getAppSequenceNumber() +
                ", FIXEDDATA=" + getFixedData() + "]";
    }

    public String toStringTable(){

        return "Record: [ID=" + getId() + ", TEMPLATENAME=" + getName() +
//                ", INSTITUTIONNAME=" + getInstitutionName() +
                "]";

    }

    public boolean equalsTable(Object obj){

        if (obj == null)
        {
            return false;
        }

        if (obj.getClass() != this.getClass())
        {
            return false;
        }

        final MessageTemplateDataRecord other = (MessageTemplateDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

//        if (!this.getInstitutionName().equals(other.getInstitutionName()))
//        {
//            return false;
//        }

        return true;

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

        final MessageTemplateDataRecord other = (MessageTemplateDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getName().equals(other.getName()))
        {
            return false;
        }

        if (!this.getInstitutionName().equals(other.getInstitutionName()))
        {
            return false;
        }

        if (!this.getPan().equals(other.getPan()))
        {
            return false;
        }

        if (!this.getPanSequence().equals(other.getPanSequence()))
        {
            return false;
        }

        if(!this.getExpiryDate().equals(other.getExpiryDate())){
            return false;
        }

        if(!this.getPanAlias().equals(other.getPanAlias())){
            return false;
        }

        if(!this.getPanId().equals(other.getPanId())){
            return false;
        }

        if(!this.getPinPukFlag().equals(other.getPinPukFlag())){
            return false;
        }

        if(!this.getPinBlock().equals(other.getPinBlock())){
            return false;
        }

        if(!this.getPukBlock().equals(other.getPukBlock())){
            return false;
        }

        if(!this.getPinVerificationValue().equals(other.getPinVerificationValue())){
            return false;
        }

        if(!this.getPukVerificationValue().equals(other.getPukVerificationValue())){
            return false;
        }

        if(!this.getCustomerCode().equals(other.getCustomerCode())){
            return false;
        }

        if(!this.getOperation().equals(other.getOperation())){
            return false;
        }

        if(!this.getTokenProductName().equals(other.getTokenProductName())){
            return false;
        }

        if(!this.getAppSequenceNumber().equals(other.getAppSequenceNumber())){
            return false;
        }

        return true;
    }
}