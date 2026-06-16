package OnlinePlatform;

import java.util.ArrayList;
import java.util.List;

public class ValidBinaryString3955 {
    public static boolean checkString(String str,int k){
        int count=0;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)=='1' && str.charAt(i+1)=='1'){
                return false;
            }
            else{
                if(str.charAt(i)=='1'){
                    count+=i;
                }
            }
        }
        if(str.charAt(str.length()-1)=='1'){
            count+=str.length()-1;
        }
        return count<=k;
    }
    public   List<String> generateValidStrings(int n, int k) {
   List<String>list=new ArrayList<>();
   int i=0;
        String binary=String.format("%" + n + "s",
                        Integer.toBinaryString(i))
                .replace(' ', '0');
        if(checkString(binary,k)){
            list.add(binary);
        }
     while(binary.length()==n){
         i++;
         binary = String.format("%" + n + "s",
                         Integer.toBinaryString(i))
                 .replace(' ', '0');
         if(checkString(binary,k)){
             list.add(binary);
         }
     }
     list.removeLast();
     return list;
    }
    public static void main(String[] args) {
        int num = 1;
        int k = 0;
        ValidBinaryString3955 vl=new ValidBinaryString3955();
        System.out.println(vl.generateValidStrings(num,k));
    }
}
