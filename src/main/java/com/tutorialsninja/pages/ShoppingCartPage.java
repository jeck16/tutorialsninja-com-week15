package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement quantity;
    //By quantity = By.xpath("//input[contains(@name, 'quantity')]");
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement update;
    //By update = By.xpath("//button[contains(@data-original-title, 'Update')]");

    public void changeQuantity(String text) {
        Reporter.log("Change Quantity " + text);
        WebElement qty = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        qty.clear();
        sendTextToElement(quantity, text);
        CustomListeners.test.log(Status.PASS, "Change Quantity " + text);
    }

    public void clickOnUpdate() {
        Reporter.log("Click on Update ");
        clickOnElement(update);
        CustomListeners.test.log(Status.PASS, "Click on Update ");
    }
}
