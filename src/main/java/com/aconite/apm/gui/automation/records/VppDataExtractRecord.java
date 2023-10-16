package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class VppDataExtractRecord
{
    private String id;
    private String interfaceId;
    private String trxTypeId;
    private String trxStatus;

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

    public String getInterfaceId()
    {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId)
    {
        this.interfaceId = nullEmptyFix(interfaceId);
    }

    public String getTrxTypeId()
    {
        return trxTypeId;
    }

    public void setTrxTypeId(String trxTypeId)
    {
        this.trxTypeId = trxTypeId;
    }

    public String getTrxStatus()
    {
        return trxStatus;
    }

    public void setTrxStatus(String trxStatus)
    {
        this.trxStatus = trxStatus;
    }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", INTERFACEID=" + getInterfaceId() + ", TRXTYPEID=" + getTrxTypeId() + ", TRXSTATUS=" +
                getTrxStatus() + "]";
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

        final VppDataExtractRecord other = (VppDataExtractRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.getInterfaceId().equals(other.getInterfaceId()))
        {
            return false;
        }

        if (!this.getTrxTypeId().equals(other.getTrxTypeId()))
        {
            return false;
        }

        if (!this.getTrxStatus().equals(other.getTrxStatus()))
        {
            return false;
        }

        return true;
    }
}