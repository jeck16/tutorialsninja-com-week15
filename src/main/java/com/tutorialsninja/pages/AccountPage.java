package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;
    //By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public void clickOnContinue() {
        Reporter.log("Click on Continue");
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on Continue");
    }
}
