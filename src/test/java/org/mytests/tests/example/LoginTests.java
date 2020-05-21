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
    public void loginWithIncorrectUser(LoginData loginData) {
        myAccountPage.open();
        loginForm.loginAs(loginData.loginInfo);
        errorLoginMessage.has().attr("outerText", loginData.errorMessage);
    }

    @Test
    public void loginWithValidUser() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
    }

    @Test
    public void loginAuthentication() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        assert userNameLoggedIn.isDisplayed();
        logoutLink.click();
        myAccountPage.back();
        userNameLoggedIn.assertThat().notAppear();
    }

}
