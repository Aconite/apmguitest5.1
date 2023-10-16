package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class AdminCommon {

    public WebDriver webDriver;
    public OR_Admin orAdmin;

    public AdminCommon(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
    }

    public static String getDateTime(){

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);

    }

//    public ArrayList<String> getListData(WebElement obj) {
//
//        ArrayList<String> vals = new ArrayList<>();
//        obj.click();
//        for (WebElement item : orAdmin.dropDownItems()) {
//            vals.add(item.getText());
//        }
//        obj.click();
//
//        return (vals);
//
//    }

    public boolean setListValue(WebElement obj, String selValue) {

        boolean found = false;

        obj.click();

        for (WebElement item : orAdmin.dropDownItems()) {
            if (item.getText().startsWith(selValue)) {
                found = true;
                item.click();
                break;
            }
        }

        return found;

    }

    public int getDataRowCount(){

        return(orAdmin.tblRows().size());

    }

    public boolean isSelected(WebElement obj){

        boolean isSet;
        WebElement parent = obj.findElement(By.xpath("./ancestor::table"));
        isSet = parent.getAttribute("class").contains("x-form-cb-checked");
        return(isSet);

    }

    public void selectCheckbox(WebElement obj, String set){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);
        myWait.until(ExpectedConditions.elementToBeClickable(obj));

        boolean isSet = isSelected(obj);
        if(isSet && set.equals("false")){
            obj.click();
        }
        if(!isSet && set.equals("true")){
            obj.click();
        }
    }

    public void setSpinValue(WebElement obj, String set){

        int intNumber;
        int intSet = Integer.parseInt(set);

        System.out.println("In setSpinValue: " + obj.toString());
        System.out.println("In setSpinValue: " + set);

        obj.click();

        WebElement inputObj = obj.findElement(By.xpath("tbody//input[contains(@id,\"inputEl\")]"));

        String currentValue = getSpinValue(obj);
        if(currentValue.equals("")){
            intNumber = 0;
        }
        else{
            intNumber = Integer.parseInt(currentValue);
        }

        while(intSet>intNumber){

            inputObj.click();
            inputObj.sendKeys(Keys.ARROW_UP);
            currentValue = getSpinValue(obj);
            intNumber = Integer.parseInt(currentValue);
            System.out.println("Click Up: New Value = " + intNumber);
        }

        while(intSet<intNumber){
            inputObj.click();
            inputObj.sendKeys(Keys.ARROW_DOWN);
            currentValue = getSpinValue(obj);
            intNumber = Integer.parseInt(currentValue);
            System.out.println("Click Down: New Value = " + intNumber);
        }

    }

    public String getSpinValue(WebElement obj){

        String currentValue;

        System.out.println("In getSpinValue - OBJ = " + obj);
        WebElement inputObj = obj.findElement(By.xpath("tbody//input[contains(@id,\"inputEl\")]"));
        currentValue = inputObj.getAttribute("value");

        System.out.println("In getSpinValue: " + inputObj);
        System.out.println(("In getSpinValue: " + currentValue));

        return currentValue;

    }

    public void searchInstitutionAndIssuer(String institution, String issuer){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));
        setListValue(orAdmin.selSearchInstitution(), institution);

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchIssuer()));
        setListValue(orAdmin.selSearchIssuer(), issuer);

        orAdmin.btnSearch().click();
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public void searchInstitution(String institution){

        WebDriverWait myWait = new WebDriverWait(webDriver, 10);

        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));
        setListValue(orAdmin.selSearchInstitution(), institution);

        orAdmin.btnSearch().click();

    }

    public void clickAddButton(){

        WebDriverWait myWait = new WebDriverWait(webDriver, 30);
        myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));

        orAdmin.btnAdd().click();
    }


    public void clickEditById(WebElement table, String id){

        sleep(500);
        List<WebElement> rows = table.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        for(WebElement row : rows){
            WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
            if(id.equals(cellId.getText())) {
                WebElement btnEdit = row.findElement(By.xpath(".//img[contains(@src, 'edit.png')]"));
                btnEdit.click();
                break;
            }
        }
    }
    public boolean clickEditById_Country(WebElement table, String id){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;

        orAdmin.btnCountryRefresh().click();
        orAdmin.btnCountryTableFirst().click();

        do {

            boolean found = false;
            sleep(500);
            List<WebElement> rows = table.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGCode')]"));
                if (id.equals(cellId.getText())) {
                    found = true;
                    WebElement btnEdit = row.findElement(By.xpath(".//img[contains(@src, 'edit.png')]"));
                    try {
                        btnEdit.click();
                    }
                    catch (ElementClickInterceptedException ignored){}
                    System.out.println("Clicked");
                    break;
                }
            }

            if (!found) {

                thisPageString = orAdmin.txtCountryTablePageCount().getText();
                pageArray = thisPageString.split(" ");
                lastItem = Integer.parseInt(pageArray[4]);
                itemCount = Integer.parseInt(pageArray[6]);

                System.out.println("Last Item: " + lastItem + "\nItem Count: " + itemCount);

                if(lastItem < itemCount){
                    // go to next page
                    orAdmin.btnCountryTableNext().click();
                }
                else{
                    return false;
                }
            }
            else{
                break;
            }


        }while (lastItem < itemCount);

        System.out.println("Finished");
        return true;

    }

    public void clickEditByName(WebElement table, String name){

        List<WebElement> rows = table.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        for(WebElement row : rows){
            WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
            if(cellId.getText().equals(name)) {
                WebElement btnEdit = row.findElement(By.xpath(".//img[contains(@src, 'edit.png')]"));
                btnEdit.click();
                return;
            }
        }
    }

    public void clickDeleteById(WebElement table, String id){

        List<WebElement> rows = table.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        for(WebElement row : rows){
            WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGId') or contains(@class, 'idGID')]"));
            if(id.equals(cellId.getText())) {
                WebElement btnDelete = row.findElement(By.xpath(".//img[contains(@src, 'delete.gif')]"));
                btnDelete.click();
                break;
            }
        }
    }

    public void clickDeleteByName(WebElement table, String name){

        List<WebElement> rows = table.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        for(WebElement row : rows){
            WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idGNam')]"));
            if(name.equals(cellId.getText())) {
                WebElement btnDelete = row.findElement(By.xpath(".//img[contains(@src, 'delete.gif')]"));
                btnDelete.click();
                break;
            }
        }
    }

    public void sleep(int milli){
        try {
            Thread.sleep(milli);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean clickBtnOk(){

        try{
            WebDriverWait myWait = new WebDriverWait(webDriver, 30);
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));
            orAdmin.btnOK().click();
            sleep(500);

        }
        catch(StaleElementReferenceException | NoSuchElementException | ElementNotInteractableException e){
            return false;
        }

        return true;
    }

    public String clickBtnYes(){

        String output;

        try{
            WebDriverWait myWait = new WebDriverWait(webDriver, 30);
            myWait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnYes()));
            output = orAdmin.txtMsg().getText();
            orAdmin.btnYes().click();
            sleep(500);
        }
        catch(StaleElementReferenceException | NoSuchElementException e){
            return "false";
        }

        return output;

    }

    public boolean findObjectByColumn(WebElement list, String columnName, String value){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;

        WebElement btnRefresh = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Refresh\"]"));
        WebElement hdrColumnName = list.findElement(By.xpath("//span[@class=\"x-column-header-text\" and contains(text(),\"" + columnName + "\")]"));
        WebElement btnTableLast = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Last Page\"]"));
        WebElement btnTableFirst = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"First Page\"]"));
        WebElement btnTableNext = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Next Page\"]"));
        WebElement txtPageCount = list.findElement(By.xpath("//div[contains(@id,'tbtext') and contains(text(),\"Displaying items\")]"));

        String[] idText = hdrColumnName.getAttribute("id").split("-");

        btnRefresh.click();
        sleep(500);
        hdrColumnName.click();
        sleep(500);
        btnTableLast.click();
        sleep(500);
        btnTableFirst.click();
        sleep(500);

        do {

            boolean found = false;
            sleep(500);
            List<WebElement> rows = list.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, '" + idText[0] + "')]"));
                if (value.equals(cellId.getText())) {
                    found = true;
                    break;
                }
            }

            if (!found) {

                thisPageString = txtPageCount.getText();
                pageArray = thisPageString.split(" ");
                lastItem = Integer.parseInt(pageArray[4]);
                itemCount = Integer.parseInt(pageArray[6]);

                if(lastItem < itemCount){
                    btnTableNext.click();
                }
                else{
                    return false;
                }
            }
            else{
                break;
            }

        }while (lastItem < itemCount);

        return true;

    }

    public String getIdByColumn(WebElement list, String columnName, String value){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;
        String out = null;

        WebElement btnRefresh = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Refresh\"]"));
        WebElement hdrColumnName = list.findElement(By.xpath("//span[@class=\"x-column-header-text\" and contains(text(),\"" + columnName + "\")]"));
        WebElement btnTableLast = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Last Page\"]"));
        WebElement btnTableFirst = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"First Page\"]"));
        WebElement btnTableNext = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Next Page\"]"));
        WebElement txtPageCount = list.findElement(By.xpath("//div[contains(@id,'tbtext') and contains(text(),\"Displaying items\")]"));

        String[] idText = hdrColumnName.getAttribute("id").split("-");

        btnRefresh.click();
        sleep(500);
        hdrColumnName.click();
        sleep(500);
        btnTableLast.click();
        sleep(500);
        btnTableFirst.click();
        sleep(500);

        do {

            boolean found = false;
            sleep(500);
            List<WebElement> rows = list.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, '" + idText[0] + "')]"));
                if (value.equals(cellId.getText())) {
                    found = true;
                    out = row.findElement(By.xpath(".//td[contains(@class, 'idGId')]")).getText();
                    break;
                }
            }

            if (!found) {

                thisPageString = txtPageCount.getText();
                pageArray = thisPageString.split(" ");
                lastItem = Integer.parseInt(pageArray[4]);
                itemCount = Integer.parseInt(pageArray[6]);

                if(lastItem < itemCount){
                    btnTableNext.click();
                }
                else{
                    return null;
                }
            }
            else{
                break;
            }

        }while (lastItem < itemCount);

        return out;

    }

    public boolean clickEditByColumn(WebElement list, String columnName, String value){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;

        WebElement btnRefresh = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Refresh\"]"));
        WebElement hdrColumnName = list.findElement(By.xpath("//span[@class=\"x-column-header-text\" and text()=\"" + columnName + "\"]"));
        WebElement btnTableLast = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Last Page\"]"));
        WebElement btnTableFirst = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"First Page\"]"));
        WebElement btnTableNext = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Next Page\"]"));
        WebElement txtPageCount = list.findElement(By.xpath("//div[contains(@id,'tbtext') and contains(text(),\"Displaying items\")]"));

        String headerId = hdrColumnName.getAttribute("id");
        String[] idText = headerId.split("-");

        btnRefresh.click();
        sleep(500);
        try {
            hdrColumnName.click();
        }
        catch( Exception ElementNotInteractableException ){
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("window.document.getElementById('" + headerId + "').click()");
        }
        sleep(500);
        btnTableLast.click();
        sleep(500);
        btnTableFirst.click();
        sleep(500);

        do {

            boolean found = false;
            sleep(500);
            List<WebElement> rows = list.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, '" + idText[0] + "')]"));
                if (value.equals(cellId.getText())) {
                    found = true;
                    WebElement btnEdit = row.findElement(By.xpath(".//img[contains(@src, 'edit.png')]"));
                    btnEdit.click();
                    break;
                }
            }

            if (!found) {

                thisPageString = txtPageCount.getText();
                pageArray = thisPageString.split(" ");
                lastItem = Integer.parseInt(pageArray[4]);
                itemCount = Integer.parseInt(pageArray[6]);

                if(lastItem < itemCount){
                    btnTableNext.click();
                }
                else{
                    return false;
                }
            }
            else{
                break;
            }

        }while (lastItem < itemCount);

        return true;

    }

    public boolean clickDeleteByColumn(WebElement list, String columnName, String value){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;

        WebElement btnRefresh = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Refresh\"]"));
        WebElement hdrColumnName = list.findElement(By.xpath("//span[@class=\"x-column-header-text\" and text()=\"" + columnName + "\"]"));
        WebElement btnTableLast = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Last Page\"]"));
        WebElement btnTableFirst = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"First Page\"]"));
        WebElement btnTableNext = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Next Page\"]"));
        WebElement txtPageCount = list.findElement(By.xpath("//div[contains(@id,'tbtext') and contains(text(),\"Displaying items\")]"));

        String headerId = hdrColumnName.getAttribute("id");
        String[] idText = headerId.split("-");

        btnRefresh.click();
        sleep(500);
        try {
            hdrColumnName.click();
        }
        catch( Exception ElementNotInteractableException ){
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("window.document.getElementById('" + headerId + "').click()");
        }
        sleep(500);
        btnTableLast.click();
        sleep(500);
        btnTableFirst.click();
        sleep(500);

        do {

            boolean found = false;
            sleep(500);
            List<WebElement> rows = list.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, '" + idText[0] + "')]"));
                if (value.equals(cellId.getText())) {
                    found = true;
                    WebElement btnDelete = row.findElement(By.xpath(".//img[contains(@src, 'delete.gif')]"));
                    btnDelete.click();
                    break;
                }
            }

            if (!found) {

                thisPageString = txtPageCount.getText();
                pageArray = thisPageString.split(" ");
                lastItem = Integer.parseInt(pageArray[4]);
                itemCount = Integer.parseInt(pageArray[6]);

                if(lastItem < itemCount){
                    btnTableNext.click();
                }
                else{
                    return false;
                }
            }
            else{
                break;
            }

        }while (lastItem < itemCount);

        return true;

    }

    public boolean checkReadOnly(String testItem){

        int lastItem;
        int itemCount;
        String thisPageString;
        String[] pageArray;
        boolean res = true;
        WebElement list = null;

        switch(testItem){

            case "Token Product Groups":
                list = orAdmin.tblTokenProductGroupsList();
                break;

            case "Institutions":
                list = orAdmin.tblInstitutionList();
                break;

            case "Issuers":
                list = orAdmin.tblIssuerList();
                break;

            case "Task Scheduler":
                list = orAdmin.tblTaskSchedulerList();
                break;

            case "Interfaces":
                list = orAdmin.tblInterfaceList();
                break;

            case "Perso Bureau":
                list = orAdmin.tblPersoBureauList();
                break;

        }

        WebElement btnRefresh = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Refresh\"]"));
        WebElement btnTableLast = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Last Page\"]"));
        WebElement btnTableFirst = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"First Page\"]"));
        WebElement btnTableNext = list.findElement(By.xpath("//button[contains(@id,'btnEl') and @data-qtip=\"Next Page\"]"));
        WebElement txtPageCount = list.findElement(By.xpath("//div[contains(@id,'tbtext') and contains(text(),\"Displaying\")]"));

        btnRefresh.click();
        sleep(500);
        btnTableLast.click();
        sleep(500);
        btnTableFirst.click();
        sleep(500);

        do {

            sleep(500);
            List<WebElement> rows = list.findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
            for (WebElement row : rows) {
                WebElement actionCell = row.findElement(By.xpath(".//td[contains(@class, 'actioncolumn')]"));
                List<WebElement> images = actionCell.findElements(By.xpath(".//img[contains(@src,\"data:image\") and contains(@class,\"icon\")]"));
                for(int i = 0; i < images.size(); i++){
                    System.out.println("Image " + i + " (" + images.get(i).getAttribute("data-qtip") + "): " + images.get(i).getAttribute("class"));
                    if(!images.get(i).getAttribute("class").contains("disabled")){
                        res = false;
                    }
                }
            }

            thisPageString = txtPageCount.getText();
            pageArray = thisPageString.split(" ");
            lastItem = Integer.parseInt(pageArray[4]);
            itemCount = Integer.parseInt(pageArray[6]);

            if(lastItem < itemCount){
                btnTableNext.click();
            }

        }while (lastItem < itemCount);

        return res;

    }



}
