package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadTokenApplicationDataExtract
 * This will call all the functions to put enough data in for a TokenApplicationDataExtract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTokenImport;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadTokenApplicationDataExtract
{
    public static String runDataLoadTokenApplicationDataExtract() throws Exception {

        StringBuilder out = new StringBuilder();
        String res="";
        String xmlrsp;
        String pinEncrypted;
        String pinVerificationValue;
        String pvvKeyIndex;
        String panId;
        String panClear;
        String panSeqNum;
        String panExpDate;
        String issuerPanAlias;

        HashMap<Integer, HashMap<String, String>> responseData ;

        /*
         * TOWPD - Mail
         */
        /* TOWPD_OT1_Mail */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT1_Mail: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT1_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");
        }
        res = "";

        /* TOWPD_OT2_Mail */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT2_Mail: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT2_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT3_Mail */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT3_Mail: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT3_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT4_Mail */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT4_Mail: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT4_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT6_Mail */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT6_Mail: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT6_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * Token Import
         */
        xmlrsp = WebRequests.dataload(DataLoadTokenImport.dataloadTokenImport());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){

            if(responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");

                res = "TRX_TYPE_ID 7 - TOKEN IMPORT: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" +
                        panSeqNum + ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias;
            }
            else{
                System.out.println("TRX_TYPE_ID 7 - TOKEN IMPORT FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");
        }
        res = "";

        /*
         * TOWPD - SMS
         */
        /* TOWPD_OT1_SMS */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT1_SMS: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT1_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT2_SMS */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT2_SMS: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT2_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT3_SMS */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT3_SMS: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT3_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT4_SMS */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT4_SMS: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT4_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT6_SMS */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++ ) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                issuerPanAlias = responseData.get(i).get("IssuerPANAlias");
                pinEncrypted = responseData.get(i).get("PIN");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pvvKeyIndex = responseData.get(i).get("PVVKeyIndex");

                res = "TRX_TYPE_ID 9 - TOWPD_OT6_SMS: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PVVKEYINDEX=" + pvvKeyIndex;

            } else {
                System.out.println("TOWPD_OT6_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }

        return(out.toString());

    }


}


