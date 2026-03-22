package BinaryTree32;

public class InsertIntoBinarySearchTree701 extends TreeTraversal{
    public static Node insertIntoBST(Node root, int val) {
       if(root==null){
           return new Node(val);
       }
       if(root.data<=val){
        root.right=insertIntoBST(root.right,val);

       }
        if(root.data>=val){
           root.left =insertIntoBST(root.left,val);
       }

       return root;
    }

    public static void main(String[] args) {
        int []arr={4,2,1,-1,-1,3,-1,-1,7,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        inOrder(insertIntoBST(root,5));
    }
}
