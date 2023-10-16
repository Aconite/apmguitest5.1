package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.records.InstitutionDataRecord;
import com.aconite.apm.gui.automation.records.IssuerDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aconite.apm.gui.automation.objectrepository.OR_Admin;

public class IssuersPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public IssuersPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanIssuersTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnIssuerDetailCreate()));

        orAdmin.btnIssuerDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnIssuerDetailCancel()));

        orAdmin.btnIssuerDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On Issuer Page - Issuer Detail window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtIssuerDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("Country"):
                if (!orAdmin.selIssuerDetailCountry().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }

    public IssuerDataRecord enterIssuerData(IssuerDataRecord newIss) {

        IssuerDataRecord newRecord;
        WebDriverWait mywait = new WebDriverWait(webDriver, 10);

        adminCommon.searchInstitution(newIss.getParentInstitution());

        // Click Add button
        orAdmin.btnAdd().click();
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnIssuerDetailCancel()));

        orAdmin.txtIssuerDetailName().sendKeys(newIss.getIssuerName());
        adminCommon.setListValue(orAdmin.selIssuerDetailCountry(), newIss.getCountry());

        orAdmin.btnIssuerDetailCreate().click();

        // Deal with the confirmation pop up
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("successfully added")) {
            orAdmin.btnOK().click();
            mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblIssuerList()));

            // get the row data by issuer name and get the id to return
            newRecord = getIssuerListRecordByName(newIss);

        }
        else{
            newRecord = null;
        }

        return(newRecord);

    }

    public boolean editIssuerData(IssuerDataRecord editIssuer, String instField){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);

        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));
        adminCommon.searchInstitution(editIssuer.getParentInstitution());

        // Find and click the Edit button by the row's ID
        adminCommon.sleep(500);
        adminCommon.clickEditById(orAdmin.tblIssuerList(),editIssuer.getId());

        // Edit the field required
        switch(instField){

            case("Name"):
                orAdmin.txtIssuerDetailName().clear();
                orAdmin.txtIssuerDetailName().sendKeys(editIssuer.getIssuerName());
                break;

            case("Country"):
                adminCommon.setListValue(orAdmin.selIssuerDetailCountry(), editIssuer.getCountry());
                break;

        }

        // Click the Save button
        orAdmin.btnIssuerDetailSave().click();

        return(adminCommon.clickBtnOk());

    }

    public boolean clickDeleteIssuerById(IssuerDataRecord editIssuer){

        WebDriverWait mywait = new WebDriverWait(webDriver, 30);

        // Search page
        adminCommon.searchInstitution(editIssuer.getParentInstitution());

        // Click delete
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblIssuerList()));
        adminCommon.clickDeleteById(orAdmin.tblIssuerList(), editIssuer.getId());

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

    public IssuerDataRecord getIssuerListRecordByName(IssuerDataRecord issName){

        List<WebElement> rows = orAdmin.tblIssuerList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            issName.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (issName.getIssuerName().equals(cellName.getText())) {
                    issName.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                issName.setId(null);
            }
        }

        return(issName);
    }

    public IssuerDataRecord getTableDataById(IssuerDataRecord issuer){

        IssuerDataRecord record = new IssuerDataRecord();

        List<WebElement> rows = orAdmin.tblIssuerList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
                if (issuer.getId().equals(cellId.getText())) {
                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    record.setIssuerName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getText());
                    record.setInstitutionName(row.findElement(By.xpath(".//td[contains(@class, 'idGInstitution')]")).getText());
                    record.setCountry(row.findElement(By.xpath(".//td[contains(@class, 'idGCountry')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                record.setId(null);
            }
        }

        return(record);

    }

    public IssuerDataRecord getDBDataById(String instId) throws Exception{

        IssuerDataRecord record = new IssuerDataRecord();

        try {

            String getIssByIdSQL = "SELECT CDI.ID, CDI.NAME, INST.NAME, CTRY.NAME " +
                    "FROM C_D_ISSUER CDI " +
                    "LEFT JOIN  C_D_INSTITUTION INST ON CDI.INSTITUTION_ID = INST.ID " +
                    "LEFT JOIN  C_S_COUNTRIES CTRY ON CDI.COUNTRY_CODE = CTRY.ID " +
                    "WHERE CDI.ID = ?";
            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setIssuerName(null);
                record.setInstitutionName(null);
                record.setCountry(null);
            }
            else{

                rs.next();

                record.setId(rs.getString(1));
                record.setIssuerName(rs.getString(2));
                record.setInstitutionName(rs.getString(3));
                record.setCountry(rs.getString(4));


            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

}
