package com.aconite.apm.gui.automation.records;

public class TokenOrderFeedbackRecord
{
    private String panId;
    private String pan;
    private String panEncryptedFlag;
    private String panSequenceNumber;
    private String panExpiryDate;
    private String issuerPanAlias;
    private String clearPin;
    private String pinVerificationValue;
    private String pvvKeyIndex;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }


    public String getPanId()
    {
        return panId;
    }

    public void setPanId(String panId)
    {
        this.panId = panId;
    }

    public String getPan()
    {
        return pan;
    }

    public void setPan(String pan)
    {
        this.pan = pan;
    }

    public String getPanEncryptedFlag()
    {
        return panEncryptedFlag;
    }

    public void setPanEncryptedFlag(String panEncryptedFlag)
    {
        this.panEncryptedFlag = panEncryptedFlag;
    }

    public String getPanSequenceNumber()
    {
        return panSequenceNumber;
    }

    public void setPanSequenceNumber(String panSequenceNumber)
    {
        this.panSequenceNumber = nullEmptyFix(panSequenceNumber);
    }

    public String getPanExpiryDate()
    {
        return panExpiryDate;
    }

    public void setPanExpiryDate(String panExpiryDate)
    {
        this.panExpiryDate = panExpiryDate;
    }

    public String getIssuerPanAlias()
    {
        return issuerPanAlias;
    }

    public void setIssuerPanAlias(String issuerPanAlias)
    {
        this.issuerPanAlias = issuerPanAlias;
    }

    public String getPin()
    {
        return clearPin;
    }

    public void setPin(String clearPin)
    {
        this.clearPin = clearPin;
    }

    public String getPinVerificationValue()
    {
        return pinVerificationValue;
    }

    public void setPinVerificationValue(String pinVerificationValue)
    {
        this.pinVerificationValue = pinVerificationValue;
    }

    public String getPvvKeyIndex()
    {
        return pvvKeyIndex;
    }

    public void setPvvKeyIndex(String pvvKeyIndex)
    {
        this.pvvKeyIndex = pvvKeyIndex;
    }


    @Override
    public String toString()
    {
        return "Record: [PANID=" + getPanId() + ", PAN=" + getPan() + ", PANENCRYPTEDFLAG=" + getPanEncryptedFlag() +
                ", PANSEQUENCENUMBER=" + getPanSequenceNumber() + ", PANEXPIRYDATE=" + getPanExpiryDate() +
                ", ISSUERPANALIAS=" + getIssuerPanAlias() +
                ", CLEARPIN=" + getPin() + ", PINVERIFICATIONVALUE=" + getPinVerificationValue() +
                ", PVVKEYINDEX=" + getPvvKeyIndex() + "]";
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

        final TokenOrderFeedbackRecord other = (TokenOrderFeedbackRecord) obj;

        if (!this.panId.equals(other.panId))
        {
            return false;
        }

        if (!this.pan.equals(other.pan))
        {
            return false;
        }

        if (!this.panEncryptedFlag.equals(other.panEncryptedFlag))
        {
            return false;
        }

        if (!this.panSequenceNumber.equals(other.panSequenceNumber))
        {
            return false;
        }

        if (!this.panExpiryDate.equals(other.panExpiryDate))
        {
            return false;
        }

        if (!this.clearPin.equals(other.clearPin))
        {
            return false;
        }

        if (!this.issuerPanAlias.equals(other.issuerPanAlias))
        {
            return false;
        }

        if (!this.pinVerificationValue.equals(other.pinVerificationValue))
        {
            return false;
        }

        if (!this.pvvKeyIndex.equals(other.pvvKeyIndex))
        {
            return false;
        }

        return true;
    }
}
