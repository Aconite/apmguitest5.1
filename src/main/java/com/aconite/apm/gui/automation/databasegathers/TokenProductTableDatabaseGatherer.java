package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.TokenProductTableDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenProductTableDatabaseGatherer
{
    int rowcount = 0;
    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    private static final String SQL =   "SELECT CDTP.ID, CDTP.NAME, CDTP.ISSUER_TOKEN_PRODUCT_CODE, ISS.NAME, " +
            "CDTPG.NAME, CDTP.RETENTION_DAYS, CTRY.NAME, CDTP.LANGUAGE_CODE, " +
            "IDPB.NAME, CDTP.FEEDBACK_REQUIRED_FLAG, CDTP.STATUS, CDTP.PIN_TEMPLATE_ID, " +
            "CDTP.SECONDARY_PIN_TEMPLATE_ID, CDTP.PUK_TEMPLATE_ID, CDTP.PASSWORD_TEMPLATE_ID, " +
            "CDTP.SMS_PASSWORD_EXPIRATION, CDTP.SMS_SENDER, CDTP.SMS_VALIDITY, CDTP.SMS_CLASS " +
            "FROM C_D_TOKEN_PRODUCT CDTP " +
            "LEFT JOIN C_D_ISSUER ISS ON CDTP.ISSUER_ID = ISS.ID " +
            "LEFT JOIN C_D_TOKEN_PRODUCT_GROUP CDTPG ON CDTP.TOKEN_PRODUCT_GROUP_ID = CDTPG.ID " +
            "LEFT JOIN C_S_COUNTRIES CTRY ON CDTP.COUNTRY_CODE = CTRY.COUNTRY_CODE " +
            "LEFT JOIN INT_D_PERSO_BUREAU IDPB ON CDTP.PERSO_BUREAU_ID = IDPB.ID " +
            "WHERE CDTP.ISSUER_ID = ? " +
            "AND CDTP.TOKEN_PRODUCT_GROUP_ID = ?";

    private static final String getIssuerIdSQL = "SELECT ID FROM C_D_ISSUER WHERE NAME = ?";

    private static final String getTokenProductIdSQL = "SELECT ID FROM C_D_TOKEN_PRODUCT_GROUP WHERE NAME = ?";


    private Connection connection;
    public List <TokenProductTableDataRecord> records = new ArrayList<>();

    public TokenProductTableDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public String getIssuerId(String issuerName) throws Exception{

        PreparedStatement preparedSelect = connection.prepareStatement(getIssuerIdSQL);
        System.out.println("About to get id for issuer " + issuerName);
        preparedSelect.setString(1, issuerName);
        ResultSet rs = preparedSelect.executeQuery();
        rs.next();
        return(rs.getString(1));
    }

    public String getTokenProductId(String tokenProductGroupName)throws Exception{

        PreparedStatement preparedSelect = connection.prepareStatement(getTokenProductIdSQL);
        System.out.println("About to get id for issuer " + tokenProductGroupName);
        preparedSelect.setString(1, tokenProductGroupName);
        ResultSet rs = preparedSelect.executeQuery();
        rs.next();
        return(rs.getString(1));
    }

    public void gatherData(String issuerName, String tokenProductGroupName)throws Exception
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setString(1, getIssuerId(issuerName));
            preparedSelect.setString(2, getTokenProductId(tokenProductGroupName));

            System.out.println("About to gather data for all token product entries with for issuer " + issuerName +
                    " and token product group " + tokenProductGroupName);

            ResultSet rs = preparedSelect.executeQuery();
            while (rs.next())
            {
                TokenProductTableDataRecord record = new TokenProductTableDataRecord();
                record.setId(rs.getString(1));
                record.setName(rs.getString(2));
                record.setIssuerTokenProductCode(rs.getString(3));
                record.setIssuer(rs.getString(4));
                record.setTokenProductGroup(rs.getString(5));
                record.setRetentionDays(rs.getString(6));
                record.setCountry(rs.getString(7));
                record.setLanguage(rs.getString(8));
                record.setPersoBureau(rs.getString(9));
                record.setFeedbackRequired(rs.getString(10));
                record.setActive(rs.getString(11));
                record.setPinTemplate(rs.getString(12));
                record.setSecondaryPinTemplate(rs.getString(13));
                record.setPukTemplate(rs.getString(14));
                record.setPasswordTemplate(rs.getString(15));
                record.setSmsPasswordHours(rs.getString(16));
                record.setSmsSender(rs.getString(17));
                record.setSmsValidityHours(rs.getString(18));
                record.setSmsClassDB(rs.getString(19));

                records.add(record);
                rowcount++;
            }
            System.out.println("Data gathered for all token product entries with for issuer " + issuerName +
                    " and token product group " + tokenProductGroupName);
            this.setRecordCount(rowcount);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: TokenProductTableDatabaseGatherer");
        for (TokenProductTableDataRecord tokenProductTableDataRecord : records)
        {
            System.out.println(tokenProductTableDataRecord.toString());
        }
    }

}