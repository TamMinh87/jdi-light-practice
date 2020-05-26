package org.mytests.tests.data;

import org.mytests.uiobjects.example.entities.User;
import org.testng.annotations.DataProvider;

public class UserDataProvider {
    public static LoginData INCORRECT_USERNAME_PASSWORD = new LoginData().set(c -> {
        c.loginInfo = new User().set(d -> {
            d.username = "thuanduongtest21@gmail.com";
            d.password = "Thuan12";
        });
        c.errorMessage = "Error: A user could not be found with this email address.";
    });

    public static LoginData CORRECT_USERNAME_EMPTY_PASSWORD = new LoginData().set(c -> {
        c.loginInfo = new User().set(d -> {
            d.username = "thuanduongtest2@gmail.com";
            d.password = "";
        });
        c.errorMessage = "Error: Password is required.";
    });

    public static LoginData EMPTY_USERNAME_VALID_PASSWORD = new LoginData().set(c -> {
        c.loginInfo = new User().set(d -> {
            d.username = "";
            d.password = "Thuan120891";
        });
        c.errorMessage = "Error: Username is required.";
    });

    public static LoginData EMPTY_USERNAME_EMPTY_PASSWORD = new LoginData().set(c -> {
        c.loginInfo = new User().set(d -> {
            d.username = "";
            d.password = "";
        });
        c.errorMessage = "Error: Username is required.";
    });

    public static RegistrationData INVALID_EMAIL_CORRECT_PASSWORD = new RegistrationData().set(c -> {
        c.registerInfo = new User().set(d -> {
            d.username = "thuanduongtest21";
            d.password = "Thuan120891";
        });
        c.errorMessage = "Please include an '@' in the email address. 'thuanduongtest21' is missing an '@'.";
    });

    public static RegistrationData EMPTY_EMAIL_CORRECT_PASSWORD = new RegistrationData().set(c -> {
        c.registerInfo = new User().set(d -> {
            d.username = "";
            d.password = "Thuan120891";
        });
        c.errorMessage = "Error: Please provide a valid email address.";
    });

    public static RegistrationData VALID_EMAIL_EMPTY_PASSWORD = new RegistrationData().set(c -> {
        c.registerInfo = new User().set(d -> {
            d.username = "thuanduongtest23@gmail.com";
            d.password = "";
        });
        c.errorMessage = "Error: Please enter an account password.";
    });

    public static RegistrationData EMPTY_EMAIL_EMPTY_PASSWORD = new RegistrationData().set(c -> {
        c.registerInfo = new User().set(d -> {
            d.username = "";
            d.password = "";
        });
        c.errorMessage = "Error: Please provide a valid email address.";
    });

    @DataProvider(name = "failedUsers")
    public static Object[][] failedUsers() {
        return new LoginData[][]{{INCORRECT_USERNAME_PASSWORD}, {CORRECT_USERNAME_EMPTY_PASSWORD}, {EMPTY_USERNAME_VALID_PASSWORD}, {EMPTY_USERNAME_EMPTY_PASSWORD}};
    }

    @DataProvider(name = "failedRegistrationUsers")
    public static Object[][] failedRegistrationUsers() {
        return new RegistrationData[][]{{INVALID_EMAIL_CORRECT_PASSWORD}};
    }

    @DataProvider(name = "failedRegistrationUsersWithErrorMess")
    public static Object[][] failedRegistrationUsersWithErrorMess() {
        return new RegistrationData[][]{{EMPTY_EMAIL_CORRECT_PASSWORD}, {VALID_EMAIL_EMPTY_PASSWORD}, {EMPTY_EMAIL_EMPTY_PASSWORD}};
    }
}
