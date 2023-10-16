package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import com.aconite.apm.gui.automation.records.ExtractLogDataExtractRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ExtractLogDataGatherer
{
    static final String SQL =   "SELECT ID, EXTRACT_TYPE_ID, ID_FROM, ID_TO, STATUS, FILES " +
                                "FROM EXTR_D_EXTRACT_LOG " +
                                "WHERE EXTRACT_TYPE_ID = ? " +
                                "AND STATUS = 'C' " +
                                "ORDER BY ID DESC";

    static final String housekeeperSQL =    "SELECT ID, ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                            "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID " +
                                            "FROM EXTR_D_EXTRACT_LOG " +
                                            "WHERE FINISH_DATETIME < to_timestamp((select CURRENT_TIMESTAMP from dual)-?)";

    static final String housekeeperSQLCount =    "SELECT COUNT(*) FROM EXTR_D_EXTRACT_LOG";

    private final Connection connection;
    public List <ExtractLogDataExtractRecord> records = new ArrayList<>();

    public ExtractLogDataGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public static int getLastSuccessfulRunId(ExtractTypes extractTypes)
    {
        int id = 0;

        try
        {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect =  connection.prepareStatement(SQL,
                                                ResultSet.TYPE_SCROLL_INSENSITIVE ,
                                                ResultSet.CONCUR_UPDATABLE);
            preparedSelect.setString(1, extractTypes.getExtractTypeId());

            ResultSet rs = preparedSelect.executeQuery();

            if (!rs.next())
            {
                System.out.println("There are no entries in EXTR_D_EXTRACT_LOG for a successful run of task type: " + extractTypes.getExtractTypeId());
            }
            else
            {
                rs.absolute(1);
                id = rs.getInt(1);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return id;
    }

    public static int getLastSuccessfulRunToId(ExtractTypes extractTypes)
    {
        int toId = 0;

        try
        {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect =  connection.prepareStatement(SQL,
                                                ResultSet.TYPE_SCROLL_INSENSITIVE ,
                                                ResultSet.CONCUR_UPDATABLE);
            preparedSelect.setString(1, extractTypes.getExtractTypeId());

            ResultSet rs = preparedSelect.executeQuery();

            if (!rs.next())
            {
                System.out.println("There are no entries in EXTR_D_EXTRACT_LOG for a successful run of task type: " + extractTypes.getExtractTypeId());
            }
            else
            {
                rs.absolute(1);
                toId = rs.getInt(4);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return toId;
    }

    public static int getLastSuccessfulRunFromId(ExtractTypes extractTypes)
    {
        int fromId = 0;

        try
        {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect =  connection.prepareStatement(SQL,
                                                ResultSet.TYPE_SCROLL_INSENSITIVE ,
                                                ResultSet.CONCUR_UPDATABLE);
            preparedSelect.setString(1, extractTypes.getExtractTypeId());

            ResultSet rs = preparedSelect.executeQuery();

            if (!rs.next())
            {
                System.out.println("There are no entries in EXTR_D_EXTRACT_LOG for a successful run of task type: " + extractTypes.getExtractTypeId());
            }
            else
            {
                rs.absolute(1);
                fromId = rs.getInt(3);
            }
         }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return fromId;
    }

    //HACKY! Json in the database has bugs!
    public static String getLastSuccessfulRunFileName(ExtractTypes extractTypes)
    {
        String filename = null;

        try
        {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect =  connection.prepareStatement(SQL,
                                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                ResultSet.CONCUR_UPDATABLE);
            preparedSelect.setString(1, extractTypes.getExtractTypeId());

            ResultSet rs = preparedSelect.executeQuery();
            if (!rs.next())
            {
                System.out.println("There are no entries in EXTR_D_EXTRACT_LOG for a successful run of task type: " + extractTypes.getExtractTypeId());
            }
            else
            {
                rs.absolute(1);

                String dbFileName = rs.getString(6);
                Pattern pattern = Pattern.compile(extractTypes.getFileRegex(), Pattern.DOTALL);
                Matcher matcher = pattern.matcher(dbFileName);

                while (matcher.find())
                {
                    filename = matcher.group(0);
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

      return filename;
    }

    public static String getLastSuccessfulRunEndTime(ExtractTypes extractTypes){

        String lastRunEndTime = null;
        Pattern pattern;
        Matcher matcher;

        try
        {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect =  connection.prepareStatement(SQL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE ,
                    ResultSet.CONCUR_UPDATABLE);
            preparedSelect.setString(1, extractTypes.getExtractTypeId());

            ResultSet rs = preparedSelect.executeQuery();

            if (!rs.next())
            {
                System.out.println("There are no entries in EXTR_D_EXTRACT_LOG for a successful run of task type: " + extractTypes.getExtractTypeId());
            }
            else
            {
                rs.absolute(1);
                String dbFileName = rs.getString(6);
                if(extractTypes.getExtractTypeId().equals("9") || extractTypes.getExtractTypeId().equals("17")) {
                    pattern = Pattern.compile("&quot;end&quot;:(.*?)}]", Pattern.DOTALL);
                    matcher = pattern.matcher(dbFileName);
                    while (matcher.find())
                    {
                        lastRunEndTime = matcher.group(1);
                    }
                }
                if(extractTypes.getExtractTypeId().equals("1")) {
                    pattern = Pattern.compile("&quot;,end:&quot;(.*?)&quot;}]", Pattern.DOTALL);
                    matcher = pattern.matcher(dbFileName);
                    while (matcher.find())
                    {
                        lastRunEndTime = matcher.group(1);
                    }
                }

            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return lastRunEndTime;

    }

    public void gatherDataForHousekeeper(String param)
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQL);
            preparedSelect.setInt(1, Integer.parseInt(param));

            System.out.println("About to gather data for all extractlog entries older than " + param + " days...");

            ResultSet rs = preparedSelect.executeQuery();
            int rowCount = 0;
            while (rs.next())
            {
                ExtractLogDataExtractRecord record = new ExtractLogDataExtractRecord();
                record.setId(rs.getString(1));
                record.setOriginator(rs.getString(2));
                record.setExtractTypeId(rs.getString(3));
                record.setStartDateTime(rs.getString(4));
                record.setFinishDateTime(rs.getString(5));
                record.setIdFrom(rs.getString(6));
                record.setIdTo(rs.getString(7));
                record.setDateTimeFrom(rs.getString(8));
                record.setDateTimeTo(rs.getString(9));
                record.setStatus(rs.getString(10));
                record.setFiles(rs.getString(11));
                record.setIssuerId(rs.getString(12));

                records.add(record);
                rowCount++;
            }

            System.out.println("Data gathered for extractlog entries older than " + param + " days: " + rowCount + " rows found");


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
//                System.out.println(rs.getString(1));
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
        System.out.println("Print Records: ExtractLogDatabaseGatherer");
        for (ExtractLogDataExtractRecord extractLogDataExtractRecord : records)
        {
            System.out.println(extractLogDataExtractRecord.toString());
        }
    }

}