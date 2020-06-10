package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.mytests.uiobjects.example.entities.Customers;
import org.mytests.uiobjects.example.site.custom.SearchDropdown;

import java.util.List;

public class CheckOutForm2 extends Form<Customers> {
    TextField billingFirstName;
    TextField billingLastName;
    TextField billingCompany;
    TextField billingEmail;
    TextField billingPhone;
    @JDropdown(value = ".select2-chosen", list = "*root*#select2-results-1 li")
    SearchDropdown billingCountry;
    @UI("#billing_address_1.input-text") TextField billingAddress1;
    TextField billingPostcode;
    TextField billingCity;
    @UI("[name='payment_method']") public static List<RadioButtons> paymentMethod;


    public void fillBilling(Customers customer){
        fill(customer);
    }
}
