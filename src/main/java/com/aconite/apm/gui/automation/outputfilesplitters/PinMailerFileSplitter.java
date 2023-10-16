package com.aconite.apm.gui.automation.outputfilesplitters;

import com.aconite.apm.gui.automation.databasegathers.ExtractLogDataGatherer;
import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.records.PinMailerRecord;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;
import com.aconite.apm.gui.automation.utilities.CryptoUtils;
import com.aconite.apm.gui.automation.utilities.SFTPFileRetriever;
import com.aconite.apm.gui.automation.utilities.XmlUtils;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.apache.commons.lang.BooleanUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import static com.aconite.apm.gui.automation.enums.PinBlockFormats.FORMAT_0;

public class PinMailerFileSplitter
{
    public List<PinMailerRecord> records;
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

    private PinMailerRecord getRecord(Node node) throws Exception
    {
        PinMailerRecord record = new PinMailerRecord();
        String bureauZek = ConfigUtils.cfgProperty("bureau_zek");
        String bureauZpk = ConfigUtils.cfgProperty("bureau_zpk");
        String bureauPanEncryptedFlag = ConfigUtils.cfgProperty("bureau_pan_encrypted");
        String bureauPinBlockFormat = ConfigUtils.cfgProperty("bureau_pinblock_format");

        String bureauExtractPanFlag = ConfigUtils.cfgProperty("bureau_extract_pan");

        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element element = (Element) node;

            String clearPan = null;
            String pinBlock = XmlUtils.getTagValue("PIN", element);

            if (BooleanUtils.toBoolean(bureauExtractPanFlag))
            {
                String panFromFile = XmlUtils.getTagValue("PAN", element);
                if (BooleanUtils.toBoolean(bureauPanEncryptedFlag))
                {
                    //BUG - APM seems to use the wrong encryption zone
                    System.out.println(">" + panFromFile + "<");
                    clearPan = CryptoUtils.getPanFromEncPanBlock(panFromFile, bureauZek);
//                    clearPan = CryptoUtils.getPanFromEncPanBlock(panFromFile, localZek);
                    record.setPan(clearPan);
                }
                else
                {
                    record.setPan(panFromFile);
                }

                record.setPanEncryptedFlag(XmlUtils.getAttributeValue("EncryptedFlag", "PAN", element));
                record.setPanMasked(XmlUtils.getTagValue("PANMasked", element));

            }
            else
            {
                record.setPan("");
            }


            if (bureauPinBlockFormat.equals(FORMAT_0.toString()) && !BooleanUtils.toBoolean(bureauExtractPanFlag))
            {
                throw new Exception("INT_D_PERSO_BUREAU.EXTRACT_PAN_FLAG must be 'Y' to allow ISO 9564-1 Format 0 PIN extraction");
            }
            else
            {
                record.setPin(CryptoUtils.extractPinFromPinBlock(pinBlock, bureauPinBlockFormat, bureauZpk, clearPan));
            }

            record.setPinBlockFormat(XmlUtils.getAttributeValue("PINBlockFormat", "PIN", element));

            record.setMailingCode(XmlUtils.getTagValue("MailingCode", element));

            record.setTitle(XmlUtils.getTagValue("Title",element));
            record.setFirstName(XmlUtils.getTagValue("FirstName",element));
            record.setMiddleName(XmlUtils.getTagValue("MiddleName",element));
            record.setLastName(XmlUtils.getTagValue("LastName",element));


            Element tokenHolderAddress = XmlUtils.getElement("TokenholderAddress", element);
            record.setThAddressLine1(XmlUtils.getTagValue("AddressLine1",tokenHolderAddress));
            record.setThAddressLine2(XmlUtils.getTagValue("AddressLine2",tokenHolderAddress));
            record.setThAddressLine3(XmlUtils.getTagValue("AddressLine3",tokenHolderAddress));
            record.setThAddressLine4(XmlUtils.getTagValue("AddressLine4",tokenHolderAddress));
            record.setThAddressLine5(XmlUtils.getTagValue("AddressLine5",tokenHolderAddress));
            record.setThAddressLine6(XmlUtils.getTagValue("AddressLine6",tokenHolderAddress));
            record.setThTown(XmlUtils.getTagValue("Town",tokenHolderAddress));
            record.setThPostCode(XmlUtils.getTagValue("PostCode",tokenHolderAddress));
            record.setThCountryCode(XmlUtils.getTagValue("CountryCode",tokenHolderAddress));


            Element issuerBranch = XmlUtils.getElement("IssuerBranch", element);
            if(issuerBranch != null){
                record.setBranchCode(XmlUtils.getTagValue("BranchCode",issuerBranch));
                record.setBranchName(XmlUtils.getTagValue("BranchName",issuerBranch));
                record.setIbAddressLine1(XmlUtils.getTagValue("AddressLine1",issuerBranch));
                record.setIbAddressLine2(XmlUtils.getTagValue("AddressLine2",issuerBranch));
                record.setIbAddressLine3(XmlUtils.getTagValue("AddressLine3",issuerBranch));
                record.setIbAddressLine4(XmlUtils.getTagValue("AddressLine4",issuerBranch));
                record.setIbAddressLine5(XmlUtils.getTagValue("AddressLine5",issuerBranch));
                record.setIbAddressLine6(XmlUtils.getTagValue("AddressLine6",issuerBranch));
                record.setIbTown(XmlUtils.getTagValue("Town",issuerBranch));
                record.setIbPostCode(XmlUtils.getTagValue("PostCode",issuerBranch));
                record.setIbCountryCode(XmlUtils.getTagValue("CountryCode",issuerBranch));
            }
            else{
                record.setBranchCode(" ");
                record.setBranchName(" ");
                record.setIbAddressLine1(" ");
                record.setIbAddressLine2(" ");
                record.setIbAddressLine3(" ");
                record.setIbAddressLine4(" ");
                record.setIbAddressLine5(" ");
                record.setIbAddressLine6(" ");
                record.setIbTown(" ");
                record.setIbPostCode(" ");
                record.setIbCountryCode(" ");
            }


            record.setPriority(XmlUtils.getTagValue("Priority",element));
            record.setLanguageCode(XmlUtils.getTagValue("LanguageCode",element));
            record.setCompanyName(XmlUtils.getTagValue("CompanyName",element));
            record.setCompanyContact(XmlUtils.getTagValue("CompanyContact",element));
            //This is because of how passthroughdata element has a nested passthroughdata element
            record.setPassthroughData(XmlUtils.getSerializedChildElements("PassThroughData",element));
            record.setIssuerId(XmlUtils.getTagValue("IssuerId",element));
            record.setIssuerName(XmlUtils.getTagValue("IssuerName",element));
            record.setIssuerTokenProductCode(XmlUtils.getTagValue("IssuerTokenProductCode",element));
            record.setTokenProductName(XmlUtils.getTagValue("TokenProductName",element));
        }

        return record;
    }

    public void printRecords()
    {
        System.out.println("Print Records: PinMailerLogFileSplitter");
        for (PinMailerRecord record : records)
        {
            System.out.println(record.toString());
        }
    }

    private void getFileNameFromDatabase()
    {
        outputFileName = ExtractLogDataGatherer.getLastSuccessfulRunFileName(ExtractTypes.PINMAILER);
    }

    private void retrieveFileFromSftp() throws SftpException, JSchException
    {
        outputFilePath = ConfigUtils.cfgProperty("local_folder");
        String srcFolder = ConfigUtils.cfgProperty("pinmailer_filepath");
        String srcFileName = outputFileName;

        SFTPFileRetriever.downloadFile(srcFolder, srcFileName, outputFilePath);
    }
}
