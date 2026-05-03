package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RectagularConstruct492 {
    public static int[] constructRectangle(int area) {
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        for(int i=1;i<=area;i++){
            if(area%i==0){
                arr.add(new ArrayList<>(List.of(i,area/i)));
            }
        }
        int minDiff=Integer.MAX_VALUE;
        int length=0;
        int width=0;
        for(ArrayList<Integer> e:arr){
            if(e.get(0)>=e.get(1) && (e.get(0)-e.get(1))<minDiff){
                minDiff=Math.min(minDiff,e.get(0)-e.get(1));
                length=e.get(0);
                width=e.get(1);
            }
        }
        return new int[]{length, width};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(37)));
    }
}
