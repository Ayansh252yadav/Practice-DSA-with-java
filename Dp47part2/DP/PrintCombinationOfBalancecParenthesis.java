package Dp47part2.DP;

import java.util.ArrayList;
import java.util.List;

public class PrintCombinationOfBalancecParenthesis {
    public static int  catalnsRecursion(int n){
        if(n==1 || n==0){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalnsRecursion(i)*catalnsRecursion(n-i-1);
        }
        return ans;
    }
 public static void generate(int open , int close, String path, List<String> res){
        if(open>close){
            return;
        }
        if(open==0 && close==0){
            res.add(path);
            return;
        }
     if (open > 0) {
         generate(open - 1, close, path + "(", res);
     }

     if (close > 0) {
         generate(open, close - 1, path + ")", res);
     }
 }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, "", res);
        return res;
    }
    public static void main(String[] args) {
//        System.out.println(catalnsRecursion(4));
        System.out.println(generateParenthesis(2));
    }
}
