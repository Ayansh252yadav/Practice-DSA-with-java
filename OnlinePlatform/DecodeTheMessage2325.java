package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage2325 {
    public static String decodeMessage(String key, String message) {
        Map<Character,Character> mp=new HashMap<>();
        char ch='a';
       for(int i=0;i<key.length();i++){
           if(!mp.containsKey(key.charAt(i)) && key.charAt(i)!=' '){
               mp.put(key.charAt(i),ch++);
           }
       }
        System.out.println(mp);
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<message.length();i++){
           if(mp.containsKey(message.charAt(i))){
               sb.append(mp.get(message.charAt(i)));
           }else{
               sb.append(" ");
           }
       }
       return sb.toString();
    }
    public int maxWidthOfVerticalArea(int[][] points) {
        ArrayList<Integer>arr=new ArrayList<>();
        for(int []e:points){
            arr.add(e[0]);
        }
        arr.sort((a,b)->a-b);
        int maxDiff=Integer.MIN_VALUE;
        for(int i=0;i<arr.size()-1;i++){
            int t=arr.get(i+1)-arr.get(i);
            maxDiff=Math.max(maxDiff,t);
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));
    }
}
