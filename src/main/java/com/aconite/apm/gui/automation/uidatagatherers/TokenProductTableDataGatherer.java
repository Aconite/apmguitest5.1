package com.aconite.apm.gui.automation.uidatagatherers;

import com.aconite.apm.gui.automation.enums.ScheduledTaskNames;
import com.aconite.apm.gui.automation.records.TokenProductTableDataRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

public class TokenProductTableDataGatherer {

    WebDriver webDriver;

    public TokenProductTableDataGatherer(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public List <TokenProductTableDataRecord> records = new ArrayList<>();

    /**
     * Object Properties
     **/
    @FindBy(xpath = "//div[@id=\"idTokenProductsList-body\"]")
    WebElement table;

    @FindBy(xpath = "//div[@id=\"divTokenProductsList\"]//span[@class=\"x-column-header-text\"]")
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

        return(tblRows.size());

    }

    public void gatherData()
    {
        try
        {
            System.out.println("About to gather data for all token product entries in table...");
            int rowCount = getDataRowCount();
            Map<String, String> tblData = getColumnHeadings();

            //Loop through table rows
            for(int i = 1; i <= rowCount; i++){

                TokenProductTableDataRecord record = new TokenProductTableDataRecord();

                for (Map.Entry<String, String> entry : tblData.entrySet())
                {

                    if(entry.getKey().equals("ID")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setId(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Name")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setName(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Issuer Token Product Code")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setIssuerTokenProductCode(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Issuer")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setIssuer(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Token Product Group")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setTokenProductGroup(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Retention Days")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setRetentionDays(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Country")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setCountry(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Languange")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setLanguage(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Perso Bureau")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setPersoBureau(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Feedback Required")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setFeedbackRequired(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Active")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setActive(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("PIN Template")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setPinTemplate(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Secondary PIN Template")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setSecondaryPinTemplate(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("PUK Template")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setPukTemplate(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("Password Template")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setPasswordTemplate(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("SMS Password Hours")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setSmsPasswordHours(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("SMS Sender")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setSmsSender(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("SMS Validity Hours")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setSmsValidityHours(cell.getAttribute("textContent"));
                    }

                    if(entry.getKey().equals("SMS Class")){
                        WebElement cell = table.findElement(By.xpath("(//td[contains(@class, \"" + entry.getValue() + "\")])[" + i + "]"));
                        record.setSmsClassGUI(cell.getAttribute("textContent"));
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
        for (TokenProductTableDataRecord tokenProductTableDataRecord : records)
        {
            System.out.println(tokenProductTableDataRecord.toString());
        }
    }

}
