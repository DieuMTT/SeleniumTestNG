package com.dieutester.pages;

import com.dieutester.helpers.ExcelHelper;
import com.dieutester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.dieutester.constants.ConfigData.*;
import static com.dieutester.keywords.WebUI.*;

public class EditProductPage {
    private By headerEditProductPage = By.xpath("//h1[normalize-space()='Edit Product']");

    private By inputProductName = By.xpath("//label[normalize-space()='Product Name']/following-sibling::div/input");
    private By buttonUpdateProduct = By.xpath("//form[@id='choice_form']//button[normalize-space()='Update Product']");
    private By dropdownCategory = By.xpath("//label[normalize-space()='Category']/following-sibling::div//button[@data-id='category_id']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//input[@name='min_qty']");
    private By inputTags = By.xpath("//tags[@role='tagslist']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount']/following-sibling::div/input");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");

    public void testEditProduct() {
        waitForPageLoaded();
        setText(inputProductName, " " + "Edited");
        clickElement(buttonUpdateProduct);
        waitForPageLoaded();
    }

    public void verifyEditProductPage() {
        Assert.assertTrue(getWebElement(headerEditProductPage).isDisplayed(), "Fail.headerEditProductPage does not display");
        Assert.assertEquals(getWebElement(headerEditProductPage).getText(), "Edit Product", "Fail.headerEditProductPage does not match");
    }

    public void verifyDataProduct() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "ProductsData");
        waitForPageLoaded();
        Assert.assertEquals(getElementAttribute(inputProductName, "value"), excelHelper.getCellData("product_name", 1) + " Edited");
        waitForPageLoaded();
    }

    public void verifyProductsDetail() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "ProductsData");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(WebUI.getElementAttribute(inputProductName, "value"), excelHelper.getCellData("product_name", 1), "Giá trị Tên Product không đúng");
        softAssert.assertEquals(WebUI.getElementText(dropdownCategory), excelHelper.getCellData("category_name", 1), "Giá trị Category không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputMinimumPurchaseQty, "value"), excelHelper.getCellData("minimum_purchase_qty", 1), "Giá trị MinimumPurchaseQty không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputUnit, "value"), excelHelper.getCellData("unit", 1), "Giá trị Unit không đúng");
//        softAssert.assertEquals(WebUI.getElementAttribute(inputTags, "value"), "", "Giá trị Tags không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputUnitPrice, "value"), excelHelper.getCellData("unit_price", 1) + ".00", "Giá trị UnitPrice không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputQuantity, "value"), excelHelper.getCellData("quantity", 1), "Giá trị Quantity không đúng");
        softAssert.assertEquals(WebUI.getElementAttribute(inputDiscount, "value"), excelHelper.getCellData("discount", 1) + ".00", "Giá trị Discount không đúng");

        softAssert.assertAll();
    }
}
