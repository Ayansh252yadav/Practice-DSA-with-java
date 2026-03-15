package BinaryTree32;

public class ValidateBST extends PrintRangeBSt{
    public static boolean isValidBST(Node root,Node min,Node max) {
      if(root==null){
          return true;
      }
      else if(min!=null && root.data<=min.data){
          return false;
      }else if(max!=null  && root.data>=max.data){
          return false;
      }
      boolean isLeft=isValidBST(root.left,min,root);
      boolean isRight=isValidBST(root.right,root,max);
     return isLeft && isRight;
    }

    public static void main(String[] args) {
        Node root=new Node(2);

        root.left = new Node(1);
        root.right = new Node(3);

//        root.right.left = new Node(3);
//        root.right.right = new Node(6);
        System.out.println(isValidBST(root,null,null));
    }
}
