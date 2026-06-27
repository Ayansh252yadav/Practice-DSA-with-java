package Stocks;

public class BuyAndSellStock188 {
    public static int maxProfit(int k, int[] prices) {
        int buyPrice=0;
        int idx=0;
        int profit=0;
        int totalProfit=0;
        while(k!=0){
            buyPrice=prices[idx];
            for(int i=idx+1;i<prices.length;i++){
                if(buyPrice>prices[i]){
                    buyPrice=prices[i];
                }
                if(profit<prices[i]-buyPrice){
                    profit=prices[i]-buyPrice;
                    idx=i;
                }
            }
            totalProfit+=profit;
            profit=0;
            k--;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int []prices={3,2,6,5,0,3};
        System.out.println(maxProfit(2,prices));
    }
}
