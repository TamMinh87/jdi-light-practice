package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.entities.User;


public class RegisterForm extends Form<User> {
    @UI("#reg_email") public static TextField username;
    @UI("#reg_password") public static TextField password;
}
