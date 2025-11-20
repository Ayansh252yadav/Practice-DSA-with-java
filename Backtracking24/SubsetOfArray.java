package Backtracking24;

import java.util.ArrayList;
import java.util.List;

public class SubsetOfArray {
    public static void Subsets(int nums[], int i, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> arr2) {
        if (i == nums.length) {
            arr.add(new ArrayList<>(arr2));
            return;
        }
        arr2.add(nums[i]);
        Subsets(nums, i + 1, arr, arr2);
        arr2.remove(arr2.size() - 1);
        Subsets(nums, i + 1, arr, arr2);
    }

    public static void main(String[] args) {
     int arrr[]={1,2,3};
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<>();
        ArrayList<Integer> help = new ArrayList<>();

        Subsets(arrr,0,newArr,help);
        System.out.println(newArr);
    }
}
