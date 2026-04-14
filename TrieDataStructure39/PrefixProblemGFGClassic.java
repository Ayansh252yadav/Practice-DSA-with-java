package TrieDataStructure39;

import java.util.Arrays;

public class PrefixProblemGFGClassic {
    static class Node{
        Node[]children=new Node[26];
        boolean eow=false;
        int freq=1;
    }
    public Node root=new Node();
    public  void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public  String findPrefix(String word){
        Node curr=root;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            curr=curr.children[idx];
            ans.append((char)(idx+'a'));
            if(curr.freq==1){
                break;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        PrefixProblemGFGClassic pf=new PrefixProblemGFGClassic();
        String []arr = {"zebra", "dog", "duck", "dove"};
        for(int i=0;i<arr.length;i++){
            pf.insert(arr[i]);
        }
        String []result=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]= pf.findPrefix(arr[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
