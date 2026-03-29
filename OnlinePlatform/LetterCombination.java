package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    static String []map={
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
     List<String>result=new ArrayList<>();
     if(digits.isEmpty()){
         return result;
     }
     backTrack(0,digits,new StringBuilder(),result);
     return result;
    }
    public static void backTrack(int index, String digits,
                                 StringBuilder current,
                                 List<String> result){
     if(index==digits.length()){
         result.add(current.toString());
         return;
     }
        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backTrack(index + 1, digits, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
