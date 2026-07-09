package GRAPH43PART4.COM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSheduleII210 {
    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
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
    public static void calcInde(ArrayList<Edge>[]graph,int []indeg){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static int topBfs(ArrayList<Edge>[]graph,int[]indeg,int []res){
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[i++]=curr;
            for(int j=0;j<graph[curr].size();j++){
                Edge e=graph[curr].get(j);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.offer(e.dest);
                }
            }
        }
        return i;
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    int []indeg=new int[numCourses];
    int [] res=new int[numCourses];
    ArrayList<Edge>[]graph=new ArrayList[numCourses];
    createGraph(graph,prerequisites);
    calcInde(graph,indeg);
    int i=topBfs(graph,indeg,res);
    if(i!=numCourses-1){
        return new int[0];
    }
    return res;
    }

    public static void main(String[] args) {
      int   numCourses = 2;
      int [][]prerequisites = {{1,0}};
        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }
}
