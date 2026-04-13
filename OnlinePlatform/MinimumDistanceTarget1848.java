package OnlinePlatform;

public class MinimumDistanceTarget1848 {
    public static int getMinDistanceUtil(int[] nums, int target,int start) {
        int tarIdx=0;
        int minDis=Integer.MAX_VALUE;
     for(int i=0;i<nums.length;i++) {
         if (nums[i] == target) {
            tarIdx=Math.abs(i-start);
             minDis=Math.min(tarIdx,minDis);
         }

     }
     return minDis;
    }
    public static int getMinDistance(int[] nums, int target, int start) {
    return getMinDistanceUtil(nums,target, start);
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4,5};
        int target=5;
        int start=3;
        System.out.println(getMinDistance(nums,target,start));
    }
}
