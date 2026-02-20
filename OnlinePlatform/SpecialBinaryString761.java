package OnlinePlatform;

import java.util.ArrayList;
import java.util.Collections;

public class SpecialBinaryString761 {
    public static ArrayList<String> substring(String str){
        ArrayList<String>res=new ArrayList<>();
      for(int i=0;i<str.length();i++){
          for(int j=i+1;j<=str.length();j++){
            res.add(str.substring(i,j)) ;
          }
      }

      for(int i=res.size()-1;i>=0;i--){
          String temp=res.get(i);
          int count=0;
          boolean valid = true;
          for(int j=0;j<temp.length();j++){
              if(temp.charAt(j)=='1'){
                  count++;
              }else{
                  count--;
              }
              if(count < 0){  // prefix condition
                  valid = false;
                  break;
              }
          }

          if(count != 0 || !valid || temp.equals(str)){
              res.remove(i);
          }
      }

      return res;
    }

    public static void main(String[] args) {
        System.out.println(substring("11011000"));
    }
}
