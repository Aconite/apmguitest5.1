package com.aconite.apm.gui.automation.uidatagatherers;

import com.aconite.apm.gui.automation.records.TaskSchedulerTableDataRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSchedulerTableDataGatherer {

    WebDriver webDriver;

    public TaskSchedulerTableDataGatherer(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public List <TaskSchedulerTableDataRecord> records = new ArrayList<>();


    /**
     * Object Properties
     **/
    @FindBy(xpath = "//div[@id=\"idSchedulerList-body\"]")
    WebElement table;

    @FindBy(xpath = "//div[@id=\"divSchedulerList\"]//span[@class=\"x-column-header-text\"]")
    List<WebElement> colHeaders;

    @FindBy(xpath= "//tr[contains(@class, \"x-grid-row\")]")
    List<WebElement> tblRows;


    /**
     * Page Functions
     **/
    public Map<String, String> getColumnHeadings(){

        Map<String, String> tblHeadings = new HashMap<String, String>();
        String colName = null;
        String colIdRoot = null;
        int itemCount = 0;

        for (WebElement webElement : colHeaders) {

            colName = webElement.getAttribute("textContent");
            String[] temp = webElement.getAttribute("id").split("-");
            colIdRoot = temp[0];
            tblHeadings.put(colName, colIdRoot);

        }

        return(tblHeadings);

    }

    public int getDataRowCount(){

        WebElement eTaskTable = webDriver.findElement(By.xpath("//div[@id =\"idSchedulerList-body\"]"));
        List<WebElement> rowlist = eTaskTable.findElements(By.xpath("//tr[contains(@class, \"x-grid-row\")]"));
        return rowlist.size();

    }

    public void gatherData()
    {


        try
        {
            records.clear();

            System.out.println("About to gather data for all scheduled tasks entries in table...");
            int rowCount = getDataRowCount();
            Map<String, String> tblData = getColumnHeadings();

            //Loop through table rows
            for(int i = 1; i <= rowCount; i++){

                TaskSchedulerTableDataRecord record = new TaskSchedulerTableDataRecord();

                for (Map.Entry<String, String> entry : tblData.entrySet())
                {

                    if(entry.getValue().equals("idGId")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setId(cell.getAttribute("textContent"));
                    }

                    if(entry.getValue().equals("idGRownumber")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setRowNumber(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Name")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setName(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Active")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setActive(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Last Run")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setLastRun(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Next Run")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setNextRun(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Issuer")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setIssuer(cell.getAttribute("textContent"));
                    }

                }

                records.add(record);

            }
            System.out.println("Data gathered for all token product entries in table...");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void printRecords()
    {
        System.out.println("Print Records: TokenProductsTableDataGatherer");
        for (TaskSchedulerTableDataRecord taskSchedulerTableDataRecord : records)
        {
            System.out.println(taskSchedulerTableDataRecord.toString());
        }
    }

    @Override
    public String toString()
    {
        String outMsg = "";

        for (TaskSchedulerTableDataRecord taskSchedulerTableDataRecord : records) {
            outMsg = outMsg + "Record: [ID=" + taskSchedulerTableDataRecord.getId() +
                    ", NAME=" + taskSchedulerTableDataRecord.getName() +
                    ", ACTIVE=" + taskSchedulerTableDataRecord.getActive() +
                    ", LASTRUN=" + taskSchedulerTableDataRecord.getLastRun() +
                    ", NEXTRUN=" + taskSchedulerTableDataRecord.getNextRun() +
                    ", ISSUER=" + taskSchedulerTableDataRecord.getIssuer() + "]\n";
        }

        return outMsg;
    }




}
