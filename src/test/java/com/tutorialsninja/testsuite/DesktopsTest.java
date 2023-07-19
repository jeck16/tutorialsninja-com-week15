package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        homePage.mouseHoverOnDesktopAndClick();
        homePage.selectMenu("Show AllDesktops");

        // Get all the products name and stored into array list
        List<WebElement> products = webElementList(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
        Collections.reverse(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        Thread.sleep(3000);
        // After filter Z -A Get all the products name and stored into array list
        products = webElementList(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName, "Product not arrange in descending order.");
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        homePage.selectCurrency();
        homePage.mouseHoverOnDesktopAndClick();
        homePage.selectMenu("Show AllDesktops");
        desktopsPage.selectSorting("Name (A - Z)");
        desktopsPage.clickOnHP();
        verifyTwoStrings("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));
        productPage.datePicker("2022", "November", "30");
        productPage.changeQuantity();
        productPage.clickOnAddToCart();
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")).contains("Success: You have added HP LP3065 to your shopping cart!"), "Product not added to cart");
        Thread.sleep(3000);
        productPage.clickOnShoppingCart();
        //2.11 Verify the text "Shopping Cart"
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='content']//h1")).contains("Shopping Cart"));
        //2.12 Verify the Product name "HP LP3065"
        verifyTwoStrings("HP LP3065", By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a"));
        //2.13 Verify the Delivery Date "2022-11-30"
        //System.out.println(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")));
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")).contains("2022-11-30"), "Delivery date not matched");
        //2.14 Verify the Model "Product21"
        verifyTwoStrings("Product 21", By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]"));
        //2.15 Verify the Todat "£74.73"
        //System.out.println(getTextFromElement(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));
        verifyTwoStrings("£74.73", By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"));
    }
}
