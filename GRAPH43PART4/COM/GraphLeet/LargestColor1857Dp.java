package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LargestColor1857Dp {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int [][]edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1]));
        }
    }
    public static void calcIndegree(ArrayList<Edge>[]graph,int []indegree){
        for (int i=0;i<graph.length;i++){
            for (int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static boolean topUtil(ArrayList<Edge>[]graph,
                               int [][]dp,String color){
        int []indegree=new int[color.length()];
        calcIndegree(graph,indegree);
        Queue<Integer> q=new LinkedList<>();
        int processNode=0;
        for(int i=0;i<color.length();i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            processNode++;
            dp[cur][color.charAt(cur)-'a']++;
            for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                for (int c = 0; c < 26; c++) {
                    dp[e.dest][c] = Math.max(dp[e.dest][c], dp[cur][c]);
                }
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.offer(e.dest);
                }
            }
        }
       return processNode!=color.length();
    }
    public static int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        ArrayList<Edge>[]graph=new ArrayList[n];
        createGraph(graph,edges);
        int [][]dp=new int[n][26];
        int maxCount=Integer.MIN_VALUE;
            boolean isPath=topUtil(graph,dp,colors);
            if(!isPath){
              for(int []e:dp){
                  for(int c:e){
                      maxCount=Math.max(maxCount,c);
                  }
              }
            }
        return maxCount==Integer.MIN_VALUE?-1:maxCount;
    }

    public static void main(String[] args) {
        String colors = "abaca";
        int [][]edges = {{0,1},{0,2},{2,3},{3,4}};
        System.out.println(largestPathValue(colors,edges));
    }
}
