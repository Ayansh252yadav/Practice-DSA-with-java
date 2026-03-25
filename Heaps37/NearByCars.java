package Heaps37;

import java.util.PriorityQueue;

public class NearByCars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int disSq;
        int idx;
        Point(int x,int y,int disSq,int idx){
            this.x=x;
            this.y=y;
            this.disSq=disSq;
            this.idx=idx;
        }
        public int compareTo(Point p){
            return this.disSq-p.disSq;
        }
    }

    public static void main(String[] args) {
        int [][]pts={{3,3},{5,-1},{2,4}};
        int k=2;
        PriorityQueue<Point>pq=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int disSq=pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0],pts[i][1],disSq,i));
        }
        for(int i=0;i<k;i++){
            System.out.println("car "+pq.peek().idx);
            pq.remove();
        }
    }
}
