package Backtracking24;

import java.util.ArrayList;
import java.util.List;

public class NQueensallWays2 {
    public static void permutation(char [][]board,int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='Q';
                permutation(board,row+1);//recursion
                board[row][i]='X';//backtracking
            }
        }
    }
  public static List<List<String>> printBoard(char board[][]){
      System.out.println("-------------");
//      for(int i=0;i<board.length;i++){
//          for(int j=0;j<board.length;j++){
//              System.out.print(board[i][j]+" ");
//          }
//          System.out.println();
//      }
      List<String> solution = new ArrayList<>();
      for (char[] row : board) {
          solution.add(new String(row));
      }
      List<List<String>> result = new ArrayList<>();
      result.add(solution);
return result;
  }
  public static boolean isSafe(char board[][],int row,int col){
        //vertical up
      for(int i=row-1;i>=0;i--){
          if(board[i][col]=='Q'){
              return false;
          }
      }
      //digonal left up
      for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--){
          if(board[i][j]=='Q'){
              return false;
          }
      }
//      digonal right up
      for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
          if(board[i][j]=='Q'){
              return false;
          }
      }
      return true;
  }
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char[n][n];
        //intialization
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        permutation(board,0);
//        printBoard(board);
    }
}
