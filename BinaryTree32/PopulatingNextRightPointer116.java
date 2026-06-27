package BinaryTree32;

public class PopulatingNextRightPointer116 {
    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
            this.next=null;
        }
    }
    static int idx=-1;
    public static Node createTree(int []node){
         idx++;
        if(node[idx]==-1){
        return null;
        }
        Node newNode=new Node(node[idx]);
        newNode.left=createTree(node);
        newNode.right=createTree(node);
        return newNode;
    }
    public static Node connect(Node root) {
        if(root==null){
            return null;
        }
    if(root.left != null) {
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.left.next;
        }
    }
    connect(root.left);
    connect(root.right);
    return root;
    }
}
