package experiments;

public class ExceptionFlow {

    static void exceptionFlows2() {
        try {
            exceptionFlows1();
        } catch (Exception e) {
            System.out.println("In exceptionFlows2 catch");
        }

    }

    static void exceptionFlows1() {
        try {
            int x = 1/0;
        } catch (Exception e) {
            // do something
            System.out.println("In exceptionFlows1 catch");
            throw e;
        }
    }
    public static void main(String[] args) {
        exceptionFlows2();
    }
}
