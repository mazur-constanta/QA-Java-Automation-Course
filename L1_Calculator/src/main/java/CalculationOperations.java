import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculationOperations {
    private Double firstNum;
    private Double secondNum;
    private Double result;
    private char operation;


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

    public void performCalculation() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean numbers = enterNumbers();
            while (numbers) {
                numbers = enterNumbers();
            }

            boolean operator = chooseOperation();
            while (operator) {
                operator = chooseOperation();
            }

            switch (operation) {
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
            System.out.println(firstNum + " " + operation + " " + secondNum + " = " + result + "\n");

            System.out.println("Would you like to exit? y/n");

            char exit = scanner.next().charAt(0);

            while (exit != 'y' && exit != 'n') {
                System.out.println("Write only y or n: ");
                exit = scanner.next().charAt(0);
            }

            if (exit == 'y') {
                break;
            }
        }
    }


    public boolean enterNumbers() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter 1st number: ");
            firstNum = scanner.nextDouble();

            System.out.println("Enter 2nd number: ");
            secondNum = scanner.nextDouble();
            return false;
        } catch (InputMismatchException ime) {
            System.out.println("You cannot enter letters or special symbols.");
            return true;
        }
    }

    public boolean chooseOperation() {
        System.out.println("Enter some operator:");
        Scanner scanner = new Scanner(System.in);
        List<Character> validCharacters = List.of('+', '-', '*', '/');

        try {
            operation = scanner.next().charAt(0);
            if (!validCharacters.contains(operation)) {
                throw new NoSuchElementException();
            }
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Choose valid operation: +, -, *, /. You cannot use letters or special symbols.");
            return true;
        }
    }
}
