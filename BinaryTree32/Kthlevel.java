package BinaryTree32;

public class Kthlevel extends SameTree100 {
    public static int kthLevelSum(Node root,int level,int k){
        if(root==null){
            return 0;
        }
        if(level==k){
            return root.data;
        }
        return kthLevelSum(root.left,level+1,k)+kthLevelSum(root.right,level+1,k);
    }
    public static void kthLevel(Node root,int level,int k){
        if(root ==null){
            return ;
        }
        if(level==k){
            System.out.println(root.data);
            return;
        }
        kthLevel(root.left,level+1,k);
        kthLevel(root.right,level+1,k);
    }

    public static void main(String[] args) {
        idx=-1;
        int []arr={1,2,-1,-1,3,-1,-1};
        Node root=buildTree(arr);
//        kthLevel(root,0,1);
        System.out.println(kthLevelSum(root,0,1));
        String s = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";


    }
}
