package OnlinePlatform;

import java.util.Arrays;
// wrong re attempt
public class LicenceKeyFormatting482 {
    public static void helper(String []s,int i,StringBuilder sb,int k){
     if(s[i].length()<k){
          if(s[i-1].length()>k){
              s[i]+=s[i-1].substring(k+1);
          }
          if(s[i].length()<k){

          }
     }
    }
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb=new StringBuilder();
    for(char ch:s.toCharArray()){
        if(Character.isAlphabetic(ch)){
            sb.append(Character.toUpperCase(ch));
        }else{
            sb.append(ch);
        }
    }
    String []str=sb.toString().split("-");
      for(int i=1;i<str.length;i++){
         if(str[i].length()!=k){

         }
      }
      return "";
    }

    public static void main(String[] args) {
        String  s = "2-5g-3-J";
        int k = 2;
        System.out.println(licenseKeyFormatting(s,k));
    }
}
