package com.aconite.apm.gui.automation.records;

public class PVVDataRecord {

    private String parentInstitution;
    private String parentIssuer;
    private String parentTokenProduct;
    private String parentTokenProductId;
    private String id;
    private String parentTokenApplicationProfileName;
    private String parentTokenApplicationProfileAppSeqNum;
    private String pvkIdentifier;
    private String pinVerificationKey;
    private String pinVerificationMethod;




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

    public String getParentTokenApplicationProfileName()
    {
        return parentTokenApplicationProfileName;
    }

    public void setParentTokenApplicationProfileName(String parentTokenApplicationProfileName) { this.parentTokenApplicationProfileName = parentTokenApplicationProfileName; }

    public String getParentTokenApplicationProfileAppSeqNum() { return parentTokenApplicationProfileAppSeqNum; }

    public void setParentTokenApplicationProfileAppSeqNum(String parentTokenApplicationProfileAppSeqNum) { this.parentTokenApplicationProfileAppSeqNum = parentTokenApplicationProfileAppSeqNum; }

    public String getId() { return id; }

    public void setId(String id){ this.id = id; }

    public String getPvkIdentifier() {  return pvkIdentifier; }

    public void setPvkIdentifier(String pvkIdentifier) {
        this.pvkIdentifier = pvkIdentifier;
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


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TOKENPRODUCT=" + getParentTokenProduct() +
                ", APPSEQNUM=" + getParentTokenApplicationProfileAppSeqNum() +
                ", PVKIDENTIFIER=" + getPvkIdentifier() + ", PINVERIFICATIONKEY=" + getPinVerificationKey() +
                ", PINVERIFICATIONMETHOD=" + getPinVerificationMethod() + "]";

    }

    public String toStringAllFields()
    {
        return "Record: [PARENTINSTITUTION=" + getParentInstitution() +
                ", PARENTISSUER=" + getParentIssuer() + ", TOKENPRODUCT=" + getParentTokenProduct() +
                ", TOKENPRODUCTID=" + getParentTokenProductId() + ", ID=" + getId() +
                ", APPSEQNUM=" + getParentTokenApplicationProfileAppSeqNum() +
                ", PVKIDENTIFIER=" + getPvkIdentifier() + ", PINVERIFICATIONKEY=" + getPinVerificationKey() +
                ", PINVERIFICATIONMETHOD=" + getPinVerificationMethod() + "]";

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final PVVDataRecord other = (PVVDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getParentTokenApplicationProfileAppSeqNum().equals(other.getParentTokenApplicationProfileAppSeqNum()))
        {
            return false;
        }

        if (!this.getParentTokenProduct().equals(other.getParentTokenProduct()))
        {
            return false;
        }

        if (!this.getPvkIdentifier().equals(other.getPvkIdentifier()))
        {
            return false;
        }

        if (!this.getPinVerificationKey().equals(other.getPinVerificationKey()))
        {
            return false;
        }

        if (!this.getPinVerificationMethod().equals(other.getPinVerificationMethod()))
        {
            return false;
        }

        return true;

    }

}
