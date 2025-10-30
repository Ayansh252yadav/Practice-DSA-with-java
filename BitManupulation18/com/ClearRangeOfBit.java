package BitManupulation18.com;

public class ClearRangeOfBit extends ClearLastIthBit {
//    public static
    public static void main(String[] args) {
        System.out.println(~(0)<<2);
        System.out.println(clearithbit(10,2));
    }
}
class ClearLastIthBit{
    public static int clearithbit(int n,int i){
        int bitmask=~(0)<<i;
        return n & bitmask;
    }
}
