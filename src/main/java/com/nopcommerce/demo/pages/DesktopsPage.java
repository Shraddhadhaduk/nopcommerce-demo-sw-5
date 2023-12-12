package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//h1[normalize-space()='Desktops'])[1]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='product-item'])[1]")
    WebElement buildYourOwnComputer;

    public String getDesktopsText(){
        String message = getTextFromElement(desktopsText);
        CustomListeners.test.log(Status.PASS,"Verify Desktops Text");
        return message;
    }
    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnComputer);
    }
}
