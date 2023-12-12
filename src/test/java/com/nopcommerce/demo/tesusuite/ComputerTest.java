package com.nopcommerce.demo.tesusuite;

import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class ComputerTest extends BaseTest {
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity","smoke","regrassion"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Verify "Computer" text
        String actualText = computerPage.getComputerText();
        Assert.assertEquals(actualText, "Computer");
    }

    @Test(groups = {"smoke","regrassion"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Click on Desktops link
        computerPage.clickOnDeskTopLink();
        //Verify "Desktops" text
        String actualText = desktopsPage.getDesktopsText();
        Assert.assertEquals(actualText, "Desktops");
    }

    @Test
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software){
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Click on Desktops link
        computerPage.clickOnDeskTopLink();
        //Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
        //Select processor "processor"
        buildYourOwnComputerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //Select RAM "ram"
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        //Select HDD "hdd"
        buildYourOwnComputerPage.clickOnHdd();
        //Select OS "os"
        buildYourOwnComputerPage.clickOnOs();
        //Select Software "software"
        buildYourOwnComputerPage.clickOnSoftware();
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        //Verify message "The product has been added to your shopping cart"
        String actualText = buildYourOwnComputerPage.getAddedText();
        Assert.assertEquals(actualText, "The product has been added to your shopping cart");
    }
}
