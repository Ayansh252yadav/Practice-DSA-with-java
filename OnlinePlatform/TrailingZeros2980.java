package OnlinePlatform;

import java.util.ArrayList;

public class TrailingZeros2980 {
    public boolean hasTrailingZeros(int[] nums) {
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            String temp=Integer.toBinaryString(nums[i]);
            if(temp.charAt(temp.length()-1)=='0'){
                list.add(Integer.parseInt(temp,2));
            }
        }
        return list.size() >= 2;
    }
}
