package Divide.conquer.com;

import java.util.Arrays;

public class MergeStringSort {
    public static String[] mergeSort(String []str,int si,int ei){
        if(si==ei){
            String A[]={str[si]};
            return A;
        }
        int mid=si+(ei-si)/2;
      String arr1[]=  mergeSort(str,si,mid);
      String arr2[]=  mergeSort(str,mid+1,ei);
      String arr3[]=merge(arr1,arr2);
      return arr3;
    }
    public static String[] merge(String str1[],String str2[]){
     int m=str1.length;
     int n= str2.length;
     String arr3[]=new String[m+n];
     int idx=0;
     int i=0;
     int j=0;
     while(i<m && j<n){
         if(isAlphabeticallySmaller(str1[i],str2[j])){
             arr3[idx]=str1[i];
             i++;
             idx++;
         }
         else{
             arr3[idx]=str2[j];
             j++;
             idx++;
         }
     }
     while (i<m){
         arr3[idx++]=str1[i++];
     }
     while (j<n){
         arr3[idx++]=str2[j++];
     }
     return arr3;
    }
    public static boolean isAlphabeticallySmaller(String s1,String s2){
        if(s1.compareTo((s2))<0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String arr[]={"sun","earth","mars","mercury"};
        System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
    }
}
