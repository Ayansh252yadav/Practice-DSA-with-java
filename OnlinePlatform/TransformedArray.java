package OnlinePlatform;

import java.util.Arrays;

public class TransformedArray {
    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // Circular index: (i + nums[i] + n) % n for negative handling
            int offset=nums[i]%n;
            int targetIdx = (i + offset + n) % n;
            result[i] = nums[targetIdx];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-10};
        System.out.println(Arrays.toString(constructTransformedArray(nums)));
    }
}
