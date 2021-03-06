package com.daasworld.webapp;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloIntegrationTest {

    private Selenium selenium;

    @BeforeClass
    public void startSelenium() {
        // http://release.seleniumhq.org/selenium-remote-control/1.0-beta-2/doc/java/com/thoughtworks/selenium/DefaultSelenium.html#DefaultSelenium
        // Selenium Server Host and Port, browser, and target
        // 8080 is the port number that is used by Jetty - see the pom.xml
        selenium = new DefaultSelenium("localhost", 4444, "*safari", "http://localhost:8080");
        selenium.start();
    }

    @AfterClass(alwaysRun = true)
    public void stopSelenium() {
        selenium.stop();
    }

    @Test
    public void testSequence() throws Exception {
        selenium.open("/api/hello");
        selenium.waitForPageToLoad("30000");

        String body = selenium.getBodyText();
        System.out.println(body);
        Assert.assertTrue( selenium.isTextPresent("Hello World from the servlet"), "string not present") ;
    }

    @Test
    public void staticPageTest() throws Exception {
        selenium.open("/static/test.html");
        selenium.waitForPageToLoad("30000");

        String body = selenium.getBodyText();
        System.out.println(body);
        Assert.assertTrue( selenium.isTextPresent("This is a Static web page"), "string not present") ;
    }



}