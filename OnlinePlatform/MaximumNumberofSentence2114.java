package OnlinePlatform;

import java.util.Arrays;

public class MaximumNumberofSentence2114 {
    public static int mostWordsFound(String[] sentences) {
  int maxCount=Integer.MIN_VALUE;
  int count=0;
  for(String s:sentences){
     String[]str= s.split("\\s+");
     for(String st:str){
         count++;
     }
      maxCount=Math.max(maxCount,count);
     count=0;
      System.out.println();
  }
  return maxCount;
    }

    public static void main(String[] args) {
        String[]str={"please wait", "continue to fight", "continue to win"};
        System.out.println(mostWordsFound(str));
    }
}
