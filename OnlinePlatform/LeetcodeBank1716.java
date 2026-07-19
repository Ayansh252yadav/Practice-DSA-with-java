package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeBank1716 {
    public int totalMoney(int n) {
     int []arr={1,2,3,4,5,6,7};
        int rem=n%7;
        int temp=(n-rem)/7;
        int sum=0;
        int i=0;
        while(temp!=0){
         for(int j=0;j<arr.length;j++){
             sum+=arr[i%7];
             arr[i%7]+=1;
             i++;
         }
          temp--;
        }
        i=0;
        while(rem!=0){
            sum+=arr[i];
            i++;
            rem--;
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetcodeBank1716 leetcode=new LeetcodeBank1716();
        System.out.println(leetcode.totalMoney(10));
    }
}
