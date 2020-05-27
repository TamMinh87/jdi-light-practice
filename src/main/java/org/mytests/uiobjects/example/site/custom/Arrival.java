package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class Arrival extends Section {
    @UI("img") public Image image;
    @UI("h3") public Label title;
    @UI(".price") public Text price;
    @UI(".button") public Text addToCart;
}
