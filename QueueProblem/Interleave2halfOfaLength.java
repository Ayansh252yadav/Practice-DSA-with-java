package QueueProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Interleave2halfOfaLength extends QueueUsingArray {
    public static void interLeave(Queue<Integer>q){
        Queue<Integer>firstHalf=new LinkedList<>();
        int n=q.size();
        for(int i=0;i<n/2;i++){
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer>q= new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
       interLeave(q);
        System.out.println(q);
    }
}
