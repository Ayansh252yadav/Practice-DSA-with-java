package OnlinePlatform;

import java.util.ArrayList;

public class PunishmentNumber2698 {
    public static void digit(int n,ArrayList<Integer>arr){
        while(n!=0){
            arr.add(n%10);
            n=n/10;
        }
    }
    public boolean isSum(int n,int temp){
        ArrayList<Integer>arr=new ArrayList<>();
        digit(n,arr);
        if(arr.size()==1){
            return true;
        }
        for(int i=0;i<arr.size();i++){
            int start=i;
            for(int j=i+1;j<arr.size();j++){
                int end=j;
                int sum=0;
                for(int k=start;k<=end;k++){
                    sum+=arr.get(k);
                }
                if(sum==temp){
                    return true;
                }
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int sum=0;
     for(int i=1;i<=n;i++){
         int temp=i*i;
      if(isSum(temp,i)){
          sum+=temp;
      }
     }
     return sum;
    }
}
