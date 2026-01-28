package OnlinePlatform;
import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan901 {
    public static void stockSpan(int []stocks,int []span){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice>=stocks[s.peek()] ){
               s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int []stock={100,80,60,70,60,85,100};
        int span[]=new int[stock.length];
        stockSpan(stock,span);
        System.out.println(Arrays.toString(span));
    }
}
