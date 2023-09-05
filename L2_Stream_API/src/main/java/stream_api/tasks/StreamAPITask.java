package stream_api.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPITask {

    private static List<Person> initPersons() {
        return Arrays.asList(
                new Person("Alex", 16, ""),
                new Person("Oleg", 16, "Lidl"),
                new Person("Kate", 25, "Vilnus"),
                new Person("Mike", 45, "Berlin"),
                new Person("Liza", 29, "Grodno")
        );
    }

    public static void main(String[] args) {
        List<Person> persons = initPersons();

        // return sorted by age
        List<Person> sortedByAgePersons = persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        System.out.println(sortedByAgePersons); /** [a11, a11, a3, f44, ki1] */

        // return sorted by age, name, address
        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getAddress))
                .collect(Collectors.toList());
        System.out.println(sortedPersons);

        // return the youngest person
        Person person1 = persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("no such person"));
        System.out.println(person1);

        // return all youngest persons
        Person firstPerson = persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("no such person"));

        List<Person> youngestPersons = persons.stream()
                .filter(person -> person.getAge() == firstPerson.getAge())
                .collect(Collectors.toList());
        System.out.println(youngestPersons);

        // return persons >= 18
        List<Person> adultPersons = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(adultPersons);

        // return all Person's names in console
        List<Person> personNames = persons.stream()
                .peek(value -> System.out.println(value.getName()))
                .collect(Collectors.toList());
        System.out.println(personNames);

        persons.stream()
                .forEach(value -> System.out.println(value.getName()));

        // return all person's addresses
        List<String> addresses = persons.stream()
                .map(Person::getAddress)
                .collect(Collectors.toList());
        System.out.println(addresses);

        // add _city to each address
        List<Person> updateWithAddress = persons.stream()
                .map(person -> new Person(person.getName(), person.getAge(), person.getAddress().concat("_city")))
                .collect(Collectors.toList());
        System.out.println(updateWithAddress); /** Person{name='Oleg', age=16, address='Lidl_city'} */

        // using forEach we're changing initial collection
//        persons.stream()
//                .forEach(person -> person.setAddress(person.getAddress().concat("_cities")));
//        System.out.println(persons); /** Person{name='Alex', age=16, address='_cities'} */

        // names of 18+ persons
        List<String> personNamesAge18 = persons.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(personNamesAge18);

        // qtu of 18+ persons
        long personAge18 = persons.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println(personAge18);

        // if all persons have the address
        boolean isAddressPresentForEachPerson = persons.stream()
//                .allMatch(person -> isAddressPresent(person));
                .allMatch(StreamAPITask::isAddressPresent);
        System.out.println(isAddressPresentForEachPerson); /** false */

        // 3 last people
        persons.stream()
                .skip(2)
                .forEach(System.out::println);

        // 2 people
        persons.stream()
                .limit(2)
                .forEach(System.out::println);
    }

    private static boolean isAddressPresent(Person person) {
        return !person.getAddress().equals("") && person.getAddress() != null;
    }




}
