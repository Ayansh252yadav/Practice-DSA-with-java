package BinaryTree32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree extends DiameterOfBinaryTree {
    static class Info{
        Node node;
        int hd;
        Info(Node node ,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topView(Node root){
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,Node>map=new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while (!q.isEmpty()){
            Info currNode=q.remove();
                if(currNode==null){
                    if(q.isEmpty()){
                        break;
                    }else {
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(currNode.hd)){
                        map.put(currNode.hd,currNode.node);
                    }
                    if(currNode.node.left!=null){
                        q.add(new Info(currNode.node.left,currNode.hd-1));
                        min=Math.min(min, currNode.hd-1);
                    }
                    if(currNode.node.right!=null){
                        q.add(new Info(currNode.node.right, currNode.hd+1));
                        max=Math.max(max, currNode.hd+1);
                    }
                }
        }
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=min;i<=max;i++){
            System.out.println(map.get(i).data);
            res.add(map.get(i).data);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,-1,-1,3,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
        topView(root);
    }
}
