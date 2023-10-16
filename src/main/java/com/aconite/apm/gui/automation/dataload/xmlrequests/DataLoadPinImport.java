package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinImport
{

    public static String dataloadPinImportSingle(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINImport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:IssuerPINID>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPINID>" +
                                "<apm:PIN>0D899B5EF21237AB</apm:PIN>" +
                            "</apm:record>" +
                        "</apm:PINImport_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinImportSingleExpired(){

        String xml =    "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                            "<soapenv:Header/>" +
                            "<soapenv:Body>" +
                                "<apm:PINImport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                    "<apm:record record_number=\"1\">" +
                                        "<apm:IssuerPINID>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPINID>" +
                                        "<apm:PIN>0D899B5EF21237AB</apm:PIN>" +
                                        "<apm:PINExpiryDate>2020-12-01</apm:PINExpiryDate>" +
                                    "</apm:record>" +
                                "</apm:PINImport_request>" +
                            "</soapenv:Body>" +
                        "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinImportMultiple(){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                    "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINImport_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                "<apm:IssuerPINID>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPINID>" +
                                "<apm:PIN>0D899B5EF21237AB</apm:PIN>" +
                            "</apm:record>" +
                            "<apm:record record_number=\"2\">" +
                                "<apm:IssuerPINID>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPINID>" +
                                "<apm:PIN>0D899B5EF21237AB</apm:PIN>" +
                            "</apm:record>" +
                            "<apm:record record_number=\"3\">" +
                                "<apm:IssuerPINID>" + DataLoadDataGatherer.getIdentifier(18) + "</apm:IssuerPINID>" +
                                "<apm:PIN>0D899B5EF21237AB</apm:PIN>" +
                            "</apm:record>" +
                        "</apm:PINImport_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

}