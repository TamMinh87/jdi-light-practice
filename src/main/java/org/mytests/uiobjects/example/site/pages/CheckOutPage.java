package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.site.sections.CheckOutForm;

@Url("/checkout/") @Title("Checkout – Automation Practice Site")
public class CheckOutPage extends WebPage {
    @UI("form[name='checkout']")
    public static CheckOutForm checkOutForm;
}
