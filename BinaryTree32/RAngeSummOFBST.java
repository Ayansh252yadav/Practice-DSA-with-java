package BinaryTree32;

public class RAngeSummOFBST extends TreeTraversal {
    static int sum=0;
    public static int rangeSumBST(Node root, int low, int high) {
     if(root==null){
         return 0;
     }
     if(root.data>=low && root.data<=high){
         sum+=root.data;
     }
     rangeSumBST(root.left,low,high);
     rangeSumBST(root.right,low,high);
     return sum;
    }

    public static void main(String[] args) {
        sum=0;
        int arr[]={10,5,3,-1,-1,7,-1,-1,15,-1,18,-1,-1};
        Node root=buildTree(arr);
        System.out.println(rangeSumBST(root,7,15));
    }
}
