package OnlinePlatform;

public class check3591 {
    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        int []freq=new int[100+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int e:freq){
            if(isPrime(e)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4,5,4};
        check3591 sc=new check3591();
        System.out.println(sc.checkPrimeFrequency(nums));
    }
}
