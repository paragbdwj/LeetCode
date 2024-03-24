package oops;

public class Abstraction {
    public abstract class TestClass {
        public int a;
        abstract void f();
        void g() {
            System.out.printf("I am in the non-abstract method");
        }
    }

    public static void main(String[] args) {
//        TestClass testClassObj = new TestClass(); // won't be possible to instantiate
    }

}
