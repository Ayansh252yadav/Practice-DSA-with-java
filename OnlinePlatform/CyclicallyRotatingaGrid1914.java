package OnlinePlatform;

import com.sun.jdi.ArrayReference;

import java.util.*;

public class CyclicallyRotatingaGrid1914 {

    public static String[] findRelativeRanks(int[] score) {
        String []ans=new String[score.length];
        int []temp=score.clone();
        Map<Integer,String> mp= new HashMap<>();
        Arrays.sort(score);
        for(int i=score.length-1;i>=0;i--){
            int rank=score.length-i;
            if(rank==1){
                mp.put(score[i],"Gold Medal");
            }else if(rank==2){
                mp.put(score[i],"Silver Medal");
            }else if(rank==3){
                mp.put(score[i],"Bronze Medal");
            }else{
                mp.put(score[i],String.valueOf(rank));
            }
        }
        for(int i=0;i<temp.length;i++){
           ans[i]=mp.get(temp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]score = {10,3,8,9,4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}
