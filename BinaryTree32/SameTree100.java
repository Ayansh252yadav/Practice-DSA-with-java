package BinaryTree32;

public class SameTree100 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=-1;
    public static Node buildTree(int []arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node newNode=new Node(arr[idx]);
        newNode.left=buildTree(arr);
        newNode.right=buildTree(arr);
        return newNode;
    }
    public static boolean isSameTree(Node p, Node q) {
     if(p==null && q==null){
         return true;
     }
     if(p==null || q==null || p.data!=q.data){
         return false;
     }
     if(!isSameTree(p.left,q.left)){
         return false;
     }
     if(!isSameTree(p.right,q.right)){
         return false;
     }
     return true;
    }

    public static void main(String[] args) {
        int []arr={1,2,-1,-1,3,-1,-1};
        int []arr1={1,2,-1,-1,3,-1,-1};
        Node root=buildTree(arr);
        idx=-1;
        Node subroot=buildTree(arr1);
        System.out.println(isSameTree(root,subroot));
    }
}
