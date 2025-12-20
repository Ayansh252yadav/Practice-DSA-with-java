package LinkedList26;

public class PallindromeLinkedListSlowFastApproch extends CreateLinkedList {
    //in this approch first find mid
    public static Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
        return slow;
    }
    public static boolean isPalilindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode=findMid(head);
        // then step-2 reverse the list from mid;
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node temp=prev;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        //check left and right data
//        as we know that prev point to the reverse list of head;
      Node right=prev;
        Node left=head;
        while (right!=null){
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,2,1};
        for(int i=0;i<arr.length;i++){
            addFirst(arr[i]);
        }
//        System.out.println(isPalilindrome(head));
        practice pc=new practice();
        System.out.println(pc.isPallindrome(head));
    }
}
class practice extends CreateLinkedList{
    public static Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static boolean isPallindrome(Node head){
        if(head==null|| head.next==null){
            return false;
        }
        Node midNode=findMid(head);
       Node prev=null;
       Node curr=midNode;
       Node next;
       while (curr!=null){
           next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
       }
       Node left=head;
       Node right=prev;
       while (right!=null){
           if(right.data!=left.data){
               return false;
           }
           right=right.next;
           left=left.next;
       }
       return true;
    }
}
