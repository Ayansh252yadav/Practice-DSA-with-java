package OnlinePlatform;

public class ComplementOFBAse10Integer1009 {
    public static int bitwiseComplement(int n) {
       String binary=Integer.toBinaryString(n);
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<binary.length();i++){
          char ch= binary.charAt(i);
          sb.append(ch=='0'?'1':'0');
      }
      int result=Integer.parseInt(sb.toString(),2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println( bitwiseComplement(2100));
    }
}
