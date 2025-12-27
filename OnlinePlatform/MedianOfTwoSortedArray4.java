package OnlinePlatform;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArray4 {
    public static double findMedianSortedArrays(int []nums1,int []nums2){
        int n=nums1.length;
        int m=nums2.length;
        int arr[]=new int[m+n];
        int temp=0;
        for(int i=0;i<n;i++){
         arr[temp]=nums1[i];
         temp++;
        }
        for(int i=0;i<m;i++){
            arr[temp]=nums2[i];
            temp++;
        }
        Arrays.sort(arr);
        double median;
        int k=n+m;
        if((n+m)%2==0){
         median=(arr[k/2 - 1] + arr[k/2]) / 2.0;
        }else{
            median=arr[(n+m)/2];
        }
        return median;
    }

    public static void main(String[] args) {
     int []nums1={1,2};
     int []nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
