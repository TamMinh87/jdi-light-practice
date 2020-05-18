package org.mytests.uiobjects.example;

import org.mytests.uiobjects.example.entities.User;

public class TestData {
    public static User DEFAULT_USER = new User().set(
        u -> {u.username = "thuanduongtest2@gmail.com"; u.password = "Thuan120891";});

    public static User DEFAULT_USER2 = new User().set(
            u -> {u.username = "thuanduongtest3@gmail.com"; u.password = "Thuan120891";});

    public static User INCORRECT_USER = new User().set(
            u -> {u.username = "thuanduongtest21@gmail.com"; u.password = "Thuan120891";});

}
