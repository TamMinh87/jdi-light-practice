package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class Breadcrumb extends UIElement {
    @UI("a") public Link homeLink;
}
