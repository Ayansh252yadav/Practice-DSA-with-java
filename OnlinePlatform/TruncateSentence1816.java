package OnlinePlatform;

public class TruncateSentence1816 {
    public  static String truncateSentence(String s, int k) {
      String []str=s.split(" ");
      StringBuilder sb=new StringBuilder();
      for(int i=0;i<k;i++){
        sb.append(str[i]+" ");
      }
      return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s,k));
    }
}
