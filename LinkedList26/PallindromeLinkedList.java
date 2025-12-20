package LinkedList26;

import java.util.Stack;

public class PallindromeLinkedList extends CreateLinkedList{
    public static boolean isPallindrome(Node head){
        Node temp=head;
        Stack<Integer>st=new Stack<>();
        while (temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while (!st.isEmpty()){
            if(st.pop()!= temp.data){
                return false;
            }
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,2,1};
        for(int i=0;i<arr.length;i++){
            addFirst(arr[i]);
        }
        System.out.println(isPallindrome(head));
    }
}
