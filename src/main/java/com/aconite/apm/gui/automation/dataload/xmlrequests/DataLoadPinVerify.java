package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.records.DataLoadPinRecord;
import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinVerify
{

    public static String dataloadPinVerifyByPanId() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();
        System.out.println("Checking: " + record);

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:PINVerify_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                    "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                                    "<apm:PIN>" + record.getPinTranslated() + "</apm:PIN>" +
                                "</apm:record>" +
                            "</apm:PINVerify_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        System.out.println(xml);

        return(xml);
    }

    public static String dataloadPinVerifyByPanSeqNoExpiryDate() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINVerify_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PAN>" +
                                "<apm:PANSeqNumber>" +  record.getAppSequenceNumber() + "</apm:PANSeqNumber>" +
                                "<apm:PANExpiryDate>" +  record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                                "<apm:PIN>" +  record.getPinTranslated() + "</apm:PIN>" +
                            "</apm:record>" +
                        "</apm:PINVerify_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadPinVerifyByPanAlias() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINVerify_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:IssuerPANAlias>" +  record.getPanAlias() + "</apm:IssuerPANAlias>" +
                                "<apm:PIN>" +  record.getPinTranslated() + "</apm:PIN>" +
                            "</apm:record>" +
                        "</apm:PINVerify_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

}