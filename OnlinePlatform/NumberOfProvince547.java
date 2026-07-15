package OnlinePlatform;

import java.util.ArrayList;

public class NumberOfProvince547 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]connected){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<connected.length;i++){
            for(int j=0;j<connected[i].length;j++){
                if(connected[i][j]==1){
                    graph[i].add(new Edge(i,j));
                    graph[j].add(new Edge(j,i));
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[]graph,int curr,boolean[]vis){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected) {
    int n=isConnected.length;
    boolean[] visited=new boolean[n];
    ArrayList<Edge>[]graph=new ArrayList[n];
    createGraph(graph,isConnected);
    int count=0;
    for(int i=0;i<n;i++){
        if(!visited[i]){
            dfs(graph,i,visited);
            count++;
        }
    }
    return count;
    }

    public static void main(String[] args) {
       int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
