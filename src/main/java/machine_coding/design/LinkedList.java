package machine_coding.design;

public class LinkedList {

    static class Node {
         Node next;
         Node prev;
         int data;

         Node() {

         }

         Node(int data) {
             this.data = data;
             this.next = null;
             this.prev = null;
         }
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node node = node0;
        System.out.println("address of node is " + node);
        System.out.println("address of node0 is " + node0);
        node = node2;
        System.out.println("address of node is " + node);
        while(node != null) {
            System.out.println("for address : " + node + "data is " + node.data);
            node = node.next;
        }
        System.out.println("data for node 0 : " + node0.data);
    }
}
