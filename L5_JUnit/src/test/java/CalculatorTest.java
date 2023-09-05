import org.junit.*;

import static org.junit.Assert.*;

@Ignore("Reason")
public class CalculatorTest {
    private Calculator calculator;

    @Before // precondition
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Ignore("Not correct logic") //@Test // Tests/Verify/testSearch_numbers
    public void testMultiply() {
        assertEquals("Regular multiplication should work",
                calculator.multiply(4.0, 5.0), 20.0);
    }

    @Ignore("Not correct logic") //@Test
    public void testMultiplyWithZero() {
        assertEquals("Multiple with zero should be zero", 0,
                calculator.multiply(0, 5));
        assertEquals("Multiple with zero should be zero", 0,
                calculator.multiply(5, 0));
    }
}
