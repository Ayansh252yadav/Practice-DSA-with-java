package BinaryTree32;

public class SmallestStrigStartedFromLeaf extends TreeTraversal {

   static String ans="~";
    public static  void smallestFromLeaf(Node root,String path) {
     if(root==null){
         return;
     }
     char ch=(char)('a'+ root.data);
     path=ch+path;
     if(root.left==null && root.right==null){
      if(ans.compareTo(path)>=0){
          ans=path;
      }
     }
     smallestFromLeaf(root.left,path);
     smallestFromLeaf(root.right,path);
    }
    public static void main(String[] args) {
        int []arr={0,1,2,-1,-1,3,-1,-1,4,3,-1,-1,4,-1,-1};

        Node root=buildTree(arr);
        smallestFromLeaf(root,"");
        System.out.println(ans);
    }
}
