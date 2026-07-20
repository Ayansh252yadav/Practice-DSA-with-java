package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Distancebus1184 {
    static class Edge{
        int src;
        int dst;
        int weight;
        public Edge(int src,int dst,int weight){
            this.src=src;
            this.dst=dst;
            this.weight=weight;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int []distance){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<graph.length-1;i++){
            graph[i].add(new Edge(i,i+1,distance[i]));
            graph[i+1].add(new Edge(i+1,i,distance[i]));
        }
        graph[graph.length-1]
                .add(new Edge(graph.length-1, 0,distance[distance.length-1]));
    }
    static class Pair implements Comparable<Pair>{
     int node;
        int weight;
        public Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
    public static int dijkstra(ArrayList<Edge>[]graph,int start,int end){
        int []dist=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(start,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if (curr.weight > dist[curr.node]) {
                continue;
            }
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.src;
                int v=e.dst;
                int wt=e.weight;
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new Pair(v,dist[v]));
                }
            }
        }
        return dist[end];
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        ArrayList<Edge>[]graph=new ArrayList[distance.length];
        createGraph(graph,distance);
        return dijkstra(graph,start,destination);
    }
}
