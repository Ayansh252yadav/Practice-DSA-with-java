package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<Math.pow(2,n);i++){
            arr.add(i);
        }
        for(int i=0;i<arr.size();i++){
            arr.set(i,arr.get(i)>>1);
        }
        List<Integer>res=new ArrayList<>();
        for(int i=0;i< arr.size();i++){
            res.add(i^arr.get(i));
        }
        return res;
    }
}
