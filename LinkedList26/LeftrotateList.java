package LinkedList26;

public class LeftrotateList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    static Node tail;
    public static void addLast(int data){
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
        System.out.println("null");
    }
    public static Node leftRotate(Node head,int k){
        if(head==null || head.next==null || k==0){
            return head;
        }
        Node temp=head;
        int size=1;
        while(temp.next!=null){
            temp=temp.next;
            size++;
        }
        if(k%size==0){
            return head;
        }
        Node tail=temp;
        tail.next=head;
        Node newTail=head;
        for(int i=1;i<k;i++){
            newTail=newTail.next;
        }
        head=newTail.next;
        newTail.next=null;

        return head;
    }

    public static void main(String[] args) {

        int arr[]={10 ,20, 30, 40,50};
        for(int i=0;i<arr.length;i++){
            addLast(arr[i]);
        }
        printList(head);
        System.out.println();
        head= leftRotate(head,4);
        printList(head);
    }
}
