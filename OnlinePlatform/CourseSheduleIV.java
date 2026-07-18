package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class CourseSheduleIV {
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,
                                   int [][]prerequisites){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:prerequisites){
            graph[e[0]].add(new Edge(e[0],e[1]));
        }
    }
    public static boolean find(ArrayList<Edge>[]graph,int src,int dest,boolean[] visited){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.dest]){
                if(find(graph,e.dest,dest,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static List<Boolean> checkIfPrerequisite(int numCourses,
                                                    int[][] prerequisites, int[][] queries) {
     ArrayList<Edge>[]graph=new ArrayList[numCourses];
     createGraph(graph,prerequisites);
     List<Boolean> result=new ArrayList<>();
     for(int []e:queries){
         boolean[] visited=new boolean[numCourses];
         if(find(graph,e[0],e[1],visited)){
             result.add(true);
         }else{
             result.add(false);
         }
     }
     return result;
    }

    public static void main(String[] args) {
        int numCourses = 2;

        int[][] prerequisites = {
                {1, 0}
        };

        int[][] queries = {
                {0, 1},
                {1, 0}
        };
        System.out.println(checkIfPrerequisite(numCourses,prerequisites,queries));
    }
}
