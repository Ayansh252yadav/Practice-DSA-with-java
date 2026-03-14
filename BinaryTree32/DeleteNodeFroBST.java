package BinaryTree32;

public class DeleteNodeFroBST extends SearchInBst{
    public static Node deletNode(Node root,int key){
        if(root == null){
            return null;
        }
        if(root.data<key){
           root.right= deletNode(root.right,key);
        }else if (root.data>key){
            root.left=deletNode(root.left,key);
        }else{
            //case 1 no child
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2 one child
            else if(root.left==null){
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }
            //case 3 for two children
            Node inSuc=findInorder(root.right);
            root.data=inSuc.data;
            root.right=deletNode(root.right,inSuc.data);
        }
        return root;
    }
    public static Node findInorder(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int []arr={5,3,6,2,4,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildBst(root,arr[i]);
        }
        preOrder(root);
        deletNode(root,3);
        System.out.println();
        preOrder(root);
    }
}
