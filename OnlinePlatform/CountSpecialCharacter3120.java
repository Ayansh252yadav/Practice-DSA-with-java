package OnlinePlatform;

import java.util.HashSet;
import java.util.Set;

public class CountSpecialCharacter3120 {
    public static int numberOfSpecialChars(String word) {
        Set<Character> set=new HashSet<>();
        for(char ch:word.toCharArray()){
            set.add(ch);
        }
        int count=0;
        for(char ch:word.toCharArray()){
            boolean check=Character.isUpperCase(ch);
            if(check){
                if(set.contains(ch) && set.contains((char)(ch+32))){
                    count++;
                    set.remove(ch);
                    set.remove((char)(ch+32));
                }
            }else {
                if(set.contains(ch) && set.contains((char)(97-ch))){
                    count++;
                    set.remove(ch);
                    set.remove((char)(97-ch));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("abc"));
    }
}
