package BinaryTree32;

import java.util.ArrayList;

public class RootToLeafPaths extends PrintRangeBSt{
    public static ArrayList<ArrayList<Integer>> Paths(Node root,ArrayList<Integer>path,ArrayList<ArrayList<Integer>>res) {
        if(root==null){
            return res;
        }
       path.add(root.data);
        if(root.left==null &&root.right==null){
            res.add(new ArrayList<>(path));
        }
        Paths(root.left,path,res);
        Paths(root.right,path,res);
        path.remove(path.size()-1);
        return res;
    }

    public static void main(String[] args) {
        int []arr={8,5,3,6,10,11,14};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildBst(root,arr[i]);
        }
        System.out.println(Paths(root,new ArrayList<>(),new ArrayList<>()));
    }
}
