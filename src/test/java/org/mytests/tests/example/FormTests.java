package org.mytests.tests.example;

import com.epam.jdi.light.elements.composite.Form;
import org.mytests.tests.SimpleTestsInit;
//import org.mytests.tests.TestsInit;
import org.mytests.uiobjects.example.entities.Contacts;
import org.testng.annotations.Test;

import static org.mytests.tests.states.States.*;
import static org.mytests.tests.states.States.shouldBeLoggedIn;
import static org.mytests.tests.states.States.shouldBeLoggedOut;
//import static org.mytests.uiobjects.example.entities.Defaults.*;
//import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.TestData.DEFAULT_USER;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
//import static org.mytests.uiobjects.example.site.SiteJdi.contactFormPage;
//import static org.mytests.uiobjects.example.site.SiteJdi.contactsPage;
//import static org.mytests.uiobjects.example.site.SiteJdi.homePage;
//import static org.mytests.uiobjects.example.site.SiteJdi.loginForm;
//import static org.mytests.uiobjects.example.site.SiteJdi.userIcon;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

public class FormTests implements SimpleTestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
//        contactForm.check(DEFAULT_CONTACT);
    }

//    @Test
//    public void fillContactFormTest() {
//        shouldBeLoggedIn();
//        contactFormPage.shouldBeOpened();
//        contactForm.submit(DEFAULT_CONTACT);
//        contactForm.check(DEFAULT_CONTACT);
//    }
//
//    @Test
//    public void fillContactsTest() {
//        shouldBeLoggedIn();
//        contactsPage.shouldBeOpened();
//        Form<Contacts> contactFrom = contactsPage.asForm();
//        contactFrom.submit(DEFAULT_CONTACT);
//        contactFrom.check(DEFAULT_CONTACT);
//    }
}
