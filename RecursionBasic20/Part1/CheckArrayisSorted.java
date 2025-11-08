package RecursionBasic20.Part1;

public class CheckArrayisSorted {
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }else if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static void main(String[] args) {
        int arr[]={1,4,5};
        System.out.println(isSorted(arr,0));
    }
}
