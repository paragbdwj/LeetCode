package experiments;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class ClassStaticTesting {

    @Setter
    @Getter
    static class TestClass {
        private static int x = 0;
        private static Integer y = 0;

        private int z;
        private Integer w = 0;

        private static Map<Integer,TestClass> map = new HashMap<>();
        TestClass() {
            x++;
            y++;
            z++;
            w++;
            map.put(x, this);
        }

        public String printObj() {
           return "x : " + x + " y : " + y + " z : " + this.z + " w : " + this.w;
        }

        public Map<Integer,TestClass> getMap() {
            return map;
        }
    }

    public static void main(String[] args) {

        TestClass testClass1 = new TestClass();
        System.out.println("testClass1: " + testClass1.printObj());
        TestClass testClass2 = new TestClass();
        System.out.println("testClass2: " + testClass2.printObj());
        TestClass testClass3 = new TestClass();
        System.out.println("testClass3: " + testClass3.printObj());
        TestClass testClass4 = new TestClass();
        System.out.println("testClass4: " + testClass4.printObj());

    }
}
