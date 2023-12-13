package com.dieutester.testcases;

import com.dieutester.common.BaseTest;
import com.dieutester.constants.*;
import com.dieutester.helpers.ExcelHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import com.dieutester.pages.*;
import org.testng.annotations.Test;

import static com.dieutester.constants.ConfigData.*;

public class AddNewProductTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AddNewProductPage addNewProductPage;
    InHouseProductsPage inHouseProductsPage;
    EditProductPage editProductPage;


    @Test(priority = 1)
    public void testAddNewProduct() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "UsersData");

        //Login
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();

        //Cick on menu Add New Product
        addNewProductPage = homePage.clickMenuAddNewProduct();

        //Verify Add New Product Page
        addNewProductPage.verifyHeaderAddNewProductPage();

        //Input data
        inHouseProductsPage = addNewProductPage.inputFormData();
    }

    @Test(priority = 2)
    public void checkProductJustAddedIsDisplayedInTheList() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "UsersData");
        //Login
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));

        //Cick on menu Add New Product
        addNewProductPage = homePage.clickMenuAddNewProduct();

        //Verify Add New Product Page
        addNewProductPage.verifyHeaderAddNewProductPage();

        //Input data
        inHouseProductsPage = addNewProductPage.inputFormData();

        //Check Product Just Added Is Displayed In The List
        inHouseProductsPage.searchAndVerifyProduct();
        editProductPage = inHouseProductsPage.clickButtonEditProduct();
        editProductPage.verifyProductsDetail();

    }
}
