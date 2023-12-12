package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BuildYourOwnComputerPage extends Utility {

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processor;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(name = "product_attribute_3")
    WebElement hdd;

    @CacheLookup
    @FindBy(name = "product_attribute_4")
    WebElement os;

    @CacheLookup
    @FindBy(name = "product_attribute_5")
    WebElement softWare;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "(//p[@class='content'])[1]")
    WebElement verifyText;

    public void selectProcessor(String processorName){
        selectByVisibleTextFromDropDown(processor, processorName);
        CustomListeners.test.log(Status.PASS, "select processor");
    }

    public void selectRam(String ramName){
        selectByVisibleTextFromDropDown(ram, ramName);
        CustomListeners.test.log(Status.PASS, "select RAM");
    }
    public void clickOnHdd(){
        clickOnElement(hdd);
        CustomListeners.test.log(Status.PASS, "click on HDD");
    }

    public void clickOnOs(){
        clickOnElement(os);
        CustomListeners.test.log(Status.PASS, "click on OS");
    }
    public void clickOnSoftware(){
        clickOnElement(softWare);
        CustomListeners.test.log(Status.PASS, "click on software");
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "click on add to cart button");
    }
    public String getAddedText(){
        String message = getTextFromElement(verifyText);
        CustomListeners.test.log(Status.PASS, "verify text");
        return message;
    }


}
