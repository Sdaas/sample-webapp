package com.daasworld.webapp;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * User: sdaas
 * Date: 9/15/13
 * Time: 10:43 AM
 */
public class HelloTest {

    @Test
    public void testSayHello() throws Exception {

        Hello h = new Hello();
        Assert.assertEquals( h.sayHello(), "Hello World from the servlet", "got incorrect response");
    }
}
