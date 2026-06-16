package OnlinePlatform;

public class FindMiddleIndex1991 {
    public static int  leftSum(int []num,int i){
        int leftSum=0;
        for(int j=i;j>=0;j--){
            leftSum+=num[j];
        }
        return leftSum;
    }
    public static int rightSum(int []num,int i){
        int rightSum=0;
        for(int j=i;j<num.length;j++){
            rightSum+=num[j];
        }
        return rightSum;
    }
    public static  int findMiddleIndex(int[] nums) {
     for(int i=0;i<nums.length;i++){
         if(leftSum(nums,i-1)==rightSum(nums,i+1)){
             return i;
         }
     }
     return -1;
    }
    public static int findMiddleIndex1(int []nums){
        int arraySum=0;
        for (int num : nums) {
            arraySum += num;
        }
        int leftSum=0;
        for(int i=1;i<nums.length;i++){
            leftSum+=nums[i-1];
            int rightSum=arraySum-leftSum-nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int []num={2,3,-1,8,4};
//        System.out.println(findMiddleIndex(num));
        System.out.println(findMiddleIndex1(num));
    }
}
