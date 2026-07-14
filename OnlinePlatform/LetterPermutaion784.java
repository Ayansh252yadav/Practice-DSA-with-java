package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class LetterPermutaion784 {
    public static void permutaion(String s,int idx,List<String>list,StringBuilder temp){
        if(s.length()==idx){
            list.add(temp.toString());
            return;
        }
            char curr=s.charAt(idx);
           if(Character.isLetter(curr)){
               temp.append(Character.toLowerCase(curr));
                permutaion(s,idx+1,list,temp);
                temp.deleteCharAt(temp.length()-1);

                temp.append(Character.toUpperCase(curr));
                permutaion(s,idx+1,list,temp);
                temp.deleteCharAt(temp.length()-1);
           }else{
               temp.append(curr);
               permutaion(s,idx+1,list,temp);
               temp.deleteCharAt(temp.length()-1);
           }
    }
    public static List<String> letterCasePermutation(String s) {
        List<String> list=new ArrayList<>();
        permutaion(s,0,list,new StringBuilder());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }
}
