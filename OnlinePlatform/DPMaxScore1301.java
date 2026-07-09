package OnlinePlatform;

import java.util.Arrays;
import java.util.List;

public class DPMaxScore1301 {
    public int[] pathsWithMaxScore(List<String> board) {
      int n=board.size();
        int MOD = 1000000007;
      int [][]score=new int[n][n];
      int [][]path=new int[n][n];
      for(int i=0;i<n;i++){
          Arrays.fill(score[i],-1);
      }
      score[n-1][n-1]=0;
      path[0][0]=1;
      for(int i=n-1;i>=0;i--){
          for(int j=n-1;j>=0;j--){
              if(board.get(i).charAt(j)=='X'){
                  continue;
              }
              if(i==n-1 && j==n-1){
                  continue;
              }
              int maxScore = -1;
              int count = 0;
              //down
              if(i+1<n && score[i+1][j]!=-1){
                  if(score[i+1][j]>maxScore){
                      maxScore=score[i+1][j];
                      count=path[i+1][j];
                  }else if(score[i+1][j]==maxScore){
                      count = (count + path[i + 1][j]) % MOD;
                  }
              }
              //right
              if(j+1<n && score[i][j+1]!=-1){
                if(score[i][j+1]>maxScore){
                    maxScore=score[i][j+1];
                    count=path[i][j+1];
                } else if (score[i][j+1]==maxScore) {
                    count = (count + path[i][j+1]) % MOD;
                }
              }
              //up-left
              if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] != -1) {
                  if (score[i + 1][j + 1] > maxScore) {
                      maxScore = score[i + 1][j + 1];
                      count = path[i+1][j + 1];
                  } else if (score[i + 1][j + 1] == maxScore) {
                      count = (count + path[i + 1][j + 1]) % MOD;
                  }
              }
              if (maxScore == -1)
                  continue;

              char ch = board.get(i).charAt(j);

              if (Character.isDigit(ch))
                  maxScore += ch - '0';

              score[i][j] = maxScore;
              path[i][j] = count;
          }
      }
        if (score[0][0] == -1)
            return new int[]{0, 0};

        return new int[]{score[0][0], path[0][0]};
    }
}
