package OnlinePlatform;

public class DivcideArray {
    public static boolean divideArray(int[] nums) {
        int[] res = new int[501];
        for (int e : nums) {
            res[e]++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,6};
        System.out.println(divideArray(arr));
    }
}
