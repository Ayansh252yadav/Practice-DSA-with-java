package BinaryTree32;

public class InvertBinaryTree extends TreeTraversal{
    public static Node invertTree(Node root) {
      if(root==null){
          return root;
      }
      Node leftChild=invertTree(root.left);
      Node rightChild=invertTree(root.right);
      root.left=rightChild;
      root.right=leftChild;
      return root;
    }

    public static void main(String[] args) {
        int arr []={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        invertTree(root);
        preOrder(root);
    }
}
