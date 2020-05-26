package org.mytests.uiobjects.example;

import org.mytests.uiobjects.example.entities.Customers;
import org.mytests.uiobjects.example.Utils.General;
import org.mytests.uiobjects.example.entities.ShippingAddress;
import org.mytests.uiobjects.example.entities.User;

public class TestData {
    public static User DEFAULT_USER = new User().set(
        u -> {u.username = "thuanduongtest2@gmail.com"; u.password = "Thuan120891";});

    public static User DEFAULT_USER2 = new User().set(
            u -> {u.username = "thuanduongtest3@gmail.com"; u.password = "Thuan120891";});

    public static Customers DEFAULT_CUSTOMER = new Customers().set(c-> {
        c.billingFirstName = "Long"; c.billingLastName = "Dinh"; c.billingCompany = "EPAM";
        c.billingEmail = "long_dinh@epam.com"; c.billingPhone = "012345678";
        c.billingAddress1 = "259 Tran Hung Dao Street"; c.billingPostcode = "700000";
        c.billingCity = "Ho Chi Minh"; c.paymentMethod = "cheque"; c.country = "Vietnam";
    });

    public static String ONHOLD_STATUS = "On Hold";

    public static String ORDER_DATE = "May 21, 2020";

    public static String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";

    public static ShippingAddress SHIPPING_ADDRESS_INFO = new ShippingAddress().set(s -> {s.shippingPostcode = General.getCurrentDate(FORMAT_DATE_YYYYMMDD);});

}
