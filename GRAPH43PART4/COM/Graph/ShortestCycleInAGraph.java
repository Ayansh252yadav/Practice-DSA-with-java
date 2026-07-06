package GRAPH43PART4.COM.Graph;

import java.util.*;

public class ShortestCycleInAGraph {
    static class Edge{
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]edges){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e:edges){
            graph[e[0]].add(new Edge(e[0],e[1]));
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
    }
    public static void findIsCycle(ArrayList<Edge>[]graph,int curr,int par,boolean[]vis,
                                   List<List<Integer>>res,ArrayList<Integer>temp){
        vis[curr]=true;
        temp.add(curr);
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.des] && e.des!=par){
                int idx=temp.indexOf(e.des);
                res.add(new ArrayList<>(temp.subList(idx,temp.size())));
                vis[curr]=false;
                temp.remove(temp.size()-1);
                return;
            }
            if(!vis[e.des]){
               findIsCycle(graph,e.des,curr,vis,res,temp);
            }
        }
        vis[curr]=false;
        temp.remove(temp.size()-1);
    }
    public static int findShortestCycle(int n, int[][] edges) {
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,edges);
     boolean []vis=new boolean[n];
     int ans=Integer.MAX_VALUE;
     for(int i=0;i<graph.length;i++){
         if(!vis[i]){
          ans=   bfsCycle(graph,i,vis);
         }
     }
     return ans==Integer.MAX_VALUE?-1:ans;
    }
   public static int bfsCycle(ArrayList<Edge>[]graph,int src,boolean[]vis){
        int []dist=new int[graph.length];
        int par[]=new int[graph.length];
       Arrays.fill(par,-1);
       int ans=Integer.MAX_VALUE;
       Queue<Integer>q=new LinkedList<>();
       q.add(src);
       while (!q.isEmpty()){
           int curr=q.remove();
           if(!vis[curr]){
               vis[curr]=true;
               for(int i=0;i<graph[curr].size();i++){
                   Edge e=graph[curr].get(i);
                   if(!vis[e.des]){
                       dist[e.des] = dist[curr] + 1;
                       par[e.des] = curr;
                   }else if(par[curr]!=e.des){
                       ans = Math.min(ans,
                               dist[curr] + dist[e.des] + 1);
                   }
               }
           }
       }
       return ans;
   }
    public static void main(String[] args) {

    }
}
