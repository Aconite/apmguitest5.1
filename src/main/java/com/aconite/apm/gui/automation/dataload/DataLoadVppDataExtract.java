package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadVppDataExtract
 * This will call all the functions to put enough data in for a translatepaniddataextract test
 */

import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadPinImport;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadTOWPD;
import com.aconite.apm.gui.automation.dataload.xmlrequests.DataLoadVPP;
import com.aconite.apm.gui.automation.utilities.WebRequests;

import java.util.HashMap;

public class DataLoadVppDataExtract
{

    public static String runDataLoadVppDataExtract() throws Exception {

        HashMap<Integer, HashMap<String, String>> responseData;
        String encryptedPinBlock;
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
        String pinId;

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

        /* SET VPP PIN ID BY PAN - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPAN());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for(int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: FAIL");
                    }
                }

            }
            else {
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN: FAIL");
            }
        }

        /* SET VPP PIN ID BY PANID - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPANId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")){
                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PANID: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for(int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: FAIL");
                    }
                }
            }
            else {
                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PANID: FAIL");
            }

        }

        /* SET VPP PIN ID BY ISSUER PIN ID - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByIssuerPinId());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {

                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: FAIL");
                    }
                }
            }
            else {
                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID: FAIL");
            }
        }

        /* SET VPP PIN ID BY PAN ALIAS - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPSetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 11 - VPP SET PIN: FAIL");
                    }
                }

            } else{
                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS: FAIL");
            }

        }

        /* SET VPP PIN ID BY PAN - VPP GET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPAN());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
//                            System.out.println(responseData);
                        encryptedPinBlock = responseData.get(j).get("EncryptedPinBlock");
                        res = "TRX_TYPE_ID 12 - VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                        out.append(res);
                    } else {
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: FAIL");
                    }

                }
            }
            else{
                System.out.println("TRX_TYPE_ID 17 - SET VPP PIN ID BY PAN: FAIL");
            }
        }
        res = "";

        /* SET VPP PIN ID BY PANID - VPP SET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPANId());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {

                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PANID: PASS");

                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        encryptedPinBlock = responseData.get(j).get("EncryptedPinBlock");
                        res = "TRX_TYPE_ID 12 - VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: FAIL");
                    }
                    out.append(res);
                }

            } else {
                System.out.println("TRX_TYPE_ID 13 - SET VPP PIN ID BY PANID: FAIL");
            }
        }
        res = "";

        /* SET VPP PIN ID BY ISSUER PIN ID - VPP GET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByIssuerPinId());
        responseData = WebRequests.getResponseData(xmlrsp);

        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {

                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        encryptedPinBlock = responseData.get(j).get("EncryptedPinBlock");
                        res = "TRX_TYPE_ID 12 - VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: FAIL");
                    }
                    out.append(res);
                }
            }
            else {
                System.out.println("TRX_TYPE_ID 14 - SET VPP PIN ID BY ISSUER PIN ID: FAIL");
            }
        }
        res="";

        /* SET VPP PIN ID BY PAN ALIAS - VPP GET PIN */
        xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadSetVPPPINIdByPanAlias());
        responseData = WebRequests.getResponseData(xmlrsp);
        for (int i = 0; i < responseData.size(); i++) {
            if (responseData.get(i).get("ResponseCode").equals("1")) {

                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS: PASS");
                xmlrsp = WebRequests.dataload(DataLoadVPP.dataloadVPPGetPIN());
                responseData = WebRequests.getResponseData(xmlrsp);
                for (int j = 0; j < responseData.size(); j++) {
                    if (responseData.get(j).get("ResponseCode").equals("1")) {
                        encryptedPinBlock = responseData.get(j).get("EncryptedPinBlock");
                        res = "TRX_TYPE_ID 12 - VPPGetPIN: ENCRYPTEDPINBLOCK=" + encryptedPinBlock + "\n";
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: PASS");
                    } else {
                        System.out.println("TRX_TYPE_ID 12 - VPP GET PIN: FAIL");
                    }
                    out.append(res);
                }

            } else {
                System.out.println("TRX_TYPE_ID 22 - SET VPP PIN ID BY PAN ALIAS: FAIL");
            }
        }

        return(out.toString());

    }
}