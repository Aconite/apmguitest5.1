package com.aconite.apm.gui.automation.dataload;

/*
 * DataLoadHousekeeperExtractLogsCleanUp
 * This will call all the functions to put enough data in for a pin_mailer test
 */

import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataLoadHousekeeperExtractLogsCleanUp
{
    public static String runDataLoadHousekeeperExtractLogsCleanUp() throws Exception {

        String insertExtractRecordSQL = "INSERT ALL " +
                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('TokenOrderFeedback',2, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "53,480, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"1\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:\"ScheduledJob\",issuerId:1\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:\"1994-07-13 00:00:00.0\";,end:\"2021-11-28 16:25:00.088\";}]\",\"records\":\"[{name: TokenOrderFeedback_ZeroRecord_20211128162500.err,recordCount:0,Status:C}]\"}', " +
                                        "1) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('accesslog',13, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "53,480, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"36\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2022-02-11 11:07:59.06,end:2022-02-11 11:36:00.05}]\",\"records\":\"[{name: dbexp_AccessLog_file_dataextraction_20220211113600.066.xml,recordCount:36,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('translatepanid',19, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "5127,5475, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"1\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:UIManualRun\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2022-02-02 16:41:51.438,end:2022-02-04 11:08:40.101}]\",\"records\":\"[{name: dbexp_TranslatePanIdDataExtract_file_dataextraction_20220204110840.117.xml,recordCount:1,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('PinSms',15, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "7581,7607, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'Success: 0 transaction log records processed: 7602, 7588, 7574, 7595, 7581, ', " +
                                        "1) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('token',8, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "1292,1584, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"255\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2022-02-02 16:40:51.383,end:2022-02-04 12:52:55.716}]\",\"records\":\"[{name: dbexp_Token_file_dataextraction_20220204125255.732.xml,recordCount:255,Status:C}]\"}', " +
                                        "1) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('PinMailer',3, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "1150,1695, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"23\",\"recordName\":\"feedbackaudits\",\"taskid: 1,tasktype: ScheduledJob, issuerId: 1\":\" \",\"offsetvalues\":\"[{sod: -10000, eod: 10000}]\",\"datawindow\":\"[{start: 2021-12-09 13:18:01.912,end: 2021-12-17 15:40:16.768}]\",\"records\":\"[{name: PINMailer_ABCBank_OBER_20211217154018.xml,recordCount:23,Status:C}]\"}', " +
                                        "1) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('pin',9, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "714,834, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"107\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-12-09 13:06:59.05,end:2021-12-15 16:14:07.47}]\",\"records\":\"[{name: dbexp_PIN_file_dataextraction_20211215161407.486.xml,recordCount:107,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('pinsmsdataextract',17, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "1392,1411, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"5\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-12-09 16:12:59.074,end:2021-12-14 16:48:22.027}]\",\"records\":\"[{name: dbexp_PinSMSDataExtract_file_dataextraction_20211214164822.433.xml,recordCount:5,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('TokenImportFeedback',1, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "1084,1544, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"224\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob,issuerId:1\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-12-09 11:21:59.073,end:2022-01-27 14:44:00.061}]\",\"records\":\"[{name: TokenImportFeedback_ABCBank_20220127144407.xml,recordCount:224,Status:C}]\"}', " +
                                        "1) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('transactionlog',14, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "856,1876, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"477\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-12-07 16:36:20.248,end:2022-01-07 14:19:49.806}]\",\"records\":\"[{name: dbexp_TransactionLog_file_dataextraction_20220107141949.853.xml,recordCount:477,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('vpp',18, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "820,5122, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"37\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-12-07 15:27:16.872,end:2022-02-02 16:42:02.454}]\",\"records\":\"[{name: dbexp_VPPDataExtract_file_dataextraction_20220202164202.470.xml,recordCount:37,Status:C}]\"}', " +
                                        "0) " +

                                        "INTO EXTR_D_EXTRACT_LOG " +
                                        "(ORIGINATOR, EXTRACT_TYPE_ID, START_DATETIME, FINISH_DATETIME, " +
                                        "ID_FROM, ID_TO, DATETIME_FROM, DATETIME_TO, STATUS, FILES, ISSUER_ID) " +
                                        "VALUES " +
                                        "('tokenapplication',11, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "136,1291, " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "to_timestamp((select CURRENT_TIMESTAMP from dual) - 100), " +
                                        "'C', " +
                                        "'{\"totalCount\":\"960\",\"recordName\":\"feedbackaudits\",\"taskid:1,tasktype:ScheduledJob\":\" \",\"offsetvalues\":\"[{sod:-10000, eod:10000}]\",\"datawindow\":\"[{start:2021-11-30 08:39:59.056,end:2022-02-02 16:40:32.381}]\",\"records\":\"[{name: dbexp_TokenApplication_file_dataextraction_20220202164032.413.xml,recordCount:960,Status:C}]\"}', " +
                                        "0) " +

                                        "SELECT * FROM DUAL";


        Connection connection;
        connection = DatabaseConnection.getConnection();

        PreparedStatement preparedSelect = connection.prepareStatement(insertExtractRecordSQL);
        ResultSet rs = preparedSelect.executeQuery();

        connection.close();

        return("");

    }
}


