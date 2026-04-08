package OnlinePlatform;

import java.util.Arrays;

public class XOROperationArray1486 {
    public static int xorOperation(int n, int start) {
    int []nums=new int[n];
    for(int i=0;i<n;i++){
        nums[i]=start+2*i;
    }
        System.out.println(Arrays.toString(nums));
    int sum=0;
    for(int i=0;i<nums.length;i++) {
        sum=sum^nums[i];
    }
    return sum;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(4,3));
    }
}
