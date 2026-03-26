package OnlinePlatform;

public class NumberOfOneBits {
    public static int hammingWeight(int n) {
    String temp=Integer.toBinaryString(n);
    int count=0;
    for(char c:temp.toCharArray()){
        if(c==1){
            count++;
        }
    }
    return count;
    }
}
