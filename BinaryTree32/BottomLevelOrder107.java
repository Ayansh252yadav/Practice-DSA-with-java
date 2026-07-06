package BinaryTree32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomLevelOrder107 extends TreeTraversal {
    public void bfs(Node root,List<List<Integer>>res){
        if(root==null){
            return;
        }
       List<Integer>temp=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                res.add(temp);
                temp=new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                temp.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public List<List<Integer>> levelOrderBottom(Node root) {
   List<List<Integer>>res=new ArrayList<>();
   bfs(root,res);
   return res.reversed();
    }

    public static void main(String[] args) {
        int []arr={3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        BottomLevelOrder107 bs=new BottomLevelOrder107();
        System.out.println(bs.levelOrderBottom(root));
    }
}
