package reviision.ArrayII.com;

public class BuyandsellStock {
    public  static int Stocks(int prices[]){
        int maxProfit=0;
        int buyPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                maxProfit=Math.max(maxProfit,profit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[]={7, 10, 1, 3, 6, 9, 2};
        System.out.println(Stocks(prices));
        SelltheStocksAnyNumberOfTimes sc=new SelltheStocksAnyNumberOfTimes();
        System.out.println(sc.stock2(prices));
    }
}
class SelltheStocksAnyNumberOfTimes{
    public static int stock2(int prices[]){
        if(prices.length==0){
            return 0;
        }
        int total_profit=0;
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                total_profit+=prices[i]-prices[i-1];
            }
        }
        return total_profit;
    }
}