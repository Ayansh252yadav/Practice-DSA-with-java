package TrieDataStructure39;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
   static class Node{
       Node []children=new Node[26];
       boolean isWord=false;
       String word=null;
   }
   public static Node root=new Node();
   public static void createTrie(String word){
       Node curr=root;
       for(int i=0;i<word.length();i++){
           int idx=word.charAt(i)-'a';
           if(curr.children[idx]==null){
               curr.children[idx]=new Node();
           }
           curr=curr.children[idx];
       }
       curr.isWord=true;
       curr.word=word;
   }

   public static void dfs(char[][]board,int row,int col,Node node,List<String>ans){
       if(row<0 || row>=board.length || col<0 || col>=board[0].length){
           return;
       }
       if(board[row][col]=='#'){
           return;
       }
       char ch=board[row][col];
       int idx=ch-'a';
       if(node.children[idx] == null){
           return;
       }
       node=node.children[idx];
      if(node.isWord){
          ans.add(node.word);
          node.isWord=false;
      }
       board[row][col] = '#';
      dfs(board,row+1,col,node,ans);
      dfs(board,row-1,col,node,ans);
      dfs(board,row,col+1,node,ans);
      dfs(board,row,col-1,node,ans);
       board[row][col] = ch;
   }
    public static List<String> findWords(char[][] board, String[] words) {
     for(String s:words){
         createTrie(s);
     }
     List<String>ans=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char [][]board={{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','i','v'}};
        String []words = {"oath","pea","eat","rain"};
        System.out.println( findWords(board,words));
    }
}
