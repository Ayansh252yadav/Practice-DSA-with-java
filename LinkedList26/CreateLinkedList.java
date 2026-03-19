package LinkedList26;
//import java.util.LinkedList;
public class CreateLinkedList {
   public static class Node{
       public int data;
      public   Node next;
       public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  Node head;
    public Node tail;
    static int size;
   //print linked list
    public  void printList(Node head){
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
  public  void addFirst(int data){
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
    public  void addLast(int data){
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
    public  void addMiddle(int data){
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
    public  void removeFirst(){
      if(head==null){
          System.out.println("your List is empty");
          return;
      }
      head=head.next;
      size--;
    }
    //remove last element from the List
    public  void removeLast(){
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
    public  void removeIndexOf(int index){
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
      CreateLinkedList ls=new CreateLinkedList();
        ls.addLast(5);
        ls.addFirst(4);
//        addFirst(3);
        ls.addFirst(2);
        ls.addFirst(1);
        ls.addMiddle(3);
        ls.addMiddle(6);
        ls.addMiddle(7);
        ls.removeFirst();
        ls.removeLast();
        ls.removeIndexOf(5);
        System.out.println(size);
        System.out.println(ls.tail.data);
        System.out.println(ls.head.data);
        ls.printList(ls.head);
    }
}
