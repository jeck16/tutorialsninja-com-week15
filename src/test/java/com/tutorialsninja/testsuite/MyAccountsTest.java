package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    AccountPage accountPage;
    LogOutPage logOutPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        accountPage = new AccountPage();
        logOutPage = new LogOutPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"Sanity","Regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        verifyTwoStrings("Register Account", By.xpath("//h1[contains(text(),'Register Account')]"));
    }

    @Test(groups = {"Smoke","Regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        verifyTwoStrings("Returning Customer", By.xpath("//h2[contains(text(),'Returning Customer')]"));
    }

    @Test(groups = {"Smoke","Regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Ankur");
        registerPage.enterLastName("Rathod");
        registerPage.enterEmail("prime55@gmail.com");
        registerPage.enterTelephone("08128008020");
        registerPage.enterPassword("test3334");
        registerPage.enterConfirmPassword("test3334");
        registerPage.clickOnSubscribe();
        registerPage.clickOnPolicy();
        registerPage.clickOnContinueButton();
        verifyTwoStrings("Your Account Has Been Created!",By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        accountPage.clickOnContinue();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"));
        logOutPage.clickOnLogout();
    }

    @Test(groups = {"Regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmail("prime55@gmail.com");
        loginPage.enterPassword("test3334");
        loginPage.clickOnLogin();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings("Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
        logOutPage.clickOnLogout();
    }

}
