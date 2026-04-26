package OnlinePlatform;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character,Integer> mp=new HashMap<>();
    for(int i=0;i<magazine.length();i++){
        if(mp.containsKey(magazine.charAt(i))){
            mp.put(magazine.charAt(i),mp.get(magazine.charAt(i))+1);
        }else{
            mp.put(magazine.charAt(i),1);
        }
    }
    for(int i=0;i<ransomNote.length();i++){
        if(!mp.containsKey(ransomNote.charAt(i))){
            return false;
        }else{
            mp.put(ransomNote.charAt(i),mp.get(ransomNote.charAt(i))-1);
        }
    }
    for(Character ch:mp.keySet()){
        if(mp.get(ch)<0){
            return false;
        }
    }
    return true;
    }
}
