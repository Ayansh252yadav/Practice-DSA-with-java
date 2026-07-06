package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;

public class CycleDetectionUsingDFS {
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
    public static boolean detectCycleUtil(ArrayList<Edge>[]graph,int curr,int par,boolean[]vis){
       vis[curr]=true;
      for(int i=0;i<graph[curr].size();i++){
          Edge e=graph[curr].get(i);
          //case 3
          if(!vis[e.dest]){
              if(detectCycleUtil(graph,e.dest,curr,vis)){
              return true;
              }
          }
          //case1
           else if (vis[e.dest] && e.dest!=par) {
             return true;
          }
           //case 2 do nothing just continue
      }
      return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[]graph,int src){
        boolean []vis=new boolean[graph.length];
        for(int i=src;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,i,-1,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
   int v=7;
   ArrayList<Edge>[]graph=new ArrayList[v];
   createGraph(graph);
        System.out.println(detectCycle(graph,0));
    }
}
