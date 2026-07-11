package OnlinePlatform;

import java.util.Arrays;

public class ReverseOnlyLetter917 {
    public static String reverseOnlyLetters(String s) {
    char []arr=s.toCharArray();
    int start=0;
    int end=arr.length-1;
    while(start<=end){
        if (Character.isAlphabetic(arr[start]) &&
                Character.isAlphabetic(arr[end])) {
            char temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        else if(Character.isAlphabetic(arr[start])
                                            && !Character.isAlphabetic(arr[end])){
            end--;
        }else{
            start++;
        }
    }
    StringBuilder sb=new StringBuilder();
    for (char ch : arr) {
        sb.append(ch);
    }
    return reverseSpecialCharacter(sb.toString());
    }
    public static String reverseSpecialCharacter(String s) {
        char[] arr=s.toCharArray();
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            if(!Character.isAlphabetic(arr[start])
                             &&  !Character.isAlphabetic(arr[end])){
                char temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }else if(!Character.isAlphabetic(arr[start]) && Character.isAlphabetic(arr[end])){
                end--;
            }else{
                start++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters(")ebc#da@f("));
    }
}
