package CoderArmy;

import java.util.ArrayList;
import java.util.Collections;

public class LongestPrefixSuffixKMP {
    public static int LPS(String s){
        ArrayList<Integer>lps=new ArrayList<>(Collections.nCopies(s.length(),0));
        int pre=0;
        int suf=1;
        while(suf<s.length()){
            if(s.charAt(pre)==s.charAt(suf)){
                lps.set(suf,pre+1);
                pre++;
                suf++;
            }else{
                if(pre==0){
                    lps.set(suf,0);
                    suf++;
                }else{
                    pre=lps.get(pre-1);
                }
            }
        }
        return lps.get(s.length()-1);
    }
  public static String happyPrefix(String s){
        ArrayList<Integer>lps=new ArrayList<>(Collections.nCopies(s.length(),0));
        StringBuilder sb=new StringBuilder();
        int pre=0;
        int suf=1;
        while (suf<s.length()){
            if (s.charAt(pre)==s.charAt(suf)){
                lps.set(suf,pre+1);
                suf++;
                pre++;
            }else{
                if(pre==0){
                    lps.set(suf,0);
                    suf++;
                }else{
                    pre=lps.get(pre-1);
                }
            }
        }
        for(int i=0;i<lps.get(s.length()-1);i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
  }
    public static void main(String[] args) {
        String s="level";
        System.out.println(LPS(s));
        System.out.println(happyPrefix(s));
    }
}
