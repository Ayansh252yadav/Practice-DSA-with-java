package OnlinePlatform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountNumOfCompleCompoGraph2685 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1]));
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
    }
    public static int [] componentUtil(ArrayList<Edge>[]graph,int src,boolean[] visited){
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        int vertices=0;
        int edges=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(!visited[curr]){
                vertices++;
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                        q.add(e.dest);
                        edges++;
                }
            }
        }
        return new int[]{vertices,edges/2};
    }
    public static int countCompleteComponents(int n, int[][] edges) {
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,edges);
     boolean []vis=new boolean[n];
     int count=0;
     for(int i=0;i<n;i++){
         if(!vis[i]){
            int []res=componentUtil(graph,i,vis);
             if(res[0]*(res[0]-1)/2==res[1]){
                 count++;
             }
         }
     }
     return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int [][]edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(countCompleteComponents(n,edges));
    }
}
