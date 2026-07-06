package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;

public class DFSTraversalOnConnectedComponentGraph {
    static class Edge{
        Integer src;
        Integer dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
 public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,4));
        graph[6].add(new Edge(0,0));
 }
 public static   void dfsUtil(ArrayList<Edge>[]graph,int src,boolean[]vis){
        vis[src]=true;
     System.out.println(src);
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
 }
 public static void dfs(ArrayList<Edge>[]graph,int src){
        boolean []visited=new boolean[graph.length];
        for(int i=src;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph,i,visited);
            }
        }
 }
    public static void main(String[] args) {
         /*      0 ----- 1
                |       |
                2 ----- 3

                4 ----- 5

                6
          */
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        dfs(graph,0);
    }
}
