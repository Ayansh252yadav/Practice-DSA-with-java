package RecursionBasic20.Part1;

public class FirstOccurenceInAnArray {
    public static int firstOccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        else if(key==arr[i]){
            return i+1;
        }
        return firstOccurence(arr,key,i+1);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,3,4,5,6,6,7,7};
        System.out.println(firstOccurence(arr,7,0));
    }
}
