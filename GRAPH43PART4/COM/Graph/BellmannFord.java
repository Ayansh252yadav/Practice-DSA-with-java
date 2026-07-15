package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BellmannFord {
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
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmann(ArrayList<Edge>[]graph,int src){
        int []dist=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(src==i){
                continue;
            }
            dist[i]=Integer.MAX_VALUE;
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
              for(int k=0;k<graph[j].size();k++){
                  Edge e=graph[j].get(k);
                  int u=e.src;
                  int v=e.dest;
                  int wt=e.wt;
                  if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                      dist[v]=dist[u]+wt;
                  }
              }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
 public static void createGraph2(ArrayList<Edge> graph){
     graph.add(new Edge(0,1,2));
     graph.add(new Edge(0,2,4));

     graph.add(new Edge(1,2,-4));

     graph.add(new Edge(2,3,2));

     graph.add(new Edge(3,4,4));
     graph.add(new Edge(4,1,-1));
 }
 public static void bellmann2(ArrayList<Edge>graph,int src,int V){
        int []dist=new int[V];
        for(int i=0;i<dist.length;i++){
            if(src==i){
                continue;
            }
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.size();j++){
                Edge e=graph.get(j);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
     System.out.println(Arrays.toString(dist));
 }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[]graph=new ArrayList[v];

        createGraph(graph);
        bellmann(graph,0);
        ArrayList<Edge>edge=new ArrayList<Edge>();
        createGraph2(edge);
        bellmann2(edge,0,5);
    }
}





/*

static class Pair implements Comparable<Pair>{
        int node;
        int path;
        public Pair(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(Pair o) {
            return this.path-o.path;
        }
    }

public static void dijkstra(ArrayList<Edge>[]graph,int src){
    int []dist=new int[graph.length];
    for(int i=0;i<dist.length;i++){
        if(i==src){
            continue;
        }
        dist[i]=Integer.MAX_VALUE;
    }
    PriorityQueue<Pair>q=new PriorityQueue<Pair>();
    q.add(new Pair(src,0));
    while(!q.isEmpty()){
        Pair p=q.poll();
        for(int i=0;i<graph[p.node].size();i++){
            Edge e=graph[p.node].get(i);
            int u=e.src;
            int v=e.dest;
            int wt=e.wt;
            if(dist[u]+wt<dist[v]){
                dist[v]=dist[u]+wt;
                q.add(new Pair(v,dist[v]));
            }
        }
    }
}*/
