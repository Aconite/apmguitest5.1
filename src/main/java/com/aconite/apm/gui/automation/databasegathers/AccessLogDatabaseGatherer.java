package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.AccessLogDataExtractRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccessLogDatabaseGatherer
{
    private static final String SQL =   "SELECT ID, TO_CHAR(DATETIME, 'YYYY-MM-DD'), USERNAME, ORIGINATOR, DESCRIPTION " +
                                        "FROM ACL_D_ACCESS_LOG " +
                                        "WHERE ID > ? " +
                                        "ORDER BY ID";

    private static final String housekeeperSQL =    "SELECT ID, TO_CHAR(DATETIME, 'YYYY-MM-DD'), USERNAME, ORIGINATOR, DESCRIPTION " +
                                                    "FROM ACL_D_ACCESS_LOG " +
                                                    "WHERE DATETIME < to_timestamp((select CURRENT_TIMESTAMP from dual)-?)" +
                                                    "ORDER BY ID";

    private static final String housekeeperSQLCount =    "SELECT COUNT(*) FROM ACL_D_ACCESS_LOG";

    private final Connection connection;
    public List <AccessLogDataExtractRecord> records = new ArrayList<>();

    public AccessLogDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    private int thisRunFromId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.ACCESSLOGDATAEXTRACT);

    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    public void gatherData()
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);

            System.out.println("About to gather data for all accesslog entries with ID > " + thisRunFromId + " ...");

            ResultSet rs = preparedSelect.executeQuery();
            while (rs.next())
            {
                AccessLogDataExtractRecord record = new AccessLogDataExtractRecord();
                record.setId(rs.getString(1));
                record.setDateTime(rs.getString(2));
                record.setUserName(rs.getString(3));
                record.setOriginator(rs.getString(4));
                record.setDescription(rs.getString(5));

                records.add(record);
                rowCount++;
            }
            System.out.println("Data gathered for all accesslog entries with ID > " + thisRunFromId + ": " + rowCount + " rows found");
            this.setRecordCount(rowCount);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void gatherDataForHousekeeper(String param)
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQL);
            preparedSelect.setInt(1, Integer.parseInt(param));

            System.out.println("About to gather data for all accesslog entries older than " + param + " days...");

            ResultSet rs = preparedSelect.executeQuery();
            int rowCount = 0;
            while (rs.next())
            {
                AccessLogDataExtractRecord record = new AccessLogDataExtractRecord();
                record.setId(rs.getString(1));
                record.setDateTime(rs.getString(2));
                record.setUserName(rs.getString(3));
                record.setOriginator(rs.getString(4));
                record.setDescription(rs.getString(5));

                records.add(record);
                rowCount++;
            }

            System.out.println("Data gathered for accesslog entries older than " + param + " days: " + rowCount + " rows found");


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
//        System.out.println(rs.toString());
        return outCount;
    }

    public void printRecords()
    {
        System.out.println("Print Records: AccessLogDatabaseGatherer");
        for (AccessLogDataExtractRecord accessLogDataExtractRecord : records)
        {
            System.out.println(accessLogDataExtractRecord.toString());
        }
    }


}
