package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;
    //By desktop = By.linkText("Desktops");
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooks;
    //By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement components;
    //By components = By.linkText("Components");
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currency;
    //By currency = By.xpath("//span[contains(text(),'Currency')]");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
    WebElement pound;
    //By pound = By.xpath("//button[normalize-space()='£Pound Sterling']");
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;
    //By myAccount = By.xpath("//span[contains(text(),'My Account')]");


    public void mouseHoverOnDesktopAndClick() {
        Reporter.log("Mouse hover on Desktop and click");
        mouseHoverToElementAndClick(desktop);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Desktop and click");
    }

    public void mouseHoverOnLaptopsAndClick() {
        Reporter.log("Mouse hover on Laptops and click");
        mouseHoverToElementAndClick(laptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Laptops and click");
    }

    public void mouseHoverOnComponentsAndClick() {
        Reporter.log("Mouse hover on Components and click");
        mouseHoverToElementAndClick(components);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Components and click");
    }

    public void selectMenu(String menu) {
        Reporter.log("Select Menu " + menu);

        List<WebElement> topMenuList = webElementList(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = webElementList(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }

        CustomListeners.test.log(Status.PASS, "Select Menu " + menu);
    }

    public void selectCurrency() {
        Reporter.log("Click on Currency");
        clickOnElement(currency);
        CustomListeners.test.log(Status.PASS, "Click on Currency");

        Reporter.log("Click on Pound");
        clickOnElement(pound);
        CustomListeners.test.log(Status.PASS, "Click on Pound");
    }

    public void selectMyAccountOptions(String option) {

        Reporter.log("Select MyAccount option " + option);

        List<WebElement> myAccountList = webElementList(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = webElementList(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

        CustomListeners.test.log(Status.PASS, "Select MyAccount option " + option);
    }

    public void clickOnMyAccount() {
        Reporter.log("Click on MyAccount");
        clickOnElement(myAccount);
        CustomListeners.test.log(Status.PASS, "Click on MyAccount");
    }

}
