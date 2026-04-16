package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosesetEqualElementQuery3488{
    public static int closestTarget(int [] arr, int target, int startIndex) {
        int n = arr.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(i!=startIndex){
                if (arr[i]==target) {
                    int diff = Math.abs(i - startIndex);
                    int dist = Math.min(diff, n - diff);
                    minDist = Math.min(minDist, dist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer>res=new ArrayList<>(queries.length);

        for (int idx : queries) {
            res.add(closestTarget(nums, nums[idx], idx));

        }
      return res;
    }

    static int circularDistance(int i, int j, int n) {
        int linear = Math.abs(i - j);
        return Math.min(linear, n - linear);
    }

    public static List<Integer> solveQueries2(int[] nums, int[] queries) {
        int n=nums.length;
        List<Integer>res=new ArrayList<>(queries.length);
        Map<Integer,List<Integer>>indexMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            indexMap.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        int minDist = Integer.MAX_VALUE;


        // Step 2: Check all consecutive pairs + wrap-around pair
        for (Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> indices = entry.getValue();

            if (indices.size() < 2) continue; // no duplicate

            for (int k = 0; k < indices.size(); k++) {
                int i = indices.get(k);
                int j = indices.get((k + 1) % indices.size()); // wrap-around

                int dist = circularDistance(i, j, n);
                res.add(dist);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums={1,3,1,4,1,3,2};
        int []queries={0,3,5};
        System.out.println(solveQueries(nums,queries));
    }
}
