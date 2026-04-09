package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyString43 {
    public static String multiply(String num1, String num2) {
     int m=num1.length();
     int n=num2.length();
     int carry=0;
     int mul=0;
        ArrayList<Integer>arr=new ArrayList<>();
   int num=0;
   int k=0;
  for(int i=m;i>=0;i--){
      for(int j=n;j>=0;j--){
          mul=(num2.charAt(i)-'0')*(num1.charAt(j)-'0')+carry;
          carry=mul/10;
          num=num*10+mul%10;
      }
      if(carry>0){

      }
      arr.add(num);
  }
     StringBuilder res=new StringBuilder();


//     while (m>=0){
//         mul=(num1.charAt(index1)-'0')+carry;
//         carry=mul/10;
//         char c=(char) ('0'+mul%10);
//         res.append(c);
//         index1--;
//     }
//     if(carry!=0){
//         res.append(1);
//     }
     return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2","3"));
    }
}
