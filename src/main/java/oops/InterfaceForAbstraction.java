package oops;

public class InterfaceForAbstraction {

    // ----------------------------------INTERFACES--------------------------------------------------------

    public interface I1 {
        void f1();
        void g1();
    }

    public interface I2 {
        void f2();
        void g2();

    }
    public interface I3 extends I1,I2 {

    }

    // -------------------------------------CLASSES---------------------------------------------------------

    public class C1 implements I1 {


        public void f1() {
            System.out.println("In function f1 of class C1");
        }
        public void g1() {
            System.out.println("In function g1 of class C1");
        }

    }
    public class C2 implements I2 {


        public void f2() {
            System.out.println("In function f2 of class C2");
        }
        public void g2() {
            System.out.println("In function g2 of class C2");
        }

    }

    public class C3 implements I3 {

        public void f1() {
            System.out.println("In function f1 of class C3");
        }
        public void f2() {
            System.out.println("In function f2 of class C3");
        }
        public void g1() {
            System.out.println("In function g1 of class C3");
        }
        public void g2() {
            System.out.println("In function g2 of class C3");
        }
    }

//-----------------------------------------DIAMOND PROBLEM----------------------------------------------------
    public static class C4 {
        void f() {
            System.out.println("In function f of C4");
        }
    }
    public static class C5 extends C4 {
        @Override
        void f() {
            System.out.println("In function f of C5");
        }
    }

    public static void main(String[] args) {
        C5 c5 = new C5();
        c5.f();
    }

}
