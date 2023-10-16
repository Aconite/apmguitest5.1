package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.TokenProductAddEditDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenProductAddEditDatabaseGatherer
{
    int rowcount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    private static final String SQL =   "SELECT CDTP.ID, CDTP.NAME, CDTP.ISSUER_TOKEN_PRODUCT_CODE, ISS.NAME AS ISSUER, " +
            "CDTPG.NAME AS TOKEN_PRODUCT_GROUP, CDTP.RETENTION_DAYS, CTRY.NAME AS COUNTRY, " +
            "CONCAT(CONCAT(CONCAT(CDTP.LANGUAGE_CODE, ' ('), CSL.NAME), ')') AS LANGUAGE, " +
            "IDPB.NAME, CDTP.PIN_OVER_SMS_DELAY, CDTP.PIN_MAILER_DELAY, " +
            "CDTP.SMS_PASSWORD_DELAY, CDTP.FEEDBACK_REQUIRED_FLAG, CDTP.STATUS, " +
            "PMDT1.NAME AS PIN_TEMPLATE, " +
            "PMDT4.NAME AS SECONDARY_PIN_TEMPLATE, " +
            "PMDT2.NAME AS PUK_TEMPLATE, " +
            "PMDT3.NAME AS PASSWORD_TEMPLATE,  " +
            "CDTP.SMS_SENDER, CDTP.SMS_VALIDITY, CDTP.SMS_PASSWORD_EXPIRATION, " +
            "CDTP.SMS_CLASS, CDTP.IMPORT_PIN_DELIVERY_METHOD, " +
            "CDTP.TOWPD_PIN_DELIVERY_METHOD, CDTP.TOWPD_FORCE_DELIVERY_FLAG, " +
            "CDTP.ADVICE_PIN_DELIVERY_METHOD, CDTP.ADVICE_FORCE_DELIVERY_FLAG " +
            "FROM C_D_TOKEN_PRODUCT CDTP " +
            "LEFT JOIN C_D_ISSUER ISS ON CDTP.ISSUER_ID = ISS.ID " +
            "LEFT JOIN C_S_LANGUAGE CSL ON CDTP.LANGUAGE_CODE = CSL.LANGUAGE_CODE " +
            "LEFT JOIN C_D_TOKEN_PRODUCT_GROUP CDTPG ON CDTP.TOKEN_PRODUCT_GROUP_ID = CDTPG.ID " +
            "LEFT JOIN C_S_COUNTRIES CTRY ON CDTP.COUNTRY_CODE = CTRY.COUNTRY_CODE " +
            "LEFT JOIN INT_D_PERSO_BUREAU IDPB ON CDTP.PERSO_BUREAU_ID = IDPB.ID " +
            "LEFT JOIN PM_D_TEMPLATE PMDT1 ON CDTP.PIN_TEMPLATE_ID = PMDT1.ID " +
            "LEFT JOIN PM_D_TEMPLATE PMDT2 ON CDTP.PUK_TEMPLATE_ID = PMDT2.ID " +
            "LEFT JOIN PM_D_TEMPLATE PMDT3 ON CDTP.PASSWORD_TEMPLATE_ID = PMDT3.ID " +
            "LEFT JOIN PM_D_TEMPLATE PMDT4 ON CDTP.SECONDARY_PIN_TEMPLATE_ID = PMDT4.ID AND PMDT4.ID IS NOT NULL " +
            "WHERE CDTP.ID = ?";



    private Connection connection;

    public TokenProductAddEditDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public TokenProductAddEditDataRecord gatherData(String tokenProductId) throws Exception
    {
        TokenProductAddEditDataRecord record = new TokenProductAddEditDataRecord();

        try
        {

            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setString(1, tokenProductId);

            System.out.println("About to gather data for all token product entries with for Token Product ID:  " + tokenProductId);

            ResultSet rs = preparedSelect.executeQuery();
            rs.next();

            record.setId(rs.getString(1));
            record.setName(rs.getString(2));
            record.setIssuerTokenProductCode(rs.getString(3));
            record.setIssuer(rs.getString(4));
            record.setTokenProductGroup(rs.getString(5));
            record.setRetentionDays(rs.getString(6));
            record.setCountry(rs.getString(7));
            record.setLanguage(rs.getString(8));
            record.setPersoBureau(rs.getString(9));
            record.setPinOverSmsDelayHours(rs.getString(10));
            record.setPinMailerDelayHours(rs.getString(11));
            record.setSmsPasswordDelayHours(rs.getString(12));
            record.setFeedbackRequired(rs.getString(13));
            record.setActive(rs.getString(14));
            record.setPinTemplate(rs.getString(15));
            record.setSecondaryPinTemplate(rs.getString(16));
            record.setPukTemplate(rs.getString(17));
            record.setPasswordTemplate(rs.getString(18));
            record.setSmsSender(rs.getString(19));
            record.setSmsValidityHours(rs.getString(20));
            record.setSmsPasswordHours(rs.getString(21));
            record.setSmsClassDB(rs.getString(22));
            record.setTiPinDeliveryMethodDB(rs.getString(23));
            record.setTowpdPinDeliveryMethodDB(rs.getString(24));
            record.setForcePinDelivery(rs.getString(25));
            record.setPaPinDeliveryMethodDB(rs.getString(26));
            record.setForcePinAdvice(rs.getString(27));

            System.out.println("Data gathered for all token product entries with for Token Product ID:  " + tokenProductId);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return(record);

    }

}