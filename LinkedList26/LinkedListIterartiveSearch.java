package LinkedList26;

public class LinkedListIterartiveSearch extends CreateLinkedList{
    public static boolean iterativeSearch(Node head,int data){
        Node temp=head;
        if(head==null){
            System.out.println("List is empty");
            return false;
        }
        while(temp!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
   public static boolean recursiveSearch(Node head,Node temp,int data){
       if(head==null){
           System.out.println("List is empty");
           return false;
       }
       if(temp==null){
           return false;
       }
       if(temp.data!=data){
           return recursiveSearch(head,temp.next,data);
       }
       return true;
   }
    public static void main(String[] args) {
        CreateLinkedList ls=new CreateLinkedList();
        int arr[] = {1, 2, 3, 4, 5};
        for(int i=arr.length-1;i>=0;i--){
            ls.addFirst(arr[i]);
        }
        ls.printList(ls.head);
        System.out.println();
        System.out.println(iterativeSearch(ls.head,6));
        System.out.println(recursiveSearch(ls.head,ls.head,1));
    }
}
