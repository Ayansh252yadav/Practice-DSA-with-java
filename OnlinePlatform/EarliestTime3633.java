package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class EarliestTime3633 {
    public static int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                         int[] waterStartTime, int[] waterDuration) {
    int []landFinishTime=new int[landStartTime.length];
    for(int i=0;i<landStartTime.length;i++){
        landFinishTime[i]=landStartTime[i]+landDuration[i];
    }
    int landToWater=Integer.MAX_VALUE;
    for(int i=0;i<landFinishTime.length;i++){
        for(int j=0;j<waterDuration.length;j++){
            int waterStart=Math.max(landFinishTime[i],waterStartTime[j]);
            landToWater=Math.min(landToWater,waterStart+waterDuration[j]);
        }
    }
    int []waterFinishTime=new int[waterStartTime.length];
    for(int i=0;i<waterStartTime.length;i++){
        waterFinishTime[i]=waterStartTime[i]+waterDuration[i];
    }
    int waterToLand=Integer.MAX_VALUE;
    for(int i=0;i<waterFinishTime.length;i++){
        for(int j=0;j<landStartTime.length;j++){
            int landStart=Math.max(waterFinishTime[i],landStartTime[j]);
            waterToLand=Math.min(waterToLand,landStart+landDuration[j]);
        }
    }
       return Math.min(waterToLand,landToWater);
    }

    public static void main(String[] args) {
        int []landStartTime = {2,8};
        int []landDuration = {4,1};
        int [] waterStartTime = {6};
        int [] waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime,landDuration,waterStartTime,waterDuration));
    }
}
