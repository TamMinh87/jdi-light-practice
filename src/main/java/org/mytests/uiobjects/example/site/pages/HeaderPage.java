package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.awt.*;

public class HeaderPage extends WebPage {
    @UI("#main-nav") public static Menu headerMenu;
    @UI("#site-logo>a") public static Link logo;
    @UI(".wpmenucart-contents>.amount") public static Text itemPrice;
    @UI(".wpmenucart-icon-shopping-cart-0") public static Button cartButton;
}
