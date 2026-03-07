package BinaryTree32;

public class MinimumDistanceBetweenNodesOfBT extends TreeTraversal{
    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis=lcaDist(root.left,n);
        int rightDIst=lcaDist(root.right,n);
        if(leftDis==-1 && rightDIst==-1){
            return -1;
        }
        else if(leftDis==-1){
            return rightDIst+1;
        }
        else  {
            return leftDis + 1;
        }
    }
    public static int minDist(Node root,int n1,int n2){
        int leftDis=lcaDist(root,n1);
        int rightDis=lcaDist(root,n2);
        return leftDis+rightDis;
    }

    public static void main(String[] args) {
        idx=-1;
        int []arr={1,2,-1,-1,3,-1,-1};
        Node root=buildTree(arr);
        System.out.println(minDist(root,2,3));
    }
}
