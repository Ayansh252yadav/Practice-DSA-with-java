package LinkedList26;

public class RotateListRe61 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static int size(Node head){
        Node temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    public static Node head=null;
    public static Node rotate(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        Node last=temp.next;
        temp.next=null;
        last.next=head;
        return last;
    }
    public static Node rotateRight(Node head, int k) {
      if(head==null){
          return null;
      }
      int n=k%size(head);
     while (n!=0){
      head= rotate(head);
       n--;
     }
     return head;
    }
    public static void swap(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node temp=head;
        while(temp!=null &&temp.next!=null){
            int t=temp.data;
            temp.data=temp.next.data;
            temp.next.data=t;
            temp=temp.next.next;
        }
    }
    public static Node swapPairs(Node head) {
   if(head==null || head.next==null){
       return head;
   }
 swap(head);
   return head;
    }
   public static Node createList(Node head,int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return head;
        }
        newNode.next=head;
        head=newNode;
        return head;
   }
   public static void printList(Node head){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
       System.out.println("null");
   }
    public static void main(String[] args) {
        int []arr={1,2,3};
        for(int i=0;i<arr.length;i++){
           head= createList(head,arr[i]);
        }
        printList(head);
       head=swapPairs(head);
        printList(head);
    }
}
