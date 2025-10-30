package BitManupulation18.com;

public class UpdateIthBit extends ClearIthBit {
    public static int updateithbit(int n,int i,int newbit){
      if(newbit==0){
         return  clearithbit(n,i);
      }else{
         return setithbit(n,i);
      }
    }

    public static void main(String[] args) {

//        System.out.println(clearithbit(13,6));
        System.out.println(updateithbit(13,6,1));
    }
}
class ClearIthBit extends SetIthBit{
    public static int clearithbit(int n,int i){
        int bitmask=~(1<<i);
        return n & bitmask;
    }
}
