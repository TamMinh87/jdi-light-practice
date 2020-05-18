package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.data.LoginData;
import org.mytests.tests.data.UserDataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;

public class LoginTests implements SimpleTestsInit {


    @Test(dataProvider = "failedUsers", dataProviderClass = UserDataProvider.class)
    public void loginIncorrectUser(LoginData loginData) {
        myAccountPage.open();
        loginForm.loginAs(loginData.loginInfo);
    }

    @Test
    public void loginTest() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        assert userNameLoggedIn.isDisplayed();
    }

}
