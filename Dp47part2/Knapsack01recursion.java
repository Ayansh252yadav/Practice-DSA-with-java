package Dp47part2;

public class Knapsack01recursion {
    public static int recursionKanapsack(int val[],int wt[],int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        if(wt[n-1]<=W){
            //include
            int ans1=val[n-1]+recursionKanapsack(val,wt,W-wt[n-1],n-1);
            //exclude
            int ans2=recursionKanapsack(val,wt,W,n-1);
            return Math.max(ans1,ans2);
        }else{
            return recursionKanapsack(val,wt,W,n-1);
        }
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(recursionKanapsack(val,wt,W,val.length));
    }
}
