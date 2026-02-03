package QueueProblem;

import java.util.Queue;

public class QueueUsingArray {
    static class simpleQueue {
        static int arr[];
        static int size;
        static int rear;

        simpleQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        //add element
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        //remove element
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        //top or peek element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

        public static void printQueue() {
          if(isEmpty()){
              System.out.println("Queue is empty");
              return;
          }

          for(int i=0;i<=rear;i++){
              System.out.print(arr[i]+" ");
          }
        }
    }
    public static void main(String[] args) {
        simpleQueue q=new simpleQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();
    }
}
