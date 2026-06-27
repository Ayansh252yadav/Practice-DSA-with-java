package Dp47part2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ValidParenthesis32 {
    public static int longestValidParentheses(String s) {
        ArrayDeque<Integer>st=new ArrayDeque<>();
        st.push(-1);
        int i=0;
        int ans=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else {
                    ans=Math.max(ans,i-st.peek());
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s=")()())";
        System.out.println(longestValidParentheses(s));
    }
}
