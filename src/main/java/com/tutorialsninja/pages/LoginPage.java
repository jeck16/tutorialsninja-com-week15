package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    //By email = By.id("input-email");
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    //By password = By.id("input-password");
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;
    //By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

    public void enterEmail(String text) {
        Reporter.log("Enter Email " + text);
        sendTextToElement(email, text);
        CustomListeners.test.log(Status.PASS, "Enter Email " + text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter Password " + text);
        sendTextToElement(password, text);
        CustomListeners.test.log(Status.PASS, "Enter Password " + text);
    }

    public void clickOnLogin() {
        Reporter.log("Click on Login Button ");
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on Login Button ");
    }
}
