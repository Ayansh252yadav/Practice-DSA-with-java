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
        CreateLinkedList ls=new CreateLinkedList();
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            ls.addFirst(arr[i]);
        }
        ls.printList(ls.head);
        deleteNthnode(ls.head,2);
        System.out.println();
        ls.printList(ls.head);
    }
}
