package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.mytests.tests.data.LoginData;
import org.mytests.tests.data.RegistrationData;
import org.mytests.tests.data.UserDataProvider;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.JdiTestSite.myAccountPage;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.*;
import static org.mytests.uiobjects.example.site.pages.MyAccountPage.userNameLoggedIn;

public class RegistrationTests implements SimpleTestsInit {
//    @Test
//    public void loginWithValidUser() {
//        myAccountPage.open();
//        registerForm.submit();
//    }

    @Test(dataProvider = "failedRegistrationUsers", dataProviderClass = UserDataProvider.class)
    public void loginWithIncorrectUser(RegistrationData registrationData) {
        myAccountPage.open();
        registerForm.fill(registrationData.registerInfo);
        registerForm.username.has().attr("validationMessage", registrationData.errorMessage);
    }

    @Test(dataProvider = "failedRegistrationUsersWithErrorMess", dataProviderClass = UserDataProvider.class)
    public void loginWithIncorrectUserWithErrorMess(RegistrationData registrationData) {
        myAccountPage.open();
        registerForm.submit(registrationData.registerInfo);
        errorLoginMessage.has().attr("outerText", registrationData.errorMessage);
    }
}
