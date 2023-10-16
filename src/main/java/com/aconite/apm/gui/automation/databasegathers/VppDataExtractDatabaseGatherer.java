package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.VppDataExtractRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VppDataExtractDatabaseGatherer
{
    private static final String SQL =   "SELECT ID, INTERFACE_ID, " +
                                        "TRX_TYPE_ID, TRX_STATUS " +
                                        "FROM PM_D_TRX_LOG " +
                                        "WHERE TRX_TYPE_ID in (11, 12) " +
                                        "AND ID > ? " +
                                        "AND TRX_STATUS = 2" +
                                        "ORDER BY ID";

    private final Connection connection;
    public List <VppDataExtractRecord> records = new ArrayList<>();

    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    public VppDataExtractDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(int thisRunFromId)
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);

            System.out.println("About to gather data for all vppdataextract entries with ID > " + thisRunFromId + " ...");

            ResultSet rs = preparedSelect.executeQuery();
            while (rs.next())
            {
                VppDataExtractRecord record = new VppDataExtractRecord();

                record.setId(rs.getString(1));
                record.setInterfaceId(rs.getString(2));
                record.setTrxTypeId(rs.getString(3));
                record.setTrxStatus(rs.getString(4));

                records.add(record);
                rowCount++;
            }
            this.setRecordCount(rowCount);
            System.out.println("Data gathered for all vppdataextract entries with ID > " + thisRunFromId + ": " + rowCount + " rows found");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: VppDataExtractDatabaseGatherer");
        for (VppDataExtractRecord vppDataExtractRecord : records)
        {
            System.out.println(vppDataExtractRecord.toString());
        }
    }

}