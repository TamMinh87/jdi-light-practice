package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class HeaderPage extends WebPage {
    @UI(".menu-item [href*='my-account']") public static Link myAccountMenu;
}
