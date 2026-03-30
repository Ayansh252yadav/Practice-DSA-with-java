package OnlinePlatform;

import java.util.Stack;

public class ValidPallindrome2680 {
    public static boolean validPalindrome(String s) {

        int start=0;
        int end=s.length()-1;
       while(start<=end){
           if(s.charAt(start)==s.charAt(end)){
               start++;
               end--;
           }else{
               return isPalindrome(s, start + 1, end) ||
                       isPalindrome(s, start, end - 1);
           }
        }
      return true;
    }
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }
}
