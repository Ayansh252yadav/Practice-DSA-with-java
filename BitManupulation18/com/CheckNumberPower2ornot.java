package BitManupulation18.com;

public class CheckNumberPower2ornot {
    public static boolean check(int n){
        return (n & (n-1))==0;
    }

    public static void main(String[] args) {
        System.out.println(check(1024));
        System.out.println(5>>1);
    }
}
