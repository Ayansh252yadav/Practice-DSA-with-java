package OnlinePlatform;

import java.util.Random;

public class ArrangeCoins441 {
    public static int arrangeCoins(int n) {
        int i=0;
        int cntCom=0;
    while(true){
  i++;
  if(n<=0){
      break;
  }
  if(n>=i){
      n=n-i;
      cntCom++;
  }else{
      break;
  }

    }
    return cntCom;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
    }
}
