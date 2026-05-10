package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestDistanceTOaCharacter821 {
    public static void helper(int[]res,int n,String s){
        for(int i=0;i<s.length();i++){
            res[i]=Math.min(res[i],Math.abs(i-n));
        }
    }
    public static int[] shortestToChar(String s, char c) {
       int []res=new int[s.length()];
       Arrays.fill(res,Integer.MAX_VALUE);
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                arr.add(i);
            }
        }
        System.out.println(arr);
        for (Integer integer : arr) {
            helper(res, integer, s);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar(s,c)));
    }
}
