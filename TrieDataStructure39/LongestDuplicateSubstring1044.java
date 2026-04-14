package TrieDataStructure39;

public class LongestDuplicateSubstring1044 {
     class Node{
        Node []children=new Node[26];
        int count=0;
    }
    public Node root=new Node();
     public  void insert(String word){
         Node curr=root;
         for(int i=0;i<word.length();i++){
             int idx=word.charAt(i)-'a';
             if(curr.children[idx]==null) {
                 curr.children[idx] = new Node();
             }
             curr=curr.children[idx];
             curr.count++;
         }
     }
    public String longestDupSubstring(String s) {
       int n=s.length();
       int maxLen=0;
       int startIdx=-1;
       for(int i=0;i<n;i++){
           insert(s.substring(i));
       }

       for(int i=0;i<s.length();i++){
           Node curr=root;
           for(int j=i;j<n;j++){
           int idx=s.charAt(j)-'a';
           if(curr.children[idx]==null){
               break;
           }
           curr=curr.children[idx];
           if(curr.count>=2){
               int len=j-i+1;
               if(len>maxLen){
                   maxLen=len;
                   startIdx=i;
               }
           }else{
               break;
           }
           }
       }
       if(startIdx==-1){
           return " ";
       }
       return s.substring(startIdx,startIdx+maxLen);
    }

    public static void main(String[] args) {
         LongestDuplicateSubstring1044 l=new LongestDuplicateSubstring1044();
        String s="aa";
        System.out.println(l.longestDupSubstring(s));
    }
}
