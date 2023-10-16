package com.aconite.apm.gui.automation.outputfilesplitters;

import com.aconite.apm.gui.automation.databasegathers.ExtractLogDataGatherer;
import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.TokenOrderFeedbackRecord;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;
import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import com.aconite.apm.gui.automation.utilities.SFTPFileRetriever;
import com.aconite.apm.gui.automation.utilities.XmlUtils;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class TokenOrderFeedbackFileSplitter
{
    public List<TokenOrderFeedbackRecord> records;
    private String outputFileName = null;
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

//            String localFilePath = localFolder + "/" + outputFileName;
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

    private TokenOrderFeedbackRecord getRecord(Node node) throws Exception
    {
        String importZpk = ConfigUtils.cfgProperty("import_zpk");
        String importPinBlockFormat = ConfigUtils.cfgProperty("import_pinblock_format");

        TokenOrderFeedbackRecord record = new TokenOrderFeedbackRecord();
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;
            String pan = XmlUtils.getTagValue("PAN", element);
            String pinBlock = XmlUtils.getTagValue("PIN", element);

            record.setPanId(XmlUtils.getTagValue("PANID", element));
            record.setPan(pan);
            record.setPanEncryptedFlag(XmlUtils.getAttributeValue("EncryptedFlag", "PAN", element));
            record.setPanSequenceNumber(XmlUtils.getTagValue("PANSequenceNumber", element));
            record.setPanExpiryDate(XmlUtils.getTagValue("PANExpiryDate", element));
            record.setIssuerPanAlias(XmlUtils.getTagValue("IssuerPANAlias", element));
            record.setPinVerificationValue(XmlUtils.getTagValue("PINVerificationValue", element));
//            record.setPinVerificationValue("1234");
            record.setPvvKeyIndex(XmlUtils.getTagValue("PVVKeyIndex", element));
            record.setPin(CryptoUtils.extractPinFromPinBlock(pinBlock, importPinBlockFormat, importZpk, pan));
        }

        return record;
    }

    public void printRecords()
    {
        for (TokenOrderFeedbackRecord record : records)
        {
            System.out.println(record.toString());
        }
    }

    private void getFileNameFromDatabase()
    {
        outputFileName = ExtractLogDataGatherer.getLastSuccessfulRunFileName(ExtractTypes.TOKENORDERFEEDBACK);
    }

    private void retrieveFileFromSftp() throws SftpException, JSchException
    {
        outputFilePath = ConfigUtils.cfgProperty("local_folder");
        String srcFolder = ConfigUtils.cfgProperty("orderfeedback_filepath");
        String srcFileName = outputFileName;

        SFTPFileRetriever.downloadFile(srcFolder, srcFileName, outputFilePath);
    }
}
