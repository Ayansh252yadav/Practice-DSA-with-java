package OnlinePlatform;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {

        long low = 1;
        long high = num;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sq = mid * mid;

            if (sq == num) {
                return true;
            } else if (sq < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
