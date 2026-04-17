package BinaryTree32;

public class SumOfLeftLeaves404 extends TreeTraversal{

    public int sumOfLeftLeaves(Node root) {
     if(root==null){
         return 0;
     }
        int sum=0;
     if(root.left!=null && root.left.left==null && root.left.right==null){
         sum+=root.left.data;
     }else{
         sum+=sumOfLeftLeaves(root.left);
     }
     sum+=sumOfLeftLeaves(root.right);
     return sum;
    }

    public static void main(String[] args) {
        int []arr={3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        SumOfLeftLeaves404 sl=new SumOfLeftLeaves404();
        Node root=buildTree(arr);
        System.out.println(sl.sumOfLeftLeaves(root));
    }
}
