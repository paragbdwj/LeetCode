package experiments;

import java.util.TreeMap;

public class MultiSetUpperBoundAndLowerBound {

    public static class MultiSet<T> {
        TreeMap<T, Integer> elementToFreqMap;

        public void add(T ele) {
            elementToFreqMap.put(ele, elementToFreqMap.getOrDefault(ele, 0) + 1);
        }

        public int getFreq(T ele) {
            return elementToFreqMap.getOrDefault(ele,0);
        }

    }


}
