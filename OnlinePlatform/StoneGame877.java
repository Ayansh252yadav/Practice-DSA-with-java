package OnlinePlatform;

import java.util.ArrayList;

public class StoneGame877 {
    public static boolean predictTheWinner(int[] nums) {
        if(nums.length%2==0){
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        long player1=0;
        long player2=0;
        int t=0;
        int p=0;
        while(!list.isEmpty()){
            t=(Math.max(list.getFirst(), list.getLast()));
            if(t==list.getFirst()){
                list.removeFirst();
            } else  {
              list.removeLast();
            }
           if(!list.isEmpty()){
               player1=player1+t;
               p=(Math.min(list.getFirst(), list.getLast()));
               if(p==list.getFirst()){
                   list.removeFirst();
               }else   {
                   list.removeLast();
               }
               player2=player2+p;
           }
        }
        if(player1>=player2){
            return true;
        }
        return false;
    }
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i=0;i<s.length()-1;i++){
            int first=s.charAt(i)-'0';
            int second=s.charAt(i+1)-'0';
            if(Math.abs(first-second)>2){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
   int []nums={1,5,2};

   System.out.println(predictTheWinner(nums));
    }
}
