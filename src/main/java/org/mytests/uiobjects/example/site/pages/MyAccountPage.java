package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.mytests.uiobjects.example.site.sections.LoginForm;

@Url("my-account/") @Title("My Account - Automation Practice Site")
public class MyAccountPage extends WebPage {
    @UI(".login") public static LoginForm loginForm;
    @UI(".woocommerce-MyAccount-content>p>strong") public static Text loggedInUserName;
    @UI(".woocommerce-MyAccount-navigation-link--edit-account>a") public static Link accountDetailsSideMenu;
    @UI("#account_email") public static Text loggedInEmail;
}
