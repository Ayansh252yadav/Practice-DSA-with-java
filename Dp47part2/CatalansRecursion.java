package Dp47part2;

public class CatalansRecursion {
    public static int catlans(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catlans(i)*catlans(n-i-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(catlans(7));
    }
}
