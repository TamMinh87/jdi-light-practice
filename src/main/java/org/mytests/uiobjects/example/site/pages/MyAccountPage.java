package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.site.sections.LoginForm;

@Url("my-account/") @Title("My Account Page")
public class MyAccountPage extends WebPage {
    @UI(".login") public static LoginForm loginForm;
    @UI(".woocommerce-MyAccount-content strong") public static Label userNameLoggedIn;
    @UI(".woocommerce-MyAccount-content [href*='logout/']") public static Label logoutLink;
    @UI(".woocommerce-error") public static Label errorLoginMessage;
}
