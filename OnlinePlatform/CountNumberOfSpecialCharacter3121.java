package OnlinePlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSpecialCharacter3121 {
    public static int numberOfSpecialChars(String word) {
        Map<Character, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
           map.computeIfAbsent(word.charAt(i),k->new ArrayList<>()).add(i);
        }
        int count=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            boolean check=Character.isUpperCase(ch);
            boolean t=false;
            if(check){
                if(map.containsKey((char)(ch+32)) && map.containsKey(ch)){
                    for(int j=0;j<map.get((char)(ch+32)).size();j++){
                        if(i>=map.get((char)(ch+32)).get(j)){
                            t=true;
                        }else{
                            t=false;
                            break;
                        }
                    }
                    map.remove((char)(ch+32));
                    map.remove(ch);
                    if(t){
                        count++;
                    }
                }
            }else{
                t=false;
                if(map.containsKey((char)(ch-32)) && map.containsKey(ch)){
                    int k=0;
                    for(int j=0;j<map.get((char)(ch-32)).size();j++){
                        if(k>=map.get(ch).size()){
                            break;
                        }
                       else if(map.get(ch).get(k)<=map.get((char)(ch-32)).get(j)){
                            k++;
                            t=true;
                        }
                        else{
                            t=false;
                            break;
                        }
                    }
                    map.remove((char)(ch-32));
                    map.remove(ch);
                    if(t){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("AbBCab"));
    }
}
