package OnlinePlatform;

public class CountSymmetric2843 {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
     for(int i=low;i<=high;i++){
         String s1 = String.valueOf(i);
         int n=s1.length();
         if(n%2==0){
             n=n/2;
             int leftSum=0;
             int rightSum=0;
             for(int j=0;j<n;j++){
                leftSum+=s1.charAt(j)-'0';
                rightSum+=s1.charAt(j+n)-'0';
             }
             if(leftSum==rightSum){
                 count++;
             }
         }
     }
     return count;
    }

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1,100));
    }
}
