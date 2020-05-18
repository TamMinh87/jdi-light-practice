package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
//import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
//import com.epam.jdi.light.ui.html.common.Iconon;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import io.qameta.allure.Step;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.sections.LoginForm;
import org.openqa.selenium.WebElement;

@Url("/index.html") @Title("Home Page")
public class HomePage extends WebPage {
    @Css("form") public static LoginForm loginForm;
    @Css("img#user-icon") public static Icon userIcon;
    @Css(".fa-sign-out") public static WebElement logout;
}
