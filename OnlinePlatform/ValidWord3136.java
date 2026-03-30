package OnlinePlatform;

public class ValidWord3136 {
    public static boolean isValid(String word) {
      if(word.length()<3){
          return false;
      }
 boolean hasVowel=false;
      boolean hasConsonant=false;
      for(char ch:word.toCharArray()){
           if(!Character.isLetterOrDigit(ch)){
               return false;
           }
           if(Character.isLetter(ch)){
               if("aeiouAEIOU".indexOf(ch)!=-1){
                   hasVowel = true;
               } else {
                   hasConsonant = true;
               }
           }
      }
      return hasConsonant&&hasVowel;
    }

    public static void main(String[] args) {
        System.out.println(isValid("234Adas"));
    }
}
