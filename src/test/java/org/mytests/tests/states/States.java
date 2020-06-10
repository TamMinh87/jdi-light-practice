package org.mytests.tests.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static org.mytests.uiobjects.example.TestData.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class States {
    private static void onSite() {
        if (!WebPage.getUrl().contains("http://practice.automationtesting.in/my-account/"))
            myAccountPage.open();
    }
//    @Step
//    public static void shouldBeLoggedIn() {
//        onSite();
//        if (!myAccountPage.userNameLoggedIn.isDisplayed())
//            login();
//    }
//    @Step
//    public static void login() {
//        myAccountPage.loginForm.loginAs(DEFAULT_USER);
//    }
//    @Step
//    public static void shouldBeLoggedOut() {
//        onSite();
//        if (myAccountPage.userNameLoggedIn.isDisplayed())
//            logout();
//    }
//    @Step
//    public static void logout() {
//        if (!myAccountPage.signOutLink.isDisplayed())
//            myAccountPage.open();
//        myAccountPage.signOutLink.click();
//    }
}
