package LinkedList26;

import static java.lang.Integer.valueOf;

public class OddEvenLinkedList extends CreateLinkedList {
    public static Node Insert(Node list, int data) {
        Node newNode = new Node(data);
        if (list == null) {
            list = newNode;
            return list;
        }
        Node temp = list;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return list;
    }

    Node list = null;

    public Node oddEvenList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        int check = head.data % 2;
        while (temp != null) {
            if (temp.data % 2 == check) {
               list= Insert(list, temp.data);
            }
            temp = temp.next;
        }
        if(check==1){
            check=0;
        }else if(check==0){
            check=1;
        }
        temp=head;
        while(temp!=null){
            if(temp.data%2==check){
               list= Insert(list,temp.data);
            }
            temp=temp.next;
        }
        return list;
    }
   public  Node oddEvenIndicesList(Node head){
        if(head==null){
            return null;
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(count%2==0){
                list=Insert(list,temp.data);
            }
            count++;
            temp=temp.next;
        }
        count=0;
        temp=head;
       while(temp!=null){
           if(count%2==1){
               list=Insert(list,temp.data);
           }
           count++;
           temp=temp.next;
       }
       return list;
   }
    public static void main(String[] args) {
int a=100;int b=100;
        System.out.println(a==b);
        a=200;
        b=200;
        System.out.println(a==b);
        Integer f =valueOf(500);
        Integer g=valueOf(500);
        System.out.println(f==g);
    }
}
