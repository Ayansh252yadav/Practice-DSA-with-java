package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoinChange {
    public static int findChange(int amount){
        Integer coin[]={186,419,83,408};
        Arrays.sort(coin, Comparator.reverseOrder());
        int count=0;
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<coin.length;i++){
            if(coin[i]<=amount){
                while (coin[i]<=amount){
                    count++;
                    res.add(coin[i]);
                    amount-=coin[i];
                }
            }
        }
        System.out.println(res);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findChange(6249));
    }
}
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
