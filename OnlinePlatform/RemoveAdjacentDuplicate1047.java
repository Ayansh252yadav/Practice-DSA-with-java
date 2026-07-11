package OnlinePlatform;

import java.util.ArrayDeque;
import java.util.Stack;

public class RemoveAdjacentDuplicate1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
    for(int i=1;i<s.length();i++){
        char ch=s.charAt(i);
        if(!st.isEmpty() && st.peek()==ch){
            st.pop();
        } else {
            st.push(ch);
        }
    }
    StringBuilder sb=new StringBuilder();
    while(!st.isEmpty()){
        sb.append(st.pop());
    }
    return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }
}
