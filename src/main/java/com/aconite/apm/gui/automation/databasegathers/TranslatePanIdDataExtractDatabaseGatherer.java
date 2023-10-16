package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.TranslatePanIdDataExtractRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TranslatePanIdDataExtractDatabaseGatherer
{
    private static final String SQL =   "SELECT REQ_DATETIME, ID, INSTITUTION_ID, " +
                                        "TRX_TYPE_ID, TRX_STATUS, REQ_PAN_ID " +
                                        "FROM PM_D_TRX_LOG " +
                                        "WHERE TRX_TYPE_ID = 16 " +
                                        "AND ID > ? " +
                                        "ORDER BY ID";

    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    private final Connection connection;
    public List <TranslatePanIdDataExtractRecord> records = new ArrayList<>();

    public TranslatePanIdDataExtractDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(int thisRunFromId)
    {
        try
        {

            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);

            System.out.println("About to gather data for all translatepaniddataextract entries with ID > " + thisRunFromId + " ...");

            ResultSet rs = preparedSelect.executeQuery();

            while (rs.next())
            {
                TranslatePanIdDataExtractRecord record = new TranslatePanIdDataExtractRecord();

                record.setReqDateTime(rs.getString(1));
                record.setId(rs.getString(2));
                record.setInstitutionId(rs.getString(3));
                record.setTrxTypeId(rs.getString(4));
                record.setTrxStatus(rs.getString(5));
                record.setReqPanId(rs.getString(6));


                records.add(record);
                rowCount++;
            }
            this.setRecordCount(rowCount);
            System.out.println("Data gathered for all translatepaniddataextract entries with ID > " + thisRunFromId + ": " + rowCount + " rows found");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: TranslatePanIdDataExtractDatabaseGatherer");
        for (TranslatePanIdDataExtractRecord translatePanIdDataExtractRecord : records)
        {
            System.out.println(translatePanIdDataExtractRecord.toString());
        }
    }

}