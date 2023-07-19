package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;
    //By firstName = By.id("input-firstname");
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    //By lastName = By.id("input-lastname");
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    //By email = By.id("input-email");
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;
    //By telephone = By.id("input-telephone");
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    //By password = By.id("input-password");
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;
    //By confirmPassword = By.id("input-confirm");
    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    WebElement radioYes;
    //By radioYes = By.xpath("//label[normalize-space()='Yes']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement policy;
    //By policy = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;
    //By continueButton = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

    public void enterFirstName(String text) {
        Reporter.log("Enter Firstname " + text + getAlphaNumericString(4));
        sendTextToElement(firstName, text + getAlphaNumericString(4));
        CustomListeners.test.log(Status.PASS, "Enter Firstname " + text + getAlphaNumericString(4));
    }

    public void enterLastName(String text) {
        Reporter.log("Enter Lastname " + text + getAlphaNumericString(4));
        sendTextToElement(lastName, text + getAlphaNumericString(4));
        CustomListeners.test.log(Status.PASS, "Enter Lastname " + text + getAlphaNumericString(4));
    }

    public void enterEmail(String text) {
        Reporter.log("Enter Email " + text + getAlphaNumericString(4) + "@gmail.com");
        sendTextToElement(email, text + getAlphaNumericString(4) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Enter Email " + text + getAlphaNumericString(4) + "@gmail.com");
    }

    public void enterTelephone(String text) {
        Reporter.log("Enter Telephone " + text);
        sendTextToElement(telephone, text);
        CustomListeners.test.log(Status.PASS, "Enter Telephone " + text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter Password " + text);
        sendTextToElement(password, text);
        CustomListeners.test.log(Status.PASS, "Enter Password " + text);
    }

    public void enterConfirmPassword(String text) {
        Reporter.log("Enter ConfirmPassword " + text);
        sendTextToElement(confirmPassword, text);
        CustomListeners.test.log(Status.PASS, "Enter ConfirmPassword " + text);
    }

    public void clickOnSubscribe() {
        Reporter.log("Click on Subscribe ");
        clickOnElement(radioYes);
        CustomListeners.test.log(Status.PASS, "Click on Subscribe ");
    }

    public void clickOnPolicy() {
        Reporter.log("Click on policy ");
        clickOnElement(policy);
        CustomListeners.test.log(Status.PASS, "Click on policy ");
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on Continue ");
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on Continue ");
    }
}
