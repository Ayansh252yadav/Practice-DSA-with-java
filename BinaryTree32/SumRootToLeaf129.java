package BinaryTree32;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf129 extends TreeTraversal{
    public static void helper(Node root, List<String>res,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.data);
        if(root.left==null && root.right==null){
            res.add(sb.toString());
        }
        helper(root.left,res,sb);
        helper(root.right,res,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public static int sumNumbers(Node root) {
        List<String>res=new ArrayList<>();

      helper(root,res,new StringBuilder());
      int sum=0;
        System.out.println(res);
      for (String e:res){
          sum+=Integer.parseInt(e);
      }
      return sum;
    }

    public static void main(String[] args) {
        int []arr={1,2,-1,-1,3,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        System.out.println(sumNumbers(root));
    }
}
