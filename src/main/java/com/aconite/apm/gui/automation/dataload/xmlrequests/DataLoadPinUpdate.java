package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.records.DataLoadPinRecord;
import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinUpdate
{

    public static String dataloadPinUpdateByPanId() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:PINUpdate_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                    "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                                    "<apm:PIN>" + DataLoadDataGatherer.getEncryptedPin() + "</apm:PIN>" +
                                    "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                    "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                                "</apm:record>" +
                            "</apm:PINUpdate_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadPinUpdateByPanSeqNoExpiryDate() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINUpdate_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PAN>" +
                                "<apm:PANSeqNumber>" +  record.getAppSequenceNumber() + "</apm:PANSeqNumber>" +
                                "<apm:PANExpiryDate>" +  record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                                "<apm:PIN>" + DataLoadDataGatherer.getEncryptedPin() + "</apm:PIN>" +
                                "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                            "</apm:record>" +
                        "</apm:PINUpdate_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadPinUpdateByPanAlias() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINUpdate_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:IssuerPANAlias>" +  record.getPanAlias() + "</apm:IssuerPANAlias>" +
                                "<apm:PIN>" + DataLoadDataGatherer.getEncryptedPin() + "</apm:PIN>" +
                                "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                            "</apm:record>" +
                        "</apm:PINUpdate_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

}