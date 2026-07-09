package GRAPH43PART4.COM;

import java.util.ArrayList;

public class NetworkRecoveryPathways3620 {
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
    public static void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:edges){
         graph[e[0]].add(new Edge(e[0],e[1],e[2]));
        }
    }
    public static long dfsUtil(ArrayList<Edge>[]graph,
                              boolean[] visited,int curr,boolean[]online,
                              int sum,long k,long min){
        if(curr==graph.length-1){
            return sum<=k?min:0;
        }
        if(!online[curr]){
            return 0;
        }
        visited[curr]=true;
        long best=-1;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dst] && online[e.dst] && sum+e.wt<=k){
                long newMin=Math.min(min,e.wt);
                long res= dfsUtil(graph,visited,e.dst,online,sum+e.wt,k,newMin);
                if(res!=-1){
                    best = Math.max(best,res);
                }
            }
        }
        visited[curr]=false;
        return best;
    }

    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
     int v= online.length;
     ArrayList<Edge>[]graph=new ArrayList[v];
     createGraph(graph,edges);
     boolean[] visited=new boolean[v];
     long path = dfsUtil(graph,visited,0,online,0,k,Long.MAX_VALUE);
        return (int) path;
    }

    public static void main(String[] args) {
        int [][]edges = {{0,1,5},{1,3,10},{0,2,3},{2,3,4}};
        boolean[]online = {true,true,true,true};
        int k = 10;
        System.out.println(findMaxPathScore(edges, online, k));
    }
}
