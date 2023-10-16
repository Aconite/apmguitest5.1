package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class PinDataRecord
{
    private String id;
    private String status;
    private String creationDateTime;
    private String expiryDateTime;
    private String issuerPinId;
    private String pinPukFlag;

    private String nullEmptyFix(String param){
        if (param==null || param==""){
            param = " ";
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = nullEmptyFix(status);
    }

    public String getCreationDateTime()
    {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime)
    {
        this.creationDateTime = nullEmptyFix(creationDateTime);
    }

    public String getExpiryDateTime()
    {
        return expiryDateTime;
    }

    public void setExpiryDateTime(String expiryDateTime)
    {
        this.expiryDateTime = nullEmptyFix(expiryDateTime);
    }

    public String getIssuerPinId()
    {
        return issuerPinId;
    }

    public void setIssuerPinId(String issuerPinId)
    {
        this.issuerPinId = nullEmptyFix(issuerPinId);
    }

    public String getPinPukFlag()
    {
        return pinPukFlag;
    }

    public void setPinPukFlag(String pinPukFlag)
    {
        this.pinPukFlag =nullEmptyFix(pinPukFlag);
    }

    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", STATUS=" + getStatus() + ", CREATIONDATETIME=" + getCreationDateTime() + ", EXPIRYDATETIME=" + getExpiryDateTime() + ", ISSUERPINID=" + getIssuerPinId() + ", PINPUKFLAG=" +
                getPinPukFlag() + "]";
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

        final PinDataRecord other = (PinDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getStatus().equals(other.getStatus()))
        {
            return false;
        }

        if (!this.creationDateTime.equals(other.creationDateTime))
        {
            return false;
        }

        if (!this.expiryDateTime.equals(other.expiryDateTime))
        {
            return false;
        }

        if (!this.issuerPinId.equals(other.issuerPinId))
        {
            return false;
        }

        if (!this.pinPukFlag.equals(other.pinPukFlag))
        {
            return false;
        }

        return true;
    }
}