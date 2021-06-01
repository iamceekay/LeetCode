package Exam.Amazon;

import java.util.PriorityQueue;

public class mergeFiles {
    public static void main(String[] args) {
        int[] files1 = {1, 2, 5, 10, 35, 89};
        System.out.println(mergeFilesMethod(files1));
    }

    private static int mergeFilesMethod(int[] file) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int res=0;
        for(int f:file)
            pq.add(f);
        while(pq.size()>1)
        {
            int p=pq.poll();
            int q=pq.poll();
            pq.add(p+q);
            res+=p+q;
        }
        return res;
    }
}
