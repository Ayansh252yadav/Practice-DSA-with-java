package BinaryTree32;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreOrderTraversal589 {
    static class Node{
        int val;
        List<Node>children;
        public Node(int val) {
            this.val=val;
            this.children=new ArrayList<>();
        }

    }
    Node root=null;
    List<Integer> res=new ArrayList<>();
    public  void preOrder(Node root){
        if(root==null){
            return;
        }
        res.add(root.val);
        for(Node child:root.children){
            preOrder(child);
        }
    }
}
