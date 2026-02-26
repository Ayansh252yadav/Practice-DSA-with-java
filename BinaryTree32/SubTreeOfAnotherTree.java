package BinaryTree32;

public class SubTreeOfAnotherTree extends DiameterOfBinaryTree{
    public static boolean isSubtree(Node root,Node subroot){
        if(root==null){
            return false;
        }
        if (subroot == null) return true;
        if(root.data==subroot.data){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        boolean leftAns=isSubtree(root.left,subroot);
        boolean rightAns=isSubtree(root.right,subroot);
        return  leftAns|| rightAns;
    }
    public  static boolean isIdentical(Node root,Node subroot){
        if(root==null && subroot==null){
            return true;
        } else if (root==null || subroot==null || subroot.data!=root.data) {
            return false;
        }
        if(!isIdentical(root.left,subroot.left)){
            return false;
        }
        if(!isIdentical(root.right,subroot.right)){
            return false;
        }
        return true;
    }
    static int idx =-1;
    public static Node buildTree(int node[]){
        idx++;
        if(node[idx]==-1){
            return null;
        }
        Node newNode=new Node(node[idx]);
        newNode.left=buildTree(node);
        newNode.right=buildTree(node);
        return newNode;
    }
    public static void main(String[] args) {
        int arr[]={3,4,1,-1,-1,2,-1,0,-1,-1,5,-1,-1};
        int arr2[]={4,1,-1,-1,2,-1,-1};
        idx=-1;
        Node root =buildTree(arr);
        idx=-1;
        Node subRoot=buildTree(arr2);
//        preOrder(root);
        System.out.println(isSubtree(root,subRoot));
    }
}
