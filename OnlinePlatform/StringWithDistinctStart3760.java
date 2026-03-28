package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class StringWithDistinctStart3760 {
    public static void subsetUtil(String str,String temp,int i,ArrayList<String>res){
        if(i==str.length()){
            if(!temp.isEmpty()){
                res.add(temp);
            }
            return;
        }
        subsetUtil(str,temp+str.charAt(i),i+1,res);
        subsetUtil(str,temp,i+1,res);
    }
    public static int maxDistinct(String s) {
        ArrayList<String>res=new ArrayList<>();
       subsetUtil(s,"",0,res);
        HashSet<Character>hs=new HashSet<>();
        for(String str:res){
            hs.add(str.charAt(0));
        }
        return hs.size();
    }
    public static int maxDistinct2(String s) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(maxDistinct("abcd"));
    }
}
