package LinkedList26;

public class DeleteNode extends CreateLinkedList{
    public  void deleteNode(Node node){
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
        CreateLinkedList ls=new DeleteNode();
        DeleteNode Dd=new DeleteNode();
        for(int i=arr.length-1;i>=0;i--){
            ls.addFirst(arr[i]);
        }
        Node newNode=new Node(4);
        ls.printList(ls.head);
       Dd.deleteNode(newNode);
        System.out.println();
        System.out.println();
        ls.printList(ls.head);
    }
}
