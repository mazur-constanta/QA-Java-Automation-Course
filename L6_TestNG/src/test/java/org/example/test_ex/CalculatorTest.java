package org.example.test_ex;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {
    @Test
    public void testContainsAnyOf() {
        List<String> abc = Arrays.asList("a", "b", "c");

        assertThat(abc)
//                .containsAnyOf("b")
//                .containsAnyOf("b", "c")
//                .containsAnyOf("a", "b", "c")
//                .containsAnyOf("a", "b", "c", "d")
                .containsAnyOf("e", "f", "g");

    }

    @Test
    public void assertionExampleContainExactlyElementsOf() {
        List<String> names = Arrays.asList("Tanya", "Nadya");
        assertThat(names)
                .containsExactlyElementsOf(new ArrayList<>(Arrays.asList("Nadya", "Tanya")));
    }

    @Test
    public void assertionExamplesContainsAll() {
        List<String> names = Arrays.asList("Kolya", "Vasya");
        assertThat(names)
                .containsAll(Arrays.asList("Kolya", "Ivan"));
    }

    @Test
    public void assertionExamples() {
        String name = "Kate1";
        System.out.println("Check...");
//        assertThat(name).overridingErrorMessage("Person's name").isEqualTo("Kate");
        assertThat(name).as("Person's name").isEqualTo("Kate");
    }
}
