package org.mytests.tests.data;

import com.epam.jdi.tools.DataClass;
import org.mytests.uiobjects.example.entities.User;

public class LoginData extends DataClass<LoginData>{
    public User loginInfo;
    public String errorMessage;
}
