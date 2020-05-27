package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.mytests.uiobjects.example.entities.Contacts;
import org.mytests.uiobjects.example.entities.Customers;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;
import org.mytests.uiobjects.example.site.custom.SearchDropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class CheckOutForm extends Form<Customers> {
	TextField billingFirstName;
	TextField billingLastName;
	TextField billingCompany;
	TextField billingEmail;
	TextField billingPhone;
	@UI("#s2id_billing_country")
	static Button billingCountry;
	static List<WebElement> countryList;
	@UI("#billing_address_1")
	TextField billingAddress1;
	TextField billingPostcode;
	TextField billingCity;
	@UI("[name='payment_method']") List<RadioButtons> paymentMethod;
	@UI("#place_order") public static Button placeOrder;
	@JDropdown(value = ".select2-chosen", list = "*root*#select2-results-1 li")
	public SearchDropdown country;

	public void placeOrder(Customers customer) {
		fill(customer);
		placeOrder.click();
	}
	public void selectCountry(String country) {
		billingCountry.click();
		countryList = getDriver().findElements(By.cssSelector(".select2-result-label"));
		for (WebElement e : countryList) {
			if (e.getText().toLowerCase().contains(country.toLowerCase())){
				e.click();
				break;
			}
		}
	}
}