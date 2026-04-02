package Hashing38;
import java.util.HashMap;

public class MaxSubArraySumZero {
    public static void main(String[] args) {
        int []arr={1, 0, -4, 3, 1, 0};
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
       sum+=arr[j];
        if(sum==0){
            len=j+1;
        }
        if(map.containsKey(sum)){
            len=Math.max(len,j-map.get(sum));
        }else{
            map.put(sum,j);
        }
        }
        System.out.println(len);
    }
}
