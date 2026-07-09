package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;

public class AllPathFromSourceTargetDFS {
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
        graph[0].add(new Edge(0,3));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,0));
    }
    public static void allPathsDFSutil(ArrayList<Edge>[]graph,int curr,int dest,String path){
      if(curr==dest){
          System.out.println(path+dest);
          return;
      }
      for(Edge e:graph[curr]){
              allPathsDFSutil(graph,e.dest,dest,path+curr);
          }
    }
    public static void allPaths(ArrayList<Edge>[]graph,int src,int dest){
       allPathsDFSutil(graph,src,dest,"");
    }

    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        int src=5;
        int dest=1;
        allPaths(graph,src,dest);
    }
}
