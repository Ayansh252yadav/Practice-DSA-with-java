package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingCitiesUsingPrims {
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
    public static void createGraph(ArrayList<Edge>[]graph,int [][]cities){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<cities.length;i++){
            for(int j=0;j<cities.length;j++){
                if(cities[i][j]!=0){
                graph[i].add(new Edge(i,j,cities[i][j]));
                }
            }
        }
    }
    static class Info implements Comparable<Info>{
        int v;
        int cost;
        public Info(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Info o) {
            return this.cost-o.cost;
        }
    }
    public static void prims(ArrayList<Edge>[]graph,int src){
        PriorityQueue<Info> q=new PriorityQueue<>();
        boolean[] visited=new boolean[graph.length];
        int cost=0;
        q.add(new Info(src,0));
        while(!q.isEmpty()){
            Info temp=q.poll();
            if(!visited[temp.v]){
                visited[temp.v]=true;
                cost+=temp.cost;
                for(Edge e:graph[temp.v]){
                    if(!visited[e.dest]){
                        q.add(new Info(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        int [][]cities={{0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}};
        ArrayList<Edge>[]graph=new ArrayList[cities.length];
        createGraph(graph,cities);
        prims(graph,0);
        System.out.println(ConnectingCities.connectCities(cities));
    }
}
class  ConnectingCities{
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        public Edge(int dest,int cost){
            this.dest=dest;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
    public static int connectCities(int [][]cities){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean[] visited=new boolean[cities.length];
        pq.add(new Edge(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Edge curr=pq.poll();
            if(!visited[curr.dest]){
                visited[curr.dest]=true;
                cost+=curr.cost;
                for(int i=0;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge(i,cities[curr.dest][i]));
                    }
                }
            }
        }
        return cost;
    }
}
