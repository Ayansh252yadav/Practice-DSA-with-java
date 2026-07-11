package OnlinePlatform;

import java.util.*;

public class RemoveDuplicateLetters316 {
    public static String removeDuplicateLetters(String s) {
     boolean  []vis=new boolean[26];
     int []freq=new int[26];
     Stack<Character> stack=new Stack<>();
     for(int i=0;i<s.length();i++){
         freq[s.charAt(i)-'a']++;
     }
     stack.push(s.charAt(0));
     vis[s.charAt(0)-'a']=true;
     for(int i=1;i<s.length();i++){
         char ch=s.charAt(i);
         freq[ch-'a']--;
         if(vis[ch-'a']){
             continue;
         }
       while(!stack.isEmpty() && stack.peek()>ch && freq[stack.peek()-'a']>0 ){
           vis[stack.peek()-'a']=false;
           stack.pop();
       }
           stack.push(ch);
           vis[ch-'a']=true;
     }
     StringBuilder sb = new StringBuilder();
     while(!stack.isEmpty()){
         sb.append(stack.pop());
     }
     return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
