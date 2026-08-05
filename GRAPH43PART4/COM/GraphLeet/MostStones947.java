package GRAPH43PART4.COM.GraphLeet;

import java.util.ArrayList;

public class MostStones947 {

    public void createGraph(ArrayList<Integer>[]graph,int[][] stones){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0]==stones[j][0] ||
                        stones[i][1]==stones[j][1]){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
    }
    public void dfs(ArrayList<Integer>[]graph,int src,boolean[] visited){
        visited[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Integer edge=graph[src].get(i);
            if(!visited[edge]){
                dfs(graph, edge, visited);
            }
        }
    }
    public int removeStones(int[][] stones) {
        ArrayList<Integer>[]graph=new ArrayList[stones.length];
        createGraph(graph,stones);

     boolean[]visited=new boolean[stones.length];
         int component=0;
     for(int i=0;i<stones.length;i++){
         if(!visited[i]){
             dfs(graph,i,visited);
             component++;
         }
     }
     return stones.length-component;
    }
}
