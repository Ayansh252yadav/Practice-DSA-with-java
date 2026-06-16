package OnlinePlatform;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class MinimumCostOfBuying2144 {
        static int sum=0;
        public static void helper(ArrayDeque<Integer>arr){
            int firstCandy=0;
            if(!arr.isEmpty()){
                firstCandy=arr.pop();
            }
            int secondCandy=0;
            if(!arr.isEmpty()){
             secondCandy=arr.pop();
            }
            int minCost=Math.min(firstCandy,secondCandy);
            int freeCandy=0;
            if(!arr.isEmpty()){
                freeCandy=arr.peek();
                if(freeCandy<=minCost){
                    arr.pop();
                }
            }
            sum+=firstCandy+secondCandy;
        }
        public static int minimumCost(int[] cost) {
            Arrays.sort(cost);
            ArrayDeque<Integer>st=new ArrayDeque<>();
            for(int e:cost){
                st.push(e);
            }
            for(int i=0;i<cost.length;i+=3){
                helper(st);
            }
            return sum;
        }
    public static void main(String[] args) {
        int []arr={5,5};
        System.out.println(minimumCost(arr));
    }
}
