package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

@Url("basket/")
public class BasketPage extends WebPage {
    @UI("[data-title='Subtotal']>span") public static Label subTotal;
    @UI(".order-total>td>strong") public static Label total;
    @UI(".wc-proceed-to-checkout>a") public static Button proceedToCheckout;
}
