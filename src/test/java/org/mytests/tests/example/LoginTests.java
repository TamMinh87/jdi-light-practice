package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.data.LoginData;
import org.mytests.tests.data.UserDataProvider;
import org.mytests.uiobjects.example.entities.User;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;
import static org.testng.Assert.assertEquals;

public class LoginTests implements SimpleTestsInit {



//    public static LoginData CORRECT_USERNAME_EMPTY_PASSWORD = new LoginData().set(c -> {
//        c.loginInfo.username = "thuanduongtest2@gmail.com";
//        c.loginInfo.password = "";
//        c.errorMessage = "Error: Password is required.";
//    });




    @Test(dataProvider = "failedUsers", dataProviderClass = UserDataProvider.class)
    public void loginIncorrectUser(LoginData loginData) {
        myAccountPage.open();
        loginForm.loginAs(loginData.loginInfo);
//        errorLoginMessage.has().attr("outerText", loginData.errorMessage);
    }

//    @Test
//    public void loginTest() {
//        myAccountPage.open();
//        loginForm.loginAs(DEFAULT_USER);
//        assert userNameLoggedIn.isDisplayed();
//    }

}
