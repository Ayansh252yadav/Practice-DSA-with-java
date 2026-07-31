package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PathMinEffort1631 {
    int minEffort=Integer.MAX_VALUE;
    public void minPAthUtil(int [][]heights,int i,int j,
                            boolean[][]vis,int currEffort){
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) {
            return;
        }

        if (vis[i][j]){
            return ;
        }
        // Destination reached
        if (i == heights.length - 1 && j == heights[0].length - 1) {
            minEffort = Math.min(minEffort, currEffort);
            return;
        }
        vis[i][j]=true;
        //up
       if(i-1>=0){
           int effort=Math.max(currEffort,
                   Math.abs(heights[i-1][j]-heights[i][j]));
           minPAthUtil(heights,i-1,j,vis,effort);
       }
       //down
        if(i+1<heights.length){
            int effort=Math.max(currEffort,
                    Math.abs(heights[i+1][j]-heights[i][j]));
            minPAthUtil(heights,i+1,j,vis,effort);
        }
        //left
        if(j-1>=0){
            int effort=Math.max(currEffort,
                    Math.abs(heights[j-1][j]-heights[i][j]));
            minPAthUtil(heights,j-1,j,vis,effort);
        }
        //right
        if(j+1<heights[0].length){
            int effort=Math.max(currEffort,
                     Math.abs(heights[i][j]-heights[i][j+1]));
            minPAthUtil(heights,i,j+1,vis,effort);
        }
        vis[i][j]=false;
    }
    public int minimumEffortPath(int[][] heights) {
       minEffort=Integer.MAX_VALUE;
       boolean[][] vis=new boolean[heights.length][heights[0].length];
       minPAthUtil(heights,0,0,vis,0);
       return minEffort;
    }
}
class DijKastra{
    static class Edge{
        int src;
        int dst;
        int wt;
        Edge(int src,int dst,int wt){
            this.src=src;
            this.dst=dst;
            this.wt=wt;
        }
    }
    public void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        int m=edges.length;
        int n=edges[0].length;
        for(int i=0;i<n*m;i++){
            graph[i]=new ArrayList<Edge>();
        }
        int []dr={-1,1,0,0};
        int []dc={0,0,-1,1};
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               for(int k=0;k<4;k++){
                   int nr=i+dr[k];
                   int nc=j+dc[k];
                   if(nr>=0&&nr<m&&nc>=0&&nc<n){
                       int wt=Math.abs(edges[i][j]-edges[nr][nc]);
                       int src = i * n + j;
                       int dst = nr * n + nc;
                     graph[src].add(new Edge(src,dst,wt));
                   }
               }
           }
       }
    }
    static class Info implements Comparable<Info>{
        int node;
        int cost;
        public Info(int node,int cost){
            this.node=node;
            this.cost=cost;
        }

        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }
    public int minPathUtil(ArrayList<Edge>[]graph,int src,int dst) {
        boolean[] visited=new boolean[graph.length];
        int []dist=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        pq.add(new Info(src,0));
        while(!pq.isEmpty()){
            Info curr=pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dst;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE &&dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Info(v,dist[v]));
                    }
                }
            }
        }
        return dist[dst];
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        ArrayList<Edge>[]graph=new ArrayList[m*n];
        createGraph(graph,heights);
      return   minPathUtil(graph,0,n*m-1);
    }
}
