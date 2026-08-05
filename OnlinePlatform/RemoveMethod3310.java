package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class RemoveMethod3310 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge>[]graph, int [][]invocations){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:invocations){
            graph[e[0]].add(new Edge(e[0],e[1]));
        }
    }
    public void suspicious(ArrayList<Edge>[]graph,int src,
                           boolean[] visited,List<Integer>suspicious){
        visited[src]=true;
        suspicious.add(src);
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest]){
                suspicious(graph,e.dest,visited,suspicious);
            }
        }
    }
    public boolean remainingMethodsUtil(int [][]invocations,boolean []isSuspicious){
       for(int []e:invocations){
           int u=e[0];
           int v=e[1];
           if(isSuspicious[v] && !isSuspicious[u]){
               return false;
           }
       }
       return true;
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,invocations);

     List<Integer>suspicious=new ArrayList<>();
     suspicious(graph,k,new boolean[n],suspicious);

     boolean[]isSuspicious=new boolean[n];
     for(int x:suspicious){
         isSuspicious[x]=true;
     }
   boolean isRemove=remainingMethodsUtil(invocations,isSuspicious);
     List<Integer>result=new ArrayList<>();
     if(isRemove){
       for(int i=0;i<n;i++){
           if(!isSuspicious[i]){
               result.add(i);
           }
       }
     }else{
         for(int i=0;i<n;i++){
             result.add(i);
         }
     }
     return result;
    }
}
