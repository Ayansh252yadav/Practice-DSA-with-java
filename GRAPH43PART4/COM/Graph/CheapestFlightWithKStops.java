package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops {
    static class Edge{
        int from;
        int to;
        int price;
        public Edge(int from,int to,int price){
            this.from=from;
            this.to=to;
            this.price=price;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,100));
        graph[0].add(new Edge(0,2,500));
        graph[1].add(new Edge(1,2,100));
    }
    static class Pair implements Comparable<Pair>{
        int from;
        int price;
        int stops;
        public Pair(int from,int price,int stops){
            this.from=from;
            this.price=price;
            this.stops=stops;
        }

        @Override
        public int compareTo(Pair o) {
            return this.stops - o.stops;
        }
    }
    public static int dijKstra(ArrayList<Edge>[]graph,int src,int dest,
                                int k){
        int []dist=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int from=curr.from;
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[from].size();i++){
                Edge e=graph[from].get(i);
                int u=e.from;
                int v=e.to;
                int price=e.price;
                if(dist[u] != Integer.MAX_VALUE && curr.price + price < dist[v]){
                    dist[v]=curr.price+price;
                    pq.add(new Pair(v,dist[v],curr.stops+1));
                }
            }
        }
        return dist[dest];
    }
    public static void main(String[] args) {
        int v=3;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        System.out.println( dijKstra(graph,0,2,1));
    }
}
