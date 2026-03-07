package BinaryTree32;

public class KthAncestorOfNode extends TreeTraversal{
    public static int kthAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis=kthAncestor(root.left,n,k);
        int rightDis=kthAncestor(root.right,n,k);
        if(leftDis==-1 && rightDis==-1){
            return -1;
        }
        int max=Math.max(leftDis,rightDis);
        if(max+1==k){
            System.out.println(root.data);;
        }
        return max+1;
    }

    public static void main(String[] args) {
        int []arr={1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        System.out.println(kthAncestor(root,4,2));
    }
}
