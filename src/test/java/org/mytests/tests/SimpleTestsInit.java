package org.mytests.tests;

import com.epam.jdi.light.driver.get.DriverData;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.WebSettings;
import org.mytests.uiobjects.example.site.JdiTestSite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.HashMap;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
//import static com.epam.jdi.light.driver.get.DriverData.DOWNLOADS_DIR;
//import static com.epam.jdi.light.driver.get.DriverData.PAGE_LOAD_STRATEGY;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
//import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;
import static org.openqa.selenium.ie.InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;

import static com.epam.jdi.light.driver.WebDriverUtils.*;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.settings.WebSettings.*;

public interface SimpleTestsInit {
    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        logger.setLogLevel(STEP);
        openSite(JdiTestSite.class);
        logger.info("Run Tests");
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

