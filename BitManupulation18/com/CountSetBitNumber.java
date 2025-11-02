package BitManupulation18.com;

public class CountSetBitNumber {
    public static int Countsetbit(int n){
        int count= 0;
        while(n>0){
            if((n & 1)!=0){ //lsb(left significant bit) check
                count++;
            }
            n=n>>1;
    }
   return count;
    }

    public static void main(String[] args) {
        System.out.println(Countsetbit(15));
    }
}
