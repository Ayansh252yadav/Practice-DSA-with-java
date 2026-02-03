package QueueProblem;

public class CircularQueue {
    static class circularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        circularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        //add element;
        public static void add(int data) {
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //remove Element
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        //top element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

        public static void printQueue() {
            if (isEmpty()){
                System.out.println("Queue is empty nothing to print");
                return;
            }
            for(;front<=rear;front++){
                System.out.print(arr[front]+" ");
            }
        }
    }
    public static void main(String[] args) {
        circularQueue cq=new circularQueue(5);
//        cq.add(5);
//        cq.add(2);
//        cq.add(3);
        cq.printQueue();
    }
}
