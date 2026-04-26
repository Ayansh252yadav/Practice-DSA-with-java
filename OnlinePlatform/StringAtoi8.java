package OnlinePlatform;

public class StringAtoi8 {
    public static int myAtoi(String s) {
        if(s.isEmpty()){
            return 0;
        }
        s=s.trim();
        long temp=0;
        boolean negative=false;
        int i=0;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
         while (i<s.length()) {
             char ch = s.charAt(i);
             if (Character.isDigit(ch)) {
                 temp = temp * 10 + (int) (ch - '0');
                 if (!negative && temp > Integer.MAX_VALUE){
                     return Integer.MIN_VALUE;
                 }
                 if(negative && -temp<Integer.MIN_VALUE){
                     return Integer.MIN_VALUE;
                 }
             }else{
                 break;
             }
             i++;
         }
         int res=(int)temp;
        return negative?-res:res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
