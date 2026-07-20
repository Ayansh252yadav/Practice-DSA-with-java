package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class wordLadder127 {
    static class Edge{
        int s;
        String src;
        String dest;
        public Edge(int s,String src, String dest){
            this.s=s;
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[]graph,
                                   List<String>list,String begin){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,begin,list.get(0)));
        for(int i=1;i<list.size();i++){
            graph[i].add(new Edge(1,list.get(i-1),list.get(i)));
        }
    }
    public static int ladderUtil(ArrayList<Edge>[]graph,
                                 boolean[]vis,String src,String dest,int step,int s){
        if(src.equals(dest)){
            return step;
        }
        vis[s]=true;
        for(int i=0;i<graph[s].size();i++){
            Edge e=graph[s].get(i);
            if(!vis[e.s]){
                step++;
             step=ladderUtil(graph,vis,e.dest,dest,step,e.s);
            }
        }
        return 0;
    }
    public static int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {
     ArrayList<Edge>[]graph=new ArrayList[wordList.size()+1];
     boolean[]vis=new boolean[wordList.size()+1];
     createGraph(graph,wordList,beginWord);
     return ladderUtil(graph,vis,beginWord,endWord,0,0);
    }

    public static void main(String[] args) {
     String   beginWord = "hit";
     String endWord = "cog";
      List<String>wordList=new ArrayList<>(List.of("hot","dot","dog","lot","log","cog")) ;
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
}
