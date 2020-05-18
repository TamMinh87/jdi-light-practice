package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.TestData.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.JdiTestSite.tikiHomePage;
import static org.mytests.uiobjects.example.site.JdiTestSite.tikiLoginForm;
import static org.mytests.uiobjects.example.site.pages.TikiHomePage.headerUser;
import static org.mytests.uiobjects.example.site.pages.TikiHomePage.loginButton;

public class LoginTikiTests implements SimpleTestsInit {
    @Test
    public void loginTest() {
        tikiHomePage.open();
        headerUser.hover();
        loginButton.click();
        tikiLoginForm.loginAs(DEFAULT_USER);
//        homePage.checkOpened();
    }
}
