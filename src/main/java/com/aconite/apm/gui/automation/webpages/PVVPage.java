package com.aconite.apm.gui.automation.webpages;

import com.aconite.apm.gui.automation.objectrepository.OR_Admin;
import com.aconite.apm.gui.automation.records.PVVDataRecord;
import com.aconite.apm.gui.automation.records.TokenProductDataRecord;
import com.aconite.apm.gui.automation.utilities.DatabaseConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class PVVPage {

    public WebDriver webDriver;
    public OR_Admin orAdmin;
    private final TokenProductsPage tokenProductsPage;
    private final TokenApplicationProfilePage tokenApplicationProfilePage;
    public AdminCommon adminCommon;

    public PVVPage(WebDriver webDriver){

        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        orAdmin = new OR_Admin(this.webDriver);
        tokenProductsPage = new TokenProductsPage(webDriver);
        tokenApplicationProfilePage = new TokenApplicationProfilePage(webDriver);
        adminCommon = new AdminCommon(this.webDriver);
    }

    public void clickAddPVV(){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);

        orAdmin.btnPVVAdd().click();
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVAdd()));

    }

    public void clickCreatePVV(){

        orAdmin.btnPVVDetailCreate().click();

    }

    public void clickCancelPVV(){

        orAdmin.btnPVVDetailCancel().click();

    }

    public boolean deletePVV(PVVDataRecord recordEditPVV){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.selSearchInstitution()));

        adminCommon.searchInstitutionAndIssuer(recordEditPVV.getParentInstitution(), recordEditPVV.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordEditPVV.getParentTokenProductId());
        tokenApplicationProfilePage.dblClickTokenApplicationProfileByName(recordEditPVV.getParentTokenApplicationProfileName());


        // Click delete
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblPVVList()));
        adminCommon.clickDeleteById(orAdmin.tblPVVList(), recordEditPVV.getId());

        // Click Yes
        String out = adminCommon.clickBtnYes();
        if (!out.equals("false")){
            // Click OK
            if(!adminCommon.clickBtnOk()){
                return false;
            }
        }

        return true;

//        // Search the Institution and Issuer  and double click the Token Product
//        TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
//        recordSearchTokenProduct.setParentInstitution(recordEditPVV.getParentInstitution());
//        recordSearchTokenProduct.setParentIssuer(recordEditPVV.getParentIssuer());
//        recordSearchTokenProduct.setId(recordEditPVV.getParentTokenProductId());
//
//
//        adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
//        tokenProductsPage.dblClickTokenProductById(recordSearchTokenProduct.getId());
//
//        //Double click the Token Application Profile
//        tokenApplicationProfilePage.dblClickTokenApplicationProfileByName(recordEditPVV.getParentTokenApplicationProfileName());
//
//        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVAdd()));
//        try {
//            Thread.sleep(1000);
//        }
//        catch(InterruptedException e){
//            e.printStackTrace();
//        }
//
//        int rowCount = adminCommon.getDataRowCount();
//
//        for(int i = 1; i <= rowCount; i++){
//            WebElement thisRow = this.webDriver.findElement(By.xpath("(//div[@id=\"idPVVList-body\"]//tr[contains(@class,\"x-grid-row\")])[" + i + "]"));
//            String thiId = thisRow.findElement(By.xpath("(./td[contains(@class, \"idGID\")])[" + i + "]")).getAttribute("textContent");
//
//            if(thiId.equals(recordEditPVV.getId())){
//                // press the id key
//                int j = i+1;
//                WebElement btnDelete2 =  thisRow.findElement(By.xpath("./td[contains(@class,\"actioncolumn\")]//img[contains(@src, \"delete.gif\")]"));
//                btnDelete2.click();
//                break;
//            }
//        }
//
//        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnYes()));
//        String output = orAdmin.txtMsg().getText();
//
//        if(output.contains("Are you sure")){
//            orAdmin.btnYes().click();
//            mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));
//
//            orAdmin.btnOK().click();
//            mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnAdd()));
//        }
//        else{
//            System.out.println("THERE'S NO MESSAGE");
//        }

    }

    public boolean checkRequiredFieldMessages(String field, String message){

        boolean rc = true;

        switch(field) {


            case("TokenProduct"):
                if (!orAdmin.selPVVDetailTokenProduct().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("AppSequenceNumber"):
                if (!orAdmin.txtPVVDetailAppSeqNumber().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case ("PVKIdentifier"):
                if (!orAdmin.txtPVVDetailPvkIdentifier().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinVerificationMethod"):
                if (!orAdmin.selPVVDetailPinVerificationMethod().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

            case("PinVerificationKey"):
                if (!orAdmin.selPVVDetailPinVerificationKey().getAttribute("data-errorqtip").contains(message)){
                    rc = false;
                }
                break;

        }

        return rc;
    }

    public PVVDataRecord enterPVVData(PVVDataRecord recordNewPVV){

        // Search the Institution and Issuer  and double click the Token Product
        TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
        recordSearchTokenProduct.setParentInstitution(recordNewPVV.getParentInstitution());
        recordSearchTokenProduct.setParentIssuer(recordNewPVV.getParentIssuer());
        recordSearchTokenProduct.setId(recordNewPVV.getParentTokenProductId());


        adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordSearchTokenProduct.getId());

        //Double click the Token Application Profile
        tokenApplicationProfilePage.dblClickTokenApplicationProfileByName(recordNewPVV.getParentTokenApplicationProfileName());


        WebDriverWait mywait = new WebDriverWait(webDriver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVAdd()));
        orAdmin.btnPVVAdd().click();

        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVDetailCreate()));

        adminCommon.setListValue(orAdmin.selPVVDetailTokenProduct(), recordNewPVV.getParentTokenProduct());
        orAdmin.txtPVVDetailAppSeqNumber().sendKeys(recordNewPVV.getParentTokenApplicationProfileAppSeqNum());
        orAdmin.txtPVVDetailPvkIdentifier().sendKeys(recordNewPVV.getPvkIdentifier());
        adminCommon.setListValue(orAdmin.selPVVDetailPinVerificationMethod(),recordNewPVV.getPinVerificationMethod());
        adminCommon.setListValue(orAdmin.selPVVDetailPinVerificationKey(),recordNewPVV.getPinVerificationKey());


        orAdmin.btnPVVDetailCreate().click();

        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnOK()));

        String output = orAdmin.txtMsg().getText();
        if(!output.contains("successfully added")){
            recordNewPVV = null;
        }
        else{
            orAdmin.btnOK().click();

        }

        orAdmin.btnPVVRefresh().click();

        return recordNewPVV;

    }

    public PVVDataRecord getPVVRecordByPVKIdentifier(PVVDataRecord pvvPvkIdentifier) {

        adminCommon.sleep(1000);

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.tblPVVList()));
        PVVDataRecord record = new PVVDataRecord();

        List<WebElement> rows = orAdmin.tblPVVList().findElements(By.xpath(".//tr[contains(@class,'x-grid-row')]"));
        if(rows.size()==0){
            record.setPvkIdentifier(null);
        }
        else {
            boolean found = false;
            for (WebElement row : rows) {

                WebElement cellId = row.findElement(By.xpath(".//td[contains(@class, 'idPvkIdentifier')]"));
                if (pvvPvkIdentifier.getPvkIdentifier().equals(cellId.getText())) {

                    record.setId(row.findElement(By.xpath(".//td[contains(@class, 'idGID')]")).getText());
                    record.setPvkIdentifier(row.findElement(By.xpath(".//td[contains(@class, 'idPvkIdentifier')]")).getText());
                    record.setParentTokenProduct(row.findElement(By.xpath(".//td[contains(@class, 'idGTPID')]")).getText());
                    record.setParentTokenApplicationProfileAppSeqNum(row.findElement(By.xpath(".//td[contains(@class, 'idASNum')]")).getText());
                    record.setPinVerificationKey(row.findElement(By.xpath(".//td[contains(@class, 'idPVK')]")).getText());
                    record.setPinVerificationMethod(row.findElement(By.xpath(".//td[contains(@class, 'idPVM')]")).getText());
                    found = true;
                    break;

                }
            }
            if (!found) {
                record.setPvkIdentifier(null);
            }
        }

        return(record);
    }

    public boolean editPVVData(PVVDataRecord recordEditPVV, String field){

        WebDriverWait mywait = new WebDriverWait(webDriver, 10);

        // Search the Institution and Issuer  and double click the Token Product
        TokenProductDataRecord recordSearchTokenProduct = new TokenProductDataRecord();
        recordSearchTokenProduct.setParentInstitution(recordEditPVV.getParentInstitution());
        recordSearchTokenProduct.setParentIssuer(recordEditPVV.getParentIssuer());
        recordSearchTokenProduct.setId(recordEditPVV.getParentTokenProductId());


        adminCommon.searchInstitutionAndIssuer(recordSearchTokenProduct.getParentInstitution(), recordSearchTokenProduct.getParentIssuer());
        tokenProductsPage.dblClickTokenProductById(recordSearchTokenProduct.getId());

        //Double click the Token Application Profile
        tokenApplicationProfilePage.dblClickTokenApplicationProfileByName(recordEditPVV.getParentTokenApplicationProfileName());

        adminCommon.clickEditById(orAdmin.tblPVVList(), recordEditPVV.getId());
        //editPVVDataById(recordEditPVV.getId());
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVDetailSave()));


        switch(field) {

            case("PVKIdentifier"):
                orAdmin.txtPVVDetailPvkIdentifier().clear();
                orAdmin.txtPVVDetailPvkIdentifier().sendKeys(recordEditPVV.getPvkIdentifier());
                break;

            case("PinVerificationMethod"):
                adminCommon.setListValue(orAdmin.selPVVDetailPinVerificationMethod(), recordEditPVV.getPinVerificationMethod());
                break;

           case("PinVerificationKey"):
                adminCommon.setListValue(orAdmin.selPVVDetailPinVerificationKey(), recordEditPVV.getPinVerificationKey());
                break;


        }

        // Click the Save button
        mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnPVVDetailSave()));
        orAdmin.btnPVVDetailSave().click();
        boolean present = false;
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            try{
                webDriver.findElement(By.xpath("//*[@id=\"button-1005-btnEl\"]"));
                String output = orAdmin.txtMsg().getText();
                if (!output.contains("successfully updated")) {
                    return(false);
                }

                orAdmin.btnOK().click();
                mywait.until(ExpectedConditions.elementToBeClickable(orAdmin.btnTokenApplicationProfileAdd()));
                present = true;
                break;

            }catch (NoSuchElementException e) {
                System.out.println("OK Button not found: " + i);
            }
        }

        return(present);

    }

    public PVVDataRecord getDBDataById(String id){

        PVVDataRecord record = new PVVDataRecord();

        try {

            String SQL = "SELECT INST.NAME, ISS.NAME, TP.NAME, PVV.TOKEN_PRODUCT_ID, PVV.ID, TAP.NAME, TAP.APP_SEQ_NUMBER, PVV.PVK_IDENTIFIER , SCI.NAME, PVM.NAME " +
                    "FROM ENC_D_PVVS PVV " +
                    "LEFT JOIN C_D_TOKEN_APP_PROFILE TAP ON PVV.TOKEN_PRODUCT_ID=TAP.TOKEN_PRODUCT_ID " +
                    "AND PVV.APP_SEQ_NUMBER=TAP.APP_SEQ_NUMBER " +
                    "LEFT JOIN C_D_TOKEN_PRODUCT TP ON PVV.TOKEN_PRODUCT_ID=TP.ID " +
                    "LEFT JOIN C_D_ISSUER ISS ON PVV.TOKEN_PRODUCT_ID=TP.ID AND TP.ISSUER_ID=ISS.ID " +
                    "LEFT JOIN C_D_INSTITUTION INST ON ISS.INSTITUTION_ID=INST.ID " +
                    "LEFT JOIN ENC_D_SCI SCI ON PVV.SCI_PIN_VERIFICATION_KEY_ID=SCI.ID " +
                    "LEFT JOIN ENC_S_PIN_VERIFICATION_METHOD PVM ON PVV.PIN_VERIFICATION_METHOD_ID=PVM.ID " +
                    "WHERE PVV.ID = ?";

            Connection connection;
            connection = DatabaseConnection.getConnection();
            PreparedStatement preparedSelect = connection.prepareStatement(SQL);
            preparedSelect.setString(1, id);

            ResultSet rs = preparedSelect.executeQuery();
            if(!rs.isBeforeFirst()){

                record.setParentInstitution(null);
                record.setParentIssuer(null);
                record.setParentTokenProduct(null);
                record.setParentTokenProductId(null);
                record.setId(null);
                record.setParentTokenApplicationProfileName(null);
                record.setParentTokenApplicationProfileAppSeqNum(null);
                record.setPvkIdentifier(null);
                record.setPinVerificationKey(null);
                record.setPinVerificationMethod(null);
            }
            else{
                rs.next();

                record.setParentInstitution(rs.getString(1));
                record.setParentIssuer(rs.getString(2));
                record.setParentTokenProduct(rs.getString(3));
                record.setParentTokenProductId(rs.getString(4));
                record.setId(rs.getString(5));
                record.setParentTokenApplicationProfileName(rs.getString(6));
                record.setParentTokenApplicationProfileAppSeqNum(rs.getString(7));
                record.setPvkIdentifier(rs.getString(8));
                record.setPinVerificationKey(rs.getString(9));
                record.setPinVerificationMethod(rs.getString(10));

            }

        }catch (Exception exc) {
            exc.printStackTrace();
        }

        return(record);

    }





}
