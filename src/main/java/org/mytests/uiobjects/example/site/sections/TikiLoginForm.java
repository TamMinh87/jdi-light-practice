package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.entities.User;

public class TikiLoginForm extends Form<User> {
    @Css("//input[@id='email']") TextField name;
    @Css("//input[@id='password']") TextField password;
    @Css("//button[contains(@class,'UserModalstyle__RightButton') and text()='Đăng nhập']") Button login;
//    @Css("//button[contains(@class,'UserModalstyle__RightButton') and text()='Đăng nhập1']") Button enter2;
}
