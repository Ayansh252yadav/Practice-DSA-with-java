package OnlinePlatform;

public class ExcelSheetColumn168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
      while (columnNumber!=0){
       columnNumber-=1;
       int rem=columnNumber%26;
       sb.append((char)(65+rem));
       columnNumber/=26;
      }
      return sb.reverse().toString();
    }
    public static int titleToNumber(String columnTitle) {
        int res=0;
      for(Character s:columnTitle.toCharArray()){
          int value=s-'A'+1;
          res=res*26+value;
      }
      return res;
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(titleToNumber("ZY"));
    }
}
