package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.records.TokenProductGroupDataRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;


public class TokenProductGroupsPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public TokenProductGroupsPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public boolean isPageOpened() {
        return orAdmin.spanTokenProductGroupsTableHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductGroupsDetailCreate()));

        orAdmin.btnTokenProductGroupsDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductGroupsDetailCancel()));

        orAdmin.btnTokenProductGroupsDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On Issuer Page - Issuer Detail window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtTokenProductGroupsDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("Issuer"):
                if (!orAdmin.selTokenProductGroupsDetailIssuer().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }

    public TokenProductGroupDataRecord enterTokenProductGroupData(TokenProductGroupDataRecord newTPG){

        TokenProductGroupDataRecord newRecord;

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.setListValue(orAdmin.selSearchInstitution(), newTPG.getParentInstitution());
        adminCommon.setListValue(orAdmin.selSearchIssuer(), newTPG.getParentIssuer());
        orAdmin.btnSearch().click();

        // Click Add button
        orAdmin.btnAdd().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductGroupsDetailCancel()));

        orAdmin.txtTokenProductGroupsDetailName().sendKeys(newTPG.getName());
        adminCommon.setListValue(orAdmin.selTokenProductGroupsDetailIssuer(), newTPG.getIssuer());
        orAdmin.txtTokenProductGroupsDetailGroupCode().sendKeys(newTPG.getGroupCode());

        orAdmin.btnTokenProductGroupsDetailCreate().click();

        // Deal with the confirmation pop up
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();

        if(output.contains("successfully added")){
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenProductGroupsList()));

            // get the row data by institution name and get the id to return
            newRecord = getTokenProductGroupListRecordByName(newTPG);
        }
        else{
            newRecord=null;
        }

        return(newRecord);


    }

    public boolean editTokenProductGroupData(TokenProductGroupDataRecord editTPG, String tpgField){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(editTPG.getParentInstitution(), editTPG.getParentIssuer());
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenProductGroupsList()));

//        clickEditTokenProductGroupById(editTPG.getId());
        adminCommon.clickEditById(orAdmin.tblTokenProductGroupsList(), editTPG.getId());

        // Edit the field required
        switch(tpgField){

            case("Name"):
                orAdmin.txtTokenProductGroupsDetailName().clear();
                orAdmin.txtTokenProductGroupsDetailName().sendKeys(editTPG.getName());
                break;

            case("Issuer"):
                adminCommon.setListValue(orAdmin.selTokenProductGroupsDetailIssuer(), editTPG.getIssuer());
                break;

             case("GroupCode"):
                orAdmin.txtTokenProductGroupsDetailGroupCode().clear();
                orAdmin.txtTokenProductGroupsDetailGroupCode().sendKeys(editTPG.getGroupCode());
                break;

        }

        // Click the Save button
        orAdmin.btnTokenProductGroupsDetailSave().click();

        // Check the message and click OK
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();
        if (!output.contains("successfully updated")) {
            return(false);
        }

        orAdmin.btnOK().click();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

        return(true);

    }

    public boolean deleteTokenProductGroupById(TokenProductGroupDataRecord delTPG){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(delTPG.getParentInstitution(), delTPG.getParentIssuer());

        // Click delete
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenProductGroupsList()));
        adminCommon.clickDeleteById(orAdmin.tblTokenProductGroupsList(), delTPG.getId());

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

    public TokenProductGroupDataRecord getTokenProductGroupListRecordByName(TokenProductGroupDataRecord tpgName){

        List<WebElement> rows = orAdmin.tblTokenProductGroupsList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            tpgName.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (tpgName.getName().equals(cellName.getText())) {
                    tpgName.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                tpgName.setId(null);
            }
        }

        return(tpgName);

    }

    public TokenProductGroupDataRecord getTableDataById(TokenProductGroupDataRecord editTPG){

        TokenProductGroupDataRecord record = new TokenProductGroupDataRecord();

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(editTPG.getParentInstitution(), editTPG.getParentIssuer());

        List<WebElement> rows = orAdmin.tblTokenProductGroupsList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            record.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
                if (editTPG.getId().equals(cellId.getText())) {
                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    record.setName(row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]")).getText());
                    record.setIssuer(row.findElement(By.xpath(".//td[contains(@class, 'idGIssuer')]")).getText());
                    record.setGroupCode(row.findElement(By.xpath(".//td[contains(@class, 'idGGroupCode')]")).getText());
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

    public TokenProductGroupDataRecord getDBDataById(TokenProductGroupDataRecord editTPG) throws Exception{

        TokenProductGroupDataRecord record = new TokenProductGroupDataRecord();

        try {

            String getTPGByIdSQL = "SELECT CDTPG.ID, CDTPG.NAME,  CDI.NAME, CDTPG.GROUP_CODE " +
                    "FROM C_D_TOKEN_PRODUCT_GROUP CDTPG " +
                    "LEFT JOIN  C_D_ISSUER CDI ON CDTPG.ISSUER_ID = CDI.ID " +
                    "WHERE CDTPG.ID = ?";

            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getTPGByIdSQL);
            preparedSelect.setString(1, editTPG.getId());
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setName(null);
                record.setIssuer(null);
                record.setGroupCode(null);

            }
            else{

                rs.next();

                record.setId(rs.getString(1));
                record.setName(rs.getString(2));
                record.setIssuer(rs.getString(3));
                record.setGroupCode(rs.getString(4));

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }



}
