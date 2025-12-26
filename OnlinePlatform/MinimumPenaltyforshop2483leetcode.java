package OnlinePlatform;

import java.util.Arrays;

public class MinimumPenaltyforshop2483leetcode {
    public static int bestClosingTime(String customer){

        int n=customer.length();
        int penalty;
        int temp[]=new int[n+1];
        int j=0;
        while (j<=n){
            penalty=0;
            for(int i=0;i<n;i++){
                if(i<j && customer.charAt(i)=='N'){
                    penalty+=1;
                } else if (i>=j && customer.charAt(i)=='Y') {
                    penalty=penalty+1;
                }
            }

            temp[j]=penalty;
            j++;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            min=Math.min(temp[i],min);
        }
        int k=0;
        while (k<=n){
            if(temp[k]==min){
                return k;
            }
            k++;
        }
        return k;
    }
    public static int bestClosingTime2(String customer) {

        int n = customer.length();

        // Step 1: penalty when closing at hour 0
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customer.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Step 2: shift closing time from 1 to n
        for (int i = 0; i < n; i++) {
            if (customer.charAt(i) == 'Y') {
                penalty--; //shop open and customer come
            } else {
                penalty++;   // shop open but no customer
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }


    public static void main(String[] args) {
        String str="NNNNN";
        System.out.println(bestClosingTime(str));
    }
}
