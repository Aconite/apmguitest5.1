package com.aconite.apm.gui.automation.dataload.datagatherers;


import com.aconite.apm.gui.automation.crypto.PinBlock1;
import com.aconite.apm.gui.automation.enums.PinBlockFormats;
import com.aconite.apm.gui.automation.records.DataLoadPinRecord;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;
import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DataLoadDataGatherer{

    private static Connection connection;

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String getDateTime(){

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return dateFormat.format(date);

    }

    public static String createNewExpiryDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar myDate = Calendar.getInstance();
        myDate.setTime(Calendar.getInstance().getTime());
        myDate.add(Calendar.MONTH,getRandomNumber(18,24));
        return dateFormat.format(myDate.getTime());

    }

    public static String createExpiredExpiryDate(int minMonths, int maxMonths){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar myDate = Calendar.getInstance();
        myDate.setTime(Calendar.getInstance().getTime());
        int num = getRandomNumber(minMonths,maxMonths);
        myDate.add(Calendar.MONTH,-num);
        return dateFormat.format(myDate.getTime());

    }

    public static String getIdentifier(int idLen){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(idLen)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public static String getNewPin(int idLen){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 57; // numeral '9'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(idLen)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public static String getPan(){

        String panInit = String.valueOf(System.nanoTime());
        for (int l = panInit.length(); l < 16; l++){
            panInit = "1" + panInit;
        }

        return(panInit);
    }

    public static String getEncryptedPin() throws Exception{

        String pin = getNewPin(4);
        String hexPin = CryptoUtils.hexify(PinBlock1.calculatePinBlock(pin));
        return CryptoUtils.desEncryptData(hexPin,ConfigUtils.cfgProperty("institution_zpk"));

    }

    public static String getVPPPinBlock() throws Exception{

        String pin = getNewPin(4);
        String hexPin = CryptoUtils.hexify(PinBlock1.calculatePinBlock(pin));
        return CryptoUtils.desEncryptData(hexPin,ConfigUtils.cfgProperty("interface_zpk"));

    }

    public static DataLoadPinRecord dataloadGetPinRecordForVerify() throws Exception{

        ResultSet rs;
        DataLoadPinRecord record = new DataLoadPinRecord();

        String sqlPinVerify = "SELECT TAPP.TOKEN_ID, TAPP.PAN_ENCRYPTED, TAPP.APP_SEQ_NUMBER, TO_CHAR(TAPP.EXPIRY_DATE, 'YYYY-MM-DD'), TAPP.PAN_ALIAS, PIN.ID, PIN.VALUE " +
                "FROM C_D_TOKEN_APPLICATION TAPP " +
                "LEFT JOIN C_D_PIN PIN ON TAPP.PIN_ID = PIN.ID " +
                "WHERE TAPP.TOKEN_ID = (SELECT TOKEN_ID FROM (SELECT TOKEN_ID FROM C_D_TOKEN_APPLICATION ORDER BY dbms_random.value) WHERE rownum = 1)";

        do {
            // Get a row at random
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(sqlPinVerify);
            rs = preparedSelect.executeQuery();
            rs.next();

            record.setTokenId(rs.getString(1));
            record.setPanEncrypted(rs.getString(2));
            record.setAppSequenceNumber(rs.getString(3));
            record.setPanExpiryDate(rs.getString(4));
            record.setPanAlias(rs.getString(5));
            record.setPinId(rs.getString(6));
            record.setPinEncrypted(rs.getString(7));

            String clearPan = CryptoUtils.translatePan(record.getPanEncrypted(), "Y", "N", ConfigUtils.cfgProperty("local_zek"), ""); //get props for local_zek
            record.setPanClear(clearPan);

            String translatedPin = CryptoUtils.translatePin(record.getPinEncrypted(), PinBlockFormats.FORMAT_1.toString(), ConfigUtils.cfgProperty("local_zpk"), PinBlockFormats.FORMAT_1.toString(), ConfigUtils.cfgProperty("institution_zpk"), "");
            record.setPinTranslated(translatedPin);

        }while (rs.getString(5) == null || rs.getString(5).equals(" "));

        return(record);

    }

    public static DataLoadPinRecord dataloadGetUpdatedPins() throws Exception{

        ResultSet rs;
        DataLoadPinRecord record = new DataLoadPinRecord();

        String sqlPinVerify = "SELECT TAPP.TOKEN_ID, TAPP.PAN_ENCRYPTED, TAPP.APP_SEQ_NUMBER, TO_CHAR(TAPP.EXPIRY_DATE, 'YYYY-MM-DD'), TAPP.PAN_ALIAS, PIN.ID, PIN.VALUE " +
                "FROM C_D_TOKEN_APPLICATION TAPP " +
                "LEFT JOIN C_D_PIN PIN ON TAPP.PIN_ID = PIN.ID " +
                "WHERE PIN.PREVIOUS_VALUE is not NULL " +
                "ORDER BY dbms_random.value";

        do {
            // Get a row at random
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(sqlPinVerify);
            rs = preparedSelect.executeQuery();
            rs.next();

            record.setTokenId(rs.getString(1));
            record.setPanEncrypted(rs.getString(2));
            record.setAppSequenceNumber(rs.getString(3));
            record.setPanExpiryDate(rs.getString(4));
            record.setPanAlias(rs.getString(5));
            record.setPinId(rs.getString(6));
            record.setPinEncrypted(rs.getString(7));

            String clearPan = CryptoUtils.translatePan(record.getPanEncrypted(), "Y", "N", ConfigUtils.cfgProperty("local_zek"), "");
            record.setPanClear(clearPan);

            String translatedPin = CryptoUtils.translatePin(record.getPinEncrypted(), PinBlockFormats.FORMAT_1.toString(),ConfigUtils.cfgProperty("local_zpk"), PinBlockFormats.FORMAT_1.toString(), ConfigUtils.cfgProperty("institution_zpk"), "");
            record.setPinTranslated(translatedPin);

        }while (rs.getString(5) == null || rs.getString(5).equals(" "));

        System.out.println(record);

        return(record);

    }

    public static String dataloadGetIssuerPinAliasByPinId(String pinId) throws Exception{

        String sql = "SELECT PIN.ISSUER_PIN_ID FROM C_D_PIN PIN WHERE PIN.ID = ?";
        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);
        preparedSelect.setString(1, pinId);

        ResultSet rs = preparedSelect.executeQuery();
        rs.next();

        return(rs.getString(1));

    }

    public static String dataloadGetRandomIssuerPinId() throws Exception{

        String sql = "SELECT ISSUER_PIN_ID FROM " +
                "(SELECT * FROM C_D_PIN WHERE ISSUER_PIN_ID is not null ORDER BY dbms_random.value) " +
                "WHERE rownum = 1 ";
        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        ResultSet rs = preparedSelect.executeQuery();
        rs.next();

        return(rs.getString(1));

    }

    public static String dataloadGetRandomVPPPinId() throws Exception{

        String sql = "SELECT VPP_PIN_ID FROM " +
                "(SELECT * FROM C_D_VPP_PIN_ID WHERE VPP_PIN_ID is not null " +
                "AND EXPIRY_DATETIME > (SELECT CURRENT_TIMESTAMP FROM DUAL) " +
                "ORDER BY dbms_random.value) " +
                "WHERE rownum = 1 ";
        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        ResultSet rs = preparedSelect.executeQuery();
        rs.next();



        return(rs.getString(1));

    }

    public static void dataloadModifyDatesForTransactionCleanUp() throws Exception{

        String sql =    "UPDATE PM_D_TRX_LOG " +
                "SET " +
                "SYSTEM_DATETIME = to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) - 181), " +
                "REQ_DATETIME = to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) - 181), " +
                "RSP_DATETIME = to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) - 181) " +
                "WHERE ID in (select id from (select * from PM_D_TRX_LOG order by id asc) where rownum<11)";

        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        preparedSelect.executeQuery();

        connection.close();

    }

    public static void dataloadModifyDatesForUserAccessLogsCleanUp() throws Exception{

        String sql =    "UPDATE ACL_D_ACCESS_LOG " +
                "SET " +
                "DATETIME = to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) - 181) " +
                "WHERE ID in (select id from (select * from ACL_D_ACCESS_LOG order by id asc) where rownum<11)";

        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        preparedSelect.executeQuery();

        connection.close();

    }

    public static boolean dataloadCheckTestKeyExists() throws Exception{

        String sql =    "SELECT * FROM ENC_D_SCI " +
                "WHERE NAME = 'Big Bank of Dave Message ZEK'";

        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        ResultSet rs = preparedSelect.executeQuery();
        if (!rs.isBeforeFirst() ) {
            System.out.println("No data");
            return (false);
        }
        else{
            return (true);
        }



    }

    public static void dataloadInsertKey() throws Exception{

        String sql = "INSERT INTO ENC_D_SCI " +
                "(NAME, STATUS, KEY_TYPE_ID, HSM_TYPE, LMK_KCV, " +
                "SCI_KEY_ALGORITHM, BLOCK_SIZE, " +
                "KEY_VALUE, KEY_KCV, EXPIRY_DATE, KEY_INDEX)" +
                "VALUES " +
                "('Big Bank of Dave Message ZEK', 'A', '3', 'THALES_PAYSHIELD_KB', " +
                "'9D04A0', 'DES2EDE', '64', 'S10096D0TB00S0002CFDB2AF0C411CC6D4D5B1A8D6D39932D76A19438FC025EDC77279261FDFB0B8E0B7AAACB9E84A03B', " +
                "'71501A', to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) + 9), '1')";

        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        preparedSelect.executeQuery();


    }

    public static void dataloadUpdateKeyExpiryDate() throws Exception{

        String sql =    "UPDATE ENC_D_SCI " +
                "SET " +
                "EXPIRY_DATE = to_timestamp((SELECT CURRENT_TIMESTAMP FROM DUAL) + 9) " +
                "WHERE Name = 'Big Bank of Dave Message ZEK'";

        connection = DatabaseConnection.getConnection();
        PreparedStatement preparedSelect = connection.prepareStatement(sql);

        preparedSelect.executeQuery();

        connection.close();

    }


}