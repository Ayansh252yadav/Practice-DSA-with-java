package LinkedList26;

public class RemoveNthNodeFromEndOfList extends CreateLinkedList{
    public static void deleteNthnode(Node head,int n){
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        if(size==n){
            head=head.next;
            return;
        }
        int i=1;
        temp=head;
        while(i<size-n){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            addFirst(arr[i]);
        }
        printList(head);
        deleteNthnode(head,2);
        System.out.println();
        printList(head);
    }
}
