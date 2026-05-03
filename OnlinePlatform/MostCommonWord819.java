package OnlinePlatform;

import java.util.*;

public class MostCommonWord819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", "");
        paragraph=paragraph.toLowerCase();
        String []s=paragraph.split(" ");
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> mp=new HashMap<>();
        for (String string : s) {
            if (mp.containsKey(string)) {
                mp.put(string, mp.getOrDefault(string, 0) + 1);
            } else {
                mp.put(string, 1);
            }
        }
        String temp="";
        int maxCount=0;
        for (String string : s) {
            if (mp.containsKey(string) && !ban.contains(string)) {
                if (maxCount < mp.get(string)) {
                    maxCount = mp.get(string);
                    temp = string;
                }
            }
        }
   return temp;
    }
    public static void main(String[] args) {
  String s="Bob hit a ball, the hit BALL flew far after it was hit.";
  String []banned = {"hit"};
        System.out.println(mostCommonWord(s,banned));
    }
}
