package Heaps37;
import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueue1 {
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        public Student(String name,int  rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student o) {
            return this.rank-o.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student>pq=new PriorityQueue();
        pq.add(new Student("Ayansh",2));

        while(!pq.isEmpty()){
            System.out.println(pq.remove().name);
        }
    }
}
