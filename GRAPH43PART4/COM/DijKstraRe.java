package GRAPH43PART4.COM;

import java.util.*;

public class DijKstraRe {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,5,5));
        graph[4].add(new Edge(4,3,2));
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int path;
        public Pair(int node, int path){
            this.node = node;
            this.path = path;
        }
        @Override
        public int compareTo(Pair o) {
            return this.path - o.path;
        }
    }
    public static void dfs(ArrayList<Edge>[]graph, int src){
       int []dist=new int[graph.length];
       for(int i = 0; i < graph.length; i++){
           if(i!=src){
               dist[i]=Integer.MAX_VALUE;
           }
       }
       boolean []visited=new boolean[graph.length];
       PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e =graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge>[]graph,
                                       int src, boolean[] visited,
                                       Stack<Integer> stack){
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e =graph[src].get(i);
            if(!visited[e.dest]){
                topologicalSortUtil(graph,e.dest,visited,stack);
            }
        }
        stack.push(src);
    }
    public static void topologicalSort(ArrayList<Edge>[]graph){
        boolean[] visited=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topologicalSortUtil(graph,i,visited,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void indegreeCalc(ArrayList<Edge>[]graph, int []indegree){
        for(int i=0;i< graph.length;i++){
            for(int j=0;j< graph[i].size();j++){
                Edge e=graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topoLogicalBfs(ArrayList<Edge>[]graph){
        int []indegree=new int[graph.length];
        indegreeCalc(graph,indegree);
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(Edge e:graph[curr]){
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        createGraph(graph);
        topologicalSort(graph);
        topoLogicalBfs(graph);
    }
}
