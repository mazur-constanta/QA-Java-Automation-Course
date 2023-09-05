import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    CalculationOperations calc = new CalculationOperations();

    @Test
    @DisplayName("Test to check - / 0 exception")
    public void TestAssertThrowsArithmeticExceptionCust() {
        Throwable exception = assertThrows(
                ArithmeticExceptionCust.class,
                () -> {
                    throw new ArithmeticExceptionCust("You cannot divide by 0. You need to enter number <> 0");
                }
        );
        assertTrue("You cannot divide by 0. You need to enter number <> 0".contains(exception.getMessage()));
    }

    @Test
    @DisplayName("Test to check valid operation exception")
    public void TestAssertThrowsNoSuchElException() {
        Throwable exception = assertThrows(
                NoSuchElementException.class,
                () -> {
                    throw new NoSuchElementException("Choose valid operation: +, -, *, /. You cannot use letters or special symbols.");
                }
        );
        assertEquals("Choose valid operation: +, -, *, /. You cannot use letters or special symbols.", exception.getMessage());
    }

    @Test
    @DisplayName("Test to check input mismatch exception")
    public void TestAssertThrowsInputMismatch() {
        Throwable exception = assertThrows(
                InputMismatchException.class,
                () -> {
                    throw new InputMismatchException("You cannot enter letters or special symbols.");
                }
        );
        assertEquals("You cannot enter letters or special symbols.", exception.getMessage());
    }

    @Test
    public void testSum() {
        Assertions.assertEquals(
                calc.sum(4.0, 5.0), 9.0);
    }

    @Test
    public void testMinus() {
        Assertions.assertEquals(
                calc.minus(14.0, 4.0), 10.0);
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals(
                calc.multiply(2.0, 15.0), 30.0);
    }

    @Test
    public void testDivide() {
        Assertions.assertEquals(
                calc.divide(25.0, 5.0), 5.0);
    }

    @Test
    public void testDivideNegative() {
        assertThrows(
                ArithmeticExceptionCust.class,
                () -> {
                    calc.divide(5, 0);
                }
        );

//        CalculationOperations calculationOperations = new CalculationOperations();
//        calculationOperations.setFirstNum(10.0);
//        calculationOperations.setSecondNum(0.0);
//        calculationOperations.setOperation('/');
//        calculationOperations.setResult(0.0);
    }

//    @Test
//    public void performCalculations() throws IOException {
//        byte[] input1 = { 10 };
//        byte[] input2 = { 7 };
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(input1);
//        DataInputStream input = new DataInputStream(inputStream);
////        input.readDouble();
//        System.setIn(input);
//        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(input2);
//        DataInputStream inputs2 = new DataInputStream(inputStream2);
//        System.setIn(inputs2);
//        assertEquals(calc.performCalculation(), "End of program");
//    }

}
