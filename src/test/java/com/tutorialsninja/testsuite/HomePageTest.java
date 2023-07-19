package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        homePage.mouseHoverOnDesktopAndClick();
        homePage.selectMenu("Show AllDesktops");
        verifyTwoStrings("Desktops", By.xpath("//h2[contains(text(),'Desktops')]"));
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        homePage.mouseHoverOnLaptopsAndClick();
        homePage.selectMenu("Show AllLaptops & Notebooks");
        verifyTwoStrings("Laptops & Notebooks", By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentsAndClick();
        homePage.selectMenu("Show AllComponents");
        verifyTwoStrings("Components", By.xpath("//h2[contains(text(),'Components')]"));
    }
}
