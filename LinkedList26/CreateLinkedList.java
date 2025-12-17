package LinkedList26;
//import java.util.LinkedList;
public class CreateLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    static int size;
   //print linked list
    public static void printList(Node head){
        Node temp=head;
        if(head==null){
            System.out.println("Linked list is empty first please add some element");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
  ///add first in liked list
  public static void addFirst(int data){
      Node newNode=new Node(data);
      size++;
      if(head==null){
          head=tail=newNode;
          return;
      }
      newNode.next=head;
      head=newNode;
  }
  //add element at the last of the linked list
    public static void addLast(int data){
      Node newNode=new Node(data);
      size++;
      if(head==null){
          head=tail=newNode;
          return;
      }
     tail.next=newNode;
      tail=newNode;
    }
    //add  int the middle of the Linked List
    public static void addMiddle(int data){
      Node temp=head;
      int i=1;
      while(i<size/2){
          temp=temp.next;
          i++;
      }
      Node newNode=new Node(data);
      size++;
      newNode.next=temp.next;
      temp.next=newNode;
    }
    //remove first element in LinkedList
    public static void removeFirst(){
      if(head==null){
          System.out.println("your List is empty");
          return;
      }
      head=head.next;
      size--;
    }
    //remove last element from the List
    public static void removeLast(){
      Node temp=head;
      int i=0;
    if(size==0){
        System.out.println("your List is empty");
        return;
    }
    else if(size==1){
          head=tail=null;
      }else{
          while(temp.next.next!=null){
              temp=temp.next;
          }
          temp.next=null;
          tail=temp;
      }
      size--;
    }
    //remove specified indexof list element
    public static void removeIndexOf(int index){
      if(head==null){
          System.out.println("List is Empty");
          return;
      }
      else if(index!=size){
          Node temp=head;
          int i=1;
          while (i<index-1){
              temp=temp.next;
              i++;
          }
          temp.next=temp.next.next;
          size--;
      }else if(index==size){
          Node temp=head;
          while(temp.next.next!=null){
              temp=temp.next;
          }
          temp.next=null;
          tail=temp;
          size--;
      }
//        System.out.println(size);
    }
    public static void main(String[] args) {
        addLast(5);
        addFirst(4);
//        addFirst(3);
        addFirst(2);
        addFirst(1);
        addMiddle(3);
        addMiddle(6);
        addMiddle(7);
        removeFirst();
        removeLast();
        removeIndexOf(5);
        System.out.println(size);
        System.out.println(tail.data);
        System.out.println(head.data);
        printList(head);
    }
}
