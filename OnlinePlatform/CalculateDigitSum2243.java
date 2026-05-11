package OnlinePlatform;

import javax.management.StandardEmitterMBean;
import java.util.ArrayList;

public class CalculateDigitSum2243 {
 public static int  Sum(String s){
     int sum=0;
     for(char ch:s.toCharArray()){
         sum+=(int)(ch-'0');
     }
     return sum;
 }
 public static ArrayList<String> partition(String s,int k){
     ArrayList<String>arr=new ArrayList<>();
     for(int i=0;i<s.length();i+=k){
         arr.add(s.substring(i,Math.min(i+k,s.length())));
     }
     return arr;
    }
    public static String digitSum(String s, int k) {
    StringBuilder temp= new StringBuilder(s);
    while(temp.length()>k){
        ArrayList<String>arr=partition(temp.toString(),k);
        temp=new StringBuilder();
        for (String string : arr) {
            temp.append(Sum(string));
        }
        arr.clear();
    }
    return temp.toString();
    }

    public static void main(String[] args) {
        System.out.println(digitSum( "00000000",3));
    }
}
