package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.records.DataLoadPinRecord;

public class DataLoadVPP{

    public static String dataloadSetVPPPINIdByPAN() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPAN_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PAN>" +
                "<apm:PANSequenceNumber>" +  record.getAppSequenceNumber() + "</apm:PANSequenceNumber>" +
                "<apm:PANExpiryDate>" +  record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:UniquenessFlag>N</apm:UniquenessFlag>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "</apm:SetVPPPINIdByPAN_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

//        System.out.println(xml);
        return(xml);

    }

    public static String dataloadSetVPPPINIdByPANId() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPANID_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "</apm:SetVPPPINIdByPANID_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadSetVPPPINIdByIssuerPinId() throws Exception {

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByIssuerPINId_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:IssuerPINId>" + DataLoadDataGatherer.dataloadGetRandomIssuerPinId() + "</apm:IssuerPINId>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "</apm:SetVPPPINIdByIssuerPINId_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadSetVPPPINIdByPanAlias() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPANAlias_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:IssuerPANAlias>" + record.getPanAlias() + "</apm:IssuerPANAlias>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "</apm:SetVPPPINIdByPANAlias_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadVPPSetPIN() throws Exception {

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:VPPSetPIN_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.dataloadGetRandomVPPPinId() + "</apm:VPPPINId>" +
                "<apm:PIN>" + DataLoadDataGatherer.getVPPPinBlock() + "</apm:PIN>" +
                "</apm:VPPSetPIN_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadVPPGetPIN() throws Exception {

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:VPPGetPIN_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.dataloadGetRandomVPPPinId() + "</apm:VPPPINId>" +
                "</apm:VPPGetPIN_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadSetExpiredVPPPINIdByPAN() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPAN_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:PAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PAN>" +
                "<apm:PANSequenceNumber>" +  record.getAppSequenceNumber() + "</apm:PANSequenceNumber>" +
                "<apm:PANExpiryDate>" +  record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:UniquenessFlag>N</apm:UniquenessFlag>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "<apm:VPPPINIdExpiryTime>1640995199</apm:VPPPINIdExpiryTime>" +
                "</apm:SetVPPPINIdByPAN_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

//        System.out.println(xml);
        return(xml);

    }

    public static String dataloadSetExpiredVPPPINIdByPANId() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPANID_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "<apm:VPPPINIdExpiryTime>1640995199</apm:VPPPINIdExpiryTime>" +
                "</apm:SetVPPPINIdByPANID_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadSetExpiredVPPPINIdByIssuerPinId() throws Exception {

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByIssuerPINId_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:IssuerPINId>" + DataLoadDataGatherer.dataloadGetRandomIssuerPinId() + "</apm:IssuerPINId>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "<apm:VPPPINIdExpiryTime>1640995199</apm:VPPPINIdExpiryTime>" +
                "</apm:SetVPPPINIdByIssuerPINId_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

    public static String dataloadSetExpiredVPPPINIdByPanAlias() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:SetVPPPINIdByPANAlias_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:IssuerPANAlias>" + record.getPanAlias() + "</apm:IssuerPANAlias>" +
                "<apm:VPPPINId>" + DataLoadDataGatherer.getIdentifier(15) + "</apm:VPPPINId>" +
                "<apm:VPPPINIdExpiryTime>1640995199</apm:VPPPINIdExpiryTime>" +
                "</apm:SetVPPPINIdByPANAlias_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }


}