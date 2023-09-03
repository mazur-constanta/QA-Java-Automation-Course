package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest {
    @Test
    public void testAssumptionOne() {
        String someString = "Just a String";
        assumingThat(
            someString.equals("Just a string"),
            () -> assertEquals(4, 2)
        );
    }

    @Test
    public void testAssumptionTwo() {
        assumingThat(System.getProperty("as.name").equals("Windows"),
            () -> assertTrue(false, "error message")
        );
        System.out.println("Smth after Assume");
    }
}
