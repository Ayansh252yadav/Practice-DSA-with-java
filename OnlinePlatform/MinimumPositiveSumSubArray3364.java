package OnlinePlatform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MinimumPositiveSumSubArray3364 {
    public static int minimumSumSubArray(List<Integer> nums, int l, int r) {
        int min=0;
        int lSum=0;
        for(int i=0;i<l;i++){
            lSum+=Math.max(lSum,nums.get(i));
        }
        int rSum=0;
        for(int i=0;i<r;i++){

            rSum+=Math.max(rSum,nums.get(i));
        }
        min=Math.min(lSum,rSum);
        if(min>0){
            return min;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(-12, 8));
        System.out.println(minimumSumSubArray(arr,1,1));
    }
}
