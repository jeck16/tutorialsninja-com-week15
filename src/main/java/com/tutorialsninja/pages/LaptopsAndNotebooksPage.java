package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortOption;
    //By sortOption = By.id("input-sort");
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbook;
    //By macbook = By.linkText("MacBook");


    public void selectSorting(String text) {
        Reporter.log("Select Sorting " + text);
        selectByVisibleTextFromDropDown(sortOption, text);
        CustomListeners.test.log(Status.PASS, "Select Sorting " + text);
    }

    public void clickOnMacbook() {
        Reporter.log("Click on Macbook");
        clickOnElement(macbook);
        CustomListeners.test.log(Status.PASS, "Click on Macbook");
    }
}
