package GRAPH43PART4.COM.Graph;

public class DisjointSetDS {
    static int n=7;
    int [] parent=new int[n];
    int[] rank=new int[n];
    public void init(){
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]= find(parent[x]);
    }
    public void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]>rank[parB]){
            parent[parB]=parA;
        }else  if(rank[parA]<rank[parB]){
            parent[parA]=parB;
        }
    }

    public static void main(String[] args) {
        DisjointSetDS ds=new DisjointSetDS();
        ds.init();
        ds.union(1,3);
        System.out.println(ds.find(3));
        ds.union(2,4);
        ds.union(3,6);
        ds.union(1,4);
        System.out.println(ds.find(3));
        System.out.println(ds.find(4));
        ds.union(1,5);
    }
}
