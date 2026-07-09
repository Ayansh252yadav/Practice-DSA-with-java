package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class PathExistence3532 {
   static class Edge{
       int src;
       int dest;
       public Edge(int src,int dest){
           this.src=src;
           this.dest=dest;
       }
   }
   public static void createGraph(ArrayList<Edge>[]graph,int maxDiff,int []nums){
       for(int i=0;i<graph.length;i++){
           graph[i]=new ArrayList<Edge>();
       }
       for(int i=0;i<graph.length;i++){
           for(int j=i+1;j<graph.length;j++){
               if(Math.abs(nums[i]-nums[j])<=maxDiff){
                   graph[i].add(new Edge(i, j));
                   graph[j].add(new Edge(j, i));
               }
           }
       }
   }
   public static boolean isPath(ArrayList<Edge>[]graph,int src,int dest,boolean[] visited){
       if(src==dest){
           return true;
       }
       visited[src]=true;
       for(Edge e:graph[src]){
           if(!visited[e.dest]){
               if(isPath(graph,e.dest,dest,visited)){
                   return true;
               }
           }
       }
       return false;
   }
    public static boolean[] pathExistenceQueries(int n, int[] nums,
                                          int maxDiff, int[][] queries) {
       ArrayList<Edge>[]graph=new ArrayList[n];
       createGraph(graph,maxDiff,nums);
     boolean[]res=new boolean[queries.length];
     int i=0;
     for(int []e:queries){
         boolean[] visited = new boolean[n];
         res[i++] = isPath(graph, e[0], e[1], visited);
     }
     return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int []nums = {2,5,6,8};
        int maxDiff = 2;
        int [][]queries = {{0,1},{0,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(pathExistenceQueries(n,nums,maxDiff,queries)));
    }
}
