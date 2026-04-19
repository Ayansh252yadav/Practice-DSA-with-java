package OnlinePlatform;

public class HammingDistance461 {
    public static int hammingDistance(int x, int y) {

    return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(0,1));
    }
}
