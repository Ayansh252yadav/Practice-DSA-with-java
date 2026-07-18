package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BellmannFordre {
    static class Edge {
        int src;
        int dest;
        int wt;
        Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
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
    public static void dijkstra(ArrayList<Edge>[]graph,int src,boolean[]vis){
        int []dist=new int[graph.length];
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(src,0));
        for(int i=0;i<graph.length;i++){
            if(i==src){
                dist[i]=0;
            }
            dist[i]=Integer.MAX_VALUE;
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            if(!vis[node]) {
                vis[node]=true;
                for (int j = 0; j < graph[node].size(); j++) {
                    Edge e = graph[node].get(j);
                    int wt = e.wt;
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        q.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
    }
    public static void bellmannFordre(ArrayList<Edge>[]graph,int src){
        int []dist=new int[graph.length];
        for(int i=0;i<dist.length;i++){
            if(i==src){
                dist[i]=0;
            }
            dist[i]=Integer.MAX_VALUE;
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j< graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
    }
}
