package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.records.DataLoadPinRecord;

public class DataLoadTranslate{

    public static String dataloadTranslatePanId() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:TranslatePANID_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                        "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                                "</apm:record>" +
                            "</apm:TranslatePANID_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTranslatePan() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TranslatePAN_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" +  record.getPanClear() + "</apm:PAN>" +
                "<apm:PANSeqNumber>" + record.getAppSequenceNumber() +"</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                "</apm:record>" +
                "</apm:TranslatePAN_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadTranslatePanAlias() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:TranslatePANAlias_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerPANAlias>" + record.getPanAlias() + "</apm:IssuerPANAlias>" +
                "</apm:record>" +
                "</apm:TranslatePANAlias_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }
}