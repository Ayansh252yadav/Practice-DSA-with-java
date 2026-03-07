package BinaryTree32;

public class TransformToSuTree extends TreeTraversal{
    public static int transformTree(Node root){
        if(root==null){
            return 0;
        }
        int leftChild=transformTree(root.left);
        int rightChild=transformTree(root.right);
        int data=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;
        root.data=newLeft+newRight+leftChild+rightChild;
        return data;
    }

    public static void main(String[] args) {
        int []arr={1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        transformTree(root);
        preOrder(root);
    }
}
