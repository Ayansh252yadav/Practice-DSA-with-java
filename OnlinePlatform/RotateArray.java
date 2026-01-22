package OnlinePlatform;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int nums[],int k){
        int newArray[]=new int[nums.length];
        int n=nums.length;
        k = k % n;
        int index=n-k;
        int i=0;
        for(;i<k;i++){
            newArray[i]=nums[index];
            index++;
        }
        index=0;
        for(int j=i;j<n;j++){
            if(index<n-k){
                newArray[j]=nums[index];
                index++;
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        int k = 2;
        Solution sc=new Solution();
        sc.rotateArr(nums,k);
    }
}

//gfg rotate array
// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int nums[], int k) {
        // add your code here
        int newArray[]=new int[nums.length];
        int n=nums.length;
        k = k % n;
        int index=k;
        int i=0;
        for(;index<n;i++){
            newArray[i]=nums[index];
            index++;
        }
        index=0;
        for(int j=i;j<n;j++){
            if(index<k){
                newArray[j]=nums[index];
                index++;
            }
        }
        for (int x = 0; x < n; x++) {
            nums[x] = newArray[x];
        }
        System.out.println(Arrays.toString(newArray));
    }
}
