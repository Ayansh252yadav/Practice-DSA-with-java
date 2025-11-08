package RecursionBasic20.Part1;

import BitManupulation18.com.*;
public class PrintXpowerN {
//    fast exponentiation using bit manupulation
    public static int bitmanupulation(int a,int n){
    int ans=1;
        while(n!=0){
            if((n & 1) !=0){
                ans=ans*a;
            }
            a=a*a;
           n= n>>1;
        }
        return ans;
    }
    // now using recursion to print X ^ N
    public static int powerN(int a,int n){
        if(n==1){
            return a;
        }
        return a*powerN(a,n-1);
    }

    public static void main(String[] args) {
        System.out.println(powerN(3,5));
        System.out.println(bitmanupulation(3,5));
    }
}
