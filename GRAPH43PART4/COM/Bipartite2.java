package GRAPH43PART4.COM;

import GRAPH43PART4.COM.Graph.BipartiteGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite2 {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,2));
    }
    public static boolean isBipartitebfs(ArrayList<Edge>[]graph,int src,
                                         int []color,Queue<Integer>q){
        while(!q.isEmpty()){
            int curr=q.poll();
           for(Edge e:graph[curr]){
               if(color[e.dest]==-1){
                   int nextColor=color[curr]==0?1:0;
                   color[e.dest]=nextColor;
                   q.add(e.dest);
               }else if(color[e.dest]==color[curr]){
                   return false;
               }
           }
        }
        return true;
    }
    public static boolean isBipartite(ArrayList<Edge>[]graph){
        int []color=new int[graph.length];
        Arrays.fill(color,-1);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i< graph.length;i++){
            if(color[i]==-1){
                q.add(i);
                if(isBipartitebfs(graph,i,color,q)){
                    return true;
                }
            }
        }
        return false;
    }
}
