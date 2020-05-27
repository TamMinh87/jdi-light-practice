package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;

import static com.epam.jdi.light.common.CheckTypes.*;

@Url(value = "/product/%s/", template = ".*/product/.*/", validate = MATCH)
@Title(value = ".* – Automation Practice Site", validate = MATCH)
public class ProductPage extends WebPage {
    @UI(".single_add_to_cart_button") public Button addToBasketBtn;
    @ByText("View Basket") public Link viewBasket;

    public void addToBasket() {
        addToBasketBtn.click();
        viewBasket.click();
    }
}
