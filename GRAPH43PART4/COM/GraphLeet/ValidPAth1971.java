package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPAth1971 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1]));
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
    }
    public static boolean path(ArrayList<Edge>[]graph,int src,int dest,
                               boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==dest){
                return true;
            }
            if(!visited[cur]){
                visited[cur]=true;
                for(Edge e:graph[cur]){
                    if(!visited[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
        return false;
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,edges);
     boolean[] visited=new boolean[n];
     if(path(graph,source,destination,visited)){
         return true;
     }
     return false;
    }
    public long removeZeros(long n) {
        StringBuilder sb=new StringBuilder(Long.toString(n));
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0'){
                sb.deleteCharAt(i);
            }
        }
        return Long.parseLong(sb.toString());
    }
    public static int[] decimalRepresentation(int n) {
      StringBuilder sb=new StringBuilder(Integer.toString(n));
      ArrayList<Integer> list=new ArrayList<>();
     for(int i=0;i<sb.length();i++){
         if(sb.charAt(i)!='0'){
             list.add((sb.charAt(i)-'0')*((int)Math.pow(10,sb.length()-1-i)));
         }
     }
     int []res=new int[list.size()];
     for(int i=0;i<list.size();i++){
         res[i]=list.get(i);
     }
     return res;
    }
    public static void main(String[] args) {
//      int   n = 3;
//      int [][]edges = {{0,1},{1,2},{2,0}};
//      int source = 0;
//      int destination = 2;
//
//        System.out.println(validPath(n,edges,source,destination));
        System.out.println(Arrays.toString(decimalRepresentation(537)));
    }
}
