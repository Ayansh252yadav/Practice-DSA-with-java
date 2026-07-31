package OnlinePlatform;

public class TriangularSum2221 {
    public static int triangularSum(int[] nums) {
      for(int i=1;i<nums.length;i++){
          int []newNums = new int[nums.length-i];
          for(int j=0;j<nums.length-i;j++){
              newNums[j]=(nums[j]+nums[j+1])%10;
          }
          nums=newNums.clone();
      }
        System.out.println(nums[0]);
      return nums[0];
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        System.out.println(triangularSum(arr));
    }
}
