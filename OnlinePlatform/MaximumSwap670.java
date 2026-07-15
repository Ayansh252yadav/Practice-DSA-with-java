package OnlinePlatform;

public class MaximumSwap670 {
    public static int maximumSwap(int num) {
        String s=String.valueOf(num);
    StringBuilder sb=new StringBuilder(s);
    for(int i=0;i<sb.length();i++){
       int idx=-1;
       char ch=sb.charAt(i);
        for(int j=i+1;j<sb.length();j++){
            if(ch<=sb.charAt(j)){
             idx=j;
             ch=sb.charAt(j);
            }
        }
        if(idx!=-1){
            char temp=sb.charAt(i);
            sb.setCharAt(i,sb.charAt(idx));
            sb.setCharAt(idx,temp);
            return  Integer.parseInt(sb.toString());
        }
  }
    return num;

    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }
}
