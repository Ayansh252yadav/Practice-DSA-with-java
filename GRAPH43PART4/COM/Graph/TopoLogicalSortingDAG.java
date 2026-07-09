package GRAPH43PART4.COM.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class TopoLogicalSortingDAG {
   static class Edge{
       int src;
       int dest;
       public Edge(int src,int dest){
           this.src=src;
           this.dest=dest;
       }
   }
   public static void createGraph(ArrayList<Edge>[]graph){
       for(int i=0;i<graph.length;i++){
           graph[i]=new ArrayList<>();
       }
       graph[2].add(new Edge(2,3));
       graph[3].add(new Edge(3,1));
       graph[5].add(new Edge(5,2));
       graph[5].add(new Edge(5,0));
       graph[4].add(new Edge(4,1));
       graph[4].add(new Edge(4,0));
   }

   public static void topSortUtil(ArrayList<Edge>[]graph,boolean []vis,
                                  ArrayDeque<Integer>stack,int curr){
       vis[curr]=true;
       for(int i=0;i<graph[curr].size();i++){
           Edge e=graph[curr].get(i);
           if(!vis[e.dest]){
               topSortUtil(graph,vis,stack,e.dest);
           }
       }
       stack.push(curr);
   }
   public static void topSort(ArrayList<Edge>[]graph){
       boolean[] vis=new boolean[graph.length];
       ArrayDeque<Integer> stack=new ArrayDeque<>();
       for(int i=0;i<graph.length;i++){
           if(!vis[i]){
             topSortUtil(graph,vis,stack,i);
           }
       }
       while (!stack.isEmpty()){
           System.out.println(stack.pop());
       }
   }
    public static void main(String[] args) {
   int v=6;
   ArrayList<Edge>[]graph=new ArrayList[v];
   createGraph(graph);
   topSort(graph);
    }
}
