package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static int jobSheduling(int jobsInfo[][]){
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        Collections.sort(jobs,(a,b)->b.profit-a.profit);
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                time++;
                seq.add(curr.id);
            }
        }
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
        return time;
    }

    public static void main(String[] args) {
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
//        System.out.println(jobSheduling(jobsInfo));
        leet lt=new leet();
            int start[]={1,2,3,3};
            int end[]={3,4,5,6};
            int profit[]={50,10,40,70};
            System.out.println(leet.jobScheduling(start,end,profit));
        }
}

class leet {
    public static int jobScheduling(int start[], int end[], int profit[]) {
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
//        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));
        int maxProfit = 0;
        int lastAct = activities[0][2];
        for (int i = 0; i < start.length; i++) {
            if (activities[i][1] >= lastAct) {
                maxProfit += profit[i];
                lastAct = activities[i][2];
            }
        }
        return maxProfit;
    }
}
