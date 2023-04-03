package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertIterableEquals() {
        List<String> al = new ArrayList<>(Arrays.asList("Java", "JUnit", "Test"));
        List<String> ll = new ArrayList<>(Arrays.asList("Java", "JUnitt", "Test"));
        assertIterableEquals(al, ll, "typo somewhere");
    }

    @Test
    public void testAssertIterableEqualsTwo() {
        List<String> al2 = new ArrayList<>(Arrays.asList("Java", "JUnit", "Test"));
        List<String> ll2 = new ArrayList<>(Arrays.asList("Java", "JUnit", "Test"));
        assertIterableEquals(al2, ll2, "error message");
    }

    @Test
    public void testAssertLinesMatches() {
        // D+ - non numberic, d+ - numeric, .* - for texts
        List<String> expected = Arrays.asList("Java", "\\d+", ".*");
        List<String> actual = Arrays.asList("Java", "11", "Test");
        assertLinesMatch(expected, actual);
    }

    // with lambdas
    @Test
    public void testAssertEqual() {
        char[] expected = {'J', 'u', 'p', 'i', 't', 'e', 'r'};
        char[] actual = "Jupiter".toCharArray();
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void testAssertFalse() {
        BooleanSupplier condition = () -> 5 > 6;
        assertFalse(condition, "5 is not greater than 6");
    }

    @Test
    public void testAssertNull() {
        Object cat = null;
        assertNull(cat, () -> "Cat should be null.");
    }

//    @Test
//    public void testFailAssert() {
//        // Test not completed
//        fail("Fail - test not completed");
//    }

    /** HardAssert - if smth failed, others won't run. SoftAssert - even if smth failed, others will run */
//    @Test
//    public void testAssertAll() {
//        assertAll(
//                () -> assertEquals("javo", "JAVA".toLowerCase(), "error 1"),
//                () -> assertEquals("javo", "JAVA".toLowerCase(), "error 2")
//        );
//    }

    // to check that method throws exceptions with some particular message
    @Test
    void TestAssertThrows() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Exception message");
                }
        );
        assertEquals("Exception message", exception.getMessage());
    }

    // code that requires less than 2 minutes to execute
    @Test
    public void testAssertTimeout() {
        assertTimeout(
            ofSeconds(2),
            () -> {
                // code that requires less than 2 minutes to execute
                Thread.sleep(1000);
            }
        );
    }

}
