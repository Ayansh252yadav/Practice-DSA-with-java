package Heaps37;

import java.util.PriorityQueue;

public class ConnectNRopes {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int []ropes={4,3,2,6};
        for(int r:ropes){
            pq.add(r);
        }
        int cost=0;
        while (pq.size() > 1){
            int min1=pq.remove();
            int min2=pq.remove();
            cost+=min2+min1;
            pq.add(min1+min2);
        }
        System.out.println(cost);
    }
}
