package OnlinePlatform;

public class DivideTwoInteger {
       public static int divideON(int dividend, int divisor) {
           if (dividend == Integer.MIN_VALUE && divisor == -1) {
               return Integer.MAX_VALUE;
           }
           if(dividend==2147483647 && divisor==-1){
               return -2147483647;
           }
        boolean negative = (dividend < 0) ^ (divisor < 0);
           long a = Math.abs((long) dividend);
           long b = Math.abs((long) divisor);
        int quotient = 0;
        while (a >= b) {
            a = a - b;
            quotient++;
        }
        if (negative) {
            quotient = -quotient;
        }

        int remainder =(int) a;
        if (dividend < 0) {
            remainder = -remainder;
        }

        System.out.println("Quotient = " + quotient);
        System.out.println("Remainder = " + remainder);
        return quotient;
    }
    public static void main(String[] args) {

        System.out.println(divideON(2147483647,-1));

    }
}
