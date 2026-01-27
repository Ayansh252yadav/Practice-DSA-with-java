package OnlinePlatform;

import java.util.ArrayList;

public class GeneratePermutationsofanarrayGFG {
    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(nums,0, result);
        return result;
    }
    public static void backtrack(int[] arr,int start,ArrayList<ArrayList<Integer>>result) {
     if(arr.length==start){
         ArrayList<Integer> currentPermutation = new ArrayList<>();
         for (int num : arr) {
             currentPermutation.add(num);
         }
         result.add(currentPermutation);
         return ;
     }
     int temp;
    for(int i=start;i<arr.length;i++){
        temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
        backtrack(arr,start+1,result);
        temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
    }
    }

    public static void main(String[] args) {
        int []arr={1, 2, 3};
        System.out.println(permute(arr));
    }
}
