package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import static org.mytests.uiobjects.example.site.JdiTestSite.homePage;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;


public class HomePageTest implements SimpleTestsInit {
    @Test
    public void verifyThreeArrivals(){
        homePage.open();
        assertTrue(arrivals.size() == 3);
    }

    @Test
    public void verifyArrivalsDetails(){
        homePage.open();
        homePage.navigateImages();
    }
}
