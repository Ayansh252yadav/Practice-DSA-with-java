package OnlinePlatform;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Fascinating {
    public boolean isFascinating(int n) {
        int n2=2*n;
        int n3=3*n;
        StringBuilder sb=new StringBuilder();
        sb.append(n);
        sb.append(n2);
        sb.append(n3);
        Set<Character> set=new HashSet<>();
        for(char c:sb.toString().toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
    public boolean squareIsWhite(String coordinates) {
        int a=coordinates.charAt(0)-'a'+1;
        int b=coordinates.charAt(1)-'0';
        if(a%2==0 && b%2==1){
            return true;
        }
        if(a%2==1 && b%2==0){
            return true;
        }
        return false;
    }
    public int largest(int []nums){
        int t=Integer.MIN_VALUE;
        int idx=-1;
       for(int i=0;i<nums.length;i++){
           if(nums[i]>t){
               t=nums[i];
               idx=i;
           }
       }
       if(idx!=-1){
           nums[idx]=Integer.MIN_VALUE;
       }
       return t;
    }
    public int smallest(int []nums){
        int t=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<t){
                t=nums[i];
                idx=i;
            }
        }
        if(idx!=-1){
            nums[idx]=Integer.MAX_VALUE;
        }
        return t;
    }
    public int maximumProduct(int[] nums) {
        int []temp=nums.clone();
       int largest=largest(nums);
       int secondLargest=largest(nums);
       int thirdLargest=largest(nums);
       int smallest=smallest(temp);
       int secondSmallest=smallest(temp);
       int t=largest*secondLargest*thirdLargest;
       int p=largest*smallest*secondSmallest;
       return Math.max(p,t);
    }
}
