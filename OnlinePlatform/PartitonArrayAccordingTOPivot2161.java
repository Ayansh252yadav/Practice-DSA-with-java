package OnlinePlatform;
import java.util.ArrayList;
import java.util.Arrays;

public class PartitonArrayAccordingTOPivot2161 {
    public static int[] pivotArray(int[] nums, int pivot) {
       int n=nums.length;
        int []res=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                res[k]=nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(res));
        for(int i=0;i<n;i++){
            if(pivot==nums[i]){
                res[k]=nums[i];
                k++;
            }
        }
        for(int i=0;i<n;i++){
            if(pivot<nums[i]){
                res[k]=nums[i];
                k++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]arr={9,12,5,10,14,3,10};
        int pivot=10;
        System.out.println(Arrays.toString(pivotArray(arr,pivot)));
    }
}
