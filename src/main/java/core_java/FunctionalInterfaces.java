package core_java;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    @FunctionalInterface
    public interface FuncInterface {

        void target();
    }

    public static class Child implements FuncInterface {
        @Override
        public void target() {
            System.out.println("Inside the target function of Child class");
        }
    }
    public static void main(String[] args) {
        Child child = new Child();
        child.target();

        FuncInterface funcInterface = new FuncInterface() {
            @Override
            public void target() {
                System.out.println("anon class: 1 target() inside class");
            }
        };

        FuncInterface funcInterfaceSecond = () -> System.out.println("anon class: 2 target() inside class");

        funcInterface.target();
        funcInterfaceSecond.target();


/////////////////////////////////////////////////////////         CONSUMER        /////////////////////////////////////////////////////
        Consumer<Integer> consumer = (x) -> {
            x = x + 5;
            System.out.println("Value of integer is " + x);
        };
        consumer.accept(4);

/////////////////////////////////////////////////////////         PRODUCER        /////////////////////////////////////////////////////

        Supplier<Integer> supplier = () -> {
            System.out.println("I am a supplier :)");
            return 5;
        };
        Integer supplierValue = supplier.get();
        System.out.println("supplier Value is " + supplierValue);

/////////////////////////////////////////////////////////         PREDICATE        /////////////////////////////////////////////////////

        Predicate<Integer> predicate = (x) -> x == 5;
        System.out.println("predicate value is " + predicate.test(5));

/////////////////////////////////////////////////////////         FUNCTION        /////////////////////////////////////////////////////

        Function<String, Integer> function = Integer::parseInt;
        System.out.println("function value for 327 is " + function.apply("327"));
    }
}
