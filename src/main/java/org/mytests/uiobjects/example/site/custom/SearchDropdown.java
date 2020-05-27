package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.Root;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SearchDropdown extends Dropdown {
    @Root @UI(".select2-input") TextField search;
    @Override
    public void select(String name) {
        show();
        expand();
        search.input(name);
        list().select(name);
    }
}
