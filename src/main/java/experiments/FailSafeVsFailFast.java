package experiments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeVsFailFast {

    // Fail Fast Iterator example :::: It will throw ConcurrentModificationException
    static void  FailFastIteratorExample() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(21);
        list.add(22);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            // do any sort of operation to modify list like insert/sort
            list.remove(a);
            System.out.println(list);
        }
        System.out.println("FailFastIteratorExample success");

    }

    static void FailSafeIteratorExample() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(13);
        list.add(27);
        list.add(29);
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer a = itr.next();
            list.remove(a);
            System.out.println(list);
        }
        System.out.println("FailSafeIteratorExample success");
    }

    public static void main(String[] args) {
//        FailFastIteratorExample();
        FailSafeIteratorExample();
    }
}
