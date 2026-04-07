package TrieDataStructure39;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII140 extends WordBreak139{
//    public List<String> wordUtil(String s,List<String>res){
//        if(s.isEmpty()){
//            return res;
//        }
//        for(int i=1;i<=s.length();i++){
//            if(search(s.substring(0,i))){
//                res.add(s.substring(0,i));
//                wordUtil(s.substring(i),res);
//            }
//        }
//        return res;
//    }
public List<String> wordUtil(String s) {
    List<String> res = new ArrayList<>();

    if (s.length() == 0) {
        res.add("");
        return res;
    }

    for (int i = 1; i <= s.length(); i++) {
        String prefix = s.substring(0, i);

        if (search(prefix)) {
            List<String> rest = wordUtil(s.substring(i));

            for (String r : rest) {
                if (r.isEmpty()) {
                    res.add(prefix);
                } else {
                    res.add(prefix + " " + r);
                }
            }
        }
    }
    return res;
}
    public List<String> wordBreak2(String s, List<String> wordDict) {
      for(int i=0;i<wordDict.size();i++){
          insert(wordDict.get(i));
      }
      return wordUtil(s);
    }

    public static void main(String[] args) {
        String []arr={"cat","cats","and","sand","dog"};
        List<String>ls=new ArrayList<>(List.of("cat","cats","and","sand","dog"));
        String s="catsanddog";
        WordBreakII140 wb=new WordBreakII140();
        System.out.println(wb.wordBreak2(s,ls));
    }
}
