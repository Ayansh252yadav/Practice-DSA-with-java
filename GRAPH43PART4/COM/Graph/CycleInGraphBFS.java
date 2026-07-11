package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInGraphBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[1].add(new Edge(1, 9));
        graph[1].add(new Edge(1, 5));

        graph[9].add(new Edge(9, 5));
        graph[9].add(new Edge(9, 1));

        graph[5].add(new Edge(5, 9));
        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));

        graph[2].add(new Edge(2, 5));
        graph[2].add(new Edge(2, 4));

        graph[4].add(new Edge(4, 2));
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph, int curr, int par,
                                  boolean[] vis) {
        vis[curr] = true;
        par = curr;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] && e.dest != par) {
                return true;
            } else if (!vis[e.dest]) {
                if (dfsUtil(graph, e.dest, par, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsDirectedCycle(ArrayList<Edge>[] graph, int curr,
                                           boolean[] stack, boolean[] vis) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!vis[e.dest]) {
                if (dfsDirectedCycle(graph, e.dest, stack, vis)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean bfsUtil(ArrayList<Edge>[]graph,int src,boolean[]vis){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,-1));
        vis[src]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int curr=p.node;
            int par=p.parent;
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(vis[e.dest] &&  e.dest!=par){
                        return true;
                }
                if(!vis[e.dest]){
                    vis[e.dest]=true;
                    q.add(new Pair(e.dest,curr));
                }
            }
        }
        return false;
    }

    public static boolean bfsCycle(ArrayList<Edge>[]graph){
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(bfsUtil(graph,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
     int v=10;
     ArrayList<Edge>[] graph=new ArrayList[v];
     createGraph(graph);
        System.out.println(bfsCycle(graph));
    }
}
