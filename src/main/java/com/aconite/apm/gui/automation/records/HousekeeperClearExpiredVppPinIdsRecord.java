package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class HousekeeperClearExpiredVppPinIdsRecord
{
    private String id;
    private String vppPinId;
    private String institutionId;
    private String pinId;
    private String expiryDateTime;
    private String lastUpdateDateTime;

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

    public String getVppPinId()
    {
        return vppPinId;
    }

    public void setVppPinId(String vppPinId)
    {
        this.vppPinId = nullEmptyFix(vppPinId);
    }

    public String getInstitutionId()
    {
        return institutionId;
    }

    public void setInstitutionId(String institutionId)
    {
        this.institutionId = institutionId;
    }

    public String getPinId()
    {
        return pinId;
    }

    public void setPinId(String pinId)
    {
        this.pinId = nullEmptyFix(pinId);
    }

    public String getExpiryDateTime()
    {
        return expiryDateTime;
    }

    public void setExpiryDateTime(String expiryDateTime)
    {
        this.expiryDateTime = expiryDateTime;
    }

    public String getLastUpdateDateTime()
    {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(String lastUpdateDateTime)
    {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", VPPPINID=" + getVppPinId() + ", INSTITUTIONID=" + getInstitutionId() +
                ", PINID=" + getPinId() + ", EXPIRYDATETIME=" + getExpiryDateTime() + ", LASTUPDATEDATETIME=" + getLastUpdateDateTime() + "]";
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

        final HousekeeperClearExpiredVppPinIdsRecord other = (HousekeeperClearExpiredVppPinIdsRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getVppPinId().equals(other.getVppPinId()))
        {
            return false;
        }

        if (!this.getInstitutionId().equals(other.getInstitutionId()))
        {
            return false;
        }

        if (!this.getPinId().equals(other.getPinId()))
        {
            return false;
        }

        if (!this.getExpiryDateTime().equals(other.getExpiryDateTime()))
        {
            return false;
        }

        if (!this.getLastUpdateDateTime().equals(other.getLastUpdateDateTime()))
        {
            return false;
        }

        return true;
    }
}