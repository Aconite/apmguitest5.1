package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadTransactionLogDataExtract
 * This will call all the functions to put enough data in for a transaction_log_data_extract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTokenDelete;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTranslate;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadVPP;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadTransactionLogDataExtract
{
    public static String runDataLoadTransactionLogDataExtract() throws Exception {

        StringBuilder out = new StringBuilder();
        String res = "";
        String xmlrsp;
        String panId;
        String pan;
        String panSeqNum;
        String panExpDate;
        String encryptedPinBlock;

        HashMap<Integer, HashMap<String, String>> responseData;



        /*
         * Token Delete
         */

        xmlrsp = WebRequests.dataload(DataLoadTokenDelete.dataloadTokenDeleteByPanId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 10 - TOKEN DELETE BY PAN ID => Success");
//                System.out.println(responseData);
            } else {
                System.out.println("TRX_TYPE_ID 10 - TOKEN DELETE BY PAN ID => " + responseData.get(i).get("ErrorDescription"));
            }
        }

        xmlrsp = DataLoadTokenDelete.dataloadTokenDeleteByPanSeqNoExpiryDate();
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 10 - TOKEN DELETE BY PAN - PAN SEQ NUM - PAN EXP DATE => Success");
//                System.out.println(responseData);
            } else {
                System.out.println("TRX_TYPE_ID 10 - TOKEN DELETE BY PAN - PAN SEQ NUM - PAN EXP DATE => " + responseData.get(i).get("ErrorDescription"));
            }
        }

        xmlrsp = DataLoadTokenDelete.dataloadTokenDeleteByPanAlias();
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 10 -  BY PAN ALIAS => Success");
//                System.out.println(responseData);
            } else {
                System.out.println("TRX_TYPE_ID 10 - TOKEN DELETE BY PAN ALIAS => " + responseData.get(i).get("ErrorDescription"));
            }
        }

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
                res = "TRX_TYPE_ID 12 - VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                out.append(res);
            }else {
                System.out.println("TRX_TYPE_ID 12 - VPP GET PIN FAIL: " + responseData.get(1).get("ErrorDescription"));
            }

            out.append(res);

        }
        res = "";


        /*
         * Translate
         */

        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePan());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                panId = responseData.get(i).get("PANID");
                res = "TRX_TYPE_ID 19 - TRANSLATE PAN: PANID=" + panId;
            } else {
                System.out.println("TRX_TYPE_ID 19 - TRANSLATE PAN=> " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                pan = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                res = "TRX_TYPE_ID 23 - TRANSLATE PAN ALIAS: PAN=" + pan + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate;
            } else {
                System.out.println("TRX_TYPE_ID 23 - TRANSLATE PAN ALIAS=> " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);

        }
        res = "";

        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePanId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                pan = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");
                res = "TRX_TYPE_ID 16 - TRANSLATE PAN ID: PAN=" + pan + ", PANSEQUENCENUMBER=" + panSeqNum +
                        ", PANEXPIRYDATE=" + panExpDate;
            } else {
                System.out.println("TRX_TYPE_ID 16 - TRANSLATE PAN ID=> " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res);

        }

        return(out.toString());
    }
}


