package OnlinePlatform;

import java.util.*;

public class FindWinnerOfAnArrayGame1535 {
    public static int getWinner(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(int e:arr){
            dq.offerLast(e);
        }
        int winCount=0;
        int currWinner=dq.peekFirst();

      while(winCount<k){
          int first =dq.removeFirst();
          int second = dq.removeFirst();
          if(first>second){
              dq.offerFirst(first);
              dq.offerLast(second);
              if(currWinner==first){
                  winCount++;
              }else{
                  currWinner=first;
                  winCount=1;
              }
          }
          else {
              dq.offerLast(first);
              dq.offerFirst(second);
              if(currWinner==second){
                  winCount++;
              }else{
                 currWinner=second;
                 winCount=1;
              }
          }
      }
      return currWinner;
    }

    public static void main(String[] args) {
        int []arr={2,1,3,5,4,6,7};
        int k=2;
        System.out.println(getWinner(arr,k));
    }
}

//2059