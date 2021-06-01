package Concurrency;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFounder {
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }

    public static void main(String[] args) {
        MedianFounder med=new MedianFounder();
        med.addNum(1);
        med.addNum(3);
        System.out.println(med.findMedian());
        med.addNum(5);
        System.out.println(med.findMedian());
        med.addNum(4);
        med.addNum(5);
        System.out.println(med.findMedian());

    }
}
