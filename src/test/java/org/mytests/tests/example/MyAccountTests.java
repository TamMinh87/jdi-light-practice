package org.mytests.tests.example;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.mytests.tests.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.HeaderPage.myAccountMenu;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;

public class MyAccountTests implements SimpleTestsInit {

    @Test
    public void checkDashboardDisplayed() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        dashBoardMenu.is().displayed();
    }

    @Test
    public void checkOrdersDisplayed() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        orderMenu.click();
        goShopButton.is().displayed();
    }

    @Test
    public void viewOrderDetails() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        orderMenu.click();
        viewOrderDetailButton.click();
        customerDetailTable.is().displayed();
        orderDetailTable.is().displayed();
        addressArea.is().displayed();
    }

    @Test
    public void viewOrderDateAndStatus() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        orderMenu.click();
        viewOrderDetailButton.click();
        orderDate.assertThat().text(ORDER_DATE);
        orderStatus.assertThat().text(ONHOLD_STATUS);
    }

    @Test
    public void viewAddressInfo() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        addressMenu.click();
        billingAddressTitle.is().displayed();
        shippingAddressTitle.is().displayed();
    }

    @Test
    public void editShippingAddressInfo() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        addressMenu.click();
        shippingEditButton.click();
        shippingForm.submit(SHIPPING_ADDRESS_INFO);
        addressMenu.click();
        shippingCode.assertThat().text(containsString(SHIPPING_ADDRESS_INFO.shippingPostcode));
    }

    @Test
    public void viewAccountDetails() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        accountDetailMenu.click();
        accountEmail.is().displayed();
        accountEmail.assertThat().text(DEFAULT_USER2.username);
    }

    @Test
    public void logOutAccount() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER2);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        logOutLink.click();
        userNameLoggedIn.assertThat().notAppear();
    }
}
