package OnlinePlatform;

import java.util.ArrayDeque;

public class RemoveOuterMostParenthesis1021 {
    public static String removeOuterParentheses(String s) {
     StringBuilder sb=new StringBuilder();
     int depth=0;
     for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='('){
          if(depth>0){
              sb.append('(');
          }
          depth++;
      }
      if(s.charAt(i)==')'){
          depth--;
          if(depth>0){
              sb.append(')');
          }
      }
     }
     return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
