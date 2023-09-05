package lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RunnableLambda {
    public static void main(String[] args) {
        // Implementation 1
//        Runnable runnable = new MyThreadBehaviour();
//        Thread thread = new Thread(runnable);
//        thread.run();

        // Implementation 2
//        Thread thread = new Thread(new MyThreadBehaviour());
//        thread.run();

        // Implementation 3
//        Thread thread = new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                }
//        );
//        thread.run();

        // Implementation 4 - Interface Lambda (Consumer, Supplier, Predicate)
//        Runnable runnable = () -> System.out.println("Hello!");
//        Thread thread = new Thread(runnable);
//        thread.run();

        // Implementation 5 - Interface Lambda (short format)
//        Thread thread = new Thread(() -> System.out.println("Hello!"));
//        thread.run();

        Runnable runnable = () -> System.out.println("Hey hey");
        Consumer<String> consumer = (a) -> System.out.println(a.toUpperCase());
        consumer.accept("f");

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

        Predicate<String> predicate = (a) -> a.contains("a");
        System.out.println(predicate.test("fhsa"));
    }

    // Should be used for Imp 1/Imp 2
//    public static class MyThreadBehaviour implements Runnable {
//        @Override
//        public void run() {
//            System.out.println("Hello!");
//        }
//    }
}
