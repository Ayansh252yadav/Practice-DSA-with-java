package BinaryTree32;
import LinkedList26.*;

import java.util.ArrayList;

public class ConvertSortedListTOBST extends CreateLinkedList{
     class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public  TreeNode buildBST(ArrayList<Integer>arr,int st,int ei){
        if(st>ei){
            return null;
        }
        int mid=st+(ei-st)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=buildBST(arr,st,mid-1);
        root.right=buildBST(arr,mid+1,ei);
        return root;
    }
    public  void preOrder(TreeNode root){
         if(root==null){
             return;
         }
        System.out.print(root.data+" ");
         preOrder(root.left);
         preOrder(root.right);
    }
  public TreeNode createList(Node head){
         Node temp=head;
         ArrayList<Integer>arr=new ArrayList<>();
         while(temp!=null){
             arr.add(temp.data);
             temp=temp.next;
         }
        TreeNode root= buildBST(arr,0,arr.size()-1);
         return root;
  }
    public static void main(String[] args) {
        CreateLinkedList ls=new CreateLinkedList();
        ConvertSortedListTOBST bs=new ConvertSortedListTOBST();
        ls.head=null;
        ls.addFirst(9);
        ls.addFirst(5);
        ls.addFirst(0);
        ls.addFirst(-3);
        ls.addFirst(-10);
//        ls.printList(ls.head);
        TreeNode root=bs.createList(ls.head);
        bs.preOrder(root);
    }
}
