package com.dieutester.testcases;


import com.dieutester.common.BaseTest;
import com.dieutester.dataprovider.DataProviderFactory;
import com.dieutester.drivers.DriverManager;
import com.dieutester.helpers.CaptureHelper;
import com.dieutester.keywords.WebUI;
import com.dieutester.pages.HomePage;
import com.dieutester.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class LoginByDataProviderTest1 extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @Test(dataProvider = "DataLoginSuccess",dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email,String password) {
        System.out.println("========TestLogin_Success========");
        CaptureHelper.startRecord("testLoginSuccess");
        loginPage = new LoginPage();
        homePage = loginPage.loginCMS(email, password);
       CaptureHelper.stopRecord();
//        WebUI.captureScreenImage("testLoginSuccess");
        loginPage.verifyLoginSuccess();
    }


}
