package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinAdvice
{

    public static String dataloadPinAdviceByPanIdSMS(String panId){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                                "<apm:PANID>" + panId + "</apm:PANID>" +
                                "<apm:SMSData>" +
                                    "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                                    "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                                "</apm:SMSData>" +
                            "</apm:record>" +
                        "</apm:PINAdvice_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanIdMail(String panId){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                    "<apm:record record_number=\"1\">" +
                        "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                        "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                        "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                        "<apm:PANID>" + panId + "</apm:PANID>" +
                        "<apm:PINMailerData>" +
                            "<apm:MailingCode>2</apm:MailingCode>" +
                            "<apm:TokenholderName>" +
                                "<apm:Title>Mr</apm:Title>" +
                                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                                "<apm:LastName>ByPANIDMail</apm:LastName>" +
                                "</apm:TokenholderName>" +
                            "<apm:TokenholderAddress>" +
                                "<apm:AddressLine1>Pin Advice By PAN ID - Mail</apm:AddressLine1>" +
                                "<apm:Town>PAN ID:" + panId + "</apm:Town>" +
                                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                                "<apm:CountryCode>826</apm:CountryCode>" +
                            "</apm:TokenholderAddress>" +
                        "</apm:PINMailerData>" +
                    "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanAliasSMS(String issuerPanAlias){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                                "<apm:IssuerPANAlias>" + issuerPanAlias + "</apm:IssuerPANAlias>" +
                                "<apm:SMSData>" +
                                    "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                                    "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                                "</apm:SMSData>" +
                            "</apm:record>" +
                        "</apm:PINAdvice_request>" +
                    "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanAliasMail(String issuerPanAlias){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:IssuerPANAlias>" + issuerPanAlias + "</apm:IssuerPANAlias>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>2</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                "<apm:LastName>ByPANAliasMail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>Pin Advice By PAN Alias - Mail</apm:AddressLine1>" +
                "<apm:Town>PAN Alias:" + issuerPanAlias + "</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanSeqNumExpDateSMS(String panClear, String panSeqNum, String panExpDate){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PAN EncryptedFlag=\"N\">" + panClear + "</apm:PAN>" +
                "<apm:PANSeqNumber>" + panSeqNum + "</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + panExpDate + "</apm:PANExpiryDate>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanSeqNumExpDateMail(String panClear, String panSeqNum, String panExpDate){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PAN EncryptedFlag=\"N\">" + panClear + "</apm:PAN>" +
                "<apm:PANSeqNumber>" + panSeqNum + "</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + panExpDate + "</apm:PANExpiryDate>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>2</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                "<apm:LastName>ByPanSeqNumExpDate</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>By Pan SeqNum ExpDate- Mail</apm:AddressLine1>" +
                "<apm:Town>PAN:" + panClear + "</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanIdMailHousekeeper(String panId){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PANID>" + panId + "</apm:PANID>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>2</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>ByPANIDMail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>Pin Advice By PAN ID - Mail</apm:AddressLine1>" +
                "<apm:Town>PAN ID:" + panId + "</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanAliasMailHousekeeper(String issuerPanAlias){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:IssuerPANAlias>" + issuerPanAlias + "</apm:IssuerPANAlias>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>2</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>ByPANAliasMail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>Pin Advice By PAN Alias - Mail</apm:AddressLine1>" +
                "<apm:Town>PAN Alias:" + issuerPanAlias + "</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(String panClear, String panSeqNum, String panExpDate){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:PINAdvice_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINAdviceForAllTokenApplicationsFlag>N</apm:PINAdviceForAllTokenApplicationsFlag>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PAN EncryptedFlag=\"N\">" + panClear + "</apm:PAN>" +
                "<apm:PANSeqNumber>" + panSeqNum + "</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + panExpDate + "</apm:PANExpiryDate>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>2</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>PINAdvice</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>ByPanSeqNumExpDate</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>By Pan SeqNum ExpDate- Mail</apm:AddressLine1>" +
                "<apm:Town>PAN:" + panClear + "</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:record>" +
                "</apm:PINAdvice_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }


}