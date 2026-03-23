package BinaryTree32;

public class PathSum {
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
    public static boolean hasPathSum(Node root, int targetSum,int sum) {
        if(root==null){
            return false;
        }
        sum+=root.data;
        if(sum==targetSum && root.left==null && root.right==null){
            return true;
        }
        boolean left=hasPathSum(root.left, targetSum,sum);
        boolean right=hasPathSum(root.right,targetSum,sum);
        return left||right;
    }
    static int idx=-1;
    public static Node buildTree(int []arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node root=new Node(arr[idx]);
        root.left=buildTree(arr);
        root.right=buildTree(arr);
        return root;
    }
    public static void main(String[] args) {
        int arr[]={5,4,11,7,-1,-1,2,-1,-1,-1,8,13,-1,-1,4,-1,1,-1,-1};
        Node root=buildTree(arr);
        System.out.println(hasPathSum(root,22,0));
    }
}
