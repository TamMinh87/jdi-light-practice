package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.custom.MenuItem;
import org.mytests.uiobjects.example.site.pages.ContactFormPage;
import org.mytests.uiobjects.example.site.pages.ContactsPage;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.mytests.uiobjects.example.site.pages.TikiHomePage;
import org.mytests.uiobjects.example.site.sections.TikiLoginForm;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {
    public static HomePage homePage;
    public static ContactFormPage contactFormPage;
    public static ContactsPage contactsPage;

    public static TikiHomePage tikiHomePage;
    public static TikiLoginForm tikiLoginForm;

    @Css("form") public static Form<User> loginForm;

    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @Css(".fa-sign-out") public static WebElement logout;
    @Css("img#user-icon") public static UIElement userIcon;
    @UI(".sidebar-menu li") public static Menu leftMenu;
    @UI(".sidebar-menu li") public static JList<MenuItem> menu;
}
