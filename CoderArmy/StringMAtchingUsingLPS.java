package CoderArmy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class StringMAtchingUsingLPS {
    public static void LPS(String s, ArrayList<Integer>lps){
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
    }
    public static boolean stringMatched(String hayStack,String needle){
        ArrayList<Integer>lps=new ArrayList<>(Collections.nCopies(needle.length(),0));
        LPS(needle,lps);
        int first=0;
        int second=0;
        while (first<hayStack.length() && second<needle.length()){
            if(hayStack.charAt(first)==needle.charAt(second)){
                first++;
                second++;
            }else{
                if(second==0){
                    first++;
                }
                else {
                    second=lps.get(second-1);
                }
            }
        }
        if(second==needle.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String hayStack="ONIONIONSON";
        String needle="ONIONSE";
        System.out.println(stringMatched(hayStack,needle));
    }
}
