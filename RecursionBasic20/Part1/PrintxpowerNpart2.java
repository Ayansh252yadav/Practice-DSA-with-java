package RecursionBasic20.Part1;

public class PrintxpowerNpart2 {
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }

    public static int optimizedPower(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPower=optimizedPower(x,n/2);
        halfPower*=halfPower;
        if(n%2!=0){
            halfPower*=x;
        }
        return halfPower;
    }

    public static void main(String[] args) {
//        System.out.println(power(2,5));
        System.out.println(optimizedPower(2,4));
    }
}
