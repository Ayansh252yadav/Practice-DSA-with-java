package OnlinePlatform;

public class FindValidPair3438 {
    public static String findValidPair(String s) {
   int []freq=new int[10];
   for(int i=0;i<s.length();i++){
       freq[s.charAt(i)-'0']++;
   }
   String res="";
   for(int i=0;i<s.length()-1;i++){
       int firstDigit=s.charAt(i)-'0';
       int secondDigit=s.charAt(i+1)-'0';
       if(firstDigit!=secondDigit && freq[firstDigit]==firstDigit
         && freq[secondDigit]==secondDigit){
           res+=firstDigit;
           res+=secondDigit;
           return res;
       }
   }
   return "";
    }

    public static void main(String[] args) {
        System.out.println(findValidPair("2523533"));
    }
}
