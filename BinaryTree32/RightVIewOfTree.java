package BinaryTree32;

import java.util.*;

public class RightVIewOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=-1;
    public static Node bulidtree(int arr[]){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node newNode=new Node(arr[idx]);
        newNode.left=bulidtree(arr);
        newNode.right=bulidtree(arr);
        return newNode;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    static class Info{
        Node node;
        int hd;
        Info(Node node ,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static List<Integer> rightView(Node root){
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,Node>map=new HashMap<>();
        q.add(new Info(root,0));
        q.add(null);
        int max=0;
        int min=0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min=Math.min(curr.hd-1, min);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(map.containsKey(i)&& map.containsKey(-i) && i!=0){
                map.remove(-i);
            }  if(map.get(i) != null){
                list.add(map.get(i).data);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int arr[]={1,2,4,5,-1,-1,-1,-1,3,-1,-1};
        Node root=bulidtree(arr);
        System.out.println(rightView(root));
    }
}
