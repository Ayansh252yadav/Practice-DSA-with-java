package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubArrayDistinct2913 {
    public static void subSet(List<Integer> nums, int i, ArrayList<Integer>mid,ArrayList<ArrayList<Integer>>res){
        if(nums.size()==i){
            if(!mid.isEmpty()){
                res.add(new ArrayList<>(mid));
            }
            return;
        }
        mid.add(nums.get(i));
        subSet(nums,i+1,mid,res);
        mid.removeLast();
        subSet(nums,i+1,mid,res);
    }
    public static int sumCounts(List<Integer> nums) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
      subSet(nums,0,new ArrayList<>(),res);
      int sum=0;
      int n;
      for(int i=0;i<res.size();i++){
          n=res.get(i).size();
          sum+=n*n;
      }
      return sum;
    }
    public static int sumCounts1(List<Integer> nums) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                int distinct = set.size();
                sum += distinct * distinct;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        List<Integer>ls=new ArrayList<>();
        ls.addAll(List.of(1,1));
        System.out.println(sumCounts1(ls));
    }
}
