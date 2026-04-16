package BinaryTree32;

public class BooleanBinaryTree2331 extends TreeTraversal{

    public static boolean evaluateTree(Node root) {
     if(root.data==0){
         return false;
     }
     if(root.data==1){
         return true;
     }
    if(root.data==2){
        return evaluateTree(root.left) || evaluateTree(root.right);
    }
     return evaluateTree(root.left) && evaluateTree(root.right);
    }

    public static void main(String[] args) {
        int [] bool={2,1,-1,-1,3,0,-1,-1,1,-1,-1};
        Node root=buildTree(bool);
        System.out.println(evaluateTree(root));
    }
}
