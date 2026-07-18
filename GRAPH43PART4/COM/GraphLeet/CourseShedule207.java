package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseShedule207 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,int [][]prerequisites){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:prerequisites){
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
    }
    public static void indeCalc(ArrayList<Edge>[]graph,int []indeg){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topUtil(ArrayList<Edge>[]graph,
                               ArrayList<Integer>res){
        int []indeg=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();
        indeCalc(graph,indeg);
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<Edge>[]graph=new ArrayList[numCourses];
    createGraph(graph,prerequisites);
    ArrayList<Integer> res=new ArrayList<>();
    topUtil(graph,res);
    return numCourses==res.size();
    }
}
