package TrieDataStructure39;

public class LongestCommonSuffixQuery3093 {
    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int index;
    }
    public static Node root=new Node();
    public static void insert(String word,int index){
        Node curr=root;
        for(int i=0;i<word.length();i++){
           int idx=word.charAt(i)-'a';
           if(curr.children[idx]==null){
               curr.children[idx]=new Node();
           }

            if(curr.index == -1){
                curr.index = index;
            }
           curr=curr.children[idx];

        }
        curr.eow=true;
    }
    public static void helper(String s){
        Node curr=root;
        String temp="";
        for(int i=0;i<26;i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null) {
                temp += (char) (i + 'a');
            }
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
 return new int[]{};
    }
}
