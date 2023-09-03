package org.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

public class AssumeTest {
    @Test
    public void testAssumeExample() {
//        assumeTrue(System.getProperty("os.name").equals("Mac OS X"));
//        assertEquals("Test failed", 3, 3);

        assumeThat(System.getProperty("os.name"), is("Mac OS X"));
        assertEquals(3, 3);
    }
}
