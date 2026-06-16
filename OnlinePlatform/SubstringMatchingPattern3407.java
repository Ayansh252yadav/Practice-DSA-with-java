package OnlinePlatform;
public class SubstringMatchingPattern3407 {
    public static boolean hasMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] res = new boolean[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                res[0][j] = res[0][j - 1];
            }
        }
        for (int i = 0; i <= n; i++) {
            res[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sch = s.charAt(i - 1);
                char pch = p.charAt(j - 1);
                if (pch == sch) {
                    res[i][j] = res[i - 1][j - 1];
                } else if (pch == '*') {
                    res[i][j] = res[i - 1][j] || res[i][j - 1];
                }
            }
        }
        return res[n][m];
    }

    public static void main(String[] args) {
        System.out.println(hasMatch("took", "t*t"));
    }
}
