package org.mytests.tests;

import org.mytests.uiobjects.example.site.JdiTestSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.mytests.uiobjects.example.site.JdiTestSite.homePage;
import static com.epam.jdi.light.elements.composite.WebPage.*;


public interface SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        logger.setLogLevel(STEP);
        openSite(JdiTestSite.class);
        logger.info("Run Tests");
    }

    @BeforeMethod(alwaysRun = true)
    default void teardownMethod(){
        homePage.open();
        getDriver().manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    default void teardown() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    default void clearAllDriver() {
        killAllSeleniumDrivers();
    }

}

