package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;


@Url("/product/selenium-ruby/") @Title("Selenium Ruby – Automation Practice Site")
public class SeleniumRubyPage extends WebPage {
    @UI(".single_add_to_cart_button") public static Button addToCartButton;
}
