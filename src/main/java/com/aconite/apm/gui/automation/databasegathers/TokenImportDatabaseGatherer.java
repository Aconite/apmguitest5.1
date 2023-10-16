package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.TokenImportFeedbackRecord;
import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TokenImportDatabaseGatherer
{

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount() {
        return (this.recordCount);
    }

        static final String SQL = "SELECT " +
                                    "MAX(TRXL.ID) as RECORD_ID, " + //1
                                    "TRXL.RSP_ISSUER_TOKEN_PRODUCT_CODE as ISSUER_TOKEN_PRODUCT_CODE, " + //2
                                    "TRXL.RSP_TOKEN_APP_SEQ_NUM as TOKEN_APPLICATION_SEQ_NUMBER, " + //3
                                    "TAPP.PAN_ALIAS, " + //4
                                    "TAPP.ID as PAN_ID, " + //5
                                    "TAPP.PAN_ENCRYPTED as PAN, " + //6
                                    "TAPP.PAN_SEQ_NUMBER as PAN_SEQ_NUMBER, " + //7
                                    "TAPP.EXPIRY_DATE as PAN_EXPIRY_DATE, " + //8
                                    "TRXL.RSP_RESPONSE_CODE as RESPONSE_CODE, " + //9
                                    "TRXL.RSP_ERROR_DESCR as ERROR_DESCRIPTION " + //10
                                "FROM " +
                                    "PM_D_TRX_LOG  TRXL inner join " +
                                    "C_D_TOKEN_APPLICATION TAPP  on TAPP.ID=TRXL.RSP_PAN_ID inner join " +
                                    "C_D_TOKEN_APP_PROFILE TAPR  on TAPP.TOKEN_PRODUCT_ID=TAPR.TOKEN_PRODUCT_ID " +
                                    "                            AND TAPP.APP_SEQ_NUMBER=TAPR.APP_SEQ_NUMBER inner join " +
                                    "C_D_TOKEN TOKN              on TOKN.ID=TAPP.TOKEN_ID inner join " +
                                    "C_D_TOKEN_PRODUCT TPRD      on TPRD.ID=TOKN.TOKEN_PRODUCT_ID inner join " +
                                    "C_D_ISSUER ISSR             on ISSR.ID=TPRD.ISSUER_ID inner join " +
                                    "C_D_INSTITUTION INST        on INST.ID=ISSR.INSTITUTION_ID " +
                                "WHERE TRXL.TRX_TYPE_ID = (7) " +
                                    "AND TRXL.TRX_STATUS=2 " +
                                    "AND (TRXL.REQ_FEEDBACK_REQUIRED_FLAG ='Y' OR (TRXL.REQ_FEEDBACK_REQUIRED_FLAG ='D' AND TPRD.FEEDBACK_REQUIRED_FLAG ='Y')) " +
//                                    "AND TRXL.ID > ? " +
                                    "AND TRXL.SYSTEM_DATETIME > (SELECT TO_TIMESTAMP(?,'YYYY-MM-DD HH24:MI:SS.FF') FROM DUAL) " +
                                    "AND ISSR.ID = ? " +
                                "GROUP BY ISSR.ID " +
                                    ",ISSR.NAME " +
                                    ",TAPP.TOKEN_ID " +
                                    ",TRXL.RSP_TOKEN_APP_SEQ_NUM " +
                                    ",TRXL.REQ_DATETIME " +
                                    ",TRXL.RSP_ISSUER_TOKEN_PRODUCT_CODE " +
                                    ",TRXL.RSP_RESPONSE_CODE " +
                                    ",TRXL.RSP_ERROR_DESCR " +
                                    ",TAPP.PAN_ALIAS " +
                                    ",TAPP.ID " +
                                    ",TAPP.PAN_ENCRYPTED " +
                                    ",TAPP.PAN_SEQ_NUMBER " +
                                    ",TAPP.EXPIRY_DATE " +
                                    ",INST.APM_LOCAL_ENC_ZONE_ID " +
                                    ",TAPR.IMPORT_ENC_ZONE_ID " +
                                "ORDER BY TAPP.TOKEN_ID";

    private final Connection connection;
    public List<TokenImportFeedbackRecord> records = new ArrayList<>();

    int rowCount = 0;

    public TokenImportDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(String thisRunFromDateTime)
    {
        try
        {
            int issuer = Integer.parseInt(ConfigUtils.cfgProperty("issuer"));
            String localZek = ConfigUtils.cfgProperty("local_zek");
            String importZek = ConfigUtils.cfgProperty("import_zek");
            String localPanEncryptedFlag = ConfigUtils.cfgProperty("local_pan_encrypted");
            String importPanEncryptedFlag = ConfigUtils.cfgProperty("import_pan_encrypted");

            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            if(thisRunFromDateTime==null){
                thisRunFromDateTime = "1900-01-01 00:00:00.00";
            }
            preparedSelect.setString(1, thisRunFromDateTime);
            preparedSelect.setInt(2, issuer);

            System.out.println("About to gather data for tokenimportfeedback task with Token Imports created since " + thisRunFromDateTime + " for issuer " + issuer);


            ResultSet rs = preparedSelect.executeQuery();

            while (rs.next())
            {

                String dbPan = rs.getString(6);

                TokenImportFeedbackRecord record = new TokenImportFeedbackRecord();
                record.setIssuerTokenProductCode(rs.getString(2));
                record.setSequenceNumber(rs.getString(3));
                record.setPanId(rs.getString(5));
                record.setPan(CryptoUtils.translatePan(dbPan, localPanEncryptedFlag, importPanEncryptedFlag, localZek, importZek));
                record.setPanEncryptedFlag(importPanEncryptedFlag);
                record.setPanSequenceNumber(rs.getString(7));
                record.setPanExpiryDate(rs.getDate(8).toString());
                record.setIssuerPanAlias(rs.getString(4) == null ? "" : rs.getString(4));
                record.setResponseCode(rs.getString(9));
                record.setErrorDescription(rs.getString(10) == null ? "" : rs.getString(10));

                records.add(record);
                rowCount++;
            }

            this.setRecordCount(rowCount);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        for (TokenImportFeedbackRecord tokenImportFeedbackRecord : records)
        {
            System.out.println(tokenImportFeedbackRecord.toString());
        }
    }

}
