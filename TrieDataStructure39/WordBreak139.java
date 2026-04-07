package TrieDataStructure39;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
    class Node{
        Node []children=new Node[26];
        boolean eow=false;
    }
    Node root=new Node();
    public void insert(String word){
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
    public boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
    if(s.isEmpty()){
        return true;
    }
    for(int i=1;i<=s.length();i++){
        if(search(s.substring(0,i)) && wordBreak(s.substring(i),wordDict)){
            return true;
        }
    }
    return false;
    }
    public static void main(String[] args) {
        WordBreak139 wb=new WordBreak139();
        String [] dict={"leet","code"};
        String s="leetcode";
        for(int i=0;i<dict.length;i++){
            wb.insert(dict[i]);
        }
        System.out.println(wb.wordBreak(s,new ArrayList<>()));
    }
}
//time limit exceeded
class WordBreak {
    class Node{
        Node [] children=new Node[26];
        boolean eow=false;
    }
    Node root=new Node();
    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow;
    }

    public boolean breakUtil(String s){
        if(s.isEmpty()){
            return true;
        }
        for(int i=1;i<=s.length();i++){
            if(search(s.substring(0,i))&& breakUtil(s.substring(i))){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
        }
        return breakUtil(s);
    }
}
