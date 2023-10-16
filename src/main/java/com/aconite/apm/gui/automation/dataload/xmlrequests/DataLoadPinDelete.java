package com.aconite.apm.gui.automation.dataload.xmlrequests;

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;

public class DataLoadPinDelete
{

    public static String dataloadPinDeleteByPinId(String pinId){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                "<soapenv:Header/>" +
                    "<soapenv:Body>" +
                        "<apm:PINDelete_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                            "<apm:record record_number=\"1\">" +
                                "<apm:PINID>" + pinId + "</apm:PINID>" +
                            "</apm:record>" +
                        "</apm:PINDelete_request>" +
                    "</soapenv:Body>" +
                "</soapenv:Envelope>";

        return(xml);

    }

    public static String dataloadPinDeleteByIssuerPinId(String issuerPinId){

        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:apm=\"http://www.aconite.net/schema/apm\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                            "<apm:PINDelete_request RequestDateTime=\"" + DataLoadDataGatherer.getDateTime() + "\" RequestID=\"" + DataLoadDataGatherer.getIdentifier(10) + "\">" +
                                "<apm:record record_number=\"1\">" +
                                    "<apm:IssuerPINID>" + issuerPinId + "</apm:IssuerPINID>" +
                                "</apm:record>" +
                            "</apm:PINDelete_request>" +
                        "</soapenv:Body>" +
                    "</soapenv:Envelope>";
        System.out.println(xml);
        return(xml);

    }


}