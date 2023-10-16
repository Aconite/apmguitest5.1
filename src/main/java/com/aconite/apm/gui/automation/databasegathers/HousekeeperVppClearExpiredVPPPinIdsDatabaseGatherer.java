package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.HousekeeperClearExpiredVppPinIdsRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer
{

    private static final String housekeeperSQL =   "SELECT ID, VPP_PIN_ID, " +
                                                    "INSTITUTION_ID, PIN_ID, " +
                                                    "EXPIRY_DATETIME, LAST_UPDATE_DATETIME " +
                                                    "FROM C_D_VPP_PIN_ID " +
                                                    "WHERE EXPIRY_DATETIME < to_timestamp((select CURRENT_TIMESTAMP from dual)-10)";

    private static final String housekeeperSQLCount =    "SELECT COUNT(*) FROM C_D_VPP_PIN_ID " +
                                                        "WHERE EXPIRY_DATETIME < to_timestamp((select CURRENT_TIMESTAMP from dual)-10)";

    private final Connection connection;
    public List <HousekeeperClearExpiredVppPinIdsRecord> records = new ArrayList<>();

    public HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherDataForHousekeeper()
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQL);

//            TODO: Need to read retention period from token product table
            System.out.println("About to gather data for all clearExpiredVPPPinIds entries older than 10 days...");

            ResultSet rs = preparedSelect.executeQuery();

            int rowCount = 0;
            while (rs.next())
            {
                HousekeeperClearExpiredVppPinIdsRecord record = new HousekeeperClearExpiredVppPinIdsRecord();

                record.setId(rs.getString(1));
                record.setVppPinId(rs.getString(2));
                record.setInstitutionId(rs.getString(3));
                record.setPinId(rs.getString(4));
                record.setExpiryDateTime(rs.getString(5));
                record.setLastUpdateDateTime(rs.getString(6));

                records.add(record);
                rowCount++;
            }

            System.out.println("Data gathered for clearExpiredVPPPinIds entries older than 10 days: " + rowCount + " rows found");


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
        System.out.println("Print Records: HousekeeperClearExpiredVppPinIdsRecord");
        for (HousekeeperClearExpiredVppPinIdsRecord housekeeperClearExpiredVppPinIdsRecord : records)
        {
            System.out.println(housekeeperClearExpiredVppPinIdsRecord.toString());
        }
    }

}