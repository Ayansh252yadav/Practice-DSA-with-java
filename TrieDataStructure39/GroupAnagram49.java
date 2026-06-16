package TrieDataStructure39;

import java.util.*;

public class GroupAnagram49 {
    static class Node{
        Node []children=new Node[26];
        boolean eow=false;
        ArrayList<Integer>arr=new ArrayList<>();
    }
    public static Node root=new Node();
    public static void insert(String word,int idx){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int ix=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
        curr.arr.add(idx);
    }
    public static int add(String word){
        int sum=0;
        for(int i=0;i<word.length();i++){
            sum+=word.charAt(i)-'a';
        }
        return sum;
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

      List<List<String>>res=new ArrayList<>();
//  49
        return new ArrayList<>();
    }
}
