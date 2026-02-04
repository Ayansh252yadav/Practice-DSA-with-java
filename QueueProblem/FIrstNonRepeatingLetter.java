package QueueProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FIrstNonRepeatingLetter {
    public static char nonRepeating(String str) {
        if(str==null || str.length()==0){
            return '$';
        }
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
        }
                    if (q.isEmpty()) {
                return '$';
            }

        System.out.println(q);
        System.out.println(Arrays.toString(freq));
                return q.peek();
    }

    public static void main(String[] args) {
        String str="aabcca";
        System.out.println(nonRepeating(str));
    }
}
