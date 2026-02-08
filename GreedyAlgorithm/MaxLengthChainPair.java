package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChainPair {
    public static int maxLenChain(int pair[][]){
        Arrays.sort(pair, Comparator.comparingInt(o->o[1]));
        int ans=1;
        int lastSec=pair[0][1];
        for(int i=0;i<pair.length;i++){
            if(pair[i][0]>lastSec){
                ans++;
                lastSec=pair[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int pair[][]={{1,2},{2,3},{3,4}};
        System.out.println(maxLenChain(pair));
    }
}
