package com.nopcommerce.demo.tesusuite;

import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","smoke","regrassion"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Verify "Register" text
        String actualText = registerPage.getRegisterText();
        Assert.assertEquals(actualText, "Register");
    }

    @Test(groups = {"smoke", "regrassion"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify the error message "First name is required."
        String actualText = registerPage.getFirstNameRequiredText();
        Assert.assertEquals(actualText, "First name is required.");
        //Verify the error message "Last name is required."
        String actualText1 = registerPage.getLastNameRequiredText();
        Assert.assertEquals(actualText1, "Last name is required.");
        //Verify the error message "Email is required."
        String actualText2 = registerPage.getEmailRequiredText();
        Assert.assertEquals(actualText2, "Email is required.");
        //Verify the error message "Password is required."
        String actualText3 = registerPage.getPasswordRequiredText();
        Assert.assertEquals(actualText3, "Password is required.");
        //Verify the error message "Password is required."
        String actualText4 = registerPage.getConfirmPasswordRequiredText();
        Assert.assertEquals(actualText4, "Password is required.");
    }

    @Test(groups = {"regrassion"})
    public void verifyThatUserShouldCreateAccountSuccessfully(){
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female"
        registerPage.clickOnRadioButton();
        //Enter firstname
        registerPage.enterFirstName("Dana");
        //Enter lastname
        registerPage.enterLastName("John");
        //Select day
        registerPage.enterDate("2");
        //Select month
        registerPage.enterMonth("March");
        //Select year
        registerPage.enterYear("2000");
        //Enter email
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        registerPage.enterEmail("Dana" + randomInt + "@gmail.com");
        //Enter password
        registerPage.enterPassword("dana123");
        //Enter Confirm Password
        registerPage.enterConfirmPassword("dana123");
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify message "Your registration completed"
        String actualText = registerPage.getRegistrationSuccessfulText();
        Assert.assertEquals(actualText, "Your registration completed");
    }
}
