package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class DataLoadPinRecord
{
    private String tokenId;
    private String panEncrypted;
    private String panClear;
    private String appSequenceNumber;
    private String panExpiryDate;
    private String panAlias;
    private String pinId;
    private String pinEncrypted;
    private String pinTranslated;


    private String nullEmptyFix(String param){
        if (param==null || param==""){
            param = " ";
        }
        return param;
    }

    public String getTokenId()
    {
        return tokenId;
    }

    public void setTokenId(String tokenId)
    {
        this.tokenId = tokenId;
    }

    public String getPanEncrypted(){ return panEncrypted; }

    public void setPanEncrypted(String panEncrypted){ this.panEncrypted = nullEmptyFix(panEncrypted); }

    public String getPanClear()
    {
        return panClear;
    }

    public void setPanClear(String panClear)
    {
        this.panClear = nullEmptyFix(panClear);
    }

    public String getAppSequenceNumber()
    {
        return appSequenceNumber;
    }

    public void setAppSequenceNumber(String appSequenceNumber){ this.appSequenceNumber = nullEmptyFix(appSequenceNumber); }

    public String getPanExpiryDate()
    {
        return panExpiryDate;
    }

    public void setPanExpiryDate(String panExpiryDate)
    {
        this.panExpiryDate = nullEmptyFix(panExpiryDate);
    }

    public String getPanAlias()
    {
        return panAlias;
    }

    public void setPanAlias(String panAlias)
    {
        this.panAlias = nullEmptyFix(panAlias);
    }

    public String getPinId()
    {
        return pinId;
    }

    public void setPinId(String pinId)
    {
        this.pinId =nullEmptyFix(pinId);
    }

    public String getPinEncrypted()
    {
        return pinEncrypted;
    }

    public void setPinEncrypted(String pinEncrypted)
    {
        this.pinEncrypted =nullEmptyFix(pinEncrypted);
    }

    public String getPinTranslated()
    {
        return pinTranslated;
    }

    public void setPinTranslated(String pinTranslated)
    {
        this.pinTranslated =nullEmptyFix(pinTranslated);
    }

    @Override
    public String toString()
    {
        return "Record: [TOKENID=" + getTokenId() + ", PANENCRYPTED=" + getPanEncrypted() +
                ", PANCLEAR=" + getPanClear() + ", APPSEQUENCENUMBER=" + getAppSequenceNumber() +
                ", PANEXPIRYDATE=" + getPanExpiryDate() + ", PANALIAS=" + getPanAlias() +
                ", PINID=" + getPinId() + ", PINENCRYPTED=" + getPinEncrypted() +
                ", PINTRANSLATED=" + getPinTranslated() + "]";
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

        final DataLoadPinRecord other = (DataLoadPinRecord) obj;

        if (!this.getTokenId().equals(other.getTokenId()))
        {
            return false;
        }

        if (!this.getPanEncrypted().equals(other.getPanEncrypted()))
        {
            return false;
        }

        if (!this.getPanClear().equals(other.getPanClear()))
        {
            return false;
        }

        if (!this.getAppSequenceNumber().equals(other.getAppSequenceNumber()))
        {
            return false;
        }

        if (!this.getPanExpiryDate().equals(other.getPanExpiryDate()))
        {
            return false;
        }

        if (!this.getPanAlias().equals(other.getPanAlias()))
        {
            return false;
        }

        if (!this.getPinId().equals(other.getPinId()))
        {
            return false;
        }

        if (!this.getPinEncrypted().equals(other.getPinEncrypted()))
        {
            return false;
        }

        if (!this.getPinTranslated().equals(other.getPinTranslated()))
        {
            return false;
        }

        return true;
    }
}