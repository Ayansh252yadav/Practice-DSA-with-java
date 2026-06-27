package Dp47part2.DP;

public class MinimumPartitioning {
    public static int partitioningRecursion(int []arr,int sum,int n){
      if(sum==0 || n==0){
          return 0;
      }
      if(arr[n-1]<=sum){
          //include
          int ans1=arr[n-1]+partitioningRecursion(arr,sum-arr[n-1],n-1);
          //exclude
          int ans2=partitioningRecursion(arr,sum,n-1);
          return Math.max(ans1,ans2);
      }else{
          return partitioningRecursion(arr,sum,n-1);
      }
    }
   public static int partitioningTabulation(int []arr){
        int sum=0;
        for(int e:arr){
            sum+=e;
        }
        int set1=sum-sum/2;
        int n=arr.length;
        int m=sum/2;
        int [][]dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]<=j){
                    //include
                    int ans1=dp[i][j-arr[i-1]]+arr[i-1];
                    //exclude
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int set2=dp[n][m];
        return Math.abs(set1-set2);
   }
    public static void main(String[] args) {
        int []arr={1,6,11,5};
        int sum=0;
        for(int e:arr){
            sum+=e;
        }
        int set1=sum-sum/2;
        int set2=partitioningRecursion(arr,sum/2,arr.length);
        System.out.println(Math.abs(set1-set2));
        System.out.println(partitioningTabulation(arr));
    }
}
