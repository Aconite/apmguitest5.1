package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class HousekeeperTokenCleanUpDataRecord
{
    private String id;
    private String tokenId;
    private String tokenStatus;
    private String expiryDate;
    private String pinId;
    private String pinStatus;

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

    public String getTokenStatus()
    {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus)
    {
        this.tokenStatus = tokenStatus;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getPinId()
    {
        return pinId;
    }

    public void setPinId(String pinId)
    {
        this.pinId = pinId;
    }

    public String getPinStatus()
    {
        return pinStatus;
    }

    public void setPinStatus(String pinStatus)
    {
        this.pinStatus = pinStatus;
    }




    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", TOKEN_ID=" + getTokenId() + ", TOKEN_STATUS=" + getTokenStatus() +
                ",EXPIRY_DATE=" + getExpiryDate() + ", PIN_ID=" + getPinId() +
                ", PIN_STATUS=" + getPinStatus() + "]";
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

        final HousekeeperTokenCleanUpDataRecord other = (HousekeeperTokenCleanUpDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getTokenId().equals(other.getTokenId()))
        {
            return false;
        }


        if (!this.getTokenStatus().equals(other.getTokenStatus()))
        {
            return false;
        }

        if (!this.getExpiryDate().equals(other.getExpiryDate()))
        {
            return false;
        }

        if (!this.getPinId().equals(other.getPinId()))
        {
            return false;
        }

        if (!this.getPinStatus().equals(other.getPinStatus()))
        {
            return false;
        }

        return true;
    }
}