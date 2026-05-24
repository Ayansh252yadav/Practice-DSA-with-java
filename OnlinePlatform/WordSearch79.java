package OnlinePlatform;

import java.util.TreeSet;

public class WordSearch79 {//incomplete
    public static boolean helpUtil(char [][]board,boolean [][]vis,int i,int j,
                                   String str,int idx){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(idx==str.length()-1){
            return true;
        }
        if(vis[i][j]){
            return false;
        }
        if(board[i][j]!=str.charAt(idx)){
            return false;
        }
        int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        vis[i][j]=true;
        for(int []d:dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (helpUtil(board, vis, ni, nj, str, idx + 1)) {
                return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        boolean [][]vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                    if(helpUtil(board,vis,i,j,word,0)){
                        return true;
                    }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));
        StringBuilder sb=new StringBuilder("dhsdakjaf");

    }
}
class Solution5 {
    public int secondHighest(String s) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                set.add(s.charAt(i)-'0');
            }
        }
        if(set.size()>=2){
            return set.lower(set.last());
        }
        return -1;
    }
}
