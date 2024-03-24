package design_patterns.creational;

import lombok.Getter;
import lombok.Setter;

public class Clone {
    private static class Sample {
        private int a;
        private int b;
        public static Sample getCloneStatic(Sample sample) {
            Sample newSample = new Sample();
            newSample.a = sample.a;
            newSample.b = sample.b;
            return newSample;
        }
        public Sample getCloneNonStatic () {
            Sample newSample = new Sample();
            newSample.a = this.a;
            newSample.b = this.b;
            return newSample;
        }
    }
    public static void main(String[] args) {
        Sample x = new Sample();
        x.a = 1;
        x.b = 2;
        Sample y = Sample.getCloneStatic(x);
        Sample z = x.getCloneNonStatic();
        System.out.println("y.a : " + y.a + "  y.b : " + y.b);
        System.out.println("z.a : " + z.a + "  z.b : " + z.b);
    }
}
