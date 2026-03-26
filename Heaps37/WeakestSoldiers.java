package Heaps37;

import java.util.PriorityQueue;

public class WeakestSoldiers {
    static class Info implements Comparable<Info>{
        int soldiers;
        int idx;
        Info(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }
        @Override
        public int compareTo(Info st){
            if(this.soldiers==st.soldiers){
                return this.idx-st.idx;
            }else {
                return this.soldiers-st.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int [][]army={{1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}};
        int k=2;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        for (int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                count+=army[i][j]==1?1:0;
            }
            pq.add(new Info(count,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("row "+pq.remove().idx);
        }
    }
}
