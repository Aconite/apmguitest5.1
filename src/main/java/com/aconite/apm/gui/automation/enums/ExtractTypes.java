package com.aconite.apm.gui.automation.enums;

public enum ExtractTypes
{
    ACCESSLOGDATAEXTRACT("13", "\\bdbexp_AccessLog_file_dataextraction.*xml\\b"),
    TOKENORDERFEEDBACK ("2", "\\bTokenOrder.*xml\\b"),
    TOKENIMPORTFEEDBACK ("1", "\\bTokenImport.*xml\\b"),
    TOKENDATAEXTRACT("8", "\\bdbexp_Token_file_dataextraction.*xml\\b"),
    TOKENAPPLICATIONDATAEXTRACT("11", "\\bdbexp_TokenApplication_file_dataextraction.*xml\\b"),
    PINMAILER ("3", "\\bPINMailer.*xml\\b"),
    PINDATAEXTRACT ("9", "\\bdbexp_PIN_file_dataextraction.*xml\\b"),
    PINSMSDATAEXTRACT ("17", "\\bdbexp_PinSMSDataExtract_file_dataextraction.*xml\\b"),
    TRANSACTIONLOGDATAEXTRACT ("14", "\\bdbexp_TransactionLog_file_dataextraction.*xml\\b"),
    TRANSLATEPANIDDATAEXTRACT("19","\\bdbexp_TranslatePanIdDataExtract_file_dataextraction.*xml\\b"),
    VPPDATAEXTRACT("18","\\bdbexp_VPPDataExtract_file_dataextraction.*xml\\b");

    private final String extractTypeId;
    private final String fileRegex;

    public String getExtractTypeId()
    {
        return extractTypeId;
    }

    public String getFileRegex()
    {
        return fileRegex;
    }

    ExtractTypes(String extractTypeId, String fileRegex)
    {
        this.extractTypeId = extractTypeId;
        this.fileRegex = fileRegex;
    }
}