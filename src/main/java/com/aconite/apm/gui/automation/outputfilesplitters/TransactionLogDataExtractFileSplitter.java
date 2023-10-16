package com.aconite.apm.gui.automation.outputfilesplitters;

import com.aconite.apm.gui.automation.databasegathers.ExtractLogDataGatherer;
import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.TransactionLogDataExtractRecord;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;
import com.aconite.apm.gui.automation.utilities.SFTPFileRetriever;
import com.aconite.apm.gui.automation.utilities.XmlUtils;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogDataExtractFileSplitter
{
    public List<TransactionLogDataExtractRecord> records;
    String outputFileName = null;
    String outputFilePath;

    int rowCount = 0;

    private int recordCount = 0;
    private String parsedFileName = "";

    private void setParsedFileName(String fileName){
        this.parsedFileName = fileName;
    }

    public String getParsedFileName(){
        return (this.parsedFileName);
    }

    private void setRecordCount(int count){
        this.recordCount = count;
    }

    public int getRecordCount(){
        return (this.recordCount);
    }

    public void splitFileInRecords() throws Exception
    {
        getFileNameFromDatabase();

        if (outputFileName == null)
        {
            throw new IllegalStateException("No filename retrieved from database. Did the task complete successfully?");
        }
        else
        {
            retrieveFileFromSftp();

            String localFilePath = outputFilePath + "\\" + outputFileName;

            records = new ArrayList<>();

            NodeList nodeList = XmlUtils.splitFileIntoRecords(localFilePath);

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                records.add(getRecord(nodeList.item(i)));
                rowCount++;
            }
            this.setRecordCount(rowCount);
            this.setParsedFileName(outputFileName);
        }
    }

    private TransactionLogDataExtractRecord getRecord(Node node)
    {
        TransactionLogDataExtractRecord record = new TransactionLogDataExtractRecord();
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;
            record.setId(XmlUtils.getTagValue("ID", element));
            record.setInterfaceId(XmlUtils.getTagValue("INTERFACE_ID", element));
            record.setTrxTypeId(XmlUtils.getTagValue("TRX_TYPE_ID", element));
            record.setTrxStatus(XmlUtils.getTagValue("TRX_STATUS", element));
            record.setSystemDateTime(XmlUtils.getTagValue("SYSTEM_DATETIME", element));
            record.setReqDateTime(XmlUtils.getTagValue("REQ_DATETIME", element));
            record.setReqOrigId(XmlUtils.getTagValue("REQ_ORIG_ID", element));
            record.setReqRn(XmlUtils.getTagValue("REQ_RN", element));
            record.setReqIssuerPinId(XmlUtils.getTagValue("REQ_ISSUER_PIN_ID", element));
            record.setReqIssuerPukId(XmlUtils.getTagValue("REQ_ISSUER_PUK_ID", element));
            record.setReqPukId(XmlUtils.getTagValue("REQ_PUK_ID", element));
            record.setReqPinExpiryDate(XmlUtils.getTagValue("REQ_PIN_EXPIRY_DATE", element));
            record.setReqPinId(XmlUtils.getTagValue("REQ_PIN_ID", element));
            record.setReqPanId(XmlUtils.getTagValue("REQ_PAN_ID", element));
            record.setReqIssuerPanAlias(XmlUtils.getTagValue("REQ_ISSUER_PAN_ALIAS", element));
            record.setReqPanSeqNumber(XmlUtils.getTagValue("REQ_PAN_SEQ_NUMBER", element));
            record.setReqPanExpiryDate(XmlUtils.getTagValue("REQ_PAN_EXPIRY_DATE", element));
            record.setReqTokenAppStatusId(XmlUtils.getTagValue("REQ_TOKEN_APP_STATUS_ID", element));
            record.setReqTokenAppSeqNum(XmlUtils.getTagValue("REQ_TOKEN_APP_SEQ_NUM", element));
            record.setReqIssuerTokenProductCode(XmlUtils.getTagValue("REQ_ISSUER_TOKEN_PRODUCT_CODE", element));
            record.setReqPinDeliveryMethod(XmlUtils.getTagValue("REQ_PIN_DELIVERY_METHOD", element));
            record.setReqAdviceAllTokenAppFlag(XmlUtils.getTagValue("REQ_ADVICE_ALL_TOKEN_APP_FLAG", element));
            record.setReqAdvicePinPukFlag(XmlUtils.getTagValue("REQ_ADVICE_PIN_PUK_FLAG", element));
            record.setReqLanguageCode(XmlUtils.getTagValue("REQ_LANGUAGE_CODE", element));
            record.setReqMailingCode(XmlUtils.getTagValue("REQ_MAILING_CODE", element));
            record.setReqPriority(XmlUtils.getTagValue("REQ_PRIORITY", element));
            record.setReqBranchCode(XmlUtils.getTagValue("REQ_BRANCH_CODE", element));
            record.setReqBranchName(XmlUtils.getTagValue("REQ_BRANCH_NAME", element));
            record.setReqNumberofTokens(XmlUtils.getTagValue("REQ_NUMBER_OF_TOKENS", element));
            record.setReqGeneratePanFlag(XmlUtils.getTagValue("REQ_GENERATE_PAN_FLAG", element));
            record.setReqGeneratePinFlag(XmlUtils.getTagValue("REQ_GENERATE_PIN_FLAG", element));
            record.setReqGeneratePukFlag(XmlUtils.getTagValue("REQ_GENERATE_PUK_FLAG", element));
            record.setReqOrderType(XmlUtils.getTagValue("REQ_ORDER_TYPE", element));
            record.setReqFeedbackRequiredFlag(XmlUtils.getTagValue("REQ_FEEDBACK_REQUIRED_FLAG", element));
            record.setReqPreviousPanId(XmlUtils.getTagValue("REQ_PREVIOUS_PAN_ID", element));
            record.setReqPreviousPanSeqNumber(XmlUtils.getTagValue("REQ_PREVIOUS_PAN_SEQ_NUMBER", element));
            record.setReqPreviousPanExpiryDate(XmlUtils.getTagValue("REQ_PREVIOUS_PAN_EXPIRY_DATE", element));
            record.setRspResponseCode(XmlUtils.getTagValue("RSP_RESPONSE_CODE", element));
            record.setRspErrorDescr(XmlUtils.getTagValue("RSP_ERROR_DESCR", element));
            record.setRspDateTime(XmlUtils.getTagValue("RSP_DATETIME", element));
            record.setRspPinId(XmlUtils.getTagValue("RSP_PIN_ID", element));
            record.setRspPukId(XmlUtils.getTagValue("RSP_PUK_ID", element));
            record.setRspPanId(XmlUtils.getTagValue("RSP_PAN_ID", element));
            record.setRspPanSeqNumber(XmlUtils.getTagValue("RSP_PAN_SEQ_NUMBER", element));
            record.setRspPanExpiryDate(XmlUtils.getTagValue("RSP_PAN_EXPIRY_DATE", element));
            record.setRspIssuerTokenProductCode(XmlUtils.getTagValue("RSP_ISSUER_TOKEN_PRODUCT_CODE", element));
            record.setRspTokenAppSeqNum(XmlUtils.getTagValue("RSP_TOKEN_APP_SEQ_NUM", element));
            record.setRspSmsStatus(XmlUtils.getTagValue("RSP_SMS_STATUS", element));
            record.setExtInstitutionId(XmlUtils.getTagValue("EXT_INSTITUTION_ID", element));
            record.setExtInstitutionName(XmlUtils.getTagValue("EXT_INSTITUTION_NAME", element));
            record.setExtIssuerId(XmlUtils.getTagValue("EXT_ISSUER_ID", element));
            record.setExtIssuerName(XmlUtils.getTagValue("EXT_ISSUER_NAME", element));
            record.setExtTokenProductId(XmlUtils.getTagValue("EXT_TOKEN_PRODUCT_ID", element));
            record.setExtIssuerTokenproductCode(XmlUtils.getTagValue("EXT_ISSUER_TOKEN_PRODUCT_CODE", element));
            record.setExtTokenProductName(XmlUtils.getTagValue("EXT_TOKEN_PRODUCT_NAME", element));
            record.setExtTokenProductGroupId(XmlUtils.getTagValue("EXT_TOKEN_PRODUCT_GROUP_ID", element));
            record.setExtTokenProductGroupName(XmlUtils.getTagValue("EXT_TOKEN_PRODUCT_GROUP_NAME", element));
            record.setExtTokenProductGroupCode(XmlUtils.getTagValue("EXT_TOKEN_PRODUCT_GROUP_CODE", element));
            record.setExtPanDisplay(XmlUtils.getTagValue("EXT_PAN_DISPLAY", element));
            record.setExtIssuerCountryCode(XmlUtils.getTagValue("EXT_ISSUER_COUNTRY_CODE", element));
        }

        return record;
    }

    public void printRecords()
    {
        System.out.println("Print Records: TransactionLogDataExtractFileSplitter");
        for (TransactionLogDataExtractRecord transactionLogDataExtractRecord : records)
        {
            System.out.println(transactionLogDataExtractRecord.toString());
        }
    }

    private void getFileNameFromDatabase()
    {
        outputFileName = ExtractLogDataGatherer.getLastSuccessfulRunFileName(ExtractTypes.TRANSACTIONLOGDATAEXTRACT);
    }

    private void retrieveFileFromSftp() throws SftpException, JSchException
    {
        outputFilePath = ConfigUtils.cfgProperty("local_folder");
        String srcFolder = ConfigUtils.cfgProperty("extractlog_filepath");
        String srcFileName = outputFileName;

        SFTPFileRetriever.downloadFile(srcFolder, srcFileName, outputFilePath);
    }

}