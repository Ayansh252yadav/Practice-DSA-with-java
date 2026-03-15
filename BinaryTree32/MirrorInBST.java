package BinaryTree32;

public class MirrorInBST extends PrintRangeBSt {
    static Node  mirror(Node root) {
        // code here
     if(root==null){
         return null;
     }
     Node leftMirror=mirror(root.left);
     Node rightMirror=mirror(root.right);
     root.left=rightMirror;
     root.right=leftMirror;
     return root;
    }

    public static void main(String[] args) {
        int []arr={5,3,6,2,4,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildBst(root,arr[i]);
        }
        postOrder(root);
        System.out.println();
        mirror(root);
        postOrder(root);
    }
}
