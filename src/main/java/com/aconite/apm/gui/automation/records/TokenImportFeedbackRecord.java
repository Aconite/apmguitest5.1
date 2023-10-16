package com.aconite.apm.gui.automation.records;

public class TokenImportFeedbackRecord
{
    private String issuerTokenProductCode;

    //There can be one of more of these
    private String tokenApplication;
    private String sequenceNumber;
    private String panId;
    private String pan;
    private String panEncryptedFlag;
    private String panSequenceNumber;
    private String panExpiryDate;
    private String issuerPanAlias;

    private String responseCode;
    private String errorDescription;

    public String getIssuerTokenProductCode()
    {
        return issuerTokenProductCode;
    }

    public void setIssuerTokenProductCode(String issuerTokenProductCode)
    {
        this.issuerTokenProductCode = issuerTokenProductCode;
    }

    public String getTokenApplication()
    {
        return tokenApplication;
    }

    public void setTokenApplication(String tokenApplication)
    {
        this.tokenApplication = tokenApplication;
    }

    public String getSequenceNumber()
    {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber)
    {
        this.sequenceNumber = sequenceNumber;
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
        this.panSequenceNumber = panSequenceNumber;
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

    public String getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(String responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getErrorDescription()
    {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription)
    {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString()
    {
        return "Record: TokenApplication-SequenceNumber:" + getSequenceNumber() + ": " +
                "[PANID=" + getPanId() + ", PAN=" + getPan() + ", PANEncryptedFlag=" + getPanEncryptedFlag() +
                ", PANSequenceNumber=" + getPanSequenceNumber() + ", PANExpiryDate=" + getPanExpiryDate() +
                ", IssuerPANAlias=" + getIssuerPanAlias() +
                ", ResponseCode=" + getResponseCode() + ", ErrorDescription=" + getErrorDescription() + "]";
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

        final TokenImportFeedbackRecord other = (TokenImportFeedbackRecord) obj;

        if (!this.sequenceNumber.equals(other.sequenceNumber))
        {
            return false;
        }

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

        if (!this.issuerPanAlias.equals(other.issuerPanAlias))
        {
            return false;
        }

        if (!this.errorDescription.equals(other.errorDescription))
        {
            return false;
        }

        if (!this.responseCode.equals(other.responseCode))
        {
            return false;
        }

        return true;
    }

}
