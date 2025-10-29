package Strings17.com;

public class PallindromeString {
    public static boolean checkPallindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
            return true;
    }

    public static void main(String[] args) {
//        System.out.println(checkPallindrome("NAMAN"));
        Solution sc=new Solution();
        System.out.println(sc.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
//A phrase is a palindrome if, after converting all uppercase letters into
//lowercase letters and removing all non-alphanumeric characters, it reads
//the same forward and backward. Alphanumeric characters include letters
//and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.
//Example 1:
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
class Solution {
    public boolean isPalindrome(String str) {
       str= str.toLowerCase();
       str= str.trim();
        str = str.replaceAll("[^a-zA-Z0-9]", "");;
        System.out.println(str);
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}