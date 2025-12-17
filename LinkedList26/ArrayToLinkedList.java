package LinkedList26;

public class ArrayToLinkedList extends CreateLinkedList {
    public static int getMiddle(Node head) {
        // code here
        int size=0;
        Node temp1=head;
        while(temp1!=null){
            temp1=temp1.next;
            size++;
        }
        int i=0;
        temp1=head;
        while(i<size/2){
            temp1=temp1.next;
            i++;
        }
        return temp1.data;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            addFirst(arr[i]);
        }
        printList(head);
        System.out.println();
        System.out.println(getMiddle(head));
    }
}
