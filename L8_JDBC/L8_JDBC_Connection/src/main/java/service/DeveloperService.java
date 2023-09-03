package service;

import model.Developer;

import java.util.Scanner;

public class DeveloperService {
    public static Developer inputDeveloper() {
        Developer developer = new Developer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dev name: ");
        developer.setName(scanner.nextLine());
        System.out.println("Enter dev specialty: ");
        developer.setSpecialty(scanner.nextLine());
        System.out.println("Enter dev salary: ");
        developer.setSalary(scanner.nextInt());
        return developer;
    }

}
