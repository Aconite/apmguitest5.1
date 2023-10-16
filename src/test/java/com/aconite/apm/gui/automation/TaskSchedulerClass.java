package com.aconite.apm.gui.automation;//package com.aconite.apm.gui.automation;
//
//import com.aconite.apm.gui.automation.bindings.SchedulerTestSteps;
//import com.aconite.apm.gui.automation.bindings.AbsractSteps;
//import com.aconite.apm.gui.automation.bindings.LoginTestSteps;
//import com.aconite.apm.gui.automation.databasegathers.ExtractLogDataGatherer;
//import com.aconite.apm.gui.automation.databasegathers.AccessLogDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.PinDataDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.PinMailerDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.PinSMSDataExtractDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TokenDataDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TokenImportDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TokenOrderFeedbackDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TokenApplicationDataDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TransactionLogDataExtractDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.TranslatePanIdDataExtractDatabaseGatherer;
//import com.aconite.apm.gui.automation.databasegathers.VppDataExtractDatabaseGatherer;
//import com.aconite.apm.gui.automation.enums.ScheduledTaskNames;
//import com.aconite.apm.gui.automation.enums.ExtractTypes;
//import com.aconite.apm.gui.automation.outputfilesplitters.AccessLogFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.PinDataFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.PinMailerFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.PinSMSDataExtractFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TokenDataFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TokenImportFeedbackFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TokenOrderFeedbackFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TokenApplicationDataFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TransactionLogDataExtractFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.TranslatePanIdDataExtractFileSplitter;
//import com.aconite.apm.gui.automation.outputfilesplitters.VppDataExtractFileSplitter;
//import com.aconite.apm.gui.automation.webpages.HomePage;
//import com.aconite.apm.gui.automation.webpages.LoginPage;
//import com.aconite.apm.gui.automation.webpages.TaskSchedulerPage;
//import com.aconite.apm.gui.automation.records.TokenImportFeedbackRecord;
//import com.aconite.apm.gui.automation.records.TokenOrderFeedbackRecord;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.WebDriver;
//import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
//import java.sql.*;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import java.io.File;
//import com.aconite.apm.gui.automation.cucumber.TestContext;
//import enums.Context;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.Arrays;
////import org.testng.annotations.*;
//import org.junit.Test;
//
//
//
//public class TaskSchedulerClass{
//
//    AbsractSteps absractSteps = new AbsractSteps();
//    TestContext testContext;
//
//    SchedulerTestSteps schedulerTestSteps= new SchedulerTestSteps(absractSteps);
//
//    public TaskSchedulerClass() throws Exception{
//
//        absractSteps.setUp();
//
//    }
//
//
//    @Test
//    public void AccessLogDataExtract(){
//
//        String taskName = "accesslogdataextract";
//
//        try{
//            schedulerTestSteps.i_am_logged_in_and_on_the_scheduler_page();
//        }
//        catch (Exception exc)
//        {
//            exc.printStackTrace();
//        }
//
//
////        schedulerTestSteps.i_add_a_new_daily_task(taskName);
////        schedulerTestSteps.i_take_a_screenshot("Task Added");
////
////        schedulerTestSteps.i_run_a_Task(taskName);
////        schedulerTestSteps.i_take_a_screenshot("Task Run");
////
////        try{
////            schedulerTestSteps.the_Task_Runs_Successfully_And_The_OutputIsCorrect(taskName);
////        }
////        catch (Exception exc)
////        {
////            exc.printStackTrace();
////        }
////
////        schedulerTestSteps.i_can_delete_the_task(taskName);
////        schedulerTestSteps.i_take_a_screenshot("Task Deleted");
//
//    }
//
//
//
//
//
//}