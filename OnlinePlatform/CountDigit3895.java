package OnlinePlatform;

public class CountDigit3895 {
    public static int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            String s=String.valueOf(nums[i]);
            if(s.contains(String.valueOf(digit))){
                System.out.println(s);
                for(char c:s.toCharArray()){
                    if(c-'0'==digit){
                        count++;
                    }
                }
            }
        }
         return count;
    }

    public static void main(String[] args) {
        int []nums={12,54,32,22};
        int digit=2;
        System.out.println(countDigitOccurrences(nums,digit));
    }
}
