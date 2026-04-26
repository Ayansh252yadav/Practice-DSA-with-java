package OnlinePlatform;

import java.util.Arrays;
import java.util.List;

public class StringReverse541 {
    public static String reverseStr(String s) {
        String[] temp=s.split(" ");
        StringBuilder sb=new StringBuilder();
        String res="";
        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
            sb.reverse();
            res+=sb.toString();
            if(i!=temp.length-1){
                res+=" ";
            }

            sb.setLength(0);
        }
        res.trim();
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("Let's take LeetCode contest"));
    }
}
