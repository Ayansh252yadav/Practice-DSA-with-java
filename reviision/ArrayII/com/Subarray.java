package reviision.ArrayII.com;

public class Subarray {
public static void subArray(int arr[]){
    int n=arr.length;
    for(int i=0;i<n;i++){
        int start=i;
        for(int j=i;j<n;j++){
           int end=j;
           for(int k=start;k<=end;k++){
               System.out.print(arr[k]+" ");
           }
            System.out.println();
        }
        System.out.println();
    }
}

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        subArray(arr);
    }
}
