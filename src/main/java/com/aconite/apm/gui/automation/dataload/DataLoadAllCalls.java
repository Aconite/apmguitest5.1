package com.aconite.apm.gui.automation.dataload;



import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinImport;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinVerify;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinDelete;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinExport;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinUpdate;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinAdvice;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTokenImport;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadVPP;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTokenDelete;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTranslate;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinChangeRollback;
import com.aconite.apm.gui.automation.utilities.WebRequests;
import java.util.Map;
import java.util.HashMap;

public class DataLoadAllCalls
{
    public static void runDataLoadPinDataExtract() throws Exception {

        String xmlrsp = "";
        HashMap<Integer, HashMap<String, String>> responseData = null;

        /*****************************************************************
         * Pin Import
         *****************************************************************/
//        WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
//        WebRequests.dataload(DataLoadPinImport.dataloadPinImportMultiple());

        /*****************************************************************
         * Pin Verify
         *****************************************************************/
//        WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanId());
//        WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanSeqNoExpiryDate());
//        WebRequests.dataload(DataLoadPinVerify.dataloadPinVerifyByPanAlias());

        /*****************************************************************
         * Pin Delete
         *****************************************************************/
//        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
//        responseData = WebRequests.getResponseData(xmlrsp);
//
//        for (int i = 0; i < responseData.size(); i++ ){
//
//            if(responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                String pinId = responseData.get(i).get("PINID").toString();
//                String xmlRspDelete = WebRequests.dataload(DataLoadPinDelete.dataloadPinDeleteByPinId(pinId));
//                System.out.println("Delete Response: " + xmlRspDelete);
//            }
//        }
//        xmlrsp = "";
//        responseData = null;
//
//        xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingle());
//        responseData = WebRequests.getResponseData(xmlrsp);
//
//        for (int i = 0; i < responseData.size(); i++ ){
//
//            if(responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                String pinId = responseData.get(i).get("PINID").toString();
//                String issuerPinId = DataLoadDataGatherer.dataloadGetIssuerPinAliasByPinId(pinId);
//                System.out.println(issuerPinId);
//                String xmlRspDelete = WebRequests.dataload(DataLoadPinDelete.dataloadPinDeleteByIssuerPinId(issuerPinId));
//                System.out.println("Delete Response: " + xmlRspDelete);
//            }
//        }
//        xmlrsp = "";
//        responseData = null;

        /*****************************************************************
         * Pin Export
         *****************************************************************/
//        WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanId());
//        WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanSeqNoExpiryDate());
//        WebRequests.dataload(DataLoadPinExport.dataloadPinExportByPanAlias());

        /*****************************************************************
         * Pin Update
         *****************************************************************/
//        WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanId());
//        WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanSeqNoExpiryDate());
//        WebRequests.dataload(DataLoadPinUpdate.dataloadPinUpdateByPanAlias());

        /*****************************************************************
         * Token Import
         *****************************************************************/
//        xmlrsp = WebRequests.dataload(DataLoadTokenImport.dataloadTokenImport());
//        responseData = WebRequests.getResponseData(xmlrsp);
//        for (int i = 0; i < responseData.size(); i++ ){
//
//            if(responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                String panId = responseData.get(i).get("PANID").toString();
//                String panClear = responseData.get(i).get("PAN").toString();
//                String panSeqNum = responseData.get(i).get("PANSequenceNumber").toString();
//                String panExpDate = responseData.get(i).get("PANExpiryDate").toString();
//                String issuerPanAlias = responseData.get(i).get("IssuerPANAlias").toString();
//
//                System.out.println("PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" +
//                        panSeqNum + ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias);
//            }
//        }
//        xmlrsp = "";
//        responseData = null;

        /*****************************************************************
         * Token Import with PIN Advice - SMS
         *****************************************************************/
//        xmlrsp = WebRequests.dataload(DataLoadTokenImport.dataloadTokenImport());
//        responseData = WebRequests.getResponseData(xmlrsp);
//        for (int i = 0; i < responseData.size(); i++ ){
//
//            if(responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                String panId = responseData.get(i).get("PANID").toString();
//                String panClear = responseData.get(i).get("PAN").toString();
//                String panSeqNum = responseData.get(i).get("PANSequenceNumber").toString();
//                String panExpDate = responseData.get(i).get("PANExpiryDate").toString();
//                String issuerPanAlias = responseData.get(i).get("IssuerPANAlias").toString();
//
//                System.out.println("PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" +
//                        panSeqNum + ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias);
//
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdSMS(panId));
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanIdMail(panId));
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasSMS(issuerPanAlias));
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanAliasMail(issuerPanAlias));
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateSMS(panClear, panSeqNum, panExpDate));
//                WebRequests.dataload(DataLoadPinAdvice.dataloadPinAdviceByPanSeqNumExpDateMail(panClear, panSeqNum, panExpDate));
//            }
//        }
//        xmlrsp = "";
//        responseData = null;
//
        /*****************************************************************
         * TOWPD
         *****************************************************************/
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Web());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT1_Mail_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Mail());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_Web());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT2_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Web());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT3_Mail_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Web());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT4_Mail_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Web());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_SMS_DM1());
//        xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD_OT6_Mail_DM1());
//        responseData = WebRequests.getResponseData(xmlrsp);
//
//        for (int i = 0; i < responseData.size(); i++ ) {
//
//            if (responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                String panId = responseData.get(i).get("PANID").toString();
//                String panClear = responseData.get(i).get("PAN").toString();
//                String panSeqNum = responseData.get(i).get("PANSequenceNumber").toString();
//                String panExpDate = responseData.get(i).get("PANExpiryDate").toString();
//                String issuerPanAlias = responseData.get(i).get("IssuerPANAlias").toString();
//                String pinEncrypted = responseData.get(i).get("PIN").toString();
//                String pinVerificationValue = responseData.get(i).get("PINVerificationValue").toString();
//                String pvvKeyIndex = responseData.get(i).get("PVVKeyIndex").toString();
//
//                System.out.println("PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
//                        ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
//                        ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
//                        ", PVVKEYINDEX=" + pvvKeyIndex);
//
//            }
//
//        }


        /*****************************************************************
         * VPP
         *****************************************************************/
//        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPAN());
//        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPANId());
//        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByIssuerPinId());
//        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPanAlias());
//        responseData = WebRequests.getResponseData(xmlrsp);
//
//        if (responseData.get(1).get("ResponseCode").toString().equals("1"))
//        {
//
//            System.out.println("SetVPPPINIdByPanAlias => Success");
//
//            xmlrsp = "";
//            responseData = null;
////            System.out.println(DataLoadVPP.dataloadVPPSetPIN());
////            xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
//            xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
//            responseData = WebRequests.getResponseData(xmlrsp);
//            if (responseData.get(1).get("ResponseCode").toString().equals("1"))
//            {
//                System.out.println("VPPGetPIN => Success");
//            }
//            else
//            {
//                System.out.println("VPPGetPIN => Failure");
//            }
//            xmlrsp = "";
//            responseData = null;
//
//        }
//        else
//        {
//            System.out.println("SetVPPPINIdByPanAlias => Failed");
//            xmlrsp = "";
//            responseData = null;
//        }

        /*****************************************************************
         * Token Delete
         *****************************************************************/

//        xmlrsp = WebRequests.dataload(DataLoadTokenDelete.dataloadTokenDeleteByPanId());
//        String xmlin = DataLoadTokenDelete.dataloadTokenDeleteByPanSeqNoExpiryDate();
//        String xmlin = DataLoadTokenDelete.dataloadTokenDeleteByPanAlias();
//        System.out.println(xmlin);
//        xmlrsp = WebRequests.dataload(xmlin);
//        responseData = WebRequests.getResponseData(xmlrsp);
//        for (int i = 0; i < responseData.size(); i++ ) {
//
//            if (responseData.get(i).get("ResponseCode").toString().equals("1")) {
//                System.out.println("Token Delete => Success");
//            } else {
//                System.out.println("Token Delete => " + responseData.get(i).get("ErrorDescription").toString());
//            }
//
//        }

        /*****************************************************************
         * Translate
         *****************************************************************/
////        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePan());
////        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePanAlias());
//        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePanId());
//        responseData = WebRequests.getResponseData(xmlrsp);
//        for (int i = 0; i < responseData.size(); i++ ) {
//            if (responseData.get(i).get("ResponseCode").toString().equals("1")) {
////                TranslatePan gets the following
//                String panId = responseData.get(i).get("PAN").toString();
//                System.out.println(" => " + panId);
//
////                TranslatePanAlias and TranslatePanId get the following
//                String pan = responseData.get(i).get("PAN").toString();
//                String panSequenceNumber = responseData.get(i).get("PANSequenceNumber").toString();
//                String panExpiryDate = responseData.get(i).get("PANExpiryDate").toString();
//                System.out.println(" => " + pan + ", " + panSequenceNumber + ", " + panExpiryDate);
//            }
//        }

        /*****************************************************************
         * Pin Change Rollback
         *****************************************************************/
        String xmlin = DataLoadPinUpdate.dataloadPinUpdateByPanId();
        System.out.println(xmlin);
        xmlrsp = WebRequests.dataload(xmlin);
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").toString().equals("1")) {

//                xmlin = DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanId();
//                xmlin = DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanSeqNoExpiryDate();
                xmlin = DataLoadPinChangeRollback.dataloadPinChangeRollbackByPanAlias();
                xmlrsp = WebRequests.dataload(xmlin);
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++ ) {
                    if (responseData.get(j).get("ResponseCode").toString().equals("1")) {
                        System.out.println("dataloadPinChangeRollback => Success");
                    }
                    else{
                        System.out.println("dataloadPinChangeRollback => Fail");
                    }

                }

            }
        }




    }
}


