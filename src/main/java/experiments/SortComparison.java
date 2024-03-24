package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortComparison {

    static void quickSort(int[] a) {
        long start = System.currentTimeMillis();
        Arrays.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("Arrays.sort() took time : " + (end - start)/1000.0);
    }

    static void mergeSortWithStreams(int[] a) {
        long start = System.currentTimeMillis();
        List<Integer> listInt = Arrays.stream(a).boxed().sorted().toList();
        long end = System.currentTimeMillis();
        System.out.println("Collections.sort() (mergeSortWithStreams) took time : " + (end - start)/1000.0);
    }

    static void mergeSortNormal(int[] a) {
        long start = System.currentTimeMillis();
        List<Integer> listInt = new ArrayList<>();
        for(int x : a) {
            listInt.add(x);
        }
        Collections.sort(listInt);
        long end = System.currentTimeMillis();
        System.out.println("Collections.sort() (mergeSortNormal) took time : " + (end - start)/1000.0);
    }


    public static void main(String[] args) {

        int[] a = new int[10000000];
        for(int i = 0; i < 10000000; i++) {
            a[i] = i;
        }
        int[] b = Arrays.stream(a).toArray();
        int[] c = Arrays.stream(a).toArray();

        //Arrays.sort() is dumb which uses quick sort (which is O(n^2) in worst case scenario)
        quickSort(a);

        //Collections.sort() uses merge sort
        mergeSortWithStreams(b);
        mergeSortNormal(c);
    }
}
