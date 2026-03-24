package BinaryTree32;

public class MaxSumPathinBinaryTree {
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
    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    private static int solve(Node root) {
        if (root == null) return 0;

        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        // update global max
        maxSum = Math.max(maxSum, left + right + root.data);

        // return one path
        // return one path
        return root.data + Math.max(left, right);
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
  int []arr={20,-10,-1,-1,20,-10,-1,-1,-50,-1,-1};
  idx=-1;
  Node root=buildTree(arr);
        System.out.println(maxPathSum(root));
    }
}
