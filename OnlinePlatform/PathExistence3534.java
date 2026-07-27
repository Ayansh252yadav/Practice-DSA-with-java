package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathExistence3534 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int n,
                                   int []nums,int maxDiff){
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(Math.abs(nums[i]-nums[j])<=maxDiff){
                    graph[i].add(new Edge(i,j));
                    graph[j].add(new Edge(j,i));
                }
            }
        }
    }

    public static int bfs(ArrayList<Edge>[]graph,int src,int dest,
                           boolean[]visited){
        int []dist=new int[graph.length];
        Arrays.fill(dist,-1);
        dist[src]=0;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        int cost=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            if (curr == dest) {
                return dist[curr];
            }
               for(int i=0;i<graph[curr].size();i++) {
                   Edge e = graph[curr].get(i);
                   if (!visited[e.dest]) {
                       queue.add(e.dest);
                       visited[e.dest] = true;
                       dist[e.dest] = dist[curr] + 1;
                   }
               }
        }
        return  dist[dest];
    }
    public int[] pathExistenceQueries(int n, int[] nums,
                                      int maxDiff, int[][] queries) {
        ArrayList<Edge>[]graph=new ArrayList[n];
        createGraph(graph,n,nums,maxDiff);
        int []res=new int[queries.length];
        int i=0;
     for(int []e:queries){
         int src=e[0];
         int dest=e[1];
         boolean[] visited=new boolean[n];
      res[i++]=bfs(graph,src,dest,visited);
     }
     return res;
    }
}
