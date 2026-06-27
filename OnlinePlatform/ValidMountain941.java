package OnlinePlatform;

public class ValidMountain941 {
    public static boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
       int i=0;
       while(i<arr.length-1 && arr[i]<arr[i+1] ){
          i++;
       }
       if(i==0 || i==arr.length-1){
           return false;
       }
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
       return i==arr.length-1;
    }

    public static void main(String[] args) {
        int []arr={2};
        System.out.println(validMountainArray(arr));
    }
}
