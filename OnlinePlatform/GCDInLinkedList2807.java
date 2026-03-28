package OnlinePlatform;
import LinkedList26.ArrayToLinkedList;
import LinkedList26.CreateLinkedList;

import java.util.ArrayList;

public class GCDInLinkedList2807 extends CreateLinkedList {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public static Node insertAtPos(Node head,int pos,int data){
        Node newNode=new Node(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }

        Node temp=head;
        for(int i=0;i<pos-1;i++){
            if(temp==null){
                return head;
            }
            temp=temp.next;
        }
        if(temp==null){
            return head;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
    public static Node insertGreatestCommonDivisors(Node head) {
      if(head==null){
          return null;
      }
        ArrayList<Integer>arr=new ArrayList<>();
      Node temp=head;
      while(temp.next!=null){
          int gcd=gcd(temp.data,temp.next.data);
          arr.add(gcd);
          temp=temp.next;
      }
      int pos=1;
     for(int i=0;i<arr.size();i++){
         head = insertAtPos(head, pos, arr.get(i));
         pos += 2;
     }
      return head;
    }

    public static void main(String[] args) {
        int []arr={3,10,6,18};
        CreateLinkedList cr=new CreateLinkedList();

        for(int i=0;i<arr.length;i++){
            cr.addFirst(arr[i]);
        }
        cr.printList(cr.head);
       Node head1= insertGreatestCommonDivisors(cr.head);
        System.out.println();
        cr.printList(head1);
    }
}
