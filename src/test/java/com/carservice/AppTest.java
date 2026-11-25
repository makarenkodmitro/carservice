package com.carservice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testPerformedWorksArePrintedOnSeparateLinesWithoutSemicolons()
    {
        ServiceOrder order = new ServiceOrder(1201, "2026-09-02", "CA 1001 AA",
                "Skoda", "Octavia", "Заміна мастила; Заміна фільтра");

        String output = order.toString();

        assertTrue(output.contains("performedWorks=\"Заміна мастила"
                + System.lineSeparator() + "Заміна фільтра\""));
        assertFalse(output.contains(";"));
    }
}
