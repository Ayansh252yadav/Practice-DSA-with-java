package Stack.Problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStack1441 {
    public static boolean isPresent(int []target,int nums){
        for(int i=0;i<target.length;i++){
            if(target[i]==nums){
                return true;
            }
        }
        return false;
    }
    public static List<String> buildArray(int[] target, int n) {
       List<String>res=new ArrayList<>();
       int found=0;
       for(int i=1;i<=n;i++){
           if(isPresent(target,i)){
               res.add("PUSH");
               found++;
               if(found == target.length) break;
           }else{
               res.add("PUSH");
               res.add("POP");
           }
       }
       return res;
    }

    public static void main(String[] args) {
        int []target={1,2};
        int n=4;
        System.out.println(buildArray(target,n));
    }
}
