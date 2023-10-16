package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.records.DataLoadPinRecord;
import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinExport
{

    public static String dataloadPinExportByPanId() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:PINExport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                    "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                                    "<apm:PINFlag>Y</apm:PINFlag>" +
                                    "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                    "<apm:PUKFlag>N</apm:PUKFlag>" +
                                    "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                                "</apm:record>" +
                            "</apm:PINExport_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadPinExportByPanSeqNoExpiryDate() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINExport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PAN EncryptedFlag=\"N\">" + record.getPanClear() + "</apm:PAN>" +
                                "<apm:PANSeqNumber>" +  record.getAppSequenceNumber() + "</apm:PANSeqNumber>" +
                                "<apm:PANExpiryDate>" +  record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                                "<apm:PINFlag>Y</apm:PINFlag>" +
                                "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                "<apm:PUKFlag>N</apm:PUKFlag>" +
                                "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                            "</apm:record>" +
                        "</apm:PINExport_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);
    }

    public static String dataloadPinExportByPanAlias() throws Exception {

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetPinRecordForVerify();

        String xml ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINExport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:IssuerPANAlias>" +  record.getPanAlias() + "</apm:IssuerPANAlias>" +
                                "<apm:PINFlag>Y</apm:PINFlag>" +
                                "<apm:PINPVVFlag>Y</apm:PINPVVFlag>" +
                                "<apm:PUKFlag>N</apm:PUKFlag>" +
                                "<apm:PUKPVVFlag>N</apm:PUKPVVFlag>" +
                            "</apm:record>" +
                        "</apm:PINExport_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return (xml);

    }

}