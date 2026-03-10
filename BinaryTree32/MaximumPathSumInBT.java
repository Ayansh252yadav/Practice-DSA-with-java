package BinaryTree32;

public class MaximumPathSumInBT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        static int idx=-1;
        public static Node buildTree(int arr[]){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node newNode=new Node(arr[idx]);
            newNode.left=buildTree(arr);
            newNode.right=buildTree(arr);
            return newNode;
        }
        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        static int maxSum=0;
        public static int maxPath(Node root){
           maxSum=Integer.MIN_VALUE;
           helper(root);
           return maxSum;
        }
        public static int helper(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = Math.max(0, helper(root.left));
            int rightSum = Math.max(0, helper(root.right));

            int totalSum=leftSum+rightSum+root.data;
            maxSum=Math.max(maxSum,totalSum);
            return root.data+Math.max(leftSum,rightSum);
        }


    public static void main(String[] args) {
        int arr[]={1,2,-1,-1,3,-1,-1};
        Node root=buildTree(arr);
        System.out.println(maxPath(root));
    }
}
