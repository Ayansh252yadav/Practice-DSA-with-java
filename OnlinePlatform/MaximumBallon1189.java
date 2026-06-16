package OnlinePlatform;

import java.util.Arrays;

public class MaximumBallon1189 {
    public static int maxNumberOfBalloons(String text) {
        String s="balloon";
        int []balloon=new int[26];
       for(int i=0;i<text.length();i++){
           if(text.charAt(i)=='b' || text.charAt(i)=='a' || text.charAt(i)=='l' || text.charAt(i)=='o' ||
                   text.charAt(i)=='n' ){
               balloon[text.charAt(i)-'a']++;
           }
       }
       int []res=new int[s.length()];
       int k=0;
       for(int i=0;i<s.length();i++){
           int  temp=s.charAt(i)-'a';
           if(balloon[temp]==0){
               return 0;
           }
           if(s.charAt(i)=='l' && balloon[temp]<2 || s.charAt(i)=='o' && balloon[temp]<2){
               return 0;
           }
           res[k++]=balloon[temp];
       }
       int count=0;
       while(true){
           if(res[0]>0 && res[1]>0 && res[2]>1 && res[3]>1 && res[4]>1 && res[5]>1 && res[6]>0){
               res[0]--;
               res[1]--;
               res[2]=res[2]-2;
               res[3]=res[3]-2;
               res[4]=res[4]-2;
               res[5]=res[5]-2;
               res[6]--;
               count++;
           }else{
               break;
           }
       }
        System.out.println(Arrays.toString(res));
       return count;
    }
    public static void main(String[] args) {
    String text = "wvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(text));
    }
}
