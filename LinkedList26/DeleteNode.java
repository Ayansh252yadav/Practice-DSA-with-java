package LinkedList26;

public class DeleteNode extends CreateLinkedList{
    public static void deleteNode(Node node){
        if(head.data==node.data){
            head=head.next;
            return;
        }
        if(head==null){
            return;
        }
        Node prev=head;
        Node curr=head.next;
        while(curr!=null){
            if(curr.data==node.data){
                prev.next=curr.next;
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            addFirst(arr[i]);
        }
        Node newNode=new Node(4);
        printList(head);
       deleteNode(newNode);
        System.out.println();
        System.out.println();
        printList(head);
    }
}
