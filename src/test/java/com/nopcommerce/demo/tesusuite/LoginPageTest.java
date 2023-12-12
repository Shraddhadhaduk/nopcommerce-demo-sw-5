package com.nopcommerce.demo.tesusuite;

import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity","smoke","regrassion"})
    public void verifyUserShouldNavigateToLoginPage() {
        //Click on login link
        homePage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"smoke","regrassion"})
    public void verifyErrorMessageWithInvalidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterEmailId("prime123@gmail.com");
        //Enter Password
        loginPage.enterPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
    }
    @Test(groups = {"regrassion"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter Email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        loginPage.enterEmailId("People" + randomInt + "@gmail.com");
        //Enter Password
        loginPage.enterPassword("Happy123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that LogOut link is display
        String actualText = loginPage.getLogOutText();
        Assert.assertEquals(actualText,"Log out");
    }

    @Test(groups = {"regrassion"})
    public void verifyThatUserShouldLogOutSuccessFully(){
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter Email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        loginPage.enterEmailId("People" + randomInt + "@gmail.com");
        //Enter Password
        loginPage.enterPassword("Happy123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Click on LogOut Link
        loginPage.clickOnLogOutLink();
        //Verify that LogIn Link Display
        String actualText1 = loginPage.getLogInText();
        Assert.assertEquals(actualText1, "Log in");
    }
}
