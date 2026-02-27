package OnlinePlatform;

public class NumberOfOperationtoEqalizeString {
    public static int minOperation(String s,int k){
        int n = s.length();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            }
        }
        if (zeroCount == 0) return 0;
        if (k == n) {
            if (zeroCount == n) return 1;
            else return -1;
        }
        if (k == 1) return zeroCount;
        if (k % 2 == 0 && zeroCount % 2 == 1) {
            return -1;
        }
        int t = (zeroCount + k - 1) / k;
        if ((t * k - zeroCount) % 2 != 0) {
            t++;
        }
        return t;
    }



    public static void main(String[] args) {
        System.out.println(minOperation("001",3));
    }
    }


