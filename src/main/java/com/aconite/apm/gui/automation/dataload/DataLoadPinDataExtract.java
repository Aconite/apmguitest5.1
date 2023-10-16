package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadPinDataExtract
 * This will call all the functions to put enough data in for a pin_data_extract test
 */

import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.dataload.xmlrequests.*;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadPinDataExtract
{
    public static String runDataLoadPinDataExtract() throws Exception {

        StringBuilder out = new StringBuilder();
        String res = "";
        String xmlrsp;
        String pinId;
        String pinEncrypted;
        String pinKeyIndex;
        String pinVerificationValue;
        String pinPvvKeyIndex;
        String pvvKeyIndex;
        String panId;
        String panClear;
        String panSeqNum;
        String panExpDate;
        String issuerPanAlias;
        String encryptedPinBlock;

        HashMap<Integer, HashMap<String, String>> responseData;

        /*
         * Pin Import
         */
        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinId = responseData.get(i).get("PINID");
                res = "TRX_TYPE_ID 1 - PIN IMPORT SINGLE: PINID=" + pinId;
            }
            else{
                System.out.println("TRX_TYPE_ID 1 - PIN IMPORT SINGLE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportMultiple());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinId = responseData.get(i).get("PINID");
                res = "TRX_TYPE_ID 1 - PIN IMPORT MULTIPLE: PINID=" + pinId;
            }
            else{
                System.out.println("TRX_TYPE_ID 1 - PIN IMPORT MULTIPLE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";
        pinId = "";

        /*
         * Pin Verify
         */
        xmlrsp = WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanId());
        System.out.println("Response Output: " + xmlrsp);
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN ID: PASS");
            }
            else{
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanSeqNoExpiryDate());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN - PAN SEQ NUM - PAN EXP DATE: PASS");
            }
            else{
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN - PAN SEQ NUM - PAN EXP DATE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN ALIAS: PASS");
            }
            else{
                System.out.println("TRX_TYPE_ID 2 - PIN VERIFY BY PAN ALIAS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
        }

        /*
         * Pin Delete
         */
        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinId = responseData.get(i).get("PINID");
                res = "TRX_TYPE_ID 1 - PIN IMPORT SINGLE: PINID=" + pinId;
            }
            else{
                System.out.println("TRX_TYPE_ID 1 - PIN IMPORT SINGLE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinDelete.dataloadPinDeleteByPinId(pinId));
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 3 - PIN DELETE BY PIN ID: PASS");
            }
            else{
                System.out.println("TRX_TYPE_ID 3 - PIN DELETE BY PIN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
        }
        pinId = "";

        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinId = responseData.get(i).get("PINID");
                res = "TRX_TYPE_ID 1 - PIN IMPORT SINGLE: PINID=" + pinId;
            }
            else{
                System.out.println("TRX_TYPE_ID 1 - PIN IMPORT SINGLE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        String issuerPinId = DataLoadDataGatherer.dataloadGetIssuerPinAliasByPinId(pinId);
        System.out.println(issuerPinId);

        xmlrsp = WebRequests.dataload(DataLoadPinDelete.dataloadPinDeleteByIssuerPinId(issuerPinId));
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 3 - PIN DELETE BY ISSUER PIN ID: PASS");
            }
            else{
                System.out.println("TRX_TYPE_ID 3 - PIN DELETE BY ISSUER PIN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
        }

        /*
         * Pin Export
         */
        xmlrsp = WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinEncrypted = responseData.get(i).get("PIN");
                pinKeyIndex = responseData.get(i).get("PINKeyIndex");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 18 - PIN EXPORT BY PAN ID: PIN=" + pinEncrypted + ", PINKEYINDEX=" + pinKeyIndex +
                        ", PINVERIFICATIONVALUE=" +pinVerificationValue + ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 18 - PIN EXPORT BY PAN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanSeqNoExpiryDate());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinEncrypted = responseData.get(i).get("PIN");
                pinKeyIndex = responseData.get(i).get("PINKeyIndex");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 18 - PIN EXPORT BY PAN - PAN SEQ NUM - PAN EXP DATE: PIN=" + pinEncrypted + ", PINKEYINDEX=" + pinKeyIndex +
                        ", PINVERIFICATIONVALUE=" +pinVerificationValue + ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 18 - PIN EXPORT BY PAN - PAN SEQ NUM - PAN EXP DATE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinEncrypted = responseData.get(i).get("PIN");
                pinKeyIndex = responseData.get(i).get("PINKeyIndex");
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 18 - PIN EXPORT BY PAN ALIAS: PIN=" + pinEncrypted + ", PINKEYINDEX=" + pinKeyIndex +
                        ", PINVERIFICATIONVALUE=" +pinVerificationValue + ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 18 - PIN EXPORT BY PAN ALIAS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * Pin Update
         */
        xmlrsp = WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 21 - PIN UPDATE BY PAN ID: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 21 - PIN UPDATE BY PAN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanSeqNoExpiryDate());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 21 - PIN UPDATE BY PAN - PAN SEQ NUM - PAN EXP DATE: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 21 - PIN UPDATE BY PAN - PAN SEQ NUM - PAN EXP DATE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 21 - PIN UPDATE BY PAN ALIAS: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX=" + pinPvvKeyIndex;
            }
            else{
                System.out.println("TRX_TYPE_ID 21 - PIN UPDATE BY PAN ALIAS FAIL: " + responseData.get(i).get("ErrorDescription"));
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
         * TOWPD
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT1_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT2_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT3_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT4_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
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
                System.out.println("TRX_TYPE_ID 9 - TOWPD_OT6_Mail FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        /*
         * VPP
         */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPAN());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPANId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PAN ID: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PAN ID FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByIssuerPinId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 11 - VPP SET PIN FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
        }

        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                encryptedPinBlock = responseData.get(i).get("EncryptedPinBlock");
                res = "VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                out.append(res);
            } else {
                System.out.println("TRX_TYPE_ID 12 - VPP GET PIN FAIL: " + responseData.get(1).get("ErrorDescription"));
            }
            out.append(res);
        }
        res = "";

        /*
         * Pin Change Rollback
         */
        xmlrsp = WebRequests.dataload(DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanId());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN ID: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX" + pinPvvKeyIndex;
            } else {
                System.out.println("TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanSeqNoExpiryDate());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN - PAN SEQ NUM - PAN EXP DATE: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX" + pinPvvKeyIndex;
            } else {
                System.out.println("TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN - PAN SEQ NUM - PAN EXP DATE FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {

            if (responseData.get(i).get("ResponseCode").equals("1")) {
                pinVerificationValue = responseData.get(i).get("PINVerificationValue");
                pinPvvKeyIndex = responseData.get(i).get("PINPVVKeyIndex");
                res = "TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN ALIAS: PINVERIFICATIONVALUE=" + pinVerificationValue +
                        ", PINPVVKEYINDEX" + pinPvvKeyIndex;
            } else {
                System.out.println("TRX_TYPE_ID 20 - PIN CHANGE ROLLBACK BY PAN ALIAS FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }

        return(out.toString());
    }
}


