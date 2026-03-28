package OnlinePlatform;


public class SumOfAllSubSetXOr {
    public static int subsetXORSum(int[] nums) {
        int or = 0;


        for (int num : nums) {
            or |= num;
        }

        // multiply by 2^(n-1)
        return or * (1 << (nums.length - 1));
    }
    public static void main(String[] args) {
        int arr[]={3,4,5,6,7,8};
        System.out.println(subsetXORSum(arr));
    }
}
