package OnlinePlatform;

import java.util.HashMap;
import java.util.Map;

public class ConvertDecimalToHexaDecimal405 {
    public static String toHex(int num) {
Map<Integer,Character>map=new HashMap<>();
map.put(10,'a');
map.put(11,'b');
map.put(12,'c');
map.put(13,'d');
map.put(14,'e');
map.put(15,'f');
     int temp=num;
     int qu=0;
     int n=0;
    StringBuilder hexNum=new StringBuilder();
     while(temp!=0){
         int rem=temp%16;
             if(map.containsKey(rem)){
              hexNum.append(map.get(rem));
         }else{
             hexNum.append(rem);
         }
         temp=temp/16;
     }
     return hexNum.reverse().toString();
    }

public static String toHex2(int num){
        if(num==0){
            return "0";
        }
        char []hexChar="0123456789abcdef".toCharArray();
        StringBuilder res=new StringBuilder();
        while (num!=0){
            int rem=num & 15;
            res.append(hexChar[rem]);
            num>>>=4;
        }
        return res.toString();
}
    public static void main(String[] args) {
        System.out.println(toHex2(-1));

    }
}
