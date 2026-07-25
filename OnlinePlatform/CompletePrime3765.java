package OnlinePlatform;

public class CompletePrime3765 {
    public boolean isPrime(int n){
        if (n < 2) {
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean completePrime(int num) {
     String s=String.valueOf(num);

     int n=s.length();
     int temp=0;
     for(int i=0;i<n;i++){
         char ch=s.charAt(i);
         temp=temp*10+ch-'0';
         if(!isPrime(temp)){
             return false;
         }
     }
     temp=0;
     for(int i=0;i<n;i++){
         temp=Integer.valueOf(s.substring(i));
         if(!isPrime(temp)){
             return false;
         }
     }
     return true;
    }
}
