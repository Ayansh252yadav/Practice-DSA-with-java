package LinkedList26;

import java.util.Stack;

public class ReverseaLinkedList extends CreateLinkedList{
    public static void reverseList(){
     Node prev=null;
     Node curr=tail=head;
     Node next;
     while (curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
     }
     head=prev;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            addFirst(arr[i]);
        }
        printList(head);
        System.out.println();
        reverseList();
        printList(head);
    }
}
