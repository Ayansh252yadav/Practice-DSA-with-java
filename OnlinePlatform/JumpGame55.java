package OnlinePlatform;

public class JumpGame55 {
    public static boolean canJump(int[] nums){
        int n=nums.length;
        int dis=0;
        int reach=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
         dis=Math.max(dis,i+nums[i]);
            if(i>dis){
                break;
            }
            if(dis>=n-1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
