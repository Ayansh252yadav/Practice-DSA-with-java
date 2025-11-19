package Divide.conquer.com;

import java.util.Arrays;

public class MergesortString2 {
    public static String [] stringsort(String []str,int left,int right){
        if(left==right){
            String []A={str[left]};
            return A;
        }
        int mid=left+(right-left)/2;
        String str2[]=stringsort(str,left,mid);
        String str3[]=stringsort(str,mid+1,right);
        String str4[]=mergeString(str2,str3);
        return str4;
    }
    public static String [] mergeString(String str1[],String str2[]){
        int n=str1.length;
        int m=str2.length;
        String str3[]=new String[m+n];
        int idx=0;
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(isAlphabeticalSmaller(str1[i],str2[j])){
               str3[idx]=str1[i];
               i++;
            }
            else{
                str3[idx]=str2[j];
                j++;
            }
            idx++;
        }
        while(i<n){
            str3[idx++]=str1[i++];
        }
        while (j<m){
            str3[idx++]=str2[j++];
        }
        return str3;
    }
    public static boolean isAlphabeticalSmaller(String str1,String str2){
        if(str1.compareTo(str2)<0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String arr[]={"sun","earth","mars","mercury"};
        System.out.println(Arrays.toString(stringsort(arr,0, arr.length-1)));
    }
}
