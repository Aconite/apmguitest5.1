package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.records.DataLoadPinRecord;

public class DataLoadPinChangeRollback{

    public static String dataloadPinChangeRollbackByPanId() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetUpdatedPins();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:RollbackPINChange_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                        "<apm:PANID>" + record.getTokenId() + "</apm:PANID>" +
                                        "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                                "</apm:record>" +
                            "</apm:RollbackPINChange_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinChangeRollbackByPanSeqNoExpiryDate() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetUpdatedPins();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:RollbackPINChange_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:PAN EncryptedFlag=\"N\">" +  record.getPanClear() + "</apm:PAN>" +
                "<apm:PANSeqNumber>" + record.getAppSequenceNumber() +"</apm:PANSeqNumber>" +
                "<apm:PANExpiryDate>" + record.getPanExpiryDate() + "</apm:PANExpiryDate>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "</apm:record>" +
                "</apm:RollbackPINChange_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinChangeRollbackByPanAlias() throws Exception{

        DataLoadPinRecord record = DataLoadDataGatherer.dataloadGetUpdatedPins();

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                "<apm:RollbackPINChange_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                "<apm:record record_number=\"1\">" +
                "<apm:IssuerPANAlias>" + record.getPanAlias() + "</apm:IssuerPANAlias>" +
                "<apm:PINPUKFlag>1</apm:PINPUKFlag>" +
                "</apm:record>" +
                "</apm:RollbackPINChange_request>" +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }
}