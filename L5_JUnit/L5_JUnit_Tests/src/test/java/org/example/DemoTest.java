package org.example;

import org.junit.Test;

import static junit.framework.Assert.*;

public class DemoTest {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    @Test
    public void testIsEven() {
        assertTrue("Is even works incorrectly", isEven(4));
    }

    @Test
    public void testIsOdd() {
        assertFalse("Is odd works incorrectly", isEven(3));
    }

    @Test
    public void testIsEvenWithFunc() {
        assertEquals("Is even works incorrectly", true, isEven(4));
    }

    @Test
    public void objestShouldNotBeNull() {
        Calculator calculator;
        assertNull("Is even works incorrectly", null);
    }

}
