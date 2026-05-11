package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class SeparateTheDigit2553 {
    public static ArrayList<Integer> separate(int n){
        ArrayList<Integer>res=new ArrayList<>();
        while(n!=0){
            int rem=n%10;
            res.add(rem);
            n/=10;
        }
        res.reversed();
        return res;
    }
    public static int[] separateDigits(int[] nums) {
        ArrayList<Integer>arr=new ArrayList<>();
     for(int e:nums){
         if(e<=9){
             arr.add(e);
         }else{
          ArrayList<Integer>t=separate(e);
         for(int i=t.size()-1;i>=0;i--){
             arr.add(t.get(i));
         }
         }
     }
     int []res=new int[arr.size()];
     int k=0;
     for(int e:arr){
         res[k++]=e;
     }
     return res;
    }
}
