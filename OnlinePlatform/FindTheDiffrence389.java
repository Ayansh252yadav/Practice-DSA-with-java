package OnlinePlatform;

public class FindTheDiffrence389 {
    public static char findTheDifference(String s, String t) {
      long tSum=0;
      long sSum=0;
      for(char ch:s.toCharArray()){
          sSum+=(int)(ch);
      }
      for(char ch:t.toCharArray()){
          tSum+=(int)(ch);
      }
      return (char)(Math.abs(tSum-sSum));
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("a","aa"));
    }
}
