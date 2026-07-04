package GRAPH43PART4.COM;

import java.util.ArrayList;

public class MinimumScoreOfAPAth2492 {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]roads,int n){
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e:roads){
            graph[e[0]].add(new Edge(e[0], e[1], e[2]));
            graph[e[1]].add(new Edge(e[1], e[0], e[2]));
        }
    }
    public static int minPath(ArrayList<Edge>[]graph,int answer,int src,int dest,boolean []visted){
        visted[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            answer=Math.min(answer,e.wt);
            if(!visted[e.dest]){
             answer=   minPath(graph,answer,e.dest,dest,visted);
            }
        }
        return answer;
    }
    public int minScore(int n, int[][] roads) {
    int v=roads.length;
    ArrayList<Edge> []graph=new ArrayList[n+1];
    createGraph(graph,roads,n);
    return minPath(graph,Integer.MAX_VALUE,0,n,new boolean[n+1]);
    }

    public static void main(String[] args) {

    }
}
