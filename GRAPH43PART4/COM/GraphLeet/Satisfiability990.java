package GRAPH43PART4.COM.GraphLeet;

public class Satisfiability990 {
    int n=26;
    int []par=new int[n];
    int []rank=new int[n];
    public void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    public void union(int a,int b){
        int x1=find(a);
        int x2=find(b);
        if(rank[x1]==rank[x2]){
            par[x1]=x2;
            rank[x2]++;
        }else if(rank[x1]>rank[x2]){
            par[x2]=x1;
        }else{
            par[x1]=x2;
        }
    }
    public boolean equationsPossible(String[] equations) {
        init();
     for(String e:equations){
         if(e.charAt(1)=='=' && e.charAt(2)=='='){
             union(e.charAt(0)-'a', e.charAt(3)-'a');
         }
     }
      for(String e:equations){
          if(e.charAt(1)=='=' && e.charAt(2)=='='){
              int x=find(e.charAt(0)-'a');
              int y=find(e.charAt(3)-'a');
              if(x!=y){
                  return false;
              }
          } else if(e.charAt(1)=='!' && e.charAt(2)=='='){
              int x=find(e.charAt(0)-'a');
              int y=find(e.charAt(3)-'a');
              if(x==y){
                  return false;
              }
          }
      }
      return true;
    }
}
