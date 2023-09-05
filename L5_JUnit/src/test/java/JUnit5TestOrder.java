import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5TestOrder {
    private static StringBuilder output = new StringBuilder("");

    @Order(1)
    @Test
    public void myBTest() {
        output.append("A");
        System.out.println(output);

        List<String> list1 = Arrays.asList("1", "2", "3");
        List<String> list2 = Arrays.asList("1", "2", "3");

        assertEquals(list1, list2, "");
    }

    @Order(2)
    @Test
    public void myATest() {
        output.append("B");
        System.out.println(output);
    }

}
