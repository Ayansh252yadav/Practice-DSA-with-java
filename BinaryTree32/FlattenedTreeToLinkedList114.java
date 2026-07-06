package BinaryTree32;

import java.util.ArrayList;
import java.util.List;

public class FlattenedTreeToLinkedList114 extends TreeTraversal{
    public static void getTreeVal(List<Node> arr, Node root){
        if(root==null){
            return;
        }
        arr.add(root);
        getTreeVal(arr,root.left);
        getTreeVal(arr,root.right);
    }
    public static void flatten(Node root) {
        if (root == null){
            return;
        }
        List<Node> list = new ArrayList<>();
        getTreeVal(list,root);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,-1,-1,4,-1,-1,5,-1,6,-1,-1};
        idx=-1;
        Node root=buildTree(arr);
       flatten(root);
    }
}
