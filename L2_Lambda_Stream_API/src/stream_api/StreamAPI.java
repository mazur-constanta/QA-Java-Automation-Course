package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import java.util.stream;

public class StreamAPI {
    public static void main(String[] args) {
        /**Stream API - набор классов и методов, для удобства работы с коллекциями и т.п.
         2 типа метода: конвейерные (работают на 1 поток данных
         и возвращают новый поток)
         терминальные (завершают цепочку операций и выполняют
         конечное действие - вывод коллекции, сохранение в коллекцию)*/

        // Конвеерные методы
        List<String> values = Arrays.asList("a11", "a11", "f44", "a3", "ki1");

        // filter - contains number 1
        List<String> resultFilter = values.stream()
            .filter(value -> value.contains("1"))
            .collect(Collectors.toList());
        System.out.println(resultFilter); /** [a11, a11, ki1] */

        // skip
        List<String> resultSkip = values.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(resultSkip); /** [f44, a3, ki1] */

        // distinct - no duplicates
        List<String> resultDistinct = values.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(resultDistinct); /** [a11, f44, a3, ki1] */

        // map - does smth for each element (changes list)
        List<String> resultMap = values.stream()
                .map(value -> value.concat("_1"))
                .collect(Collectors.toList());
        System.out.println(resultMap); /** [a11, f44, a3, ki1] */

        // peek - for logging
        List<String> resultPeek = values.stream()
//                .peek(value -> System.out.println(value)) // pick and do not return anything
//                .map(value -> value.toUpperCase()) // pick and return smth

                // Method references - call static methods
                .peek(System.out::println)
//                .peek(value -> System.out.println(value))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(resultPeek); /** [A11, A11, F44, A3, KI1] */

        // limit - output: 2 elements of collection
        List<String> resultLimit = values.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(resultLimit); /** [a11, a11, f44] */

        // sorted - to sort elements
        List<String> resultSorted = values.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultSorted); /** [a11, a11, a3, f44, ki1] */

        // mapToInt, mapToDouble, mapToLong
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
//                .mapToInt(value -> Integer.parseInt(value))

                // using Method Reference
//                .mapToInt(Integer::parseInt)
                .mapToDouble(Double::parseDouble)
                .forEach(System.out::println);
                /**1.0
                2.0
                3.0
                4.0
                5.0*/
//        System.out.println(strings);

        // flatMap
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenList = listOfLists.stream()
                .flatMap(collection -> collection.stream())
                .collect(Collectors.toList());
        System.out.println(flattenList); /** [1, 2, 3, 4, 5, 6, 7, 8, 9] */

        //
        List<String> list = Arrays.asList("Geeks", "GPT", "GeekForGreeks");

        List<Character> result = list.stream()
                .flatMap(str -> Stream.of(str.charAt(2)))
                .collect(Collectors.toList());
        System.out.println(result); /** [e, T, e] */

        // Терминальные методы
        // findFirst
        String result1 = values.stream()
                .filter(value -> value.contains("1"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such el"));
//                .get();
        System.out.println(result1); /** a11 */

        // findAny
        String result2 = values.stream()
                .filter(value -> value.contains("1"))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such el"));
//                .get();
        System.out.println(result2); /** a11 */

        // collect to new result

        // allMatch
        boolean allMatchResult = values.stream()
                .allMatch(value -> value.contains("a"));
        System.out.println(allMatchResult); /** false */

        // anyMatch
        boolean anyMatchResult = values.stream()
                .anyMatch(value -> value.contains("k"));
        System.out.println(anyMatchResult); /** true */

        // noneMatch
        boolean noneMatchResult = values.stream()
                .noneMatch(value -> value.contains("z"));
        System.out.println(noneMatchResult); /** true */

        // Operations, which can be useful
        List<Integer> ints = Arrays.asList(1, 33, 54, 76, 89);
        int maxResult = ints.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException(""));
        System.out.println(maxResult); /** 89 */

        // forEach - works for each element
        values.stream()
                .filter(value -> value.contains("1"))
                .forEach(System.out::println);

        // forEachOrdered
        values.stream()
                .filter(value -> value.contains("1"))
                .forEachOrdered(System.out::println);

        // toArray
        Integer[] arr1 = ints.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr1)); /** [1, 33, 54, 76, 89] */
    }
}
