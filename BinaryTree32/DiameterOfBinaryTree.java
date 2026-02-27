package BinaryTree32;

public class DiameterOfBinaryTree {
    //
    public static class Node{
      public   int data;
       public Node left;
       public Node right;
       public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int idx=-1;
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
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    //543 leetcode
    public static int diameterOfTree(Node root){
        if(root==null){
            return 0;
        }
        int leftDiameter=diameterOfTree(root.left);
        int lh=height(root.left);
        int rightDiameter=diameterOfTree(root.right);
        int rh=height(root.right);
        int selfDiameter=lh+rh+1;
        return Math.max(Math.max(leftDiameter,rightDiameter),selfDiameter);
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

// optimize approach
    static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.ht=ht;
            this.diam=diam;
        }
}
public static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diameter(root.left);
        Info rightInfo=diameter(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);
}
    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=buildTree(node);
//        System.out.println(diameterOfTree(root));
        System.out.println(diameter(root).ht);
        System.out.println(diameter(root).diam);
    }
}

