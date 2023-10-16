package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class TokenApplicationDataRecord
{
    private String id;
    private String tokenId;
    private String tokenproductId;
    private String appSeqNumber;
    private String statusId;
    private String panDisplay;
    private String panAlias;
    private String panSeqNumber;
    private String expiryDate;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTokenId()
    {
        return tokenId;
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

    public String getTokenProductId()
    {
        return tokenproductId;
    }

    public void setTokenProductId(String tokenproductId)
    {
        this.tokenproductId = tokenproductId;
    }

    public String getAppSeqNumber()
    {
        return appSeqNumber;
    }

    public void setAppSeqNumber(String appSeqNumber)
    {
        this.appSeqNumber = appSeqNumber;
    }

    public String getStatusId()
    {
        return statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    public String getPanDisplay()
    {
        return panDisplay;
    }

    public void setPanDisplay(String panDisplay)
    {
        this.panDisplay = panDisplay;
    }

    public String getPanAlias()
    {
        return panAlias;
    }

    public void setPanAlias(String panAlias)
    {
        if (panAlias == null)
            {
            this.panAlias = " ";
            }
        else{
            this.panAlias = panAlias;
            }
    }

    public String getPanSeqNumber()
    {
        return panSeqNumber;
    }

    public void setPanSeqNumber(String panSeqNumber)
    {
        this.panSeqNumber = panSeqNumber;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TOKEN_ID=" + getTokenId() + ", TOKEN_PRODUCT_ID=" + getTokenProductId() + ", APP_SEQ_NUMBER=" + getAppSeqNumber() + ", STATUS_ID=" + getStatusId() + ", PAN_DISPLAY=" + getPanDisplay() + ", PAN_ALIAS=" + getPanAlias() + ", PAN_SEQ_NUMBER=" + getPanSeqNumber() + ", EXPIRY_DATE=" + getExpiryDate() + "]";
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

        final TokenApplicationDataRecord other = (TokenApplicationDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getTokenId().equals(other.getTokenId()))
        {
            return false;
        }

        if (!this.getTokenProductId().equals(other.getTokenProductId()))
        {
            return false;
        }

        if (!this.getAppSeqNumber().equals(other.getAppSeqNumber()))
        {
            return false;
        }

        if (!this.getStatusId().equals(other.getStatusId()))
        {
            return false;
        }

        if (!this.getPanDisplay().equals(other.getPanDisplay()))
        {
            return false;
        }

        if (!this.getPanAlias().equals(other.getPanAlias()))
        {
            return false;
        }

        if (!this.getPanSeqNumber().equals(other.getPanSeqNumber()))
        {
            return false;
        }

        if (!this.getExpiryDate().equals(other.getExpiryDate()))
        {
            return false;
        }

        return true;
    }
}