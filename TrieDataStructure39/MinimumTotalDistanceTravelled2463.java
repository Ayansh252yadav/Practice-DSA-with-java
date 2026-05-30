package TrieDataStructure39;

import java.util.*;

public class MinimumTotalDistanceTravelled2463 {
    public static int helper(int robot,int[][]factory){
        int minDis=Integer.MAX_VALUE;
        int idx=0;
        for(int i=0;i< factory.length;i++){
            if(minDis>Math.abs(robot-factory[i][0]) && factory[i][1]>0) {
                minDis = Math.min(minDis, Math.abs(robot - factory[i][0]));
                idx=i;
            }
        }
        factory[idx][1]=factory[idx][1]-1;
        return minDis!=Integer.MAX_VALUE?minDis:0;
    }
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
     int countDis=0;
     for(int i=0;i<robot.size();i++){
         countDis+=helper(robot.get(i),factory);
     }
     return (long)(countDis);
    }
//correct approach dp
    public static int util(List<Integer>robot,int robotPos,List<Integer>factory,int factPos,int[][]dp){
        if(robotPos<0){
            return 0;
        }
        if(factPos<0){
            return Integer.MAX_VALUE;
        }
        if(dp[robotPos][factPos]!=-1){
            return dp[robotPos][factPos];
        }
        int include=Math.abs(robot.get(robotPos)-factory.get(factPos))+
                util(robot,robotPos-1,factory,factPos-1,dp);
        int exclude =util(robot,robotPos,factory,factPos-1,dp);
        dp[robotPos][factPos]=Math.min(include,exclude);
       return  dp[robotPos][factPos];
    }
    public static long minimumTotalDistance1(List<Integer> robot, int[][] factory) {
     int [][]dp=new int[robot.size()][factory.length];
     for(int i=0;i<dp.length;i++){
         Arrays.fill(dp[i],-1);
     }
        Collections.sort(robot);
//        Collections.sort(factory, Comparator.comparingInt(a -> a[0]));
        List<Integer>fact=new ArrayList<>();
        for (int[] e : factory) {
            fact.add(e[0]);
        }
        Collections.sort(fact);
        util(robot,robot.size()-1,fact,fact.size()-1,dp);
        return (long) dp[0][0];
    }
    public static void main(String[] args) {
       List<Integer>ls=new ArrayList<>();
       ls.add(0);
       ls.add(4);
       ls.add(6);
        int [][]factory = {{2,2},{6,2}};
//        System.out.println(minimumTotalDistance(ls,factory));
        System.out.println(minimumTotalDistance1(ls,factory));
    }
}
