package OnlinePlatform;

import java.util.PriorityQueue;

public class MergeKSortedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    static Node tail;
    public static void addFirst(int data){
        if(head==null){
            Node newNode=new Node(data);
            head=tail=newNode;
            return;
        }
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public static void addLast(int data){
        if(head==null){
            Node newNode=new Node(data);
            tail=head=newNode;
            return;
        }
        Node newNode=new Node(data);
        tail.next=newNode;
        tail=newNode;
    }
    public static void addAtPosition(int data,int pos){
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode=new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;

            if (tail == null) { // list was empty
                tail = newNode;
            }
            return;
        }
        Node temp=head;
        for(int i=1;i<pos-1;i++){
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public static void printList(Node head){
        if(head==null){
            System.out.println("List is empty please first insert some element before print");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        for(int i=0;i<arr.length;i++){
            addFirst(arr[i]);
        }
        addAtPosition(5,1);
        printList(head);
    }
}
class MergesortefList {
    public class ListNode {
      int val;
      ListNode next;
     ListNode(int val) {
         this.val = val;
         this.next = next;
     }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}

