package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;

public class LargestColor1857 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph, int [][]edges){
       for(int i=0;i<graph.length;i++){
           graph[i]=new ArrayList<Edge>();
       }
       for(int []e:edges){
           graph[e[0]].add(new Edge(e[0],e[1]));
       }
    }
    public static boolean larPathnoCylce(
            ArrayList<Edge>[]graph,int src,
            boolean []vis,boolean[]stack,
            StringBuilder temp,
            String color,
            ArrayList<String>res
    ) {

        vis[src]=true;
        stack[src]=true;
        temp=temp.append(color.charAt(src));
        if(graph[src].isEmpty()){
            res.add(temp.toString());
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(stack[e.dest]){
                return false;
            }
            if(!vis[e.dest]){
                if(!larPathnoCylce(graph,e.dest,vis,stack,temp,color,res)){
                    return false;
                }
            }
        }
        stack[src]=false;
        vis[src]=false;
        temp.deleteCharAt(temp.length()-1);
        return true;
    }
    public static int largestPathValue(String colors, int[][] edges) {
     int n=colors.length();
     ArrayList<Edge>[]graph=new ArrayList[n];
     createGraph(graph,edges);
     ArrayList<String>res=new ArrayList<>();
     boolean []vis=new boolean[n];
     boolean []stack=new boolean[n];
     int maxColor=Integer.MIN_VALUE;
     for(int i=0;i<n;i++){
         if(!vis[i]){
             boolean isPath=larPathnoCylce(graph,i,vis,stack,new StringBuilder(),
                     colors,res);
             if(isPath){
                for(String str:res){
                    int []freq=new int[26];
                    for(int j=0;j<str.length();j++){
                        freq[str.charAt(j)-'a']++;
                    }
                    for(int e:freq){
                        maxColor=Math.max(maxColor,e);
                    }
                }
                res=new ArrayList<>();
             }else {
                 break;
             }
         }
     }
     return maxColor==Integer.MIN_VALUE?-1:maxColor;
    }

    public static void main(String[] args) {
      String colors = "abaca";
      int [][]edges = {{0,1},{0,2},{2,3},{3,4}};
        System.out.println(largestPathValue(colors,edges));
    }
}
