package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinCostToConnectAllPath1584 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public void createGraph(ArrayList<Edge>[]graph,int [][]points){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int wt=Math.abs(points[i][0]-points[j][0])
                        +Math.abs(points[i][1]-points[j][1]);
            graph[i].add(new Edge(i,j, wt));
            graph[j].add(new Edge(j,i, wt));
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
    public static int minCostToConnectAllPaths(ArrayList<Edge>[]graph,int src){
        Boolean[] visited=new Boolean[graph.length];
        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.offer(new Info(src,0));
        int cost=0;
        while(!pq.isEmpty()){
            Info curr=pq.poll();
            if(!visited[curr.v]){
                visited[curr.v]=true;
                cost+=curr.cost;
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    if(!visited[e.dest]){
                        pq.offer(new Info(e.dest,e.wt));
                    }
                }
            }
        }
        return cost;
    }
    public int minCostConnectPoints(int[][] points) {
     int n=points.length;
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,points);
     return minCostToConnectAllPaths(graph,0);
    }
}
