package OnlinePlatform;

public class FurthestPointFromOrigin2833 {
    public static int furthestDistanceFromOrigin(String moves) {

        int countLeft=0;
        int countRight=0;
        int countHyphen=0;
        for (int i = 0; i < moves.length(); i++) {
          if(moves.charAt(i)=='L'){
              countLeft++;
          }
          else if(moves.charAt(i)=='R'){
              countRight++;
          }else{
              countHyphen++;
          }
        }
        return Math.abs(countLeft-countRight+countHyphen);

    }

    public static void main(String[] args) {
        furthestDistanceFromOrigin("hello");
    }
}
