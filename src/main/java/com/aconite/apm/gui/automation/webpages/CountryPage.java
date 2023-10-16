package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.CountryDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CountryPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public CountryPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean isPageOpened() {
        return orAdmin.spanCountryTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnCountryDetailCreate()));

        orAdmin.btnCountryDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnCountryDetailCancel()));

        orAdmin.btnCountryDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        switch (field) {

            case("CountryCode"):
                if (!orAdmin.txtCountryDetailCountryCode().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("CountryName"):
                if (!orAdmin.txtCountryDetailCountryName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }

    public CountryDataRecord enterCountryData(CountryDataRecord newCountry) {

        CountryDataRecord newRecord;

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
        orAdmin.btnAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnCountryDetailCancel()));

        orAdmin.txtCountryDetailCountryCode().sendKeys(newCountry.getCountryCode());
        orAdmin.txtCountryDetailCountryName().sendKeys(newCountry.getCountryName());

        hardWait(10000);

        orAdmin.btnCountryDetailCreate().click();

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("successfully added")) {
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblCountryList()));

            adminCommon.findObjectByColumn(orAdmin.countryList(),"Country Code", newCountry.getCountryCode());
            newRecord = getCountryListRecordByName(newCountry);

        }
        else{
            newRecord = null;
        }


        return newRecord;

    }

    public boolean editCountryData(CountryDataRecord editCountry, String editField){

        System.out.println(editCountry);
        adminCommon.sleep(500);


        if(adminCommon.clickEditByColumn(orAdmin.countryList(), "Country Code", editCountry.getCountryCode())) {

            // Edit the field required
            switch (editField) {

                case ("CountryName"):
                    orAdmin.txtCountryDetailCountryName().clear();
                    orAdmin.txtCountryDetailCountryName().sendKeys(editCountry.getCountryName());
                    break;

                case ("CountryCode"):
                    orAdmin.txtCountryDetailCountryCode().clear();
                    orAdmin.txtCountryDetailCountryCode().sendKeys(editCountry.getCountryCode());
                    break;

            }

            // Click the Save button
            orAdmin.btnCountryDetailSave().click();

            return(adminCommon.clickBtnOk());

        }

        return false;

    }

    public CountryDataRecord getCountryListRecordByName(CountryDataRecord newCountry){

        adminCommon.findObjectByColumn(orAdmin.countryList(),"Name", newCountry.getCountryName());

        List<WebElement> rows = orAdmin.tblCountryList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            newCountry.setCountryName(null);
            newCountry.setCountryCode(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (newCountry.getCountryName().equals(cellName.getText())) {
                    newCountry.setCountryCode(row.findElement(By.xpath(".//td[contains(@class, 'idGCode')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                newCountry.setCountryName(null);
                newCountry.setCountryCode(null);
            }
        }


        return(newCountry);
    }

    public CountryDataRecord getTableDataById(CountryDataRecord country){

        CountryDataRecord record = new CountryDataRecord();

        //need to find the object in the table
        adminCommon.findObjectByColumn(orAdmin.tblCountryList(), "Country Code", country.getCountryCode());

        List<WebElement> rows = orAdmin.tblCountryList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setCountryCode(null);
            record.setCountryName(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGCode')]"));
                if (country.getCountryCode().equals(cellId.getText())) {
                    record.setCountryCode(row.findElement(By.xpath(".//td[contains(@class, 'idGCode')]")).getText());
                    record.setCountryName(row.findElement(By.xpath(".//td[contains(@class, 'idGName')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                record.setCountryCode(null);
                record.setCountryName(null);
            }
        }

        return(record);

    }

    public CountryDataRecord getDBDataById(String instId) throws Exception{

        CountryDataRecord record = new CountryDataRecord();

        try {
            String getIssByIdSQL = "SELECT COUNTRY_CODE, NAME " +
                    "FROM C_S_COUNTRIES " +
                    "WHERE COUNTRY_CODE = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setCountryCode(null);
                record.setCountryName(null);
            }
            else{
                rs.next();

                record.setCountryCode(rs.getString(1));
                record.setCountryName(rs.getString(2));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public boolean clickDeleteCountryByCountryCode(CountryDataRecord delCountry){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblCountryList()));

        adminCommon.clickDeleteByColumn(orAdmin.tblCountryList(), "Country Code", delCountry.getCountryCode());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }

        return true;
    }
    
}
