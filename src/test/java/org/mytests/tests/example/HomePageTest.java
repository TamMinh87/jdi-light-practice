package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.uiobjects.example.site.pages.*;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.*;
import static org.mytests.uiobjects.example.site.pages.HeaderPage.*;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
//import static org.mytests.uiobjects.example.site.pages.HomePage.seleniumRuby;

public class HomePageTest implements SimpleTestsInit {
    //1. Log-in with valid username and password.
    @Test
    public void LoginWithValidUsernameAndPassword(){
        myAccountPage.open();
        MyAccountPage.loginForm.loginAs(DEFAULT_USER);
        MyAccountPage.accountDetailsSideMenu.click();
        MyAccountPage.loggedInEmail.is().text(DEFAULT_USER.username);
    }

    //18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    @Test
    public void EndtoEnd() {
        headerMenu.select("Shop");
        HeaderPage.logo.click();
        newArrivals.has().size(3);
        newArrivals.get(1).click();
        seleniumRubyPage.checkOpened();
        SeleniumRubyPage.addToCartButton.click();
        itemPrice.has().text("₹500.00");
        cartButton.click();
        basketPage.checkOpened();
        subTotal.has().text("₹500.00");
        total.has().text("₹525.00");
        proceedToCheckout.click();
        billingDetails.fillBilling(DEFAULT_CUSTOMER);
        placeOrder.click();
        orderedPaymentMethod.is().text("Check Payments");
        orderedTotal.is().text("₹525.00");
        System.out.println("");


    }
}