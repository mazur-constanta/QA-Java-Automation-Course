package homework1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculationOperations {
    private double firstNum;
    private double secondNum;
    private double result;
    private char operation;

    Scanner scanner = new Scanner(System.in);

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    private double sum(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    private double minus(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    private double multiply(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    private double divide(double firstNum, double secondNum) {
        boolean notValidSecondVal = secondNum == 0;

        if (notValidSecondVal) {
            throw new ArithmeticExceptionCust("You cannot divide by 0. You need to enter number <> 0");
        }
        return result = firstNum / secondNum;
    }

    public String performCalculation() {
        enterNumbers();
        switch(chooseOperation()) {
            case '+':
                result = sum(firstNum, secondNum);
                break;
            case '-':
                result = minus(firstNum, secondNum);
                break;
            case '*':
                result = multiply(firstNum, secondNum);
                break;
            case '/':
                result = divide(firstNum, secondNum);
                break;
        }
        return firstNum + " " + operation + " " + secondNum + " = " + result + "\n";
    }

    public void enterNumbers() {
        try {
            System.out.println("Enter 1st number: ");
            firstNum = scanner.nextDouble();

            System.out.println("Enter 2nd number: ");
            secondNum = scanner.nextDouble();
        } catch (InputMismatchException ime) {
            throw new InputMismatchException("You cannot enter letters or special symbols.");
        }
    }

    public char chooseOperation() {
        System.out.println("Enter some operator:");

        operation = scanner.next().charAt(0);

        List<Character> validCharacters = List.of('+', '-', '*', '/');

        boolean notValidCharacters = !(validCharacters.contains(operation));

        if (notValidCharacters) {
            throw new NoSuchElementException("Choose valid operation: +, -, *, /. You cannot use letters or special symbols.");
        }
        return operation;
    }
}
