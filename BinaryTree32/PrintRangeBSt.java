package BinaryTree32;

public class PrintRangeBSt {
     static class  Node{
         int data;
         Node left;
         Node right;
         Node(int data){
             this.data=data;
             this.left=null;
             this.right=null;
         }
     }
     public static Node buildBst(Node root,int data){
         if(root==null){
             root=new Node(data);
             return root;
         }
         if(root.data>data){
             root.left=buildBst(root.left,data);
         }else{
             root.right=buildBst(root.right,data);
         }
         return root;
     }
     public static void postOrder(Node root){
         if(root==null){
             return;
         }
         postOrder(root.left);
         postOrder(root.right);
         System.out.print(root.data+" ");
     }
    public static void rangeBst(Node root,int k1,int k2){
         if(root==null){
             return;
         }
         if(root.data>=k1 && root.data<=k2){
             rangeBst(root.left,k1,k2);
             System.out.print(root.data+" ");
             rangeBst(root.right,k1,k2);
         } else if(root.data < k1){
             rangeBst(root.right,k1,k2);
         }
         else{
             rangeBst(root.left,k1,k2);
         }
    }

    public static void main(String[] args) {
        int []arr={5,3,6,2,4,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildBst(root,arr[i]);
        }
        postOrder(root);
        System.out.println();
        rangeBst(root,2,7);
    }
}
