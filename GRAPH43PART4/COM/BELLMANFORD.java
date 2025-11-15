package GRAPH43PART4.COM;

import java.util.ArrayList;

public class BELLMANFORD {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static void creategraph(ArrayList<Edge> graph[]) {
     for(int i=0;i<graph.length;i++){
         graph[i]=new ArrayList<>();
     }
//     graph[0].add(new Edge(0,1,2));
//     graph[0].add(new Edge(0,2,4));
//     graph[1].add(new Edge(1,2,-4));
//     graph[2].add(new Edge(2,3,2));
//     graph[3].add(new Edge(3,4,4));
//     graph[4].add(new Edge(4,1,-1));
        //graph 4


    }

    public static void creategraph2(ArrayList<Edge> graph){
//        it other graph1
//        graph.add(new Edge(0,1,2));
//        graph.add(new Edge(0,2,4));
//        graph.add(new Edge(1,2,-4));
//        graph.add(new Edge(2,3,2));
//        graph.add(new Edge(3,4,4));
//        graph.add(new Edge(4,1,-1));
//        graph2
//        graph.add(new Edge(1,2,1));
//        graph.add(new Edge(2,1,-2));
//        graph.add(new Edge(2,3,1));
        //graph3
//        graph.add(new Edge(1,2,4));
//        graph.add(new Edge(1,3,5));
//        graph.add(new Edge(2,4,6));
//        graph.add(new Edge( 3,2,-4));
//        graph.add(new Edge(4,5,2));
//        graph.add(new Edge(4,3,3));
//        graph.add(new Edge(4,6,9));
//        graph.add(new Edge(5,7,1));
//        graph.add(new Edge(6,3,7));

        graph.add(new Edge(1,2,2));
        graph.add(new Edge(1,3,3));
        graph.add(new Edge(2,4,4));
        graph.add(new Edge(3,2,-2));
        graph.add(new Edge(4,3,5));
        graph.add(new Edge(4,5,1));
        graph.add(new Edge(4,6,2));
        graph.add(new Edge(5,7,2));
        graph.add(new Edge(6,7,1));
    }

    public static void bellmanFord2(ArrayList<Edge> graph, int src, int V) {
        int dist[]=new int[V];
        for(int i=0;i< dist.length;i++){
            if(i !=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        //algorithm-O(V*E)

        for(int i=0;i<V-1;i++){
            //edges-O(E)
            for(int j=0;j< graph.size();j++){

                    Edge e=graph.get(j);
                    //u,v,wt
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    //relaxation
                    if(dist[u] !=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
            }
        }
        for(int i=1;i< dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void bellmanFord(ArrayList<Edge> graph[],int src){
    int dist[]=new int[graph.length];
    for(int i=0;i< dist.length;i++){
        if(i !=src){
            dist[i]=Integer.MAX_VALUE;
        }
    }
    //algorithm-O(V*E)
        int V=graph.length;
    for(int i=0;i<V-1;i++){
        //edges-O(E)
        for(int j=0;j< graph.length;j++){
            for(int k=0;k<graph[j].size();k++){
                Edge e=graph[j].get(k);
                //u,v,wt
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                //relaxation
                if(dist[u] !=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
    }
    for(int i=0;i< dist.length;i++){
        System.out.print(dist[i]+" ");
    }
    }

    public static void main(String[] args) {
        int V=8;
//        ArrayList<Edge>graph[]=new ArrayList[V];
        ArrayList<Edge> edges=new ArrayList<>();//this is another way of creating graph
//        creategraph(graph);
        creategraph2(edges);
        bellmanFord2(edges,1,V);
//        bellmanFord(graph,0);
    }
}
