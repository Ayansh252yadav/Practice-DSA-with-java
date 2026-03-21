package BinaryTree32;

public class ClosestInBST extends TreeTraversal {
    static int min_diff=Integer.MAX_VALUE;

    public static void closest(Node root,int key){
        if(root==null){
            return;
        }

        if(min_diff>Math.abs(key-root.data)){
            min_diff=Math.abs(key-root.data);
        }
        if(root.data==key){
            min_diff=0;
            return;
        }
        if(key<root.data){
            closest(root.left,key);
        }
        if(key> root.data){
            closest(root.right,key);
        }
    }

    public static void main(String[] args) {
        idx=0;
        int []arr={10,2,1,-1,-1,5,3,-1,4,-1,-1,6,-1,-1,11,-1,-1};
        Node root=null;
                root=buildTree(arr);
        min_diff = Integer.MAX_VALUE;
        closest(root,13);
        System.out.println(min_diff);
    }
}
