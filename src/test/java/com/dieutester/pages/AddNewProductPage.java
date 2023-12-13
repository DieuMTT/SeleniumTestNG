package com.dieutester.pages;

import com.dieutester.helpers.ExcelHelper;
import com.dieutester.helpers.PropertiesHelper;
import com.dieutester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static com.dieutester.constants.ConfigData.*;
import static com.dieutester.keywords.WebUI.*;

public class AddNewProductPage {
    private By headerAddNewProductPage = By.xpath("//h5[normalize-space()='Add New Product']");
    private By headerProductInformationPage = By.xpath("//h5[normalize-space()='Product Information']");
    private By inputProductName = By.xpath("//label[.='Product Name *']/following-sibling::div//input");
    private By dropdownCategory = By.xpath("//div[@id='category']//button[@data-id='category_id']");

    private By inputSearchCategory = By.xpath("//div[@id='category']//input[@type='search']");
    private By inputUnit = By.xpath("//label[normalize-space()='Unit']/following-sibling::div//input");
    private By inputMinimumPurchaseQty = By.xpath("//label[.='Minimum Purchase Qty *']/following-sibling::div/input");
    private By inputTags = By.xpath("//label[contains(text(),'Tags')]/following-sibling::div//tags");
    //tags[@role='tagslist']

    //Product price + stock
    private By headerProductPriceStock = By.xpath("//h5[normalize-space()='Product price + stock']");
    private By inputUnitPrice = By.xpath("//label[.='Unit price *']/following-sibling::div/input");
    private By inputDiscountDateRange = By.xpath("//label[normalize-space()='Discount Date Range']/following-sibling::div/input");
    private By inputDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div/input");
    private By listDiscountType = By.xpath("//select[@name='discount_type']");
    private By dropdownDiscount = By.xpath("//label[normalize-space()='Discount *']/following-sibling::div//div/button");
    private By inputQuantity = By.xpath("//input[@name='current_stock']");
    private By inputSKU = By.xpath("//label[normalize-space()='SKU']/following-sibling::div/input");
    private By inputExternalLink = By.xpath("//label[normalize-space()='External link']/following-sibling::div/input");
    private By inputExternalLinkButtonText = By.xpath("//label[normalize-space()='External link button text']/following-sibling::div/input");

    private By buttonSaveAndPublish = By.xpath("//form[@id='choice_form']//button[normalize-space()= 'Save & Publish']");

    public void selectCategoryName(String categoryName) {
        clickElement(dropdownCategory);
        setTextAndKey(inputSearchCategory, categoryName, Keys.ENTER);
    }

    public void verifyHeaderAddNewProductPage() {
        waitForPageLoaded();
        Assert.assertTrue(getWebElement(headerAddNewProductPage).isDisplayed(),
                "Fail.Header Add New Product Page not display");
        Assert.assertEquals(getElementText(headerAddNewProductPage), "Add New Product",
                "Fail.Header Add New Product Page not match");
    }

    public InHouseProductsPage inputFormData() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "ProductsData");

        waitForPageLoaded();
        //Input Product Information
        setText(inputProductName, excelHelper.getCellData("product_name", 1));
        selectCategoryName(excelHelper.getCellData("category_name", 1));
        clearText(inputUnit);
        setText(inputUnit, excelHelper.getCellData("unit", 1));
        clearText(inputMinimumPurchaseQty);
        setText(inputMinimumPurchaseQty, excelHelper.getCellData("minimum_purchase_qty", 1));
        moveToElement(inputTags);
        setText(inputTags, excelHelper.getCellData("tags", 1));
        //Input Product price + stock
        clearText(inputUnitPrice);
        setText(inputUnitPrice, excelHelper.getCellData("unit_price", 1));
        clearText(inputDiscount);
        setText(inputDiscount, excelHelper.getCellData("discount", 1));
        clearText(inputQuantity);
        setText(inputQuantity, excelHelper.getCellData("quantity", 1));
        clickElement(buttonSaveAndPublish);
        waitForPageLoaded();
        return new InHouseProductsPage();
    }

}
