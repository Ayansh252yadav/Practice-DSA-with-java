package Backtracking24;

public class FindSubset {
    public static void findsubset(String str,String ans,int i){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        findsubset(str,ans+str.charAt(i),i+1);
        findsubset(str,ans,i+1);
    }

    public static void main(String[] args) {
        findsubset("abc","",0);
    }
}
