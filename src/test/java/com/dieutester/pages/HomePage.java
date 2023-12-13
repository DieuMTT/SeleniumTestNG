package com.dieutester.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dieutester.keywords.WebUI.*;

public class HomePage {
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuAddNewProduct = By.xpath("//span[normalize-space()='Add New Product']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");
    private By menuInHouseProducts = By.xpath("//ul[@id='main-menu']//span[normalize-space()='In House Products']");

    public void clickMenuCategory() {
        waitForPageLoaded();
        clickElement(menuProducts);
        clickElement(menuCategory);
    }

    public AddNewProductPage clickMenuAddNewProduct() {
        waitForPageLoaded();
        waitForElementVisible(menuProducts);
        clickElement(menuProducts);
        waitForElementVisible(menuAddNewProduct);
        clickElement(menuAddNewProduct);
        return new AddNewProductPage();
    }

    public InHouseProductsPage clickMenuInHouseProducts() {
        waitForElementVisible(menuProducts);
        clickElement(menuProducts);
        waitForElementVisible(menuInHouseProducts);
        clickElement(menuInHouseProducts);
        return new InHouseProductsPage();
    }
}
