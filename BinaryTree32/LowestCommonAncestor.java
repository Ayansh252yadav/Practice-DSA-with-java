package BinaryTree32;

import java.util.ArrayList;

public class LowestCommonAncestor extends TreeTraversal{
    public static Node lowestCommonAncestor(Node root, Node p, Node q){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        getPath(root,p,path1);
        for(int j=0;j<path1.size();j++){
            System.out.print(path1.get(j).data+" ");
        }
        System.out.println();
        getPath(root,q,path2);
        for(int j=0;j<path2.size();j++){
            System.out.print(path2.get(j).data+" ");
        }
        System.out.println();
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;
    }
    public static boolean getPath(Node root, Node n, ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n.data){
            return true;
        }
        boolean foundLeft=getPath(root.left,n,path);
        boolean foundRight=getPath(root.right,n,path);
        if(foundRight|| foundLeft){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    //optimized approach
    public static Node lowestAncestor(Node root,Node p,Node q){
        if(root==null){
            return null;
        }
        if(root.data==p.data || root.data==q.data){
            return root;
        }
        Node lcaLeft=lowestAncestor(root.left,p,q);
        Node lcaRight=lowestAncestor(root.right,p,q);
        if(lcaLeft==null){
            return lcaRight;
        }
        if(lcaRight==null){
            return lcaLeft;
        }
        return root;
    }

    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        idx=-1;
     Node root=buildTree(node);
     Node p=new Node(2);
     Node q=new Node(3);

//        System.out.println(lowestCommonAncestor(root,p,q).data);
        System.out.println(lowestAncestor(root,p,q).data);
    }
}
