package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendar;
    //By calendar = By.xpath("//div[@class = 'input-group date']//button");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndyear;
    //By monthAndyear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextIcon;
    //By nextIcon = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    WebElement alldates;
    //By alldates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    @CacheLookup
    @FindBy(name = "quantity")
    WebElement quantity;
    //By quantity = By.name("quantity");
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    //By addToCart = By.xpath("//button[@id='button-cart']");
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;
    //By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");

    public void datePicker(String y, String m, String d) {
        String year = y;
        String month = m;
        String date = d;

        Reporter.log("Click on Calendar");
        clickOnElement(calendar);
        CustomListeners.test.log(Status.PASS, "Click on Calendar");

        Reporter.log("Select Date "+d+"-"+m+"-"+y);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndyear);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextIcon);
            }
        }
        List<WebElement> allDates = webElementList(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select Date "+d+"-"+m+"-"+y);
    }

    public void changeQuantity() {
        Reporter.log("Change Quantity 1");
        WebElement qty = driver.findElement(By.name("quantity"));
        qty.clear();
        sendTextToElement(quantity, "1");
        CustomListeners.test.log(Status.PASS, "Change Quantity 1");
    }

    public void clickOnAddToCart() {
        Reporter.log("Click on Add to Cart");
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on Add to Cart");
    }

    public void clickOnShoppingCart() {
        Reporter.log("Click on Shopping Cart");
        clickOnElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Click on Shopping Cart");
    }
}
