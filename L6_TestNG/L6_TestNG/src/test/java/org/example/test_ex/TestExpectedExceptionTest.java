package org.example.test_ex;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestExpectedExceptionTest {
    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerExpection() {
        ArrayList<String> list = null;
        int size = list.size();
    }
}
