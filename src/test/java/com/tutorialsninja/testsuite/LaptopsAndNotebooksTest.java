package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
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
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        productPage = new ProductPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnLaptopsAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");

        List<WebElement> products = webElementList(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            //System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        //System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        //System.out.println(originalProductsPrice);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        Thread.sleep(3000);
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = webElementList(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        //System.out.println(afterSortByPrice);
        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(afterSortByPrice, originalProductsPrice, "Product not sorted by price High to Low");
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        homePage.selectCurrency();
        homePage.mouseHoverOnLaptopsAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        laptopsAndNotebooksPage.selectSorting("Price (High > Low)");
        Thread.sleep(3000);
        laptopsAndNotebooksPage.clickOnMacbook();
        verifyTwoStrings("MacBook", By.xpath("//h1[contains(text(),'MacBook')]"));
        productPage.clickOnAddToCart();
        Thread.sleep(3000);
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")).contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        productPage.clickOnShoppingCart();
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='content']//h1")).contains("Shopping Cart"));
        verifyTwoStrings("MacBook", By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a"));
        shoppingCartPage.changeQuantity("2");
        shoppingCartPage.clickOnUpdate();
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"), "Cart not modified");
        verifyTwoStrings("£737.45", By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]"));

    }
}
