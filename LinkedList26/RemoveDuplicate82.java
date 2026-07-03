package LinkedList26;

import java.util.List;

public class RemoveDuplicate82 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        while (curr != null) {
            boolean flag=false;
            while (curr.next!=null && curr.val == curr.next.val) {
                curr = curr.next;
                flag=true;
            }
            if(flag){
                prev.next=curr.next;
                curr=curr.next;
            }
           else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    public static ListNode addAtStart(ListNode head,int data){
        ListNode newNode=new ListNode(data);
        if(head==null){
            head=newNode;
            return head;
        }
        newNode.next=head;
        head=newNode;
        return head;
    }
    public static void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode root=null;
     int []arr={1,2,3,3,4,4,5};
     for(int i=arr.length-1;i>=0;i--){
        root= addAtStart(root,arr[i]);
     }
     deleteDuplicates(root);
     print(root);
    }
}
