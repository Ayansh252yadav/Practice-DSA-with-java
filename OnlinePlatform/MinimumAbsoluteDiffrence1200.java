package OnlinePlatform;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MinimumAbsoluteDiffrence1200 {
    public static List<List<Integer>> minimumAbsDifference(int[] arr){
        List<List<Integer>>result=new ArrayList<>();
        if(arr.length==0 || arr==null){
            return result;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==minDiff){
                result.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []arr={40,11,26,27,-20};
        System.out.println(minimumAbsDifference(arr));
    }
}
