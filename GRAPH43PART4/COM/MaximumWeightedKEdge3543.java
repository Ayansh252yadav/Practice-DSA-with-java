package GRAPH43PART4.COM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWeightedKEdge3543 {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int [][]edges){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
     for(int []e:edges){
         graph[e[0]].add(new Edge(e[0],e[1],e[2]));
     }
    }
    static class State{
        int node;
        int weight;
        int edgesUsed;
        public State(int node,int weight,int edgesUsed){
            this.node=node;
            this.weight=weight;
            this.edgesUsed=edgesUsed;
        }
    }
    public static int  maxWeightUtil(ArrayList<Edge>[]graph,
                                     int src,int k,int edge,int weight,int t){
        if (edge == k) {
            return (weight < t) ? weight : Integer.MIN_VALUE;
        }
        int ans = Integer.MIN_VALUE;
        for(Edge e:graph[src]){
            ans = Math.max(ans,maxWeightUtil(graph,e.dest, k, edge + 1, weight +
                    e.weight,t));
        }
        return ans;
    }
    public static int maxWeight(int n, int[][] edges, int k, int t) {
    ArrayList<Edge>[]graph=new ArrayList[n];
    createGraph(graph,edges);
    int res=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
            int ans=maxWeightUtil(graph,i,k,0,0,t);
        res = Math.max(res, ans);
    }
    return  res == Integer.MIN_VALUE ? -1 : res;
    }
}
