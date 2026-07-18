package GRAPH43PART4.COM.GraphLeet;

import java.util.*;

public class FindEventualSafeState802 {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]edges, int [][]graph){
        for(int i=0;i<edges.length;i++){
            edges[i]=new ArrayList<Edge>();
        }
       for(int i=0;i<graph.length;i++){
          for(int j=0;j<graph[i].length;j++){
              edges[i].add(new Edge(i,graph[i][j]));
          }
       }
    }
    public static void calcTerminal(ArrayList<Edge>graph[],boolean []terminal){
        for(int i=0;i<graph.length;i++){
           if(graph[i].isEmpty()){
               terminal[i]=true;
           }
        }
    }
   public static void topDFS(ArrayList<Edge>[]graph, int src,
                             boolean[]vis, Stack<Integer> st){
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge edge=graph[src].get(i);
            if(!vis[edge.dest]){
                topDFS(graph,edge.dest,vis,st);
            }
        }
        st.push(src);

   }
   public static boolean isSafe(ArrayList<Edge>[]graph,int node,int []color){
        if(color[node]==1){
            return false;
        }
        if(color[node]==0){
            return true;
        }
        color[node]=1;
        for(Edge edge:graph[node]){
            if(!isSafe(graph,edge.dest,color)){
                return false;
            }
        }
      color[node]=0;
        return true;
   }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
          /*
    -1=unvisited
    1=visited
    0=safe
     */
    int []color=new int[graph.length+1];
    Arrays.fill(color,-1);
    ArrayList<Edge>[]edges=new ArrayList[graph.length];
    ArrayList<Integer>ans=new ArrayList<>();
    createGraph(edges,graph);
     for(int i=0;i<edges.length;i++){
         if(isSafe(edges,i,color)){
             ans.add(i);
         }
     }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int [][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
}
