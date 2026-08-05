package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DistinctInteger2442 {
    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int e:nums){
            StringBuilder sb=new StringBuilder();
            sb.append(String.valueOf(e)).reverse();
            set.add(e);
            set.add(Integer.parseInt(sb.toString()));
        }
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return set.size();
    }

    public static void main(String[] args) {
  int []num={1,13,10,12,31};
  countDistinctIntegers(num);
    }
}
