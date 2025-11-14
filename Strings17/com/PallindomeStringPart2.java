package Strings17.com;

public class PallindomeStringPart2 {
public static boolean isPallindrome(String str){
    str=str.toLowerCase();
    str=str.trim();//this method trim only the starting and end extra spaces
    System.out.println(str);
    str=str.replaceAll("[^a-zA-Z0-9]",""); //this is very
    // important sequence to check
    // whether a sentence is pallindrome or not
    System.out.println(str);
    int start=0;
    int end=str.length()-1;
    while(start<=end){
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}

    public static void main(String[] args) {
        System.out.println(isPallindrome("       A man, a plan, a canal: Panama "));
    }
}
