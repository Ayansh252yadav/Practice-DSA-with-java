package OnlinePlatform;


import java.util.Arrays;

public class MaxiMumNumberOfItemsForSale3946 {
    public static int maximumSaleItems(int[][] items, int budget) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
        return 0;
    }

    public static void main(String[] args) {
       int [][] items = {{6,2},{2,6},{3,4}};
       int budget = 4;
        System.out.println(maximumSaleItems(items,budget));
    }
}
