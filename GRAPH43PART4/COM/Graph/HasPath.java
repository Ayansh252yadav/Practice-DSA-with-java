package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;

public class HasPath extends DFSTraversal{
    public static boolean hasPath(ArrayList<Edge>[]graph,int src,int dest,boolean[]visted){
        if(src==dest){
            return true;
        }
        visted[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visted[e.dest] && hasPath(graph,e.dest,dest,visted)){
               return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        System.out.println(hasPath(graph,0,5,new boolean[v]));
    }
}
