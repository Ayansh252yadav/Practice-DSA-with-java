package CoderArmy;

public class StringMatching {
    public static int match(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        for(int i=0;i<=n-m;i++){
           int first=i;
           int  second=0;
            while(second<m){
                if(str1.charAt(first)!=str2.charAt(second)){
                    break;
                }else{
                    first++;
                    second++;
                }
            }
            if(second==m){
                return first-second;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(match("abcabdefg","def"));
    }
}
