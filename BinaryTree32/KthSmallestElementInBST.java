package BinaryTree32;

public class KthSmallestElementInBST extends TreeTraversal {
    static int count=0;
    public static Node kthSmallest(Node root, int k) {
        if(root==null){
            return null;
        }
        Node left=kthSmallest(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return root;
        }
        return kthSmallest(root.right,k);
    }

    public static void main(String[] args) {
        int []arr={3,1,-1,2,-1,-1,4,-1,-1};
        Node root=buildTree(arr);
        kthSmallest(root,1);
        System.out.println(count);
    }
}
