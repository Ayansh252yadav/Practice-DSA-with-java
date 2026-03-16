package BinaryTree32;

import java.util.ArrayList;

public class ConvertBStToBalancedBSt extends TreeTraversal{
    public static void getInorder(ArrayList<Integer>inOrder,Node root){
        if(root==null){
            return;
        }
        getInorder(inOrder,root.left);
        inOrder.add(root.data);
        getInorder(inOrder,root.right);
    }
    public static Node createBSt(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=st+(end-st)/2;
        Node root=new Node(inorder.get(mid));
        root.left=createBSt(inorder,st,mid-1);
        root.right=createBSt(inorder,mid+1,end);
        return root;
    }
    public static Node balancedBst(Node root){
        ArrayList<Integer>inorder=new ArrayList<>();
        getInorder(inorder,root);
        root=createBSt(inorder,0, inorder.size()-1);
        return root;
    }

    public static void main(String[] args) {

    }
}
