package com.aconite.apm.gui.automation.dataload;

/*
 DataLoadPinSmsDataExtract
 This will call all the functions to put enough data in for a pinsmsdataextract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinAdvice;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadPinSmsDataExtract
{
    public static String runDataLoadPinSmsDataExtract() throws Exception {

        StringBuilder out = new StringBuilder();
        String res = "";
        String xmlrsp;
        String pinEncrypted;
        String pinVerificationValue;
        String pvvKeyIndex;
        String panId;
        String panClear;
        String panSeqNum;
        String panExpDate;
        String issuerPanAlias;


        HashMap<Integer, HashMap<String, String>> responseData;

        /*
         * TOWPD - SMS
         */
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_SMS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * TOWPD OT 1 - Delivery Method 1 - PIN Advice
         */
        /* TOWPD_OT1_SMS_DM1 - PIN Advice By Pan Id */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT1_SMS_DM1 - PIN Advice By Pan Alias */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";


        /* TOWPD_OT1_SMS_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * TOWPD OT 2 - Delivery Method 1 - PIN Advice
         */

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT2_SMS_DM1 - PIN Advice By Pan Alias */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS_DM1());
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


                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT2_SMS_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * TOWPD OT 3 - Delivery Method 1 - PIN Advice
         */

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT3_SMS_DM1 - PIN Advice By Pan Alias */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT3_SMS_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * TOWPD OT 4 - Delivery Method 1 - PIN Advice
         */

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT4_SMS_DM1 - PIN Advice By Pan Alias */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT4_SMS_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * TOWPD OT 6 - Delivery Method 1 - PIN Advice
         */

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";


        /* TOWPD_OT6_SMS_DM1 - PIN Advice By Pan Alias */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /* TOWPD_OT6_SMS_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS_DM1());
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

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_SMS_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }

        return(out.toString());

    }
}


