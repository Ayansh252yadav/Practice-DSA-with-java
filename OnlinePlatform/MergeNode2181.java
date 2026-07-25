package OnlinePlatform;

import java.util.ArrayList;

public class MergeNode2181 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           this.val = x;
        this.next = null;
        }
    }
   public static ListNode addLast(ListNode head,ListNode tail,int data) {
        ListNode newNode = new ListNode(data);
        if(head==null){
         head=tail=newNode;
         return head;
        }
      tail.next = newNode;
        return head;
   }
   static ListNode head1=null;
    static ListNode tail=null;
   public static void sum(ListNode head, ArrayList<Integer> list){
        int sum=0;
        ListNode temp=head.next;
        while(temp!=null){
            if(temp.val==0){
                list.add(sum);
                ListNode newNode=new ListNode(sum);
                if(head1==null){
                    head1=tail=newNode;
                }else{
                    tail.next=newNode;
                    tail = newNode;
                }
                sum=0;
            }else{
                sum+=temp.val;
            }
            temp=temp.next;
        }
   }
    public ListNode mergeNodes(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        sum(head,list);
        ListNode head1=null;
        ListNode tail=null;
        for(int i=0;i<list.size();i++){
            head1=addLast(head,tail,list.get(i));
        }
        return head1;
    }

}
