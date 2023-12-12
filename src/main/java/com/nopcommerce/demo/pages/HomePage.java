package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    //By loginLink = By.linkText("Log in");

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
    //By registerLink = By.linkText("Register");

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computerLink;


    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

    public void clickOnComputerLink(){
        clickOnElement(computerLink);

    }

}
