package BinaryTree32;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDiffrence530 extends TreeTraversal{
    static int min=Integer.MAX_VALUE;
    List<Integer> res=new ArrayList<>();
    public void util(Node root){
        if(root==null){
            return ;
        }
        util(root.left);
        res.add(root.data);
        util(root.right);
    }
    public  int getMinimumDifference(Node root) {
        util(root);
     for(int i=0;i<res.size()-1;i++){
         min=Math.min(min, Math.abs(res.get(i)-res.get(i+1)));
     }
     return min;
    }

    public static void main(String[] args) {
        int []arr={4,2,1,-1,-1,3,-1,-1,6,-1,-1};
        Node root=buildTree(arr);
        MinimumAbsoluteDiffrence530 mn=new MinimumAbsoluteDiffrence530();
        System.out.println(mn.getMinimumDifference(root));
        System.out.println(mn.res);
    }
}
