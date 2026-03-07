package OnlinePlatform;

public class MinimumNumberOfflipsRequired1888 {
    public static String rotate(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(0));
        return sb.toString();
    }
    public static int minFlips(String s) {

       int min=Integer.MAX_VALUE;
       String st=s;
       for(int r=0;r<s.length();r++){
           int count1=0;
           int count2=0;
       for(int i=0;i<s.length();i++){
           char expected1=(i%2==0)?'1':'0';
           char expected2=(i%2==0)?'0':'1';
           if(expected1!=st.charAt(i)){
               count1++;
           }
           if(expected2!=st.charAt(i)){
               count2++;
           }
           }
           min=Math.min(min,Math.min(count2,count1));
           st=rotate(st);
       }
       return min;
    }
   //optimize approach
   public static int minFlip(String s) {
       int n = s.length();
       String str = s + s;
       int diff1 = 0;
       int diff2 = 0;
       int res= Integer.MAX_VALUE;
       int left = 0;
       for (int right = 0; right < str.length(); right++) {
           char expected1 = (right % 2 == 0) ? '1' : '0';
           char expected2 = (right % 2 == 0) ? '0' : '1';
           if (str.charAt(right) != expected1){
               diff1++;
           }
           if (str.charAt(right) != expected2){
               diff2++;
           }
           if (right - left + 1 > n) {
               char leftExpected1 = (left % 2 == 0) ? '1' : '0';
               char leftExpected2 = (left % 2 == 0) ? '0' : '1';

               if (str.charAt(left) != leftExpected1){
                   diff1--;
               }
               if (str.charAt(left) != leftExpected2){
                   diff2--;
               }
               left++;
           }
           if (right - left + 1 == n) {
               res = Math.min(res, Math.min(diff1, diff2));
           }
       }
       return res;
   }
    public static void main(String[] args) {
        System.out.println(minFlip("01001001101"));
    }
}
