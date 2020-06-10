package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CUSTOMER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.checkOutForm;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.showCoupon;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
import static org.mytests.uiobjects.example.site.pages.ShopPage.*;

public class ShopPageTest implements SimpleTestsInit {
    //Testcase 1
    @Test
    public void testCase1() {
        topMenu.select("Shop");
        dragAndDropTo(350);
    }
}
