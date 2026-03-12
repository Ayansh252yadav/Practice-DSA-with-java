package OnlinePlatform;

public class SortColors {
    public static void sortColors(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int []temp=new int[max+1];
        for(int i=0;i<n;i++){
            temp[nums[i]]++;
        }
        int k=0;
        for(int i=0;i<temp.length;i++){
            while(temp[i]!=0){
                nums[k]=i;
                k++;
                temp[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={2,0,2,1,1,0};
        sortColors(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
