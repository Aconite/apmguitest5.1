package com.aconite.apm.gui.automation.enums;

public enum ScheduledTaskNames
{
    ACCESSLOGDATAEXTRACT  ("accesslogdataextract", false),
    HOUSEKEEPER  ("housekeeper", false),
    PINDATAEXTRACT ("pindataextract", false),
    PINMAILER ("pinmailer", true),
    PINSMS ("pinsms", true),
    PINSMSDATAEXTRACT ("pinsmsdataextract", false),
    TOKENAPPLICATIONDATAEXTRACT ("tokenapplicationdataextract", false),
    TOKENDATAEXTRACT ("tokendataextract", false),
    TOKENDELETE ("tokendelete", true),
    TOKENIMPORTFEEDBACK ("tokenimportfeedback", true),
    TOKENORDERFEEDBACK ("tokenorderfeedback", true),
    TRANSACTIONLOGDATAEXTRACT ("transactionlogdataextract", false),
    TRANSLATEPANIDDATAEXTRACT ("translatepaniddataextract", false),
    VPPDATAEXTRACT ("vppdataextract", false);


    private final String taskNameStr;
    private final boolean issuerRequired;

    ScheduledTaskNames(String taskNameStr, boolean issuerRequired)
    {
        this.taskNameStr = taskNameStr;
        this.issuerRequired = issuerRequired;
    }


    public boolean isIssuerRequired()
    {
        return issuerRequired;
    }

    @Override
    public String toString()
    {
        return taskNameStr;
    }
}
