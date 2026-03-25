package BinaryTree32;

public class SymmetricBinaryTree extends PathSum {
public static boolean isSymmetric(Node root){
    if(root==null){
        return true;
    }
    return isMirror(root.left,root.right);
}
public static boolean isMirror(Node t1,Node t2){
    if(t1==null && t2==null){
        return true;
    }
    if(t1==null || t2==null){
        return false;
    }
    if(t1.data!=t2.data){
        return false;
    }
    boolean leftMirror=isMirror(t1.left,t2.right);
    boolean rightMirror=isMirror(t1.right,t2.left);
    return leftMirror && rightMirror;
}

    public static void main(String[] args) {

    }
}
