package com.daasworld.webapp;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloIntegrationTest {

    private Selenium selenium;

    @BeforeClass
    public void startSelenium() {
        // http://release.seleniumhq.org/selenium-remote-control/1.0-beta-2/doc/java/com/thoughtworks/selenium/DefaultSelenium.html#DefaultSelenium
        // Selenium Server Host and Port, browser, and target
        // 9090 is the port number that is used by Jetty - see the pom.xml
        selenium = new DefaultSelenium("localhost", 4444, "*safari", "http://localhost:9090");
        selenium.start();
    }

    @AfterClass(alwaysRun = true)
    public void stopSelenium() {
        selenium.stop();
    }

    @Test
    public void testSequence() throws Exception {
        selenium.open("/");
        selenium.waitForPageToLoad("30000");
        assert selenium.isTextPresent("Hello World");
    }

}