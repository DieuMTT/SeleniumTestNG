package com.dieutester.testcases;

import com.dieutester.common.BaseTest;
import com.dieutester.constants.ConfigData;
import com.dieutester.helpers.ExcelHelper;
import com.dieutester.pages.*;
import org.testng.annotations.Test;


public class EditProductTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AddNewProductPage addNewProductPage;
    InHouseProductsPage inHouseProductsPage;
    EditProductPage editProductPage;


    @Test(priority = 1)
    public void testEditProduct() {
        //Login
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

        //Search
        inHouseProductsPage.searchAndVerifyProduct();

        //Verify data
        editProductPage = inHouseProductsPage.clickButtonEditProduct();
        editProductPage.testEditProduct();
        editProductPage.verifyDataProduct();
    }
}
