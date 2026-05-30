package OnlinePlatform;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MinimizeStringLength2716 {

    public static int minimizedStringLength(String s) {
    Set<Character> set=new HashSet<>();
    for(char ch:s.toCharArray()){
        set.add(ch);
    }
    Iterator<Character> it=set.iterator();
    StringBuilder sb=new StringBuilder();
    while(it.hasNext()){
        sb.append(it.next());
    }
    return sb.length();
    }

    public static void main(String[] args) {
        System.out.println(minimizedStringLength("aaabc"));
    }
}
