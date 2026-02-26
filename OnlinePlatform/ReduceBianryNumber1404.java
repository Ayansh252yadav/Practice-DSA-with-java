package OnlinePlatform;

public class ReduceBianryNumber1404 {
    public static int numSteps(String s) {
//     int decimal=Integer.parseInt(s);
//     int i=s.length()-1;
//     long decimal=0;
//     int k=0;
//     while (i>=0){
//         int temp=s.charAt(i)-'0';
//         decimal+=(int)Math.pow(2,k)*temp;
//         i--;
//         k++;
//     }
        long decimal=Long.parseLong(s,2);
     int st=steps(decimal,0);
        System.out.println(st);
        return st;
    }
   public static int steps(long decimal,int st){
        if(decimal==1){
            return st;
        }
      if(decimal%2==0){
         return steps(decimal/2,st+1);
      }
      else{
          return steps(decimal+1,st+1);
      }
   }
    public static void main(String[] args) {
        numSteps("1111110011101010110011100100101110010100101110111010111110110010");
    }
}
