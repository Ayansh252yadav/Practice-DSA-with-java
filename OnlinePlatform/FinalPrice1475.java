package OnlinePlatform;

import java.util.ArrayDeque;

public class FinalPrice1475 {
    public int[] finalPrices(int[] prices) {
      int[] ans = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=prices.length-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()>prices[i]){
              stack.pop();
            }
           ans[i]=stack.isEmpty()?prices[i]:prices[i]-stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
