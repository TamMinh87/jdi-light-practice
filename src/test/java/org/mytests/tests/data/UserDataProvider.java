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

    @DataProvider(name = "failedUsers")
    public static Object[][] failedUsers() {
        return new LoginData[][]{{INCORRECT_USERNAME_PASSWORD}, {CORRECT_USERNAME_EMPTY_PASSWORD}, {EMPTY_USERNAME_VALID_PASSWORD}, {EMPTY_USERNAME_EMPTY_PASSWORD}};
    }
}
