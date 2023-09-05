package org.example.test_ex;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {
    @Test
    public void testSoftAssert() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(2 < 1);
        System.out.println("Assertion failed in Test 1");
        soft.assertFalse(1 > 0);
        System.out.println("Assertion failed in Test 1");
        soft.assertAll();
    }
}
