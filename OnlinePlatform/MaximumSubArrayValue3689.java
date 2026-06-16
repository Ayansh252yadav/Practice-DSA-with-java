package OnlinePlatform;

public class MaximumSubArrayValue3689 {
    public int minElement(int []nums){
        int min=Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
    public int maxElement(int []nums){
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
    public long maxTotalValue(int[] nums, int k) {
        int min=minElement(nums);
        int max=maxElement(nums);
        return (long) (max - min) *k;
    }

    public static void main(String[] args) {
        MaximumSubArrayValue3689 ms=new MaximumSubArrayValue3689();
        int []nums={1,3,2};
        int k=2;
        System.out.println(ms.maxTotalValue(nums,k));
    }
}
