package Divide.conquer.com;

public class InversionCount2 {
    public static int inversion(int arr[],int left,int right){
        int invCot=0;
        if(right>left){
            int mid=left+(right-left)/2;
            invCot=inversion(arr,left,mid);
            invCot+=inversion(arr,mid+1,right);
            invCot+=merge(arr,left,mid,right);
        }
        return invCot;
    }
    public static int merge(int arr[],int left,int mid,int right){
        int arr2[]=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        int invcout=0;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                arr2[k]=arr[i];
                i++;
            }else{
                arr2[k]=arr[j];
                j++;
                invcout+=mid-i+1;
            }
            k++;
        }
        while(i<=mid){
            arr2[k++]=arr[i++];
        }
        while(j<=right){
            arr2[k++]=arr[j];
            j++;
        }
        for(i=left,k=0;i<=right;i++,k++){
            arr[i]=arr2[k];
        }
        return invcout;
    }

    public static void main(String[] args) {
        int arr[]={2, 4, 1, 3, 5};
        System.out.println(inversion(arr,0,arr.length-1));
    }
}
