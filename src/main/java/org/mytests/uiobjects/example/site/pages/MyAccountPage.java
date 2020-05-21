package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import org.mytests.uiobjects.example.site.sections.LoginForm;
import org.mytests.uiobjects.example.site.sections.RegisterForm;
import org.mytests.uiobjects.example.site.sections.ShippingForm;

@Url("my-account/") @Title("My Account Page")
public class MyAccountPage extends WebPage {
    @UI(".login") public static LoginForm loginForm;
    @UI(".woocommerce-MyAccount-content strong") public static Label userNameLoggedIn;
    @UI(".woocommerce-MyAccount-content [href*='logout']") public static Link logoutLink;
    @UI(".woocommerce-error") public static Label errorLoginMessage;
    @UI(".register") public static RegisterForm registerForm;
    @UI("//*[contains(@class,'woocommerce-MyAccount-navigation-link')]//a[contains(text(),'Dashboard')]") public static Link dashBoardMenu;
    @UI(".woocommerce-MyAccount-navigation-link [href*='orders']") public static Link orderMenu;
    @UI(".woocommerce-Button.button") public static Button goShopButton;
    @UI(".order-actions .button.view") public static Button viewOrderDetailButton;
    @UI(".shop_table.order_details") public static Table orderDetailTable;
    @UI(".shop_table.customer_details") public static Table customerDetailTable;
    @UI(".woocommerce-MyAccount-content > address") public static UIElement addressArea;
    @UI(".order-date") public static Label orderDate;
    @UI(".order-status") public static Label orderStatus;
    @UI(".woocommerce-MyAccount-navigation-link [href*='edit-address']") public static Link addressMenu;
    @UI("//*[text()='Billing Address']") public static Label billingAddressTitle;
    @UI("//*[text()='Shipping Address']") public static Label shippingAddressTitle;
    @UI(".woocommerce-Address-title [href*='shipping']") public static Button shippingEditButton;
    @UI(".woocommerce-MyAccount-content form") public static ShippingForm shippingForm;
    @UI("(//*[contains(@class,'woocommerce-Address')]//address)[2]") public static Label shippingCode;
}
