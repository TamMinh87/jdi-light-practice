package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.mytests.uiobjects.example.site.pages.*;
import org.openqa.selenium.WebElement;

@JSite("http://practice.automationtesting.in/")
public class JdiTestSite {
    public static HomePage homePage;
    public static BasketPage basketPage;
    public static CheckOutPage checkOutPage;
    public static OrderConfirmationPage orderConfirmationPage;
    public static MyAccountPage myAccountPage;
    public static HeaderPage headerPage;

    @Css(".fa-sign-out") public static WebElement logout;
}
