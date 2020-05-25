package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.data.LoginData;
import org.mytests.tests.data.UserDataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.*;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;

public class LoginTests implements SimpleTestsInit {

    @Test
    public void TC1_loginWithValidUser() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        userNameLoggedIn.is().displayed();
    }

    /**
     * TC2: Login with incorrect username and incorrect password
     * TC3: Login with correct username and empty password
     * TC4: Login with empty username and valid password
     * TC5: Login with empty username and empty password
     */
    @Test(dataProvider = "failedUsers", dataProviderClass = UserDataProvider.class)
    public void TC2_loginWithIncorrectUser(LoginData loginData) {
        myAccountPage.open();
        loginForm.loginAs(loginData.loginInfo);
        errorLoginMessage.has().attr("outerText", loginData.errorMessage);
    }


    /**
     * TC8: Login Authentication.
     */
    @Test
    public void loginAuthentication() {
        myAccountPage.open();
        loginForm.loginAs(DEFAULT_USER);
        assert userNameLoggedIn.isDisplayed();
        signOutLink.click();
        myAccountPage.back();
        userNameLoggedIn.assertThat().notAppear();
    }

}
