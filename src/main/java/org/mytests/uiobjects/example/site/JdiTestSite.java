package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.site.pages.*;
import org.openqa.selenium.WebElement;

@JSite("http://practice.automationtesting.in/")
public class JdiTestSite {
    public static HomePage homePage;
//    public static ShopPage shopPage;
//    public static ProductPage productPage;
    public static BasketPage basketPage;
    public static CheckOutPage checkOutPage;
//    public static OrderConfirmationPage orderConfirmationPage;
    public static MyAccountPage myAccountPage;
    public static HeaderPage headerPage;
    public static SeleniumRubyPage seleniumRubyPage;

    @Css(".fa-sign-out") public static WebElement logout;
    @UI("#main-nav") public static Menu topMenu;
}
