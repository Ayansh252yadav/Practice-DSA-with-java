package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public static boolean wordPattern(String pattern, String s) {
    char ch[]=s.toCharArray();
        ArrayList<String>temp=new ArrayList<>();
    String t="";
    for(int i=0;i<ch.length;i++){
       if(ch[i]==' '){
           temp.add(t);
          t="";
       }else{
        t+=ch[i];
       }
    }
    temp.add(t);
    t="";
        if(pattern.length() != temp.size()){
            return false;
        }
    Map<Character,String> mp1=new HashMap<>();
    Map<String,Character> mp2=new HashMap<>();
    for(int i=0;i<pattern.length();i++){
        char ch1=pattern.charAt(i);
        t=temp.get(i);
        if(mp1.containsKey(ch1)){
            if(!mp1.get(ch1).equals(t)){
                return false;
            }
        }else{
            mp1.put(ch1,t);
        }

        if(mp2.containsKey(t)){
            if(!mp2.get(t).equals(ch1)){
                return false;
            }
        }else{
            mp2.put(t,ch1);
        }
    }
        System.out.println(mp1);
    return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
