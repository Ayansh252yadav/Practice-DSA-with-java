package OnlinePlatform;

import java.util.HashSet;

public class UniqueBinaryString1980 {
    public static String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        HashSet<String>hs=new HashSet<>();
        for(String num:nums){
            hs.add(num);
        }
        for(int i=0;i<(1<<n);i++){
            String res=Integer.toBinaryString(i);
                while (res.length()<n){
                    res="0"+res;
                }
            if(!hs.contains(res)){
                return res;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] test1 = {"01", "10"};
        System.out.println("Unique binary string: " + findDifferentBinaryString(test1));
    }
}
