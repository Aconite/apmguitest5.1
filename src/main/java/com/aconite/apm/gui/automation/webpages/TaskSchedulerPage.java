package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.enums.ScheduledTaskNames;
import com.aconite.apm.gui.automation.records.TaskSchedulerTableDataRecord;
import com.aconite.apm.gui.automation.uidatagatherers.TaskSchedulerTableDataGatherer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.HashMap;
import org.openqa.selenium.interactions.Actions;


public class TaskSchedulerPage
{

    WebDriver webDriver;

    String tableCSS = "table[class*='resizer']";
    String tableRowTag = "tr";
    String tableIDCellCSS  = "td[class*='x-grid-cell-idGId']";
    String tableNameCellCSS  = "td[class*='idGName']";
    String tableActiveCellCSS  = "td[class*='idGStatus']";
    String tableLastRunCellCSS  = "td[class*='idGLastRun']";
    String tableNextRunCellCSS  = "td[class*='idGNextRun']";
    String tableIssuerCellCSS  = "td[class*='idGIssuer']";

    String btnAddXpath = "//*[@id='button-1015-btnEl']";

    @FindBy (xpath = "//*[@id=\"secondary_bar\"]/div[2]/h4")
    WebElement ePageHeader;

    @FindBy (xpath = "//*[@id=\"button-1015-btnEl\"]")
    WebElement eAddTaskButton;

    @FindBy (xpath = "//*[@id=\"gridview-1014\"]/table/tbody/tr[2]/td[1]/div/img[1]")
    WebElement eEditTaskButton;

    @FindBy (xpath = "//*[@id=\"gridview-1014\"]/table/tbody/tr[2]/td[1]/div/img[3]")
    WebElement eDeleteTaskButton;

    @FindBy (xpath = "//*[@id=\"gridview-1014\"]/table/tbody/tr[2]/td[1]/div/img[5]")
    WebElement eRunTaskButton;

    @FindBy (xpath = "//*[@id=\"idName-inputEl\"]")
    WebElement eTaskNameDropDown;

    @FindBy (xpath = "//*[@id=\"idIssuerid-inputEl\"]")
    WebElement eIssuerDropDown;

    @FindBy(how = How.TAG_NAME, using = "li")
    List <WebElement> dropDownItems;

    @FindBy (xpath = "//*[@id=\"idBuildCronBtn-btnEl\"]")
    WebElement eBuildCronButton;

    @FindBy (xpath = "//*[@id=\"idBtnCreate-btnEl\"]")
    WebElement eCreateTaskButton;

    @FindBy (xpath = "//*[@id=\"idStatus-inputEl\"]")
    WebElement eActiveCheckBox;

    @FindBy (xpath = "//*[@id=\"idDailyCronSet-legendChk-inputEl\"]")
    WebElement eDailyTaskCheckBox;

    @FindBy (how = How.XPATH, using = "//*[@id=\"gridview-1014\"]/table/tbody/tr/td[4]")
    List <WebElement> configuredTasksList;

    @FindBy (css="table[class='x-grid-table x-grid-table-resizer']")
    WebElement eTaskTable;

    public TaskSchedulerPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageOpened ()
    {
        return ePageHeader.isDisplayed();
    }

    public void clickOnAdd ()
    {

        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAddXpath)));
        eAddTaskButton.click();
    }

    public void clickOnEdit (ScheduledTaskNames scheduledTaskName)
    {
        for(WebElement e : configuredTasksList)
        {
            if (e.getText().equalsIgnoreCase(scheduledTaskName.toString()))
            {
                e.findElement(By.xpath(".//../td[1]/div/img[1]")).click();
            }
        }
    }

    public void clickOnRun (ScheduledTaskNames scheduledTaskName, String taskId)
    {
        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        WebElement eTaskTable = webDriver.findElement(By.cssSelector(tableCSS));
        List<WebElement> rowList = eTaskTable.findElements(By.tagName(tableRowTag));

        for (int i = 1; i<rowList.size();i++)
        {
            WebElement eTaskIdCell = rowList.get(i).findElement(By.cssSelector(tableIDCellCSS));
            String thisRowTaskId = eTaskIdCell.getAttribute("textContent");

            if (thisRowTaskId.equalsIgnoreCase(taskId))
            {
                WebElement thisRowRun = rowList.get(i).findElement(By.cssSelector("img[src*='run.gif']"));
                thisRowRun.click();
                break;
            }
        }

        //click on the confirm button
        webDriver.findElement(By.xpath("//*[@id=\"button-1006-btnInnerEl\"]")).click();

    }

    public void clickOnDelete (ScheduledTaskNames scheduledTaskName)
    {
        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        WebElement eTaskTable = webDriver.findElement(By.cssSelector(tableCSS));
        List<WebElement> rowList = eTaskTable.findElements(By.tagName(tableRowTag));

        for (int i = 1; i<rowList.size();i++)
        {
            WebElement eTaskNameCell = rowList.get(i).findElement(By.cssSelector(tableNameCellCSS));
            String thisRowTaskName = eTaskNameCell.getText();

//            System.out.println("### This Row Task Name = " + thisRowTaskName);
//            System.out.println("### This Scheduled Task Name = " + scheduledTaskName.toString());

            if (thisRowTaskName.equalsIgnoreCase(scheduledTaskName.toString())){
                WebElement thisRowDelete = rowList.get(i).findElement(By.cssSelector("img[src*='delete']"));
                //get x,y location
//                Point location = thisRowDelete.getLocation();
//                int elementWidth = element.getSize().getWidth();
//                int elementHeight = element.getSize().getHeight();
                if(!webDriver.findElements(By.id("ext-gen1271")).isEmpty()){

                    System.out.println("Masking element exists");
//                    int click_x = location.GetX() + elementWidth/2;
//                    int click_y = location.GetY() + elementHeight/2;
                    Actions action = new Actions(webDriver);
                    action.moveToElement(thisRowDelete);
                    action.click();
                    action.perform();

                }
                else {
                    WebDriverWait elementwait = new WebDriverWait(webDriver, 120);
                    elementwait.until(ExpectedConditions.elementToBeClickable(thisRowDelete));
                    thisRowDelete.click();
                }
            }
        }

        //click on the confirm button
        webDriver.findElement(By.xpath("//*[@id=\"button-1006-btnInnerEl\"]")).click();

        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));
    }

//    public String getTaskAddedId(
//            HashMap<Integer, HashMap<String, String>> dataBefore,
//            HashMap<Integer, HashMap<String, String>> dataAfter)

    public TaskSchedulerTableDataRecord getTaskAdded(
            TaskSchedulerTableDataGatherer dataBefore,
            TaskSchedulerTableDataGatherer dataAfter)
    {

//        String taskId ="";
        TaskSchedulerTableDataRecord retRecord = null;


        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        if(dataBefore == dataAfter)
        {
            System.out.println("getTaskAddedId: Datasets are the same - no task added");
        }

        //Insert checks here for add and return new taskID

//        for (int i = 1; i <= dataAfter.size(); i++ )
//        {
//            boolean found = false;
////            System.out.println("After Task ID: " + dataAfter.get(i).get("taskId") + " - Searching....");
//            for (int j = 1; j <= dataBefore.size(); j++)
//            {
//                if (dataAfter.get(i).get("taskId").equalsIgnoreCase(dataBefore.get(j).get("taskId")))
//                {
////                    System.out.println("After Task ID: " + dataAfter.get(i).get("taskId") + " found.");
//                    found = true;
//                    break;
//                }
//            }
////            System.out.println("Finished j loop: " + found);
//
//            if(!found)
//            {
////                System.out.println("After Task ID: " + dataAfter.get(i).get("taskId") + " not found.");
//                taskId = (String)dataAfter.get(i).get("taskId");
//                break;
//            }
//        }

        for(TaskSchedulerTableDataRecord record :  dataAfter.records){

            if(!dataBefore.records.contains(record)){
                retRecord = record;
                break;
            }

        }

        return retRecord;
    }



    public void checkRowDeletion(TaskSchedulerTableDataRecord delTask,
                                 TaskSchedulerTableDataGatherer dataAfter)
    {

        //Check the task is not in the list after
//        boolean found_after = false;
//        for (int i = 1; i <= dataAfter.size(); i++)
//        {
//            if (dataAfter.get(i).get("taskId").equalsIgnoreCase(taskId))
//            {
//                found_after = true;
//            }
//        }

        if (dataAfter.records.contains(delTask))
        {
            assert false;//, "Task ID: " + taskId + " has not been deleted", dataAfter.toString());
        }
        else
        {
            assert true;//, "Task ID: " + taskId + " has been deleted");
        }

    }

//    public HashMap<Integer, HashMap<String, String>> getTableData()
//    {
//
//        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
//        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));
//
//        WebElement eTaskTable = webDriver.findElement(By.cssSelector(tableCSS));
//        List<WebElement> rowList = eTaskTable.findElements(By.tagName(tableRowTag));
//        //System.out.println("*** Found " + rowList.size() + " rows.");
//        //Create Array here to store dictionaries
//        HashMap <Integer, HashMap<String, String>> tableData = new HashMap<Integer, HashMap<String, String>>();
//
//        //Create the dictionary
//        for (int i = 1; i<rowList.size();i++)
//        {
//            HashMap <String, String> rowData = new HashMap<String, String>();
//
//            rowData.put("taskId", rowList.get(i).findElement(By.cssSelector(tableIDCellCSS)).getAttribute("textContent"));
//            rowData.put("taskName", rowList.get(i).findElement(By.cssSelector(tableNameCellCSS)).getText());
////            rowData.put("taskCronParam", rowList.get(i).findElement(By.cssSelector(tableCronParamCellCSS)).getText());
//            rowData.put("taskActive", rowList.get(i).findElement(By.cssSelector(tableActiveCellCSS)).getText());
//            rowData.put("taskLastRun", rowList.get(i).findElement(By.cssSelector(tableLastRunCellCSS)).getText());
//            rowData.put("taskNextRun", rowList.get(i).findElement(By.cssSelector(tableNextRunCellCSS)).getText());
//            rowData.put("taskIssuer", rowList.get(i).findElement(By.cssSelector(tableIssuerCellCSS)).getText());
//
//            //Assign the dictionary to the array
//            tableData.put(i,rowData);
//        }
//
//        return tableData;
//    }

    public void getNamesOfAddedTasks()
    {
        System.out.println("Total number of tasks currently added on the GUI: " + configuredTasksList.size());

        int i = 1;
        for(WebElement e : configuredTasksList)
        {
            System.out.println("Task " + i + ": " + e.getText());
            i++;
        }
    }

    public boolean isTaskAdded (ScheduledTaskNames scheduledTaskName)
    {

        boolean isTaskAdded = false;
        List<WebElement> rowList;
        WebElement eTaskTable;
        WebElement eTaskNameCell;
        String thisRowTaskName;

        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        eTaskTable = webDriver.findElement(By.cssSelector(tableCSS));
        rowList = eTaskTable.findElements(By.tagName(tableRowTag));
        //System.out.println("Table has "  + rowList.size() + " rows.");
        for (int i = 1; i < rowList.size(); i++) {
            eTaskNameCell = rowList.get(i).findElement(By.cssSelector(tableNameCellCSS));
            thisRowTaskName = eTaskNameCell.getText();
            if (thisRowTaskName.equalsIgnoreCase(scheduledTaskName.toString())) {
                isTaskAdded = true;
                break;
            }
        }

        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        return isTaskAdded;
    }

    public String getLastRunByTaskId(HashMap<Integer, HashMap<String, String>> taskTable, String taskId){

        for (int i = 1; i <= taskTable.size(); i++)
        {
            String rowTaskId = taskTable.get(i).get("taskId").toString();
            if (rowTaskId.equals(taskId))
            {
                String lastRun = taskTable.get(i).get("taskLastRun").toString();
                return lastRun;
            }
        }

        return "";
    }

    public TaskSchedulerTableDataRecord updateTaskRecordById(String taskId, TaskSchedulerTableDataGatherer tableData){

        TaskSchedulerTableDataRecord task;
        task = null;

        for (TaskSchedulerTableDataRecord record : tableData.records){
//            System.out.println("----" + record.getId());
//            System.out.println("====" + taskId);
            if(record.getId().equals(taskId)){
                task = record;
//                System.out.println("++++" + task);
                break;
            }
        }

        return task;
    }

    //******************************************************
    //*  Dealing with the Scheduler Detail Window
    //*******************************************************

    // for tasks without issuer
    public void addNewDailyTask(ScheduledTaskNames scheduledTaskNames, boolean isActive)
    {
        String taskName = scheduledTaskNames.toString();

        clickOnAdd();

        selectTaskName(taskName);

        if (scheduledTaskNames.isIssuerRequired())
        {
            selectIssuer("");
        }

        if (isActive)
        {
            checkActiveCheckBox();
        }

        checkDailyCheckBox();
        clickOnBuildCronButton();
        clickOnCreateTaskButton();

        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));
    }

    // for tasks with issuer
    public String addNewDailyTask(ScheduledTaskNames scheduledTaskNames, boolean isActive, String issuer)
    {
        String taskName = scheduledTaskNames.toString();

        clickOnAdd();

        selectTaskName(taskName);

        if (scheduledTaskNames.isIssuerRequired())
        {
            selectIssuer(issuer);
        }

        if (isActive)
        {
            checkActiveCheckBox();
        }

        checkDailyCheckBox();
        clickOnBuildCronButton();
        clickOnCreateTaskButton();

        WebDriverWait mywait = new WebDriverWait(webDriver, 120);
        mywait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(tableCSS)));

        return taskName;

    }

    private void selectTaskName (String taskName)
    {
        eTaskNameDropDown.click();
        for (WebElement webElement : dropDownItems)
        {
            if (webElement.getText().equals(taskName))
                {
                    webElement.click();
                }
        }
    }

    private void selectIssuer (String issuer)
    {
        eIssuerDropDown.click();
        for (WebElement webElement : dropDownItems)
        {
            if (webElement.getText().equals(issuer))
            {
                webElement.click();
            }
        }
    }

    private void clickOnBuildCronButton()
    {
        eBuildCronButton.click();
    }

    private void checkActiveCheckBox()
    {
        eActiveCheckBox.click();
    }

    private void checkDailyCheckBox()
    {
        eDailyTaskCheckBox.click();
    }

    private void clickOnCreateTaskButton()
    {
        eCreateTaskButton.click();
    }
}
