import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = initEmployees();

        List<String> empOlderThan30 = employees.stream()
                .filter(emp -> emp.getAge() > 30)
                .map(Employee::toString)
                .collect(Collectors.toList());
        System.out.println(empOlderThan30);

        List<Employee> updateAddress = employees.stream()
                .map(emp -> new Employee(emp.getName(), emp.getAge(), emp.getAddress().concat("_City")))
                .collect(Collectors.toList());
        System.out.println(updateAddress);

        List<Employee> updateEmpOlderThan18WithNamePart = employees.stream()
                .filter(emp -> emp.getAge() > 18)
                .map(emp -> new Employee(emp.getName().concat("_name"), emp.getAge(), emp.getAddress()))
                .collect(Collectors.toList());
        System.out.println(updateEmpOlderThan18WithNamePart);

        List<String> newEmpNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(newEmpNames);

    }

    private static List<Employee> initEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", 25, "Minsk"));
        employees.add(new Employee("Oleg", 6, "Moscow"));
        employees.add(new Employee("Hanna", 45, "Minsk"));
        employees.add(new Employee("Mike", 52, "Riga"));
        employees.add(new Employee("Olga", 27, "Minsk"));
        employees.add(new Employee("Nikita", 32, "Gdansk"));
        employees.add(new Employee("Mike", 52, "Riga"));
        employees.add(new Employee("Oleg", 6, "Moscow"));
        return employees;
    }
}
