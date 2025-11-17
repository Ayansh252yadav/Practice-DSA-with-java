package Divide.conquer.com;

public class InversionCount {
    public static int mergeSortInversion(int arr[],int left,int right){
        int inversionCount=0;
        if(right>left) {
            int mid = left + (right - left) / 2;
            inversionCount = mergeSortInversion(arr, left, mid);
            inversionCount+=mergeSortInversion(arr,mid+1,right);
            inversionCount+=merge(arr,left,mid,right);
        }
        return inversionCount;
    }
    public static int merge(int arr[],int left,int mid,int right){
        int temp[]=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        int invCount=0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
                invCount+=mid-i+1;
            }
            k++;
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for(i=left,k=0;i<=right;i++,k++){
            arr[i]=temp[k];
        }
        return invCount;
    }
     public static int getInversion(int arr[]){
        int n=arr.length;
        return mergeSortInversion(arr,0,n-1);
     }
    public static void main(String[] args) {
        int arr[]={2, 4, 1, 3, 5};
        System.out.println(getInversion(arr));
    }
}
