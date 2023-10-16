package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadTokenImportFeedback
 * This will call all the functions to put enough data in for a DataLoadTokenImportFeedback test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTokenImport;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadTokenImportFeedback
{
    public static String runDataLoadTokenImportFeedback() throws Exception {

        StringBuilder out = new StringBuilder();
        String res="";
        String xmlrsp;
        String panId;
        String panClear;
        String panSeqNum;
        String panExpDate;
        String issuerPanAlias;

        HashMap<Integer, HashMap<String, String>> responseData;

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
                System.out.println("TOKEN IMPORT FAIL: " + responseData.get(i).get("ErrorDescription"));
            }

            out.append(res).append("\n");

        }

        return(out.toString());

    }
}


