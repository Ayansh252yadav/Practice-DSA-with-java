package OnlinePlatform;

import java.util.ArrayList;

public class NextPermutation31 {
    public static void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void permutation(int[] nums, int idx, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            temp.add(nums[idx]);
            permutation(nums, idx + 1, temp, res);
            temp.removeLast();
            swap(nums, idx, i);
        }
    }

    public static void main(String[] args) {
        int []nums={1,2,3};
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        permutation(nums,0,new ArrayList<>(),res);
        System.out.println(res);
    }
}
