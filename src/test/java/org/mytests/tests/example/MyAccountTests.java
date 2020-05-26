package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.HeaderPage.myAccountMenu;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;

public class MyAccountTests implements SimpleTestsInit {

    // TC1: My Accounts - Dashboard
    @Test
    public void checkDashboardDisplayed() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        dashBoardMenu.is().displayed();
    }

    // TC2: My Accounts - Check order displayed
    @Test
    public void checkOrdersDisplayed() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
        myAccountMenu.click();
        orderMenu.click();
        goShopButton.is().displayed();
    }

    // TC3: My Accounts - View order details
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

    // TC4: My Accounts - View order date and status
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

    // TC5: My Accounts - View address info
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

    // TC6: My Accounts - Edit shipping address
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

    // TC7: My Accounts - View account details
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

    // TC8: My Accounts - Log out
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
