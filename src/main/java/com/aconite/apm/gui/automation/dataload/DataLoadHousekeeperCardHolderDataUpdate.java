package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadPinMailer
 * This will call all the functions to put enough data in for a pin_mailer test
 */


import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinAdvice;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import com.aconite.apm.gui.automation.utilities.WebRequests;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataLoadHousekeeperCardHolderDataUpdate
{
    public static String runDataLoadHousekeeperCardHolderDataUpdate() throws Exception {

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
         * TOWPD
         */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail_Housekeeper());
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail_Housekeeper());
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail_Housekeeper());
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail_Housekeeper());
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";


        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail_Housekeeper());
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";


        /*
         * TOWPD OT 1 - Delivery Method 1 - PIN Advice
         */
        /*  TOWPD_OT1_Mail_DM1 - PIN Advice By Pan Id */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMailHousekeeper(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT1_Mail_DM1 - PIN Advice By Pan Alias*/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /* PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMailHousekeeper(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";


        /*  TOWPD_OT1_Mail_DM1 - PIN Advice By Pan */
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail_DM1_Housekeeper());
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

                out.append(res);

                /*  PIN Advice */
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*
         * TOWPD OT 2 - Delivery Method 1 - PIN Advice
         *****************************************************************/

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /* PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMailHousekeeper(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT2_Mail_DM1 - PIN Advice By Pan Alias **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";


                /* PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMailHousekeeper(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";


        /*  TOWPD_OT2_Mail_DM1 - PIN Advice By Pan **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail_DM1_Housekeeper());
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
                out.append(res);
                res = "";


                /*   PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*
         * TOWPD OT 3 - Delivery Method 1 - PIN Advice
         *****************************************************************/

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMailHousekeeper(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT3_Mail_DM1 - PIN Advice By Pan Alias **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";


                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMailHousekeeper(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";


        /*  TOWPD_OT3_Mail_DM1 - PIN Advice By Pan **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";


                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*
         * TOWPD OT 4 - Delivery Method 1 - PIN Advice
         *****************************************************************/

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMailHousekeeper(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT4_Mail_DM1 - PIN Advice By Pan Alias **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail_DM1_Housekeeper());
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
                out.append(res);
                res = "";


                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMailHousekeeper(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /* TOWPD_OT4_Mail_DM1 - PIN Advice By Pan **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*
         * TOWPD OT 6 - Delivery Method 1 - PIN Advice
         *****************************************************************/

        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";


                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMailHousekeeper(panId));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN ID FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT6_Mail_DM1 - PIN Advice By Pan Alias **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMailHousekeeper(issuerPanAlias));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY ISSUER PAN ALIAS FAIL: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }
        res = "";

        /*  TOWPD_OT6_Mail_DM1 - PIN Advice By Pan **********/
        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail_DM1_Housekeeper());
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

                out.append(res);
                res = "";

                /*  PIN Advice ***/
                xmlrsp = WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMailHousekeeper(panClear, panSeqNum, panExpDate));
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ){

                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        res = "TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS";
                    }
                    else{
                        System.out.println("TRX_TYPE_ID 5 - PIN ADVICE BY PAN - PAN SEQ NUM - PAN EXP DATE: " + responseData.get(j).get("ErrorDescription"));
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_Mail_DM1 FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);
        }

        updateSystemDateTime();

        return(out.toString());

    }

    private static void updateSystemDateTime() throws Exception{


        String updateSystemDateTimeSQL = "UPDATE PM_D_TRX_LOG SET " +
                                        "SYSTEM_DATETIME = to_timestamp((select CURRENT_TIMESTAMP from dual) - 8), " +
                                        "REQ_DATETIME = to_timestamp((select CURRENT_TIMESTAMP from dual) - 8), " +
                                        "RSP_DATETIME = to_timestamp((select CURRENT_TIMESTAMP from dual) - 8)" +
                                        "WHERE REQ_TH_MIDDLE_NAME = 'cardHolderDataUpdate'";

        Connection connection;
        connection = DatabaseConnection.getConnection();

        PreparedStatement preparedSelect = connection.prepareStatement(updateSystemDateTimeSQL);
        ResultSet rs = preparedSelect.executeQuery();

        connection.close();

    }
}


