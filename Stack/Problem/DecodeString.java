package Stack.Problem;

import java.util.Stack;

public class DecodeString {

    public static String decode(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<Character> stringStack = new Stack<>();
        String temp = "";
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 1. If digit, build full number
            if (Character.isDigit(ch)) {
                int count = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--; // adjust index
                integerStack.push(count);
            }

            // 2. If closing bracket
            else if (ch == ']') {
                temp = "";
                int count = integerStack.pop();

                // get string inside brackets
                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.pop() + temp;
                }

                stringStack.pop(); // remove '['

                // repeat and push back
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < temp.length(); k++) {
                        stringStack.push(temp.charAt(k));
                    }
                }
            }

            // 3. If opening bracket
            else if (ch == '[') {
                stringStack.push(ch);
            }

            // 4. Normal character
            else {
                stringStack.push(ch);
            }
        }

        // Build final result
        while (!stringStack.isEmpty()) {
            res = stringStack.pop() + res;
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "2[cv]";
        System.out.println(decode(str)); // cvcv
    }
}
