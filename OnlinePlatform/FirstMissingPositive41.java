package OnlinePlatform;

import java.util.Arrays;

public class FirstMissingPositive41 {
    public static int firsMissingPositive(int nums[]){
        int n = nums.length;

        // Step 1: place each number in its correct position
        for (int i = 0; i < n; i++) {
            while (
                    nums[i] > 0 &&
                            nums[i] <= n &&
                            nums[nums[i] - 1] != nums[i]
            ) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int nums[]={7,8,9,11,12};
        System.out.println(firsMissingPositive(nums));
    }
}
