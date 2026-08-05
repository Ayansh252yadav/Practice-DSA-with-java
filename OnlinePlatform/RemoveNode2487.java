package OnlinePlatform;

public class RemoveNode2487 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }
    public boolean addNode(ListNode head,int val){
        ListNode temp=head;
        while(temp!=null){
            if(val<temp.val){
                return true;
            }
            temp=temp.next;
        }
        return  false;
    }

    ListNode head1=null;
    ListNode tail=null;
    public void createNewList(ListNode node){
        if(head1==null){
            head1=node;
            tail=node;
            return;
        }
        tail.next=node;
        tail=node;
        tail.next=null;
        return;
    }
    public ListNode removeNodes(ListNode head) {
      ListNode curr=head;
      ListNode prev=null;
      ListNode next=null;
      while(curr!=null){
          if(!addNode(curr, curr.val)){
            createNewList(curr);
          }
          curr = curr.next;
      }
      return head1;
    }
    //optimized
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode removeNodes1(ListNode head) {
    head= reverse(head);
     int max=Integer.MIN_VALUE;
     ListNode currList=null;
     ListNode tail=null;
     while(head!=null){
         if(head.val>max){
             max=head.val;
             if(currList==null){
                 currList=tail=new ListNode(max);
             }else{
                 tail.next=new ListNode(max);
                 tail=tail.next;
                 tail.next=null;
             }
         }
         head=head.next;
     }
     return reverse(currList);
    }
}
