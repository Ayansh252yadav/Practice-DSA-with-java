package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle119 {
    public static List<Integer> getRow(int rowIndex) {
   List<Integer>res=new ArrayList<>();
   List<List<Integer>>temp=new ArrayList<>();
   res.add(1);
    if(rowIndex==0){
    return res;
   }
    temp.add(new ArrayList<>(res));
    res.add(1);
    if(rowIndex==1){
        return res;
    }
    temp.add(new ArrayList<>(res));
    res.clear();
    for(int i=2;i<=rowIndex;i++){
        res.add(1);
        for(int j=0;j<temp.get(i-1).size()-1;j++){
            int sum=temp.get(i-1).get(j)+temp.get(i-1).get(j+1);
            res.add(sum);
        }
        res.add(1);
        temp.add(new ArrayList<>(res));
        res.clear();
    }
    res=temp.get(rowIndex);
    return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
