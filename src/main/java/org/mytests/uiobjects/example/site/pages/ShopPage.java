package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.mytests.uiobjects.example.site.custom.Breadcrumb;

import static org.mytests.uiobjects.example.site.pages.BasketPage.getPrice;

public class ShopPage extends WebPage {
    @UI(".woocommerce-breadcrumb") public static Breadcrumb breadcrumb;
    @UI("button[type='submit']") public static Button filter;
    @UI("span[class*='slider-handle']:first-of-type") public static Button leftSlider;
    @UI("span[class*='slider-handle']:last-of-type") public static Button rightSlider;
    @UI(".price_label span:last-of-type") public static Text rightPrice;

    public static void dragAndDropTo(int price){
        while(price<getPrice(rightPrice.getText()))
            rightSlider.dragAndDropTo(-5,0);
    }
}

