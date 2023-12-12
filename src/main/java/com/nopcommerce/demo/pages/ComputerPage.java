package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//h1[normalize-space()='Computers'])[1]")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Desktops'])[3]")
    WebElement desktopLink;


    public String getComputerText(){
       String message = getTextFromElement(computerText);
       CustomListeners.test.log(Status.PASS, "Verify computer text");
       return message;
    }
    public void clickOnDeskTopLink(){
        clickOnElement(desktopLink);
        CustomListeners.test.log(Status.PASS,"Click on desktop");
    }
}
