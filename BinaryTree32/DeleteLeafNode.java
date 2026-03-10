package BinaryTree32;

public class DeleteLeafNode extends TreeTraversal{
    public static Node deleteLeafNode(Node root,int x){
        if(root==null){
            return null;
        }
        root.left=deleteLeafNode(root.left,x);
        root.right=deleteLeafNode(root.right,x);
        if(root.data==x && root.left==null &&root.right==null){
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[]={1,3,3,-1,-1,2,-1,-1,3,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        deleteLeafNode(root,3);
        preOrder(root);
    }
}
