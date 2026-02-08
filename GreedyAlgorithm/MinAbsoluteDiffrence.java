package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDiffrence {
    public static List<List<Integer>>  minimumAbsDifference(int []arr){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDiff=Math.min(minDiff,arr[i-1]-arr[i]);
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]-arr[i]==minDiff){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr={4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }
}
