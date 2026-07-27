package OnlinePlatform;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ValidParenthesis2116 {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }

        ArrayDeque<Integer> openStack = new ArrayDeque<>();
       ArrayDeque<Integer> freeStack = new ArrayDeque<>();
       for(int i=0;i<s.length();i++){
           if (locked.charAt(i) == '0') {
               freeStack.push(i);
           }
           else if (s.charAt(i) == '(') {
               openStack.push(i);
           }
           else {
               if (!openStack.isEmpty()) {
                   openStack.pop();
               } else if (!freeStack.isEmpty()) {
                   freeStack.pop();
               } else {
                   return false;
               }
           }
       }
        while (!openStack.isEmpty() && !freeStack.isEmpty()) {
            if (openStack.peek() < freeStack.peek()) {
                openStack.pop();
                freeStack.pop();
            } else {
                return false;
            }
        }
        return openStack.isEmpty();
    }
}
