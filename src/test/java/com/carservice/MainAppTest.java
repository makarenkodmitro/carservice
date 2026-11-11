package com.carservice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MainAppTest extends TestCase {
    public MainAppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MainAppTest.class);
    }

    public void testMainApp() {
        assertTrue(true);
    }
}
