package GRAPH43PART4.COM.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountMerge721 {
    int []par;
    int []rank;
    public void init(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]= find(par[x]);
    }
    public void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(parA==parB){
            par[parA]=parB;
            rank[parB]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
   HashMap<String,Integer>emailToId=new HashMap<>();
   HashMap<String,String>emailToName=new HashMap<>();
   int id=0;
  for(List<String> account:accounts){
      for(int i=1;i<account.size();i++){
          if(!emailToId.containsKey(account.get(i))){
              emailToId.put(account.get(i), id++);
              emailToName.put(account.get(i), account.get(0));
          }
      }
  }
        init(id);
 for(int i=0;i<accounts.size();i++){
         String s=accounts.get(i).get(1);
     for(int j=1;j<accounts.get(i).size();j++){
         union(emailToId.get(s),emailToId.get(accounts.get(i).get(j)));
     }
 }
        HashMap<Integer, List<String>> groups = new HashMap<>();
        for(String email:emailToId.keySet()){
            int root=find(emailToId.get(email));
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> list:groups.values()){
            Collections.sort(list);
           List<String> temp=new ArrayList<>();
           temp.add(emailToName.get(list.get(0)));
           temp.addAll(list);
           result.add(temp);
        }
        return result;
    }
}
