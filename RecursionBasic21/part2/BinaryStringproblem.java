package RecursionBasic21.part2;

public class BinaryStringproblem {
    public static void binaryString(int n,int lastPlace,String newStr){
        //print all binary string of size n without consecutive ones
        if(n==0){
            System.out.println(newStr);
            return;
        }
        binaryString(n-1,0,newStr+"0");
        if(lastPlace==0){
            binaryString(n-1,1,newStr+"1");
        }
    }

    public static void main(String[] args) {
        binaryString(3,0,"");
    }
}
