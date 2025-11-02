package BitManupulation18.com;

public class ClearRangeOfBit extends ClearLastIthBit {
    public static int clearrangeofbit(int n,int i,int j){
        int a=(~0)<<(j+1);
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n &bitmask;
    }
    public static void main(String[] args) {
        System.out.println(clearrangeofbit(10,2,7));
    }
}
class ClearLastIthBit{
    public static int clearithbit(int n,int i){
        int bitmask=~(0)<<i;
        return n & bitmask;
    }
}
