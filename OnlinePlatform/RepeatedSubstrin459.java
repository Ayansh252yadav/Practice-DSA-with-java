package OnlinePlatform;

public class RepeatedSubstrin459 {
    public static boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<s.length();i++){
        String temp=s.substring(0,i);
        temp=temp.repeat(s.length()/temp.length());
        if(temp.equals(s)){
            return true;
        }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern( "aba"));
    }
}
