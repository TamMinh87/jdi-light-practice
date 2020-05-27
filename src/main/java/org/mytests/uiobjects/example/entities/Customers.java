package org.mytests.uiobjects.example.entities;

import com.epam.jdi.tools.DataClass;

public class Customers extends DataClass<Customers> {
    public String billingFirstName, billingLastName, billingCompany, billingEmail, billingPhone,
              billingAddress1, billingPostcode, billingCity, paymentMethod, country;
}
