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
        int arr[]={10 ,20, 30, 40};
        for(int i=0;i<arr.length;i++){
            addLast(arr[i]);
        }
        printList(head);
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node tail=temp;
        tail.next=head;
        System.out.println(isCycle(head));

    }
}
