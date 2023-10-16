package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.TokenApplicationDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TokenApplicationDataDatabaseGatherer
{
    private static final String SQL =   "SELECT ID, TOKEN_ID, TOKEN_PRODUCT_ID, " +
                                        "APP_SEQ_NUMBER, STATUS_ID, PAN_DISPLAY,  " +
                                        "NVL(PAN_ALIAS,' '), PAN_SEQ_NUMBER, TO_CHAR(EXPIRY_DATE, 'YYYY-MM-DD') " +
                                        "FROM C_D_TOKEN_APPLICATION " +
                                        "WHERE ID > ? " +
                                        "ORDER BY ID";



    private final Connection connection;
    public List <TokenApplicationDataRecord> records = new ArrayList<>();
    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    public TokenApplicationDataDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherData(int thisRunFromId)
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setInt(1, thisRunFromId);

            System.out.println("About to gather data for all accesslog entries with ID > " + thisRunFromId + " ...");

            ResultSet rs = preparedSelect.executeQuery();

            while (rs.next())
            {
                TokenApplicationDataRecord record = new TokenApplicationDataRecord();

                record.setId(rs.getString(1));
                record.setTokenId(rs.getString(2));
                record.setTokenProductId(rs.getString(3));
                record.setAppSeqNumber(rs.getString(4));
                record.setStatusId(rs.getString(5));
                record.setPanDisplay(rs.getString(6));
                record.setPanAlias(rs.getString(7));
                record.setPanSeqNumber(rs.getString(8));
                record.setExpiryDate(rs.getString(9));

                records.add(record);
                rowCount++;
            }
            System.out.println("Data gathered for all tokenapplicationdata entries with ID > " + thisRunFromId + ": " + rowCount + " rows found");
            this.setRecordCount(rowCount);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void printRecords()
    {
        System.out.println("Print Records: TokenApplicationDataDatabaseGatherer");
        for (TokenApplicationDataRecord tokenApplicationDataRecord : records)
        {
            System.out.println(tokenApplicationDataRecord.toString());
        }
    }
}