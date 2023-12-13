package com.dieutester.testcases;


import com.dieutester.common.BaseTest;
import com.dieutester.dataprovider.DataProviderFactory;
import com.dieutester.helpers.ExcelHelper;
import com.dieutester.keywords.WebUI;
import com.dieutester.pages.HomePage;
import com.dieutester.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginByDataProviderTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

//    @Test(dataProvider = "DataLoginSuccess",dataProviderClass = DataProviderFactory.class)
//    public void testLoginSuccess(String email,String password) {
//        loginPage = new LoginPage();
//        homePage = loginPage.loginCMS(email, password);
//        loginPage.verifyLoginSuccess();
//        WebUI.captureScreenImage("testLoginSuccess");
//    }
//
//    @Test(dataProvider = "DataLoginEmailInvalid", dataProviderClass = DataProviderFactory.class)
//    public void testLoginWithEmailInvalid(String email, String password) {
//        loginPage = new LoginPage();
//        homePage = loginPage.loginCMS( email, password);
//        loginPage.verifyLoginFail();
//        WebUI.captureScreenImage("testLoginWithEmailInvalid");
//    }

    @Test(dataProvider = "data_provider_login_excel_hashtable",dataProviderClass = DataProviderFactory.class)
    public void testLoginWithPasswordInvalid(Hashtable<String,String>data) {
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(data.get("EMAIL"),data.get("PASSWORD"));
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
