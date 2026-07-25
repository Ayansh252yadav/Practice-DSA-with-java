package GRAPH43PART4.COM.GraphLeet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostPath3650 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1],e[2]));
            graph[e[1]].add(new Edge(e[1],e[0],e[2]*2));
        }
    }
    static class Info implements Comparable<Info> {
        int node;
        int cost;
        public Info(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        @Override
        public int compareTo(Info o1) {
            return this.cost-o1.cost;
        }
    }
    public static int  minCostUtil(ArrayList<Edge>[]graph,int src,int dest){
        int []dist=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.offer(new Info(src,0));
        while(!pq.isEmpty()){
            Info curr=pq.poll();
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new Info(v,dist[v]));
                }
            }
        }
        return dist[dest];
    }
    public int minCost(int n, int[][] edges) {
   ArrayList<Edge>[]graph=new ArrayList[n];
   createGraph(graph,edges);
   return  minCostUtil(graph,0,n-1);
    }
}
