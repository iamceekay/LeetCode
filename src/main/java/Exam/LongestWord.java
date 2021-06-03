package Exam;

import java.util.PriorityQueue;

public class LongestWord {
    public static void main(String[] args) {

    }
    public String longestWord(String[] words) {
        PriorityQueue<String> pq= new PriorityQueue<>((a, b)->a.length()-b.length());
        for(String w:words)
            pq.add(w);
        System.out.println(pq);
        String start=pq.poll();
        int i=0;
        while(!pq.isEmpty() && i<words.length-1)
        {
            String s=pq.peek();
            int last=s.length();
            if(s.length()-start.length()==1)
            {
                if(start+s.charAt(last)==s)
                start=pq.poll();
            }
            i++;

        }
        return start;
    }
}
