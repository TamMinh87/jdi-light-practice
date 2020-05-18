package org.mytests.uiobjects.example;

import org.mytests.uiobjects.example.entities.Contacts;
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
}
