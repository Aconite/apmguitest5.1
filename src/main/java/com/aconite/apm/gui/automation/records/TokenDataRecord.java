package com.aconite.apm.gui.automation.records;

import java.sql.SQLOutput;

public class TokenDataRecord
{
    private String id;
    private String status;
    private String tokenproductId;
    private String defaultTokenAppId;
    private String customerCode;

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
        this.status = status;
    }

    public String getTokenProductId()
    {
        return tokenproductId;
    }

    public void setTokenProductId(String tokenproductId)
    {
        this.tokenproductId = tokenproductId;
    }

    public String getDefaultTokenAppId()
    {
        return defaultTokenAppId;
    }

    public void setDefaultTokenAppId(String defaultTokenAppId)
    {
        this.defaultTokenAppId = defaultTokenAppId;
    }

    public String getCustomerCode()
    {
        return customerCode;
    }

    public void setCustomerCode(String customerCode)
    {
        this.customerCode = nullEmptyFix(customerCode);
    }


    @Override
    public String toString()
    {
        return "Record: [ID=" + getId() + ", STATUS=" + getStatus() + ", TOKEN_PRODUCT_ID=" + getTokenProductId() + ", DEFAULT_TOKEN_APP_ID=" + getDefaultTokenAppId() + ", CUSTOMER_CODE=" + getCustomerCode() + "]";
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

        final TokenDataRecord other = (TokenDataRecord) obj;

        if (!this.getId().equals(other.getId()))
        {
            return false;
        }

        if (!this.status.equals(other.status))
        {
            return false;
        }

        if (!this.tokenproductId.equals(other.tokenproductId))
        {
            return false;
        }

        if (!this.defaultTokenAppId.equals(other.defaultTokenAppId))
        {
            return false;
        }

        if (!this.customerCode.equals(other.customerCode))
        {
            return false;
        }

        return true;
    }
}