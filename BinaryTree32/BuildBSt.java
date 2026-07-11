package BinaryTree32;

public class BuildBSt extends TreeTraversal{
    public static Node buildBst(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=buildBst(root.left,val);
        }else{
            root.right=buildBst(root.right,val);
        }
        return root;
    }

    public static void main(String[] args) {
        int []values={5,1,4,3,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=buildBst(root,values[i]);
        }
        postOrder(root);
    }

}
