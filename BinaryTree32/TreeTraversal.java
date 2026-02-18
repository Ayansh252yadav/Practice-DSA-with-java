package BinaryTree32;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

        static int idx=-1;
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
        public static void preOrder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root){
         if(root==null){
             return;
         }
         inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
     public static void levelOrder(Node root){
            if(root==null){
                return;
            }
         Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();

                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
     }

//height of tree
    public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) {
     int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
     Node root=buildTree(node);
  /*
         1
        /  \
       2    3
      / \  / \
      4  5 6  7
         */
//     postOrder(root);
        levelOrder(root);
    }
}
