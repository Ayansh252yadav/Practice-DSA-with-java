package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
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
    public static void prims(ArrayList<Edge>[]graph,int src){
        boolean[] visited=new boolean[graph.length];
        int cost=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                System.out.println(curr.node);
                cost+=curr.weight;
                for(Edge e:graph[curr.node]){
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("Cost of mst : "+cost);
    }

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        prims(graph,0);
    }
}
