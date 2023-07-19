package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LogOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement logout;

    //By logout = By.xpath("//a[contains(text(),'Continue')]");
    public void clickOnLogout() {
        Reporter.log("Click on Logout Button ");
        clickOnElement(logout);
        CustomListeners.test.log(Status.PASS, "Click on Logout Button ");
    }
}
