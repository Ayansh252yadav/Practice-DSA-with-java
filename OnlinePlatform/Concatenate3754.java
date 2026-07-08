package OnlinePlatform;

public class Concatenate3754 {
    public static long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        int sum=0;
      for(char c:s.toCharArray()){
          if(c!='0'){
             sb.append(c);
             sum+=c-'0';
          }
      }
        Integer x=1;
      if(!sb.isEmpty()){
        x =Integer.parseInt(sb.toString());
      }
        return ((long) sum *x);
    }

    public static void main(String[] args) {
        System.out.println(sumAndMultiply(10203004));
    }
}
