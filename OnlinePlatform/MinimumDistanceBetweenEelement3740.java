package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumDistanceBetweenEelement3740 {

    public static int minimumDistance(int[] nums) {
        if(nums.length<3){
            return -1;
        }
        int minDis=0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

       for(int i=0;i<nums.length;i++){
           if (visited[i]) {
               continue;
           }
           ArrayList<Integer> temp = new ArrayList<>();
           temp.add(nums[i]);
         for(int j=0;j<nums.length;j++){
             if(nums[i]==nums[j]){
                temp.add(j);
                 visited[j]=true;
             }
         }
           arr.add(temp);
       }
        arr.removeIf(list -> list.size() < 4);
       int min=Integer.MAX_VALUE;
        if(!arr.isEmpty()){
            for (ArrayList<Integer> row : arr) {
                System.out.println(row);
                for(int i=1;i<row.size()-1;i++){
                    minDis+=Math.abs(row.get(i)- row.get(i+1));
                }
                minDis+=Math.abs(row.get(row.size()-1)-row.get(1));
                min=Math.min(minDis,min);
                minDis=0;
            }
        }else{
            return -1;
        }
       return min;
    }
    public static int minimumDistance1(int[] nums) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        // Step 2: process each group
        for (ArrayList<Integer> list : map.values()) {

            if (list.size() < 3) {
                continue;
            }

            for (int i = 0; i <= list.size() - 3; i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                min = Math.min(min, dist);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void main(String[] args) {
        int []arr={1,1,1,1};
        System.out.println(  minimumDistance1(arr));
    }
}
