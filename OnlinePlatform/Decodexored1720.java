package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class Decodexored1720 {
    public static int[] decode(int[] encoded, int first) {
        ArrayList<Integer>res=new ArrayList<>();
        res.add(first);
        int iterator=0;
        int j=0;
        for(int i=0;i<encoded.length;i++){
            while(true){
                if((res.get(j)^iterator)==encoded[i]){
                    res.add(iterator);
                    j++;
                    break;
                }
                iterator++;
            }
            iterator=0;
        }
        int []arr=new int[encoded.length+1];
        j=0;
        for(Integer r:res){
            arr[j]=r;
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] encoded={6};
        int first=1;
        System.out.println(Arrays.toString(decode(encoded,first)));
    }
}
