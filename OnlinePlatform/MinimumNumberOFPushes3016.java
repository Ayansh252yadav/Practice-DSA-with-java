package OnlinePlatform;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOFPushes3016 {
    public int[] maxFreq(int []freq){
        int idx=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<freq.length;i++){
            if(max<freq[i]){
                max=freq[i];
                idx = i;
            }
        }
        int []res=new int[2];
        res[0]=idx;
        res[1]=freq[idx];
        freq[idx]=0;
        return res;
    }
    public int minimumPushes(String word) {
        int []freq=new int[26];
        Set<Character> set=new HashSet<>();
        for(char c:word.toCharArray()){
            freq[c-'a']++;
            set.add(c);
        }
        int count=0;
        for(int i=0;i<set.size();i++){
            int []idx=maxFreq(freq);
            if(i<8){
               count+=idx[1];
            }else if(i<16){
                count+=idx[1]*2;
            } else if (i<24 ) {
                count+=idx[1]*3;
            }else{
                count+=idx[1]*4;
            }
        }
        return count;
    }
}
