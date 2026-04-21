package BinaryTree32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels637 extends TreeTraversal  {
    public List<Double>  bfs(Node root){
        if(root==null){
            return null;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Double>temp=new ArrayList<>();
        double sumLevel=0;
        double levelNode=0;
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null) {
                temp.add(sumLevel/levelNode);
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }else{
                sumLevel+=curr.data;
                levelNode++;
                if(curr.left!=null){
                    q.add(curr.left);
                }else{
                    q.add(curr.right);
                }
            }
        }
        return temp;
    }
    public List<Double> averageOfLevels(Node root) {
    List<Double>ans=bfs(root);
    return ans;
    }
}
