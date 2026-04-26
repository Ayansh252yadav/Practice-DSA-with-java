package OnlinePlatform;

import java.util.ArrayList;

public class ReorderList143 {
    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    static Node head=null;
    public static Node insertLast(Node head,int data){
        Node newNode=new Node(data);
        if(head==null){
           return newNode;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    public static void reorderList(Node head) {
        ArrayList<Integer>arr=new ArrayList<>();
        Node temp=head;
       while (temp!=null){
           arr.add(temp.val);
           temp=temp.next;
       }
       int st=0;
       int end=arr.size()-1;
       int []res=new int[arr.size()];
       int k=0;
       while(st<=end){
           if(st==end){
               res[k++]=arr.get(st);
           }else{
               res[k++]=arr.get(st);
               res[k++]=arr.get(end);
           }
          st++;
           end--;
       }
       temp=head;
       int i=0;
       while (temp!=null){
           temp.val=res[i++];
           temp=temp.next;
       }
    }
  public static void printList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
      System.out.println();
  }
    public static void main(String[] args) {
        int []arr={1,2,3,4};
        for(int i=0;i<arr.length;i++){
            head=insertLast(head,arr[i]);
        }
        printList();
        reorderList(head);
        printList();
    }
}
