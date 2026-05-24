package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack2 {
    public static void main(String[] args) {
        int []val={60,100,120};
        int []wt={10,20,30};
        int capacity=50;
        double [][]ratio=new double[val.length][2];
        for(int i=0;i<val.length;i++){
            int r=val[i]/wt[i];
            ratio[i][0]=i;
            ratio[i][1]=r;
        }
        int profit=0;
        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]));
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=wt[idx]){
                profit+=val[idx];
                capacity-=wt[idx];
            }else{
                profit+=capacity*(int)ratio[i][1];
                break;
            }
        }
        System.out.println(profit);
    }
}
