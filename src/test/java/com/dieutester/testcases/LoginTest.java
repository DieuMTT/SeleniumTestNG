package com.dieutester.testcases;


import com.dieutester.common.BaseTest;
import com.dieutester.constants.ConfigData;
import com.dieutester.helpers.ExcelHelper;
import com.dieutester.keywords.WebUI;
import com.dieutester.pages.HomePage;
import com.dieutester.pages.LoginPage;
import com.dieutester.utils.LogUtils;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void testLoginSuccess() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "UsersData");

        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
    }

    @Test
    public void testLoginWithEmailInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");

        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2));
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");

        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(
                excelHelper.getCellData("email", 3),
                excelHelper.getCellData("password", 3));
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
