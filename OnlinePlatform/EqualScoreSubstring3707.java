package OnlinePlatform;

public class EqualScoreSubstring3707 {
    public static boolean scoreBalance(String s) {
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            right+=s.charAt(i)-'a';
        }
      for(int i = 0; i < s.length()-1; i++){
         left+=s.charAt(i)-'a';
         right-=s.charAt(i)-'a';
         if(left==right){
             return true;
         }
      }
        System.out.println(left+" "+right);
      return false;
    }

    public static void main(String[] args) {
   scoreBalance("abcd");
    }
}
