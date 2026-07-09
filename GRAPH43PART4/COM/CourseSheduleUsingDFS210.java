package GRAPH43PART4.COM;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class CourseSheduleUsingDFS210{
    static class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int [][]prerequisites){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        for(int []e:prerequisites){
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
    }
    public static boolean topDFS(ArrayList<Edge>[]graph, int curr,boolean[]vis,
                              ArrayDeque<Integer>st,boolean []stack){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
              if(!vis[e.dest]){
                if(topDFS(graph,e.dest,vis,st,stack)){
                    return true;
                }
            }
        }
        st.push(curr);
        stack[curr]=false;
        return false;
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
     ArrayList<Edge>[]graph=new ArrayList[numCourses];
     createGraph(graph,prerequisites);
     ArrayDeque<Integer>st=new ArrayDeque<>();
    boolean []vis=new boolean[numCourses];
    boolean []stack=new boolean[numCourses];
    for(int i=0;i<numCourses;i++){
        if(!vis[i]){
            if(topDFS(graph,i,vis,st,stack)){
                return new int[0];
            }
        }
    }
    int []res=new int[numCourses];
    int i=0;
    while(!st.isEmpty()){
        res[i++]=st.pop();
    }
     return res;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int [][]prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));
    }
}
