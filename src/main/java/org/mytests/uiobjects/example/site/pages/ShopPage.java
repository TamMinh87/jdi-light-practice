package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.site.custom.Breadcrumb;

public class ShopPage extends WebPage {
    @UI(".woocommerce-breadcrumb") public static Breadcrumb breadcrumb;
}
