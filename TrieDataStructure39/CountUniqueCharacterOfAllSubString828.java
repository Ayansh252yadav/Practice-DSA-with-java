package TrieDataStructure39;

import java.util.*;

public class CountUniqueCharacterOfAllSubString828{
    public static int uniqueLetterString(String s) {
  Map<Character, List<Integer>> mp=new HashMap<>();
  for(int i=0;i<s.length();i++){
      mp.computeIfAbsent(s.charAt(i),k->new ArrayList<>()).add(i);
  }
  int totalCount=0;
  for(char ch: mp.keySet()){
      List<Integer>temp=mp.get(ch);
      for(int j=0;j<temp.size();j++){
          int currIndex=temp.get(j);
          int prevIndex=(j==0)?-1:temp.get(j-1);
          int nextIndex=(j==temp.size()-1)?s.length():temp.get(j+1);
          int leftChoice=currIndex-prevIndex;
          int rightChoice=nextIndex-currIndex;
          totalCount+=leftChoice*rightChoice;
      }
  }
  return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
    }
}
