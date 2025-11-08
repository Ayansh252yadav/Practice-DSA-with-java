package RecursionBasic20.Part1;

public class OptimizedPowerNOfN {
    public static int Optimized_power(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPower=Optimized_power(x,n/2);
        halfPower*=halfPower;
        if(n%2 !=0){
            halfPower=x*halfPower;
        }
        return halfPower;
    }

    public static void main(String[] args) {
        System.out.println(Optimized_power(3,3));
    }
}
