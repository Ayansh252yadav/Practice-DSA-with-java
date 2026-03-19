package OnlinePlatform;
import LinkedList26.CreateLinkedList;

public class MergeSortedList extends CreateLinkedList {
    public static CreateLinkedList.Node mergeList(CreateLinkedList.Node head1,CreateLinkedList.Node head2){
        CreateLinkedList.Node dummy=new CreateLinkedList.Node(-1);
        CreateLinkedList.Node tail=dummy;
        while (head1!=null && head2!=null){
            if(head1.data<=head2.data){
                tail.next=head1;
                head1=head1.next;
            }else{
                tail.next=head2;
                head2=head2.next;
            }
            tail=tail.next;
        }
        if(head1!=null){
            tail.next=head1;
        }
        if(head2!=null){
            tail.next=head2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
  CreateLinkedList list1=new CreateLinkedList();
  CreateLinkedList list2=new CreateLinkedList();
        // List 1
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        // List 2
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        CreateLinkedList.Node merge=mergeList(list1.head,list2.head);

        // Print merged list
        CreateLinkedList result = new CreateLinkedList();
        result.head = merge;
        result.printList(result.head);
    }
}
