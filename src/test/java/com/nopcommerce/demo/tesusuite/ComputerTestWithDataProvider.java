package com.nopcommerce.demo.tesusuite;

import com.nopcommerce.demo.customlisterners.CustomListeners;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.tesedata.TestData;
@Listeners(CustomListeners.class)
public class ComputerTestWithDataProvider extends BaseTest {
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();

    @Test(dataProvider = "software", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(){

    }
}
