package OnlinePlatform;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortintegerByNumberOfBits1356 {
    public static int[] sortByBits(int arr[]){
        Arrays.sort(arr);
        int bitCounter[][]=new int[arr.length][2];
        int res[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            bitCounter[i][0]=arr[i];
            bitCounter[i][1]=Integer.bitCount(arr[i]);
        }

        Arrays.sort(bitCounter, Comparator.comparingInt(o->o[1]));
            for(int i=0;i<bitCounter.length;i++){
                res[i]=bitCounter[i][0];
            }
//        System.out.println(Arrays.toString(res));

                for(int i=0;i<bitCounter.length;i++){
            for(int j=0;j<bitCounter[0].length;j++){
                System.out.print(bitCounter[i][j]+" ");

            }
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1024,512,256,128,64,32,16,8,4,2,1};
        sortByBits(arr);
    }
}
