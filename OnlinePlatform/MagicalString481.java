package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicalString481 {
    public static int magicalString(int n) {
  StringBuilder sb=new StringBuilder("122");
  int  head=2;
  char num='1';
     while (sb.length()<n){
          if(sb.charAt(head)=='2'){
             sb.append(num);
             sb.append(num);
         }else{
              sb.append(num);
          }
         head++;
          if(num=='2'){
              num='1';
          }else{
              num='2';
          }
  }
        System.out.println(sb);
     int oneC=0;
     for(int i=0;i<n;i++) {
         if (sb.charAt(i) == '1') {
             oneC++;
         }
     }
     return oneC;
    }
    public static void main(String[] args) {
magicalString(4);
    }
}
