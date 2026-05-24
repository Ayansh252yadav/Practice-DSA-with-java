package OnlinePlatform;

import java.util.*;

public class RemoveDuplicates80 {
    public static int removeDuplicates(int[] nums) {
        ArrayList<Integer>arr=new ArrayList<>();
        int track=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(track==nums[i]){
                count++;
            }else{
                arr.add(count);
                count=1;
            }
            track=nums[i];
        }
        arr.add(count);
        int size=0;
        for(int e:arr){
            if(e>2){
                size+=2;
            }else{
                size+=e;
            }
        }
        Set<Integer> temp=new LinkedHashSet<>();
        for(int num:nums){
            temp.add(num);
        }
        int j=0;
        int k=0;
       for(int x:temp){
          if(arr.get(j)>=2){
              nums[k]=x;
              nums[k+1]=x;
              k+=2;
          }else{
              nums[k]=x;
              k+=1;
          }
          j++;
       }
        System.out.println(Arrays.toString(nums));
        System.out.println(size);
        System.out.println(arr);
        return 0;
    }

    public static void main(String[] args) {
        int []nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
