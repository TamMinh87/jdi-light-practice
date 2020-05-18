package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.mytests.uiobjects.example.site.sections.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@Url("https://tiki.vn/") @Title("Tiki Home Page")
public class TikiHomePage extends WebPage {
//    private static final String URL = "https://tiki.vn/";

//    private By headerUser = By.xpath("//span[text()='Đăng nhập']");
//    private By loginButton = By.xpath("//button[text()='Đăng nhập']");

    @UI("//span[text()='Đăng nhập']") public static UIElement headerUser;
    @UI("//button[text()='Đăng nhập']") public static Button loginButton;

//    @Css("form") public static LoginForm loginForm;
//    @Css("img#user-icon") public static Icon userIcon;
//    @Css(".fa-sign-out") public static WebElement logout;
}
