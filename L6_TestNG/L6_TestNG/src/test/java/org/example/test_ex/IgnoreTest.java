package org.example.test_ex;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test(enabled = false)
    public void testSetPropertyIgnored() {
        System.out.println("This method will be ignored during testing");
    }

    @Test
    public void testSetPropertyEnabledMethod() {
        System.out.println("This method will be performed due to enabled method");
    }
}
