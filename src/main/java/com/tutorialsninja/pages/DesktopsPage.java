package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortProducts;
    //By sortProducts = By.id("input-sort");
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hp;
    //By hp = By.xpath("//a[contains(text(),'HP LP3065')]");

    public void selectSorting(String text) {
        Reporter.log("Select Sort Option " + text);
        selectByVisibleTextFromDropDown(sortProducts, text);
        CustomListeners.test.log(Status.PASS, "Select Sort Option " + text);
    }

    public void clickOnHP() {
        Reporter.log("Click on HP");
        clickOnElement(hp);
        CustomListeners.test.log(Status.PASS, "Click on HP");
    }
}
