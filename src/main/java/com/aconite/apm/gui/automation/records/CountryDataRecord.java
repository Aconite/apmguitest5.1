package com.aconite.apm.gui.automation.records;

public class CountryDataRecord {

    private String countryName;
    private String countryCode;

    private String nullEmptyFix(String param){
        if (param==null || param.equals("")){
            param = " ";
        }
        return param;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString()
    {
        return "Record: [COUNTRYNAME=" + getCountryName() +
                ", COUNTRYCODE=" + getCountryCode() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final CountryDataRecord other = (CountryDataRecord) obj;


        if (!this.getCountryCode().equals(other.getCountryCode())) {
            return false;
        }

        if (!this.getCountryName().equals(other.getCountryName())) {
            return false;
        }

        return true;
    }


}
