package org.mytests.uiobjects.example;

import org.mytests.uiobjects.example.entities.Contacts;
import org.mytests.uiobjects.example.entities.Customers;
import org.mytests.uiobjects.example.entities.User;

public class TestData {
    public static User DEFAULT_USER = new User().set(
        u -> {u.name = "Roman"; u.password = "Jdi1234";});

    public static Contacts DEFAULT_CONTACT = new Contacts().set(c-> {
        c.name = "Roman"; c.lastName = "Iovlev"; c.position = "ChiefQA";
        c.passport = true; c.passportNumber = "4321"; c.passportSeria = "123456";
        c.description = "JDI - awesome UI automation tool"; c.acceptConditions = "true";
        c.gender = "Female"; c.weather = "Sun, Rain";
    });

    public static Customers DEFAULT_CUSTOMER = new Customers().set(c-> {
        c.billingFirstName = "Long"; c.billingLastName = "Dinh"; c.billingCompany = "EPAM";
        c.billingEmail = "long_dinh@epam.com"; c.billingPhone = "012345678";
        c.billingAddress1 = "259 Tran Hung Dao Street"; c.billingPostcode = "700000";
        c.billingCity = "Ho Chi Minh"; c.paymentMethod = "cheque";
    });
}
