package experiments;

public class LinkedListExperiment {
    public static class List {
        private List next;
        private int val;

        List(int val) {
            this.val = val;
            this.next = null;
        }

        List(List next, int val) {
            this.val = val;
            this.next = next;
        }
    }

    private static class Integer {
        int i;
        Integer(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) {
        List[] lists = new List[3];
        for(int i = 0; i < 3; i++) {
            lists[i] = new List(i + 1);
            System.out.println("list_ " + i + " is having address : " + lists[i] + " and value : " + lists[i].val +" and next : " + lists[i].next);
        }
        System.out.println("after making links ::::");
        for(int i = 0; i < 2; i++) {
            lists[i].next = lists[i+1];
            System.out.println("list_ " + i + " is having address : " + lists[i] + " and value : " + lists[i].val +" and next : " + lists[i].next);
        }
        System.out.println("after some modifications ::::");
        List head = lists[0];
        head = head.next;
        System.out.println("head is : " + head);
        for(int i = 0; i < 3; i++) {
            System.out.println("list_ " + i + " is having address : " + lists[i] + " and value : " + lists[i].val +" and next : " + lists[i].next);
        }
        Integer p = new Integer(-1);


    }
}
