package org.mytests.tests.example;

import com.epam.jdi.light.elements.composite.WebPage;
import org.mytests.tests.SimpleTestsInit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static org.mytests.uiobjects.example.TestData.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.HomePage.loginForm;
import static org.mytests.uiobjects.example.site.pages.HomePage.userIcon;
import static org.mytests.uiobjects.example.site.pages.TikiHomePage.headerUser;
import static org.mytests.uiobjects.example.site.pages.TikiHomePage.loginButton;

public class SimpleJdiExample implements SimpleTestsInit {
    @AfterMethod
    public void after() {
//        homePage.logout.click();
    }
//    @Test
//    public void nonPageObjectTest() {
//        WebPage.openUrl("https://jdi-testing.github.io/jdi-light/index.html");
//        $("img#user-icon").click();
//        $("form #name").input("Roman");
//        $("form #password").input("Jdi1234");
//        $("form [type=submit]").click();
//        Assert.assertEquals(WebPage.getUrl(), "https://jdi-testing.github.io/jdi-light/index.html");
//    }

//    @Test
//    public void loginTest() {
//        homePage.open();
//        userIcon.click();
//        loginForm.loginAs(DEFAULT_USER);
//        homePage.checkOpened();
//    }

    @Test
    public void loginTest() {
        tikiHomePage.open();
        headerUser.hover();
        loginButton.click();
        tikiLoginForm.loginAs(DEFAULT_USER);
//        homePage.checkOpened();
    }
}
