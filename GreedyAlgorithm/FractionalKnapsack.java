package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[] wt, int W) {
        // code here
        double ratio[][]=new double[val.length][2];
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)wt[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int capacity=W;
        double finalValue=0;
        for(int i=val.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(wt[idx]<=capacity){
                finalValue+=val[idx];
                capacity-=wt[idx];
            }else{
                finalValue+=ratio[i][1]*capacity;
                break;
            }
        }
       return finalValue;
    }
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;
        System.out.println(fractionalKnapsack(val,weight,w));
    }
}
