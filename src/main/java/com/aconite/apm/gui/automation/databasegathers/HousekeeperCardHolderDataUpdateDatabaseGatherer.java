package com.aconite.apm.gui.automation.databasegathers;

import com.aconite.apm.gui.automation.records.HousekeeperCardHolderDataUpdateRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HousekeeperCardHolderDataUpdateDatabaseGatherer
{
    int rowCount = 0;

    private int recordCount = 0;

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    private static final String housekeeperSQL =    "SELECT ID, TRX_TYPE_ID, TRX_STATUS, SYSTEM_DATETIME, REQ_DATETIME, " +
                                                    "REQ_ORIG_ID, REQ_ISSUER_PIN_ID, REQ_PIN_EXPIRY_DATE, " +
                                                    "REQ_PIN_ID, REQ_PAN_ID, REQ_ISSUER_PAN_ALIAS, REQ_PAN_SEQ_NUMBER, REQ_PAN_EXPIRY_DATE, " +
                                                    "REQ_PIN_DELIVERY_METHOD, REQ_MOBILE_PHONE, REQ_TH_TITLE, REQ_TH_FIRST_NAME, REQ_TH_MIDDLE_NAME, REQ_TH_LAST_NAME, " +
                                                    "REQ_TH_ADDRESS1, REQ_TH_ADDRESS2, REQ_TH_ADDRESS3, REQ_TH_ADDRESS4, REQ_TH_ADDRESS5, REQ_TH_ADDRESS6, " +
                                                    "REQ_TH_TOWN, REQ_TH_POST_CODE, REQ_TH_COUNTRY_CODE, REQ_COMPANY_NAME, REQ_COMPANY_CONTACT " +
                                                    "FROM PM_D_TRX_LOG " +
                                                    "WHERE SYSTEM_DATETIME < to_timestamp((select CURRENT_TIMESTAMP from dual)-7) " +
                                                    "AND TRX_STATUS != 5";

    private static final String housekeeperActualSQL =    "SELECT ID, TRX_TYPE_ID, TRX_STATUS, SYSTEM_DATETIME, REQ_DATETIME, " +
                                                    "REQ_ORIG_ID, REQ_ISSUER_PIN_ID, REQ_PIN_EXPIRY_DATE, " +
                                                    "REQ_PIN_ID, REQ_PAN_ID, REQ_ISSUER_PAN_ALIAS, REQ_PAN_SEQ_NUMBER, REQ_PAN_EXPIRY_DATE, " +
                                                    "REQ_PIN_DELIVERY_METHOD, REQ_MOBILE_PHONE, REQ_TH_TITLE, REQ_TH_FIRST_NAME, REQ_TH_MIDDLE_NAME, REQ_TH_LAST_NAME, " +
                                                    "REQ_TH_ADDRESS1, REQ_TH_ADDRESS2, REQ_TH_ADDRESS3, REQ_TH_ADDRESS4, REQ_TH_ADDRESS5, REQ_TH_ADDRESS6, " +
                                                    "REQ_TH_TOWN, REQ_TH_POST_CODE, REQ_TH_COUNTRY_CODE, REQ_COMPANY_NAME, REQ_COMPANY_CONTACT " +
                                                    "FROM PM_D_TRX_LOG " +
                                                    "WHERE ID  = ?";



    private final Connection connection;
    public List <HousekeeperCardHolderDataUpdateRecord> records = new ArrayList<>();
    public String selectedIds = "";

    public HousekeeperCardHolderDataUpdateDatabaseGatherer()
    {
        connection = DatabaseConnection.getConnection();
    }

    public void gatherDataForHousekeeperActual (String housekeeperCardHolderDataUpdateRows){

        try
        {

            String[] ids = housekeeperCardHolderDataUpdateRows.split(",");
            for(String s: ids){

                PreparedStatement preparedSelect = connection.prepareStatement(housekeeperActualSQL);
                preparedSelect.setString(1, s);

                ResultSet rs = preparedSelect.executeQuery();

                while (rs.next()) {
                    HousekeeperCardHolderDataUpdateRecord record = new HousekeeperCardHolderDataUpdateRecord();
                    record.setId(rs.getString(1));
                    record.setTrxTypeId(rs.getString(2));
                    record.setTrxStatus(rs.getString(3));
                    record.setSystemDateTime(rs.getString(4));
                    record.setReqDateTime(rs.getString(5));
                    record.setReqOrigId(rs.getString(6));
                    record.setReqIssuerPinId(rs.getString(7));
                    record.setReqPinExpiryDate(rs.getString(8));
                    record.setReqPinId(rs.getString(9));
                    record.setReqPanId(rs.getString(10));
                    record.setReqIssuerPanAlias(rs.getString(11));
                    record.setReqPanSeqNumber(rs.getString(12));
                    record.setReqPanExpiryDate(rs.getString(13));
                    record.setReqPinDeliveryMethod(rs.getString(14));
                    record.setReqMobilePhone(rs.getString(15));
                    record.setReqTHTitle(rs.getString(16));
                    record.setReqTHFirstName(rs.getString(17));
                    record.setReqTHMiddleName(rs.getString(18));
                    record.setReqTHLastName(rs.getString(19));
                    record.setReqTHAddress1(rs.getString(20));
                    record.setReqTHAddress2(rs.getString(21));
                    record.setReqTHAddress3(rs.getString(22));
                    record.setReqTHAddress4(rs.getString(23));
                    record.setReqTHAddress5(rs.getString(24));
                    record.setReqTHAddress6(rs.getString(25));
                    record.setReqTHTown(rs.getString(26));
                    record.setReqTHPostCode(rs.getString(27));
                    record.setReqTHCountryCode(rs.getString(28));
                    record.setReqCompanyName(rs.getString(29));
                    record.setReqCompanyContact(rs.getString(30));

                    records.add(record);
                    rowCount++;

                }
                this.setRecordCount(rowCount);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }


    public void gatherDataForHousekeeper()
    {
        try
        {
            PreparedStatement preparedSelect = connection.prepareStatement(housekeeperSQL);

            System.out.println("About to gather data for cardholderDataUpdate ...");

            ResultSet rs = preparedSelect.executeQuery();
            int rowCount = 0;
            while (rs.next())
            {
                HousekeeperCardHolderDataUpdateRecord record = new HousekeeperCardHolderDataUpdateRecord();
                record.setId(rs.getString(1));
                if (selectedIds.equals("")){
                    selectedIds = rs.getString(1);
                }
                else{
                    selectedIds = selectedIds + "," + rs.getString(1);
                    }
                record.setTrxTypeId(rs.getString(2));
                record.setTrxStatus(rs.getString(3));
                record.setSystemDateTime(rs.getString(4));
                record.setReqDateTime(rs.getString(5));
                record.setReqOrigId(rs.getString(6));
                record.setReqIssuerPinId(rs.getString(7));
                record.setReqPinExpiryDate(rs.getString(8));
                record.setReqPinId(rs.getString(9));
                record.setReqPanId(rs.getString(10));
                record.setReqIssuerPanAlias(rs.getString(11));
                record.setReqPanSeqNumber(rs.getString(12));
                record.setReqPanExpiryDate(rs.getString(13));
                record.setReqPinDeliveryMethod(rs.getString(14));
                record.setReqMobilePhone(rs.getString(15));
                record.setReqTHTitle(rs.getString(16));
                record.setReqTHFirstName(rs.getString(17));
                record.setReqTHMiddleName(rs.getString(18));
                record.setReqTHLastName(rs.getString(19));
                record.setReqTHAddress1(rs.getString(20));
                record.setReqTHAddress2(rs.getString(21));
                record.setReqTHAddress3(rs.getString(22));
                record.setReqTHAddress4(rs.getString(23));
                record.setReqTHAddress5(rs.getString(24));
                record.setReqTHAddress6(rs.getString(25));
                record.setReqTHTown(rs.getString(26));
                record.setReqTHPostCode(rs.getString(27));
                record.setReqTHCountryCode(rs.getString(28));
                record.setReqCompanyName(rs.getString(29));
                record.setReqCompanyContact(rs.getString(30));


                records.add(record);
                rowCount++;
            }
            System.out.println("Data gathered for all cardholderDataUpdate entries: " + rowCount + " rows found");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }



    public void printRecords()
    {
        System.out.println("Print Records: HousekeeperCardHolderDataUpdateRecord");
        for (HousekeeperCardHolderDataUpdateRecord housekeeperCardHolderDataUpdateRecord : records)
        {
            System.out.println(housekeeperCardHolderDataUpdateRecord.toString());
        }
    }

}