package LinkedList26;

public class MergeSortedList{
 static class Node{
     int data;
     Node next;
     Node(int data){
         this.data=data;
         this.next=null;
     }
 }
     Node head;
     Node tail;

    public static Node SortList(Node head){
        if(head==null){
            return null;
        }
        Node temp;

        temp=head;
      Node curr;
       while(temp!=null){
           curr=head;
           while (curr!=null){
               if(temp.data<curr.data){
                   int t=temp.data;
                   temp.data=curr.data;
                   curr.data=t;
               }
               curr= curr.next;
           }

           temp=temp.next;
       }
       return head;
    }
public static Node Merge(Node head1,Node head2){
    if (head1 == null) return head2;
    if (head2 == null) return head1;
    Node temp=head1;
   while (temp.next!=null){
       temp=temp.next;
   }
   temp.next=head2;

   return SortList(head1);
}
public  void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
}
public static void printList(Node head){
        if(head==null){
            return;
        }
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    System.out.print("null");
}
    public static void main(String[] args) {
  MergeSortedList list1=new MergeSortedList();
  MergeSortedList list2=new MergeSortedList();
        int arr[]  = {3,4,2,5};
        int arr2[] = {1,3,4};

        for (int x : arr) {
            list1.addLast(x);
        }

        for (int x : arr2) {
            list2.addLast(x);
        }
        Node mergedHead = Merge(list1.head, list2.head);
        printList(mergedHead);
    }
}
