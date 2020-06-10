package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.mytests.uiobjects.example.site.sections.CheckOutForm2;

@Url("checkout/")
public class CheckOutPage extends WebPage {
    @UI(".page-content.entry-content") public static CheckOutForm2 billingDetails;
    @UI("#place_order") public static Button placeOrder;
    @UI("tfoot>tr:nth-child(3)>td") public static Label orderedPaymentMethod;
    @UI("tfoot>tr:nth-child(4)>td") public static Label orderedTotal;

}
