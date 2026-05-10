package OnlinePlatform;

public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        boolean isUpper=true;
        boolean isLower=true;
        for(Character ch:word.toCharArray()){
            if(!Character.isLowerCase(ch)){
             isLower=false;
            }
        }
        if(isLower){
            return true;
        }
        for(Character ch:word.toCharArray()){
            if(!Character.isUpperCase(ch)){
                isUpper=false;
            }
        }
        if(isUpper){
            return true;
        }
       boolean firstChar=Character.isUpperCase(word.charAt(0));
        boolean midChar=true;
        for(int i=1;i<word.length();i++){
            if(!Character.isLowerCase(word.charAt(i))){
                midChar=false;
            }
        }
        return firstChar && midChar;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Google"));
    }
}
