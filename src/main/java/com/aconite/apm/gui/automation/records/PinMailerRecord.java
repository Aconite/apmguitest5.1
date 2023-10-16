package com.aconite.apm.gui.automation.records;

import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import org.apache.commons.lang.StringUtils;

public class PinMailerRecord
{
    private String pin;
    private String pinBlockFormat;
    private String pan;
    private String panEncryptedFlag;
    private String panMasked;
    private String mailingCode;

//    private String tokenholderName;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;

    //make this it's own object at some point?
//    private String tokenholderAddress;
    private String thAddressLine1;
    private String thAddressLine2;
    private String thAddressLine3;
    private String thAddressLine4;
    private String thAddressLine5;
    private String thAddressLine6;
    private String thTown;
    private String thPostCode;
    private String thCountryCode;

    //make this it's own object at some point?
//    private String issuerBranch;
    private String branchCode;
    private String branchName;
    private String ibAddressLine1;
    private String ibAddressLine2;
    private String ibAddressLine3;
    private String ibAddressLine4;
    private String ibAddressLine5;
    private String ibAddressLine6;
    private String ibTown;
    private String ibPostCode;
    private String ibCountryCode;

    private String priority;
    private String languageCode;
    private String companyName;
    private String companyContact;
    private String passthroughData;
    private String issuerName;
    private String issuerId;
    private String issuerTokenProductCode;
    private String tokenProductName;

    private String nullEmptyFix(String param){
        if (param==null || param==""){
            param = " ";
        }
        return param;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public String getPinBlockFormat()
    {
        return pinBlockFormat;
    }

    public void setPinBlockFormat(String pinBlockFormat)
    {
        this.pinBlockFormat = pinBlockFormat;
    }

    public String getPan()
    {
        return pan;
    }

    public void setPan(String pan)
    {
        this.pan = nullEmptyFix(pan);
    }

    public String getPanEncryptedFlag()
    {
        return panEncryptedFlag;
    }

    public void setPanEncryptedFlag(String panEncryptedFlag)
    {
        this.panEncryptedFlag = nullEmptyFix(panEncryptedFlag);
    }

    public String getPanMasked()
    {
        return panMasked;
    }

    public void setPanMasked(String panMasked) { this.panMasked = panMasked; }

    public String getMailingCode()
    {
        return mailingCode;
    }

    public void setMailingCode(String mailingCode)
    {
        this.mailingCode = nullEmptyFix(mailingCode);
    }

//    public String getTokenholderName()
//    {
//        return tokenholderName;
//    }
//
//    public void setTokenholderName(String tokenholderName)
//    {
//        this.tokenholderName = tokenholderName;
//    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = nullEmptyFix(title);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = nullEmptyFix(firstName);
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = nullEmptyFix(middleName);
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = nullEmptyFix(lastName);
    }

//    public String getTokenholderAddress()
//    {
//        return tokenholderAddress;
//    }
//
//    public void setTokenholderAddress(String tokenholderAddress)
//    {
//        this.tokenholderAddress = tokenholderAddress;
//    }

    public String getThAddressLine1()
    {
        return thAddressLine1;
    }

    public void setThAddressLine1(String thAddressLine1)
    {
        this.thAddressLine1 = nullEmptyFix(thAddressLine1);
    }

    public String getThAddressLine2()
    {
        return thAddressLine2;
    }

    public void setThAddressLine2(String thAddressLine2)
    {
        this.thAddressLine2 = nullEmptyFix(thAddressLine2);
    }

    public String getThAddressLine3()
    {
        return thAddressLine3;
    }

    public void setThAddressLine3(String thAddressLine3)
    {
        this.thAddressLine3 = nullEmptyFix(thAddressLine3);
    }

    public String getThAddressLine4()
    {
        return thAddressLine4;
    }

    public void setThAddressLine4(String thAddressLine4)
    {
        this.thAddressLine4 = nullEmptyFix(thAddressLine4);
    }

    public String getThAddressLine5()
    {
        return thAddressLine5;
    }

    public void setThAddressLine5(String thAddressLine5)
    {
        this.thAddressLine5 = nullEmptyFix(thAddressLine5);
    }

    public String getThAddressLine6()
    {
        return thAddressLine6;
    }

    public void setThAddressLine6(String thAddressLine6)
    {
        this.thAddressLine6 = nullEmptyFix(thAddressLine6);
    }

    public String getThTown()
    {
        return thTown;
    }

    public void setThTown(String thTown)
    {
        this.thTown = nullEmptyFix(thTown);
    }

    public String getThPostCode()
    {
        return thPostCode;
    }

    public void setThPostCode(String thPostCode)
    {
        this.thPostCode = nullEmptyFix(thPostCode);
    }

    public String getThCountryCode()
    {
        return thCountryCode;
    }

    public void setThCountryCode(String thCountryCode)
    {
        this.thCountryCode = nullEmptyFix(thCountryCode);
    }

//    public String getIssuerBranch()
//    {
//        return issuerBranch;
//    }
//
//    public void setIssuerBranch(String issuerBranch)
//    {
//        this.issuerBranch = issuerBranch;
//    }

    public String getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(String branchCode)
    {
        this.branchCode = nullEmptyFix(branchCode);
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setBranchName(String branchName)
    {
        this.branchName = nullEmptyFix(branchName);
    }

    public String getIbAddressLine1()
    {
        return ibAddressLine1;
    }

    public void setIbAddressLine1(String ibAddressLine1){ this.ibAddressLine1 = nullEmptyFix(ibAddressLine1); }

    public String getIbAddressLine2()
    {
        return ibAddressLine2;
    }

    public void setIbAddressLine2(String ibAddressLine2)
    {
        this.ibAddressLine2 = nullEmptyFix(ibAddressLine2);
    }

    public String getIbAddressLine3()
    {
        return ibAddressLine3;
    }

    public void setIbAddressLine3(String ibAddressLine3)
    {
        this.ibAddressLine3 = nullEmptyFix(ibAddressLine3);
    }

    public String getIbAddressLine4()
    {
        return ibAddressLine4;
    }

    public void setIbAddressLine4(String ibAddressLine4)
    {
        this.ibAddressLine4 = nullEmptyFix(ibAddressLine4);
    }

    public String getIbAddressLine5()
    {
        return ibAddressLine5;
    }

    public void setIbAddressLine5(String ibAddressLine5)
    {
        this.ibAddressLine5 = nullEmptyFix(ibAddressLine5);
    }

    public String getIbAddressLine6()
    {
        return ibAddressLine6;
    }

    public void setIbAddressLine6(String ibAddressLine6)
    {
        this.ibAddressLine6 = nullEmptyFix(ibAddressLine6);
    }

    public String getIbTown()
    {
        return ibTown;
    }

    public void setIbTown(String ibTown)
    {
        this.ibTown = nullEmptyFix(ibTown);
    }

    public String getIbPostCode()
    {
        return ibPostCode;
    }

    public void setIbPostCode(String ibPostCode)
    {
        this.ibPostCode = nullEmptyFix(ibPostCode);
    }

    public String getIbCountryCode()
    {
        return ibCountryCode;
    }

    public void setIbCountryCode(String ibCountryCode)
    {
        this.ibCountryCode = nullEmptyFix(ibCountryCode);
    }

    public String getPriority()
    {
        return priority;
    }

    public void setPriority(String priority)
    {
        this.priority = nullEmptyFix(priority);
    }

    public String getLanguageCode()
    {
        return languageCode;
    }

    public void setLanguageCode(String languageCode)
    {
        this.languageCode = nullEmptyFix(languageCode);
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = nullEmptyFix(companyName);
    }

    public String getCompanyContact()
    {
        return companyContact;
    }

    public void setCompanyContact(String companyContact)
    {
        this.companyContact = nullEmptyFix(companyContact);
    }

    public String getPassthroughData()
    {
        return passthroughData;
    }

    public void setPassthroughData(String passthroughData)
    {
        this.passthroughData = nullEmptyFix(passthroughData);
    }

    public String getIssuerName()
    {
        return issuerName;
    }

    public void setIssuerName(String issuerName)
    {
        this.issuerName = nullEmptyFix(issuerName);
    }

    public String getIssuerTokenProductCode()
    {
        return issuerTokenProductCode;
    }

    public void setIssuerTokenProductCode(String issuerTokenProductCode)
    {
        this.issuerTokenProductCode = nullEmptyFix(issuerTokenProductCode);
    }

    public String getTokenProductName()
    {
        return tokenProductName;
    }

    public void setTokenProductName(String tokenProductName)
    {
        this.tokenProductName = nullEmptyFix(tokenProductName);
    }

    public String getIssuerId()
    {
        return issuerId;
    }

    public void setIssuerId(String issuerId)
    {
        this.issuerId = nullEmptyFix(issuerId);
    }

    @Override
    public String toString()
    {
        return "Record: \nPIN=" + getPin() + ", PINBlockFormat=" + getPinBlockFormat() + "\n" +
                "PAN=" + getPan() + ", PANMasked=" + getPanMasked() + "\n" +
                "[TokenholderName: Title=" + getTitle() + ", FirstName=" + getFirstName() + ", MiddleName=" + getMiddleName() +
                ", LastName=" + getLastName() + "]\n" +
                "[TokenholderAddress: AddressLine1=" + getThAddressLine1() + ", AddressLine2=" + getThAddressLine2() +
                ", AddressLine3=" + getThAddressLine3() + ", AddressLine4=" + getThAddressLine4() + ", AddressLine5=" + getThAddressLine5() +
                ", AddressLine6=" + getThAddressLine6() + ", Town=" + getThTown() + ", PostCode=" + getThPostCode() +
                ", CountryCode=" + getThCountryCode() + "]\n" +
                "[IssuerBranch: AddressLine1=" + getIbAddressLine1() + ", AddressLine2=" + getIbAddressLine2() +
                ", AddressLine3=" + getIbAddressLine3() + ", AddressLine4=" + getIbAddressLine4() + ", AddressLine5=" + getIbAddressLine5() +
                ", AddressLine6=" + getIbAddressLine6() + ", Town=" + getIbTown() + ", PostCode=" + getIbPostCode() +
                ", CountryCode=" + getIbCountryCode() + "]\n" +
                "Priority=" + getPriority() + ", LanguageCode=" + getLanguageCode() + ", CompanyName=" + getCompanyName() +
                ", CompanyContact=" + getCompanyContact() + ", IssuerName=" + getIssuerName() + ", MailingCode=" + getMailingCode() +
                ", IssuerTokenProductCode=" + getIssuerTokenProductCode() + ", IssuerId=" + getIssuerId() +
                ", TokenProductName=" + getTokenProductName() + "\n" +
                "PassthroughData=" + getPassthroughData() + "\n";
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

        final PinMailerRecord other = (PinMailerRecord) obj;

        if (!this.pin.equals(other.pin))
        {
            return false;
        }

        if (!this.pinBlockFormat.equals(other.pinBlockFormat))
        {
            return false;
        }

        if (!this.pan.equals(other.pan))
        {
            return false;
        }

//        if (!this.panEncryptedFlag.equals(other.panEncryptedFlag))
//        {
//            return false;
//        }


//        if (!this.panMasked.equals(other.panMasked))
//        {
//            return false;
//        }

        if (!this.mailingCode.equals(other.mailingCode))
        {
            return false;
        }

        if (!this.thAddressLine1.equals(other.thAddressLine1))
        {
            return false;
        }

        if (!this.thAddressLine2.equals(other.thAddressLine2))
        {
            return false;
        }

        if (!this.thAddressLine3.equals(other.thAddressLine3))
        {
            return false;
        }

        if (!this.thAddressLine4.equals(other.thAddressLine4))
        {
            return false;
        }

        if (!this.thAddressLine5.equals(other.thAddressLine5))
        {
            return false;
        }

        if (!this.thAddressLine6.equals(other.thAddressLine6))
        {
            return false;
        }

        if (!this.thTown.equals(other.thTown))
        {
            return false;
        }

        if (!this.thPostCode.equals(other.thPostCode))
        {
            return false;
        }

        if (!this.thCountryCode.equals(other.thCountryCode))
        {
            return false;
        }

//        if (!this.getIbAddressLine1().equals(other.getIbAddressLine1()))
//        {
//            System.out.println("Branch Address 1 - This >" + this.ibAddressLine1 + "<");
//            System.out.println("Branch Address 1 - Other >" + other.ibAddressLine1 + "<");
//            return false;
//        }
//
//        if (!this.ibAddressLine2.equals(other.ibAddressLine2))
//        {
//            return false;
//        }
//
//        if (!this.ibAddressLine3.equals(other.ibAddressLine3))
//        {
//            return false;
//        }
//
//        if (!this.ibAddressLine4.equals(other.ibAddressLine4))
//        {
//            return false;
//        }
//
//        if (!this.ibAddressLine5.equals(other.ibAddressLine5))
//        {
//            return false;
//        }
//
//        if (!this.ibAddressLine6.equals(other.ibAddressLine6))
//        {
//            return false;
//        }
//
//        if (!this.ibTown.equals(other.ibTown))
//        {
//            return false;
//        }
//
//        if (!this.ibPostCode.equals(other.ibPostCode))
//        {
//            return false;
//        }
//
//        if (!this.ibCountryCode.equals(other.ibCountryCode))
//        {
//            return false;
//        }

        if (!this.priority.equals(other.priority))
        {
            return false;
        }

        if (!this.languageCode.equals(other.languageCode))
        {
            return false;
        }

        if (!this.companyName.equals(other.companyName))
        {
            return false;
        }

        if (!this.companyContact.equals(other.companyContact))
        {
            return false;
        }

        // Workaround: it seems like the value in the database does not have the 0x0D character which is present when
        // the XML element in the parent <PassThroughData> data is serialized.
        String str1 = this.passthroughData.replaceAll("\\r", "");
        String str2 = other.passthroughData.replaceAll("\\r", "");

        if (!str1.equals(str2))
        {
//            System.out.println(StringUtils.difference(str1, str2));
//            System.out.println(CryptoUtils.hexify(this.passthroughData));
//            System.out.println(CryptoUtils.hexify(other.passthroughData));
            return false;
        }

        if (!this.issuerName.equals(other.issuerName))
        {
            return false;
        }

        if (!this.issuerTokenProductCode.equals(other.issuerTokenProductCode))
        {
            return false;
        }

        if (!this.issuerId.equals(other.issuerId))
        {
            return false;
        }

        if (!this.tokenProductName.equals(other.tokenProductName))
        {
            return false;
        }

        return true;
    }
}
