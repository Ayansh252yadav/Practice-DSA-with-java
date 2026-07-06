package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
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
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,2));
    }

    public static boolean bipartiteUtil(Queue<Integer>q,ArrayList<Edge>[]graph,int src,int []color){
        while (!q.isEmpty()){
            int curr=q.remove();
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    if(color[e.dest]==-1){
                           int nextColor=color[curr]==0?1:0;
                           color[e.dest]=nextColor;
                            q.add(e.dest);
                    }
                    if(color[e.dest]==color[curr]){
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
                if(bipartiteUtil(q,graph,i,color)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
//                0 ----- 1
//                |       |
//                |       |
//                3 ----- 2

        //here
//        0-------> yellow
//        1------->blue
//       -1------>no color
        int v=4;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
