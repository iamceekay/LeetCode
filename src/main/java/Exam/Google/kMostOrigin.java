package Exam.Google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kMostOrigin {
    public static void main(String[] args) {
            int[][] points={{3,3},{5,-1},{-2,4}};
            int k=2;
        System.out.println(Arrays.deepToString(kMostOrigin(points, k)));
    }

    private static int[][] kMostOrigin(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>((a,b)->b.x*b.x +b.y*b.y -a.x*a.x-a.y*a.y);
        for(int[] p:points)
        {
            Point point=new Point(p[0],p[1]);
            pq.offer(point);
            if(pq.size()>k) pq.poll();
        }
        int[][] result=new int[k][2];
        while(k-->0)
        {
            Point p=pq.poll();
            result[k][0]=p.x;
            result[k][1]=p.y;
           // System.out.println(pq.poll().toString());
        }
        return result;
    }

   static class Point
    {
        Integer x;
        Integer y;
        Point(int x,int y)
        {
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
