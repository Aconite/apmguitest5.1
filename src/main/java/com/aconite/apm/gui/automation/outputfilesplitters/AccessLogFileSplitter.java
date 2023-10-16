package com.aconite.apm.gui.automation.outputfilesplitters;

import com.aconite.apm.gui.automation.databasegathers.ExtractLogDataGatherer;
import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.AccessLogDataExtractRecord;
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

public class AccessLogFileSplitter
{
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

    public List<AccessLogDataExtractRecord> records;
    String outputFileName = null;
    String outputFilePath;

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

    private AccessLogDataExtractRecord getRecord(Node node)
    {
        AccessLogDataExtractRecord record = new AccessLogDataExtractRecord();
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;
            record.setId(XmlUtils.getTagValue("ID", element));
            record.setDateTime(XmlUtils.getTagValue("DATETIME", element));
            record.setUserName(XmlUtils.getTagValue("USERNAME", element));
            record.setOriginator(XmlUtils.getTagValue("ORIGINATOR", element));
            record.setDescription(XmlUtils.getTagValue("DESCRIPTION", element));
        }

        return record;
    }

    public void printRecords()
    {
        System.out.println("Print Records: AccessLogFileSplitter");
        for (AccessLogDataExtractRecord accessLogDataExtractRecord : records)
        {
            System.out.println(accessLogDataExtractRecord.toString());
        }
    }

    private void getFileNameFromDatabase()
    {
        outputFileName = ExtractLogDataGatherer.getLastSuccessfulRunFileName(ExtractTypes.ACCESSLOGDATAEXTRACT);
    }

    private void retrieveFileFromSftp() throws SftpException, JSchException
    {
        outputFilePath = ConfigUtils.cfgProperty("local_folder");
        String srcFolder = ConfigUtils.cfgProperty("extractlog_filepath");
        String srcFileName = outputFileName;

        SFTPFileRetriever.downloadFile(srcFolder, srcFileName, outputFilePath);
    }

}
