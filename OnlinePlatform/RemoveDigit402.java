package OnlinePlatform;

import java.util.ArrayDeque;

public class RemoveDigit402 {
    public String removeKdigits(String num, int k) {
    ArrayDeque<Character> stack=new ArrayDeque<>();
    for(int i=0;i<num.length();i++){
        char ch=num.charAt(i);
        while(!stack.isEmpty()&&stack.peek()>ch && k>0){
            stack.pop();
            k--;
        }
        stack.push(ch);
    }
    StringBuilder sb=new StringBuilder();
    while(!stack.isEmpty()){
        sb.append(stack.pop());
    }
    while(sb.length()>1){
        sb.deleteCharAt(0);
    }
    return sb.reverse().toString();
    }
}
