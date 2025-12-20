package LinkedList26;

import java.util.Stack;

public class RotateListleetcode61 extends CreateLinkedList{
    public static Node deleteEnd(){
        if(head==null){
            return head;
        }

        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        Node del=temp.next;
        temp.next=null;
        tail=temp;
//        System.out.println(tail.data);
//        System.out.println(head.data);
        return del;
    }
    public static void addFirst(int data){
        Node newNode=new Node(data);
     if(head==null){
         head=tail=newNode;
         return;
     }
     newNode.next=head;
     head=newNode;
    }

    public static void main(String[] args) {
        RotateListleetcode61 sc=new RotateListleetcode61();
        int arr[]={10 ,20, 30, 40};
        for(int i=0;i<arr.length;i++){
            addLast(arr[i]);
        }
//       Node del= deleteEnd(head);
//        addFirst(del.data);
//        System.out.println(del.data);
//        printList(head);
        int k=6;
        Node temp=head;
        int size=0;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        for(int i=0;i<k%size;i++){
            Node del1=deleteEnd();
            addFirst(del1.data);
        }
        printList(head);
    }
}

//right rotation of LinkedList
class Solution  {
    public class ListNode {
      int val;
      ListNode next;

      ListNode(int val) { this.val = val;
          this.next = next;
      }
  }
    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find length and tail
        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        ListNode tail = temp;

        // 2. Make list circular
        tail.next = head;

        // 3. Find new tail
        int norotate = size - (k % size) - 1;
        ListNode newTail = head;
        for (int i = 0; i < norotate; i++) {
            newTail = newTail.next;
        }

        // 4. Break the circle
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}

