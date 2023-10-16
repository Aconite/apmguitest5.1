package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadTranslatePanIdExtract
 * This will call all the functions to put enough data in for a translatepaniddataextract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTranslate;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadTranslatePanIdExtract
{

    public static String runDataLoadTranslatePanIdExtract() throws Exception {

        HashMap<Integer, HashMap<String, String>> responseData;
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

        /* TOWPD_OT1_Mail */
        /*
        Added to ensure there is a token application in the database when starting
        from an empty database
        */
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

        xmlrsp = WebRequests.dataload(DataLoadTranslate.dataloadTranslatePanId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++ ){
            if(responseData.get(i).get("ResponseCode").equals("1")) {
                panClear = responseData.get(i).get("PAN");
                panSeqNum = responseData.get(i).get("PANSequenceNumber");
                panExpDate = responseData.get(i).get("PANExpiryDate");

                System.out.println("TRX_TYPE_ID 16 - TRANSLATE PAN ID: PAN=" + panClear + ", PANSEQUENCENUMBER=" +
                        panSeqNum + ", PANEXPIRYDATE=" + panExpDate);
                res = "TRX_TYPE_ID 16 - TRANSLATE PAN ID: PAN=" + panClear + ", PANSEQUENCENUMBER=" +
                        panSeqNum + ", PANEXPIRYDATE=" + panExpDate + "\n";
            }
            else{
                System.out.println("TRX_TYPE_ID 16 - TRANSLATE PAN ID FAIL: " + responseData.get(i).get("ErrorDescription"));
            }
            out.append(res);
        }

        return(out.toString());

    }
}