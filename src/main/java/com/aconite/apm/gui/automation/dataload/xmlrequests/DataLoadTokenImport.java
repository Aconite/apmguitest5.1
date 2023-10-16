package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadTokenImport{

    public static String dataloadTokenImport(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:TokenImport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                    "<apm:OverwriteFlag>N</apm:OverwriteFlag>" +
                                    "<apm:IssuerTokenProductCode>ABCC</apm:IssuerTokenProductCode>" +
                                    "<apm:FeedbackRequiredFlag>Y</apm:FeedbackRequiredFlag>" +
                                    "<apm:TokenApplication SequenceNumber=\"1\">" +
                                        "<apm:PAN EncryptedFlag=\"N\">" + DataLoadDataGatherer.getPan() + "</apm:PAN>" +
                                        "<apm:IssuerPANAlias>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPANAlias>" +
                                        "<apm:PANSequenceNumber>1</apm:PANSequenceNumber>" +
                                        "<apm:PANExpiryDate>" + DataLoadDataGatherer.createNewExpiryDate() + "</apm:PANExpiryDate>" +
                                        "<apm:ApplicationStatus>1</apm:ApplicationStatus>" +
                                    "</apm:TokenApplication>" +
                                    "<apm:CustomerCode>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:CustomerCode>" +
                                "</apm:record>" +
                            "</apm:TokenImport_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";

        return(xml);

    }
}