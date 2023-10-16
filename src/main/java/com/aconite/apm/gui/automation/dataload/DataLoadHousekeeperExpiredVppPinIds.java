package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadHousekeeperExpiredVppPinIds
 * This will call all the functions to put enough data in for a translatepaniddataextract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadVPP;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadHousekeeperExpiredVppPinIds
{

    public static String runDataLoadHousekeeperExpiredVppPinIds() throws Exception {

        String xmlrsp;
        HashMap<Integer, HashMap<String, String>> responseData;


        /* SET VPP PIN ID BY PAN - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetExpiredVPPPINIdByPAN());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 17 - SET EXPIRED VPP PIN ID BY PAN: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 17 - SET EXPIRED VPP PIN ID BY PAN: FAIL");
            }
        }


        /* SET VPP PIN ID BY PANID - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetExpiredVPPPINIdByPANId());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 13 - SET EXPIRED VPP PIN ID BY PANID: PASS");
                }
            else {
                System.out.println("TRX_TYPE_ID 13 - SET EXPIRED VPP PIN ID BY PANID: FAIL");
            }
        }

        /* SET VPP PIN ID BY ISSUER PIN ID - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetExpiredVPPPINIdByIssuerPinId());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 14 - SET EXPIRED VPP PIN ID BY ISSUER PIN ID: PASS");
            } else {
                System.out.println("TRX_TYPE_ID 14 - SET EXPIRED VPP PIN ID BY ISSUER PIN ID: FAIL");
            }
        }

        return("");
    }
}