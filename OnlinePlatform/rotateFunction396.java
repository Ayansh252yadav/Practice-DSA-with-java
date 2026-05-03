package OnlinePlatform;

public class rotateFunction396 {
    public static void rotate(int[] arr,int pos){
        int n=arr.length;
        int []temp=new int[n];
        System.arraycopy(arr, 0, temp, 0, n);
        int k=0;
        pos=pos%n;
        for(int i=n-pos;i<n;i++){
            arr[k]=temp[i];
            k++;
        }
        for(int i=0;i<pos;i++){
            arr[k]=temp[i];
            k++;
        }
    }
    public int maxRotateFunction(int[] nums) {
     int sum=Integer.MIN_VALUE;
        int[] original = nums.clone();
     for(int i=0;i<nums.length;i++){
         nums=original.clone();
         rotate(nums,i);
         int midSu=0;
         for(int j=0;j<nums.length;j++){
             midSu+=nums[i];
         }
         sum=Math.max(midSu,sum);
     }
     return sum;
    }
}
