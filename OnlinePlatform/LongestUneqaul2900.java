package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public interface LongestUneqaul2900 {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
  List<String >list=new ArrayList<>();
  int track=-1;
  for(int i=0;i<groups.length;i++){
      if(track!=groups[i]){
          track=groups[i];
          list.add(words[i]);
      }

  }
  return list;
    }

    public static void main(String[] args) {
        String []words={"a","b","c","d"};
        int[]groups={1,0,1,1};
        System.out.println(getLongestSubsequence(words,groups));
    }
}
