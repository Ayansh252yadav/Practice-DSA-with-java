package OnlinePlatform;

import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n){
        HashSet<Integer> seen = new HashSet<>();
        int temp = n;
        while (temp != 1) {
            if (seen.contains(temp)) {
                return false;
            }
            seen.add(temp);

            int sq = 0;

            while (temp != 0) {
                int rem = temp % 10;
                sq = sq + rem * rem;
                temp = temp / 10;
            }

            temp = sq;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
