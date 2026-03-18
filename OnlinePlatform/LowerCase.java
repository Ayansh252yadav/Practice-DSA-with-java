package OnlinePlatform;

public class LowerCase {
    class Solution {
        public String toLowerCase(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    ch += 32;
                }
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        LowerCase lc=new LowerCase();
        LowerCase.Solution sc=lc.new Solution();
        System.out.println(sc.toLowerCase("Hello"));
    }
}

