package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static int activitySelection(int start[],int end[]){
        int actvities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            actvities[i][0]=i;
            actvities[i][1]=start[i];
            actvities[i][2]=end[i];
        }
        Arrays.sort(actvities,Comparator.comparingInt(o->o[2]));
        int maxAct=1;
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(actvities[0][0]);
        int lastAct=actvities[0][2];
        for(int i=1;i<start.length;i++){
            if(actvities[i][1]>=lastAct){
                maxAct++;
                ans.add(actvities[i][0]);
                lastAct=actvities[i][2];
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.print("A "+ans.get(i)+" ");
        }
        System.out.println();
        return maxAct;
    }

    public static void main(String[] args) {
        int start[]={10,12,20};
        int end[]={20,25,30};

        System.out.println(activitySelection(start,end));
    }
}
