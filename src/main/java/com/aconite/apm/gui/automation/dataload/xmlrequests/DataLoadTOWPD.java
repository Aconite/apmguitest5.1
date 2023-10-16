package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.records.DataLoadPinRecord;

public class DataLoadTOWPD{

    public static String dataloadTOWPD_OT1_SMS(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
        "<soapenv:Header/>" +
        "<soapenv:Body>" +
        "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
        "<apm:record record_number=\"1\">" +
        "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
        "<apm:OrderType>1</apm:OrderType>" +
        "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
        "<apm:TokenApplication SequenceNumber=\"1\">" +
        "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
        "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
        "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
        "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
        "<apm:PINDeliveryData>" +
        "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
        "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
        "<apm:SMSData>" +
        "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
        "<apm:LanguageCode>ENG</apm:LanguageCode>" +
        "</apm:SMSData>" +
        "</apm:PINDeliveryData>" +
        "</apm:TokenApplication>" +
        "</apm:record>" +
        "</apm:TokenOrderWithPINDelivery_request>" +
        "</soapenv:Body>" +
        "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT1_Mail(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                    "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                        "<apm:record record_number=\"1\">" +
                        "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                        "<apm:OrderType>1</apm:OrderType>" +
                        "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                        "<apm:TokenApplication SequenceNumber=\"1\">" +
                            "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                            "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                            "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                            "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                            "<apm:PINDeliveryData>" +
                                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                                "<apm:PINMailerData>" +
                                    "<apm:MailingCode>1</apm:MailingCode>" +
                                    "<apm:TokenholderName>" +
                                        "<apm:Title>Mr</apm:Title>" +
                                        "<apm:FirstName>dataloadTOWPD_OT1_Mail</apm:FirstName>" +
                                        "<apm:LastName>dataloadTOWPD_OT1_Mail</apm:LastName>" +
                                    "</apm:TokenholderName>" +
                                    "<apm:TokenholderAddress>" +
                                        "<apm:AddressLine1>dataloadTOWPD_OT1_Mail</apm:AddressLine1>" +
                                        "<apm:Town>Camberwick Green</apm:Town>" +
                                        "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                                        "<apm:CountryCode>826</apm:CountryCode>" +
                                    "</apm:TokenholderAddress>" +
                                "</apm:PINMailerData>" +
                            "</apm:PINDeliveryData>" +
                        "</apm:TokenApplication>" +
                        "</apm:record>" +
                    "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT1_Web(){

        String panAlias = DataLoadDataGatherer.getIdentifier(18);

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>1</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + panAlias + "</apm:IssuerPANAlias>" +
//                "<apm:IssuerPINID>" + panAlias + "</apm:IssuerPINID>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>5</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:WebData>" +
                "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(10) + "</apm:CustomerCode>" +
                "</apm:WebData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT1_SMS_DM1(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>1</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT1_Mail_DM1(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>1</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT1_Mail_DM1</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT1_Mail_DM1</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT1_Mail_DM1</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT2_SMS() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
	    		"<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
			    "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
			    "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT2_Mail() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT2_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT2_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT2_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT2_Web() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>5</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:WebData>" +
                "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:CustomerCode>" +
                "</apm:WebData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT2_SMS_DM1() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT2_Mail_DM1() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT2_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT2_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT2_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_SMS() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_Mail() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT3_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT3_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT3_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_Web() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>5</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:WebData>" +
                "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:CustomerCode>" +
                "</apm:WebData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_SMS_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_Mail_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT3_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT3_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT3_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_SMS() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_Mail() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT4_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT4_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT4_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_Web() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>5</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:WebData>" +
                "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(10) + "</apm:CustomerCode>" +
                "</apm:WebData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_SMS_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_Mail_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT4_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT4_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT4_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_SMS() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>3</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_Mail() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT6_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT6_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT6_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_Web() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>5</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:WebData>" +
                "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(10) + "</apm:CustomerCode>" +
                "</apm:WebData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_SMS_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:SMSData>" +
                "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                "</apm:SMSData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_Mail_DM1() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT6_Mail</apm:FirstName>" +
                "<apm:LastName>dataloadTOWPD_OT6_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT6_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    /*****************************************************************
     * Requests for cardHolderDataUpdate
     *****************************************************************/
    public static String dataloadTOWPD_OT1_Mail_Housekeeper(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>1</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT1_Mail</apm:FirstName>" +
                "<apm:FirstName>dataloadTOWPD_OT1_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT1_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT1_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT2_Mail_Housekeeper() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT2_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT2_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT2_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_Mail_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT3_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT3_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT3_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_Mail_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT4_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT4_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT4_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_Mail_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>2</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT6_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT6_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT6_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT1_Mail_DM1_Housekeeper(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>1</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT1_Mail_DM1</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT1_Mail_DM1</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT1_Mail_DM1</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTOWPD_OT2_Mail_DM1_Housekeeper() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>2</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT2_Mail_DM1</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT2_Mail_DM1</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT2_Mail_DM1</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT3_Mail_DM1_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>3</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT3_Mail_DM1</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT3_Mail_DM1</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT3_Mail_DM1</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT4_Mail_DM1_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>4</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT4_Mail_DM1</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT4_Mail_DM1</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT4_Mail_DM1</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PINID>" + record.getPinId() + "</apm:PINID>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD_OT6_Mail_DM1_Housekeeper() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                "<apm:OrderType>6</apm:OrderType>" +
                "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                "<apm:TokenApplication SequenceNumber=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>1</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "<apm:PINMailerData>" +
                "<apm:MailingCode>1</apm:MailingCode>" +
                "<apm:TokenholderName>" +
                "<apm:Title>Mr</apm:Title>" +
                "<apm:FirstName>dataloadTOWPD_OT6_Mail</apm:FirstName>" +
                "<apm:MiddleName>cardHolderDataUpdate</apm:MiddleName>" +
                "<apm:LastName>dataloadTOWPD_OT6_Mail</apm:LastName>" +
                "</apm:TokenholderName>" +
                "<apm:TokenholderAddress>" +
                "<apm:AddressLine1>dataloadTOWPD_OT6_Mail</apm:AddressLine1>" +
                "<apm:Town>Camberwick Green</apm:Town>" +
                "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                "<apm:CountryCode>826</apm:CountryCode>" +
                "</apm:TokenholderAddress>" +
                "</apm:PINMailerData>" +
                "</apm:PINDeliveryData>" +
                "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>" +
                "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadTOWPD(String orderType, String deliveryMethodInt, String deliveryMethodString, String requestPurpose) throws Exception{

//        deliveryMethodInt = number to put in
//        deliveryMethodString = Delivery data block to include

        String headerXml;
        String orderTypeXml;
        String appSeqXml;
        String panDetailsXml;
        String expDateXml;
        String pinDelMethodXml;
        String pinOutXml="";
        String copyFromXml="";
        String endXml;

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

//        Assumes a single record for each request
//        TODO: create function for multiple records
        headerXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TokenOrderWithPINDelivery_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>";

        orderTypeXml = "<apm:OrderType>" + orderType + "</apm:OrderType>";

        appSeqXml = "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                            "<apm:TokenApplication SequenceNumber=\"1\">";

        if(orderType.equals("2")){
            panDetailsXml = "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                    "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                    "<apm:PANSeqNumber>1</apm:PANSeqNumber>";

        }
        else{
            panDetailsXml = "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                    "<apm:PANSeqNumber>1</apm:PANSeqNumber>" +
                    "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>";
        }

        if(requestPurpose.equalsIgnoreCase("TOKENCLEANUP")) {
            expDateXml = "<apm:PANExpiryDate>" + DataLoadDataGatherer.createExpiredExpiryDate(6,12) + "</apm:PANExpiryDate>";
        }
        else{
            expDateXml = "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>";
        }

        pinDelMethodXml = "<apm:PINDeliveryData>" +
                "<apm:PINDeliveryMethod>" + deliveryMethodInt + "</apm:PINDeliveryMethod>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>";

        System.out.println("Delivery Method String: " + deliveryMethodString);
        if(deliveryMethodString.equalsIgnoreCase("MAIL")){

            pinOutXml = "<apm:PINMailerData>" +
                    "<apm:MailingCode>1</apm:MailingCode>" +
                    "<apm:TokenholderName>" +
                    "<apm:Title>Mr</apm:Title>" +
                    "<apm:FirstName>dataloadTOWPD_OT" + deliveryMethodInt + "_" + deliveryMethodString + "</apm:FirstName>" +
                    "<apm:MiddleName>dataloadTOWPD_OT" + requestPurpose + "</apm:MiddleName>" +
                    "<apm:LastName>dataloadTOWPD_OT" + deliveryMethodInt + "_" + deliveryMethodString + "</apm:LastName>" +
                    "</apm:TokenholderName>" +
                    "<apm:TokenholderAddress>" +
                    "<apm:AddressLine1>dataloadTOWPD_OT" + deliveryMethodInt + "_" + deliveryMethodString + "</apm:AddressLine1>" +
                    "<apm:Town>Camberwick Green</apm:Town>" +
                    "<apm:PostCode>NE45 8GB</apm:PostCode>" +
                    "<apm:CountryCode>826</apm:CountryCode>" +
                    "</apm:TokenholderAddress>" +
                    "</apm:PINMailerData>" +
                    "</apm:PINDeliveryData>";

        }

        if(deliveryMethodString.equalsIgnoreCase("SMS")){

            pinOutXml = "<apm:SMSData>" +
                    "<apm:MobilePhoneNumber>070" + DataLoadDataGatherer.getNewPin(8) + "</apm:MobilePhoneNumber>" +
                    "<apm:LanguageCode>ENG</apm:LanguageCode>" +
                    "</apm:SMSData>" +
                    "</apm:PINDeliveryData>";
        }

        if(deliveryMethodString.equalsIgnoreCase("WEB")) {

            pinOutXml = "<apm:WebData>" +
                    "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(10) + "</apm:CustomerCode>" +
                    "</apm:WebData>" +
                    "</apm:PINDeliveryData>";

        }

        System.out.println("Order Type: " + orderType);

        if(orderType.equals("1") || orderType.equals("2")) {
            copyFromXml = "";
        }

        if(orderType.equals("3")){
            copyFromXml = "<apm:PreviousPAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PreviousPAN>" +
                            "<apm:PreviousPANSequenceNumber>" + record.getAppSequenceNumber() + "</apm:PreviousPANSequenceNumber>" +
                            "<apm:PreviousPANExpirydate>" + record.getPanExpiryDate() + "</apm:PreviousPANExpirydate>";
        }

        if(orderType.equals("4")){
            copyFromXml = "<apm:PINID>" + record.getPinId() + "</apm:PINID>";
        }

        if(orderType.equals("6")){
            copyFromXml = "<apm:PreviousIssuerPANAlias>" + record.getPanAlias() + "</apm:PreviousIssuerPANAlias>";
        }

        endXml = "</apm:TokenApplication>" +
                "</apm:record>" +
                "</apm:TokenOrderWithPINDelivery_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        String xml = headerXml + orderTypeXml + appSeqXml + panDetailsXml + expDateXml + pinDelMethodXml + pinOutXml + copyFromXml + endXml;
        System.out.println(xml);
        return(xml);
    }

}