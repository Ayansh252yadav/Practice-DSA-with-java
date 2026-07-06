package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalOnGraphCompnent extends DFSTraversalOnConnectedComponentGraph{
    public static void bfsUtil(ArrayList<Edge>[]graph,int src,boolean[]vis){
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.println(curr);
                vis[curr]=true;
                for(int j=0;j<graph[curr].size();j++){
                    Edge e=graph[curr].get(j);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void BFSTraversal(ArrayList<Edge>[]graph,int src){
        boolean []vis=new boolean[graph.length];
      for(int i=src;i<graph.length;i++){
         bfsUtil(graph,i,vis);
      }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        BFSTraversal(graph,0);
    }
}
