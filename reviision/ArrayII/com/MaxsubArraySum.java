package reviision.ArrayII.com;

public class MaxsubArraySum {
    public static void  subArraySum(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        int Currsum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int start=i;
            for(int j=i;j<n;j++){
                int end=j;
                Currsum=0;
                for(int k=start;k<=end;k++){
                    Currsum+=arr[k];
                }
                System.out.println(Currsum);
                 if(maxSum<Currsum){
                     maxSum=Currsum;
                 }
            }
        }
        System.out.println("maximum sum is "+maxSum);
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        subArraySum(arr);
//        System.out.println(subArraySum(arr));
    }
}
