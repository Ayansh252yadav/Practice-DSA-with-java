package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfWays1976 {
    static int MOD=1_000_000_007;
    static class Edge{
        int src;
        int dest;
        int time;
        public Edge(int src, int dest, int time){
            this.src=src;
            this.dest=dest;
            this.time=time;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int[][]roads){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:roads){
            graph[e[0]].add(new Edge(e[0],e[1],e[2]));
            graph[e[1]].add(new Edge(e[1],e[0],e[2]));
        }
    }
    static class Info implements Comparable<Info>{
        int v;
        long w;
        public Info(int v,long w){
            this.v=v;
            this.w=w;
        }
        @Override
        public int compareTo(Info o) {
            return Long.compare(this.w,o.w);
        }
    }
    public static long countPathUtil(ArrayList<Edge>[]graph,
                                     int src,int dest){
        long []dist=new long[graph.length];
        long []ways=new long[graph.length];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(0,0));
        while(!pq.isEmpty()){
            Info curr=pq.poll();
            if(curr.w > dist[curr.v]){
                continue;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int time=e.time;
                long newDist=dist[u]+time;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new Info(v, newDist));
                }
                else if (newDist == dist[v]) {
                    ways[v] =(ways[v]+ ways[u])%MOD;
                }
            }
        }
        return ways[dest];
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Edge>[]graph=new ArrayList[n];
        createGraph(graph,roads);
      return (int)countPathUtil(graph,0,n-1);
    }
}
