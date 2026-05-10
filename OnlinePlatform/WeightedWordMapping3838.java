package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class WeightedWordMapping3838 {
    public  static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
     for(String str:words){
         int sum=0;
         for(char ch:str.toCharArray()){
             sum+=weights[ch-'a'];
         }
         sum=sum%26;
         Character t=(char)('a'+(26-sum-1)%26);
         sb.append(t);
     }
     return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int []weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights(words,weights));

    }
}
