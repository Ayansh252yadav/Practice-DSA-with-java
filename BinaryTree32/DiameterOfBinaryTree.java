package BinaryTree32;

public class DiameterOfBinaryTree {
    //
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
    public static Node buildTree(int node[]){
        idx++;
        if(node[idx]==-1){
            return null;
        }
        Node newNode=new Node(node[idx]);
        newNode.left=buildTree(node);
        newNode.right=buildTree(node);
        return newNode;
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    //543 leetcode
    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        int leftDiameter=diameterOfTree(root.left);
        int lh=height(root.left);
        int rightDiameter=diameterOfTree(root.right);
        int rh=height(root.right);
        int selfDiameter=lh+rh+1;
        return Math.max(Math.max(leftDiameter,rightDiameter),selfDiameter);
    }

    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=buildTree(node);
        System.out.println(diameterOfTree(root));
    }
}
