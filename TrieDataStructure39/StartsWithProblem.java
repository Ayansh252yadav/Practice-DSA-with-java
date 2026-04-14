package TrieDataStructure39;

public class StartsWithProblem {
    static class Node{
        Node []children=new Node[26];
        boolean eow=false;
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr= curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean startWith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String []arr={"apple","app","mango","man","woman"};
        for(String s:arr){
            insert(s);
        }
        System.out.println(startWith("moon"));
    }
}
