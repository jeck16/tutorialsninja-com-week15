package com.tutorialsninja.testbase;

import com.tutorialsninja.propertyreader.PropertyReader;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

    public void verifyTwoStrings(String expected, By by){
        String expectedText = expected;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText);
    }
}
