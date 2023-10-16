package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadHousekeeperUnusedPinPasswordCleanUp
 * This will call all the functions to put enough data in for an unusedPinPasswordCleanUp test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinImport;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadHousekeeperUnusedPinPasswordCleanUp
{

    public static String runDataLoadHousekeeperUnusedPinPasswordCleanUp() throws Exception {

        StringBuilder out = new StringBuilder();
        String res = "";
        String xmlrsp;
        String pinId;

        HashMap<Integer, HashMap<String, String>> responseData;

        for (int a = 0; a < 10; a++) {

            /* PIN Import */
            xmlrsp = WebRequests.dataload(DataLoadPinImport.dataloadPinImportSingleExpired());
            responseData = WebRequests.getResponseData(xmlrsp);

            for (int i = 0; i < responseData.size(); i++) {

                if (responseData.get(i).get("ResponseCode").equals("1")) {
                    pinId = responseData.get(i).get("PINID");
                    res = "TRX_TYPE_ID 1 - PIN IMPORT SINGLE EXPIRED: PINID=" + pinId  + "\n";
                } else {
                    System.out.println("TRX_TYPE_ID 1 - PIN IMPORT SINGLE EXPIRED: FAIL\n" + responseData);
                  }

                out.append(res);
            }
            res = "";

        }

        return(out.toString());

    }
}