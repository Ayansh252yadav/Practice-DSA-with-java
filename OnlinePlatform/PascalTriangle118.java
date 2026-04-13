package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
       ArrayList<Integer>temp=new ArrayList<>();
       temp.add(1);
       res.add(new ArrayList<>(temp));
       if(numRows==1){
           return res;
       }
       temp.add(1);
       res.add(new ArrayList<>(temp));
       if(numRows==2){
           return res;
       }

       temp.clear();
       for(int i=2;i<numRows;i++){
           temp.add(1);
           for(int j=0;j<res.get(i-1).size()-1;j++){
               int sum=res.get(i-1).get(j)+res.get(i-1).get(j+1);
               temp.add(sum);
           }
           temp.add(1);
           res.add(new ArrayList<>(temp));
           temp.clear();
       }
       return res;
    }
    public static void main(String[] args) {
        System.out.println(generate(2));
    }
}
