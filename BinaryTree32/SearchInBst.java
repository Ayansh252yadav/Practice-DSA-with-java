package BinaryTree32;

public class SearchInBst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
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
        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static Node search(Node root,int val){
            if(root==null){
                return null;
            }
            if(root.data==val){
                return root;
            }
            if(root.data>val){
               return search(root.left,val);
            }else{
                return search(root.right,val);
            }
        }

    public static void main(String[] args) {
        int []arr={4,2,7,1,3};
        Node root=null;
        for(int i=0;i<arr.length;i++){
          root=  buildBst(root,arr[i]);
        }
        preOrder(search(root,2));
    }
}
