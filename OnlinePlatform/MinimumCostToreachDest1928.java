package OnlinePlatform;

import java.util.*;

public class MinimumCostToreachDest1928 {
    static class Edge{
        int src;
        int dest;
        int time;
        public Edge(int src, int dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int [][]edges){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1],e[2]));
            graph[e[1]].add(new Edge(e[1],e[0],e[2]));
        }
    }
    static class Info implements Comparable<Info>{
        int node;
        int passFee;
        int time;
        public Info(int node, int passFee, int time) {
            this.node = node;
            this.passFee = passFee;
            this.time = time;
        }
        @Override
        public int compareTo(Info o) {
            return this.passFee - o.passFee;
        }
    }
    public static int minCostUtil(ArrayList<Edge>[]graph,int src,int dest,
                                   int []passingFee,int maxTime){
       int []dist=new int[passingFee.length];
       int []newTime=new int[passingFee.length];
       Arrays.fill(dist,Integer.MAX_VALUE);
       Arrays.fill(newTime,Integer.MAX_VALUE);
       newTime[0]=0;
       dist[src]=0;
       PriorityQueue<Info> pq=new PriorityQueue<>();
       pq.offer(new Info(src,passingFee[0],0));
       while(!pq.isEmpty()){
           Info curr=pq.poll();
           if(curr.time>maxTime){
               break;
           }
           for(int i=0;i<graph[curr.node].size();i++){
               Edge e=graph[curr.node].get(i);
               int v=e.dest;
               int time=e.time;
               int newFee=curr.passFee+passingFee[v];
               int newtime=curr.time+time;
               if(newtime>maxTime){
                   continue;
               }
               if(newFee<dist[v] || newtime<newTime[v]){
                   if(newFee<dist[v]){
                       dist[v]=newFee;
                   }
                   if(newtime<newTime[v]){
                       newTime[v]=newtime;
                   }
                   pq.add(new Info(v,newFee, newtime));
               }
           }
       }
       if(dist[dest]==Integer.MAX_VALUE){
           return -1;
       }
       return dist[dest];
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<Edge>[]graph=new ArrayList[passingFees.length];
        createGraph(graph,edges);
      return minCostUtil(graph,0,passingFees.length-1,passingFees,maxTime);
    }
}
