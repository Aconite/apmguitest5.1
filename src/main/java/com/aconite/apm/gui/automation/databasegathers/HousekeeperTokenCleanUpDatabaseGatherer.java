package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.HousekeeperTokenCleanUpDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HousekeeperTokenCleanUpDatabaseGatherer
{
    private static final String SQL =   "SELECT ID, TOKEN_ID, TOKEN_PRODUCT_ID, " +
                                        "APP_SEQ_NUMBER, STATUS_ID, PAN_DISPLAY,  " +
                                        "NVL(PAN_ALIAS,' '), PAN_SEQ_NUMBER, TO_CHAR(EXPIRY_DATE, 'YYYY-MM-DD') " +
                                        "FROM C_D_TOKEN_APPLICATION " +
                                        "WHERE ID > ? " +
                                        "ORDER BY ID";

    private static final String housekeeperSQL =    "SELECT TAP.ID, TAP.TOKEN_ID, TOK.STATUS, TAP.EXPIRY_DATE, TAP.PIN_ID, PIN.STATUS " +
                                                    "FROM C_D_TOKEN_APPLICATION TAP " +
                                                    "INNER JOIN C_D_TOKEN TOK ON TAP.TOKEN_ID=TOK.ID " +
                                                    "INNER JOIN C_D_PIN PIN ON TAP.PIN_ID = PIN.ID " +
                                                    "WHERE EXPIRY_DATE <= to_timestamp((select CURRENT_TIMESTAMP from dual)-180)" +
                                                    "ORDER BY ID";

    private static final String housekeeperSQLCount =    "SELECT COUNT(*) FROM C_D_TOKEN_APPLICATION";

    private final Connection connection;
    public List <HousekeeperTokenCleanUpDataRecord> records = new ArrayList<>();

    public HousekeeperTokenCleanUpDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(int thisRunFromId)
    {
        try
        {

            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);

            System.out.println("About to gather data for all tokenCleanUp entries with ID > " + thisRunFromId + " ...");

            ResultSet rs = preparedSelect.executeQuery();
            int rowCount = 0;
            while (rs.next())
            {
                HousekeeperTokenCleanUpDataRecord record = new HousekeeperTokenCleanUpDataRecord();

                record.setId(rs.getString(1));
                record.setTokenId(rs.getString(2));
                record.setTokenStatus(rs.getString(3));
                record.setExpiryDate(rs.getString(4));
                record.setPinId(rs.getString(5));
                record.setPinStatus(rs.getString(6));

                records.add(record);
                rowCount++;
            }
            System.out.println("Data gathered for all tokenCleanUp entries with ID > " + thisRunFromId + ": " + rowCount + " rows found");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: HousekeeperTokenCleanUpDatabaseGatherer");
        for (HousekeeperTokenCleanUpDataRecord housekeeperTokenCleanUpDataRecord : records)
        {
            System.out.println(housekeeperTokenCleanUpDataRecord.toString());
        }
    }

    public void gatherDataForHousekeeper()
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQL);

//            TODO: Need to read retention period from token product table
            System.out.println("About to gather data for all tokenCleanUp entries older than 180 days...");

            ResultSet rs = preparedSelect.executeQuery();
            int rowCount = 0;
            while (rs.next())
            {
                HousekeeperTokenCleanUpDataRecord record = new HousekeeperTokenCleanUpDataRecord();
                record.setId(rs.getString(1));
                record.setTokenId(rs.getString(2));
                record.setTokenStatus(rs.getString(3));
                record.setExpiryDate(rs.getString(4));
                record.setPinId(rs.getString(5));
                record.setPinStatus(rs.getString(6));

                records.add(record);
                rowCount++;
            }

            System.out.println("Data gathered for tokenCleanUp entries older than 180 days: " + rowCount + " rows found");


        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public int getRowCountForHousekeeper()
    {
        ResultSet rs;
        int outCount=-1;

        try {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQLCount);
            rs = preparedSelect.executeQuery();
            while (rs.next()){
                outCount = Integer.parseInt(rs.getString(1));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return outCount;
    }

}