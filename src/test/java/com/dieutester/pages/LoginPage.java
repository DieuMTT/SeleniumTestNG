package com.dieutester.pages;


import com.aventstack.extentreports.Status;
import com.dieutester.constants.ConfigData;
import com.dieutester.drivers.DriverManager;
import com.dieutester.keywords.WebUI;
import com.dieutester.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");

    private void setEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        WebUI.waitForPageLoaded();
        Assert.assertFalse(DriverManager.getDriver().getCurrentUrl().contains("login"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("login"), "FAIL. Không còn ở trang Login");

    }

    //Các hàm xử lý cho chính trang này
    public HomePage loginCMS(String email, String password) {
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new HomePage();
    }
}
