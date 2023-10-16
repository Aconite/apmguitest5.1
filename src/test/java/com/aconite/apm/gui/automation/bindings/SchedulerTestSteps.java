package com.aconite.apm.gui.automation.bindings;

import com.aconite.apm.gui.automation.databasegathers.*;
import com.aconite.apm.gui.automation.dataload.DataLoadPinDataExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadPinMailer;
import com.aconite.apm.gui.automation.dataload.DataLoadPinSmsDataExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadTokenApplicationDataExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadTokenImportFeedback;
import com.aconite.apm.gui.automation.dataload.DataLoadTranslatePanIdExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadVppDataExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadTransactionLogDataExtract;
import com.aconite.apm.gui.automation.dataload.DataLoadHousekeeperCardHolderDataUpdate;
import com.aconite.apm.gui.automation.dataload.DataLoadHousekeeperExpiredVppPinIds;
import com.aconite.apm.gui.automation.dataload.DataLoadHousekeeperExtractLogsCleanUp;
import com.aconite.apm.gui.automation.dataload.DataLoadHousekeeperTokenCleanUp;
import com.aconite.apm.gui.automation.dataload.DataLoadHousekeeperUnusedPinPasswordCleanUp;
import com.aconite.apm.gui.automation.dataload.datagatherers.DataLoadDataGatherer;
import com.aconite.apm.gui.automation.enums.ScheduledTaskNames;
import com.aconite.apm.gui.automation.enums.ExtractTypes;
import com.aconite.apm.gui.automation.outputfilesplitters.AccessLogFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.PinDataFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.PinMailerFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.PinSMSDataExtractFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TokenDataFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TokenImportFeedbackFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TokenOrderFeedbackFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TokenApplicationDataFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TransactionLogDataExtractFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.TranslatePanIdDataExtractFileSplitter;
import com.aconite.apm.gui.automation.outputfilesplitters.VppDataExtractFileSplitter;
import com.aconite.apm.gui.automation.records.AccessLogDataExtractRecord;
import com.aconite.apm.gui.automation.records.HousekeeperCardHolderDataUpdateRecord;
import com.aconite.apm.gui.automation.records.PinDataRecord;
import com.aconite.apm.gui.automation.records.PinMailerRecord;
import com.aconite.apm.gui.automation.records.PinSMSDataExtractRecord;
import com.aconite.apm.gui.automation.records.TaskSchedulerTableDataRecord;
import com.aconite.apm.gui.automation.records.TokenApplicationDataRecord;
import com.aconite.apm.gui.automation.records.TokenDataRecord;
import com.aconite.apm.gui.automation.records.TokenImportFeedbackRecord;
import com.aconite.apm.gui.automation.records.TokenOrderFeedbackRecord;
import com.aconite.apm.gui.automation.records.TransactionLogDataExtractRecord;
import com.aconite.apm.gui.automation.records.TranslatePanIdDataExtractRecord;
import com.aconite.apm.gui.automation.records.VppDataExtractRecord;
import com.aconite.apm.gui.automation.uidatagatherers.TaskSchedulerTableDataGatherer;
import com.aconite.apm.gui.automation.utilities.HousekeeperUtils;
import com.aconite.apm.gui.automation.utilities.SFTPFileRetriever;
import com.aconite.apm.gui.automation.utilities.ConfigUtils;
import com.aconite.apm.gui.automation.webpages.HomePage;
import com.aconite.apm.gui.automation.webpages.LoginPage;
import com.aconite.apm.gui.automation.webpages.TaskSchedulerPage;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SchedulerTestSteps
{
    public WebDriver webDriver;
    public SoftAssert softAssert = new SoftAssert();

    int lastRunToId=0;
    String lastRunTime = null;
    AccessLogDatabaseGatherer accessLogDatabaseGatherer;
    AccessLogDatabaseGatherer accessLogHousekeeperExp;
    AccessLogDatabaseGatherer accessLogHousekeeperAct;
    int accessLogHousekeeperCurrentRows1=0;
    int accessLogHousekeeperCurrentRows2=0;
    ExtractLogDataGatherer extractLogHousekeeperExp;
    ExtractLogDataGatherer extractLogHousekeeperAct;
    int extractLogHousekeeperCurrentRows1=0;
    int extractLogHousekeeperCurrentRows2=0;
    HousekeeperTokenCleanUpDatabaseGatherer tokenCleanUpLogHousekeeperExp;
    HousekeeperTokenCleanUpDatabaseGatherer tokenCleanUpLogHousekeeperAct;
    int tokenCleanUpHousekeeperCurrentRows1=0;
    int tokenCleanUpHousekeeperCurrentRows2=0;
    PinDataDatabaseGatherer pinsmspwdCleanUpLogHousekeeperExp;
    PinDataDatabaseGatherer pinsmspwdCleanUpLogHousekeeperAct;
    int pinsmspwdCleanUpHousekeeperCurrentRows1=0;
    int pinsmspwdCleanUpHousekeeperCurrentRows2=0;
    HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp;
    HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct;
    int housekeeperVppClearExpiredVPPPinIdsCurrentRows1=0;
    int housekeeperVppClearExpiredVPPPinIdsCurrentRows2=0;
    HousekeeperCardHolderDataUpdateDatabaseGatherer housekeeperCardHolderDataUpdateDatabaseGathererExp;
    HousekeeperCardHolderDataUpdateDatabaseGatherer housekeeperCardHolderDataUpdateDatabaseGathererAct;
    AccessLogFileSplitter accessLogFileSplitter;
    PinDataDatabaseGatherer pinDataDatabaseGatherer;
    PinDataFileSplitter pinDataFileSplitter;
    PinMailerDatabaseGatherer pinMailerDatabaseGatherer;
    PinMailerFileSplitter pinMailerFileSplitter;
    PinSMSDataExtractDatabaseGatherer pinSMSDataExtractDatabaseGatherer;
    PinSMSDataExtractFileSplitter pinSMSDataExtractFileSplitter;
    TokenDataDatabaseGatherer tokenDataDatabaseGatherer;
    TokenDataFileSplitter tokenDataFileSplitter;
    TokenApplicationDataDatabaseGatherer tokenApplicationDataDatabaseGatherer;
    TokenApplicationDataFileSplitter tokenApplicationDataFileSplitter;
    TransactionLogDataExtractDatabaseGatherer transactionLogDataExtractDatabaseGatherer;
    HousekeeperTransactionHistoryCleanUpDatabaseGatherer housekeeperTransactionHistoryCleanUpDatabaseGathererExp;
    HousekeeperTransactionHistoryCleanUpDatabaseGatherer housekeeperTransactionHistoryCleanUpDatabaseGathererAct;
    int transactionLogHousekeeperCurrentRows1 = 0;
    int transactionLogHousekeeperCurrentRows2 = 0;
    TransactionLogDataExtractFileSplitter transactionLogDataExtractFileSplitter;
    TranslatePanIdDataExtractDatabaseGatherer translatePanIdDataExtractDatabaseGatherer;
    TranslatePanIdDataExtractFileSplitter translatePanIdDataExtractFileSplitter;
    VppDataExtractDatabaseGatherer vppDataExtractDatabaseGatherer;
    VppDataExtractFileSplitter vppDataExtractFileSplitter;
    TokenImportDatabaseGatherer tokenImportDatabaseGatherer;
    TokenImportFeedbackFileSplitter tokenImportFeedbackFileSplitter;
    TokenOrderFeedbackDatabaseGatherer tokenOrderFeedbackDatabaseGatherer;
    TokenOrderFeedbackFileSplitter tokenOrderFeedbackFileSplitter;
    TaskSchedulerTableDataRecord newTask;

    List<String> housekeeperTasks;
    String outputFilePath;
    String createDataMsg;
    boolean scenarioFail = false;
    String housekeeperCardHolderDataUpdateRows = "";
    String housekeeperUnusedPins = "";

    String delFileName = "";
    String movFileName = "";

    private AbsractSteps absractSteps;

    TaskSchedulerPage taskSchedulerPage = null;

    private String getDateTimeString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar mydate = Calendar.getInstance();
        mydate.setTime(Calendar.getInstance().getTime());
        return dateFormat.format(mydate.getTime());
    }

    private String passMessage(String msg){

        return("<font color=\"green\"><b>" + msg + "</b></font>");

    }

    private String failMessage(String msg){

        return("<font color=\"red\"><b>" + msg + "</b></font>");

    }

    private String warnMessage(String msg){

        return("<font color=\"chocolate\"><b>" + msg + "</b></font>");

    }

    public SchedulerTestSteps(AbsractSteps absractSteps)
    {
        try {
            this.absractSteps = absractSteps;
            this.webDriver = absractSteps.getDriver();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }


    @Given("I am logged in and on the scheduler page")
    public void i_am_logged_in_and_on_the_scheduler_page()
    {
        try {
            AbsractSteps.myScenario.log("About to create Login. Webdriver is: " + webDriver);
            LoginPage loginPage = new LoginPage(absractSteps.getBaseUrl(), webDriver);
            AbsractSteps.myScenario.log("About to Login: " + absractSteps.getUsername() + "/" + absractSteps.getPassword());
            loginPage.login(absractSteps.getUsername(), absractSteps.getPassword());

            HomePage homePage = new HomePage(absractSteps.getDriver());
            homePage.clickOnTaskSchedulerMenuItem();

            taskSchedulerPage = new TaskSchedulerPage(absractSteps.getDriver());
            taskSchedulerPage.isPageOpened();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

    }

    @Then("I create data for the {word} extract")
    public void create_data(String word) throws Exception{

        AbsractSteps.myScenario.log("<b>Data Creation</b>");

        switch (word){

            case "pindataextract":
                createDataMsg = "";
                createDataMsg = DataLoadPinDataExtract.runDataLoadPinDataExtract();
                break;

            case "pinmailer":
                createDataMsg = "";
                createDataMsg = DataLoadPinMailer.runDataLoadPinMailer();
                break;

            case "pinsms":
                createDataMsg = "";
                createDataMsg = DataLoadPinSmsDataExtract.runDataLoadPinSmsDataExtract();
                break;

            case "pinsmsdataextract":
                createDataMsg = "";
                break;

            case "tokenapplicationdataextract":
            case "tokenorderfeedback":
            case "tokendataextract":
                createDataMsg = "";
                createDataMsg = DataLoadTokenApplicationDataExtract.runDataLoadTokenApplicationDataExtract();
                break;

            case "tokenimportfeedback":
                createDataMsg = "";
                createDataMsg = DataLoadTokenImportFeedback.runDataLoadTokenImportFeedback(); // should be iterated
                break;

            case "transactionlogdataextract":
                createDataMsg = "";
                createDataMsg = DataLoadPinDataExtract.runDataLoadPinDataExtract();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadPinMailer.runDataLoadPinMailer();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadPinSmsDataExtract.runDataLoadPinSmsDataExtract();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadTokenApplicationDataExtract.runDataLoadTokenApplicationDataExtract();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadTokenImportFeedback.runDataLoadTokenImportFeedback(); //should be iterated
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadTranslatePanIdExtract.runDataLoadTranslatePanIdExtract();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadVppDataExtract.runDataLoadVppDataExtract();
                AbsractSteps.myScenario.log(createDataMsg);

                createDataMsg = "";
                createDataMsg = DataLoadTransactionLogDataExtract.runDataLoadTransactionLogDataExtract();
                break;

            case "translatepaniddataextract":
                createDataMsg = "";
                createDataMsg = DataLoadTranslatePanIdExtract.runDataLoadTranslatePanIdExtract();
                break;

            case "vppdataextract":
                createDataMsg = "";
                createDataMsg = DataLoadVppDataExtract.runDataLoadVppDataExtract();
                break;

        }

        AbsractSteps.myScenario.log(createDataMsg);

    }


    /*******************************************************************************************************************
     * Creating Expected Results for Housekeeper Scheduled Task
     ******************************************************************************************************************/
    @Then("I create my expected results")
    public void getExpectedResultsForHousekeeper() throws Exception {

        String hTaskName;
        String hTaskParam = "";

        housekeeperTasks = HousekeeperUtils.getHousekeeperTaskList();

        for (Object hTask : housekeeperTasks){

            String hTaskString = hTask.toString();

            if (hTaskString.contains("(")){
                String[] hTaskDetail = hTaskString.split("\\(");
                hTaskName = hTaskDetail[0];
                hTaskParam = hTaskDetail[1].replace(")", "");
                }
            else{
                hTaskName = hTaskString;
            }

            switch(hTaskName){

                case "cardHolderDataUpdate":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - cardHolderDataUpdate");

                    createDataMsg = "";
                    createDataMsg = DataLoadHousekeeperCardHolderDataUpdate.runDataLoadHousekeeperCardHolderDataUpdate();

                    housekeeperCardHolderDataUpdateDatabaseGathererExp = new HousekeeperCardHolderDataUpdateDatabaseGatherer();
                    housekeeperCardHolderDataUpdateDatabaseGathererExp.gatherDataForHousekeeper();
//                    housekeeperCardHolderDataUpdateDatabaseGathererExp.printRecords();
                    housekeeperCardHolderDataUpdateRows = housekeeperCardHolderDataUpdateDatabaseGathererExp.selectedIds;
                    AbsractSteps.myScenario.log(createDataMsg);
                    AbsractSteps.myScenario.log("ID String: " + housekeeperCardHolderDataUpdateRows);

                    break;

                case "clearExpiredVPPPinIds":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - clearExpiredVPPPinIds");

                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp = new HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer();
                    housekeeperVppClearExpiredVPPPinIdsCurrentRows1 = housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp.getRowCountForHousekeeper();

                    createDataMsg = "";
                    createDataMsg = DataLoadHousekeeperExpiredVppPinIds.runDataLoadHousekeeperExpiredVppPinIds();

                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp.gatherDataForHousekeeper();
//                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp.printRecords();

                    break;

                case "expiredKeysNotification":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - expiredKeysNotification");

                    boolean rc = DataLoadDataGatherer.dataloadCheckTestKeyExists();
                    if(rc){
                        DataLoadDataGatherer.dataloadUpdateKeyExpiryDate();
                    }
                    else{
                        DataLoadDataGatherer.dataloadInsertKey();
                    }

                    break;

                case "extractLogsCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - extractLogsCleanUp");

                    extractLogHousekeeperExp = new ExtractLogDataGatherer();
                    extractLogHousekeeperCurrentRows1 = extractLogHousekeeperExp.getRowCountForHousekeeper();

                    createDataMsg = "";
                    createDataMsg = DataLoadHousekeeperExtractLogsCleanUp.runDataLoadHousekeeperExtractLogsCleanUp();


                    extractLogHousekeeperExp.gatherDataForHousekeeper(hTaskParam);
//                    extractLogHousekeeperExp.printRecords();
                    break;

                case "filesCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - filesCleanUp");

                    String remoteFilePath;

                    outputFilePath = ConfigUtils.cfgProperty("local_folder");
                    remoteFilePath = ConfigUtils.cfgProperty("extractlog_filepath");

                    /* Create files to be uploaded in the local folder */
                    delFileName = "fileCleanUpTestDelete_" + getDateTimeString() + ".djr";
                    File myDjr = new File(outputFilePath + "\\" + delFileName);
                    boolean rc1 = myDjr.createNewFile();
                    movFileName = "fileCleanUpTestMove_" + getDateTimeString() + ".aco";
                    File myAco = new File(outputFilePath + "\\" + movFileName);
                    boolean rc2 = myAco.createNewFile();

                    if(rc1 && rc2){
                        AbsractSteps.myScenario.log("Files for Housekeeper Scheduled Task - filesCleanUp created successfully.");
                    }

                    try {
                        Thread.sleep(5000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    SFTPFileRetriever.uploadFile("/" + remoteFilePath + "/" + delFileName, outputFilePath + "\\" + delFileName);
                    SFTPFileRetriever.uploadFile("/" + remoteFilePath + "/" + movFileName, outputFilePath + "\\" + movFileName);

                    break;

                case "tokenCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - tokenCleanUp");

                    tokenCleanUpLogHousekeeperExp = new HousekeeperTokenCleanUpDatabaseGatherer();
                    tokenCleanUpHousekeeperCurrentRows1 = tokenCleanUpLogHousekeeperExp.getRowCountForHousekeeper();

                    createDataMsg = "";
                    createDataMsg = DataLoadHousekeeperTokenCleanUp.runDataLoadHousekeeperTokenCleanUp();

                    tokenCleanUpLogHousekeeperExp.gatherDataForHousekeeper();
//                    tokenCleanUpLogHousekeeperExp.printRecords();

                    break;

                case "transactionHistoryCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - transactionHistoryCleanUp");

                    housekeeperTransactionHistoryCleanUpDatabaseGathererExp = new HousekeeperTransactionHistoryCleanUpDatabaseGatherer();
                    transactionLogHousekeeperCurrentRows1 = housekeeperTransactionHistoryCleanUpDatabaseGathererExp.getRowCountForHousekeeper();

                    DataLoadDataGatherer.dataloadModifyDatesForTransactionCleanUp();

                    housekeeperTransactionHistoryCleanUpDatabaseGathererExp.gatherDataForHousekeeper();
//                    housekeeperTransactionHistoryCleanUpDatabaseGathererExp.printRecords();

                    break;

                case "unusedPinPasswordCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - unusedPinPasswordCleanUp");

                    pinsmspwdCleanUpLogHousekeeperExp = new PinDataDatabaseGatherer();
                    pinsmspwdCleanUpHousekeeperCurrentRows1 = pinsmspwdCleanUpLogHousekeeperExp.getRowCountForHousekeeper();

                    createDataMsg = "";
                    createDataMsg = DataLoadHousekeeperUnusedPinPasswordCleanUp.runDataLoadHousekeeperUnusedPinPasswordCleanUp();

                    pinsmspwdCleanUpLogHousekeeperExp.gatherDataForHousekeeper();
//                    pinsmspwdCleanUpLogHousekeeperExp.printRecords();
                    housekeeperUnusedPins = pinsmspwdCleanUpLogHousekeeperExp.createdPins;
                    AbsractSteps.myScenario.log(createDataMsg);
                    AbsractSteps.myScenario.log("ID String: " + housekeeperUnusedPins);

                    break;

                case "userAccessLogsCleanUp":

                    AbsractSteps.myScenario.log("Creating Expected Results for Housekeeper Scheduled Task - userAccessLogsCleanUp");

                    accessLogHousekeeperExp = new AccessLogDatabaseGatherer();
                    accessLogHousekeeperCurrentRows1 = accessLogHousekeeperExp.getRowCountForHousekeeper();

                    DataLoadDataGatherer.dataloadModifyDatesForUserAccessLogsCleanUp();

                    accessLogHousekeeperExp.gatherDataForHousekeeper(hTaskParam);
//                    accessLogHousekeeperExp.printRecords();
                    break;

            }

        }

    }

    /*******************************************************************************************************************
     * Creating Actual Results for Housekeeper Scheduled Task
     ******************************************************************************************************************/
    @Then("I create my actual results")
    public void getActualResultsForHousekeeper() throws SftpException, JSchException {

        String hTaskName;
        String hTaskParam = "";

        housekeeperTasks = HousekeeperUtils.getHousekeeperTaskList();

        for (Object hTask : housekeeperTasks){

            String hTaskString = hTask.toString();

            if (hTaskString.contains("(")){
                String[] hTaskDetail = hTaskString.split("\\(");
                hTaskName = hTaskDetail[0];
                hTaskParam = hTaskDetail[1].replace(")", "");
            }
            else{
                hTaskName = hTaskString;
            }

            switch(hTaskName){

                case "cardHolderDataUpdate":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - cardHolderDataUpdate");

                    housekeeperCardHolderDataUpdateDatabaseGathererAct = new HousekeeperCardHolderDataUpdateDatabaseGatherer();
                    housekeeperCardHolderDataUpdateDatabaseGathererAct.gatherDataForHousekeeperActual(housekeeperCardHolderDataUpdateRows);
//                    housekeeperCardHolderDataUpdateDatabaseGathererAct.printRecords();
                    AbsractSteps.myScenario.log(housekeeperCardHolderDataUpdateDatabaseGathererAct.records.toString());

                    break;

                case "clearExpiredVPPPinIds":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - clearExpiredVPPPinIds");

                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct = new HousekeeperVppClearExpiredVPPPinIdsDatabaseGatherer();
                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct.gatherDataForHousekeeper();
//                    housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct.printRecords();

                    break;

                case "extractLogsCleanUp":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - extractLogsCleanUp");

                    extractLogHousekeeperAct = new ExtractLogDataGatherer();
                    extractLogHousekeeperAct.gatherDataForHousekeeper(hTaskParam);
//                    extractLogHousekeeperAct.printRecords();

                    break;

                case "tokenCleanUp":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - tokenCleanUp");

                    tokenCleanUpLogHousekeeperAct = new HousekeeperTokenCleanUpDatabaseGatherer();
                    tokenCleanUpLogHousekeeperAct.gatherDataForHousekeeper();
//                    tokenCleanUpLogHousekeeperAct.printRecords();

                    break;

                case "transactionHistoryCleanUp":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - transactionHistoryCleanUp");

                    housekeeperTransactionHistoryCleanUpDatabaseGathererAct = new HousekeeperTransactionHistoryCleanUpDatabaseGatherer();
                    housekeeperTransactionHistoryCleanUpDatabaseGathererAct.gatherDataForHousekeeper();
//                    housekeeperTransactionHistoryCleanUpDatabaseGathererAct.printRecords();

                    break;

                case "unusedPinPasswordCleanUp":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - unusedPinPasswordCleanUp");

                    pinsmspwdCleanUpLogHousekeeperAct = new PinDataDatabaseGatherer();
                    pinsmspwdCleanUpLogHousekeeperAct.gatherDataForHousekeeper();
//                    pinsmspwdCleanUpLogHousekeeperAct.printRecords();
                    AbsractSteps.myScenario.log(pinsmspwdCleanUpLogHousekeeperAct.records.toString());

                    break;

                case "userAccessLogsCleanUp":

                    AbsractSteps.myScenario.log("Creating Actual Results for Housekeeper Scheduled Task - userAccessLogsCleanUp");

                    accessLogHousekeeperAct = new AccessLogDatabaseGatherer();
                    accessLogHousekeeperAct.gatherDataForHousekeeper(hTaskParam);
//                    accessLogHousekeeperAct.printRecords();
                    break;

            }
        }
    }



    /*******************************************************************************************************************
     * Adding the Task
     * Parameter: word
     ******************************************************************************************************************/
    @When("I add a new daily {word} task")
    public void i_add_a_new_daily_task(String word)
    {
        ScheduledTaskNames taskName = null;

        switch (word){

            case "accesslogdataextract":
                taskName = ScheduledTaskNames.ACCESSLOGDATAEXTRACT;
                accessLogDatabaseGatherer = new AccessLogDatabaseGatherer();
                break;

            case "housekeeper":
                taskName = ScheduledTaskNames.HOUSEKEEPER;
                break;

            case "pindataextract":
                taskName = ScheduledTaskNames.PINDATAEXTRACT;
                lastRunTime = ExtractLogDataGatherer.getLastSuccessfulRunEndTime(ExtractTypes.PINDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records after " + lastRunTime);
                break;

            case "pinmailer":
                taskName = ScheduledTaskNames.PINMAILER;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.PINMAILER);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "pinsms":
                taskName = ScheduledTaskNames.PINSMS;
                break;

            case "pinsmsdataextract":
                taskName = ScheduledTaskNames.PINSMSDATAEXTRACT;
                lastRunTime = ExtractLogDataGatherer.getLastSuccessfulRunEndTime(ExtractTypes.PINSMSDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records since " + lastRunTime);
                break;

            case "tokenapplicationdataextract":
                taskName = ScheduledTaskNames.TOKENAPPLICATIONDATAEXTRACT;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.TOKENAPPLICATIONDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "tokendataextract":
                taskName = ScheduledTaskNames.TOKENDATAEXTRACT;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.TOKENDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "tokenimportfeedback":
                taskName = ScheduledTaskNames.TOKENIMPORTFEEDBACK;
                lastRunTime = ExtractLogDataGatherer.getLastSuccessfulRunEndTime(ExtractTypes.TOKENIMPORTFEEDBACK);
                AbsractSteps.myScenario.log(taskName + " database to extract records since " + lastRunTime);
                break;

            case "tokenorderfeedback":
                taskName = ScheduledTaskNames.TOKENORDERFEEDBACK;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.TOKENORDERFEEDBACK);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "transactionlogdataextract":
                taskName = ScheduledTaskNames.TRANSACTIONLOGDATAEXTRACT;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.TRANSACTIONLOGDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "translatepaniddataextract":
                taskName = ScheduledTaskNames.TRANSLATEPANIDDATAEXTRACT;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.TRANSLATEPANIDDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            case "vppdataextract":
                taskName = ScheduledTaskNames.VPPDATAEXTRACT;
                lastRunToId = ExtractLogDataGatherer.getLastSuccessfulRunToId(ExtractTypes.VPPDATAEXTRACT);
                AbsractSteps.myScenario.log(taskName + " database to extract records > " + lastRunToId);
                break;

            default:
                softAssert.fail("No valid task name found in Add Task.");

        }

        TaskSchedulerTableDataGatherer taskSchedulerTableDataGathererBefore = new TaskSchedulerTableDataGatherer(webDriver);
        taskSchedulerTableDataGathererBefore.gatherData();
//        taskSchedulerTableDataGathererBefore.printRecords();

        taskSchedulerPage.addNewDailyTask(taskName, true, "ABCBank");

        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        TaskSchedulerTableDataGatherer taskSchedulerTableDataGathererAfter = new TaskSchedulerTableDataGatherer(webDriver);
        taskSchedulerTableDataGathererAfter.gatherData();
        newTask = taskSchedulerPage.getTaskAdded(taskSchedulerTableDataGathererBefore, taskSchedulerTableDataGathererAfter);

        if(newTask!=null && !newTask.getId().equals("") && newTask.getId() != null)
        {
            AbsractSteps.myScenario.log(passMessage("ADD TASK: New " + taskName + " job added - TaskID = " +  newTask.getId()));
        }
        else
        {
//            AbsractSteps.myScenario.log(failMessage("ADD TASK: New " + taskName + " FAILED"));
//            AbsractSteps.myScenario.log(failMessage("ADD TASK: dataBefore " + taskSchedulerTableDataGathererBefore ));
//            AbsractSteps.myScenario.log(failMessage("ADD TASK: dataAfter " + taskSchedulerTableDataGathererAfter ));

            softAssert.fail("ADD TASK: New " + taskName + " FAILED" +
                    "\nADD TASK: dataBefore " + taskSchedulerTableDataGathererBefore +
                    "\nADD TASK: dataAfter " + taskSchedulerTableDataGathererAfter);
        }

    }


    /*******************************************************************************************************************
     * Running the Task
     * Parameter: word
     ******************************************************************************************************************/

    @When("I run a {word} task")
    public void i_run_a_Task(String word)
    {
        ScheduledTaskNames taskName = null;
        TaskSchedulerTableDataGatherer taskSchedulerTableDataGathererAfter = new TaskSchedulerTableDataGatherer(webDriver);

        switch (word){

            case "accesslogdataextract":
                taskName = ScheduledTaskNames.ACCESSLOGDATAEXTRACT;
                break;

            case "housekeeper":
                taskName = ScheduledTaskNames.HOUSEKEEPER;
                break;

            case "pindataextract":
                taskName = ScheduledTaskNames.PINDATAEXTRACT;
                break;

            case "pinmailer":
                taskName = ScheduledTaskNames.PINMAILER;
                break;

            case "pinsms":
                taskName = ScheduledTaskNames.PINSMS;
                break;

            case "pinsmsdataextract":
                taskName = ScheduledTaskNames.PINSMSDATAEXTRACT;
                break;

            case "tokenapplicationdataextract":
                taskName = ScheduledTaskNames.TOKENAPPLICATIONDATAEXTRACT;
                break;

            case "tokendataextract":
                taskName = ScheduledTaskNames.TOKENDATAEXTRACT;
                break;

            case "tokenimportfeedback":
                taskName = ScheduledTaskNames.TOKENIMPORTFEEDBACK;
                break;

            case "tokenorderfeedback":
                taskName = ScheduledTaskNames.TOKENORDERFEEDBACK;
                break;

            case "transactionlogdataextract":
                taskName = ScheduledTaskNames.TRANSACTIONLOGDATAEXTRACT;
                break;

            case "translatepaniddataextract":
                taskName = ScheduledTaskNames.TRANSLATEPANIDDATAEXTRACT;
                break;

            case "vppdataextract":
                taskName = ScheduledTaskNames.VPPDATAEXTRACT;
                break;

        }
        String lastRun;

        int refreshCount = 0;
        do {
            webDriver.navigate().refresh();
            String thisTaskId = newTask.getId();

            //Check if the task has already run
            taskSchedulerTableDataGathererAfter.gatherData();
            newTask = taskSchedulerPage.updateTaskRecordById(thisTaskId, taskSchedulerTableDataGathererAfter);
            lastRun = newTask.getLastRun();
            refreshCount += 1;

            AbsractSteps.myScenario.log("RUN TASK: " + newTask.getId() + "\nREFRESH COUNT: " + refreshCount + "\nLAST RUN VALUE: " +  lastRun);
            AbsractSteps.myScenario.log(taskSchedulerTableDataGathererAfter.toString());

            try {
                Thread.sleep(10000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }while((lastRun.equals("") || lastRun.equals("-")) && refreshCount < 10);

        if(!lastRun.equals("") && !lastRun.equals("-"))
        {
            AbsractSteps.myScenario.log(passMessage("RUN TASK: " + taskName.toString() + " job run at " +  lastRun));
        }
        else
        {
            AbsractSteps.myScenario.log("RUN TASK: " + taskName.toString() + " job did not run automatically after creation");
        }

        if (lastRun.equals("") || lastRun.equals("-")){

            taskSchedulerPage.clickOnRun(taskName, newTask.getId());

        }

    }

    /*******************************************************************************************************************
     * Checking the Task
     * Parameter: word
     ******************************************************************************************************************/
    @Then("the {word} task runs successfully and the output is correct")
    public void the_Task_Runs_Successfully_And_The_OutputIsCorrect(String word) throws Exception
    {
        String output;
        ScheduledTaskNames taskName;

        switch (word){

            case "accesslogdataextract":

                taskName = ScheduledTaskNames.ACCESSLOGDATAEXTRACT;
                accessLogFileSplitter = new AccessLogFileSplitter();

                Thread.sleep(10000);

                accessLogFileSplitter.splitFileInRecords();
//                accessLogFileSplitter.printRecords();

                accessLogDatabaseGatherer.gatherData();
//                accessLogDatabaseGatherer.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + accessLogDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(accessLogDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + accessLogFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + accessLogFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(accessLogFileSplitter.records.toString());

                if(accessLogDatabaseGatherer.getRecordCount() != accessLogFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            accessLogDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + accessLogFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(accessLogDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Access Log Data Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Access Log Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (AccessLogDataExtractRecord temp : accessLogDatabaseGatherer.records) {
                    if(accessLogFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Access Log Data Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Access Log Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Access Log Data Extract.");
                    }
                }

                break;

            case "housekeeper":

                String hTaskName;
                String hTaskParam = "";

                housekeeperTasks = HousekeeperUtils.getHousekeeperTaskList();

                for (Object hTask : housekeeperTasks) {

                    String hTaskString = hTask.toString();

                    if (hTaskString.contains("(")) {
                        String[] hTaskDetail = hTaskString.split("\\(");
                        hTaskName = hTaskDetail[0];
                        hTaskParam = hTaskDetail[1].replace(")", "");
                    } else {
                        hTaskName = hTaskString;
                    }

                    switch (hTaskName) {

                        case "cardHolderDataUpdate":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - cardHolderDataUpdate");


                            for (HousekeeperCardHolderDataUpdateRecord expTemp : housekeeperCardHolderDataUpdateDatabaseGathererExp.records) {

                                String expId = expTemp.getId();

                                for (HousekeeperCardHolderDataUpdateRecord actTemp : housekeeperCardHolderDataUpdateDatabaseGathererAct.records) {

                                    String actId = actTemp.getId();

                                    if(expId.equals(actId)){

                                        AbsractSteps.myScenario.log("cardHolderDataUpdate: Checking " + expId);
                                        output = "";
                                        output = output + "Record: [ID=" + expId;

                                        if(expTemp.getTrxTypeId().equals(actTemp.getTrxTypeId())){
                                            output = output + ", TRXTYPEID=" + expTemp.getTrxTypeId();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - TRXTYPEID\n" +
                                                    expTemp + "\nDatabase Record After - TRXTYPEID\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        /* Special Case - Actual transaction status should be 5 - Purged */
                                        if(actTemp.getTrxStatus().equals("5")){
                                            output = output + ", TRXSTATUS=" + actTemp.getTrxStatus();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - TRXSTATUS\n" +
                                                    expTemp + "\nDatabase Record After - TRXSTATUS\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getSystemDateTime().equals(actTemp.getSystemDateTime())){
                                            output = output + ", SYSTEMDATETIME=" + expTemp.getSystemDateTime();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - SYSTEMDATETIME\n" +
                                                    expTemp + "\nDatabase Record After - SYSTEMDATETIME\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqDateTime().equals(actTemp.getReqDateTime())){
                                            output = output + ", REQDATETIME=" + expTemp.getReqDateTime();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQDATETIME\n" +
                                                    expTemp + "\nDatabase Record After - REQDATETIME\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqOrigId().equals(actTemp.getReqOrigId())){
                                            output = output + ", REQORIGID=" + expTemp.getReqOrigId();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQORIGID\n" +
                                                    expTemp + "\nDatabase Record After - REQORIGID\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqIssuerPinId().equals(actTemp.getReqIssuerPinId())){
                                            output = output + ", REQISSUERPINID=" + expTemp.getReqIssuerPinId();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQISSUERPINID\n" +
                                                    expTemp + "\nDatabase Record After - REQISSUERPINID\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPinExpiryDate().equals(actTemp.getReqPinExpiryDate())){
                                            output = output + ", REQPINEXPIRYDATE=" + expTemp.getReqPinExpiryDate();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPINEXPIRYDATE\n" +
                                                    expTemp + "\nDatabase Record After - REQPINEXPIRYDATE\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPinId().equals(actTemp.getReqPinId())){
                                            output = output + ", REQPINID=" + expTemp.getReqPinId();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPINID\n" +
                                                    expTemp + "\nDatabase Record After - REQPINID\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPanId().equals(actTemp.getReqPanId())){
                                            output = output + ", REQPANID=" + expTemp.getReqPanId();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPANID\n" +
                                                    expTemp + "\nDatabase Record After - REQPANID\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqIssuerPanAlias().equals(actTemp.getReqIssuerPanAlias())){
                                            output = output + ", REQISSUERPANALIAS=" + expTemp.getReqIssuerPanAlias();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQISSUERPANALIAS\n" +
                                                    expTemp + "\nDatabase Record After - REQISSUERPANALIAS\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPanSeqNumber().equals(actTemp.getReqPanSeqNumber())){
                                            output = output + ", REQPANSEQNUMBER=" + expTemp.getReqPanSeqNumber();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPANSEQNUMBER\n" +
                                                    expTemp + "\nDatabase Record After - REQPANSEQNUMBER\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPanExpiryDate().equals(actTemp.getReqPanExpiryDate())){
                                            output = output + ", REQPANEXPIRYDATE=" + expTemp.getReqPanExpiryDate();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPANEXPIRYDATE\n" +
                                                    expTemp + "\nDatabase Record After - REQPANEXPIRYDATE\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(expTemp.getReqPinDeliveryMethod().equals(actTemp.getReqPinDeliveryMethod())){
                                            output = output + ", REQPINDELIVERYMETHOD=" + expTemp.getReqPinDeliveryMethod();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record Before - REQPINDELIVERYMETHOD\n" +
                                                    expTemp + "\nDatabase Record After - REQPINDELIVERYMETHOD\n" +
                                                    actTemp));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqMobilePhone().equals(" ")){
                                            output = output + ", REQMOBILEPHONE=" + actTemp.getReqMobilePhone();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQMOBILEPHONE " + actTemp.getReqMobilePhone() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHTitle().equals(" ")){
                                            output = output + ", REQTHTITLE=" + actTemp.getReqTHTitle();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHTITLE " + actTemp.getReqTHTitle()+ " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHFirstName().equals(" ")){
                                            output = output + ", REQTHFIRSTNAME=" + actTemp.getReqTHFirstName();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHFIRSTNAME " + actTemp.getReqTHFirstName() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHMiddleName().equals(" ")){
                                            output = output + ", REQTHMIDDLENAME=" + actTemp.getReqTHMiddleName();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHMIDDLENAME " + actTemp.getReqTHMiddleName() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHLastName().equals(" ")){
                                            output = output + ", REQTHLASTNAME=" + actTemp.getReqTHLastName();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHLASTNAME " + actTemp.getReqTHLastName() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress1().equals(" ")){
                                            output = output + ", REQTHADDRESS1=" + actTemp.getReqTHAddress1();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS1 " + actTemp.getReqTHAddress1() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress2().equals(" ")){
                                            output = output + ", REQTHADDRESS2=" + actTemp.getReqTHAddress2();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS2 " + actTemp.getReqTHAddress2() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress3().equals(" ")){
                                            output = output + ", REQTHADDRESS3=" + actTemp.getReqTHAddress3();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS3 " + actTemp.getReqTHAddress3() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress4().equals(" ")){
                                            output = output + ", REQTHADDRESS4=" + actTemp.getReqTHAddress4();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS4 " + actTemp.getReqTHAddress4() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress5().equals(" ")){
                                            output = output + ", REQTHADDRESS5=" + actTemp.getReqTHAddress5();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS5 " + actTemp.getReqTHAddress5() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHAddress6().equals(" ")){
                                            output = output + ", REQTHADDRESS6=" + actTemp.getReqTHAddress6();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHADDRESS6 " + actTemp.getReqTHAddress6() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHTown().equals(" ")){
                                            output = output + ", REQTHTOWN=" + actTemp.getReqTHTown();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHTOWN " + actTemp.getReqTHTown() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHPostCode().equals(" ")){
                                            output = output + ", REQTHPOSTCODE=" + actTemp.getReqTHPostCode();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHPOSTCODE " + actTemp.getReqTHPostCode() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqTHCountryCode().equals(" ")){
                                            output = output + ", REQTHCOUNTRYCODE=" + actTemp.getReqTHCountryCode();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQTHCOUNTRYCODE " + actTemp.getReqTHCountryCode() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqCompanyName().equals(" ")){
                                            output = output + ", REQCOMPANYNAME=" + actTemp.getReqCompanyName();
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQCOMPANYNAME " + actTemp.getReqCompanyName() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if(actTemp.getReqCompanyContact().equals(" ")){
                                            output = output + ", REQCOMPANYCONTACT=" + actTemp.getReqCompanyContact() + "]";
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(failMessage(actTemp +
                                                    "\nREQCOMPANYCONTACT " + actTemp.getReqCompanyContact() + " should be null."));
                                            scenarioFail = true;
                                            break;
                                        }

                                        if (scenarioFail){
                                            softAssert.fail("Record in database:\n" + output +
                                                    "\n not  updated correctly by cardHolderDataUpdate housekeeper task.");
                                        }
                                        else{
                                            AbsractSteps.myScenario.log(passMessage("Record in database:\n" + output +
                                                    "\n correctly updated by cardHolderDataUpdate housekeeper task."));

                                        }

                                    }
                                }
                            }
                            break;

                        case "clearExpiredVPPPinIds":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - clearExpiredVPPPinIds");

                            AbsractSteps.myScenario.log("clearExpiredVPPPinIds: Data expected to be cleared");
                            AbsractSteps.myScenario.log(housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp.records.toString());
                            AbsractSteps.myScenario.log("clearExpiredVPPPinIds: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct.records.toString());

                            if(housekeeperVppClearExpiredVPPPinIdsDatabaseGathererAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All expired vpp pin ids have been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all expired vpp pin ids have been deleted successfully"));
                                softAssert.fail("Not all expired vpp pin ids have been deleted successfully");
                            }

                            housekeeperVppClearExpiredVPPPinIdsCurrentRows2 = housekeeperVppClearExpiredVPPPinIdsDatabaseGathererExp.getRowCountForHousekeeper();
                            if(extractLogHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in C_D_VPP_PIN_ID Table\n" +
                                        "There were " + extractLogHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

                            break;

                        case "expiredKeysNotification":

                            outputFilePath = ConfigUtils.cfgProperty("local_folder");

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - expiredKeysNotification");
                            String resfile = SFTPFileRetriever.downloadAndDeleteFile(ConfigUtils.cfgProperty("expiredkeys_filepath"), outputFilePath);

                            //Check contents of resfile
                            String outtext = null;
                            for(Scanner sc = new Scanner(new File(outputFilePath + "//" + resfile)); sc.hasNext(); ) {
                                String line = sc.nextLine();
                                outtext = outtext + line;
                            }

                            if(outtext.contains("Big Bank of Dave Message ZEK")) {
                                AbsractSteps.myScenario.log(passMessage("Checking " + outputFilePath + "\\" + resfile + " expiredKeysNotification found for: Big Bank of Dave Message ZEK"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Checking " + outputFilePath + "\\" + resfile + " expiredKeysNotification not found for: Big Bank of Dave Message ZEK"));
                                softAssert.fail("Checking " + outputFilePath + "\\" + resfile + " expiredKeysNotification not found for: Big Bank of Dave Message ZEK");
                            }

                            break;

                        case "extractLogsCleanUp":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - extractLogsCleanUp");

                            AbsractSteps.myScenario.log("extractLogsCleanUp: Data expected to be cleared");
                            AbsractSteps.myScenario.log(extractLogHousekeeperExp.records.toString());
                            AbsractSteps.myScenario.log("extractLogsCleanUp: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(extractLogHousekeeperAct.records.toString());

                            if(extractLogHousekeeperAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All extract logs older than " + hTaskParam + " days have been deleted successfully"));
                                               }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all extract logs older than " + hTaskParam + " days have been deleted successfully"));
                                softAssert.fail("Not all extract logs older than " + hTaskParam + " days have been deleted successfully");
                            }

                            int extractLogHousekeeperCurrentRows2 = extractLogHousekeeperExp.getRowCountForHousekeeper();
                            AbsractSteps.myScenario.log("Number of Rows in Extract Log = " + extractLogHousekeeperCurrentRows2);
                            if(extractLogHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in Extract Log\n" +
                                "There were " + extractLogHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

                            break;

                        case "filesCleanUp":

                            String remoteFilePath = ConfigUtils.cfgProperty("extractlog_filepath");
                            String remoteTmpFilePath = ConfigUtils.cfgProperty("tmp_filepath");

                            boolean delFile = SFTPFileRetriever.sftpFileExists(remoteFilePath, delFileName);
                            AbsractSteps.myScenario.log("Checking Results for deleted File - " + delFile);
                            if (!delFile){
                                AbsractSteps.myScenario.log(passMessage("File " + delFileName + " has been been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("File " + delFileName + " has been not been deleted successfully"));
                                softAssert.fail("File " + delFileName + " has been not been deleted successfully");
                            }

                            AbsractSteps.myScenario.log("Checking Results for moved File - " + remoteTmpFilePath + "/" + movFileName);
                            boolean moveFile = SFTPFileRetriever.sftpFileExists(remoteTmpFilePath, movFileName);
                            if(moveFile){
                                AbsractSteps.myScenario.log(passMessage("File " + movFileName + " has been been moved successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("File " + movFileName + " has been not been moved successfully"));
                                softAssert.fail("File " + movFileName + " has been not been moved successfully");

                            }

                            break;

                        case "tokenCleanUp":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - tokenCleanUp");

                            AbsractSteps.myScenario.log("tokenCleanUp: Data expected to be cleared");
                            AbsractSteps.myScenario.log(tokenCleanUpLogHousekeeperExp.records.toString());
                            AbsractSteps.myScenario.log("tokenCleanUp: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(tokenCleanUpLogHousekeeperAct.records.toString());

                            if(tokenCleanUpLogHousekeeperAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All tokens meeting criteria have been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all tokens meeting criteria have been deleted successfully"));
                                softAssert.fail("Not all tokens meeting criteria have been deleted successfully");

                            }

                            tokenCleanUpHousekeeperCurrentRows2 = tokenCleanUpLogHousekeeperExp.getRowCountForHousekeeper();
                            if(tokenCleanUpHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in C_D_TOKEN_APPLICATION table\n" +
                                        "There were " + tokenCleanUpHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

//                            TODO: Add further checks to ensure tokens and pins have been deleted form C_D_TOKEN and C_D_PIN

                            break;

                        case "transactionHistoryCleanUp":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - transactionHistoryCleanUp");

                            AbsractSteps.myScenario.log("transactionHistoryCleanUp: Data expected to be cleared");
                            AbsractSteps.myScenario.log(housekeeperTransactionHistoryCleanUpDatabaseGathererExp.records.toString());
                            AbsractSteps.myScenario.log("transactionHistoryCleanUp: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(housekeeperTransactionHistoryCleanUpDatabaseGathererAct.records.toString());

                            if(housekeeperTransactionHistoryCleanUpDatabaseGathererAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All transaction records meeting criteria have been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all transaction records meeting criteria have been deleted successfully"));
                                softAssert.fail("Not all transaction records meeting criteria have been deleted successfully");

                            }

                            transactionLogHousekeeperCurrentRows2 = housekeeperTransactionHistoryCleanUpDatabaseGathererExp.getRowCountForHousekeeper();
                            if(transactionLogHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in PM_D_TRX_LOG table\n" +
                                        "There were " + transactionLogHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

                            break;

                        case "unusedPinPasswordCleanUp":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - unusedPinPasswordCleanUp");

                            AbsractSteps.myScenario.log("unusedPinPasswordCleanUp: Data expected to be cleared");
                            AbsractSteps.myScenario.log(pinsmspwdCleanUpLogHousekeeperExp.records.toString());
                            AbsractSteps.myScenario.log("unusedPinPasswordCleanUp: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(pinsmspwdCleanUpLogHousekeeperAct.records.toString());

                            if(pinsmspwdCleanUpLogHousekeeperAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All unused pins meeting criteria have been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all unused pins meeting criteria have been deleted successfully"));
                                softAssert.fail("Not all unused pins meeting criteria have been deleted successfully");

                            }

                            pinsmspwdCleanUpHousekeeperCurrentRows2 = pinsmspwdCleanUpLogHousekeeperExp.getRowCountForHousekeeper();
                            if(transactionLogHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in C_D_PIN table\n" +
                                        "There were " + pinsmspwdCleanUpHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

//                            TODO: This only checks C_D_PIN - ensure SMS Password is tested when available

                            break;

                        case "userAccessLogsCleanUp":

                            AbsractSteps.myScenario.log("Checking Results for Housekeeper Scheduled Task - userAccessLogsCleanUp");

                            AbsractSteps.myScenario.log("userAccessLogsCleanUp: Data expected to be cleared");
                            AbsractSteps.myScenario.log(accessLogHousekeeperExp.records.toString());
                            AbsractSteps.myScenario.log("userAccessLogsCleanUp: Data remaining after housekeeper task");
                            AbsractSteps.myScenario.log(accessLogHousekeeperAct.records.toString());

                            if(accessLogHousekeeperAct.records.isEmpty()) {
                                AbsractSteps.myScenario.log(passMessage("All access log entries meeting criteria have been deleted successfully"));
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("Not all access log entries meeting criteria have been deleted successfully"));
                                softAssert.fail("Not all access log entries meeting criteria have been deleted successfully");

                            }

                            accessLogHousekeeperCurrentRows2 = accessLogHousekeeperExp.getRowCountForHousekeeper();
                              if(accessLogHousekeeperCurrentRows2 == 0){
                                AbsractSteps.myScenario.log(warnMessage("No rows remaining in ACL_D_ACCESS_LOG table\n" +
                                        "There were " + pinsmspwdCleanUpHousekeeperCurrentRows1 + " at the beginning of the run."));
                            }

                            break;
                    }
                }

                break;

            case "pindataextract":

                taskName = ScheduledTaskNames.PINDATAEXTRACT;
                pinDataFileSplitter = new PinDataFileSplitter();

                Thread.sleep(10000);

                pinDataDatabaseGatherer = new PinDataDatabaseGatherer();
                pinDataDatabaseGatherer.gatherDataByDate(lastRunTime);

                pinDataFileSplitter.splitFileInRecords();

                AbsractSteps.myScenario.log("Database Records: " + pinDataDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(pinDataDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + pinDataFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + pinDataFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(pinDataFileSplitter.records.toString());

                if(pinDataDatabaseGatherer.getRecordCount() != pinDataFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            pinDataDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + pinDataFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(pinDataDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for PIN Data Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for PIN Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (PinDataRecord temp : pinDataDatabaseGatherer.records) {
                    if(pinDataFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in PIN Data Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in PIN Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in PIN Data Extract.");

                    }
                }
                break;

            case "pinmailer":
                taskName = ScheduledTaskNames.PINDATAEXTRACT;
                pinMailerFileSplitter = new PinMailerFileSplitter();

                Thread.sleep(10000);

                pinMailerDatabaseGatherer = new PinMailerDatabaseGatherer();
                pinMailerDatabaseGatherer.gatherData(lastRunToId);

                pinMailerFileSplitter.splitFileInRecords();

                AbsractSteps.myScenario.log("Database Records: " + pinMailerDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(pinMailerDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + pinMailerFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + pinMailerFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(pinMailerFileSplitter.records.toString());

                if(pinMailerDatabaseGatherer.getRecordCount() != pinMailerFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            pinMailerDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + pinMailerFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(pinMailerDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Pin Mailer." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Pin Mailer." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (PinMailerRecord temp : pinMailerDatabaseGatherer.records) {
                    if(pinMailerFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Pin Mailer."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Pin Mailer."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Pin Mailer.");
                    }
                }
                break;

            case "pinsmsdataextract":

                taskName = ScheduledTaskNames.PINSMSDATAEXTRACT;
                pinSMSDataExtractFileSplitter = new PinSMSDataExtractFileSplitter();

                Thread.sleep(10000);

                pinSMSDataExtractDatabaseGatherer = new PinSMSDataExtractDatabaseGatherer();
                pinSMSDataExtractDatabaseGatherer.gatherData(lastRunTime);
//                pinSMSDataExtractDatabaseGatherer.printRecords();

                pinSMSDataExtractFileSplitter.splitFileInRecords();
//                pinSMSDataExtractFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + pinSMSDataExtractDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(pinSMSDataExtractDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + pinSMSDataExtractFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + pinSMSDataExtractFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(pinSMSDataExtractFileSplitter.records.toString());

                if(pinSMSDataExtractDatabaseGatherer.getRecordCount() != pinSMSDataExtractFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            pinSMSDataExtractDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + pinSMSDataExtractFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(pinSMSDataExtractDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for PIN SMS Data Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for PIN SMS Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }


                for (PinSMSDataExtractRecord fileTemp : pinSMSDataExtractFileSplitter.records) {

                    String fileId = fileTemp.getId();

                    for (PinSMSDataExtractRecord dbTemp : pinSMSDataExtractDatabaseGatherer.records) {

                        output = "";

                        String dbId = dbTemp.getId();
                        String dbRspSmsStatus = dbTemp.getRspSmsStatus();

                        //Records created by TOWPD have RSPSMSSTATUS = 1
                        //These match between File and Database
                        if (fileId.equals(dbId) && dbRspSmsStatus.equals("1")) {
                            if (dbTemp.equals(fileTemp)) {
                                AbsractSteps.myScenario.log(passMessage("Record in database:\n" + dbTemp + "\n found in PIN SMS Data Extract."));
                                continue;
                            }
                        }

                        //If the record id matches, check all other fields.
                        //SPECIAL CASE - RSPSMSSTATUS
                        // This needs to change as
                        // RSPSMSSTATUS = 2 in the log
                        // RSPSMSSTATUS = 4 in the database
                        if (fileId.equals(dbId) && dbRspSmsStatus.equals("4")) {

                             output = output + "Record: [ID=" + dbId;

                            if(dbTemp.getInterfaceId().equals(fileTemp.getInterfaceId())){
                                output = output + ", INTERFACEID=" + dbTemp.getInterfaceId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getTrxTypeId().equals(fileTemp.getTrxTypeId())){
                                output = output + ", TRXTYPEID=" + dbTemp.getTrxTypeId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getTrxStatus().equals(fileTemp.getTrxStatus())){
                                output = output + ", TRXSTATUS=" + dbTemp.getTrxStatus();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }


                            if(dbTemp.getSystemDateTime().equals(fileTemp.getSystemDateTime())){
                                output = output + ", SYSTEMDATETIME=" + dbTemp.getSystemDateTime();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqDateTime().equals(fileTemp.getReqDateTime())){
                                output = output + ", REQDATETIME=" + dbTemp.getReqDateTime();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqOrigId().equals(fileTemp.getReqOrigId())){
                                output = output + ", REQORIGID=" + dbTemp.getReqOrigId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqRn().equals(fileTemp.getReqRn())){
                                output = output + ", REQRN=" + dbTemp.getReqRn();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqIssuerPinId().equals(fileTemp.getReqIssuerPinId())){
                                output = output + ", REQISSUERPINID=" + dbTemp.getReqIssuerPinId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqIssuerPukId().equals(fileTemp.getReqIssuerPukId())){
                                output = output + ", REQISSUERPUKID=" + dbTemp.getReqIssuerPukId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPukId().equals(fileTemp.getReqPukId())){
                                output = output + ", REQPUKID=" + dbTemp.getReqPukId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPinExpiryDate().equals(fileTemp.getReqPinExpiryDate())){
                                output = output + ", REQPINEXPIRYDATE=" + dbTemp.getReqPinExpiryDate();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPinId().equals(fileTemp.getReqPinId())){
                                output = output + ", REQPINID=" + dbTemp.getReqPinId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPanId().equals(fileTemp.getReqPanId())){
                                output = output + ", REQPANID=" + dbTemp.getReqPanId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqIssuerPanAlias().equals(fileTemp.getReqIssuerPanAlias())){
                                output = output + ", REQISSUERPANALIAS=" + dbTemp.getReqIssuerPanAlias();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPanSeqNumber().equals(fileTemp.getReqPanSeqNumber())){
                                output = output + ", REQPANSEQNUMBER=" + dbTemp.getReqPanSeqNumber();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);

                            }

                            if(dbTemp.getReqPanExpiryDate().equals(fileTemp.getReqPanExpiryDate())){
                                output = output + ", REQPANEXPIRYDATE=" + dbTemp.getReqPanExpiryDate();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqTokenAppStatusId().equals(fileTemp.getReqTokenAppStatusId())){
                                output = output + ", REQTOKENAPPSTATUSID=" + dbTemp.getReqTokenAppStatusId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqTokenAppSeqNum().equals(fileTemp.getReqTokenAppSeqNum())){
                                output = output + ", REQTOKENAPPSEQNUM=" + dbTemp.getReqTokenAppSeqNum();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqIssuerTokenProductCode().equals(fileTemp.getReqIssuerTokenProductCode())){
                                output = output + ", REQISSUERTOKENPRODUCTCODE=" + dbTemp.getReqIssuerTokenProductCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqPinDeliveryMethod().equals(fileTemp.getReqPinDeliveryMethod())){
                                output = output + ", REQPINDELIVERYMETHOD=" + dbTemp.getReqPinDeliveryMethod();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqAdviceAllTokenAppFlag().equals(fileTemp.getReqAdviceAllTokenAppFlag())){
                                output = output + ", REQADVICEALLTOKENAPPFLAG=" + dbTemp.getReqAdviceAllTokenAppFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqAdvicePinPukFlag().equals(fileTemp.getReqAdvicePinPukFlag())){
                                output = output + ", REQADVICEPINPUKFLAG=" + dbTemp.getReqAdvicePinPukFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqLanguageCode().equals(fileTemp.getReqLanguageCode())){
                                output = output + ", REQLANGUAGECODE=" + dbTemp.getReqLanguageCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqMailingCode().equals(fileTemp.getReqMailingCode())){
                                output = output + ", REQMAILINGCODE=" + dbTemp.getReqMailingCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqPriority().equals(fileTemp.getReqPriority())){
                                output = output + ", REQPRIORITY=" + dbTemp.getReqPriority();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqBranchCode().equals(fileTemp.getReqBranchCode())){
                                output = output + ", REQBRANCHCODE=" + dbTemp.getReqBranchCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqBranchName().equals(fileTemp.getReqBranchName())){
                                output = output + ", REQBRANCHNAME=" + dbTemp.getReqBranchName();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqNumberofTokens().equals(fileTemp.getReqNumberofTokens())){
                                output = output + ", REQNUMBEROFTOKENS=" + dbTemp.getReqNumberofTokens();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqGeneratePanFlag().equals(fileTemp.getReqGeneratePanFlag())){
                                output = output + ", REQGENERATEPANFLAG=" + dbTemp.getReqGeneratePanFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqGeneratePinFlag().equals(fileTemp.getReqGeneratePinFlag())){
                                output = output + ", REQGENERATEPINFLAG=" + dbTemp.getReqGeneratePinFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqGeneratePukFlag().equals(fileTemp.getReqGeneratePukFlag())){
                                output = output + ", REQGENERATEPUKFLAG=" + dbTemp.getReqGeneratePukFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqOrderType().equals(fileTemp.getReqOrderType())){
                                output = output + ", REQORDERTYPE=" + dbTemp.getReqOrderType();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqFeedbackRequiredFlag().equals(fileTemp.getReqFeedbackRequiredFlag())){
                                output = output + ", REQFEEDBACKREQUIREDFLAG=" + dbTemp.getReqFeedbackRequiredFlag();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqPreviousPanId().equals(fileTemp.getReqPreviousPanId())){
                                output = output + ", REQPREVIOUSPANID=" + dbTemp.getReqPreviousPanId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqPreviousPanSeqNumber().equals(fileTemp.getReqPreviousPanSeqNumber())){
                                output = output + ", REQPREVIOUSPANSEQNUMBER=" + dbTemp.getReqPreviousPanSeqNumber();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getReqPreviousPanExpiryDate().equals(fileTemp.getReqPreviousPanExpiryDate())){
                                output = output + ", REQPREVIOUSPANEXPIRYDATE=" + dbTemp.getReqPreviousPanExpiryDate();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspResponseCode().equals(fileTemp.getRspResponseCode())){
                                output = output + ", RSPRESPONSECODE=" + dbTemp.getRspResponseCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspErrorDescr().equals(fileTemp.getRspErrorDescr())){
                                output = output + ", RSPERRORDESCR=" + dbTemp.getRspErrorDescr();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspDateTime().equals(fileTemp.getRspDateTime())){
                                output = output + ", RSPDATETIME=" + dbTemp.getRspDateTime();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspPinId().equals(fileTemp.getRspPinId())){
                                output = output + ", RSPPINID=" + dbTemp.getRspPinId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspPukId().equals(fileTemp.getRspPukId())){
                                output = output + ", RSPPUKID=" +  dbTemp.getRspPukId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspPanId().equals(fileTemp.getRspPanId())){
                                output = output + ", RSPPANID=" + dbTemp.getRspPanId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspPanSeqNumber().equals(fileTemp.getRspPanSeqNumber())){
                                output = output + ", RSPPANSEQNUMBER=" + dbTemp.getRspPanSeqNumber();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspPanExpiryDate().equals(fileTemp.getRspPanExpiryDate())){
                                output = output + ", RSPPANEXPIRYDATE=" + dbTemp.getRspPanExpiryDate();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                scenarioFail = true;

                            }

                            if(dbTemp.getRspIssuerTokenProductCode().equals(fileTemp.getRspIssuerTokenProductCode())){
                                output = output + ", RSPISSUERTOKENPRODUCTCODE=" + dbTemp.getRspIssuerTokenProductCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspTokenAppSeqNum().equals(fileTemp.getRspTokenAppSeqNum())){
                                output = output + ", RSPTOKENAPPSEQNUM=" + dbTemp.getRspTokenAppSeqNum();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getRspSmsStatus().equals("4") && fileTemp.getRspSmsStatus().equals("2")){
                                output = output + ", RSPSMSSTATUS=" + dbTemp.getRspSmsStatus();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtInstitutionId().equals(fileTemp.getExtInstitutionId())){
                                output = output + ", EXTINSTITUTIONID=" + dbTemp.getExtInstitutionId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtInstitutionName().equals(fileTemp.getExtInstitutionName())){
                                output = output + ", EXTINSTITUTIONNAME=" + dbTemp.getExtInstitutionName();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtIssuerId().equals(fileTemp.getExtIssuerId())){
                                output = output + ", EXTISSUERID=" + dbTemp.getExtIssuerId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtIssuerName().equals(fileTemp.getExtIssuerName())){
                                output = output + ", EXTISSUERNAME=" + dbTemp.getExtIssuerName();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtTokenProductId().equals(fileTemp.getExtTokenProductId())){
                                output = output + ", EXTTOKENPRODUCTID=" + dbTemp.getExtTokenProductId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtIssuerTokenproductCode().equals(fileTemp.getExtIssuerTokenproductCode())){
                                output = output + ", EXTISSUERTOKENPRODUCTCODE=" + dbTemp.getExtIssuerTokenproductCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtTokenProductName().equals(fileTemp.getExtTokenProductName())){
                                output = output + ", EXTTOKENPRODUCTNAME=" + dbTemp.getExtTokenProductName();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtTokenProductGroupId().equals(fileTemp.getExtTokenProductGroupId())){
                                output = output + ", EXTTOKENPRODUCTGROUPID=" + dbTemp.getExtTokenProductGroupId();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtTokenProductGroupName().equals(fileTemp.getExtTokenProductGroupName())){
                                output = output + ", EXTTOKENPRODUCTGROUPNAME=" + dbTemp.getExtTokenProductGroupName();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtTokenProductGroupCode().equals(fileTemp.getExtTokenProductGroupCode())){
                                output = output + ", EXTTOKENPRODUCTGROUPCODE=" + dbTemp.getExtTokenProductGroupCode();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtPanDisplay().equals(fileTemp.getExtPanDisplay())){
                                output = output + ", EXTPANDISPLAY=" + dbTemp.getExtPanDisplay();
                            }
                            else{
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            if(dbTemp.getExtIssuerCountryCode().equals(fileTemp.getExtIssuerCountryCode())){
                                output = output + ", EXTISSUERCOUNTRYCODE=" + dbTemp.getExtIssuerCountryCode() + "]";
                            }
                            else {
                                AbsractSteps.myScenario.log(failMessage("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp));
                                softAssert.fail("RECORD MISMATCH\nDatabase Record\n" +
                                        dbTemp + "\nFile Extract Record\n" +
                                        fileTemp);
                            }

                            AbsractSteps.myScenario.log(passMessage("Record in database:\n" + output + "\n found in Pin SMS Data Extract."));


                        }

                        if(scenarioFail){
                            AbsractSteps.myScenario.log(failMessage("Record in database:\n" + output + "\n not found in Pin SMS Data Extract or incorrect."));
                            softAssert.fail("Record in database:\n" + output + "\n not found in Pin SMS Data Extract or incorrect.");

                        }

                    }

                }

                break;


            case "tokenapplicationdataextract":
                taskName = ScheduledTaskNames.TOKENAPPLICATIONDATAEXTRACT;
                tokenApplicationDataFileSplitter = new TokenApplicationDataFileSplitter();

                Thread.sleep(10000);

                tokenApplicationDataDatabaseGatherer = new TokenApplicationDataDatabaseGatherer();
                tokenApplicationDataDatabaseGatherer.gatherData(lastRunToId);
//                tokenApplicationDataDatabaseGatherer.printRecords();

                tokenApplicationDataFileSplitter.splitFileInRecords();
//                tokenApplicationDataFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + tokenApplicationDataDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(tokenApplicationDataDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + tokenApplicationDataFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + tokenApplicationDataFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(tokenApplicationDataFileSplitter.records.toString());

                if(tokenApplicationDataDatabaseGatherer.getRecordCount() != tokenApplicationDataFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            tokenApplicationDataDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + tokenApplicationDataFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(tokenApplicationDataDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Token Application Data Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Token Application Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (TokenApplicationDataRecord temp : tokenApplicationDataDatabaseGatherer.records) {
                    if(tokenApplicationDataFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Token Application Data Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Token Application Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Token Application Data Extract.");
                    }
                }
                break;

            case "tokendataextract":
                taskName = ScheduledTaskNames.TOKENDATAEXTRACT;
                tokenDataFileSplitter = new TokenDataFileSplitter();

                Thread.sleep(10000);

                tokenDataDatabaseGatherer = new TokenDataDatabaseGatherer();
                tokenDataDatabaseGatherer.gatherData(lastRunToId);
//                tokenDataDatabaseGatherer.printRecords();

                tokenDataFileSplitter.splitFileInRecords();
//                tokenDataFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + tokenDataDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(tokenDataDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + tokenDataFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + tokenDataFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(tokenDataFileSplitter.records.toString());

                if(tokenDataDatabaseGatherer.getRecordCount() != tokenDataFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            tokenDataDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + tokenDataFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(tokenDataDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Token Data Extract." +
                                                                "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Token Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                scenarioFail = false;
                for (TokenDataRecord temp : tokenDataDatabaseGatherer.records) {
                    if (tokenDataFileSplitter.records.contains(temp)) {
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Token Data Extract."));

                    } else {
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Token Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Token Data Extract.");
                    }
                }


                break;

            case "tokenimportfeedback":
                taskName = ScheduledTaskNames.TOKENIMPORTFEEDBACK;
                tokenImportFeedbackFileSplitter = new TokenImportFeedbackFileSplitter();

                Thread.sleep(10000);

                tokenImportDatabaseGatherer = new TokenImportDatabaseGatherer();
                tokenImportDatabaseGatherer.gatherData(lastRunTime);
//                tokenImportDatabaseGatherer.printRecords();

                tokenImportFeedbackFileSplitter.splitFileInRecords();
//                tokenImportFeedbackFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + tokenImportDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(tokenImportDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + tokenImportFeedbackFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + tokenImportFeedbackFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(tokenImportFeedbackFileSplitter.records.toString());

                if(tokenImportDatabaseGatherer.getRecordCount() != tokenImportFeedbackFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            tokenImportDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + tokenImportFeedbackFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(tokenImportDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Token Import Feedback Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Token Import Feedback Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                scenarioFail = false;
                for (TokenImportFeedbackRecord temp : tokenImportDatabaseGatherer.records) {
                    if(tokenImportFeedbackFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Token Import Feedback Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Token Import Feedback Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Token Import Feedback Extract.");
                    }
                }
                break;

            case "tokenorderfeedback":
                taskName = ScheduledTaskNames.TOKENORDERFEEDBACK;
                tokenOrderFeedbackFileSplitter = new TokenOrderFeedbackFileSplitter();

                Thread.sleep(10000);
                tokenOrderFeedbackDatabaseGatherer = new TokenOrderFeedbackDatabaseGatherer();
                tokenOrderFeedbackDatabaseGatherer.gatherData(lastRunToId);
//                tokenOrderFeedbackDatabaseGatherer.printRecords();
                tokenOrderFeedbackFileSplitter.splitFileInRecords();
//                tokenOrderFeedbackFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + tokenOrderFeedbackDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(tokenOrderFeedbackDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + tokenOrderFeedbackFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + tokenOrderFeedbackFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(tokenOrderFeedbackFileSplitter.records.toString());

                if(tokenOrderFeedbackDatabaseGatherer.getRecordCount() != tokenOrderFeedbackFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            tokenOrderFeedbackDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + tokenOrderFeedbackFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(tokenOrderFeedbackDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Token Order Feedback Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Token Order Feedback Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (TokenOrderFeedbackRecord temp : tokenOrderFeedbackDatabaseGatherer.records) {

                    if(tokenOrderFeedbackFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Token Order Feedback Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Token Order Feedback Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Token Order Feedback Extract.");

                    }
                }

                break;

            case "transactionlogdataextract":
                taskName = ScheduledTaskNames.TRANSACTIONLOGDATAEXTRACT;
                transactionLogDataExtractFileSplitter = new TransactionLogDataExtractFileSplitter();

                Thread.sleep(10000);
                transactionLogDataExtractDatabaseGatherer = new TransactionLogDataExtractDatabaseGatherer();
                transactionLogDataExtractDatabaseGatherer.gatherData(lastRunToId);

                transactionLogDataExtractFileSplitter.splitFileInRecords();

                AbsractSteps.myScenario.log("Database Records: " + transactionLogDataExtractDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(transactionLogDataExtractDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + transactionLogDataExtractFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + transactionLogDataExtractFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(transactionLogDataExtractFileSplitter.records.toString());

                if(transactionLogDataExtractDatabaseGatherer.getRecordCount() != transactionLogDataExtractFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            transactionLogDataExtractDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + transactionLogDataExtractFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(transactionLogDataExtractDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Transaction Log Data Extract." +
                            "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Transaction Log Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (TransactionLogDataExtractRecord temp : transactionLogDataExtractDatabaseGatherer.records) {

                    if ((temp.getTrxTypeId().equals("9") && temp.getReqPinDeliveryMethod().equals("3") && temp.getRspSmsStatus().equals("1")) ||
                            (temp.getTrxTypeId().equals("9") && temp.getReqPinDeliveryMethod().equals("3") && temp.getRspSmsStatus().equals("4")) ||
                            (temp.getTrxTypeId().equals("9") && temp.getReqPinDeliveryMethod().equals("3") && temp.getRspSmsStatus().equals(" ")) ||
                            (temp.getTrxTypeId().equals("9") && temp.getReqPinDeliveryMethod().equals("3") && temp.getRspSmsStatus()==null)){
                        AbsractSteps.myScenario.log("Ignoring Database Row " + temp.getId() + ": TOWPD Delivery Method 3 with SMSRSPSTATUS null, 1 or 4 is not included in Transaction Log Extract.");
                    }
                    else {
                        if(transactionLogDataExtractFileSplitter.records.contains(temp)){
                            AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Transaction Log Data Extract."));
                        }
                        else{
                            AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Transaction Log Data Extract."));
                            softAssert.fail("Record in database:\n" + temp + "\n not found in Transaction Log Data Extract.");
                        }
                    }
                }

                break;

            case "translatepaniddataextract":
                taskName = ScheduledTaskNames.TRANSLATEPANIDDATAEXTRACT;
                translatePanIdDataExtractFileSplitter = new TranslatePanIdDataExtractFileSplitter();

                Thread.sleep(10000);

                translatePanIdDataExtractDatabaseGatherer = new TranslatePanIdDataExtractDatabaseGatherer();
                translatePanIdDataExtractDatabaseGatherer.gatherData(lastRunToId);
//                translatePanIdDataExtractDatabaseGatherer.printRecords();

                translatePanIdDataExtractFileSplitter.splitFileInRecords();
//                translatePanIdDataExtractFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + translatePanIdDataExtractDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(translatePanIdDataExtractDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + translatePanIdDataExtractFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + translatePanIdDataExtractFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(translatePanIdDataExtractFileSplitter.records.toString());

                if(translatePanIdDataExtractDatabaseGatherer.getRecordCount() != translatePanIdDataExtractFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            translatePanIdDataExtractDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + translatePanIdDataExtractFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(translatePanIdDataExtractDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for Translate PAN ID Data Extract." +
                                                                "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for Translate PAN ID Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }

                for (TranslatePanIdDataExtractRecord temp : translatePanIdDataExtractDatabaseGatherer.records) {

                    if(translatePanIdDataExtractFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in Translate PAN ID Data Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in Translate PAN ID Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in Translate PAN ID Data Extract.");
                    }
                }

                break;

            case "vppdataextract":
                taskName = ScheduledTaskNames.VPPDATAEXTRACT;
                vppDataExtractFileSplitter = new VppDataExtractFileSplitter();

                Thread.sleep(10000);

                vppDataExtractDatabaseGatherer = new VppDataExtractDatabaseGatherer();
                vppDataExtractDatabaseGatherer.gatherData(lastRunToId);
//                vppDataExtractDatabaseGatherer.printRecords();

                vppDataExtractFileSplitter.splitFileInRecords();
//                vppDataExtractFileSplitter.printRecords();

                AbsractSteps.myScenario.log("Database Records: " + vppDataExtractDatabaseGatherer.getRecordCount());
                AbsractSteps.myScenario.log(vppDataExtractDatabaseGatherer.records.toString());
                AbsractSteps.myScenario.log("Extract Log File: " + vppDataExtractFileSplitter.getParsedFileName());
                AbsractSteps.myScenario.log("Extract Log Records: " + vppDataExtractFileSplitter.getRecordCount());
                AbsractSteps.myScenario.log(vppDataExtractFileSplitter.records.toString());

                if(vppDataExtractDatabaseGatherer.getRecordCount() != vppDataExtractFileSplitter.getRecordCount()) {
                    AbsractSteps.myScenario.log(warnMessage("Record count mismatch:\nDatabase Count: " +
                            vppDataExtractDatabaseGatherer.getRecordCount() +
                            "\nExtract File Count: " + vppDataExtractFileSplitter.getRecordCount() +
                            "\nCheck records manually."));
                }

                if(vppDataExtractDatabaseGatherer.getRecordCount() == 0) {
                    AbsractSteps.myScenario.log(failMessage("No records found in database for VPP Data Extract." +
                                                                "\nCheck if file used was from previous successful run."));
                    softAssert.fail("No records found in database for VPP Data Extract." +
                            "\nCheck if file used was from previous successful run.");

                }


                for (VppDataExtractRecord temp : vppDataExtractDatabaseGatherer.records) {

                    if(vppDataExtractFileSplitter.records.contains(temp)){
                        AbsractSteps.myScenario.log(passMessage("Record in database:\n" + temp + "\n found in VPP Data Extract."));
                    }
                    else{
                        AbsractSteps.myScenario.log(failMessage("Record in database:\n" + temp + "\n not found in VPP Data Extract."));
                        softAssert.fail("Record in database:\n" + temp + "\n not found in VPP Data Extract.");
                    }
                }

                break;

        }

    }

    /*******************************************************************************************************************
     * Deleting the Task
     * Parameter: word
     ******************************************************************************************************************/
    @Then("I can delete the {word} from the list of tasks")
    public void i_can_delete_the_task(String word){

        ScheduledTaskNames taskName = null;

        switch (word){

            case "accesslogdataextract":
                taskName = ScheduledTaskNames.ACCESSLOGDATAEXTRACT;
                break;

            case "housekeeper":
                taskName = ScheduledTaskNames.HOUSEKEEPER;
                break;

            case "pindataextract":
                taskName = ScheduledTaskNames.PINDATAEXTRACT;
                break;

            case "pinmailer":
                taskName = ScheduledTaskNames.PINMAILER;
                break;

            case "pinsms":
                taskName = ScheduledTaskNames.PINSMS;
                break;

            case "pinsmsdataextract":
                taskName = ScheduledTaskNames.PINSMSDATAEXTRACT;
                break;

            case "tokendataextract":
                taskName = ScheduledTaskNames.TOKENDATAEXTRACT;
                break;

            case "tokenapplicationdataextract":
                taskName = ScheduledTaskNames.TOKENAPPLICATIONDATAEXTRACT;
                break;

            case "tokenimportfeedback":
                taskName = ScheduledTaskNames.TOKENIMPORTFEEDBACK;
                break;

            case "tokenorderfeedback":
                taskName = ScheduledTaskNames.TOKENORDERFEEDBACK;
                break;

            case "transactionlogdataextract":
                taskName = ScheduledTaskNames.TRANSACTIONLOGDATAEXTRACT;
                break;

            case "translatepaniddataextract":
                taskName = ScheduledTaskNames.TRANSLATEPANIDDATAEXTRACT;
                break;

            case "vppdataextract":
                taskName = ScheduledTaskNames.VPPDATAEXTRACT;
                break;

        }

        taskSchedulerPage.clickOnDelete(taskName);
        TaskSchedulerTableDataGatherer taskSchedulerTableDataGathererAfter = new TaskSchedulerTableDataGatherer(webDriver);
        taskSchedulerTableDataGathererAfter.gatherData();
        taskSchedulerPage.checkRowDeletion(newTask, taskSchedulerTableDataGathererAfter);

    }


    @Then("I take a screenshot \"([^\"]*)\"$")
    public void i_take_a_screenshot(String imageName){
        byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        AbsractSteps.myScenario.attach(screenshot, "image/png", imageName);
    }

    @Then("Check scheduler scenario")
    public void check_scheduler_scenario(){
        softAssert.assertAll();
    }

}
