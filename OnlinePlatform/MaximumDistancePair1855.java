package OnlinePlatform;

public class MaximumDistancePair1855 {
    public static int maxDistance(int[] nums1, int[] nums2) {
     int dis=Integer.MIN_VALUE;
     for(int i=0;i< nums1.length;i++){
         for(int j=0;j<nums2.length;j++){
             if(i<=j && nums1[i]<=nums2[j]){
                 dis=Math.max(dis,j-i);
             }
             else if(nums1[i]>nums2[j]){
                 break;
             }
         }
     }
     return dis==Integer.MIN_VALUE?0:dis;
    }
public static int twoPointerMaxDistance(int []nums1,int []nums2){
        int i=0;
        int j=0;
        int dis=Integer.MIN_VALUE;
        while(i<nums1.length && j<nums2.length){
            if(i<=j && nums1[i]<=nums2[j]){
                dis=Math.max(dis,j-i);
                j++;
            }else {
                i++;
            }
        }
    return dis==Integer.MIN_VALUE?0:dis;
}
    public static void main(String[] args) {
        int []nums1={5,4};
        int []nums2={3,2};

            System.out.println(twoPointerMaxDistance(nums1,nums2));

    }
}
