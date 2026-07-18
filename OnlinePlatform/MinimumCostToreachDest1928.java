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
    static class Pair implements Comparable<Pair>{
        int node;
        int time;
        public Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
        @Override
        public int compareTo(Pair o) {
            return this.time - o.time;
        }
    }
    public static int dijkstra(ArrayList<Edge>[]graph,int src,int maxTime,
                               int []passingFee){
       int []dist=new int[passingFee.length];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[0]=0;
       PriorityQueue<Pair> q=new PriorityQueue<>();
       q.add(new Pair(0,0));
        boolean[]visited=new boolean[passingFee.length];
        int calcTime=0;
       while (!q.isEmpty()){
           Pair curr=q.poll();
           if(!visited[curr.node]){
               visited[curr.node]=true;
               calcTime+=curr.time;
               for(int i=0;i<graph[curr.node].size();i++){
                   Edge e=graph[curr.node].get(i);
                   int u=e.src;
                   int v=e.dest;
                   int time=e.time;
                   if(dist[u]+passingFee[v]<dist[v]){
                       dist[v]=dist[u]+passingFee[v];
                       q.add(new Pair(v,calcTime));
                   }
               }
           }
       }
       return dist[maxTime];
    }
     public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        ArrayList<Edge>[]graph=new ArrayList[passingFees.length];
       createGraph(graph,edges);
 return dijkstra(graph,0,maxTime,passingFees);
    }
}
