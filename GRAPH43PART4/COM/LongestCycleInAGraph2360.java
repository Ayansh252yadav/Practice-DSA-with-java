package GRAPH43PART4.COM;

import java.util.ArrayList;
import java.util.List;

public class LongestCycleInAGraph2360 {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int []edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            if (edges[i] != -1) {
                graph[i].add(new Edge(i, edges[i]));
            }
        }
    }
    public static void detectLongestCycle(ArrayList<Edge>[]graph,int curr,
                                          boolean[]vis,boolean[]stack,
                                          List<List<Integer>>res,ArrayList<Integer>temp){
        vis[curr]=true;
        stack[curr]=true;
        temp.add(curr);
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                int idx = temp.indexOf(e.dest);
                res.add(new ArrayList<>(temp.subList(idx, temp.size())));
                stack[curr] = false;
                temp.remove(temp.size() - 1);
                return;
            }
            else if(!vis[e.dest]){
                detectLongestCycle(graph,e.dest,vis,stack,res,temp);
            }
        }
       stack[curr]=false;
        temp.remove(temp.size()-1);
    }
    public static int longestCycle(int[] edges) {
        int v=edges.length;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph,edges);
        boolean []vis=new boolean[v];
       boolean []stack=new boolean[v];
       List<List<Integer>>res=new ArrayList<>();
       for(int i=0;i<graph.length;i++){
           if(!vis[i]){
             detectLongestCycle(graph,i,vis,stack,res,new ArrayList<>());
           }
       }
       int max=Integer.MIN_VALUE;
        for(List<Integer>cycle:res){
          max=Math.max(cycle.size(),max);
        }
       return max;
    }
    public static void main(String[] args) {
       int [] edges = {3,3,4,2,3};
  longestCycle(edges);
    }
}
