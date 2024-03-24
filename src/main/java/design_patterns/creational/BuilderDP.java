package design_patterns.creational;

public class BuilderDP {
    private class Sample {
        private int a;
        private int b;
        public int getA() {
            return this.a;
        }
        public int getB() {
            return this.b;
        }
        public void setA(int a) {
            this.a = a;
        }
        public void setB(int b) {
            this.b = b;
        }

        public static class Builder {

        }
    }
}
