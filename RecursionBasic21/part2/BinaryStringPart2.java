package RecursionBasic21.part2;

public class BinaryStringPart2 {
    public static void binaryString(int n,int lastBit,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binaryString(n-1,0,str+"0");
        if(lastBit==0){
            binaryString(n-1,1,str+"1");
        }
    }

    public static void main(String[] args) {
        binaryString(5,0,"");
    }
}
