package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.PinMailerRecord;
import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.apache.commons.lang.BooleanUtils;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PinMailerDatabaseGatherer
{
    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    static final String SQL = "SELECT " +
                                    "TRXL.ID as RECORD_ID, " + //1
                                    "PIN.VALUE as PIN, " + //2
//                                    "PUK.VALUE as PUK, " +
                                    "TAPP.PAN_ENCRYPTED as PAN, " + //3
                                    "TAPP.PAN_DISPLAY as PAN_DISPLAY, " + //4
                                    "TRXL.REQ_LANGUAGE_CODE as LANGUAGE_CODE, " + //5
                                    "TRXL.REQ_MAILING_CODE as MAILING_CODE, " + //6
                                    "TRXL.REQ_TH_TITLE as TOKEN_HOLDER_TITLE, " + //7
                                    "TRXL.REQ_TH_FIRST_NAME  as TOKEN_HOLDER_FIRST_NAME, " + //8
                                    "TRXL.REQ_TH_MIDDLE_NAME as TOKEN_HOLDER_MIDDLE_NAME, " + //9
                                    "TRXL.REQ_TH_LAST_NAME as TOKEN_HOLDER_LAST_NAME, " + //10
                                    "TRXL.REQ_TH_ADDRESS1 as TOKEN_HOLDER_ADDRESS1, " + //11
                                    "TRXL.REQ_TH_ADDRESS2 as TOKEN_HOLDER_ADDRESS2, " + //12
                                    "TRXL.REQ_TH_ADDRESS3 as TOKEN_HOLDER_ADDRESS3, " + //13
                                    "TRXL.REQ_TH_ADDRESS4 as TOKEN_HOLDER_ADDRESS4, " + //14
                                    "TRXL.REQ_TH_ADDRESS5 as TOKEN_HOLDER_ADDRESS5, " + //15
                                    "TRXL.REQ_TH_ADDRESS6 as TOKEN_HOLDER_ADDRESS6, " + //16
                                    "TRXL.REQ_TH_TOWN  as TOKEN_HOLDER_TOWN, " + //17
                                    "TRXL.REQ_TH_POST_CODE   as TOKEN_HOLDER_POST_CODE, " + //18
                                    "TRXL.REQ_TH_COUNTRY_CODE   as TOKEN_HOLDER_COUNTRY_CODE, " + //19
                                    "TRXL.REQ_COMPANY_NAME as COMPANY_NAME, " + //20
                                    "TRXL.REQ_COMPANY_CONTACT as COMPANY_CONTACT, " + //21
                                    "TRXL.REQ_PRIORITY as PRIORITY, " + //22
                                    "TRXL.REQ_BRANCH_CODE as ISSUER_BRANCH_CODE, " + //23
                                    "TRXL.REQ_BRANCH_NAME  as ISSUER_BRANCH_NAME, " + //24
                                    "TRXL.REQ_BR_ADDRESS1  as ISSUER_BRANCH_ADDRESS1, " + //25
                                    "TRXL.REQ_BR_ADDRESS2  as ISSUER_BRANCH_ADDRESS2, " + //26
                                    "TRXL.REQ_BR_ADDRESS3  as ISSUER_BRANCH_ADDRESS3, " + //27
                                    "TRXL.REQ_BR_ADDRESS4  as ISSUER_BRANCH_ADDRESS4, " + //28
                                    "TRXL.REQ_BR_ADDRESS5  as ISSUER_BRANCH_ADDRESS5, " + //29
                                    "TRXL.REQ_BR_ADDRESS6  as ISSUER_BRANCH_ADDRESS6, " + //30
                                    "TRXL.REQ_BR_TOWN  as ISSUER_BRANCH_TOWN, " + //31
                                    "TRXL.REQ_BR_POST_CODE  as ISSUER_BRANCH_POST_CODE, " + //32
                                    "TRXL.REQ_BR_COUNTRY_CODE  as ISSUER_BRANCH_COUNTRY_CODE, " + //33
                                    "TPRD.ISSUER_TOKEN_PRODUCT_CODE as ISSUER_TOKEN_PRODUCT_CODE, " + //34
                                    "TPRD.NAME as  ISSUER_TOKEN_PRODUCT_NAME, " + //35
                                    "TRXL.REQ_PASSTHRU_DATA AS PASS_THROUGH_DATA, " + //36
                                    "ISSR.NAME as ISSUER_NAME, " + //37
                                    "ISSR.ID as ISSUER_ID " + //38
                                "FROM  " +
                                    "PM_D_TRX_LOG TRXL left outer join  " +
                                    "C_D_PIN PUK                 on PUK.ID =TRXL.RSP_PUK_ID inner join " +
                                    "C_D_TOKEN_APPLICATION TAPP  on TAPP.ID=TRXL.RSP_PAN_ID  inner join " +
                                    "C_D_TOKEN_APP_PROFILE TAPR  on TAPP.TOKEN_PRODUCT_ID=TAPR.TOKEN_PRODUCT_ID  " +
                                    "                            AND TAPP.APP_SEQ_NUMBER=TAPR.APP_SEQ_NUMBER inner join " +
                                    "C_D_TOKEN TOKN              on TOKN.ID=TAPP.TOKEN_ID inner join " +
                                    "C_D_TOKEN_PRODUCT TPRD      on TPRD.ID=TOKN.TOKEN_PRODUCT_ID inner join " +
                                    "C_D_ISSUER ISSR             on ISSR.ID=TPRD.ISSUER_ID inner join " +
                                    "INT_D_PERSO_BUREAU BURO     on BURO.ID=TPRD.PERSO_BUREAU_ID inner join  " +
                                    "C_D_INSTITUTION INST        on INST.ID=ISSR.INSTITUTION_ID left outer join " +
                                    "C_D_PIN  PIN                on PIN.ID =TRXL.RSP_PIN_ID " +
                                "WHERE TRXL.TRX_TYPE_ID in (5, 9) " +
                                    "AND TRXL.REQ_PIN_DELIVERY_METHOD IN (2, 6) " +
                                    "AND TRXL.ID > ? " +
                                    "AND ISSR.ID = ? " +
                                "ORDER BY  " +
                                    "ISSR.ID, " +
                                    "BURO.BUREAU_CODE, " +
                                    "TRXL.REQ_DATETIME, " +
                                    "TRXL.SYSTEM_DATETIME";

    private final Connection connection;
    public List<PinMailerRecord> records = new ArrayList<>();

    int dbBureauPinBlockFormat;

    public PinMailerDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(int thisRunFromId)
    {
        try
        {

            int issuer = Integer.parseInt(ConfigUtils.cfgProperty("issuer"));
            String localZpk = ConfigUtils.cfgProperty("local_zpk");
            String localZek = ConfigUtils.cfgProperty("local_zek");
            String localPinBlockFormat = ConfigUtils.cfgProperty("local_pinblock_format");
            String localPanEncryptedFlag = ConfigUtils.cfgProperty("local_pan_encrypted");
            String bureauPanEncryptedFlag = ConfigUtils.cfgProperty("bureau_pan_encrypted");
            String bureauPinBlockFormat = ConfigUtils.cfgProperty("bureau_pinblock_format");
            if (bureauPinBlockFormat==null || bureauPinBlockFormat.equals("") || bureauPinBlockFormat.equals("null")){
                dbBureauPinBlockFormat = 2;
            }
            else{
                dbBureauPinBlockFormat = Integer.parseInt(bureauPinBlockFormat) + 1;
            }

            String bureauExtractPanFlag = ConfigUtils.cfgProperty("bureau_extract_pan");
            String bureauExtractPanDisplayFlag = ConfigUtils.cfgProperty("bureau_extract_pan_display");

            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);
            preparedSelect.setInt(2, issuer);

            System.out.println("About to gather data for pinmailer task with IDs > " + thisRunFromId + "  for issuer " + issuer);

            ResultSet rs = preparedSelect.executeQuery();
            while (rs.next())
            {

                String dbPin = rs.getString(2);
                String dbPan = rs.getString(3);

                String clearPan;

                if (BooleanUtils.toBoolean(localPanEncryptedFlag))
                {
                    clearPan = CryptoUtils.getPanFromEncPanBlock(dbPan, localZek);
                }
                else
                {
                    clearPan = dbPan;
                }

                String clearPin = CryptoUtils.extractPinFromPinBlock(dbPin, localPinBlockFormat, localZpk, clearPan);

                PinMailerRecord record = new PinMailerRecord();

                record.setPin(clearPin);
                record.setPinBlockFormat(Integer.toString(dbBureauPinBlockFormat));
                //record.setPinBlockFormat(Integer.toString(dbBureauPinBlockFormat));//original

                if (BooleanUtils.toBoolean(bureauExtractPanFlag))
                {
                    record.setPan(CryptoUtils.getPanFromEncPanBlock(dbPan, localZek));
                }
                else
                {
                    record.setPan("");
                }

                record.setPanEncryptedFlag(bureauPanEncryptedFlag);

                if (BooleanUtils.toBoolean(bureauExtractPanDisplayFlag))
                {
                    record.setPanMasked(rs.getString(4));
                }
                else
                {
                    record.setPanMasked("");
                }

                record.setMailingCode(rs.getString(6));

                record.setTitle(rs.getString(7) == null ? "" : rs.getString(7));
                record.setFirstName(rs.getString(8) == null ? "" : rs.getString(8));
                record.setMiddleName(rs.getString(9) == null ? "" : rs.getString(9));
                record.setLastName(rs.getString(10) == null ? "" : rs.getString(10));

                record.setThAddressLine1(rs.getString(11) == null ? "" : rs.getString(11));
                record.setThAddressLine2(rs.getString(12) == null ? "" : rs.getString(12));
                record.setThAddressLine3(rs.getString(13) == null ? "" : rs.getString(13));
                record.setThAddressLine4(rs.getString(14) == null ? "" : rs.getString(14));
                record.setThAddressLine5(rs.getString(15) == null ? "" : rs.getString(15));
                record.setThAddressLine6(rs.getString(16) == null ? "" : rs.getString(16));
                record.setThTown(rs.getString(17) == null ? "" : rs.getString(17));
                record.setThPostCode(rs.getString(18) == null ? "" : rs.getString(18));
                record.setThCountryCode(rs.getString(19) == null ? "" : rs.getString(19));

                record.setBranchCode(rs.getString(23) == null ? "" : rs.getString(23));
                record.setBranchName(rs.getString(24) == null ? "" : rs.getString(24));
                record.setIbAddressLine1(rs.getString(25) == null ? "" : rs.getString(25));
                record.setIbAddressLine2(rs.getString(26) == null ? "" : rs.getString(26));
                record.setIbAddressLine3(rs.getString(27) == null ? "" : rs.getString(27));
                record.setIbAddressLine4(rs.getString(28) == null ? "" : rs.getString(28));
                record.setIbAddressLine5(rs.getString(29) == null ? "" : rs.getString(29));
                record.setIbAddressLine6(rs.getString(30) == null ? "" : rs.getString(30));
                record.setIbTown(rs.getString(31) == null ? "" : rs.getString(31));
                record.setIbPostCode(rs.getString(32) == null ? "" : rs.getString(32));
                record.setIbCountryCode(rs.getString(33) == null ? "" : rs.getString(33));

                record.setPriority(rs.getString(22) == null ? "" : rs.getString(22));
                record.setLanguageCode(rs.getString(5) == null ? "" : rs.getString(5));
                record.setCompanyName(rs.getString(20) == null ? "" : rs.getString(20));
                record.setCompanyContact(rs.getString(21) == null ? "" : rs.getString(21));
                record.setPassthroughData(rs.getString(36) == null ? "" : rs.getString(36));
                record.setIssuerId(rs.getString(38) == null ? "" : rs.getString(38));
                record.setIssuerName(rs.getString(37) == null ? "" : rs.getString(37));
                record.setIssuerTokenProductCode(rs.getString(34) == null ? "" : rs.getString(34));
                record.setTokenProductName(rs.getString(35) == null ? "" : rs.getString(35));

                records.add(record);
                rowCount++;
            }
            System.out.println("Records Count: " + rowCount);
            this.setRecordCount(rowCount);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: PinMailerDatabaseGatherer");
        for (PinMailerRecord pinMailerRecord : records)
        {
            System.out.println(pinMailerRecord.toString());
        }
    }

}
