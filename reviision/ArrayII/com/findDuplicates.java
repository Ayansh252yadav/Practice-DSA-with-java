package reviision.ArrayII.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class findDuplicates {
    public static ArrayList<Integer> findDuplicates(int[] nums) {
//        Arrays.sort(nums);
        HashSet<Integer> hs=new HashSet<>();
        ArrayList<Integer>arr=new ArrayList<>();

        for(int num :nums){

            if(hs.contains(num)){
                arr.add(num);
            }else{
                hs.add(num);
            }
        }
//        for(int i=1;i<nums.length;i++){
//            if(nums[i-1]==nums[i]){
//                arr.add(nums[i-1]);
//            }
//        }
        return arr;
    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));

        String s="geekforgeeks";
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i%2==0) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
