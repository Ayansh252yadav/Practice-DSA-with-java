package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphTraversal {
   static class Edge{
       int src;
       int dest;

       public Edge(int src, int dest) {
           this.src = src;
           this.dest = dest;
       }
   }
   public static void createGraph(ArrayList<Edge>[]graph){
       for(int i=0;i<graph.length;i++){
           graph[i]=new ArrayList<>();
       }
       //vertex0
       graph[0].add(new Edge(0,1));
       graph[0].add(new Edge(0,2));
       //vertex 1
       graph[1].add(new Edge(1,3));
       graph[1].add(new Edge(1,0));
       //vertex2
       graph[2].add(new Edge(2,4));
       graph[2].add(new Edge(2,0));
       //vertex3
       graph[3].add(new Edge(3,2));
       graph[3].add(new Edge(3,4));
       graph[3].add(new Edge(3,5));
       //vertex4
       graph[4].add(new Edge(4,2));
       graph[4].add(new Edge(4,3));
       graph[4].add(new Edge(4,5));
       //vertex
       graph[5].add(new Edge(5,3));
       graph[5].add(new Edge(5,4));
       graph[5].add(new Edge(5,6));
       //vertex
       graph[6].add(new Edge(6,5));
   }
   public static void bfsTraversal(ArrayList<Edge>[]graph){
       boolean[]vis=new boolean[graph.length];
       Queue<Integer>q=new LinkedList<>();
       q.add(0);
       while(!q.isEmpty()){
           int curr=q.remove();
           if(!vis[curr]){
               System.out.print(curr+" ");
               vis[curr]=true;
              for(int i=0;i<graph[curr].size();i++){
                  Edge e=graph[curr].get(i);
                  q.add(e.dest);
              }
           }
       }
   }
    public static void main(String[]args){
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        bfsTraversal(graph);
    }
}
