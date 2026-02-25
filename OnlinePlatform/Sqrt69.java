package OnlinePlatform;

public class Sqrt69 {
    public int mySqrt(int x) {
    if(x<2){
        return x;
    }
        int left=1;
    int right=x/2;
    while (left<=right){
        int mid=left+(right-left)/2;
        if(mid==x/mid){
            return mid;
        }else if(mid<x/mid){
            left=mid+1;
        }else{
            right=mid-1;
        }
    }
    return right;
    }

    public static void main(String[] args) {
        Sqrt69 sq=new Sqrt69();
        System.out.println(sq.mySqrt(3));
    }
}
