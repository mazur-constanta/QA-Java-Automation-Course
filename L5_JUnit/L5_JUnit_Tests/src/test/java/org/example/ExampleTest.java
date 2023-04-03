package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class ExampleTest {
    @Test
    @Tag("smoke")
    @Tag("gold")
    public void testOne() {
        System.out.println("Test 1");
    }

    @Test
    public void testTwo() {
        System.out.println("Test 2");
    }
}
