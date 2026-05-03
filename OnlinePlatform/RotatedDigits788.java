package OnlinePlatform;

import java.util.*;

public class RotatedDigits788 {
    public static int rotatedDigits(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(2,5);
        map.put(5,2);
        map.put(6,9);
        map.put(9,6);
        map.put(8,8);
        int count=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            boolean flag=false;
            boolean valid=true;
            while(temp!=0){
                int rem=temp%10;
                if(!map.containsKey(rem)){
                    valid=false;
                    break;
                }
                if(map.get(rem) != rem){
                    flag = true;
                }
                temp=temp/10;
            }
            if(valid&&flag){
               count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(rotatedDigits(857));
    }
}
