package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

 @Title("Automation Practice Site")
public class HomePage extends WebPage {
   @UI(".products") public static JList<Label> newArrivals;
   @UI("//h3[contains(text(),'Selenium Ruby')]") public static Link seleniumRuby;
}
