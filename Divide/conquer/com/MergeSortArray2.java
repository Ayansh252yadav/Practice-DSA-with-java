package Divide.conquer.com;

import java.util.Arrays;

public class MergeSortArray2 {
    public static int [] mergeSort(int arr[],int si,int ei){
        if(si==ei){
            int A[]={arr[si]};
            return A;
        }
        int mid=si+(ei-si)/2;
        int []arr1=mergeSort(arr,si,mid);
        int []arr2=mergeSort(arr,mid+1,ei);
        int arr3[]=merge(arr1,arr2);
        return arr3;
    }
    public static int [] merge(int arr1[],int arr2[]){
        int m =arr1.length;
        int n=arr2.length;
        int arr3[]=new int[m+n];
        int i=0;
        int j=0;
        int idx=0;
        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){
                arr3[idx]=arr1[i];
                i++;
            }else{
                arr3[idx]=arr2[j];
                j++;
            }
            idx++;
        }
        while(i<m){
            arr3[idx++]=arr1[i++];
        }
        while(j<n){
            arr3[idx++]=arr2[j++];
        }
        return arr3;
    }

    public static void main(String[] args) {
        int arr[]={4,5,3,2,1};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }
}
