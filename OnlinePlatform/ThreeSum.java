package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int []nums){
        Arrays.sort(nums);
        List<List<Integer>>arr=new ArrayList<>();
        if(nums.length<3){
            return arr;
        }
        int n=nums.length;
        for(int i=0;i<n;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((nums[i]+nums[j]+nums[k])==0){
                        arr.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return arr;
    }

    public static  List<List<Integer>> twoPointerthreeSum(int nums[]){
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>>arr=new ArrayList<>();
        if(nums.length<3|| nums==null){
          return arr;
        }
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-1;
            if(i>0 && nums[i] == nums[i - 1]){
                continue;
            }
                while(left<right){
                    if(nums[i]+nums[left]+nums[right]==0){
                        arr.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        //skip duplicate left;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicate right
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if(nums[i]+nums[left]+nums[right]<0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        return arr;
    }

    public static void main(String[] args) {
        int [] nums={0,0,0,0};
//        System.out.println(threeSum(nums));
        System.out.println(twoPointerthreeSum(nums));
    }
}
