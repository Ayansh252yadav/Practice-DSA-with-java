package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagCoversion6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        ArrayList[] arr=new ArrayList[numRows];
        for(int i=0;i<numRows;i++){
            arr[i]=new ArrayList<>();
        }
        int j=0;
        int temp=numRows;
        int ch=0;
       for(;ch<s.length();){
           while (j <= numRows-1 && ch < s.length()){
               arr[j].add(s.charAt(ch));
               j++;
               ch++;
           }
           while(temp-2 > 0 && ch < s.length()){
               arr[--j-1].add(s.charAt(ch));
               ch++;
               temp--;
           }
           j=0;
           temp=numRows;
       }
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<arr.length;i++){
          for(int k=0;k<arr[i].size();k++){
              sb.append(arr[i].get(k));
          }
       }
        System.out.println(Arrays.toString(arr));
       return sb.toString();
    }

    public static void main(String[] args) {
        String  s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s,numRows));
    }
}
