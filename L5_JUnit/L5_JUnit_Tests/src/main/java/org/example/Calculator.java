package org.example;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double firstNum;
        double secondNum;
        double result;
        char operation;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        firstNum = scanner.nextDouble();

        System.out.println("Enter some operator:");
        operation = scanner.next().charAt(0);

        System.out.println("Enter 2nd number: ");
        secondNum = scanner.nextDouble();

        switch(operation) {
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
            default:
                System.out.println("Something went wrong! Choose valid operation: +, -, *, /");
                return;
        }
        System.out.println("Your result is:");
        System.out.println(firstNum + " " + operation + " " + secondNum + " = " + result);
    }

    public static double sum(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    public static double minus(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    public static double multiply(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    public static double divide(double firstNum, double secondNum) {
        return firstNum / secondNum;
    }

}
