package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class VintageTest {
    @BeforeEach
    public void somePrecondition() {
        System.out.println("Precondition");
    }

    @Test
    @DisplayName("This test validates...")
    public void someTest() {
        System.out.println("Test");
    }

}
