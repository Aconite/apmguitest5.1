package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadHousekeeperTokenCleanUp
 * This will call all the functions to put enough data in for a translatepaniddataextract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.utilities.WebRequests;
import java.util.HashMap;
import java.util.ArrayList;

public class DataLoadHousekeeperTokenCleanUp
{

    public static String runDataLoadHousekeeperTokenCleanUp() throws Exception {

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
         * DataLoadTOWPD.dataloadTOWPD(String orderType, String deliveryMethodInt, String deliveryMethodString, String requestPurpose)
         * Order Type   "1" - Create New
         *              "2" - Copy from Token ID
         *              "3" - Copy by PAN/seq Num/ExpDate
         *              "4" - Copy from PIN ID
         *              "6" - Copy from IssuerPANAlias
         * Del Method Int   "1" - No Delivery - Will be done by PIN Advice
         *                  "2" - Mail
         *                  "3" - SMS
         *                  "5" - Web
         * Del Method String    "MAIL" - Inserts PinMailerData segment
         *                      "SMS" - Inserts SMSData Segment
         *                      "WEB" - Inserts WebData Segment
         * Req Purpose  "cardHolderUpdate" - Inserts the string "cardHolderUpdate" in PinMailer data for use in identifying
         *                                   records used for dataload to have their dates updated
         *              "tokenCleanUp" -     Ensures expirydate for each record is over 6 months ago
         */
        ArrayList<String> orderTypes = new ArrayList<>();
        orderTypes.add("1");
        orderTypes.add("2");
        orderTypes.add("3");
        orderTypes.add("4");
        orderTypes.add("6");

        ArrayList<String> delMethods = new ArrayList<>();
        delMethods.add("1;MAIL");
        delMethods.add("1;SMS");
        delMethods.add("2;MAIL");
        delMethods.add("3;SMS");
        delMethods.add("5;WEB");

        for (int a = 0; a < orderTypes.size(); a++) {

            String ot = orderTypes.get(a);

            for (int b = 0; b < delMethods.size(); b++) {

                String[] result = delMethods.get(b).split(";");
                String dm1 = result[0];
                String dm2 = result[1];

                /* TOWPD */
                xmlrsp = WebRequests.dataload(DataLoadTOWPD.dataloadTOWPD(ot, dm1, dm2, "tokenCleanUp"));
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

                        res = "TRX_TYPE_ID 9 - TOWPD: PANID=" + panId + ", PAN=" + panClear + ", PANSEQUENCENUMBER=" + panSeqNum +
                                ", PANEXPIRYDATE=" + panExpDate + ", ISSUERPANALIAS=" + issuerPanAlias +
                                ", PIN=" + pinEncrypted + ", PINVERIFICATIONVALUE=" + pinVerificationValue +
                                ", PVVKEYINDEX=" + pvvKeyIndex;
                    } else {
                        System.out.println("TOWPD: FAIL\n" + responseData);
                        System.out.println("TOWPD: FAIL = " + ot + ", " + dm1 + ", " + dm2);
                    }

                    out.append(res);

                }
                res = "";

            }

        }
        return(out.toString());
    }
}