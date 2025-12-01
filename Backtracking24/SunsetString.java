package Backtracking24;
public class SunsetString {
    public static void subset(String str, int i,String newStr){
        if(i==str.length()){
            if(newStr.length()==0){
                System.out.print("null");
            }else{
                System.out.println(newStr);
            }

            return ;
        }

        subset(str,i+1,newStr+str.charAt(i));
        subset(str,i+1,newStr);
    }

    public static void main(String[] args) {
        subset("abc",0,"");
    }
}
