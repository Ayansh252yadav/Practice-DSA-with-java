package LinkedList26;

import java.util.ArrayList;

public class LinkedListIsCycle extends CreateLinkedList{
    public static boolean isCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CreateLinkedList ls=new CreateLinkedList();
        int arr[]={10 ,20, 30, 40};
        for(int i=0;i<arr.length;i++){
            ls.addLast(arr[i]);
        }
        ls.printList(ls.head);
        Node temp=ls.head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node tail=temp;
        tail.next=ls.head;
        System.out.println(isCycle(ls.head));

    }
}
