package QueueProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueElement {
    public static void reverseKelement(Queue<Integer>q){
        Stack<Integer>s=new Stack<>();
        Queue<Integer>q2=new LinkedList<>();
        int n=q.size()/2;
        for(int i=0;i<n;i++){
            s.push(q.poll());
        }
        int m=s.size();
        for(int i=0;i<m;i++){
            q2.add(s.pop());
        }
        int t=q.size();
        for(int j=0;j<t;j++){
            q2.add(q.poll());
        }
        System.out.println(q2);
    }

    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60,70,80,90,100};
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        reverseKelement(q);
    }
}
