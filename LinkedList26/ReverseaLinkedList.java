package LinkedList26;

import java.util.Stack;

public class ReverseaLinkedList extends CreateLinkedList{
    public  void reverseList(){
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
        CreateLinkedList ls=new CreateLinkedList();
        ReverseaLinkedList rs=new ReverseaLinkedList();
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            ls.addFirst(arr[i]);
        }
        ls.printList(ls.head);
        System.out.println();
        rs.reverseList();
        ls.printList(ls.head);
    }
}
