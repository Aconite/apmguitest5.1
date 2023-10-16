package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.*;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TokenProductsPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    public AdminCommon adminCommon;

    public TokenProductsPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }


    /********************************
     * Main Page Functions
     ********************************/

    public boolean isPageOpened() {

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnSearch()));
        return orAdmin.spanTokenProductSearchHeader().isDisplayed();
    }

    public void clickDetailCreateButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailCreate()));

        orAdmin.btnTokenProductDetailCreate().click();

    }

    public void clickDetailCancelButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailCancel()));

        orAdmin.btnTokenProductDetailCancel().click();

    }

    public boolean checkRequiredFieldMessages(String field, String message) {

        boolean rc = true;

        // STARTING POINT: On Token Product Page - Token Product Detail window is open
        switch (field) {

            case("Name"):
                if (!orAdmin.txtTokenProductDetailName().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("IssuerTokenProductCode"):
                if (!orAdmin.txtTokenProductDetailIssuerTokenProductCode().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("Issuer"):
                if (!orAdmin.selTokenProductDetailIssuer().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("TokenProductGroup"):
                if (!orAdmin.selTokenProductDetailTokenProductGroup().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("Country"):
                if (!orAdmin.selTokenProductDetailCountry().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("Language"):
                if (!orAdmin.selTokenProductDetailLanguage().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PersoBureau"):
                if (!orAdmin.selTokenProductDetailPersoBureau().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;

    }


    public TokenProductDataRecord getTokenProductListRecordByName(TokenProductDataRecord issuerTokenProductName){

        List<WebElement> rows = orAdmin.tblTokenProductList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if (rows.size() == 0){
            issuerTokenProductName.setId(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {
                WebElement cellName = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
                if (issuerTokenProductName.getName().equals(cellName.getText())) {
                    issuerTokenProductName.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]")).getText());
                    found = true;
                    break;
                }
            }
            if(!found){
                issuerTokenProductName.setId(null);
            }
        }

        return(issuerTokenProductName);

    }

    public void clickEditTokenProductById(String id){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        int rowCount = adminCommon.getDataRowCount();

        for(int i = 1; i <= rowCount; i++){
            WebElement cell = orAdmin.tblTokenProductList().findElement(By.xpath("(//td[contains(@class, \"idGID\")])[" + i + "]"));
            if(cell.getAttribute("textContent").equals(id)){
                // press the id key
                int j = i+1;
                WebElement btnEdit =  orAdmin.tblTokenProductList().findElement(By.xpath("//tr[" + j + "]//img[contains(@src, \"edit.png\")]"));
                btnEdit.click();
                myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailSave()));
                break;
            }
        }

    }

    public boolean clickDeleteTokenProductById(TokenProductDataRecord delTokenProduct){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(delTokenProduct.getParentInstitution(), delTokenProduct.getParentIssuer());

        // Click delete
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblTokenProductList()));
        adminCommon.clickDeleteById(orAdmin.tblTokenProductList(), delTokenProduct.getId());

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

    public void dblClickTokenProductById(String id){

        Actions action = new Actions(webDriver);
        boolean found = false;

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        int rowCount = adminCommon.getDataRowCount();

        for(int i = 1; i <= rowCount; i++){
            WebElement cell = orAdmin.tblTokenProductList().findElement(By.xpath("(//td[contains(@class, \"idGID\")])[" + i + "]"));
            if(cell.getAttribute("textContent").equals(id)){
                found = true;
                // press the id key
                cell.click();
                action.moveToElement(cell).doubleClick().perform();
                myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
                break;
            }
        }

        if(!found){
            System.out.println("dblClickTokenProductById - ID " + id + " not found");
        }

    }

    public TokenProductDataRecord enterTokenProductCodeData(TokenProductDataRecord newTokenProduct){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);

        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
        orAdmin.btnAdd().click();

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailCreate()));

        orAdmin.txtTokenProductDetailName().sendKeys(newTokenProduct.getName());
        orAdmin.txtTokenProductDetailIssuerTokenProductCode().sendKeys(newTokenProduct.getIssuerTokenProductCode());
        adminCommon.setListValue(orAdmin.selTokenProductDetailIssuer(), newTokenProduct.getIssuer());
        adminCommon.setListValue(orAdmin.selTokenProductDetailTokenProductGroup(), newTokenProduct.getTokenProductGroup());
        orAdmin.txtTokenProductDetailRetentionDays().clear();
        orAdmin.txtTokenProductDetailRetentionDays().sendKeys(newTokenProduct.getRetentionDays());
        adminCommon.setListValue(orAdmin.selTokenProductDetailCountry(), newTokenProduct.getCountry());
        adminCommon.setListValue(orAdmin.selTokenProductDetailLanguage(), newTokenProduct.getLanguage());
        adminCommon.setListValue(orAdmin.selTokenProductDetailPersoBureau(), newTokenProduct.getPersoBureau());
        adminCommon.selectCheckbox(orAdmin.cbxTokenProductDetailFeedbackRequired(),newTokenProduct.getFeedbackRequired());
        adminCommon.selectCheckbox(orAdmin.cbxTokenProductDetailActive(),newTokenProduct.getActive());
        orAdmin.txtTokenProductDetailServiceCode().clear();
        orAdmin.txtTokenProductDetailServiceCode().sendKeys(newTokenProduct.getServiceCode());

        orAdmin.btnTokenProductDetailCreate().click();

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();
        if(!output.contains("successfully")){
            newTokenProduct = null;
        }
        else{
            orAdmin.btnOK().click();
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

            TokenProductDataRecord newRecord;
            newRecord = getTokenProductListRecordByName(newTokenProduct);

            String newId = newRecord.getId();
            newTokenProduct.setId(newId);

        }

        return newTokenProduct;

    }

    public boolean editTokenProductCodeData(TokenProductDataRecord editTokenProductCode, String instField){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));
        adminCommon.searchInstitutionAndIssuer(editTokenProductCode.getParentInstitution(), editTokenProductCode.getParentIssuer());
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

//        clickEditTokenProductById(editTokenProductCode.getId());
        adminCommon.clickEditById(orAdmin.tblTokenProductList(), editTokenProductCode.getId());
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailSave()));

        switch(instField) {

            case ("Name"):
                orAdmin.txtTokenProductDetailName().clear();
                orAdmin.txtTokenProductDetailName().sendKeys(editTokenProductCode.getName());
                break;

            case("IssuerTokenProductCode"):
                orAdmin.txtTokenProductDetailIssuerTokenProductCode().clear();
                orAdmin.txtTokenProductDetailIssuerTokenProductCode().sendKeys(editTokenProductCode.getIssuerTokenProductCode());
                break;

            case("Issuer"):
                adminCommon.setListValue(orAdmin.selTokenProductDetailIssuer(), editTokenProductCode.getIssuer());
                break;

            case("TokenProductGroup"):
                adminCommon.setListValue(orAdmin.selTokenProductDetailTokenProductGroup(), editTokenProductCode.getTokenProductGroup());
                break;

            case("RetentionDays"):
                orAdmin.txtTokenProductDetailRetentionDays().clear();
                orAdmin.txtTokenProductDetailRetentionDays().sendKeys(editTokenProductCode.getRetentionDays());
                break;

            case("Country"):
                adminCommon.setListValue(orAdmin.selTokenProductDetailCountry(), editTokenProductCode.getCountry());
                break;

            case("Language"):
                adminCommon.setListValue(orAdmin.selTokenProductDetailLanguage(), editTokenProductCode.getLanguage());
                break;

            case("PersoBureau"):
                adminCommon.setListValue(orAdmin.selTokenProductDetailPersoBureau(), editTokenProductCode.getPersoBureau());
                break;

            case("FeedbackRequired"):
                adminCommon.selectCheckbox(orAdmin.cbxTokenProductDetailFeedbackRequired(),editTokenProductCode.getFeedbackRequired());
                break;

            case("Active"):
                adminCommon.selectCheckbox(orAdmin.cbxTokenProductDetailActive(),editTokenProductCode.getActive());
                break;

            case("ServiceCode"):
                orAdmin.txtTokenProductDetailServiceCode().clear();
                orAdmin.txtTokenProductDetailServiceCode().sendKeys(editTokenProductCode.getServiceCode());
                break;

        }

        // Click the Save button
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailSave()));
        orAdmin.btnTokenProductDetailSave().click();

        // Check the message and click OK
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();
        if (!output.contains("successfully updated")) {
            return(false);
        }

        orAdmin.btnOK().click();
        clickTokenProductRefresh();

        return(true);

    }

    public void clickTokenProductRefresh(){

        Actions action = new Actions(webDriver);

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductRefresh()));
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        action.moveToElement(orAdmin.btnTokenProductRefresh()).doubleClick().perform();
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductRefresh()));


    }

    public TokenProductDataRecord getTableDataById(TokenProductDataRecord editTPG){

        TokenProductDataRecord record = new TokenProductDataRecord();

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(editTPG.getParentInstitution(), editTPG.getParentIssuer());

        List<WebElement> rows = orAdmin.tblTokenProductList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
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
                    record.setIssuerTokenProductCode(row.findElement(By.xpath(".//td[contains(@class, 'idGIPCode')]")).getText());
                    record.setIssuer(row.findElement(By.xpath(".//td[contains(@class, 'idGIssuer')]")).getText());
                    record.setTokenProductGroup(row.findElement(By.xpath(".//td[contains(@class, 'idGTokenProductGroupID')]")).getText());
                    record.setRetentionDays(row.findElement(By.xpath(".//td[contains(@class, 'idGRetentionDays')]")).getText());
                    record.setCountry(row.findElement(By.xpath(".//td[contains(@class, 'idGCountryCode')]")).getText());
                    record.setLanguage(row.findElement(By.xpath(".//td[contains(@class, 'idGLanguangeCode')]")).getText());
                    record.setPersoBureau(row.findElement(By.xpath(".//td[contains(@class, 'idGPersoBureauID')]")).getText());
                    record.setFeedbackRequired(row.findElement(By.xpath(".//td[contains(@class, 'idGFeedbacksRequired')]")).getText());
                    record.setActive(row.findElement(By.xpath(".//td[contains(@class, 'idGstatus')]")).getText());
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

    public TokenProductDataRecord getDBDataById(String instId) throws Exception{

        TokenProductDataRecord record = new TokenProductDataRecord();

        try {

            String getIssByIdSQL = "SELECT CDTP.ID, CDTP.NAME, CDTP.ISSUER_TOKEN_PRODUCT_CODE, CDI.NAME AS ISSUER, CDTPG.NAME AS \"TOKEN PRODUCT GROUP\", CDTP.RETENTION_DAYS, CTRY.NAME AS COUNTRY, CDTP.LANGUAGE_CODE, IDPB.NAME AS \"PERSO BUREAU\", CDTP.FEEDBACK_REQUIRED_FLAG, CDTP.STATUS, CDTP.SERVICE_CODE " +
                    "FROM C_D_TOKEN_PRODUCT CDTP " +
                    "LEFT JOIN C_D_ISSUER CDI ON CDTP.ISSUER_ID = CDI.ID " +
                    "LEFT JOIN C_D_TOKEN_PRODUCT_GROUP CDTPG ON CDTP.TOKEN_PRODUCT_GROUP_ID = CDTPG.ID " +
                    "LEFT JOIN C_S_COUNTRIES CTRY ON CDTP.COUNTRY_CODE = CTRY.ID " +
                    "LEFT JOIN INT_D_PERSO_BUREAU IDPB ON CDTP.PERSO_BUREAU_ID = IDPB.ID " +
                    "WHERE CDTP.ID = ?";

            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(getIssByIdSQL);
            preparedSelect.setString(1, instId);
            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){
                record.setId(null);
                record.setName(null);
                record.setIssuerTokenProductCode(null);
                record.setIssuer(null);
                record.setTokenProductGroup(null);
                record.setRetentionDays(null);
                record.setCountry(null);
                record.setLanguage(null);
                record.setPersoBureau(null);
                record.setFeedbackRequired("N");
                record.setActive("N");
                record.setServiceCode(null);
            }
            else{

                rs.next();

                record.setId(rs.getString(1));
                record.setName(rs.getString(2));
                record.setIssuerTokenProductCode(rs.getString(3));
                record.setIssuer(rs.getString(4));
                record.setTokenProductGroup(rs.getString(5));
                record.setRetentionDays(rs.getString(6));
                record.setCountry(rs.getString(7));
                record.setLanguage(rs.getString(8));
                record.setPersoBureau(rs.getString(9));
                record.setFeedbackRequired(rs.getString(10));
                record.setActive(rs.getString(11));
                record.setServiceCode(rs.getString(12));

            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }

    public ArrayList<String> getInstitutions() throws Exception{

        ArrayList<String> institutions = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT NAME FROM C_D_INSTITUTION";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            institutions.add(rs.getString(1));

        }

        return(institutions);

    }

    public ArrayList<String> getPersoBureauNames() throws Exception{

        ArrayList<String> persoBureauNames = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT name FROM int_d_perso_bureau";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            persoBureauNames.add(rs.getString(1));

        }

        return(persoBureauNames);

    }

    public ArrayList<String> getIssuers(TokenProductDataRecord newRecord) throws Exception{

        ArrayList<String> issuers = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT NAME FROM C_D_ISSUER WHERE INSTITUTION_ID = (SELECT ID FROM C_D_INSTITUTION WHERE NAME = ?)";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        preparedSelect.setString(1, newRecord.getParentInstitution());
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            issuers.add(rs.getString(1));

        }

        return(issuers);

    }

    public ArrayList<String> getLanguages() throws Exception{

        ArrayList<String> languages = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT CONCAT(CONCAT(CONCAT(LANGUAGE_CODE, ' ('),NAME),')') FROM C_S_LANGUAGE";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            languages.add(rs.getString(1));

        }

        return(languages);

    }

    public ArrayList<String> getCountries() throws Exception{

        ArrayList<String> countries = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT NAME FROM C_S_COUNTRIES";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            countries.add(rs.getString(1));

        }

        return(countries);

    }

    public ArrayList<String> getTokenProductGroups(TokenProductDataRecord newRecord) throws Exception{

        ArrayList<String> tokenProductGroups = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String SQL =   "SELECT NAME FROM C_D_TOKEN_PRODUCT_GROUP WHERE ISSUER_ID = (SELECT ID FROM C_D_ISSUER WHERE NAME = '" + newRecord.getParentIssuer() + "')";
        PreparedStatement preparedSelect = connection.prepareStatement(SQL);
        ResultSet rs = preparedSelect.executeQuery();

        while (rs.next())
        {
            tokenProductGroups.add(rs.getString(1));

        }

        return(tokenProductGroups);

    }

    public void clickAddBtn(){

        orAdmin.btnAdd().click();
        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenProductDetailCancel()));

    }

    public void clickCancelBtn(){

        orAdmin.btnTokenProductDetailCancel().click();
        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

    }


}




